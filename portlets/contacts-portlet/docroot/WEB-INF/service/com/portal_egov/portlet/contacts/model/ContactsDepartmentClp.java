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

import com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class ContactsDepartmentClp extends BaseModelImpl<ContactsDepartment>
	implements ContactsDepartment {
	public ContactsDepartmentClp() {
	}

	public Class<?> getModelClass() {
		return ContactsDepartment.class;
	}

	public String getModelClassName() {
		return ContactsDepartment.class.getName();
	}

	public long getPrimaryKey() {
		return _departmentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDepartmentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_departmentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentId", getParentId());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("departmentAddress", getDepartmentAddress());
		attributes.put("departmentPhone", getDepartmentPhone());
		attributes.put("departmentWebsite", getDepartmentWebsite());
		attributes.put("departmentEmail", getDepartmentEmail());
		attributes.put("displayPriority", getDisplayPriority());
		attributes.put("departmentStatus", getDepartmentStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
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

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String departmentAddress = (String)attributes.get("departmentAddress");

		if (departmentAddress != null) {
			setDepartmentAddress(departmentAddress);
		}

		String departmentPhone = (String)attributes.get("departmentPhone");

		if (departmentPhone != null) {
			setDepartmentPhone(departmentPhone);
		}

		String departmentWebsite = (String)attributes.get("departmentWebsite");

		if (departmentWebsite != null) {
			setDepartmentWebsite(departmentWebsite);
		}

		String departmentEmail = (String)attributes.get("departmentEmail");

		if (departmentEmail != null) {
			setDepartmentEmail(departmentEmail);
		}

		Integer displayPriority = (Integer)attributes.get("displayPriority");

		if (displayPriority != null) {
			setDisplayPriority(displayPriority);
		}

		Integer departmentStatus = (Integer)attributes.get("departmentStatus");

		if (departmentStatus != null) {
			setDepartmentStatus(departmentStatus);
		}
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
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

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getDepartmentName() {
		return _departmentName;
	}

	public void setDepartmentName(String departmentName) {
		_departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return _departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		_departmentAddress = departmentAddress;
	}

	public String getDepartmentPhone() {
		return _departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		_departmentPhone = departmentPhone;
	}

	public String getDepartmentWebsite() {
		return _departmentWebsite;
	}

	public void setDepartmentWebsite(String departmentWebsite) {
		_departmentWebsite = departmentWebsite;
	}

	public String getDepartmentEmail() {
		return _departmentEmail;
	}

	public void setDepartmentEmail(String departmentEmail) {
		_departmentEmail = departmentEmail;
	}

	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_displayPriority = displayPriority;
	}

	public int getDepartmentStatus() {
		return _departmentStatus;
	}

	public void setDepartmentStatus(int departmentStatus) {
		_departmentStatus = departmentStatus;
	}

	public BaseModel<?> getContactsDepartmentRemoteModel() {
		return _contactsDepartmentRemoteModel;
	}

	public void setContactsDepartmentRemoteModel(
		BaseModel<?> contactsDepartmentRemoteModel) {
		_contactsDepartmentRemoteModel = contactsDepartmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactsDepartmentLocalServiceUtil.addContactsDepartment(this);
		}
		else {
			ContactsDepartmentLocalServiceUtil.updateContactsDepartment(this);
		}
	}

	@Override
	public ContactsDepartment toEscapedModel() {
		return (ContactsDepartment)Proxy.newProxyInstance(ContactsDepartment.class.getClassLoader(),
			new Class[] { ContactsDepartment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactsDepartmentClp clone = new ContactsDepartmentClp();

		clone.setDepartmentId(getDepartmentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setParentId(getParentId());
		clone.setDepartmentName(getDepartmentName());
		clone.setDepartmentAddress(getDepartmentAddress());
		clone.setDepartmentPhone(getDepartmentPhone());
		clone.setDepartmentWebsite(getDepartmentWebsite());
		clone.setDepartmentEmail(getDepartmentEmail());
		clone.setDisplayPriority(getDisplayPriority());
		clone.setDepartmentStatus(getDepartmentStatus());

		return clone;
	}

	public int compareTo(ContactsDepartment contactsDepartment) {
		int value = 0;

		if (getParentId() < contactsDepartment.getParentId()) {
			value = -1;
		}
		else if (getParentId() > contactsDepartment.getParentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDisplayPriority() < contactsDepartment.getDisplayPriority()) {
			value = -1;
		}
		else if (getDisplayPriority() > contactsDepartment.getDisplayPriority()) {
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

		ContactsDepartmentClp contactsDepartment = null;

		try {
			contactsDepartment = (ContactsDepartmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contactsDepartment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{departmentId=");
		sb.append(getDepartmentId());
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
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", departmentName=");
		sb.append(getDepartmentName());
		sb.append(", departmentAddress=");
		sb.append(getDepartmentAddress());
		sb.append(", departmentPhone=");
		sb.append(getDepartmentPhone());
		sb.append(", departmentWebsite=");
		sb.append(getDepartmentWebsite());
		sb.append(", departmentEmail=");
		sb.append(getDepartmentEmail());
		sb.append(", displayPriority=");
		sb.append(getDisplayPriority());
		sb.append(", departmentStatus=");
		sb.append(getDepartmentStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.contacts.model.ContactsDepartment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
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
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentName</column-name><column-value><![CDATA[");
		sb.append(getDepartmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentAddress</column-name><column-value><![CDATA[");
		sb.append(getDepartmentAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentPhone</column-name><column-value><![CDATA[");
		sb.append(getDepartmentPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentWebsite</column-name><column-value><![CDATA[");
		sb.append(getDepartmentWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentEmail</column-name><column-value><![CDATA[");
		sb.append(getDepartmentEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPriority</column-name><column-value><![CDATA[");
		sb.append(getDisplayPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentStatus</column-name><column-value><![CDATA[");
		sb.append(getDepartmentStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _departmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _parentId;
	private String _departmentName;
	private String _departmentAddress;
	private String _departmentPhone;
	private String _departmentWebsite;
	private String _departmentEmail;
	private int _displayPriority;
	private int _departmentStatus;
	private BaseModel<?> _contactsDepartmentRemoteModel;
}