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

package com.portal_egov.portlet.tthc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.tthc.model.TTHC_Attribute;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TTHC_Attribute in entity cache.
 *
 * @author HungDX
 * @see TTHC_Attribute
 * @generated
 */
public class TTHC_AttributeCacheModel implements CacheModel<TTHC_Attribute>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{attributeId=");
		sb.append(attributeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", tthcEntryId=");
		sb.append(tthcEntryId);
		sb.append(", attributeTypeId=");
		sb.append(attributeTypeId);
		sb.append(", attributeIndex=");
		sb.append(attributeIndex);
		sb.append(", attributeName=");
		sb.append(attributeName);
		sb.append(", attributeValue=");
		sb.append(attributeValue);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public TTHC_Attribute toEntityModel() {
		TTHC_AttributeImpl tthc_AttributeImpl = new TTHC_AttributeImpl();

		tthc_AttributeImpl.setAttributeId(attributeId);
		tthc_AttributeImpl.setCompanyId(companyId);
		tthc_AttributeImpl.setGroupId(groupId);
		tthc_AttributeImpl.setUserId(userId);
		tthc_AttributeImpl.setTthcEntryId(tthcEntryId);
		tthc_AttributeImpl.setAttributeTypeId(attributeTypeId);
		tthc_AttributeImpl.setAttributeIndex(attributeIndex);

		if (attributeName == null) {
			tthc_AttributeImpl.setAttributeName(StringPool.BLANK);
		}
		else {
			tthc_AttributeImpl.setAttributeName(attributeName);
		}

		if (attributeValue == null) {
			tthc_AttributeImpl.setAttributeValue(StringPool.BLANK);
		}
		else {
			tthc_AttributeImpl.setAttributeValue(attributeValue);
		}

		if (createDate == Long.MIN_VALUE) {
			tthc_AttributeImpl.setCreateDate(null);
		}
		else {
			tthc_AttributeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tthc_AttributeImpl.setModifiedDate(null);
		}
		else {
			tthc_AttributeImpl.setModifiedDate(new Date(modifiedDate));
		}

		tthc_AttributeImpl.resetOriginalValues();

		return tthc_AttributeImpl;
	}

	public long attributeId;
	public long companyId;
	public long groupId;
	public long userId;
	public long tthcEntryId;
	public int attributeTypeId;
	public int attributeIndex;
	public String attributeName;
	public String attributeValue;
	public long createDate;
	public long modifiedDate;
}