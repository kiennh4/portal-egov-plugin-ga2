package com.bkav.portal.portlet.audioplayer.admin;

import java.io.InputStream;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;
import com.bkav.portal.portlet.audioplayer.model.AudioAlbum;
import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.permission.AudioPermission;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil;
import com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil;
import com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil;
import com.bkav.portal.portlet.audioplayer.util.AudioUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AudioAdmin
 */
public class AudioAdmin extends MVCPortlet {

	public void updateAlbum(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			long fileAttachmentId = 0L;

			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AudioAlbum.class.getName(), actionRequest);

			long albumId = ParamUtil.getLong(uploadRequest, "albumId", 0L);

			String albumName = ParamUtil.getString(uploadRequest, "albumName");

			String albumInfo = ParamUtil.getString(uploadRequest, "albumInfo");

			long albumCoverId = ParamUtil.getLong(uploadRequest,
					"albumCoverId", CounterLocalServiceUtil.increment());

			long[] listAlbumSelected = ParamUtil.getLongValues(uploadRequest,
					"listAudioSelected");

			String[] selectedFileNames = ParamUtil.getParameterValues(
					uploadRequest, "selectedFileName", new String[0]);

			InputStream albumCoverStream = uploadRequest
					.getFileAsStream("albumCoverFile");

			long viewCounter = 0;

			if (albumCoverStream != null) {

				if (albumId > 0) {

					AudioAlbum album = AudioAlbumLocalServiceUtil
							.getAudioAlbum(albumId);

					if ((album != null) && (album.getAlbumCoverId() > 0)) {

						albumCoverId = album.getAlbumCoverId();

					}
				}

				AudioUtil.uploadAlbumCover(albumCoverId, albumCoverStream);

			}

			String redirectURL = ParamUtil.getString(uploadRequest,
					"redirectURL");

			if (albumId > 0) {// Update banner

				AudioAlbum album = AudioAlbumLocalServiceUtil
						.getAudioAlbum(albumId);
				viewCounter = album.getViewCounter();

				AudioAlbumLocalServiceUtil.updateAudioAlbum(albumName,
						albumInfo, albumCoverId, viewCounter, albumId);

				AlbumAudioMapLocalServiceUtil
						.deleteAlbumAudioMapByAlbumId(albumId);

				for (int i = 0; i < listAlbumSelected.length; i++) {
					AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(
							listAlbumSelected[i], albumId);
				}

				for (String selectedFileName : selectedFileNames) {

					fileAttachmentId = AudioUtil.uploadAudioFiles(
							actionRequest, actionResponse, selectedFileName);
					String audioType = MimeTypesUtil
							.getContentType(selectedFileName);
					String audioInfo = "";

					if (fileAttachmentId > 0) {

						serviceContext
								.setGroupPermissions(new String[] { AudioPermission.VIEW });
						serviceContext
								.setGuestPermissions(new String[] { AudioPermission.VIEW });

						AudioFile audio = AudioFileLocalServiceUtil
								.addAudioFile(companyId, groupId, userId,
										userName, selectedFileName, audioInfo,
										fileAttachmentId, 0, audioType,
										serviceContext);

						if (album.getAlbumId() > 0L)
							AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(
									audio.getAudioId(), album.getAlbumId());
					}
				}

			} else {

				serviceContext
						.setGroupPermissions(new String[] { AudioPermission.VIEW });
				serviceContext
						.setGuestPermissions(new String[] { AudioPermission.VIEW });

				AudioAlbum newAlbum = AudioAlbumLocalServiceUtil.addAudioAlbum(
						companyId, groupId, userId, userName, albumName,
						albumInfo, albumCoverId, viewCounter, serviceContext);

				for (int i = 0; i < listAlbumSelected.length; i++)
					AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(
							listAlbumSelected[i], newAlbum.getAlbumId());

				for (String selectedFileName : selectedFileNames) {

					fileAttachmentId = AudioUtil.uploadAudioFiles(
							actionRequest, actionResponse, selectedFileName);
					String audioType = MimeTypesUtil
							.getContentType(selectedFileName);
					String audioInfo = "";

					if (fileAttachmentId > 0) {

						serviceContext
								.setGroupPermissions(new String[] { AudioPermission.VIEW });
						serviceContext
								.setGuestPermissions(new String[] { AudioPermission.VIEW });

						AudioFile audio = AudioFileLocalServiceUtil
								.addAudioFile(companyId, groupId, userId,
										userName, selectedFileName, audioInfo,
										fileAttachmentId, 0, audioType,
										serviceContext);

						if (newAlbum.getAlbumId() > 0L)
							AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(
									audio.getAudioId(), newAlbum.getAlbumId());
					}
				}

			}

			SessionMessages.add(actionRequest, "album-saved-successfully");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			// _log.error(e);
			e.printStackTrace();
			SessionErrors.add(actionRequest, "save-failed");
		}
	}

	public void addAudio(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		long fileAttachmentId = 0L;

		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			String audioInfo = "";

			long albumId = 0L;

			if (Validator.isNotNull(ParamUtil.getLong(actionRequest,
					"albumSelected")))
				albumId = ParamUtil.getLong(actionRequest, "albumSelected");

			String[] selectedFileNames = ParamUtil.getParameterValues(
					actionRequest, "selectedFileName", new String[0]);

			if (albumId > 0L) {
				long[] selectedExistAudio = ParamUtil.getLongValues(
						actionRequest, "listAudioSelected");
				if ((Validator.isNotNull(selectedExistAudio))
						&& (selectedExistAudio.length > 0))
					for (int i = 0; i < selectedExistAudio.length; i++) {
						AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(
								selectedExistAudio[i], albumId);
					}
			}

			for (String selectedFileName : selectedFileNames) {

				fileAttachmentId = AudioUtil.uploadAudioFiles(actionRequest,
						actionResponse, selectedFileName);
				String audioType = MimeTypesUtil
						.getContentType(selectedFileName);

				if (fileAttachmentId > 0) {

					ServiceContext serviceContext = ServiceContextFactory
							.getInstance(AudioAlbum.class.getName(),
									actionRequest);

					serviceContext
							.setGroupPermissions(new String[] { AudioPermission.VIEW });
					serviceContext
							.setGuestPermissions(new String[] { AudioPermission.VIEW });

					AudioFile audio = AudioFileLocalServiceUtil.addAudioFile(
							companyId, groupId, userId, userName,
							selectedFileName, audioInfo, fileAttachmentId, 0,
							audioType, serviceContext);

					if (albumId > 0L)
						AlbumAudioMapLocalServiceUtil.addAlbumAudioMap(
								audio.getAudioId(), albumId);
				}
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			SessionMessages.add(actionRequest, "audio-saved-successfully");

			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "save-failed");
		}
	}

	public void updateAudioSettings(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest);

			long audioFolderId = ParamUtil.getLong(actionRequest,
					"audioFolderId");

			String[] audioExtensions = StringUtil.split(
					ParamUtil.getString(actionRequest, "audioExtensions"),
					StringPool.COMMA);

			String audioMaxSize = ParamUtil.getString(actionRequest,
					"audioMaxSize");

			String[] imageCoverExtensions = StringUtil.split(ParamUtil
					.getString(actionRequest, "imageThumbnailExtensions"),
					StringPool.COMMA);

			String imageCoverMaxSize = ParamUtil.getString(actionRequest,
					"imageCoverMaxSize");

			preferences
					.setValue("audioFolderId", String.valueOf(audioFolderId));
			preferences.setValues("audioExtensions", audioExtensions);
			preferences.setValue("audioMaxSize", audioMaxSize);
			preferences.setValues("imageCoverExtensions", imageCoverExtensions);
			preferences.setValue("imageCoverMaxSize", imageCoverMaxSize);

			preferences.store();

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				_log.error(e);
			}
		}
	}

	public void addAudioFolder(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long parentFolderId = ParamUtil.getLong(actionRequest,
					"parentFolderId");

			String audioFolderName = ParamUtil.getString(actionRequest,
					"audioFolderName");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFolder.class.getName(), actionRequest);

			serviceContext
					.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext
					.setGuestPermissions(new String[] { ActionKeys.VIEW });

			DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false,
					parentFolderId, audioFolderName, StringPool.BLANK,
					serviceContext);

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				_log.error(e);
			}
		}
	}

	public static void addTempAudioFile(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		InputStream inputStream = null;

		try {

			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			long folderId = ParamUtil.getLong(actionRequest, "folderId", 0);

			String sourceFileName = uploadRequest.getFileName("file")
					.replaceAll(StringPool.COMMA, StringPool.BLANK);

			_log.info(sourceFileName);

			inputStream = uploadRequest.getFileAsStream("file");

			if (inputStream != null) {

				DLAppServiceUtil.addTempFileEntry(
						themeDisplay.getScopeGroupId(), folderId,
						sourceFileName, _TEMP_FOLDER_NAME, inputStream);
			}

		} catch (Exception e) {
			_log.error(e);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	public static void deleteTempAudioFile(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		String fileName = ParamUtil.getString(actionRequest, "fileName");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {

			DLAppServiceUtil.deleteTempFileEntry(
					themeDisplay.getScopeGroupId(), folderId, fileName,
					_TEMP_FOLDER_NAME);

			jsonObject.put("deleted", Boolean.TRUE);
		} catch (PortalException e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
					"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
		}

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}

	public void removeAudioFromAlbum(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {

			long albumId = ParamUtil.getLong(actionRequest, "albumId");

			long audioId = ParamUtil.getLong(actionRequest, "audioId");

			if (albumId > 0) {
				AudioAlbum album = AudioAlbumLocalServiceUtil
						.getAudioAlbum(albumId);

				if (audioId > 0) {
					AudioFile audio = AudioFileLocalServiceUtil
							.getAudioFile(audioId);
					List<AlbumAudioMap> aamList = AlbumAudioMapLocalServiceUtil
							.findByAlbumAudio(album.getAlbumId(),
									audio.getAudioId());

					for (int i = 0; i < aamList.size(); i++) {
						AlbumAudioMap aam = aamList.get(i);
						AlbumAudioMapLocalServiceUtil.deleteAlbumAudioMap(aam
								.getMapId());
					}
				}

			}
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteAlbum(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long albumId = ParamUtil.getLong(actionRequest, "albumId");

			if (albumId > 0) {

				AudioAlbum album = AudioAlbumLocalServiceUtil
						.getAudioAlbum(albumId);

				if (album != null && album.getAlbumCoverId() > 0L) {

					ImageLocalServiceUtil.deleteImage(album.getAlbumCoverId());

				}

				AlbumAudioMapLocalServiceUtil
						.deleteAlbumAudioMapByAlbumId(albumId);

				AudioAlbumLocalServiceUtil.deleteAudioAlbum(albumId);
			}
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteAudio(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		try {

			long audioId = ParamUtil.getLong(actionRequest, "audioId");

			if (audioId > 0) {

				AudioFile audio = AudioFileLocalServiceUtil
						.getAudioFile(audioId);

				if (audio != null && audio.getAudioFileId() > 0L) {

					DLAppServiceUtil.deleteFileEntry(audio.getAudioFileId());

				}

				AlbumAudioMapLocalServiceUtil
						.deleteAlbumAudioMapByAudioId(audioId);

				AudioFileLocalServiceUtil.deleteAudioFile(audioId);
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static final String _TEMP_FOLDER_NAME = AudioAdmin.class.getName();
	private static Log _log = LogFactory.getLog(AudioAdmin.class);

}
