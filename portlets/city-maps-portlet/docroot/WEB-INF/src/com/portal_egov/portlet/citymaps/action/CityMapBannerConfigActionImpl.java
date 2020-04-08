package com.portal_egov.portlet.citymaps.action;


import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.portal_egov.portlet.citymaps.util.CityMapUtil;

public class CityMapBannerConfigActionImpl extends DefaultConfigurationAction{
		
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		try {
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			
			//Id cua ban do duoc chon de hien thi mac dinh tren trang cau hinh
			long bannerImageId = ParamUtil.getLong(uploadRequest, "bannerImageId",0L);
			
			InputStream bannerImageStream = uploadRequest.getFileAsStream("bannerImageFile");
			
			if(bannerImageStream != null){
				
				if(bannerImageId <= 0L){
					
					bannerImageId = CounterLocalServiceUtil.increment();
				}
				
				CityMapUtil.uploadMapImage(bannerImageId, bannerImageStream);
				
			}
			
			int mapImageWidth = ParamUtil.getInteger(uploadRequest, "mapImageWidth");
			
			int mapImageHeight = ParamUtil.getInteger(uploadRequest, "mapImageHeight");
			
			String cityMapDisplayPageURL = ParamUtil.getString(uploadRequest, "cityMapDisplayPageURL",PortalUtil.getPortalURL(uploadRequest));
			
			preferences.setValue("cityMapDisplayPageURL", cityMapDisplayPageURL);
			preferences.setValue("bannerImageId", String.valueOf(bannerImageId));
			preferences.setValue("mapImageWidth", String.valueOf(mapImageWidth));
			preferences.setValue("mapImageHeight", String.valueOf(mapImageHeight));
			
			if(SessionErrors.isEmpty(uploadRequest)){
				
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
		return "/html/citymap_banner/configuration.jsp";
	}
	private static Log _log = LogFactory.getLog(CityMapBannerConfigActionImpl.class);
}