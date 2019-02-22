package com.portal_egov.portlet.banner.action;

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


public class BannerConfigurationActionImpl extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			//Id cua banner duoc chon de hien thi
			long selectedBannerId = ParamUtil.getLong(actionRequest, "selectedBannerId");
			
			String bannerTitle = ParamUtil.getString(actionRequest, "bannerTitle");
			
			int bannerImageHeight = ParamUtil.getInteger(actionRequest, "bannerImageHeight");
			
			int bannerImageWidth = ParamUtil.getInteger(actionRequest, "bannerImageWidth");
			
			String bannerLink = ParamUtil.getString(actionRequest, "bannerLink");
			
			boolean bannerImageBorder = ParamUtil.getBoolean(actionRequest, "bannerImageBorder",true);
			
			boolean linkToNewTab = ParamUtil.getBoolean(actionRequest, "linkToNewTab");
			
			preferences.setValue("bannerId", String.valueOf(selectedBannerId));
			preferences.setValue("bannerTitle", bannerTitle);
			preferences.setValue("bannerImageHeight", String.valueOf(bannerImageHeight));
			preferences.setValue("bannerImageWidth", String.valueOf(bannerImageWidth));
			preferences.setValue("bannerLink", bannerLink);
			preferences.setValue("bannerImageBorder", String.valueOf(bannerImageBorder));
			preferences.setValue("linkToNewTab", String.valueOf(linkToNewTab));
			
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
	
	private static Log _log = LogFactory.getLog(BannerConfigurationActionImpl.class);
}