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

package com.portal_egov.portlet.contacts.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class ContactsDepartmentPropertyClp extends BaseModelImpl<ContactsDepartmentProperty>
	implements ContactsDepartmentProperty {
	public ContactsDepartmentPropertyClp() {
	}

	public Class<?> getModelClass() {
		return ContactsDepartmentProperty.class;
	}

	public String getModelClassName() {
		return ContactsDepartmentProperty.class.getName();
	}

	public long getPrimaryKey() {
		return _propertyId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPropertyId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_propertyId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("propertyId", getPropertyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("propertyKey", getPropertyKey());
		attributes.put("propertyValue", getPropertyValue());
		attributes.put("propertyType", getPropertyType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String propertyKey = (String)attributes.get("propertyKey");

		if (propertyKey != null) {
			setPropertyKey(propertyKey);
		}

		String propertyValue = (String)attributes.get("propertyValue");

		if (propertyValue != null) {
			setPropertyValue(propertyValue);
		}

		String propertyType = (String)attributes.get("propertyType");

		if (propertyType != null) {
			setPropertyType(propertyType);
		}
	}

	public long getPropertyId() {
		return _propertyId;
	}

	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public String getPropertyKey() {
		return _propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		_propertyKey = propertyKey;
	}

	public String getPropertyValue() {
		return _propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		_propertyValue = propertyValue;
	}

	public String getPropertyType() {
		return _propertyType;
	}

	public void setPropertyType(String propertyType) {
		_propertyType = propertyType;
	}

	public BaseModel<?> getContactsDepartmentPropertyRemoteModel() {
		return _contactsDepartmentPropertyRemoteModel;
	}

	public void setContactsDepartmentPropertyRemoteModel(
		BaseModel<?> contactsDepartmentPropertyRemoteModel) {
		_contactsDepartmentPropertyRemoteModel = contactsDepartmentPropertyRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactsDepartmentPropertyLocalServiceUtil.addContactsDepartmentProperty(this);
		}
		else {
			ContactsDepartmentPropertyLocalServiceUtil.updateContactsDepartmentProperty(this);
		}
	}

	@Override
	public ContactsDepartmentProperty toEscapedModel() {
		return (ContactsDepartmentProperty)Proxy.newProxyInstance(ContactsDepartmentProperty.class.getClassLoader(),
			new Class[] { ContactsDepartmentProperty.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactsDepartmentPropertyClp clone = new ContactsDepartmentPropertyClp();

		clone.setPropertyId(getPropertyId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDepartmentId(getDepartmentId());
		clone.setPropertyKey(getPropertyKey());
		clone.setPropertyValue(getPropertyValue());
		clone.setPropertyType(getPropertyType());

		return clone;
	}

	public int compareTo(ContactsDepartmentProperty contactsDepartmentProperty) {
		int value = 0;

		if (getDepartmentId() < contactsDepartmentProperty.getDepartmentId()) {
			value = -1;
		}
		else if (getDepartmentId() > contactsDepartmentProperty.getDepartmentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getPropertyKey().toLowerCase()
					.compareTo(contactsDepartmentProperty.getPropertyKey()
														 .toLowerCase());

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

		ContactsDepartmentPropertyClp contactsDepartmentProperty = null;

		try {
			contactsDepartmentProperty = (ContactsDepartmentPropertyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contactsDepartmentProperty.getPrimaryKey();

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

		sb.append("{propertyId=");
		sb.append(getPropertyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", propertyKey=");
		sb.append(getPropertyKey());
		sb.append(", propertyValue=");
		sb.append(getPropertyValue());
		sb.append(", propertyType=");
		sb.append(getPropertyType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>propertyId</column-name><column-value><![CDATA[");
		sb.append(getPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propertyKey</column-name><column-value><![CDATA[");
		sb.append(getPropertyKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propertyValue</column-name><column-value><![CDATA[");
		sb.append(getPropertyValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propertyType</column-name><column-value><![CDATA[");
		sb.append(getPropertyType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _propertyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _departmentId;
	private String _propertyKey;
	private String _propertyValue;
	private String _propertyType;
	private BaseModel<?> _contactsDepartmentPropertyRemoteModel;
}