package com.portal_egov.portlet.citymaps;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.model.CityMapType;
import com.portal_egov.portlet.citymaps.permission.CityMapPermission;
import com.portal_egov.portlet.citymaps.permission.CityMapTypePermission;
import com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil;
import com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil;
import com.portal_egov.portlet.citymaps.util.CityMapUtil;

/**
 * Portlet implementation class CityMapsAdmin
 */
public class CityMapsAdmin extends MVCPortlet {
 

	public void updateMapType(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long mapTypeId = ParamUtil.getLong(actionRequest, "mapTypeId",0L);
			
			String mapTypeName = ParamUtil.getString(actionRequest, "mapTypeName");
			
			String mapTypeDesc = ParamUtil.getString(actionRequest, "mapTypeDesc");
			
			if(mapTypeId > 0){
				
				CityMapTypeLocalServiceUtil.updateMapType(mapTypeId, companyId, groupId, userId, userName, mapTypeName, mapTypeDesc);
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(CityMapType.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {CityMapTypePermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {CityMapTypePermission.VIEW});
				
				CityMapTypeLocalServiceUtil.addMapType(companyId, groupId, userId, userName, mapTypeName, mapTypeDesc, serviceContext);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void deleteMapType(ActionRequest actionRequest, ActionResponse actionResponse){
		
		long mapTypeId = ParamUtil.getLong(actionRequest, "mapTypeId",0L);
		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		
		if(mapTypeId > 0){
			
			try {
				
				CityMapTypeLocalServiceUtil.deleteMapType(mapTypeId);
				
				if(Validator.isNotNull(redirectURL)){
					actionResponse.sendRedirect(redirectURL);
				}
				
			}
			catch (NoSuchCityMapTypeException e) {
				_log.error(e);
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			catch (SystemException e) {
				_log.error(e);
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			catch (IOException e) {
				_log.error(e);
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
		}
	}
	
	
	public void updateCityMap(ActionRequest actionRequest, ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long mapId = ParamUtil.getLong(uploadRequest, "mapId",0L);
			
			long mapTypeId = ParamUtil.getLong(uploadRequest, "mapTypeId",0L);
			
			String mapName = ParamUtil.getString(uploadRequest, "mapName");
			
			String mapDesc = ParamUtil.getString(uploadRequest, "mapDesc");
			
			long mapImageId = ParamUtil.getLong(uploadRequest, "mapImageId");
			
			InputStream mapImageStream = uploadRequest.getFileAsStream("mapImageFile");
			
			if(mapImageStream != null){
				
				if(mapImageId <= 0){
					
					mapImageId = CounterLocalServiceUtil.increment();
				}
				
				CityMapUtil.uploadMapImage(mapImageId, mapImageStream);
			}
			
			if(mapId > 0){
				
				CityMapLocalServiceUtil.updateMap(companyId, groupId, userId, userName, mapId, mapTypeId, mapImageId, mapName, mapDesc);
			
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(CityMap.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {CityMapPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {CityMapPermission.VIEW});
				
				CityMapLocalServiceUtil.addMap(companyId, groupId, userId, userName, mapTypeId, mapImageId, mapName, mapDesc, serviceContext);
			}
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			if(e instanceof UploadException || e instanceof ImageSizeException || e instanceof ImageTypeException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				_log.error(e);
			}
		}
	}
	
	
	public void deleteCityMap(ActionRequest actionRequest, ActionResponse actionResponse){
			
			long mapId = ParamUtil.getLong(actionRequest, "mapId",0L);
			
			if(mapId > 0){
				
				try {
					
					CityMap cityMap = CityMapLocalServiceUtil.getCityMap(mapId);
					
					if(cityMap != null){
						
						long mapImageId = cityMap.getMapImageId();
						
						if(mapImageId > 0){
							
							ImageLocalServiceUtil.deleteImage(mapImageId);
						}
						
						CityMapLocalServiceUtil.deleteCityMap(mapId);
						
						String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
						
						if(Validator.isNotNull(redirectURL)){
							actionResponse.sendRedirect(redirectURL);
						}
					}
				}
				catch (NoSuchCityMapException e) {
					_log.error(e);
					SessionErrors.add(actionRequest, e.getClass().getName());
				}
				catch (SystemException e) {
					_log.error(e);
					SessionErrors.add(actionRequest, e.getClass().getName());
				}
				catch (IOException e) {
					_log.error(e);
					SessionErrors.add(actionRequest, e.getClass().getName());
				}
				catch (PortalException e) {
					_log.error(e);
					SessionErrors.add(actionRequest, e.getClass().getName());
				}
			}
	}
	private static Log _log = LogFactory.getLog(CityMapsAdmin.class);
}
