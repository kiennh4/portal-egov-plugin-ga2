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

package com.portal_egov.portlet.tourism_map.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TourismMapMarkerGroup in entity cache.
 *
 * @author HungDX
 * @see TourismMapMarkerGroup
 * @generated
 */
public class TourismMapMarkerGroupCacheModel implements CacheModel<TourismMapMarkerGroup>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{markerGroupId=");
		sb.append(markerGroupId);
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
		sb.append(", markerGroupName=");
		sb.append(markerGroupName);
		sb.append(", markerGroupInfo=");
		sb.append(markerGroupInfo);
		sb.append("}");

		return sb.toString();
	}

	public TourismMapMarkerGroup toEntityModel() {
		TourismMapMarkerGroupImpl tourismMapMarkerGroupImpl = new TourismMapMarkerGroupImpl();

		tourismMapMarkerGroupImpl.setMarkerGroupId(markerGroupId);
		tourismMapMarkerGroupImpl.setCompanyId(companyId);
		tourismMapMarkerGroupImpl.setGroupId(groupId);
		tourismMapMarkerGroupImpl.setUserId(userId);

		if (userName == null) {
			tourismMapMarkerGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			tourismMapMarkerGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tourismMapMarkerGroupImpl.setCreateDate(null);
		}
		else {
			tourismMapMarkerGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tourismMapMarkerGroupImpl.setModifiedDate(null);
		}
		else {
			tourismMapMarkerGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (markerGroupName == null) {
			tourismMapMarkerGroupImpl.setMarkerGroupName(StringPool.BLANK);
		}
		else {
			tourismMapMarkerGroupImpl.setMarkerGroupName(markerGroupName);
		}

		if (markerGroupInfo == null) {
			tourismMapMarkerGroupImpl.setMarkerGroupInfo(StringPool.BLANK);
		}
		else {
			tourismMapMarkerGroupImpl.setMarkerGroupInfo(markerGroupInfo);
		}

		tourismMapMarkerGroupImpl.resetOriginalValues();

		return tourismMapMarkerGroupImpl;
	}

	public long markerGroupId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String markerGroupName;
	public String markerGroupInfo;
}