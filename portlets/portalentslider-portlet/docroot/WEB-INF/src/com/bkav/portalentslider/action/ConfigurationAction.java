package com.bkav.portalentslider.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bkav.portalentslider.util.SliderUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;


public class ConfigurationAction extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		
		String portletInstanceNS = StringPool.UNDERLINE + portletResource + StringPool.UNDERLINE;
		
		//String[] fileEntriesIds = StringUtil.split(ParamUtil.getString(actionRequest, "fileEntriesIds", StringPool.BLANK));
		
		long[] fileIds = ParamUtil.getLongValues(actionRequest, portletInstanceNS + "fileId", null);
		
		//String[] selectedImageIds = new String[]{};
		
		String sliderId = ParamUtil.getString(actionRequest, "sliderId", "0"); 
		
		String sliderStyle = ParamUtil.getString(actionRequest, "sliderStyle", "style1"); 
		
		int sliderWidth = ParamUtil.getInteger(actionRequest, "sliderWidth", 600);
		
		int sliderHeight = ParamUtil.getInteger(actionRequest, "sliderHeight", 300);
		
		/*boolean auto = ParamUtil.getBoolean(actionRequest, "auto", true);*/
		
		int duration = ParamUtil.getInteger(actionRequest, "duration", 1000);
		
		int durationTimeout = ParamUtil.getInteger(actionRequest, "durationTimeout", 1000);
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		try {
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			if(fileIds != null){
				
				for(int i = 0; i < fileIds.length; i++){
					
					String url =  ParamUtil.getString(actionRequest, portletInstanceNS + fileIds[i] + "_redirectURL",  StringPool.BLANK);
					
					JSONObject json = JSONFactoryUtil.createJSONObject();
					
					json.put("imageId", fileIds[i]);
					
					json.put("url", url);
					
					jsonArray.put(json);
					
				}
			}
			
			
			/*if(fileEntriesIds != null){
				for(String entryId:fileEntriesIds){
					boolean selected = ParamUtil.getBoolean(actionRequest, entryId, false);
					if(selected){
						selectedImageIds = ArrayUtil.append(selectedImageIds, entryId);
					}
				}
			}*/
			
			//preferences.setValues("imageIds", selectedImageIds);
			
			preferences.setValue("sliderId", String.valueOf(sliderId));
			
			preferences.setValue("sliderStyle", String.valueOf(sliderStyle));
			
			preferences.setValue("sliderWidth", String.valueOf(sliderWidth));
			
			preferences.setValue("sliderHeight", String.valueOf(sliderHeight));
			
			preferences.setValue("sliderItems", jsonArray.toString());
			
			/*preferences.setValue("auto", String.valueOf(auto));*/
			
			preferences.setValue("duration", String.valueOf(duration));
			
			preferences.setValue("durationTimeout", String.valueOf(durationTimeout));

			preferences.store();
			
			SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
		
	}
	
	
	public List<String> uploadImages(ActionRequest actionRequest, String[] selectedFileNames){
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		
		long repositoryId = themeDisplay.getScopeGroupId();
		
		List<String> imageIds = null;
		
		if(selectedFileNames == null || selectedFileNames.length == 0){
			return imageIds;
		}
		
		imageIds = new ArrayList<String>();
		
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
				
				FileEntry fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folderId, sourceFileName, contentType, title,
						StringPool.BLANK, StringPool.BLANK, inputStream, size, serviceContext);
				
				imageIds.add(String.valueOf(fileEntry.getFileEntryId()));

			}
			catch (Exception e) {
				 
				_log.error(e);
				continue;

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
		
		return imageIds;
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/client/configuration.jsp";
	}
	
	private static Log _log = LogFactory.getLog(ConfigurationAction.class);
}