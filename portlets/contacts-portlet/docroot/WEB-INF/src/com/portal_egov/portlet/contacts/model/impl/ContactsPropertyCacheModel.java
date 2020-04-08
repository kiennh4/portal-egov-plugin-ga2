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

import com.portal_egov.portlet.contacts.model.ContactsProperty;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ContactsProperty in entity cache.
 *
 * @author HungDX
 * @see ContactsProperty
 * @generated
 */
public class ContactsPropertyCacheModel implements CacheModel<ContactsProperty>,
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
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", propertyKey=");
		sb.append(propertyKey);
		sb.append(", propertyValue=");
		sb.append(propertyValue);
		sb.append(", propertyType=");
		sb.append(propertyType);
		sb.append("}");

		return sb.toString();
	}

	public ContactsProperty toEntityModel() {
		ContactsPropertyImpl contactsPropertyImpl = new ContactsPropertyImpl();

		contactsPropertyImpl.setPropertyId(propertyId);
		contactsPropertyImpl.setGroupId(groupId);
		contactsPropertyImpl.setCompanyId(companyId);
		contactsPropertyImpl.setUserId(userId);

		if (userName == null) {
			contactsPropertyImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactsPropertyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactsPropertyImpl.setCreateDate(null);
		}
		else {
			contactsPropertyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactsPropertyImpl.setModifiedDate(null);
		}
		else {
			contactsPropertyImpl.setModifiedDate(new Date(modifiedDate));
		}

		contactsPropertyImpl.setContactId(contactId);

		if (propertyKey == null) {
			contactsPropertyImpl.setPropertyKey(StringPool.BLANK);
		}
		else {
			contactsPropertyImpl.setPropertyKey(propertyKey);
		}

		if (propertyValue == null) {
			contactsPropertyImpl.setPropertyValue(StringPool.BLANK);
		}
		else {
			contactsPropertyImpl.setPropertyValue(propertyValue);
		}

		if (propertyType == null) {
			contactsPropertyImpl.setPropertyType(StringPool.BLANK);
		}
		else {
			contactsPropertyImpl.setPropertyType(propertyType);
		}

		contactsPropertyImpl.resetOriginalValues();

		return contactsPropertyImpl;
	}

	public long propertyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long contactId;
	public String propertyKey;
	public String propertyValue;
	public String propertyType;
}