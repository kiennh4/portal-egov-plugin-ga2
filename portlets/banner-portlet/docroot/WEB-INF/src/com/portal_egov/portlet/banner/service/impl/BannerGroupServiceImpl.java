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

package com.portal_egov.portlet.banner.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.portal_egov.portlet.banner.model.BannerGroup;
import com.portal_egov.portlet.banner.permission.BannerGroupPermission;
import com.portal_egov.portlet.banner.service.BannerGroupLocalServiceUtil;
import com.portal_egov.portlet.banner.service.base.BannerGroupServiceBaseImpl;

/**
 * The implementation of the banner group remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.banner.service.BannerGroupService} interface.
 * <p> This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.banner.service.base.BannerGroupServiceBaseImpl
 * @see com.portal_egov.portlet.banner.service.BannerGroupServiceUtil
 */
public class BannerGroupServiceImpl extends BannerGroupServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.banner.service.BannerGroupServiceUtil} to
	 * access the banner group remote service.
	 */
	
	public JSONObject getBannerGroups(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<BannerGroup> bannerGroupList = BannerGroupLocalServiceUtil.findByGroup(groupId);
		
		String bannerGroupJSonStr = JSONFactoryUtil.looseSerialize(bannerGroupList);
		
		JSONArray bannerGroupJSonArray = JSONFactoryUtil.createJSONArray(bannerGroupJSonStr);
		
		jsonObject.put("bannerGroups", bannerGroupJSonArray);
		
		return jsonObject;
	}
	
	public void deleteBannerGroup(long groupId,long bannerGroupId) throws SystemException, PrincipalException, PortalException{
		
		if(bannerGroupId > 0){
			
			BannerGroupPermission.check(getPermissionChecker(), groupId, ActionKeys.DELETE);
			
			BannerGroupLocalServiceUtil.deleteBannerGroup(bannerGroupId);
		}
	}
}
