/**
 * @author HungDX
 * @time 10:17:02 AM
 * @project legal_fag-portlet
 */
package com.portal_egov.portlet.legal_faq.action;

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


public class LegalFAQCategoriesConfigActionImpl extends DefaultConfigurationAction {
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			int numbersOfCategoriesDisplay = ParamUtil.getInteger(actionRequest, "numbersOfCategoriesDisplay",6);
			
			//Hien thi so luong cau hoi cua tung chuyen muc hay khong?
			boolean displayFAQCounter = ParamUtil.getBoolean(actionRequest, "displayFAQCounter",false);
			
			preferences.setValue("numbersOfCategoriesDisplay", String.valueOf(numbersOfCategoriesDisplay));
			preferences.setValue("displayFAQCounter", String.valueOf(displayFAQCounter));
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,portletResource);

				SessionMessages.add(actionRequest,portletConfig.getPortletName() +SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/legal_faq_categories_portlet/config.jsp";
	}
	private static Log _log = LogFactory.getLog(LegalFAQCategoriesConfigActionImpl.class);
	
}
