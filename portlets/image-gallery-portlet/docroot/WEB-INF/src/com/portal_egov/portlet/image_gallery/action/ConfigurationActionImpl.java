package com.portal_egov.portlet.image_gallery.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

/**
 * 
 * @author HungDX
 *
 */

public class ConfigurationActionImpl extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			long selectedImageFolderId = ParamUtil.getLong(actionRequest, "selectedImageFolderId",DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
			
			int numbersOfImageDisplay = ParamUtil.getInteger(actionRequest, "numbersOfImageDisplay",DEFAULT_NUMBERS_OF_IMG_DISPLAY);
			
			boolean useThumbnailImage = ParamUtil.getBoolean(actionRequest, "useThumbnailImage",true);
			
			boolean useCustomImageSize = ParamUtil.getBoolean(actionRequest, "useCustomImageSize",false);
			
			if(useCustomImageSize){
				
				int imageThumbnailWidth = ParamUtil.getInteger(actionRequest, "imageThumbnailWidth",DEFAULT_IMAGE_THUMBNAIL_MAX_WIDTH);
				
				int imageThumbnailHeight = ParamUtil.getInteger(actionRequest, "imageThumbnailHeight",DEFAULT_IMAGE_THUMBNAIL_MAX_HEIGHT);
				
				preferences.setValue("useCustomImageSize", String.valueOf(useCustomImageSize));
				preferences.setValue("imageThumbnailWidth", String.valueOf(imageThumbnailWidth));
				preferences.setValue("imageThumbnailHeight", String.valueOf(imageThumbnailHeight));
			}
			
			boolean displayGalleryLink = ParamUtil.getBoolean(actionRequest, "displayGalleryLink",true);
			
			if(displayGalleryLink){
				
				long galleryPageId = ParamUtil.getLong(actionRequest, "galleryPageId",DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
				
				preferences.setValue("galleryPageId", String.valueOf(galleryPageId));
			}
			
			preferences.setValue("displayGalleryLink", String.valueOf(displayGalleryLink));
			preferences.setValue("useThumbnailImage", String.valueOf(useThumbnailImage));
			preferences.setValue("selectedImageFolderId", String.valueOf(selectedImageFolderId));
			preferences.setValue("numbersOfImageDisplay", String.valueOf(numbersOfImageDisplay));
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();								
			}

			if(SessionErrors.isEmpty(actionRequest)){
												
				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
		
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/config/configuration.jsp";
	}
	
	private static final int DEFAULT_NUMBERS_OF_IMG_DISPLAY = 5;
	
	private static final int DEFAULT_IMAGE_THUMBNAIL_MAX_WIDTH = 260;
	
	private static final int DEFAULT_IMAGE_THUMBNAIL_MAX_HEIGHT = 140;
}