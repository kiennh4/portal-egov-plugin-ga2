package com.portal_egov.portlet.tourism_map;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;
import com.portal_egov.portlet.tourism_map.permission.TourismMapMarkerGroupPermission;
import com.portal_egov.portlet.tourism_map.permission.TourismMapMarkerPermission;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalServiceUtil;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil;

/**
 * Portlet implementation class TourismMapAdmin
 */
public class TourismMapAdmin extends MVCPortlet {
 
	
	public void updateMarker(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long markerId = ParamUtil.getLong(uploadRequest, "markerId",0L);
			
			long markerGroupId = ParamUtil.getLong(uploadRequest, "markerGroupId",0L);
			
			String markerTitle = ParamUtil.getString(uploadRequest, "markerTitle");
			
			String markerLatitude = ParamUtil.getString(uploadRequest, "markerLatitude");
			
			String markerLongitude = ParamUtil.getString(uploadRequest, "markerLongitude");
			
			String markerInfo = ParamUtil.getString(uploadRequest, "markerInfo");
			
			String markerAddress = ParamUtil.getString(uploadRequest, "markerAddress");
			
			long markerImageId = CounterLocalServiceUtil.increment();
			
			InputStream markerImageStream = uploadRequest.getFileAsStream("markerImageFile");
			
			if(markerImageStream != null){
				
				if(markerId > 0){
					
					TourismMapMarker marker = TourismMapMarkerLocalServiceUtil.getMarker(markerId);
					
					if((marker != null) && (marker.getMarkerImageId() > 0)){
						
						markerImageId = marker.getMarkerImageId();
					}
				}
				
				uploadMarkerImage(markerImageId, markerImageStream);
			}
			
			String redirectURL = ParamUtil.getString(uploadRequest, "redirectURL");
			
			if(markerId > 0){//Update group
				
				TourismMapMarkerLocalServiceUtil.updateMarker(markerId, companyId, groupId, userId, userName, markerGroupId, markerTitle,
					markerInfo, markerAddress, markerImageId, markerLongitude, markerLatitude);
				
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(TourismMapMarker.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {TourismMapMarkerPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {TourismMapMarkerPermission.VIEW});
				
				TourismMapMarkerLocalServiceUtil.addMarker(companyId, groupId, userId, userName, markerGroupId, markerTitle, markerInfo,
					markerAddress, markerImageId, markerLongitude, markerLatitude, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
	}
	
	public void deleteMarker(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long markerId = ParamUtil.getLong(actionRequest, "markerId",0L);
			
			if(markerId > 0){
				
				TourismMapMarker marker = TourismMapMarkerLocalServiceUtil.getMarker(markerId);
				
				if(marker != null){
					
					long markerImageId = marker.getMarkerImageId();
					
					if(markerImageId > 0){
						ImageLocalServiceUtil.deleteImage(markerImageId);
					}
					
					TourismMapMarkerLocalServiceUtil.deleteMarker(markerId);
					
					String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
					
					SessionMessages.add(actionRequest, "request_processed");
					
					if(Validator.isNotNull(redirectURL)){
						actionResponse.sendRedirect(redirectURL);
					}
				}
			}
		}
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
	}
	
	public void updateMarkerGroup(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, StringPool.BLANK);
			
			long markerGroupId = ParamUtil.getLong(actionRequest, "markerGroupId",0L);
			
			String markerGroupName = ParamUtil.getString(actionRequest, "markerGroupName");
			
			String markerGroupInfo = ParamUtil.getString(actionRequest, "markerGroupInfo");
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			if(markerGroupId > 0){//Update group
				
				TourismMapMarkerGroupLocalServiceUtil.updateMarkerGroup(markerGroupId, companyId, groupId,
					userId, userName, markerGroupName, markerGroupInfo);
			}else{
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(TourismMapMarkerGroup.class.getName(), actionRequest);
				
				serviceContext.setGroupPermissions(new String[] {TourismMapMarkerGroupPermission.VIEW});
				serviceContext.setGuestPermissions(new String[] {TourismMapMarkerGroupPermission.VIEW});
				
				TourismMapMarkerGroupLocalServiceUtil.addMarkerGroup(companyId, groupId, userId, userName,
					markerGroupName, markerGroupInfo, serviceContext);
			}
			
			SessionMessages.add(actionRequest, "request_processed");
			
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	
	public void deleteMarkerGroup(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			long markerGroupId = ParamUtil.getLong(actionRequest, "markerGroupId",0L);
			
			if(markerGroupId > 0){
				
				List<TourismMapMarker> markerList = TourismMapMarkerLocalServiceUtil.findByMarkerGroup(markerGroupId);
				
				for(TourismMapMarker marker : markerList){
					
					marker.setMarkerGroupId(0);
					TourismMapMarkerLocalServiceUtil.updateTourismMapMarker(marker, false);
				}
				
				TourismMapMarkerGroupLocalServiceUtil.deleteMarkerGroup(markerGroupId);
				
				String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
				
				if(Validator.isNotNull(redirectURL)){
					actionResponse.sendRedirect(redirectURL);
				}
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (NoSuchTourismMapMarkerGroupException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		
	}
	
	public void updateMapConfig(ActionRequest actionRequest,ActionResponse actionResponse){
		
		try {
			
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			
			String mapAPIKey = ParamUtil.getString(actionRequest, "mapAPIKey");
			
			String defaultMapType = ParamUtil.getString(actionRequest, "defaultMapType");
			
			int defaultZoomLevel = ParamUtil.getInteger(actionRequest, "defaultZoomLevel");
			
			String mapCenterLatitude = ParamUtil.getString(actionRequest, "mapCenterLatitude");
			
			String mapCenterLongitude = ParamUtil.getString(actionRequest, "mapCenterLongitude");
			
			preferences.setValue("mapAPIKey", mapAPIKey);
			preferences.setValue("defaultMapType", defaultMapType);
			preferences.setValue("defaultZoomLevel", String.valueOf(defaultZoomLevel));
			preferences.setValue("mapCenterLatitude", mapCenterLatitude);
			preferences.setValue("mapCenterLongitude", mapCenterLongitude);
			
			if(SessionErrors.isEmpty(actionRequest)){
				
				preferences.store();
				
				String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
				
				SessionMessages.add(actionRequest, "request_processed");
				
				if(Validator.isNotNull(redirectURL)){
					actionResponse.sendRedirect(redirectURL);
				}
			}
		}
		catch (SystemException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (ReadOnlyException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (ValidatorException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
		catch (IOException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	
	protected void uploadMarkerImage(long markerImageId,InputStream markerImageStream) throws Exception{
		
		if(markerImageStream != null){
			
			byte[] markerImageBytes = FileUtil.getBytes(markerImageStream);
			
			long uploadServletMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);

			if ((uploadServletMaxSize > 0)
				&& ((markerImageBytes == null) || (markerImageBytes.length > uploadServletMaxSize))) {

				throw new ImageSizeException();
			}
			
			ImageBag imageBag = ImageToolUtil.read(markerImageBytes);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			if (renderedImage == null) {
				throw new ImageTypeException();
			}

			int USERS_IMAGE_MAX_HEIGHT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_HEIGHT));

			int USERS_IMAGE_MAX_WIDTH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_WIDTH));
			
			renderedImage = ImageToolUtil.scale(renderedImage, USERS_IMAGE_MAX_HEIGHT,USERS_IMAGE_MAX_WIDTH);
			
			String contentType = imageBag.getType();
			
			byte[] markerImagesBytes = ImageToolUtil.getBytes(renderedImage, contentType);
			
			ImageLocalServiceUtil.updateImage(markerImageId, markerImagesBytes);
		}
	}
	
	private  Log _log = LogFactory.getLog(TourismMapAdmin.class);
}
