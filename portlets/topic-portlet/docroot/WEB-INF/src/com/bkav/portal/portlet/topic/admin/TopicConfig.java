package com.bkav.portal.portlet.topic.admin;

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

public class TopicConfig extends DefaultConfigurationAction  {
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			String numberTopicDisplay= ParamUtil.getString(actionRequest, "numberTopicDisplay","5");
			
			boolean showAllTopic = ParamUtil.getBoolean(actionRequest, "showAllTopic");
			
			if(showAllTopic){
				numberTopicDisplay = "0";
			}
			
			String allTopicUrl = ParamUtil.getString(actionRequest, "allTopicUrl","/chuyen-de");
			
			String topicStyle = ParamUtil.getString(actionRequest, "topicStyle","small");
			
			String topicPageLayoutId = ParamUtil.getString(actionRequest, "topicPageLayoutId");
			
			preferences.setValue("numberTopicDisplay", numberTopicDisplay);
			
			preferences.setValue("allTopicUrl", allTopicUrl);
			
			preferences.setValue("topicStyle", topicStyle);
			
			preferences.setValue("topicPageLayoutId", topicPageLayoutId);
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
			
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
		
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/topic/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(TopicConfig.class);
}
