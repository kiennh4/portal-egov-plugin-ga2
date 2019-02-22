
package com.bkav.portal.portlet.video;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.apache.commons.validator.routines.UrlValidator;

import com.bkav.portal.portlet.video.model.VideoCategory;
import com.bkav.portal.portlet.video.model.VideoCategoryMap;
import com.bkav.portal.portlet.video.model.VideoEntry;
import com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil;
import com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil;
import com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil;
import com.bkav.portal.portlet.video.util.MemcachedUtil;
import com.bkav.portal.portlet.video.util.VideoConstants;
import com.bkav.portal.portlet.video.util.VideoFileUtil;
import com.bkav.portal.portlet.video.util.VideoPlayerUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoAdmin
 */
public class VideoAdmin extends MVCPortlet {
	
	public void updateVideoCategory (ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException { 
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
			
			String categoryName = ParamUtil.getString(actionRequest, "categoryName");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if (Validator.isNotNull(categoryId))
			{
				ServiceContext serviceContext =
						ServiceContextFactory.getInstance(VideoCategory.class.getName(), actionRequest);
				
				VideoCategory videoCate = null;
				
				if (categoryId>0)
				{
					videoCate = VideoCategoryLocalServiceUtil.getVideoCategory(categoryId);
				}
				
				if (Validator.isNotNull(videoCate))
				{
					
					VideoCategoryLocalServiceUtil.updateVideoCategory(categoryId,companyId, groupId, userId, userName, categoryName, serviceContext);
					
					String memcachedKey = VideoPlayerUtil.buildCacheQueryKey(categoryId);
					
					MemcachedUtil.getInstance().delete(memcachedKey);
				}
			}
			else
			{
				ServiceContext serviceContext =
						ServiceContextFactory.getInstance(VideoCategory.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {
						ActionKeys.VIEW
					});
					serviceContext.setGuestPermissions(new String[] {
						ActionKeys.VIEW
					});
				
				VideoCategoryLocalServiceUtil.addVideoCategory(companyId, groupId, userId, userName, categoryName, serviceContext);
				
			}
			
			SessionMessages.add(actionRequest, "category-saved-successfully");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
			
		}
		catch (Exception e) {
			if (e instanceof VideoFileTypeException || e instanceof VideoFileSizeException ||
				e instanceof ThumbnailImageFileTypeException || e instanceof ThumbnailImageFileSizeException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				_log.error(e);
			}
			
			SessionErrors.add(actionRequest, "save-failed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
		finally {
			
		}
		
	}
	
	public void updateVideo(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		InputStream videoFileStream = null;
		InputStream thumbnailImageStream = null;

		try {

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);

			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);

			long userId = PortalUtil.getUserId(uploadPortletRequest);

			String userName = PortalUtil.getUserName(userId, "Guest");

			long videoFolderId =
				GetterUtil.getLong(preferences.getValue(
					"videoFolderId", String.valueOf(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)));

			long videoId = ParamUtil.getLong(uploadPortletRequest, "videoId");
			
			long categoryId = ParamUtil.getLong(uploadPortletRequest, "videoCategory", 0L);

			String videoName = ParamUtil.getString(uploadPortletRequest, "name");
			
			String videoDescription = ParamUtil.getString(uploadPortletRequest, "description");
			
			String videoType = ParamUtil.getString(uploadPortletRequest, "videoType");
			
			String videoUrl = "";

			long videoFileId = ParamUtil.getLong(uploadPortletRequest, "videoFileId");

			boolean videoThumbnailImage = ParamUtil.getBoolean(uploadPortletRequest, "videoThumbnailImage");
			
			long thumbnailImageId = ParamUtil.getLong(uploadPortletRequest, "thumbnailImageId");

			//External video
			if(Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE)){
				
				if(videoFileId > 0L){
					//delete internal video file
					DLAppServiceUtil.deleteFileEntry(videoFileId);
					videoFileId = 0L;
				}
				
				videoUrl = ParamUtil.getString(uploadPortletRequest, "videoUrl");
				
				if(isValidYouTubeURL(videoUrl)){//Check if Youtube video URL eg https://www.youtube.com/watch?v=Wn-_MyJV37E
					
					//Youtube video id eg Wn-_MyJV37E
					String youtubeVideoId = getVideoIdFromYoutubeURL(videoUrl);
					
					if(Validator.isNotNull(youtubeVideoId)){
						
						//build embed youtube iframe url
						videoUrl = VideoFileUtil.getEmbedYoutubeVideoURL(youtubeVideoId);
					}
				}
				
			}else{//Internal video

				videoFileStream = uploadPortletRequest.getFileAsStream("videoFile");

				if (videoFileStream != null) {

					videoUrl = "";

					byte[] videoFileBytes = FileUtil.getBytes(videoFileStream);

					String videoFileName = uploadPortletRequest.getFileName("videoFile");

					if (VideoFileUtil.validateVideoFile(videoFileName, videoFileBytes.length, preferences)) {

						String friendlyFileName = VideoFileUtil.getFriendlyFileName(videoName);

						String timeStampFileName =
							friendlyFileName + StringPool.MINUS + String.valueOf(System.nanoTime()) + StringPool.PERIOD +
								FileUtil.getExtension(videoFileName);

						String mimeType = MimeTypesUtil.getContentType(videoFileName);

						ServiceContext serviceContext =
							ServiceContextFactory.getInstance(FileEntry.class.getName(), actionRequest);

						serviceContext.setGroupPermissions(new String[] {
							ActionKeys.VIEW
						});
						serviceContext.setGuestPermissions(new String[] {
							ActionKeys.VIEW
						});

						if (videoFileId > 0) {

							DLAppServiceUtil.updateFileEntry(
								videoFileId, timeStampFileName, mimeType, timeStampFileName, StringPool.BLANK,
								StringPool.BLANK, true, videoFileBytes, serviceContext);
						}
						else {

							FileEntry videoFile =
								DLAppServiceUtil.addFileEntry(
									groupId, videoFolderId, timeStampFileName, mimeType, timeStampFileName,
									StringPool.BLANK, StringPool.BLANK, videoFileBytes, serviceContext);

							if (videoFile != null) {

								videoFileId = videoFile.getFileEntryId();
							}
						}
					}
				}
			}
			
			if (videoThumbnailImage) {

				thumbnailImageStream = uploadPortletRequest.getFileAsStream("videoThumbnailImageFile");

				if (thumbnailImageStream != null) {

					byte[] thumbnailFileBytes = FileUtil.getBytes(thumbnailImageStream);

					String thumbnailFileName = uploadPortletRequest.getFileName("videoThumbnailImageFile");

					if (VideoFileUtil.validateImageThumbnail(thumbnailFileName, thumbnailFileBytes.length, preferences)) {

						String friendlyFileName = VideoFileUtil.getFriendlyFileName(videoName);

						String timeStampFileName =
							friendlyFileName + StringPool.MINUS + String.valueOf(System.nanoTime()) +
								StringPool.PERIOD + FileUtil.getExtension(thumbnailFileName);

						String mimeType = MimeTypesUtil.getContentType(thumbnailFileName);

						ServiceContext serviceContext =
							ServiceContextFactory.getInstance(FileEntry.class.getName(), actionRequest);

						serviceContext.setGroupPermissions(new String[] {
							ActionKeys.VIEW
						});
						serviceContext.setGuestPermissions(new String[] {
							ActionKeys.VIEW
						});

						if (thumbnailImageId > 0) {

							DLAppServiceUtil.updateFileEntry(
								thumbnailImageId, timeStampFileName, mimeType, timeStampFileName, StringPool.BLANK,
								StringPool.BLANK, true, thumbnailFileBytes, serviceContext);
						}
						else {

							FileEntry thumbnailImageFile =
								DLAppServiceUtil.addFileEntry(
									groupId, videoFolderId, timeStampFileName, mimeType, timeStampFileName,
									StringPool.BLANK, StringPool.BLANK, thumbnailFileBytes, serviceContext);

							if (thumbnailImageFile != null) {

								thumbnailImageId = thumbnailImageFile.getFileEntryId();
							}
						}
					}
				}
			}

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(VideoEntry.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] {
				ActionKeys.VIEW
			});
			serviceContext.setGuestPermissions(new String[] {
				ActionKeys.VIEW
			});

			if (videoId > 0) {

				VideoEntryLocalServiceUtil.updateVideo(
					videoId, companyId, groupId, userId, userName, videoName, videoDescription, videoType, videoUrl,
					videoFileId, videoThumbnailImage, thumbnailImageId, serviceContext);
				
				if ((Validator.isNotNull(categoryId))&&(categoryId>0L))
				{
					long mapId = 0L;
					
					if (VideoCategoryMapLocalServiceUtil.findByEntry(videoId).size()>0)
					{
						mapId = VideoCategoryMapLocalServiceUtil.findByEntry(videoId).get(0).getMapId();
					}
					
					if (mapId>0L)
					{
						VideoCategoryMapLocalServiceUtil.updateVideoCategoryMap(mapId, categoryId, videoId, serviceContext);
					}
					else
					{
						VideoCategoryMapLocalServiceUtil.addVideoCategoryMap(categoryId, videoId, serviceContext);
					}
					
					String memcachedKey = VideoPlayerUtil.buildCacheQueryKey(categoryId);
					
					MemcachedUtil.getInstance().delete(memcachedKey);
				}
				
			}
			else {

				VideoEntry newVideo = VideoEntryLocalServiceUtil.addVideo(
					companyId, groupId, userId, userName, videoName, videoDescription, videoType, videoUrl,
					videoFileId, videoThumbnailImage, thumbnailImageId, serviceContext);
				
				if ((Validator.isNotNull(categoryId))&&(categoryId>0L))
					VideoCategoryMapLocalServiceUtil.addVideoCategoryMap(categoryId, newVideo.getEntryId(), serviceContext);
				
				String memcachedKey = VideoPlayerUtil.buildCacheQueryKey(categoryId);
				
				MemcachedUtil.getInstance().delete(memcachedKey);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		}
		catch (Exception e) {
			if (e instanceof VideoFileTypeException || e instanceof VideoFileSizeException ||
				e instanceof ThumbnailImageFileTypeException || e instanceof ThumbnailImageFileSizeException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				_log.error(e);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
		finally {
			StreamUtil.cleanUp(videoFileStream);
			StreamUtil.cleanUp(thumbnailImageStream);
		}
	}

	public void updateVideoSettings(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		try {

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			long videoFolderId = ParamUtil.getLong(actionRequest, "videoFolderId");

			String[] videoExtensions =
				StringUtil.split(ParamUtil.getString(actionRequest, "videoExtensions"), StringPool.COMMA);

			//Video max size in MB
			String videoMaxSize = ParamUtil.getString(actionRequest, "videoMaxSize");
			
			validateFileSizeSettings(GetterUtil.getLong(videoMaxSize));

			String[] imageThumbnailExtensions =
				StringUtil.split(ParamUtil.getString(actionRequest, "imageThumbnailExtensions"), StringPool.COMMA);

			//Thumbnail max size in MB
			String imageThumbnailMaxSize = ParamUtil.getString(actionRequest, "imageThumbnailMaxSize");
			
			validateFileSizeSettings(GetterUtil.getLong(imageThumbnailMaxSize));
			
			preferences.setValue("videoFolderId", String.valueOf(videoFolderId));
			preferences.setValues("videoExtensions", videoExtensions);
			preferences.setValue("videoMaxSize", videoMaxSize);
			preferences.setValues("imageThumbnailExtensions", imageThumbnailExtensions);
			preferences.setValue("imageThumbnailMaxSize", imageThumbnailMaxSize);

			preferences.store();
		}
		catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}else if (e instanceof VideoFileSizeException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				_log.error(e);
			}
		}

		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		if (Validator.isNotNull(redirectURL)) {

			actionResponse.sendRedirect(redirectURL);
		}
	}

	public void addVideoFolder(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);

			long parentFolderId = ParamUtil.getLong(actionRequest, "parentFolderId");

			String videoFolderName = ParamUtil.getString(actionRequest, "videoFolderName");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);

			serviceContext.setGroupPermissions(new String[] {
				ActionKeys.VIEW
			});
			serviceContext.setGuestPermissions(new String[] {
				ActionKeys.VIEW
			});

			DLFolderLocalServiceUtil.addFolder(
				userId, groupId, groupId, false, parentFolderId, videoFolderName, StringPool.BLANK, serviceContext);

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		}
		catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				_log.error(e);
			}
		}
	}

	public void deleteVideo(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long videoId = ParamUtil.getLong(actionRequest, "videoId");

			if (videoId > 0) {

				VideoEntry videoEntry = VideoEntryLocalServiceUtil.getVideoEntry(videoId);

				if (videoEntry != null && videoEntry.getVideoFileId() > 0L) {

					DLAppServiceUtil.deleteFileEntry(videoEntry.getVideoFileId());
				}

				if (videoEntry != null && videoEntry.getThumbnailImageId() > 0L) {

					DLAppServiceUtil.deleteFileEntry(videoEntry.getThumbnailImageId());
				}

				VideoEntryLocalServiceUtil.deleteVideoEntry(videoId);
				
				List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByEntry(videoId);
				
				if(Validator.isNotNull(listMap))
					for (int i = 0;i<listMap.size();i++)
					{
						String memcachedKey = VideoPlayerUtil.buildCacheQueryKey(listMap.get(i).getCategoryId());
						
						MemcachedUtil.getInstance().delete(memcachedKey);
						
						VideoCategoryMapLocalServiceUtil.deleteVideoCategoryMap(listMap.get(i));
					}
				
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}

		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	

	public void deleteVideoCategory (ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try
		{
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			
			if (Validator.isNotNull(categoryId))
			{
				String memcachedKey = VideoPlayerUtil.buildCacheQueryKey(categoryId);
				
				MemcachedUtil.getInstance().delete(memcachedKey);
				
				VideoCategoryLocalServiceUtil.deleteVideoCategory(categoryId);
				
				List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByCategory(categoryId);
				
				if(Validator.isNotNull(listMap))
					for (int i = 0;i<listMap.size();i++)
					{
						VideoCategoryMapLocalServiceUtil.deleteVideoCategoryMap(listMap.get(i));
					}
			}
		}
		catch (Exception e)
		{
			_log.error(e);
		}
	}
	

	private void validateFileSizeSettings(long fileSize) throws SystemException, VideoFileSizeException{
		
		//Document Media max size in KB
		long dlFileMaxSize = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE);
		
		if(fileSize < VideoConstants.FILE_SIZE_COEFFICENT){
			//Chuyen doi tu MB sang KB de so sanh
			fileSize = fileSize * VideoConstants.FILE_SIZE_COEFFICENT;
		}
		
		if(fileSize > dlFileMaxSize){
			throw new VideoFileSizeException();
		}
	}
	
	private boolean isValidYouTubeURL(String url){
		
		UrlValidator validator = new UrlValidator();
		
		if(validator.isValid(url)){
			String pattern = "^https:\\/\\/(?:www\\.)?youtube.com\\/watch\\?(?=.*v=\\w+)(?:\\S+)?$";

			Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
			Matcher matcher = compiledPattern.matcher(url);
			
			return matcher.matches();
			
		}else{
			return false;
		}
	}
	
	private String getVideoIdFromYoutubeURL(String url){
		
		String pattern = "(?<=v=|/videos/|embed\\/)[^#\\&\\?\"]*";

		Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = compiledPattern.matcher(url);
		
		if(matcher.find()){
			return matcher.group();
		}else{
			return StringPool.BLANK;
		}
	}
	
	private final static Log _log = LogFactoryUtil.getLog(VideoAdmin.class);
}