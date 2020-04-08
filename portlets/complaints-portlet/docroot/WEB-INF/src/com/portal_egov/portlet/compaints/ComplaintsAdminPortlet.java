package com.portal_egov.portlet.compaints;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.compaints.model.Complaint;
import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;
import com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil;
import com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil;
import com.portal_egov.portlet.compaints.util.FileAttachmentUtil;

/**
 * Portlet implementation class ComplaintsAdmin
 */
public class ComplaintsAdminPortlet extends MVCPortlet {
 
	public void updateComplaint(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			String userName = PortalUtil.getUserName(userId, "Guess");

			long complaintId = ParamUtil.getLong(actionRequest, "complaintId", 0);

			String complaintTitle = ParamUtil.getString(actionRequest, "complaintTitle");
			
			String complaintDescription = ParamUtil.getString(actionRequest, "complaintDescription");
			
			String complaintContent = ParamUtil.getString(actionRequest, "complaintContent");
			
			int complaintStatus = ParamUtil.getInteger(actionRequest, "complaintStatus");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Complaint.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
			serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
			
			Complaint complaint = null;
			
			if(complaintId > 0){
				
				complaint = ComplaintLocalServiceUtil.updateComplaint(complaintId, companyId, groupId, userId, userName,
					complaintTitle, complaintDescription, complaintContent,StringPool.BLANK, complaintStatus, serviceContext);
			
			}else{
				
				complaint = ComplaintLocalServiceUtil.addComplaint(companyId, groupId, userId, userName, complaintTitle,
					complaintDescription, complaintContent,StringPool.BLANK,complaintStatus, serviceContext);
			}
			
			String[] selectedAttachmentFileNames = ParamUtil.getParameterValues(actionRequest, "selectedFileName", new String[0]);
			
			if(selectedAttachmentFileNames.length > 0){//Upload attachment files
				
				List<Long> attachmentFileIdList = addFileAttachment(actionRequest, actionResponse);
				
				for(long attachmentFileId : attachmentFileIdList){
					
					long entryId = CounterLocalServiceUtil.increment();
					
					Complaint_DlFileEntries complaintDLFileEntry = Complaint_DlFileEntriesLocalServiceUtil.createComplaint_DlFileEntries(entryId);
					
					complaintDLFileEntry.setComplaintId(complaint.getComplaintId());
					complaintDLFileEntry.setFileEntryId(attachmentFileId);
					
					Complaint_DlFileEntriesLocalServiceUtil.updateComplaint_DlFileEntries(complaintDLFileEntry);
				}
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			
			_log.error(e);
		}
	}
	
	public void deleteComplaint(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		try {
			
			long complaintId = ParamUtil.getLong(actionRequest, "complaintId", 0);
			
			if(complaintId > 0){
				
				List<Complaint_DlFileEntries> complaintFileAttachmentList = Complaint_DlFileEntriesLocalServiceUtil.findByComplaint(complaintId);
				
				for(Complaint_DlFileEntries fileAttachment : complaintFileAttachmentList){
					
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileAttachment.getFileEntryId());
					
					Complaint_DlFileEntriesLocalServiceUtil.deleteComplaint_DlFileEntries(fileAttachment);
				}
				
				ComplaintLocalServiceUtil.deleteComplaint(complaintId);
			}
		}
		catch (Exception e) {
			
			if(e instanceof NoSuchFileException){
				
			}else{
				_log.error(e);
			}
			
		}
	}

	public void deleteFileAttachment(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long fileAttachmentId = ParamUtil.getLong(actionRequest, "fileAttachmentId", 0L);

			if (fileAttachmentId > 0) {

				DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileAttachmentId);
				
				List<Complaint_DlFileEntries> complaintDLFileList = Complaint_DlFileEntriesLocalServiceUtil.findByDLFile(fileAttachmentId);
				
				for(Complaint_DlFileEntries complaintDLFile : complaintDLFileList){
					
					Complaint_DlFileEntriesLocalServiceUtil.deleteComplaint_DlFileEntries(complaintDLFile);
				}
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void addTempFileAttachment(ActionRequest actionRequest, ActionResponse actionResponse) {

		InputStream inputStream = null;

		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long folderId = ParamUtil.getLong(actionRequest, "folderId", 0);

			String sourceFileName = uploadRequest.getFileName("file");

			inputStream = uploadRequest.getFileAsStream("file");

			if (inputStream != null) {

				DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName, _TEMP_FOLDER_NAME, inputStream);
			}

		}
		catch (Exception e) {
			_log.error(e);
		}
		finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	public void deleteTempAttachment(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {

			long folderId = ParamUtil.getLong(actionRequest, "folderId");

			String fileName = ParamUtil.getString(actionRequest, "fileName");
			
			DLAppServiceUtil.deleteTempFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName, _TEMP_FOLDER_NAME);

			jsonObject.put("deleted", Boolean.TRUE);
		}
		catch (SystemException e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(), "an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
		}
		catch (PortalException e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(), "an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
		}

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}
	
	protected List<Long> addFileAttachment(ActionRequest actionRequest, ActionResponse actionResponse) {

		long fileAttachmentId = 0L;

		List<String> validFileNameList = new ArrayList<String>();

		List<KeyValuePair> invalidFileNameKVPList = new ArrayList<KeyValuePair>();

		List<Long> fileAttachmentIdList = new ArrayList<Long>();

		try {

			String[] selectedFileNames = ParamUtil.getParameterValues(actionRequest, "selectedFileName", new String[0]);

			for (String selectedFileName : selectedFileNames) {

				fileAttachmentId = FileAttachmentUtil.addMultipleFileEntries(actionRequest, actionResponse, selectedFileName, 
																				validFileNameList, invalidFileNameKVPList);

				if (fileAttachmentId > 0) {

					fileAttachmentIdList.add(fileAttachmentId);
				}
			}

			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			for (String validFileName : validFileNameList) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("added", Boolean.TRUE);
				jsonObject.put("fileName", validFileName);

				jsonArray.put(jsonObject);
			}

			for (KeyValuePair invalidFileNameKVP : invalidFileNameKVPList) {
				String fileName = invalidFileNameKVP.getKey();
				String errorMessage = invalidFileNameKVP.getValue();

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("added", Boolean.FALSE);
				jsonObject.put("errorMessage", errorMessage);
				jsonObject.put("fileName", fileName);

				jsonArray.put(jsonObject);
			}

			writeJSON(actionRequest, actionResponse, jsonArray);

		}
		catch (Exception e) {
			_log.error(e);
		}

		return fileAttachmentIdList;
	}
	
	@Override
	protected void writeJSON(PortletRequest portletRequest, ActionResponse actionResponse, Object json)
		throws IOException {

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, json.toString());
	}
	
	private static Log _log = LogFactory.getLog(ComplaintsAdminPortlet.class);
	
	private static final String _TEMP_FOLDER_NAME = ComplaintsAdminPortlet.class.getName();
}
