package com.portal_egov.portlet.ykct.util;

import java.io.File;
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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
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
import com.portal_egov.portlet.ykct.YKCTAdminPortlet;
import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;
import com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalServiceUtil;

public class FileAttachmentUtil {
	
/**
 * 
 * @date Jun 22, 2012
 * @author HungDX
 * @todo Tao link download cho file dinh kem VBPQ
 * @return String
 * @param dlFileEntry
 * @return
 */
	public static String createAttachmentDownloadLink(DLFileEntry dlFileEntry,ThemeDisplay themeDisplay){
		
		try {
			
			String fileAttachmentDownloadLink = "";
			
			if(Validator.isNotNull(STATIC_CACHE_DIR)){
				
				String fileIdStr = String.valueOf(dlFileEntry.getFileEntryId());
				
				String[] fileIdStrSplitedArr = fileIdStr.split("(?<=\\G.{2})");
				
				StringBuilder stringBuilder = new StringBuilder();
				
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(STATIC_DOCUMENTS_FOLDER_NAME);
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(dlFileEntry.getGroupId());
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(dlFileEntry.getFolderId());
				stringBuilder.append(StringPool.SLASH);
				
				for (int i = 0; i < fileIdStrSplitedArr.length; i++){
					
					stringBuilder.append(fileIdStrSplitedArr[i]);
					stringBuilder.append(StringPool.SLASH);
				}
				
				stringBuilder.append(dlFileEntry.getFileEntryId() + "." + dlFileEntry.getExtension());
				
				if(!FileUtil.exists(STATIC_CACHE_DIR + stringBuilder.toString())){
					
					InputStream dlFileInputStream = DLFileEntryLocalServiceUtil.getFileAsStream(dlFileEntry.getUserId(), 
							dlFileEntry.getFileEntryId(), dlFileEntry.getFileVersion().getVersion());
					
					if(dlFileInputStream != null){
						
						File staticFile = new File(STATIC_CACHE_DIR + stringBuilder.toString());
						
						FileUtil.write(staticFile, dlFileInputStream);
					}
					
					if(dlFileInputStream != null){
						dlFileInputStream.close();
					}
				}
				
				fileAttachmentDownloadLink = stringBuilder.toString();
				
			}else{
				
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
			}
			
			return fileAttachmentDownloadLink;
			
		} catch (SystemException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
		catch (PortalException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
		catch (IOException e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	
	/**
	 * 
	 * @date Jun 24, 2012
	 * @author HungDX
	 * @todo Lay danh sach tai lieu dinh kem VBPQ theo vbpqEntryID
	 * @return List<DLFileEntry>
	 * @param vbpqEntryId
	 * @return
	 */
	public static List<DLFileEntry> getYKCTFileAttachment(long ykctEntryId){
		
		try {
			List<DLFileEntry> ykctFileAttachmentList = new ArrayList<DLFileEntry>();
			
			List<YKCT_DlFileEntries> ykctDLFileEntriesList = YKCT_DlFileEntriesLocalServiceUtil.findByYKCTEntry(ykctEntryId); 
			
			for(int i = 0; i < ykctDLFileEntriesList.size();i++){
				
				YKCT_DlFileEntries ykctDLFileEntries = ykctDLFileEntriesList.get(i);
				
				DLFileEntry ykctFileAttachment = getDLFileEntry(ykctDLFileEntries.getFileEntryId());
				
				if(ykctFileAttachment != null){
					
					ykctFileAttachmentList.add(ykctFileAttachment);
				}else{
					
					YKCT_DlFileEntriesLocalServiceUtil.deleteYKCT_DlFileEntries(ykctDLFileEntries);
				}
			}
			
			return ykctFileAttachmentList;
		}
		catch (Exception e) {			
			if(e instanceof NoSuchFileEntryException){
				
			}else{
				e.printStackTrace();
				_log.error(e);
			}
			return Collections.emptyList();
		}
	}
	
	/**
	 * Up load nhieu file
	 * @param actionRequest
	 * @param actionResponse
	 * @param selectedFileName
	 * @param validFileNames
	 * @param invalidFileNameKVPs
	 * @throws Exception
	 */

	public static long addMultipleFileEntries(ActionRequest actionRequest, ActionResponse actionResponse, String selectedFileName,
			List<String> validFileNames, List<KeyValuePair> invalidFileNameKVPs) throws Exception {

		long fileAttachmentId = 0L;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId");
		
		String contentType = MimeTypesUtil.getContentType(selectedFileName);
		String description = ParamUtil.getString(actionRequest, "description");
		String changeLog = ParamUtil.getString(actionRequest, "changeLog");
		
		InputStream inputStream = null;
		
		String tempFileName = TempFileUtil.getTempFileName(themeDisplay.getUserId(), selectedFileName, _TEMP_FOLDER_NAME);
		
		try {
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			boolean autoCreateSubFolder = GetterUtil.getBoolean(preferences.getValue("autoCreateSubFolder", "true"));
			
			long parentFolderId = GetterUtil.getLong(preferences.getValue("vbpqAttachmentFolderId", "0"));
			
			long folderId = parentFolderId;

			
			if(autoCreateSubFolder){
				//So hieu VBPQ
				String entryCode = ParamUtil.getString(actionRequest, "entryCode", StringPool.BLANK);
				
				String folderName = formatFileName(entryCode);
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				
				folderId = createAttachmentFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 
															repositoryId, parentFolderId, folderName, serviceContext);																
			}
			
			inputStream = TempFileUtil.getTempFileAsStream(tempFileName);
			
			long size = TempFileUtil.getTempFileSize(tempFileName);
			
 			if(!checkExistFileEntry(themeDisplay.getScopeGroupId(), folderId, selectedFileName)){			
				
				String selectedFileNamePrefix = String.valueOf(CounterLocalServiceUtil.increment()) + StringPool.UNDERLINE;
				
				selectedFileName = selectedFileNamePrefix + selectedFileName;
			}
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);			
			//Add quyen xem,download file cho Guest
			serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});

			FileEntry fileAttachment = DLAppServiceUtil.addFileEntry(repositoryId, folderId, selectedFileName, contentType,
				selectedFileName, description, changeLog, inputStream, size,serviceContext);
 			
			
			if(fileAttachment != null){
				
				fileAttachmentId = fileAttachment.getFileEntryId();
			}
			
			validFileNames.add(selectedFileName);

		} catch (Exception e) {
			
			if(e instanceof NoSuchFileEntryException){
				System.out.println(NoSuchFileEntryException.class.getName());
			}else {
				_log.error(e);
			}
			
			String errorMessage = getAddMultipleFileEntriesErrorMessage(themeDisplay, e);

			invalidFileNameKVPs.add(new KeyValuePair(selectedFileName, errorMessage));
			
		} finally {
			StreamUtil.cleanUp(inputStream);
			TempFileUtil.deleteTempFile(tempFileName);
		}
		
		return fileAttachmentId;
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

		long attachmentFolderId = 0L;
		
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
	
	/**
	 * 
	 * @date Jun 24, 2012
	 * @author HungDX
	 * @todo Kiem tra trung lap file
	 * @return boolean
	 * @param groupId
	 * @param folderId
	 * @param fileName
	 * @return
	 */
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
	

	private static DLFileEntry getDLFileEntry(long fileEntryId){
		
		DLFileEntry dlFileEntry = null;
		
		try {
			
			dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
		}
		catch (Exception e) {
			if (e instanceof NoSuchFileEntryException) {
				
			}else{
				_log.error(e);
			}
		}
		
		return dlFileEntry;
	}
	
	/**
	 * Mapping noi dung message hien thi tuong ung voi cac exception co the xay ra trong qua trinh upload file
	 * @param themeDisplay
	 * @param e
	 * @return
	 * @throws Exception
	 */
	private static String getAddMultipleFileEntriesErrorMessage(ThemeDisplay themeDisplay, Exception e) throws Exception {

		String errorMessage = null;

		if (e instanceof AssetCategoryException) {
			AssetCategoryException ace = (AssetCategoryException) e;

			AssetVocabulary assetVocabulary = ace.getVocabulary();

			String vocabularyTitle = StringPool.BLANK;

			if (assetVocabulary != null) {

				vocabularyTitle = assetVocabulary.getTitle(themeDisplay.getLocale());
			}

			if (ace.getType() == AssetCategoryException.AT_LEAST_ONE_CATEGORY) {

				errorMessage = LanguageUtil.format(themeDisplay.getLocale(), "please-select-at-least-one-category-for-x", vocabularyTitle);

			} else if (ace.getType() == AssetCategoryException.TOO_MANY_CATEGORIES) {

				errorMessage = LanguageUtil.format(themeDisplay.getLocale(), "you-cannot-select-more-than-one-category-for-x",
						vocabularyTitle);
			}

		} else if (e instanceof DuplicateFileException) {

			errorMessage = LanguageUtil.get(themeDisplay.getLocale(), "the-folder-you-selected-already-has-an-entry-with-this-name."
					+ "-please-select-a-different-folder");

		} else if (e instanceof FileExtensionException) {

			errorMessage = LanguageUtil.format(themeDisplay.getLocale(), "please-enter-a-file-with-a-valid-extension-x",
					StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)));

		} else if (e instanceof FileNameException) {

			errorMessage = LanguageUtil.get(themeDisplay.getLocale(), "please-enter-a-file-with-a-valid-file-name");

		} else if (e instanceof FileSizeException) {

			long maxSizeMB = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE) / 1024 / 1024;

			errorMessage = LanguageUtil.format(themeDisplay.getLocale(), "file-size-is-larger-than-x-megabytes", maxSizeMB);

		} else {

			errorMessage = LanguageUtil.get(themeDisplay.getLocale(), "an-unexpected-error-occurred-while-saving-your-document");
		}

		return errorMessage;
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
	
	private static final String STATIC_CACHE_DIR = PropsUtil.get("static.cache.dir");
	private static final String STATIC_DOCUMENTS_FOLDER_NAME = PropsUtil.get("static.documents.folder.name");
	
	private static final String UTF_8_STR = "Ã½á»³á»µá»·á»¹Ã¡áº£Ã Ã£áº¡Äƒáº¯áº³áº±áºµáº·Ã¢áº¥áº©áº§áº«áº­Ã©áº»Ã¨áº½áº¹Ãªáº¿á»ƒá»�á»…á»‡Ã­á»‰Ã¬Ä©á»‹Ã³á»�Ã²Ãµá»�Ã´á»‘á»•á»“á»—á»™Æ¡á»›á»Ÿá»�á»¡á»£Ãºá»§Ã¹Å©á»¥Æ°á»©á»­á»«á»¯á»±Ä‘";
	private static final String UTF_8_REPLACE_STR = "yyyyyaaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuud";
	
	private static final char[] SPECIAL_CHARS = new char[] { ' ', ',', '\\',
			'\'', '\"', '(', ')', ':', '/', '^', '|', '{', '}', '?', '#', '@',
			'+', '*', '&', '<', '>', '=', '~', ';', '$', '%',
			'!', '[', ']', '!', '`' };
	
	private static final String _TEMP_FOLDER_NAME = YKCTAdminPortlet.class.getName();
	
	private static Log _log = LogFactory.getLog(FileAttachmentUtil.class);
}
