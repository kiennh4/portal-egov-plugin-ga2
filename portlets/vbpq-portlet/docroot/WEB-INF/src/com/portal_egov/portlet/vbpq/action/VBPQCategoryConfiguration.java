package com.portal_egov.portlet.vbpq.action;

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


/**
 * 
 * @author HungDX
 *
 */

public class VBPQCategoryConfiguration extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			int numbersOfEntriesDisplay = ParamUtil.getInteger(actionRequest, "numbersOfEntriesDisplay",0);
			
			boolean displayVBPQCount = ParamUtil.getBoolean(actionRequest, "displayVBPQCount");
			
			String categoryType = ParamUtil.getString(actionRequest, "categoryType","department");
			
			boolean displayYearRangeStatistic = ParamUtil.getBoolean(actionRequest, "displayYearRangeStatistic");
			
			int yearRange = ParamUtil.getInteger(actionRequest, "yearRange",3);
			
			preferences.setValue("categoryType", categoryType);
			preferences.setValue("numbersOfEntriesDisplay", String.valueOf(numbersOfEntriesDisplay));
			preferences.setValue("displayVBPQCount", String.valueOf(displayVBPQCount));
			preferences.setValue("displayYearRangeStatistic", String.valueOf(displayYearRangeStatistic));
			preferences.setValue("yearRange", String.valueOf(yearRange));
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
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
		return "/html/vbpq_category_portlet/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(VBPQCategoryConfiguration.class);
}