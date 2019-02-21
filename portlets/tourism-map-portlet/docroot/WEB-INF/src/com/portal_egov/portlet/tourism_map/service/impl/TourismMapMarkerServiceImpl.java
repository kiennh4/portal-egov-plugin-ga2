/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal_egov.portlet.tourism_map.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil;
import com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerServiceBaseImpl;

/**
 * The implementation of the tourism map marker remote service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.tourism_map.service.TourismMapMarkerService}
 * interface. <p> This is a remote service. Methods of this service are expected
 * to have security checks based on the propagated JAAS credentials because this
 * service can be accessed remotely. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerServiceBaseImpl
 * @see com.portal_egov.portlet.tourism_map.service.TourismMapMarkerServiceUtil
 */
public class TourismMapMarkerServiceImpl extends TourismMapMarkerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.tourism_map.service.TourismMapMarkerServiceUtil}
	 * to access the tourism map marker remote service.
	 */
	
	public TourismMapMarker getMarker(long markerId) throws SystemException{
		
		return TourismMapMarkerLocalServiceUtil.getMarker(markerId);
	}
	
	public JSONObject getJSONMarkersByGroup(long markerGroupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<TourismMapMarker> markerList = TourismMapMarkerLocalServiceUtil.findByMarkerGroup(markerGroupId);
		
		String markersJSON = JSONFactoryUtil.looseSerialize(markerList);
		
		JSONArray markerJSONArray = JSONFactoryUtil.createJSONArray(markersJSON);
		
		jsonObject.put("markers", markerJSONArray);
		
		return jsonObject;
	}
	
	public JSONObject getJSONMarkers(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<TourismMapMarker> markerList = TourismMapMarkerLocalServiceUtil.findByGroup(groupId);
		
		String markersJSON = JSONFactoryUtil.looseSerialize(markerList);
		
		JSONArray markerJSONArray = JSONFactoryUtil.createJSONArray(markersJSON);
		
		jsonObject.put("markers", markerJSONArray);
		
		return jsonObject;
	}
	
	public void deleteMarker(long markerId) throws SystemException, PortalException{
		
		if(markerId > 0){
			
			TourismMapMarker marker = TourismMapMarkerLocalServiceUtil.getMarker(markerId);
			
			if(marker != null){
				
				long markerImageId = marker.getMarkerImageId();
				
				if(markerImageId > 0){
					ImageLocalServiceUtil.deleteImage(markerImageId);
				}
				TourismMapMarkerLocalServiceUtil.deleteMarker(markerId);
			}
		}
	}
	
}
