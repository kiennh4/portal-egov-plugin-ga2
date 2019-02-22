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

package com.portal_egov.portlet.citymaps.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.portal_egov.portlet.citymaps.model.CityMapType;
import com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil;
import com.portal_egov.portlet.citymaps.service.base.CityMapTypeServiceBaseImpl;

/**
 * The implementation of the city map type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.citymaps.service.CityMapTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HUNGDX
 * @see com.portal_egov.portlet.citymaps.service.base.CityMapTypeServiceBaseImpl
 * @see com.portal_egov.portlet.citymaps.service.CityMapTypeServiceUtil
 */
public class CityMapTypeServiceImpl extends CityMapTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly.
	 *  Always use {@link com.portal_egov.portlet.citymaps.service.CityMapTypeServiceUtil}
	 *   to access the city map type remote service.
	 */
	
	
	public JSONObject getJSONMapType(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<CityMapType> rootDepartmentList = CityMapTypeLocalServiceUtil.findByGroup(groupId);
		
		String mapTypesJSON = JSONFactoryUtil.looseSerialize(rootDepartmentList);
		
		JSONArray mapTypesJSONArray = JSONFactoryUtil.createJSONArray(mapTypesJSON);
		
		jsonObject.put("mapType", mapTypesJSONArray);
		
		return jsonObject;
	}
}