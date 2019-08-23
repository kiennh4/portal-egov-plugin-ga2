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

package com.portal_egov.portlet.citymaps.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.citymaps.model.CityMap;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CityMap in entity cache.
 *
 * @author HungDX
 * @see CityMap
 * @generated
 */
public class CityMapCacheModel implements CacheModel<CityMap>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mapId=");
		sb.append(mapId);
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
		sb.append(", mapTypeId=");
		sb.append(mapTypeId);
		sb.append(", mapImageId=");
		sb.append(mapImageId);
		sb.append(", mapName=");
		sb.append(mapName);
		sb.append(", mapDesc=");
		sb.append(mapDesc);
		sb.append(", mapSumary=");
		sb.append(mapSumary);
		sb.append("}");

		return sb.toString();
	}

	public CityMap toEntityModel() {
		CityMapImpl cityMapImpl = new CityMapImpl();

		cityMapImpl.setMapId(mapId);
		cityMapImpl.setCompanyId(companyId);
		cityMapImpl.setGroupId(groupId);
		cityMapImpl.setUserId(userId);

		if (userName == null) {
			cityMapImpl.setUserName(StringPool.BLANK);
		}
		else {
			cityMapImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cityMapImpl.setCreateDate(null);
		}
		else {
			cityMapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cityMapImpl.setModifiedDate(null);
		}
		else {
			cityMapImpl.setModifiedDate(new Date(modifiedDate));
		}

		cityMapImpl.setMapTypeId(mapTypeId);
		cityMapImpl.setMapImageId(mapImageId);

		if (mapName == null) {
			cityMapImpl.setMapName(StringPool.BLANK);
		}
		else {
			cityMapImpl.setMapName(mapName);
		}

		if (mapDesc == null) {
			cityMapImpl.setMapDesc(StringPool.BLANK);
		}
		else {
			cityMapImpl.setMapDesc(mapDesc);
		}

		if (mapSumary == null) {
			cityMapImpl.setMapSumary(StringPool.BLANK);
		}
		else {
			cityMapImpl.setMapSumary(mapSumary);
		}

		cityMapImpl.resetOriginalValues();

		return cityMapImpl;
	}

	public long mapId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long mapTypeId;
	public long mapImageId;
	public String mapName;
	public String mapDesc;
	public String mapSumary;
}