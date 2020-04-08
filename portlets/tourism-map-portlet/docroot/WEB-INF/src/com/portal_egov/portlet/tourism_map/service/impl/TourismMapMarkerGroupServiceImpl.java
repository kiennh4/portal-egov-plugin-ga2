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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;
import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupLocalServiceUtil;
import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil;
import com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerGroupServiceBaseImpl;

/**
 * The implementation of the tourism map marker group remote service. <p> All
 * custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupService}
 * interface. <p> This is a remote service. Methods of this service are expected
 * to have security checks based on the propagated JAAS credentials because this
 * service can be accessed remotely. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.tourism_map.service.base.TourismMapMarkerGroupServiceBaseImpl
 * @see com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupServiceUtil
 */
public class TourismMapMarkerGroupServiceImpl extends TourismMapMarkerGroupServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * com.portal_egov.portlet.tourism_map.service.TourismMapMarkerGroupServiceUtil
	 * } to access the tourism map marker group remote service.
	 */
	
	
	public JSONObject getJSONmarkerGroups(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<TourismMapMarkerGroup> markerGroupList = TourismMapMarkerGroupLocalServiceUtil.findByGroup(groupId);
		
		String markerGroupJSON = JSONFactoryUtil.looseSerialize(markerGroupList);
		
		JSONArray markerGroupJSONArray = JSONFactoryUtil.createJSONArray(markerGroupJSON);
		
		jsonObject.put("markerGroups", markerGroupJSONArray);
		
		return jsonObject;
	}
	
	public void deleteMarkerGroup(long markerGroupId) throws SystemException, NoSuchTourismMapMarkerGroupException{
		
		if(markerGroupId > 0){
			
			List<TourismMapMarker> markerList = TourismMapMarkerLocalServiceUtil.findByMarkerGroup(markerGroupId);
			
			for(TourismMapMarker marker : markerList){
				
				marker.setMarkerGroupId(0);
				TourismMapMarkerLocalServiceUtil.updateTourismMapMarker(marker, false);
			}
			
			TourismMapMarkerGroupLocalServiceUtil.deleteMarkerGroup(markerGroupId);
		}
	}
}
