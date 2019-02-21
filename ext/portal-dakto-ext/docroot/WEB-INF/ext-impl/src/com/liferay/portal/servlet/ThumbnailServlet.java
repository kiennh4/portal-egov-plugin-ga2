
package com.liferay.portal.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.liferay.portal.image.Image;
import com.liferay.portal.image.ImageLoader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;

public class ThumbnailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config)
		throws ServletException {

		super.init(config);

		_width = GetterUtil.getInteger(config.getInitParameter("width"));
		_height = GetterUtil.getInteger(config.getInitParameter("height"));

		if (Validator.isNotNull(PropsValues.STATIC_CACHE_DIR)) {
			_THUMBNAIL_IMAGE_ROOT_PATH = PropsValues.STATIC_CACHE_DIR.concat(_THUMBNAIL_FILTER_PATH);
		}

		if (!FileUtil.exists(_THUMBNAIL_IMAGE_ROOT_PATH)) {
			FileUtil.mkdirs(_THUMBNAIL_IMAGE_ROOT_PATH);
		}
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		String thumbnailURL = HttpUtil.removeDomain(request.getRequestURI());

		if (isValidThumbnailURL(thumbnailURL)) {

			try {

				String thumbnailFilePath = getThumbnailFilePath(thumbnailURL);

				File thumbnailFile = new File(thumbnailFilePath);

				if (thumbnailFile.exists() && thumbnailFile.isFile()) {
					sendContentFile(thumbnailFile, request, response);
				}
				else {

					long imageId = GetterUtil.getLong(FilenameUtils.getBaseName(thumbnailFile.getName()));

					if (imageId > 0) {

						byte[] sourceImageBytes = getImageBytes(imageId);

						if (sourceImageBytes != null && sourceImageBytes.length > 0) {

							File thumbnailFolder = new File(thumbnailFile.getParent());

							if (!thumbnailFolder.exists() || !thumbnailFolder.isDirectory()) {

								thumbnailFolder.mkdirs();
							}

							Image image = ImageLoader.fromBytes(sourceImageBytes);

							int[] thumbnailDimension = getThumbnailDimension(image);

							int thumbnailWidth = 0;
							int thumbnailHeight = 0;

							if (thumbnailDimension != null) {
								thumbnailWidth = thumbnailDimension[0];
								thumbnailHeight = thumbnailDimension[1];
							}

							if (image != null && thumbnailWidth > 0 && thumbnailHeight > 0) {

								image = image.getImageResized(thumbnailWidth, thumbnailHeight);

								String imageType = getImageType(imageId);

								if (imageType.toLowerCase().contains(ContentTypes.IMAGE_JPEG)) {
									image.soften(_THUMBNAIL_IMAGE_SOFTEN).writeToJPG(
										thumbnailFile, _THUMBNAIL_IMAGE_QUALITY);
								}
								else {
									image.soften(_THUMBNAIL_IMAGE_SOFTEN).writeToFile(thumbnailFile);
								}
							}
							else {

								FileUtil.write(thumbnailFile, sourceImageBytes);
							}

							sendContentFile(thumbnailFile, request, response);
						}
						else {
							sendContentFile(new File(_DEFAULT_THUMBNAIL_IMAGE_PATH), request, response);

						}
					}
					else {

						sendContentFile(new File(_DEFAULT_THUMBNAIL_IMAGE_PATH), request, response);
					}
				}
			}
			catch (Exception e) {
				sendContentFile(new File(_DEFAULT_THUMBNAIL_IMAGE_PATH), request, response);
			}
		}
	}

	protected void sendContentFile(File file, HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		if (file.exists() && file.isFile()) {

			FileInputStream in = null;

			try {

				String contentType = MimeTypesUtil.getContentType(file);

				if (contentType == null) {
					contentType = ContentTypes.IMAGE_JPEG;
				}

				String fileName = file.getName();
				byte[] bytes = new byte[(int) file.length()];

				in = new FileInputStream(file);
				in.read(bytes);
				response.setContentType(contentType);

				if (Validator.isNotNull(fileName)) {
					ServletResponseUtil.sendFile(request, response, fileName, bytes, contentType);
				}
				else {
					ServletResponseUtil.write(response, bytes);
				}
			}
			finally {
				in.close();
			}
		}
	}

	protected String getThumbnailFilePath(String thumbnailURL) {

		String thumbnailFilePath = "";

		// thumbnailURL = /thumbnail/140x90/12/34/56/123456.jpg
		if (isValidThumbnailURL(thumbnailURL)) {

			// remove "/thumbnail/" from url -> thumbnailFilePath =
			// 140x90/12/34/56/123456.jpg
			thumbnailFilePath = StringUtil.replace(thumbnailURL, _THUMBNAIL_FILTER_PATH, StringPool.BLANK);

			// append image root path on server
			// -> thumbnailFilePath =
			// /home/hungdx/workspace/portal-egov-ga2/thumbnail-images/140x90/12/34/56/123456.jpg
			thumbnailFilePath = _THUMBNAIL_IMAGE_ROOT_PATH + thumbnailFilePath;
		}

		return thumbnailFilePath;
	}

	protected int[] getThumbnailDimension(Image image) {

		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		int newWidth = _height * imageWidth / imageHeight;
		int newHeight = _width * imageHeight / imageWidth;

		int[] thumbnailDimension = new int[2];

		if (imageWidth > _width) {
			newWidth = _width;
		}

		if (newHeight < _height) {
			newHeight = _height;
			newWidth = _height * imageWidth / imageHeight;
		}

		if (newHeight < _height || newWidth < _width) {
			return null;
		}

		thumbnailDimension[0] = newWidth;
		thumbnailDimension[1] = newHeight;

		return thumbnailDimension;
	}

	protected String getImageType(long imageId) {

		String imageType = "";

		try {

			com.liferay.portal.model.Image sourceImage = ImageLocalServiceUtil.getImage(imageId);

			if (sourceImage != null) {
				imageType = sourceImage.getType();
			}
			else {

				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(imageId);

				if (dlFileEntry != null) {
					imageType = dlFileEntry.getExtension();
				}
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchFileException || e instanceof FileNotFoundException) {
				if (_log.isWarnEnabled()) {
					_log.warn("Error reading image " + imageId, e);
				}
			}
			else {
				_log.error(e);
			}
		}
		return imageType;
	}

	protected byte[] getImageBytes(long imageId)
		throws IOException {

		InputStream is = null;
		byte[] sourceImageBytes = null;

		try {

			com.liferay.portal.model.Image sourceImage = ImageLocalServiceUtil.getImage(imageId);

			if (sourceImage != null) {

				is =
					DLStoreUtil.getFileAsStream(_DEFAULT_COMPANY_ID, _DEFAULT_REPOSITORY_ID, imageId +
						StringPool.PERIOD + getImageType(imageId));

			}
			else {

				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(imageId);

				if (dlFileEntry != null) {

					is =
						DLStoreUtil.getFileAsStream(
							dlFileEntry.getCompanyId(), dlFileEntry.getDataRepositoryId(), dlFileEntry.getName());

				}
			}

			if (is != null) {
				sourceImageBytes = FileUtil.getBytes(is);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchFileException || e instanceof FileNotFoundException) {
				if (_log.isWarnEnabled()) {
					_log.warn("Error reading image " + imageId, e);
				}
			}
			else {
				_log.error(e);
			}
		}
		finally {
			is.close();
		}

		return sourceImageBytes;
	}

	protected boolean isValidThumbnailURL(String thumbnailURL) {

		return thumbnailURL.contains(_THUMBNAIL_FILTER_PATH);
	}

	private int _width;
	private int _height;

	private static Log _log = LogFactoryUtil.getLog(ThumbnailServlet.class);

	private static final long _DEFAULT_COMPANY_ID = 0;

	private static final long _DEFAULT_REPOSITORY_ID = 0;

	private static final float _THUMBNAIL_IMAGE_SOFTEN = 0.08f;

	private static final float _THUMBNAIL_IMAGE_QUALITY = 1.0f;

	private static final String _THUMBNAIL_FILTER_PATH = "/thumbnail/";

	private static String _THUMBNAIL_IMAGE_ROOT_PATH =
		PropsValues.LIFERAY_HOME.concat("/data" + _THUMBNAIL_FILTER_PATH);

	private static final String _DEFAULT_THUMBNAIL_IMAGE_PATH = _THUMBNAIL_IMAGE_ROOT_PATH.concat("/default-image.jpg");
}
