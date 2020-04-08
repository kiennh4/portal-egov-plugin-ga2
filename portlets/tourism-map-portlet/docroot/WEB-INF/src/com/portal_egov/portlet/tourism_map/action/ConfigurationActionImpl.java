package com.portal_egov.portlet.tourism_map.action;

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
			
			String mapAPIKey = ParamUtil.getString(actionRequest, "mapAPIKey");
			
			String defaultMapType = ParamUtil.getString(actionRequest, "defaultMapType");
			
			int defaultZoomLevel = ParamUtil.getInteger(actionRequest, "defaultZoomLevel");
			
			String mapCenterLatitude = ParamUtil.getString(actionRequest, "mapCenterLatitude");
			
			String mapCenterLongitude = ParamUtil.getString(actionRequest, "mapCenterLongitude");
			
			preferences.setValue("mapAPIKey", mapAPIKey);
			preferences.setValue("defaultMapType", defaultMapType);
			preferences.setValue("defaultZoomLevel", String.valueOf(defaultZoomLevel));
			preferences.setValue("mapCenterLatitude", mapCenterLatitude);
			preferences.setValue("mapCenterLongitude", mapCenterLongitude);
			
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
		return "/html/view/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}