package com.bkav.portal.portlet.audioplayer.util;

import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portal.portlet.audioplayer.admin.AudioAdmin;
import com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap;
import com.bkav.portal.portlet.audioplayer.model.AudioFile;
import com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil;
import com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Image;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

public class AudioUtil {
	public static final int ACTIVE_BANNER_STATUS = 1;
	public static final int DEACTIVE_BANNER_STATUS = 0;
	public static final int AUDIO_START_VIEW_COUNT = 0;
	
	public static ArrayList<AudioFile> getListAudioByAlbumId (long albumId) throws Exception, PortletException
	{
		List<AlbumAudioMap> aamList = AlbumAudioMapLocalServiceUtil.findByAlbumId(albumId);
		if (aamList.size()==0)
			return null;
		else
		{
			ArrayList<AudioFile> audioList = new ArrayList<AudioFile>();
			for (int i = 0;i<aamList.size();i++)
			{
				AudioFile audio = AudioFileLocalServiceUtil.getAudioFile(aamList.get(i).getAudioId());
				audioList.add(audio);
			}
			
			
			
			return audioList;
		}
	}
	
	public static String getAudioFilePath (RenderRequest request, long audioFileId) throws Exception, PortalException
	{
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(audioFileId);
		
		fileEntry = fileEntry.toEscapedModel();
		
		long folderId = fileEntry.getFolderId();
		String title = fileEntry.getTitle();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "//" + folderId +  "//" + HttpUtil.encodeURL(HtmlUtil.unescape(title));

		return fileUrl;
		
	}
	
	public static String getAlbumCoverPath(HttpServletRequest request,long albumCoverId){
		
		try {
			
			String albumCoverPath = "/audio-player-portlet/html/images/album-icon.png";
			
			Image coverImage = ImageLocalServiceUtil.fetchImage(albumCoverId);
			
			if(coverImage != null){
				
				if(Validator.isNotNull(PropsUtil.get(STATIC_CACHE_DIR_PROPERTY_KEY))){//Cache image
					
					String albumCoverIdStr = String.valueOf(albumCoverId);
					
					String[] albumCoverIdStrSplitedArr = albumCoverIdStr.split("(?<=\\G.{2})");
					
					StringBuilder stringBuilder = new StringBuilder();
					
					stringBuilder.append(StringPool.SLASH);
					stringBuilder.append(IMAGE_CACHE_FOLDER_NAME);
					stringBuilder.append(StringPool.SLASH);
					
					for (int i = 0; i < albumCoverIdStrSplitedArr.length; i++){
						
						stringBuilder.append(albumCoverIdStrSplitedArr[i]);
						stringBuilder.append(StringPool.SLASH);
					}
					
					stringBuilder.append(albumCoverId + "." + coverImage.getType());
					
					albumCoverPath = stringBuilder.toString();
					
				}else{
					
					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					
					albumCoverPath = themeDisplay.getPathImage() + "/logo?img_id=" + albumCoverId
									+ "&t" + WebServerServletTokenUtil.getToken(albumCoverId);
				}
			}
			
			return albumCoverPath;
		}
		catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	
	public static void uploadAlbumCover(long albumCoverId,InputStream albumCoverStream) throws Exception{
		
		if(albumCoverStream != null){
			
			byte[] albumCoverBytes = FileUtil.getBytes(albumCoverStream);
			
			long uploadServletMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);

			if ((uploadServletMaxSize > 0)
				&& ((albumCoverBytes == null) || (albumCoverBytes.length > uploadServletMaxSize))) {

				throw new ImageSizeException();
			}
			
			ImageBag imageBag = ImageToolUtil.read(albumCoverBytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new ImageTypeException();
			}

			String contentType = imageBag.getType();
			
			byte[] bannerImagesBytes = ImageToolUtil.getBytes(renderedImage, contentType);
			
			ImageLocalServiceUtil.updateImage(albumCoverId, bannerImagesBytes);
		}
	}
	
	public static long uploadAudioFiles (ActionRequest actionRequest, ActionResponse actionResponse, String selectedFileName) throws Exception{
		
		long fileAudioFileId = 0L;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId");
		
		String contentType = MimeTypesUtil.getContentType(selectedFileName);
		String description = ParamUtil.getString(actionRequest, "description");
		String changeLog = ParamUtil.getString(actionRequest, "changeLog");
		
		InputStream inputStream = null;
		
		String tempFileName = TempFileUtil.getTempFileName(themeDisplay.getUserId(), selectedFileName, _TEMP_FOLDER_NAME);
		
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			inputStream = TempFileUtil.getTempFileAsStream(tempFileName);
			
			long size = TempFileUtil.getTempFileSize(tempFileName);
			
			long audioFolderId = GetterUtil.getLong(preferences.getValue("audioFolderId", "0"));
			
			if(!checkExistFileEntry(themeDisplay.getScopeGroupId(), audioFolderId, selectedFileName)){			
				
				String selectedFileNamePrefix = String.valueOf(CounterLocalServiceUtil.increment()) + StringPool.UNDERLINE;
				
				selectedFileName = selectedFileNamePrefix + selectedFileName;
			}
			
			
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);			
			//Add quyen xem cho Guest
			serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
			
			FileEntry fileAttachment = DLAppServiceUtil.addFileEntry(repositoryId, audioFolderId, selectedFileName, contentType,
					selectedFileName, description, changeLog, inputStream, size,serviceContext);
			
			
			
			if(fileAttachment != null){
				
				fileAudioFileId = fileAttachment.getFileEntryId();
			}
		}
		catch (Exception e)
		{
			if(e instanceof NoSuchFileEntryException){
				System.out.println(NoSuchFileEntryException.class.getName());
			}else {
				_log.error(e);
			}
			
			//String errorMessage = getAddMultipleFileEntriesErrorMessage(themeDisplay, e);
		}
		finally 
		{
			
			StreamUtil.cleanUp(inputStream);
			TempFileUtil.deleteTempFile(tempFileName);
			
		}
		return fileAudioFileId;
	}
	
	private static boolean checkExistFileEntry(long groupId,long folderId,String fileName){
		try {
			
			if(Validator.equals(fileName, StringPool.BLANK)){
				return false;
			
			}else{
				
				DLFileEntry fileEntry = null;
				
				fileEntry = DLFileEntryLocalServiceUtil.getFileEntryByName(groupId, folderId, fileName);
				
				if(fileEntry == null){
					return false;
				}
			}
		}
		catch (Exception e) {
			if(e instanceof DuplicateFileException){
				
			}else if (e instanceof NoSuchFileEntryException) {
				
			}		
			else{
				_log.error(e);
			}
			return false;
		}
		
		return true;
	}
	
	
	private static Log _log = LogFactory.getLog(AudioUtil.class);
	
	private static final String _TEMP_FOLDER_NAME = AudioAdmin.class.getName();
	private static final String STATIC_CACHE_DIR_PROPERTY_KEY = "static.cache.dir";
	private static final String IMAGE_CACHE_FOLDER_NAME = "images";
}
