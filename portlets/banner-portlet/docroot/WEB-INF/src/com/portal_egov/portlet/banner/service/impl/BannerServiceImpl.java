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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.portal_egov.portlet.banner.model.Banner;
import com.portal_egov.portlet.banner.permission.BannerPermission;
import com.portal_egov.portlet.banner.service.BannerLocalServiceUtil;
import com.portal_egov.portlet.banner.service.base.BannerServiceBaseImpl;

/**
 * The implementation of the banner remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.portal_egov.portlet.banner.service.BannerService} interface. <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely. </p>
 * 
 * @author HUNGDX
 * @see com.portal_egov.portlet.banner.service.base.BannerServiceBaseImpl
 * @see com.portal_egov.portlet.banner.service.BannerServiceUtil
 */
public class BannerServiceImpl extends BannerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.portal_egov.portlet.banner.service.BannerServiceUtil} to
	 * access the banner remote service.
	 */
	
	public Banner getBanner(long bannerId) throws PortalException, SystemException{
		return BannerLocalServiceUtil.getBanner(bannerId);
	}
	
	public JSONObject getAllBanners(long groupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<Banner> bannerList = BannerLocalServiceUtil.findByGroup(groupId);
		
		String bannersJSonStr = JSONFactoryUtil.looseSerialize(bannerList);
		
		JSONArray bannersJSonArray = JSONFactoryUtil.createJSONArray(bannersJSonStr);
		
		jsonObject.put("banners", bannersJSonArray);
		
		return jsonObject;
	}
	
	public JSONObject getGroupBanners(long bannerGroupId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<Banner> bannerList = BannerLocalServiceUtil.findByBannerGroup(bannerGroupId);
		
		String bannersJSonStr = JSONFactoryUtil.looseSerialize(bannerList);
		
		JSONArray bannersJSonArray = JSONFactoryUtil.createJSONArray(bannersJSonStr);
		
		jsonObject.put("banners", bannersJSonArray);
		
		return jsonObject;
	}
	
	
	public JSONObject findByKeyword(long groupId,long bannerGroupId,String searchKeyword) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<Banner> bannerList = BannerLocalServiceUtil.findByGroup(groupId);
		
		if(Validator.isNotNull(searchKeyword)){
			
			bannerList = BannerLocalServiceUtil.findByTitle(groupId, bannerGroupId, searchKeyword, 0, -1, null);
		}
		
		String bannersJSonStr = JSONFactoryUtil.looseSerialize(bannerList);
		
		JSONArray bannersJSonArray = JSONFactoryUtil.createJSONArray(bannersJSonStr);
		
		jsonObject.put("banners", bannersJSonArray);
		
		return jsonObject;
	}
	
	public void deleteBanner(long groupId,long bannerId) throws SystemException, PrincipalException, PortalException{
		
		if(bannerId > 0){
			
			BannerPermission.check(getPermissionChecker(), groupId, ActionKeys.DELETE);
			
			BannerLocalServiceUtil.deleteBanner(bannerId);
		}
	}
}
