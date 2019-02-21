package com.portal_egov.portlet.weblinks.action;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;


public class WeblinkConfigurationActionImpl extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
					
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			//Kieu hien thi.Mac dinh la kieu hien thi dang select box
			String displayStyle = ParamUtil.getString(actionRequest, "displayStyle","defaultDisplayStyle");
			
			preferences.setValue("displayStyle", displayStyle);
			
			if(Validator.equals(displayStyle, "defaultDisplayStyle")){
				
				//Id cua chuyen muc duoc chon
				long defaultCategoryId = ParamUtil.getLong(actionRequest, "defaultCategoryId",0);
				preferences.setValue("defaultCategoryId", String.valueOf(defaultCategoryId));
				
			}else if(Validator.equals(displayStyle, "multiTabsDisplayStyle")){//Truong hop kieu hien thi dang Tab
				
				//Id cua cac chuyen muc duoc chon de hien thi
				String[] selectedWeblinkTabIds = actionRequest.getParameterValues("selectedWeblinkTabId");
				
				if(selectedWeblinkTabIds != null){
					
					preferences.setValues("selectedWeblinkTabIds", selectedWeblinkTabIds);
				}
				
				//So luong lien ket hien thi toi da trong moi tab
				int numbersOfWeblinkPerTab = ParamUtil.getInteger(actionRequest, "numbersOfWeblinkPerTab",DEFAULT_NUMBERS_OF_WEBLINKS_DISPLAY);
				
				preferences.setValue("numbersOfWeblinkPerTab", String.valueOf(numbersOfWeblinkPerTab));
			
			}else if(Validator.equals(displayStyle, "listTitleDisplayStyle")){//Kieu hien thi dang danh sach lien ket
				
				//Id cua chuyen muc duoc chon
				long selectedCategoryId = ParamUtil.getLong(actionRequest, "selectedCategoryId",0);
				
				//So luong lien ket hien thi
				int numbersOfWeblinkDisplayList = ParamUtil.getInteger(actionRequest, "numbersOfWeblinkDisplayList",DEFAULT_NUMBERS_OF_WEBLINKS_DISPLAY);
				
				preferences.setValue("selectedCategoryId", String.valueOf(selectedCategoryId));
				preferences.setValue("numbersOfWeblinkDisplayList", String.valueOf(numbersOfWeblinkDisplayList));
			}
			
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
		return "/html/weblinks/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(WeblinkConfigurationActionImpl.class);
	
	private static final int DEFAULT_NUMBERS_OF_WEBLINKS_DISPLAY = 0;
}