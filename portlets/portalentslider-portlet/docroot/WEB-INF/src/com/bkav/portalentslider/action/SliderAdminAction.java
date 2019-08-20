package com.bkav.portalentslider.action;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bkav.portalentslider.util.SliderUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SliderAdminAction
 */
public class SliderAdminAction extends MVCPortlet {
	
	public void addTempImages(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		InputStream inputStream = null;

		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		long groupId = themeDisplay.getScopeGroupId();

		String fileName = StringPool.BLANK;

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		boolean result = true;

		try {
			String sourceFileName = request.getParameter("fileName");

			inputStream = request.getInputStream();

			if (inputStream != null) {

				String ext = FileUtil.getExtension(sourceFileName);

				sourceFileName = String.valueOf(System.currentTimeMillis());

				if (Validator.isNotNull(ext)) {
					sourceFileName += StringPool.PERIOD + ext;
				}

				fileName = DLAppServiceUtil.addTempFileEntry(groupId, folderId,
						sourceFileName, SliderUtil._TEMP_FOLDER_NAME, inputStream);
				
				
			}

		} catch (Exception e) {
			String errorMessage = StringPool.BLANK;

			if (e instanceof DuplicateFileException) {
				errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
						"please-enter-a-unique-image-name");
			} else if (e instanceof FileNameException) {
				errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
						"please-enter-a-file-with-a-valid-file-name");
			}

			if (Validator.isNull(errorMessage)) {
				errorMessage = LanguageUtil
						.get(themeDisplay.getLocale(),
								"an-unexpected-error-occurred-while-uploading-the-image");
			}

			_log.error(e);
			result = false;
			jsonObject.put("errorMessage", errorMessage);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}

		jsonObject.put("success", result);

		jsonObject.put("responseFileName", fileName);

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}
	
	
	public void deleteTempImage(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String tempFileName = ParamUtil.getString(actionRequest, "fileName");
		
		long userId = themeDisplay.getUserId();
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {
			
			String tempFilePath = TempFileUtil.getTempFileName(userId, tempFileName, SliderUtil._TEMP_FOLDER_NAME);

			TempFileUtil.deleteTempFile(tempFilePath);
			
			jsonObject.put("deleted", Boolean.TRUE);
		} catch (Exception e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
					"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
		}

		HttpServletResponse response = PortalUtil
				.getHttpServletResponse(actionResponse);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		ServletResponseUtil.write(response, jsonObject.toString());
	}


	public void deleteTempImages(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		
		String resourceNamespace = ParamUtil.getString(actionRequest, "resourceNamespace");

		String fileName = ParamUtil.getString(actionRequest, resourceNamespace + "fileName");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		try {

			DLAppServiceUtil.deleteTempFileEntry(
					themeDisplay.getScopeGroupId(), folderId, fileName, SliderUtil._TEMP_FOLDER_NAME);

			jsonObject.put("deleted", Boolean.TRUE);
			SliderUtil.writeJSON(actionRequest, actionResponse, jsonObject);
		} catch (Exception e) {
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
					"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
			
			SliderUtil.writeJSON(actionRequest, actionResponse, jsonObject);
		}

		
	}
	
	public void deleteFileEntry(ActionRequest actionRequest, ActionResponse actionResponse){
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		try{
			
			long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");
			DLAppServiceUtil.deleteFileEntry(fileEntryId);
			
		}catch (Exception e) {
			_log.error(e);
			
		}finally{
			if(Validator.isNotNull(redirect)){
				try {
					actionResponse.sendRedirect(redirect);
				} catch (IOException e) {
					_log.error(e);
				}
			}
		}
	}
	
	public void deleteSliderImage(ActionRequest actionRequest, ActionResponse actionResponse){
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long fileId = ParamUtil.getLong(actionRequest, "fileId", 0L);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try{
			if(fileId > 0){
				DLAppServiceUtil.deleteFileEntry(fileId);
				jsonObject.put("deleted", Boolean.TRUE);
			}
			
			SliderUtil.writeJSON(actionResponse, jsonObject);
		}catch (Exception e) {
			_log.error(e);
			
			String errorMessage = LanguageUtil.get(themeDisplay.getLocale(),
					"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put("deleted", Boolean.FALSE);
			jsonObject.put("errorMessage", errorMessage);
			
			SliderUtil.writeJSON( actionResponse, jsonObject);
			
		}
		
	}
	
	public void deleteImages(ActionRequest actionRequest, ActionResponse actionResponse){
		
		String[] selectedIds = StringUtil.split(ParamUtil.getString(actionRequest, "selectedIds", StringPool.BLANK));
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");

		SliderUtil.deleteImages(selectedIds);
		
		if(Validator.isNotNull(redirect)){
			try {
				actionResponse.sendRedirect(redirect);
			} catch (Exception e) {
				
			}
		}
		
	}
	

	public void uploadImages(ActionRequest actionRequest, ActionResponse actionResponse){
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		
		long repositoryId = themeDisplay.getScopeGroupId();
		
		String[] selectedFileNames = StringUtil.split(ParamUtil.getString(actionRequest, "selectedFileNames", StringPool.BLANK));
		
		for (String selectedFileName : selectedFileNames) {
			
			if(Validator.isNull(selectedFileName)){
				continue;
			}

			String contentType = MimeTypesUtil.getContentType(selectedFileName);
			
			String tempFileName = StringPool.BLANK;
			
			try {
				tempFileName = TempFileUtil.getTempFileName(themeDisplay.getUserId(), selectedFileName, SliderUtil._TEMP_FOLDER_NAME);

				InputStream inputStream = TempFileUtil.getTempFileAsStream(tempFileName);
				
				
				long size = TempFileUtil.getTempFileSize(tempFileName);

				ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);

				serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
				
				serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				String sourceFileName = selectedFileName;

				String title = sourceFileName;
				
				DLAppServiceUtil.addFileEntry(repositoryId, folderId, sourceFileName, contentType, title,
						StringPool.BLANK, StringPool.BLANK, inputStream, size, serviceContext);
				
			}
			catch (Exception e) {
				
				_log.error(e);

			}
			finally {
				if (Validator.isNotNull(tempFileName)) {
					try {
						TempFileUtil.deleteTempFile(tempFileName);
					}
					catch (Exception e) {
						_log.error(e);
					}
				}
			}
		}
	}
	
	public void deleteSlider(ActionRequest actionRequest, ActionResponse actionResponse){
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if(folderId > 0){
			try {
				DLFolderLocalServiceUtil.deleteDLFolder(folderId);
				jsonObject.put("success", SliderUtil._SUCCESS_MSG01_KEY);
				SliderUtil.writeJSON(actionResponse, jsonObject);
			} catch (Exception e) {
				jsonObject.put("error", SliderUtil._ERROR_MSG_KEY);
				SliderUtil.writeJSON(actionResponse, jsonObject);
				_log.error(e);
			}
		}else{
			jsonObject.put("error", SliderUtil._ERROR_MSG_KEY);
			SliderUtil.writeJSON(actionResponse, jsonObject);
			return;
		}
	}
	
	public void updateSlider(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		long repositoryId = themeDisplay.getScopeGroupId();
		long subFolderId = ParamUtil.getLong(actionRequest, "subFolderId");
		
		String sliderName = ParamUtil.getString(actionRequest, "sliderName", StringPool.BLANK);
		String[] selectedFileNames = StringUtil.split(ParamUtil.getString(actionRequest, "selectedFileNames", StringPool.BLANK));
		//String[] selectedIds = StringUtil.split(ParamUtil.getString(actionRequest, "selectedIds", StringPool.BLANK));
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD, StringPool.BLANK);
		
		//SliderUtil.deleteImages(selectedIds);
		
		if(Validator.isNull(sliderName)){
			SessionErrors.add(actionRequest, SliderUtil._ERROR_MSG01_KEY);
			if(Validator.isNotNull(redirect)){
				actionResponse.sendRedirect(redirect);
			}
			return;
		}
		
		if(SliderUtil.checkExistDLFolder(repositoryId, folderId, subFolderId, sliderName)){
			SessionErrors.add(actionRequest, SliderUtil._ERROR_MSG02_KEY);
			if(Validator.isNotNull(redirect)){
				actionResponse.sendRedirect(redirect);
			}
			return;
		}
		
		if(subFolderId <= 0){
			subFolderId = SliderUtil.getFolderId(request, folderId, sliderName);
			
			if(subFolderId <= 0){
				SessionErrors.add(actionRequest, SliderUtil._ERROR_MSG03_KEY);

				if(Validator.isNotNull(redirect)){
					actionResponse.sendRedirect(redirect);
				}
					
				return;
			}
		}else{
			DLFolder dlFolder = SliderUtil.getDLFolder(subFolderId);
			String oldSliderName  = StringPool.BLANK;
			if(dlFolder != null){
				oldSliderName = dlFolder.getName();
			}
			
			if(!sliderName.equals(oldSliderName) && SliderUtil.checkExistDLFolder(repositoryId, folderId, subFolderId, sliderName)){
				SessionErrors.add(actionRequest, SliderUtil._ERROR_MSG02_KEY);
				if(Validator.isNotNull(redirect)){
					actionResponse.sendRedirect(redirect);
				}
				return;
			}else if(!sliderName.equals(oldSliderName) && !SliderUtil.checkExistDLFolder(repositoryId, folderId, subFolderId, sliderName)){
				dlFolder.setName(sliderName);
				DLFolderLocalServiceUtil.updateDLFolder(dlFolder);
			}
		}
		
		for (String selectedFileName : selectedFileNames) {
			
			if(Validator.isNull(selectedFileName)){
				continue;
			}

			String contentType = MimeTypesUtil.getContentType(selectedFileName);
			
			String tempFileName = StringPool.BLANK;
			
			try {
				tempFileName = TempFileUtil.getTempFileName(themeDisplay.getUserId(), selectedFileName, SliderUtil._TEMP_FOLDER_NAME);

				InputStream inputStream = TempFileUtil.getTempFileAsStream(tempFileName);
				
				
				long size = TempFileUtil.getTempFileSize(tempFileName);

				ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);

				serviceContext.setGroupPermissions(new String[] {ActionKeys.VIEW});
				
				serviceContext.setGuestPermissions(new String[] {ActionKeys.VIEW});
				
				String sourceFileName = selectedFileName;

				String title = sourceFileName;
				
				DLAppServiceUtil.addFileEntry(repositoryId, subFolderId, sourceFileName, contentType, title,
						StringPool.BLANK, StringPool.BLANK, inputStream, size, serviceContext);
				
			}
			catch (Exception e) {
				
				_log.error(e);

			}
			finally {
				if (Validator.isNotNull(tempFileName)) {
					try {
						TempFileUtil.deleteTempFile(tempFileName);
					}
					catch (Exception e) {
						_log.error(e);
					}
				}
				
				
			}
		}
		if(cmd.equals(Constants.UPDATE)){
			SessionMessages.add(actionRequest, SliderUtil._SUCCESS_MSG02_KEY);
		}else{
			SessionMessages.add(actionRequest, SliderUtil._SUCCESS_MSG_KEY);
		}

		if(Validator.isNotNull(redirect)){
			actionResponse.sendRedirect(redirect + "&" + Constants.CMD + "=" + cmd);
		}

	}

	private static Log _log = LogFactoryUtil.getLog(SliderAdminAction.class);
}
