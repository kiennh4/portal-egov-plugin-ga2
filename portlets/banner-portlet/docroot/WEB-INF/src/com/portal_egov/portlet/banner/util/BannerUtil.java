/**
 * @author HUNGDX
 * @time 9:16:08 AM
 * @project banner-portlet
 */

package com.portal_egov.portlet.banner.util;

import java.awt.image.RenderedImage;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;

public class BannerUtil {

	public static final int ACTIVE_BANNER_STATUS = 1;
	public static final int DEACTIVE_BANNER_STATUS = 0;
	public static final int BANNER_START_VIEW_COUNT = 0;

	public static String getBannerImagePath(HttpServletRequest request, long bannerImageId) {

		try {

			String bannerImagePath = "";

			Image bannerImage = ImageLocalServiceUtil.fetchImage(bannerImageId);

			if (bannerImage != null) {

//				String bannerImageIdStr = String.valueOf(bannerImageId);
//
//				String[] bannerImageIdStrSplitedArr = bannerImageIdStr.split("(?<=\\G.{2})");
//
//				StringBuilder stringBuilder = new StringBuilder();
//
//				stringBuilder.append(_THUMBNAIL_FILTER_PATH);
//
//				for (int i = 0; i < bannerImageIdStrSplitedArr.length; i++) {
//
//					stringBuilder.append(bannerImageIdStrSplitedArr[i]);
//					stringBuilder.append(StringPool.SLASH);
//				}
//
//				stringBuilder.append(bannerImageId + "." + bannerImage.getType());
//
//				bannerImagePath = stringBuilder.toString();

				 ThemeDisplay themeDisplay = (ThemeDisplay)
				 request.getAttribute(WebKeys.THEME_DISPLAY);
				
				 bannerImagePath = themeDisplay.getPathImage() +
				 "/logo?img_id=" + bannerImageId
				 + "&t" + WebServerServletTokenUtil.getToken(bannerImageId);
			}

			return bannerImagePath;
		}
		catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}

	public static void uploadBannerImage(long bannerImageId, InputStream bannerImageStream)
		throws Exception {

		if (bannerImageStream != null) {

			byte[] bannerImageBytes = FileUtil.getBytes(bannerImageStream);

			long uploadServletMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);

			if ((uploadServletMaxSize > 0) &&
				((bannerImageBytes == null) || (bannerImageBytes.length > uploadServletMaxSize))) {

				throw new ImageSizeException();
			}

			ImageBag imageBag = ImageToolUtil.read(bannerImageBytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new ImageTypeException();
			}

			String contentType = imageBag.getType();

			byte[] bannerImagesBytes = ImageToolUtil.getBytes(renderedImage, contentType);

			ImageLocalServiceUtil.updateImage(bannerImageId, bannerImagesBytes);
		}
	}

	private static Log _log = LogFactory.getLog(BannerUtil.class);

	private static final String _THUMBNAIL_FILTER_PATH = "/thumbnail/";
}
