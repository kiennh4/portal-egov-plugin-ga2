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

package com.portal_egov.portlet.tthc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class TTHC_AttributeClp extends BaseModelImpl<TTHC_Attribute>
	implements TTHC_Attribute {
	public TTHC_AttributeClp() {
	}

	public Class<?> getModelClass() {
		return TTHC_Attribute.class;
	}

	public String getModelClassName() {
		return TTHC_Attribute.class.getName();
	}

	public long getPrimaryKey() {
		return _attributeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAttributeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_attributeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attributeId", getAttributeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("tthcEntryId", getTthcEntryId());
		attributes.put("attributeTypeId", getAttributeTypeId());
		attributes.put("attributeIndex", getAttributeIndex());
		attributes.put("attributeName", getAttributeName());
		attributes.put("attributeValue", getAttributeValue());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attributeId = (Long)attributes.get("attributeId");

		if (attributeId != null) {
			setAttributeId(attributeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long tthcEntryId = (Long)attributes.get("tthcEntryId");

		if (tthcEntryId != null) {
			setTthcEntryId(tthcEntryId);
		}

		Integer attributeTypeId = (Integer)attributes.get("attributeTypeId");

		if (attributeTypeId != null) {
			setAttributeTypeId(attributeTypeId);
		}

		Integer attributeIndex = (Integer)attributes.get("attributeIndex");

		if (attributeIndex != null) {
			setAttributeIndex(attributeIndex);
		}

		String attributeName = (String)attributes.get("attributeName");

		if (attributeName != null) {
			setAttributeName(attributeName);
		}

		String attributeValue = (String)attributes.get("attributeValue");

		if (attributeValue != null) {
			setAttributeValue(attributeValue);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	public long getAttributeId() {
		return _attributeId;
	}

	public void setAttributeId(long attributeId) {
		_attributeId = attributeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getTthcEntryId() {
		return _tthcEntryId;
	}

	public void setTthcEntryId(long tthcEntryId) {
		_tthcEntryId = tthcEntryId;
	}

	public int getAttributeTypeId() {
		return _attributeTypeId;
	}

	public void setAttributeTypeId(int attributeTypeId) {
		_attributeTypeId = attributeTypeId;
	}

	public int getAttributeIndex() {
		return _attributeIndex;
	}

	public void setAttributeIndex(int attributeIndex) {
		_attributeIndex = attributeIndex;
	}

	public String getAttributeName() {
		return _attributeName;
	}

	public void setAttributeName(String attributeName) {
		_attributeName = attributeName;
	}

	public String getAttributeValue() {
		return _attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		_attributeValue = attributeValue;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public BaseModel<?> getTTHC_AttributeRemoteModel() {
		return _tthc_AttributeRemoteModel;
	}

	public void setTTHC_AttributeRemoteModel(
		BaseModel<?> tthc_AttributeRemoteModel) {
		_tthc_AttributeRemoteModel = tthc_AttributeRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TTHC_AttributeLocalServiceUtil.addTTHC_Attribute(this);
		}
		else {
			TTHC_AttributeLocalServiceUtil.updateTTHC_Attribute(this);
		}
	}

	@Override
	public TTHC_Attribute toEscapedModel() {
		return (TTHC_Attribute)Proxy.newProxyInstance(TTHC_Attribute.class.getClassLoader(),
			new Class[] { TTHC_Attribute.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TTHC_AttributeClp clone = new TTHC_AttributeClp();

		clone.setAttributeId(getAttributeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setTthcEntryId(getTthcEntryId());
		clone.setAttributeTypeId(getAttributeTypeId());
		clone.setAttributeIndex(getAttributeIndex());
		clone.setAttributeName(getAttributeName());
		clone.setAttributeValue(getAttributeValue());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(TTHC_Attribute tthc_Attribute) {
		int value = 0;

		if (getAttributeIndex() < tthc_Attribute.getAttributeIndex()) {
			value = -1;
		}
		else if (getAttributeIndex() > tthc_Attribute.getAttributeIndex()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TTHC_AttributeClp tthc_Attribute = null;

		try {
			tthc_Attribute = (TTHC_AttributeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tthc_Attribute.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{attributeId=");
		sb.append(getAttributeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", tthcEntryId=");
		sb.append(getTthcEntryId());
		sb.append(", attributeTypeId=");
		sb.append(getAttributeTypeId());
		sb.append(", attributeIndex=");
		sb.append(getAttributeIndex());
		sb.append(", attributeName=");
		sb.append(getAttributeName());
		sb.append(", attributeValue=");
		sb.append(getAttributeValue());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.tthc.model.TTHC_Attribute");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attributeId</column-name><column-value><![CDATA[");
		sb.append(getAttributeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tthcEntryId</column-name><column-value><![CDATA[");
		sb.append(getTthcEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeTypeId</column-name><column-value><![CDATA[");
		sb.append(getAttributeTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeIndex</column-name><column-value><![CDATA[");
		sb.append(getAttributeIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeName</column-name><column-value><![CDATA[");
		sb.append(getAttributeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeValue</column-name><column-value><![CDATA[");
		sb.append(getAttributeValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _attributeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _tthcEntryId;
	private int _attributeTypeId;
	private int _attributeIndex;
	private String _attributeName;
	private String _attributeValue;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _tthc_AttributeRemoteModel;
}