package com.bkav.portal.portlet.videoimage;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

public class VideoImageConfiguration extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		try {
			
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			//Luu cau hinh video
			String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
			
			long categoryId = ParamUtil.getLong(actionRequest, "videoCategory", -1);
			
			String styleTitle = ParamUtil.getString(actionRequest, "styleTitle");
			
			int numbersOfVideoDisplay = ParamUtil.getInteger(actionRequest, "numbersOfVideoDisplay");
			
			boolean useCustomVideoFrameSize = ParamUtil.getBoolean(actionRequest, "useCustomVideoFrameSize",false);
			
			if(useCustomVideoFrameSize){
				
				int videoFrameHeight = ParamUtil.getInteger(actionRequest, "videoFrameHeight");
				int videoFrameWidth = ParamUtil.getInteger(actionRequest, "videoFrameWidth");
				
				preferences.setValue("videoFrameHeight", String.valueOf(videoFrameHeight));
				preferences.setValue("videoFrameWidth", String.valueOf(videoFrameWidth));
			}
			
			boolean showVideoThumbnail = ParamUtil.getBoolean(actionRequest, "showVideoThumbnail",false);
			
			boolean showVideoPublishDate = ParamUtil.getBoolean(actionRequest, "showVideoPublishDate",false);
			
			boolean showViewMoreVideoLink = ParamUtil.getBoolean(actionRequest, "showViewMoreVideoLink",true);
			
			if(showViewMoreVideoLink){
				
				long videoPageLayoutId = ParamUtil.getLong(actionRequest, "videoPageLayoutId");
				
				preferences.setValue("videoPageLayoutId", String.valueOf(videoPageLayoutId));
			}
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("styleTitle", styleTitle);
			preferences.setValue("numbersOfVideoDisplay", String.valueOf(numbersOfVideoDisplay));
			preferences.setValue("useCustomVideoFrameSize", String.valueOf(useCustomVideoFrameSize));
			preferences.setValue("showVideoThumbnail", String.valueOf(showVideoThumbnail));
			preferences.setValue("showVideoPublishDate", String.valueOf(showVideoPublishDate));
			preferences.setValue("showViewMoreVideoLink", String.valueOf(showViewMoreVideoLink));
			preferences.setValue("categoryId", String.valueOf(categoryId));
			
			//Luu cau hinh image gallery
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
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
			
		}
		catch (Exception e)
		{
			_log.error(e);
		}
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/config.jsp";
	}
	private static Log _log = LogFactory.getLog(VideoImageConfiguration.class);
	
	private static final int DEFAULT_NUMBERS_OF_IMG_DISPLAY = 5;
	
	private static final int DEFAULT_IMAGE_THUMBNAIL_MAX_WIDTH = 260;
	
	private static final int DEFAULT_IMAGE_THUMBNAIL_MAX_HEIGHT = 140;
}
