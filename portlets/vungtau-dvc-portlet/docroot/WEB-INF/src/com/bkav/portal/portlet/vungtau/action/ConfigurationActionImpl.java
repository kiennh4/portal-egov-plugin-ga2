package com.bkav.portal.portlet.vungtau.action;

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
import com.sun.org.apache.xpath.internal.operations.Div;

public class ConfigurationActionImpl extends DefaultConfigurationAction{

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		try {
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");

			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			String tthcCateNameFirst = ParamUtil.getString(actionRequest, "tthcCategoryFirst");
			
			String tthcCateUrlFirst = ParamUtil.getString(actionRequest, "tthcCateUrlFirst");
			
			String tthcCateNameSecond = ParamUtil.getString(actionRequest, "tthcCategorySecond");
			
			String tthcCateUrlSecond = ParamUtil.getString(actionRequest, "tthcCateUrlSecond");
			
			String tthcCateNameThird = ParamUtil.getString(actionRequest, "tthcCategoryThird");
			
			String tthcCateUrlThird = ParamUtil.getString(actionRequest, "tthcCateUrlThird");
			
			String tthcReadMoreUrl = ParamUtil.getString(actionRequest, "tthcReadMore");
			
			String dvcNameFirst = ParamUtil.getString(actionRequest, "dvcNameFirst");
			
			String dvcUrlFirst = ParamUtil.getString(actionRequest, "dvcUrlFirst");
			
			String dvcNameSecond = ParamUtil.getString(actionRequest, "dvcNameSecond");
			
			String dvcUrlSecond = ParamUtil.getString(actionRequest, "dvcUrlSecond");
			
			String trcName = ParamUtil.getString(actionRequest, "tcrName");
			
			String trcUrl = ParamUtil.getString(actionRequest, "trcUrl");
			
			
			preferences.setValue("tthcCateNameFist", tthcCateNameFirst);
			preferences.setValue("tthcCateUrlFirst", tthcCateUrlFirst);
			preferences.setValue("tthcCateNameSecond", tthcCateNameSecond);
			preferences.setValue("tthcCateUrlSecond", tthcCateUrlSecond);
			preferences.setValue("tthcCateNameThird", tthcCateNameThird);
			preferences.setValue("tthcCateUrlThird", tthcCateUrlThird);
			preferences.setValue("tthcReadMore", tthcReadMoreUrl);
			preferences.setValue("dvcNameFirst", dvcNameFirst);
			preferences.setValue("dvcNameSecond", dvcNameSecond);
			preferences.setValue("dvcUrlFirst", dvcUrlFirst);
			preferences.setValue("dvcUrlSecond", dvcUrlSecond);
			preferences.setValue("trcUrlName", trcName);
			preferences.setValue("trcUrl", trcUrl);
			
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
	
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);

}
