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

package com.portal_egov.portlet.contacts.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ContactsDepartmentProperty in entity cache.
 *
 * @author HungDX
 * @see ContactsDepartmentProperty
 * @generated
 */
public class ContactsDepartmentPropertyCacheModel implements CacheModel<ContactsDepartmentProperty>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{propertyId=");
		sb.append(propertyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", propertyKey=");
		sb.append(propertyKey);
		sb.append(", propertyValue=");
		sb.append(propertyValue);
		sb.append(", propertyType=");
		sb.append(propertyType);
		sb.append("}");

		return sb.toString();
	}

	public ContactsDepartmentProperty toEntityModel() {
		ContactsDepartmentPropertyImpl contactsDepartmentPropertyImpl = new ContactsDepartmentPropertyImpl();

		contactsDepartmentPropertyImpl.setPropertyId(propertyId);
		contactsDepartmentPropertyImpl.setGroupId(groupId);
		contactsDepartmentPropertyImpl.setCompanyId(companyId);
		contactsDepartmentPropertyImpl.setUserId(userId);

		if (userName == null) {
			contactsDepartmentPropertyImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactsDepartmentPropertyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactsDepartmentPropertyImpl.setCreateDate(null);
		}
		else {
			contactsDepartmentPropertyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactsDepartmentPropertyImpl.setModifiedDate(null);
		}
		else {
			contactsDepartmentPropertyImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		contactsDepartmentPropertyImpl.setDepartmentId(departmentId);

		if (propertyKey == null) {
			contactsDepartmentPropertyImpl.setPropertyKey(StringPool.BLANK);
		}
		else {
			contactsDepartmentPropertyImpl.setPropertyKey(propertyKey);
		}

		if (propertyValue == null) {
			contactsDepartmentPropertyImpl.setPropertyValue(StringPool.BLANK);
		}
		else {
			contactsDepartmentPropertyImpl.setPropertyValue(propertyValue);
		}

		if (propertyType == null) {
			contactsDepartmentPropertyImpl.setPropertyType(StringPool.BLANK);
		}
		else {
			contactsDepartmentPropertyImpl.setPropertyType(propertyType);
		}

		contactsDepartmentPropertyImpl.resetOriginalValues();

		return contactsDepartmentPropertyImpl;
	}

	public long propertyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long departmentId;
	public String propertyKey;
	public String propertyValue;
	public String propertyType;
}