package com.portal_egov.portlet.proposition_feedback.action;

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

public class PropositionFeedbackViewConfig extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			int numbersOfLastestProposition = ParamUtil.getInteger(actionRequest, "numbersOfLastestProposition",6);
			
			int numbersOfTopViewProposition = ParamUtil.getInteger(actionRequest, "numbersOfTopViewProposition",6);
			
			int numbersOfTopFeedbackProposition = ParamUtil.getInteger(actionRequest, "numbersOfTopFeedbackProposition",6);
			
			int numbersOfSearchResultProposition = ParamUtil.getInteger(actionRequest, "numbersOfSearchResultProposition",6);
			
			preferences.setValue("numbersOfLastestProposition", String.valueOf(numbersOfLastestProposition));
			preferences.setValue("numbersOfTopViewProposition", String.valueOf(numbersOfTopViewProposition));
			preferences.setValue("numbersOfTopFeedbackProposition", String.valueOf(numbersOfTopFeedbackProposition));
			preferences.setValue("numbersOfSearchResultProposition", String.valueOf(numbersOfSearchResultProposition));
			
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
		return "/html/proposition_feedback/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(PropositionFeedbackViewConfig.class);
}