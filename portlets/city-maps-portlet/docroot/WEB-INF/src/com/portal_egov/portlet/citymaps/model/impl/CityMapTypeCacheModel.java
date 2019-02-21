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

import com.portal_egov.portlet.citymaps.model.CityMapType;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CityMapType in entity cache.
 *
 * @author HungDX
 * @see CityMapType
 * @generated
 */
public class CityMapTypeCacheModel implements CacheModel<CityMapType>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{typeId=");
		sb.append(typeId);
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
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append(", typeDesc=");
		sb.append(typeDesc);
		sb.append("}");

		return sb.toString();
	}

	public CityMapType toEntityModel() {
		CityMapTypeImpl cityMapTypeImpl = new CityMapTypeImpl();

		cityMapTypeImpl.setTypeId(typeId);
		cityMapTypeImpl.setCompanyId(companyId);
		cityMapTypeImpl.setGroupId(groupId);
		cityMapTypeImpl.setUserId(userId);

		if (userName == null) {
			cityMapTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			cityMapTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cityMapTypeImpl.setCreateDate(null);
		}
		else {
			cityMapTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cityMapTypeImpl.setModifiedDate(null);
		}
		else {
			cityMapTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (typeName == null) {
			cityMapTypeImpl.setTypeName(StringPool.BLANK);
		}
		else {
			cityMapTypeImpl.setTypeName(typeName);
		}

		if (typeDesc == null) {
			cityMapTypeImpl.setTypeDesc(StringPool.BLANK);
		}
		else {
			cityMapTypeImpl.setTypeDesc(typeDesc);
		}

		cityMapTypeImpl.resetOriginalValues();

		return cityMapTypeImpl;
	}

	public long typeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String typeName;
	public String typeDesc;
}