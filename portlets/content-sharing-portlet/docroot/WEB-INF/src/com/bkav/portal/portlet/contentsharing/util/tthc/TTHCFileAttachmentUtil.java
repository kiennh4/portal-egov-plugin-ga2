package com.bkav.portal.portlet.contentsharing.util.tthc;

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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
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
import com.liferay.portal.util.PortalUtil;
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
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;
import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil;

public class TTHCFileAttachmentUtil {
	
/**
 * 
 * @todo TAO LINK DOWNLOAD VAN BAN DINH KEM TTHC
 * @author HungDX	
 * @date Jul 3, 2012
 * @return String
 * @param dlFileEntry
 * @param themeDisplay
 * @return
 */
	public static String createAttachmentDownloadLink(DLFileEntry dlFileEntry,ThemeDisplay themeDisplay){
		
		try {
			
			String fileAttachmentDownloadLink = "";
			
			if(Validator.isNotNull(PropsUtil.get(STATIC_CACHE_DIR_PROPERTY_KEY))){
				
				String fileIdStr = String.valueOf(dlFileEntry.getFileEntryId());
				
				String[] fileIdStrSplitedArr = fileIdStr.split("(?<=\\G.{2})");
				
				StringBuilder stringBuilder = new StringBuilder();
				
				stringBuilder.append(StringPool.SLASH);
				stringBuilder.append(DOCUMENT_CACHE_FOLDER_NAME);
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
			
		} catch (Exception e) {
			_log.error(e);
			return StringPool.BLANK;
		}
	}
	
	/**
	 * @todo LAY DANH SACH FILE DINH KEM CUA THU TUC
	 * @author HungDX	
	 * @date Aug 21, 2012
	 * @return List<DLFileEntry>
	 * @param groupId
	 * @param tthcEntryId
	 * @return
	 */
	public static List<DLFileEntry> getTTHCAttachFiles(long groupId,long tthcEntryId){
		
		try {
			
			List<DLFileEntry> tthcAttachFileList = new ArrayList<DLFileEntry>();
			
			List<TTHC_Attribute> tthcAttachFileAttributeList = TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndGroup(groupId,
				tthcEntryId, TTHCConstants.FILE_ATTACHMENT_ATTRIBUTE_TYPE_ID);
			
			for(TTHC_Attribute attachFileAttribute : tthcAttachFileAttributeList){
				
				long attachFileId = GetterUtil.getLong(attachFileAttribute.getAttributeValue(), 0L);
				
				if(attachFileId > 0){
					
					DLFileEntry tthcAttachFile = getDLFileEntry(attachFileId);
					
					if (tthcAttachFile != null) {
						tthcAttachFileList.add(tthcAttachFile);
					}
				}
			}
			return tthcAttachFileList;
		}
		catch (Exception e) {
			_log.error(e);
			return Collections.EMPTY_LIST;
		}
	}
	
	
	/**
	 * 
	 * @todo UPLOAD VAN BAN DINH KEM TTHC LEN SEVER
	 * @author HungDX	
	 * @date Jul 3, 2012
	 * @return long
	 * @param actionRequest
	 * @param actionResponse
	 * @param selectedFileName
	 * @param validFileNames
	 * @param invalidFileNameKVPs
	 * @return
	 * @throws Exception
	 */

	public static long addMultipleFileEntries(ActionRequest actionRequest, ActionResponse actionResponse, String selectedFileName,
			List<String> validFileNames, List<KeyValuePair> invalidFileNameKVPs) throws Exception {
		
		long fileAttachmentId = 0L;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long userId = PortalUtil.getUserId(actionRequest);
		
		long groupId = PortalUtil.getScopeGroupId(actionRequest);
		
		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId",groupId);
		
		String contentType = MimeTypesUtil.getContentType(selectedFileName);
		String description = ParamUtil.getString(actionRequest, "description",StringPool.BLANK);
		String changeLog = ParamUtil.getString(actionRequest, "changeLog",StringPool.BLANK);
		
		InputStream inputStream = null;
		
		String tempFileName = TempFileUtil.getTempFileName(themeDisplay.getUserId(), selectedFileName, TTHCConstants.DEFAULT_TTHC_FILE_ATTACHMENT_TEMP_FOLDER_NAME);		 		
		try {
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			//Ten folder chua cac file dinh kem cua TTHC luu trong preferences,Mac dinh la "THU TUC HANH CHINH"
			String parentFolderName = preferences.getValue("folderName", TTHCConstants.DEFAULT_TTHC_FILE_ATTACHMENT_FOLDER_NAME);
			
			long parentFolderId = GetterUtil.getLong(preferences.getValue("tthcAttachmentFolderId", "0"));
			
			if(parentFolderId == 0){
				
				ServiceContext folderServiceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folderServiceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				parentFolderId = TTHCFileAttachmentUtil.createAttachmentFolder(userId, groupId, repositoryId, 
					TTHCConstants.DL_ROOT_FOLDER_ID, parentFolderName, folderServiceContext);
			}
			
			long folderId = parentFolderId;
			
			boolean autoCreateSubFolder = GetterUtil.getBoolean(preferences.getValue("autoCreateSubFolder", "true"));
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);			
			//Add quyen xem,download file cho Guest
			serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
			
			if(autoCreateSubFolder){
				
				long counterValue = CounterLocalServiceUtil.increment();
				
				//Ten folder trung voi ma so thu tuc
				String folderName = ParamUtil.getString(actionRequest, "entryCode", String.valueOf(counterValue));
				
				folderId = createAttachmentFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 
															repositoryId, parentFolderId, folderName, serviceContext);																
			}
			
			if(checkExistFileEntry(themeDisplay.getScopeGroupId(), folderId, selectedFileName)){			
				
				String selectedFileNamePrefix = String.valueOf(CounterLocalServiceUtil.increment()) + StringPool.UNDERLINE;
				
				selectedFileName = selectedFileNamePrefix + selectedFileName;
			}
			
			inputStream = TempFileUtil.getTempFileAsStream(tempFileName);
			
			long size = TempFileUtil.getTempFileSize(tempFileName);
				
			FileEntry fileAttachment = DLAppServiceUtil.addFileEntry(repositoryId, folderId, selectedFileName, contentType,
							selectedFileName, description, changeLog, inputStream, size,serviceContext);
			
			if(fileAttachment != null){
				
				fileAttachmentId = fileAttachment.getFileEntryId();
			}
			
			validFileNames.add(selectedFileName);

		} catch (SystemException e){
			
			String errorMessage = getAddMultipleFileEntriesErrorMessage(themeDisplay, e);

			invalidFileNameKVPs.add(new KeyValuePair(selectedFileName, errorMessage));
			
			_log.error(e);
			
		} finally {
			StreamUtil.cleanUp(inputStream);
			TempFileUtil.deleteTempFile(tempFileName);
		}
		
		return fileAttachmentId;
	}

	/**
	 * 
	 * @todo TAO FOLDER LUU VAN BAN DINH KEM
	 * @author HungDX	
	 * @date Jul 3, 2012
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

		long attachmentFolderId = TTHCConstants.DL_ROOT_FOLDER_ID;
		
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
	 * 
	 * @todo KIEM TRA TRUNG LAP FILE
	 * @author HungDX	
	 * @date Jul 3, 2012
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
				System.out.println(e.getClass().getName());
			}else if (e instanceof NoSuchFileEntryException) {
			}		
			else{
				_log.error(e);
				e.printStackTrace();
			}
			return false;
		}
		
		return true;
	}
	

	/**
	 * 
	 * @todo KIEM TRA TRUNG LAP FOLDER
	 * @author HungDX	
	 * @date Jul 3, 2012
	 * @return boolean
	 * @param groupId
	 * @param parentFolderId
	 * @param folderName
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
	 * @todo GET FILE DINH KEM THEO ID
	 * @author HungDX	
	 * @date Jul 3, 2012
	 * @return DLFileEntry
	 * @param fileEntryId
	 * @return
	 */
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

	private static Log _log = LogFactory.getLog(TTHCFileAttachmentUtil.class);
	
	private static final String STATIC_CACHE_DIR_PROPERTY_KEY = "static.cache.dir";
	private static final String DOCUMENT_CACHE_FOLDER_NAME = "documents";
}
