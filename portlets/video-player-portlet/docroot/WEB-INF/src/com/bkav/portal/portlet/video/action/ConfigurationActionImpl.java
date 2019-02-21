package com.bkav.portal.portlet.video.action;

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


public class ConfigurationActionImpl extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
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
			
			if(SessionErrors.isEmpty(actionRequest)){
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
			
		}catch(Exception e){
			_log.error(e);
		}
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/view/config.jsp";
	}
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}