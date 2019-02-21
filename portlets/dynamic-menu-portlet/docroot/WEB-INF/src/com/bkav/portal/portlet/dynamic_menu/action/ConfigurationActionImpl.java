package com.bkav.portal.portlet.dynamic_menu.action;


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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

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

			String displayStyle = ParamUtil.getString(actionRequest,"displayStyle",StringPool.BLANK);
			
			long selectedMenuId = ParamUtil.getLong(actionRequest, "selectedMenuId");
			
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("selectedMenuId", String.valueOf(selectedMenuId));
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() 
						+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName(), e);
		}
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/configuration.jsp";
	}
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class.getName());	
}