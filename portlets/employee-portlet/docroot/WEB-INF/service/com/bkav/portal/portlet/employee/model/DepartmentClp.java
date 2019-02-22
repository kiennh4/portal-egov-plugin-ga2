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

package com.bkav.portal.portlet.employee.model;

import com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ducdvd
 */
public class DepartmentClp extends BaseModelImpl<Department>
	implements Department {
	public DepartmentClp() {
	}

	public Class<?> getModelClass() {
		return Department.class;
	}

	public String getModelClassName() {
		return Department.class.getName();
	}

	public long getPrimaryKey() {
		return _depId;
	}

	public void setPrimaryKey(long primaryKey) {
		setDepId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_depId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("depId", getDepId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("depName", getDepName());
		attributes.put("depAddres", getDepAddres());
		attributes.put("depPhone", getDepPhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
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

		String depName = (String)attributes.get("depName");

		if (depName != null) {
			setDepName(depName);
		}

		String depAddres = (String)attributes.get("depAddres");

		if (depAddres != null) {
			setDepAddres(depAddres);
		}

		String depPhone = (String)attributes.get("depPhone");

		if (depPhone != null) {
			setDepPhone(depPhone);
		}
	}

	public long getDepId() {
		return _depId;
	}

	public void setDepId(long depId) {
		_depId = depId;
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

	public String getDepName() {
		return _depName;
	}

	public void setDepName(String depName) {
		_depName = depName;
	}

	public String getDepAddres() {
		return _depAddres;
	}

	public void setDepAddres(String depAddres) {
		_depAddres = depAddres;
	}

	public String getDepPhone() {
		return _depPhone;
	}

	public void setDepPhone(String depPhone) {
		_depPhone = depPhone;
	}

	public BaseModel<?> getDepartmentRemoteModel() {
		return _departmentRemoteModel;
	}

	public void setDepartmentRemoteModel(BaseModel<?> departmentRemoteModel) {
		_departmentRemoteModel = departmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DepartmentLocalServiceUtil.addDepartment(this);
		}
		else {
			DepartmentLocalServiceUtil.updateDepartment(this);
		}
	}

	@Override
	public Department toEscapedModel() {
		return (Department)Proxy.newProxyInstance(Department.class.getClassLoader(),
			new Class[] { Department.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DepartmentClp clone = new DepartmentClp();

		clone.setDepId(getDepId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDepName(getDepName());
		clone.setDepAddres(getDepAddres());
		clone.setDepPhone(getDepPhone());

		return clone;
	}

	public int compareTo(Department department) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), department.getCreateDate());

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

		DepartmentClp department = null;

		try {
			department = (DepartmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = department.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{depId=");
		sb.append(getDepId());
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
		sb.append(", depName=");
		sb.append(getDepName());
		sb.append(", depAddres=");
		sb.append(getDepAddres());
		sb.append(", depPhone=");
		sb.append(getDepPhone());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.employee.model.Department");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>depId</column-name><column-value><![CDATA[");
		sb.append(getDepId());
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
			"<column><column-name>depName</column-name><column-value><![CDATA[");
		sb.append(getDepName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depAddres</column-name><column-value><![CDATA[");
		sb.append(getDepAddres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depPhone</column-name><column-value><![CDATA[");
		sb.append(getDepPhone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _depId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _depName;
	private String _depAddres;
	private String _depPhone;
	private BaseModel<?> _departmentRemoteModel;
}