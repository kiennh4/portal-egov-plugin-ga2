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

import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TourismMapMarker in entity cache.
 *
 * @author HungDX
 * @see TourismMapMarker
 * @generated
 */
public class TourismMapMarkerCacheModel implements CacheModel<TourismMapMarker>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{markerId=");
		sb.append(markerId);
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
		sb.append(", markerGroupId=");
		sb.append(markerGroupId);
		sb.append(", markerTitle=");
		sb.append(markerTitle);
		sb.append(", markerInfo=");
		sb.append(markerInfo);
		sb.append(", markerAddress=");
		sb.append(markerAddress);
		sb.append(", markerImageId=");
		sb.append(markerImageId);
		sb.append(", markerLongitude=");
		sb.append(markerLongitude);
		sb.append(", markerLatitude=");
		sb.append(markerLatitude);
		sb.append("}");

		return sb.toString();
	}

	public TourismMapMarker toEntityModel() {
		TourismMapMarkerImpl tourismMapMarkerImpl = new TourismMapMarkerImpl();

		tourismMapMarkerImpl.setMarkerId(markerId);
		tourismMapMarkerImpl.setCompanyId(companyId);
		tourismMapMarkerImpl.setGroupId(groupId);
		tourismMapMarkerImpl.setUserId(userId);

		if (userName == null) {
			tourismMapMarkerImpl.setUserName(StringPool.BLANK);
		}
		else {
			tourismMapMarkerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tourismMapMarkerImpl.setCreateDate(null);
		}
		else {
			tourismMapMarkerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tourismMapMarkerImpl.setModifiedDate(null);
		}
		else {
			tourismMapMarkerImpl.setModifiedDate(new Date(modifiedDate));
		}

		tourismMapMarkerImpl.setMarkerGroupId(markerGroupId);

		if (markerTitle == null) {
			tourismMapMarkerImpl.setMarkerTitle(StringPool.BLANK);
		}
		else {
			tourismMapMarkerImpl.setMarkerTitle(markerTitle);
		}

		if (markerInfo == null) {
			tourismMapMarkerImpl.setMarkerInfo(StringPool.BLANK);
		}
		else {
			tourismMapMarkerImpl.setMarkerInfo(markerInfo);
		}

		if (markerAddress == null) {
			tourismMapMarkerImpl.setMarkerAddress(StringPool.BLANK);
		}
		else {
			tourismMapMarkerImpl.setMarkerAddress(markerAddress);
		}

		tourismMapMarkerImpl.setMarkerImageId(markerImageId);

		if (markerLongitude == null) {
			tourismMapMarkerImpl.setMarkerLongitude(StringPool.BLANK);
		}
		else {
			tourismMapMarkerImpl.setMarkerLongitude(markerLongitude);
		}

		if (markerLatitude == null) {
			tourismMapMarkerImpl.setMarkerLatitude(StringPool.BLANK);
		}
		else {
			tourismMapMarkerImpl.setMarkerLatitude(markerLatitude);
		}

		tourismMapMarkerImpl.resetOriginalValues();

		return tourismMapMarkerImpl;
	}

	public long markerId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long markerGroupId;
	public String markerTitle;
	public String markerInfo;
	public String markerAddress;
	public long markerImageId;
	public String markerLongitude;
	public String markerLatitude;
}