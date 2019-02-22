package com.portal_egov.portlet.compaints.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.AssetCategoryException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.portal_egov.portlet.compaints.ComplaintsAdminPortlet;
import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;
import com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil;

public class FileAttachmentUtil {
	
	public static List<DLFileEntry> getComplaintFileAttachments(long complaintId){
		
		List<DLFileEntry> fileAtachmentList = new ArrayList<DLFileEntry>();
		
		try {
			
			List<Complaint_DlFileEntries> complaintDLFileList = Complaint_DlFileEntriesLocalServiceUtil.findByComplaint(complaintId);
			
			for(Complaint_DlFileEntries complaintDLFile : complaintDLFileList){
				
				long dlFileEntryId = complaintDLFile.getFileEntryId();
				
				DLFileEntry fileAttachment = DLFileEntryLocalServiceUtil.getDLFileEntry(dlFileEntryId);
				
				if(fileAttachment != null){
					
					fileAtachmentList.add(fileAttachment);
				}
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		return fileAtachmentList;
	}
	
	public static String createAttachmentDownloadLink(DLFileEntry dlFileEntry,ThemeDisplay themeDisplay){
		
		String fileAttachmentDownloadLink = "";
		
		try {
						
			long folderId = dlFileEntry.getFolderId();
			
			String fileTitle = dlFileEntry.getTitle();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append(themeDisplay.getPortalURL());
			stringBuilder.append(themeDisplay.getPathContext());
			stringBuilder.append("/documents/");
			stringBuilder.append(themeDisplay.getScopeGroupId());
			stringBuilder.append(StringPool.SLASH);
			stringBuilder.append(folderId);
			stringBuilder.append(StringPool.SLASH);			
			stringBuilder.append(HttpUtil.encodeURL(fileTitle, true));
			
			fileAttachmentDownloadLink = stringBuilder.toString();
			
		} catch (Exception e) {
			_log.error(e);
		}
		return fileAttachmentDownloadLink;
	}
	

	public static long addMultipleFileEntries(ActionRequest actionRequest, ActionResponse actionResponse, String selectedFileName,
			List<String> validFileNames, List<KeyValuePair> invalidFileNameKVPs) throws Exception {

		long fileAttachmentId = 0L;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long repositoryId = ParamUtil.getLong(actionRequest, "repositoryId");
		
		String contentType = MimeTypesUtil.getContentType(selectedFileName);
		String description = ParamUtil.getString(actionRequest, "description");
		String changeLog = ParamUtil.getString(actionRequest, "changeLog");
		
		File file = null;
				 		
		try {
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);			
			//Add quyen xem,download file cho Guest
			serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
			
			//So hieu VBPQ
			long folderId = createAttachmentFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),repositoryId, 0, "KNTC", serviceContext);																
			
			if(checkExistFileEntry(themeDisplay.getScopeGroupId(), folderId, selectedFileName)){			
				
				String selectedFileNamePrefix = String.valueOf(CounterLocalServiceUtil.increment()) + StringPool.UNDERLINE;
				
				selectedFileName = selectedFileNamePrefix + selectedFileName;
			}
			
			String tempFileName = TempFileUtil.getTempFileName(themeDisplay.getUserId(), selectedFileName, _TEMP_FOLDER_NAME);
			
			file = new File(tempFileName);
			
			FileEntry fileAttachment = DLAppServiceUtil.addFileEntry(repositoryId, folderId, selectedFileName, contentType, selectedFileName
																		,description,changeLog,file,serviceContext);
			
			if(fileAttachment != null){
				
				fileAttachmentId = fileAttachment.getFileEntryId();
			}
			
			validFileNames.add(selectedFileName);

		} catch (Exception e) {
			
			_log.error(e);
			
			String errorMessage = getAddMultipleFileEntriesErrorMessage(themeDisplay, e);

			invalidFileNameKVPs.add(new KeyValuePair(selectedFileName, errorMessage));
			
		} finally {
			FileUtil.delete(file);
		}
		
		return fileAttachmentId;
	}

	
	public static long createAttachmentFolder(long userId,long groupId,long repositoryId, long parentFolderId,
													String folderName,ServiceContext serviceContext){

		long attachmentFolderId = 0;
		
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
			
			_log.error(e);
			
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
				
				fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileName);
				
				if(fileEntry == null){
					
					return false;
				}
			}
		}
		catch (Exception e) {
			
			_log.error(e);
			return false;
		}
		
		return true;
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

	private static final String _TEMP_FOLDER_NAME = ComplaintsAdminPortlet.class.getName();
	private static Log _log = LogFactory.getLog(FileAttachmentUtil.class);
}
