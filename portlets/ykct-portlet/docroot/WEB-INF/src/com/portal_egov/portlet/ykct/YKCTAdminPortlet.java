package com.portal_egov.portlet.ykct;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
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
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
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
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.DuplicateFolderNameException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil;
import com.portal_egov.portlet.ykct.service.YKCT_DlFileEntriesLocalServiceUtil;
import com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil;
import com.portal_egov.portlet.ykct.util.FileAttachmentUtil;
import com.portal_egov.portlet.ykct.model.YKCT_Category;
import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;
import com.portal_egov.portlet.ykct.model.YKCT_Entry;
import com.portal_egov.portlet.ykct.permission.YKCTCategoryPermission;
import com.portal_egov.portlet.ykct.permission.YKCTEntryPermission;

/**
 * Portlet implementation class YKCTAdminPortlet
 */
public class YKCTAdminPortlet extends MVCPortlet {
	
	public void savePortletConfig(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long userId = PortalUtil.getUserId(actionRequest);
			
			long scopeGroupId = PortalUtil.getScopeGroupId(actionRequest);
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			long ykctAttachmentFolderId = ParamUtil.getLong(actionRequest, "ykctAttachmentFolderId", 0L);
			
			String folderName = ParamUtil.getString(actionRequest, "folderName");
			
			if(Validator.isNotNull(folderName)){//Truong hop tao folder moi
				
				long parentFolderId = ParamUtil.getLong(actionRequest, "parentFolderId", 0L);
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				ykctAttachmentFolderId = FileAttachmentUtil.createAttachmentFolder(userId, scopeGroupId, scopeGroupId, parentFolderId, folderName, serviceContext);
			}

			boolean autoCreateSubFolder = ParamUtil.getBoolean(actionRequest, "autoCreateSubFolder", true);

			preferences.setValue("ykctAttachmentFolderId", String.valueOf(ykctAttachmentFolderId));
			preferences.setValue("autoCreateSubFolder", String.valueOf(autoCreateSubFolder));
			
			preferences.store();
									
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			if (e instanceof DuplicateFolderNameException) {				
				_log.error(e);
				SessionErrors.add(actionRequest, "duplicate-folder-name");
			
			}else{
				_log.error(e);
			}			
		}
	}

	
	public void updateYKCTEntry(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);
			
			String[] selectedAttachmentFileNames = ParamUtil.getParameterValues(actionRequest, "selectedFileName", new String[0]);

			if (selectedAttachmentFileNames.length > 0) {// upload attachment files and update YKCT Entry

				YKCT_Entry ykctEntry = updateYKCTContent(actionRequest, actionResponse);
				
				List<Long> ykctFileAttactmentIdList = addFileAttachment(actionRequest, actionResponse);
				
				for (int i = 0; i < ykctFileAttactmentIdList.size(); i++) {

					long ykctDLfileEntryId = CounterLocalServiceUtil.increment();

					YKCT_DlFileEntries ykctDLfileEntry = YKCT_DlFileEntriesLocalServiceUtil.createYKCT_DlFileEntries(ykctDLfileEntryId);

					ykctDLfileEntry.setYkctEntryId(ykctEntry.getEntryId());
					ykctDLfileEntry.setFileEntryId(ykctFileAttactmentIdList.get(i));

					YKCT_DlFileEntriesLocalServiceUtil.updateYKCT_DlFileEntries(ykctDLfileEntry, false);
				}
			}
			else { // Update ykct entry and redirect
				updateYKCTContent(actionRequest, actionResponse);
			}
			
			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	public void deleteYKCTEntry(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			
			long entryId = ParamUtil.getLong(actionRequest, "entryId", 0);

			if(entryId > 0){
				
				YKCT_Entry ykctEntry = YKCT_EntryLocalServiceUtil.getYKCT_Entry(entryId);
				
				if(ykctEntry != null){
					
					//Ma so ykct tuong ung voi ten thu muc chua file dinh kem van ban
					//String entryCode = vbpqEntry.getEntryCode();
					String entryCode = String.valueOf(ykctEntry.getEntryId());
					long groupId = PortalUtil.getScopeGroupId(actionRequest);
					
					PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
					
					long parentFolderId = GetterUtil.getLong(preferences.getValue("ykctAttachmentFolderId", "0"));
					
					if(FileAttachmentUtil.checkExistDLFolder(groupId, parentFolderId, entryCode)){
						
						DLFolder ykctAttachmentDLFolder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, entryCode);
						
						List<FileEntry> ykctFileAttachmentList = DLAppServiceUtil.getFileEntries(groupId, ykctAttachmentDLFolder.getFolderId());
						
						for(FileEntry ykctFileAttachment : ykctFileAttachmentList){
							
							DLAppServiceUtil.deleteFileEntry(ykctFileAttachment.getFileEntryId());
						}
						
						DLAppServiceUtil.deleteFolder(ykctAttachmentDLFolder.getFolderId());
					}
					
					List<YKCT_DlFileEntries> ykctDLFileEntryList = YKCT_DlFileEntriesLocalServiceUtil.findByYKCTEntry(entryId);

					for (int i = 0; i < ykctDLFileEntryList.size(); i++) {

						YKCT_DlFileEntriesLocalServiceUtil.deleteYKCT_DlFileEntries(ykctDLFileEntryList.get(i));
					}

					YKCT_EntryLocalServiceUtil.deleteYKCT_Entry(entryId);
				}
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);

			actionResponse.sendRedirect(redirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
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

			for (String validFileName : validFileNameList){
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("added", Boolean.TRUE);
				jsonObject.put("fileName", validFileName);

				jsonArray.put(jsonObject);
			}

			for (KeyValuePair invalidFileNameKVP : invalidFileNameKVPList){
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
	
	protected YKCT_Entry updateYKCTContent(ActionRequest actionRequest, ActionResponse actionResponse) {

		YKCT_Entry ykctEntry = null;

		try {

			long companyId = PortalUtil.getCompanyId(actionRequest);

			long groupId = PortalUtil.getScopeGroupId(actionRequest);

			long userId = PortalUtil.getUserId(actionRequest);
			
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);

			long entryId = ParamUtil.getLong(actionRequest, "entryId", 0);

			String entryName = ParamUtil.getString(actionRequest, "entryName", StringPool.BLANK);

			String entryDesc = ParamUtil.getString(actionRequest, "entryDesc", StringPool.BLANK);

			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0);

			String ykctFileAttachmentURL = ParamUtil.getString(actionRequest, "ykctFileAttachmentURL");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(YKCT_Entry.class.getName(), actionRequest);
			
			serviceContext.setGroupPermissions(new String[] {YKCTEntryPermission.VIEW_YKCT});
			serviceContext.setGuestPermissions(new String[] {YKCTEntryPermission.VIEW_YKCT});
			
			if (entryId <= 0) { // Add new YKCT Entry

				ykctEntry =
					YKCT_EntryLocalServiceUtil.addYKCTEntry(companyId, groupId, userId, userName, entryName, categoryId,
							 serviceContext);
						
			}
			else {// Update YKCT Entry

				ykctEntry =
						YKCT_EntryLocalServiceUtil.updateYKCTEntry(companyId, groupId, userId, userName, entryId, 
								entryName, categoryId, ykctFileAttachmentURL);
			}

		}
		catch (Exception e) {
			_log.error(e);
		}
		return ykctEntry;
	}
	
	public static void addTempAttachment(ActionRequest actionRequest, ActionResponse actionResponse) {

		InputStream inputStream = null;

		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long folderId = ParamUtil.getLong(actionRequest, "folderId", 0);

			String sourceFileName = uploadRequest.getFileName("file").replaceAll(StringPool.COMMA, StringPool.BLANK);
			
			_log.info(sourceFileName);
			
			inputStream = uploadRequest.getFileAsStream("file");

			if (inputStream != null) {

				DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName,
						_TEMP_FOLDER_NAME, inputStream);
			}
			
		}catch (Exception e){
			_log.error(e);
		}finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	public static void deleteTempAttachment(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");

		String fileName = ParamUtil.getString(actionRequest, "fileName");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {

			DLAppServiceUtil.deleteTempFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName, _TEMP_FOLDER_NAME);

			jsonObject.put("deleted", Boolean.TRUE);
		}
		catch (SystemException e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(), "an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
		}

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}
	
	public void deleteFileAttachment(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {

			long ykctFileAttachmentId = ParamUtil.getLong(actionRequest, "ykctFileAttachmentId", 0L);

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL", StringPool.BLANK);

			if (ykctFileAttachmentId > 0) {

				DLFileEntryLocalServiceUtil.deleteDLFileEntry(ykctFileAttachmentId);
				
				List<YKCT_DlFileEntries> ykctDLFileEntriesList = YKCT_DlFileEntriesLocalServiceUtil.findByDLFileEntry(ykctFileAttachmentId);
				
				for(int i = 0; i < ykctDLFileEntriesList.size(); i ++){
					
					YKCT_DlFileEntriesLocalServiceUtil.deleteYKCT_DlFileEntries(ykctDLFileEntriesList.get(i));
				}
			}

			actionResponse.sendRedirect(redirectURL);

		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void updateYKCTCategory(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			String ykctCategoryName = ParamUtil.getString(actionRequest, "ykctCategoryName");
			
			String ykctCategoryDesc = ParamUtil.getString(actionRequest, "ykctCategoryDesc");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(categoryId > 0){//Update category
				
				YKCT_CategoryLocalServiceUtil.updateCategory(companyId, groupId, userId, userName, categoryId, 
						ykctCategoryName, ykctCategoryDesc);
				
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(YKCT_Category.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {YKCTCategoryPermission.VIEW_CATEGORY});
				serviceContext.setGuestPermissions(new String[] {YKCTCategoryPermission.VIEW_CATEGORY});
				
				YKCT_CategoryLocalServiceUtil.addCategory(companyId, groupId, userId, 
						userName, ykctCategoryName, ykctCategoryDesc, serviceContext);
				
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void deleteYKCTCategory(ActionRequest actionRequest, ActionResponse actionResponse){
		try {
			
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId",0L);
			
			boolean deleteYKCT_Entry = ParamUtil.getBoolean(actionRequest, "deleteYKCT_Entry",false);
			
			if(categoryId > 0){
				
				YKCT_CategoryLocalServiceUtil.deleteCategory(categoryId, deleteYKCT_Entry);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	private static Log _log = LogFactory.getLog(YKCTAdminPortlet.class);
	private static final String _TEMP_FOLDER_NAME = YKCTAdminPortlet.class.getName();
}
