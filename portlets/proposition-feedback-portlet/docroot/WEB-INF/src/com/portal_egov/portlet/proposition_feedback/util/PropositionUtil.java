/**
 * @author HungDX
 * @time 2:23:34 PM
 * @project proposition_feedback-portlet
 */
package com.portal_egov.portlet.proposition_feedback.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.portlet.ActionRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;
import com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil;


public class PropositionUtil {

	/**
	 * @todo LAY TIEU DE TRANG THAI CUA GOP Y DU THAO LUAT
	 * @author HungDX	
	 * @date Aug 28, 2012
	 * @return String
	 * @param feedback
	 * @return
	 */
	public static String getFeedbackStatusTitle(PropositionFeedback feedback){
		
		String feedbackStatusTitle = "undefined";
		
		if(feedback != null){
			
			int feedbackStatus = feedback.getStatus();
			
			if(feedbackStatus == PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE){
				
				feedbackStatusTitle = "unpublish-feedback";
			}else if(feedbackStatus == PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE){
				
				feedbackStatusTitle = "publish-feedback";
			}
		}
		
		return feedbackStatusTitle;
	}
	
	/**
	 * @todo LAY TRANG THAI CUA DU THAO LUAT
	 * @author HungDX	
	 * @date Aug 3, 2012
	 * @return String
	 * @param propositionId Id cua du thao
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static String getPropositionStatusTitle(long propositionId) throws PortalException, SystemException{
		
		String propositionStatusTitle = "undefined";
		
		if(propositionId > 0){
			
			Proposition proposition = PropositionLocalServiceUtil.getProposition(propositionId);
			
			if(proposition != null){
				
				int propositionStatusValue = proposition.getStatus();
				
				if(propositionStatusValue == PropositionConstants.PUBLISH_PROPOSITION_STATUS_VALUE){
				
					propositionStatusTitle = "publish-proposition";
				}else if(propositionStatusValue == PropositionConstants.UNRELEASE_PROPOSITION_STATUS_VALUE){
					
					propositionStatusTitle = "unrelease-proposition";
				}else if(propositionStatusValue == PropositionConstants.RELEASED_PROPOSITION_STATUS_VALUE){
					
					propositionStatusTitle = "released-proposition";
				}else{
					
					propositionStatusTitle = "unpublish-proposition";
				}
			}
		}
		return propositionStatusTitle;
	}
	
	/**
	 * @todo TODO
	 * @author HungDX	
	 * @date Aug 4, 2012
	 * @return DLFileEntry
	 * @param docFileId
	 * @return
	 */
	public static DLFileEntry getDocFileEntry(long docFileId){
		
		try {
			DLFileEntry docFileEntry = null;
			
			if(docFileId > 0){
				docFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(docFileId);
			}
			return docFileEntry;
		}
		catch (Exception e) {
			if(e instanceof NoSuchFileEntryException){
				
			}else{
				_log.error(e);
			}
			return null;
		}
	}
	
	/**
	 * @todo TAO DUONG DAN DOWNLOAD FILE VAN BAN GOC CUA DU THAO LUAT
	 * @author HungDX	
	 * @date Aug 3, 2012
	 * @return String
	 * @param dlFileEntry
	 * @param themeDisplay
	 * @return
	 */
	public static String getPropositionDocFileDownloadLink(long fileEntryId,ThemeDisplay themeDisplay){
		
		String fileAttachmentDownloadLink = "";
		
		if(fileEntryId > 0){
			try {
				
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
				
				if(dlFileEntry != null){
					
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
				}
				
			} catch (Exception e) {
				_log.error(e);
			}
		}
		return fileAttachmentDownloadLink;
	}
	
	
	/**
	 * @todo UPLOAD FILE VAN BAN GOC CUA DU THAO PHAP LUAT
	 * @author HungDX	
	 * @date Aug 3, 2012
	 * @return long
	 * @param actionRequest
	 * @param fileParamName Name cua the input file trong form add/update du thao luat
	 * @param folderName Ten folder muon upload
	 * @return
	 */
	public static long uploadPropositionDocFile(UploadPortletRequest uploadRequest, ActionRequest actionRequest,String fileParamName,String folderName){
		
		long fileEntryId = 0;
		
						
		FileEntry fileEntry = null;
		
		try {
			long userId = PortalUtil.getUserId(actionRequest);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			long groupId = themeDisplay.getScopeGroupId();
			
			//UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			InputStream inputStream = uploadRequest.getFileAsStream(fileParamName);
			
			String mimeType = uploadRequest.getContentType(fileParamName);
								
			long fileUploadSize = uploadRequest.getSize(fileParamName);
			
			
			String sourceFileName = uploadRequest.getFileName(fileParamName);
							
			String changeLog = "upload-proposition-document-file";
																	
			long repositoryId = ParamUtil.getLong(uploadRequest, "repositoryId",groupId);
			
			ServiceContext fileServiceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			
			fileServiceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
			fileServiceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
			
			long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			
			//Kiem tra trung lap folder
			if(checkExistDLFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName)){
				
				DLFolder uploadFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
				
				folderId = uploadFolder.getFolderId();
				
			}else {
				ServiceContext folderServiceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				
				folderServiceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
				folderServiceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				DLFolder uploadFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, repositoryId, false, 
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName, "", folderServiceContext);
				
				folderId = uploadFolder.getFolderId();
			}
			
			//Kiem tra trung lap ten file
			if(checkExistFileEntry(groupId, folderId, sourceFileName)){//CHua ton tai file

				fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folderId, sourceFileName,mimeType, sourceFileName, 
															sourceFileName, changeLog, inputStream, fileUploadSize, fileServiceContext);
			}else{//da ton tai file
				
				String fileNameExtension = String.valueOf(Calendar.getInstance().get(Calendar.MILLISECOND));
				
				String fileName = fileNameExtension + sourceFileName;
				
				fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folderId, sourceFileName,mimeType, fileName, 
															sourceFileName, changeLog, inputStream, fileUploadSize, fileServiceContext);
			}
			
			if(fileEntry !=null){
				fileEntryId = fileEntry.getFileEntryId();
			}
															
		} catch (PortalException e) {
			if(e instanceof NoSuchFileEntryException){
			}else{
				_log.error(e);
			}
		}
		catch (SystemException e) {
			_log.error(e);
		}
		catch (IOException e) {
			_log.error(e);
		}
		return fileEntryId;
	}

	
	/**
	 * @todo KIEM TRA TON TAI CUA FILE THEO GROUP,ID CUA FOLDER VA TEN FILE
	 * @author HungDX	
	 * @date Aug 3, 2012
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
	
	/**
	 * @todo KIEM TRA SU TON TAI CUA FOLDER THEO GROUP,ID CUA FOLDER CHA VA TEN FOLDER
	 * @author HungDX	
	 * @date Aug 3, 2012
	 * @return boolean
	 * @param groupId
	 * @param parentFolderId
	 * @param folderName
	 * @return
	 */
	private static boolean checkExistDLFolder(long groupId,long parentFolderId,String folderName){
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
		} catch(Exception e) {
			
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
	
	private static Log _log = LogFactory.getLog(PropositionUtil.class);
}
