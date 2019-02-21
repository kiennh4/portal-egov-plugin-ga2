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

package com.portal_egov.portlet.landprice.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.landprice.model.LandLocation;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LandLocation in entity cache.
 *
 * @author HungDX
 * @see LandLocation
 * @generated
 */
public class LandLocationCacheModel implements CacheModel<LandLocation>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{locationId=");
		sb.append(locationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", parentLocationId=");
		sb.append(parentLocationId);
		sb.append(", locationName=");
		sb.append(locationName);
		sb.append(", locationInfo=");
		sb.append(locationInfo);
		sb.append("}");

		return sb.toString();
	}

	public LandLocation toEntityModel() {
		LandLocationImpl landLocationImpl = new LandLocationImpl();

		landLocationImpl.setLocationId(locationId);
		landLocationImpl.setCompanyId(companyId);
		landLocationImpl.setGroupId(groupId);
		landLocationImpl.setUserId(userId);

		if (userName == null) {
			landLocationImpl.setUserName(StringPool.BLANK);
		}
		else {
			landLocationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			landLocationImpl.setCreateDate(null);
		}
		else {
			landLocationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			landLocationImpl.setModifiedDate(null);
		}
		else {
			landLocationImpl.setModifiedDate(new Date(modifiedDate));
		}

		landLocationImpl.setParentLocationId(parentLocationId);

		if (locationName == null) {
			landLocationImpl.setLocationName(StringPool.BLANK);
		}
		else {
			landLocationImpl.setLocationName(locationName);
		}

		if (locationInfo == null) {
			landLocationImpl.setLocationInfo(StringPool.BLANK);
		}
		else {
			landLocationImpl.setLocationInfo(locationInfo);
		}

		landLocationImpl.resetOriginalValues();

		return landLocationImpl;
	}

	public long locationId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long parentLocationId;
	public String locationName;
	public String locationInfo;
}