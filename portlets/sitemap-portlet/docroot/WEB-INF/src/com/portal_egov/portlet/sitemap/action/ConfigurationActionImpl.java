package com.portal_egov.portlet.sitemap.action;

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
			
			long rootLayoutId = ParamUtil.getLong(actionRequest, "rootLayoutId",0L);
			
			boolean expandAllLayout = ParamUtil.getBoolean(actionRequest, "expandAllLayout",false);
			
			boolean highLightCurrentLayout = ParamUtil.getBoolean(actionRequest, "highLightCurrentLayout",true);
			
			preferences.setValue("rootLayoutId", String.valueOf(rootLayoutId));
			preferences.setValue("expandAllLayout", String.valueOf(expandAllLayout));
			preferences.setValue("highLightCurrentLayout", String.valueOf(highLightCurrentLayout));
			
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
		return "/html/configuration.jsp";
	}
}