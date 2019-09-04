package com.portal_egov.portlet.legal_faq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.compat.portal.util.PortalUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.AssetCategoryException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.LegalFAQManagement;

public class FileAttachmentUtil {
	
	/**
	 * 
	 * @date Jun 22, 2012
	 * @author HungDX
	 * @todo Tao link download cho file dinh kem LegalFAQ
	 * @return String
	 * @param dlFileEntry
	 * @return
	 */
	public static String createAttachmentDownloadLink(DLFileEntry dlFileEntry,
			ThemeDisplay themeDisplay) throws PortalException, SystemException, IOException {

		if(dlFileEntry != null){
			String fileAttachmentDownloadLink = "";

			String fileTitle = dlFileEntry.getTitle();

			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append(themeDisplay.getPortalURL());
			stringBuilder.append(themeDisplay.getPathContext());
			stringBuilder.append("/documents/");
			stringBuilder.append(themeDisplay.getScopeGroupId());
			stringBuilder.append(StringPool.SLASH);
			stringBuilder.append(dlFileEntry.getFolderId());
			stringBuilder.append(StringPool.SLASH);
			stringBuilder.append(HttpUtil.encodeURL(fileTitle, true));
			fileAttachmentDownloadLink = stringBuilder.toString();

			return fileAttachmentDownloadLink;
		} else {
			return StringPool.BLANK;
		}
	}
	/**
	 * 
	 * @date Jun 23, 2012
	 * @author HungDX
	 * @todo Tao folder luu tai lieu dinh kem
	 * @return long
	 * @param userId
	 * @param groupId
	 * @param repositoryId
	 * @param parentFolderId
	 * @param folderName
	 * @param serviceContext
	 * @return
	 */
	public static long createAttachmentFolder(long userId,long groupId,long repositoryId, long parentFolderId,
													String folderName,ServiceContext serviceContext){

		long attachmentFolderId = LegalFAQConstants.DL_ROOT_FOLDER_ID;
		
		try {
			//Kiem tra trung lap folder
			if(checkExistDLFolder(groupId, parentFolderId, folderName)){
				
				DLFolder uploadFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
				
				attachmentFolderId = uploadFolder.getFolderId();
				
			}else {
				
				serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
				serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				DLFolder uploadFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, false,
																				parentFolderId, folderName, "", serviceContext);
				attachmentFolderId = uploadFolder.getFolderId();
			}
			
		}
		catch (Exception e) {
			_log.error(e);
		}
				
		return attachmentFolderId;
	}
	
	
	/**
	 * Kiem tra trung lap folder
	 * @param groupId
	 * @param parentFolderId Id cua folder cha
	 * @param folderName Ten folder muon kiem tra
	 * @return
	 */
	public static boolean checkExistDLFolder(long groupId,long parentFolderId,String folderName){
		try {
			
			if(Validator.equals(folderName, StringPool.BLANK)){
				return false;
			}else {
				DLFolder uploadFolder = null;
				
				uploadFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
				
				if(uploadFolder == null){
					return false;
				}
			}
						
		} catch (Exception e) {
			
			if(e instanceof DuplicateFolderNameException){
				_log.error(e);
			}else if(e instanceof NoSuchFolderException){
				
			}else{
				_log.error(e);
			}
			return false;
		}
		return true;
	}
	
	public static long addFileAttachment(ActionRequest actionRequest, ActionResponse actionResponse){
		long fileAttachmentId = 0L;
		
		UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		File file = uploadRequest.getFile("_legalfaq_WAR_legalfaqportlet_legalFaqAttachment");
		try {
			if(file != null && file.getName() != null){
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				long repositoryId = themeDisplay.getScopeGroupId();
				
				String contentType = MimeTypesUtil.getContentType(file);
				
				String fileTitle = file.getName();
				
				String description = "legal faq file";
				
				String changeLog = "hi";
				
				long size = file.length();
				
				PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
				
				long parentFolderId = GetterUtil.getLong(preferences.getValue("legalFaqAttachmentFolderId", "0"));
				
				InputStream inputStream = new FileInputStream( file );
				
				if(!checkExistFileEntry(themeDisplay.getScopeGroupId(), parentFolderId, fileTitle)){			
					
					String selectedFileNamePrefix = String.valueOf(CounterLocalServiceUtil.increment()) + StringPool.UNDERLINE;
					
					fileTitle = selectedFileNamePrefix + fileTitle;
					
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);			
					//Add quyen xem,download file cho Guest
					serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
					
					FileEntry fileAttachment = DLAppServiceUtil.addFileEntry(repositoryId, parentFolderId, fileTitle, contentType,
							fileTitle, description, changeLog, inputStream, size,serviceContext);
			 			
					if(fileAttachment != null){
							
						fileAttachmentId = fileAttachment.getFileEntryId();
					}	
				}
				
			}
		} catch (Exception e) {
			if(e instanceof NoSuchFileEntryException){
				System.out.println(NoSuchFileEntryException.class.getName());
			}else {
				_log.error(e);
			}
		}
		return fileAttachmentId;
	}
	
	// Kiem tra trung lap file
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
	
	private static String formatFileName(String text){
		
		String formatedText = text.trim();

		char[] formatedCharArray = formatedText.toCharArray();

		for (int i = 0; i < formatedCharArray.length; i++) {
			
			char oldChar = formatedCharArray[i];
			
			char newChar = oldChar;

			if (contains(SPECIAL_CHARS, oldChar)) {
				newChar = '-';
			}

			int temp = UTF_8_STR.indexOf(oldChar);

			if (temp > -1) {
				newChar = UTF_8_REPLACE_STR.charAt(temp);
			}

			if (oldChar != newChar) {
				formatedCharArray[i] = newChar;
			}

			formatedText = new String(formatedCharArray);

			while (formatedText.contains("-" + "-")) {
				formatedText = replace(formatedText, "--", "-", 0);
			}

			if (formatedText.startsWith("-")) {
				formatedText = formatedText.substring(1, formatedText.length());
			}

			if (formatedText.endsWith("-")) {
				formatedText = formatedText.substring(0, formatedText.length() - 1);
			}
		}
		
		return formatedText;
	}
	
	
	private static boolean contains(char[] charArray, char character) {
		if ((charArray == null) || (charArray.length == 0)) {
			return false;
		} else {
			for (int i = 0; i < charArray.length; i++) {
				if (character == charArray[i]) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	private static String replace(String s, String oldSub, String newSub,
			int fromIndex) {

		if ((s == null) || (oldSub == null) || (newSub == null)) {
			return null;
		}

		int y = s.indexOf(oldSub, fromIndex);

		if (y >= 0) {

			// The number 5 is arbitrary and is used as extra padding to reduce
			// buffer expansion

			StringBuilder sb = new StringBuilder(s.length() + 5 * newSub.length());

			int length = oldSub.length();
			int x = 0;

			while (x <= y) {
				sb.append(s.substring(x, y));
				sb.append(newSub);

				x = y + length;
				y = s.indexOf(oldSub, x);
			}

			sb.append(s.substring(x));

			return sb.toString();
		} else {
			return s;
		}
	}
	
	private static final String STATIC_DOCUMENTS_FOLDER_NAME = PropsUtil.get("static.documents.folder.name");
	
	private static final String UTF_8_STR = "Ã½á»³á»µá»·á»¹Ã¡áº£Ã Ã£áº¡Äƒáº¯áº³áº±áºµáº·Ã¢áº¥áº©áº§áº«áº­Ã©áº»Ã¨áº½áº¹Ãªáº¿á»ƒá»�á»…á»‡Ã­á»‰Ã¬Ä©á»‹Ã³á»�Ã²Ãµá»�Ã´á»‘á»•á»“á»—á»™Æ¡á»›á»Ÿá»�á»¡á»£Ãºá»§Ã¹Å©á»¥Æ°á»©á»­á»«á»¯á»±Ä‘";
	private static final String UTF_8_REPLACE_STR = "yyyyyaaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuud";
	
	private static final char[] SPECIAL_CHARS = new char[] { ' ', ',', '\\',
			'\'', '\"', '(', ')', ':', '/', '^', '|', '{', '}', '?', '#', '@',
			'+', '*', '&', '<', '>', '=', '~', ';', '$', '%',
			'!', '[', ']', '!', '`' };
	
	private static final String _TEMP_FOLDER_NAME = LegalFAQManagement.class.getName();
	private static Log _log = LogFactory.getLog(FileAttachmentUtil.class);
}
