package com.portal_egov.portlet.contacts.action;

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
			
			boolean showDepartmentOnly = ParamUtil.getBoolean(actionRequest, "showDepartmentOnly",true);
			
			boolean showEmptyDepartment = ParamUtil.getBoolean(actionRequest, "showEmptyDepartment",true);
			
			boolean showDepartmentInfo = ParamUtil.getBoolean(actionRequest, "showDepartmentInfo",true);
			
			long defaultDepartmentId = ParamUtil.getLong(actionRequest, "defaultDepartmentId", 0L);
			
			preferences.setValue("showDepartmentOnly", String.valueOf(showDepartmentOnly));
			preferences.setValue("showEmptyDepartment", String.valueOf(showEmptyDepartment));
			preferences.setValue("showDepartmentInfo", String.valueOf(showDepartmentInfo));
			preferences.setValue("defaultDepartmentId", String.valueOf(defaultDepartmentId));
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
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
		return "/html/contacts/configuration.jsp";
	}
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
}