package com.portal_egov.portlet.weather.action;

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
import com.portal_egov.portlet.weather.util.WeatherConstants;


public class WeatherConfigurationImpl extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			//Kieu hien thi
			String displayStyle = ParamUtil.getString(actionRequest, "displayStyle","default");
			
			//Ma so cua Tinh/TP mac dinh hien thi thong tin thoi tiet
			String selectedCityVMCode = ParamUtil.getString(actionRequest, "selectedCityVMCode",WeatherConstants.HA_NOI_CITY_VM_CODE);
			
			//Cho phep nguoi dung tuy chon Tinh/TP de xem thong tin thoi tiet
			boolean displayCustomCityName = ParamUtil.getBoolean(actionRequest, "displayCustomCityName", false);
			
			//Ten Tinh/TP tuy chon
			String customCityName = ParamUtil.getString(actionRequest, "customCityName",StringPool.BLANK);
			
			preferences.setValue("displayStyle", displayStyle);
			preferences.setValue("selectedCityVMCode", selectedCityVMCode);
			preferences.setValue("displayCitySelectBox", String.valueOf(displayCustomCityName));
			preferences.setValue("customCityName", customCityName);
			
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
		return "/html/config/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(WeatherConfigurationImpl.class);
}