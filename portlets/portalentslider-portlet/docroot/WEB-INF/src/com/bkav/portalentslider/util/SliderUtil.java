package com.bkav.portalentslider.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bkav.portalentslider.action.SliderAdminAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class SliderUtil {
	
	public static String[] getTempFileEntries(long groupId, long folderId, String tempFolderName){
		try {
			String[] tempFileEntries = DLAppServiceUtil.getTempFileEntryNames(groupId, folderId, tempFolderName);
			return tempFileEntries;
			
		} catch (Exception e) {
			_log.error(e);
			return null;
		} 
	}
	
	public static String encodeTempFileToBase64(long userId, String tempFileName) throws IOException{
		
		InputStream is = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try{
			String tempFilePath = TempFileUtil.getTempFileName(userId, tempFileName, _TEMP_FOLDER_NAME);
			
			is = TempFileUtil.getTempFileAsStream(tempFilePath);
			int len;
			int size = 1024;
			byte[] buf;
			
			if (is instanceof ByteArrayInputStream) {
				size = is.available();
			    buf = new byte[size];
			    len = is.read(buf, 0, size);
			}else {
				
			    buf = new byte[size];
			    while ((len = is.read(buf, 0, size)) != -1)
			    bos.write(buf, 0, len);
			    buf = bos.toByteArray();
			    
			}
			
			return Base64.encode(buf);
			
		}catch(Exception e){
			_log.error(e);
			return StringPool.BLANK;
		}finally{
			is.close();
			bos.close();
		}
	}
	
	public static long getSliderImageFolderId(HttpServletRequest request) {


		long imageFolderId = 0;

		try {
			
			imageFolderId = getFolderId(request, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, _FOLDER_NAME);

		} catch (Exception e) {
			_log.error(e);
		}

		return imageFolderId;
	}
	
	public static void deleteImages(String[] selectedIds) {

		if(selectedIds != null){
			for(String selectedId:selectedIds){
				
				long fileEntryId = 0;
				
				try {
					fileEntryId = Long.parseLong(selectedId);
				} catch (Exception e) {
					continue;
				}
				
				if(fileEntryId <= 0){
					continue;
				}
				try {
					DLAppServiceUtil.deleteFileEntry(fileEntryId);
				} catch (Exception e) {
					continue;
				}
				
			}
		}
	}
	
	public static Folder getFolder(long folderId){
		Folder folder = null;
		try {
			folder = DLAppLocalServiceUtil.getFolder(folderId);
		} catch (Exception e) {
			folder = null;
		}
		return folder;
	}
	
	public static DLFolder getDLFolder(long folderId){
		DLFolder dlFolder = null;
		try {
			dlFolder = DLFolderLocalServiceUtil.getDLFolder(folderId);
		} catch (Exception e) {
			dlFolder = null;
		}
		return dlFolder;
	}
	
	public static long getFolderId(HttpServletRequest request, long parentFolderId, String folderName) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long folderId = 0;
		long userId = themeDisplay.getUserId();
		long repositoryId = themeDisplay.getScopeGroupId();

		try {
			Folder folder = null;

			if (checkExistDLFolder(repositoryId, parentFolderId, folderName)) {

				folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			} else {
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });

				folder = DLAppLocalServiceUtil.addFolder(userId, repositoryId, parentFolderId, 
					folderName, StringPool.BLANK, serviceContext);
			}

			if (folder != null) {
				folderId = folder.getFolderId();
			}
		} catch (Exception e) {

		}

		return folderId;
	}
	
	/**
	 * Kiem tra folder voi folderName co ton tai hay chua. return false neu chua ton tai.
	 * 
	 * @param repositoryId
	 * @param parentFolderId
	 * @param folderName
	 * @return
	 */
	public static boolean checkExistDLFolder(long repositoryId, long parentFolderId, String folderName) {

		boolean res = false;
		
		if(Validator.isNotNull(folderName)){
			
			Folder folder = null;
			
			try {
				folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			}
			catch (Exception e) {
				if (!(e instanceof NoSuchFolderException)) {
					_log.error(e);
				} 
			}

			if (folder != null) {
				res = true;
			}
		}
		
		return res;
	}
	
	/**
	 * Kiem tra folder voi folderName co ton tai hay chua. return false neu chua ton tai.
	 * 
	 * @param repositoryId
	 * @param parentFolderId
	 * @param currentFolderId
	 * @param folderName
	 * @return
	 */
	public static boolean checkExistDLFolder(long repositoryId, long parentFolderId, long currentFolderId, String folderName) {

		boolean res = false;
		
		if(Validator.isNotNull(folderName)){
			
			Folder folder = null;
			
			try {
				folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			}
			catch (Exception e) {
				if (!(e instanceof NoSuchFolderException)) {
					_log.error(e);
				} 
			}

			if (folder != null && folder.getFolderId() != currentFolderId) {
				res = true;
			}else{
				res = false;
			}
		}
		
		return res;
	}
	
	public static String getImageURL(FileEntry fileEntry, ThemeDisplay themeDisplay, String queryString, boolean absoluteURL) {

			String srcImage = StringPool.BLANK;

			try {
				StringBuilder stringBuilder = new StringBuilder(9);
				
				if (themeDisplay != null) {

					if (absoluteURL) {
						stringBuilder.append(themeDisplay.getPortalURL());
					}
					
					stringBuilder.append(themeDisplay.getPathContext());
				}

				stringBuilder.append("/documents/");
				stringBuilder.append(fileEntry.getRepositoryId());
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(fileEntry.getFolderId());
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle())));
				
				stringBuilder.append(queryString);
				srcImage = stringBuilder.toString();

			} catch (Exception e) {
				
			}
			
			return srcImage;
	}
	
	public static String getImageURL(String imageId, ThemeDisplay themeDisplay, String queryString, boolean absoluteURL) {

		String srcImage = StringPool.BLANK;
		
		FileEntry entry = null;
		
		long fileEntryId = 0;
		
		try {
			
			fileEntryId = Long.parseLong(imageId);
					
			if(fileEntryId > 0){
				entry = DLAppServiceUtil.getFileEntry(fileEntryId);
			}
									
			if(entry != null && SliderUtil.isCorrectImageMimeType(entry.getMimeType())){
				srcImage = SliderUtil.getImageURL(entry, themeDisplay, queryString, absoluteURL);
			}
									
		} catch (Exception e) {
			//_log.error(e);
		}
		
		return srcImage;
	}
	
	public static String getImageURL(long imageId, ThemeDisplay themeDisplay, String queryString, boolean absoluteURL) {

		String srcImage = StringPool.BLANK;
		
		FileEntry entry = null;
		
		try {
				
			if(imageId > 0){
				entry = DLAppServiceUtil.getFileEntry(imageId);
			}
									
			if(entry != null && SliderUtil.isCorrectImageMimeType(entry.getMimeType())){
				srcImage = SliderUtil.getImageURL(entry, themeDisplay, queryString, absoluteURL);
			}
									
		} catch (Exception e) {
			//_log.error(e);
		}
		
		return srcImage;
	}
	
	public static enum imageMimeType{
		
		PNG("image/png"), JPEG("image/jpeg"), GIF("image/gif");
		
		private final String _value;

		private imageMimeType(String value) {
	       this._value = value;
	    }

	    public String toString() {
	        return _value;
	    }
	}
	
	public static enum imageViewType{
		
		TINY("?imageThumbnail=2"), SMALL("?imageThumbnail=1"), MIDIUM("?imageThumbnail=3"), LARGE("?imageThumbnail=4");
		
		private final String _value;

		private imageViewType(String value) {
	       this._value = value;
	    }

	    public String toString() {
	        return _value;
	    }
	}
	
	public static boolean isCorrectImageMimeType(String value){
		
		boolean result = false;
		
		imageMimeType[] mimeTypes = imageMimeType.values();
		for(int i = 0; i < mimeTypes.length; i++){
			if(mimeTypes[i].toString().equals(value)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static void writeJSON(ActionResponse actionResponse, Object json){

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		try {
			ServletResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public static void writeJSON(PortletRequest portletRequest, ActionResponse actionResponse, Object json){

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		try {
			ServletResponseUtil.write(response, json.toString());
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	
	
	public static final String _TEMP_FOLDER_NAME = SliderAdminAction.class.getName();
	
	private static String _FOLDER_NAME = "Slider";
	
	public static final String _ERROR_MSG_KEY = "DELETE-SLIDER-FAIL";
	public static final String _ERROR_MSG = "delete-slider-fail";
	
	public static final String _ERROR_MSG01_KEY = "SLIDER-NAME-EMPTY";
	public static final String _ERROR_MSG01 = "slider-name-empty";
	
	public static final String _ERROR_MSG02_KEY = "SLIDER-NAME-EXIST";
	public static final String _ERROR_MSG02 = "slider-name-exist";
	
	public static final String _ERROR_MSG03_KEY = "CREATE-SLIDER-FORLDER-FAIL";
	public static final String _ERROR_MSG03 = "create-slider-folder-fail";
	
	public static final String _SUCCESS_MSG_KEY = "CREATE-SLIDER-SUCCESS";
	public static final String _SUCCESS_MSG = "create-slider-success";
	
	public static final String _SUCCESS_MSG01_KEY = "DELETE-SLIDER-SUCCESS";
	public static final String _SUCCESS_MSG01 = "delete-slider-success";
	
	public static final String _SUCCESS_MSG02_KEY = "UPDATE-SLIDER-SUCCESS";
	public static final String _SUCCESS_MSG02 = "update-slider-success";
	
	public static final String SLIDER_ADMIN_PORTLET_NAME = "slideradmin_WAR_portalentsliderportlet";
	
	private static Log _log = LogFactoryUtil.getLog(SliderUtil.class);
	
}
