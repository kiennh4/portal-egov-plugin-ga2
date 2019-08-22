package com.bkav.portal.portlet.vungtau.citizen.action;

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

public class VungTauCitizenConfigurationActionImpl extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		try {
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			String onlineChatDesc = ParamUtil.getString(actionRequest, "onlineChatDesc");
			
			String reflectRequestDesc = ParamUtil.getString(actionRequest, "reflectRequestDesc");
			
			String reflectFristUrl = ParamUtil.getString(actionRequest, "reflectFristUrl");
			
			String reflectFirstName = ParamUtil.getString(actionRequest, "reflectFirstName");
			
			String reflectSecondUrl = ParamUtil.getString(actionRequest, "reflectSecondUrl");
			
			String reflectSecondName = ParamUtil.getString(actionRequest, "reflectSecondName");
			
			String legalFaqDesc = ParamUtil.getString(actionRequest, "legalFaqDesc");
			
			String legalFaqFirstUrl = ParamUtil.getString(actionRequest, "legalFaqFirstUrl");
			
			String legalFaqFirstName = ParamUtil.getString(actionRequest, "legalFaqFirstName");
			
			String legalFaqSecondUrl = ParamUtil.getString(actionRequest, "legalFaqSecondUrl");
			
			String legalFaqSecondName = ParamUtil.getString(actionRequest, "legalFaqSecondName");
			
			preferences.setValue("onlineChatDesc", onlineChatDesc);
			preferences.setValue("reflectRequestDesc", reflectRequestDesc);
			preferences.setValue("reflectFristUrl", reflectFristUrl);
			preferences.setValue("reflectFirstName", reflectFirstName);
			preferences.setValue("reflectSecondUrl", reflectSecondUrl);
			preferences.setValue("reflectSecondName", reflectSecondName);
			preferences.setValue("legalFaqDesc", legalFaqDesc);
			preferences.setValue("legalFaqFirstUrl", legalFaqFirstUrl);
			preferences.setValue("legalFaqFirstName", legalFaqFirstName);
			preferences.setValue("legalFaqSecondUrl", legalFaqSecondUrl);
			preferences.setValue("legalFaqSecondName", legalFaqSecondName);
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
		return "/html/view/config.jsp";
	}
	
	private static Log _log = LogFactory.getLog(VungTauCitizenConfigurationActionImpl.class);

}
