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

import com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil;

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
public class EmployeeClp extends BaseModelImpl<Employee> implements Employee {
	public EmployeeClp() {
	}

	public Class<?> getModelClass() {
		return Employee.class;
	}

	public String getModelClassName() {
		return Employee.class.getName();
	}

	public long getPrimaryKey() {
		return _emplId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEmplId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_emplId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emplId", getEmplId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("birthday", getBirthday());
		attributes.put("male", getMale());
		attributes.put("phone", getPhone());
		attributes.put("addres", getAddres());
		attributes.put("email", getEmail());
		attributes.put("postId", getPostId());
		attributes.put("depId", getDepId());
		attributes.put("sal", getSal());
		attributes.put("breakDay", getBreakDay());
		attributes.put("addDay", getAddDay());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emplId = (Long)attributes.get("emplId");

		if (emplId != null) {
			setEmplId(emplId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String male = (String)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Long phone = (Long)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String addres = (String)attributes.get("addres");

		if (addres != null) {
			setAddres(addres);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
		}

		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
		}

		Long sal = (Long)attributes.get("sal");

		if (sal != null) {
			setSal(sal);
		}

		Integer breakDay = (Integer)attributes.get("breakDay");

		if (breakDay != null) {
			setBreakDay(breakDay);
		}

		Integer addDay = (Integer)attributes.get("addDay");

		if (addDay != null) {
			setAddDay(addDay);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	public long getEmplId() {
		return _emplId;
	}

	public void setEmplId(long emplId) {
		_emplId = emplId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getMale() {
		return _male;
	}

	public void setMale(String male) {
		_male = male;
	}

	public long getPhone() {
		return _phone;
	}

	public void setPhone(long phone) {
		_phone = phone;
	}

	public String getAddres() {
		return _addres;
	}

	public void setAddres(String addres) {
		_addres = addres;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getDepId() {
		return _depId;
	}

	public void setDepId(long depId) {
		_depId = depId;
	}

	public long getSal() {
		return _sal;
	}

	public void setSal(long sal) {
		_sal = sal;
	}

	public int getBreakDay() {
		return _breakDay;
	}

	public void setBreakDay(int breakDay) {
		_breakDay = breakDay;
	}

	public int getAddDay() {
		return _addDay;
	}

	public void setAddDay(int addDay) {
		_addDay = addDay;
	}

	public String getEndDate() {
		return _endDate;
	}

	public void setEndDate(String endDate) {
		_endDate = endDate;
	}

	public BaseModel<?> getEmployeeRemoteModel() {
		return _employeeRemoteModel;
	}

	public void setEmployeeRemoteModel(BaseModel<?> employeeRemoteModel) {
		_employeeRemoteModel = employeeRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeLocalServiceUtil.addEmployee(this);
		}
		else {
			EmployeeLocalServiceUtil.updateEmployee(this);
		}
	}

	@Override
	public Employee toEscapedModel() {
		return (Employee)Proxy.newProxyInstance(Employee.class.getClassLoader(),
			new Class[] { Employee.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeClp clone = new EmployeeClp();

		clone.setEmplId(getEmplId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setBirthday(getBirthday());
		clone.setMale(getMale());
		clone.setPhone(getPhone());
		clone.setAddres(getAddres());
		clone.setEmail(getEmail());
		clone.setPostId(getPostId());
		clone.setDepId(getDepId());
		clone.setSal(getSal());
		clone.setBreakDay(getBreakDay());
		clone.setAddDay(getAddDay());
		clone.setEndDate(getEndDate());

		return clone;
	}

	public int compareTo(Employee employee) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), employee.getCreateDate());

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

		EmployeeClp employee = null;

		try {
			employee = (EmployeeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = employee.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{emplId=");
		sb.append(getEmplId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", male=");
		sb.append(getMale());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", addres=");
		sb.append(getAddres());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", postId=");
		sb.append(getPostId());
		sb.append(", depId=");
		sb.append(getDepId());
		sb.append(", sal=");
		sb.append(getSal());
		sb.append(", breakDay=");
		sb.append(getBreakDay());
		sb.append(", addDay=");
		sb.append(getAddDay());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.employee.model.Employee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>emplId</column-name><column-value><![CDATA[");
		sb.append(getEmplId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>male</column-name><column-value><![CDATA[");
		sb.append(getMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addres</column-name><column-value><![CDATA[");
		sb.append(getAddres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postId</column-name><column-value><![CDATA[");
		sb.append(getPostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depId</column-name><column-value><![CDATA[");
		sb.append(getDepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sal</column-name><column-value><![CDATA[");
		sb.append(getSal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>breakDay</column-name><column-value><![CDATA[");
		sb.append(getBreakDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addDay</column-name><column-value><![CDATA[");
		sb.append(getAddDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _emplId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private Date _birthday;
	private String _male;
	private long _phone;
	private String _addres;
	private String _email;
	private long _postId;
	private long _depId;
	private long _sal;
	private int _breakDay;
	private int _addDay;
	private String _endDate;
	private BaseModel<?> _employeeRemoteModel;
}