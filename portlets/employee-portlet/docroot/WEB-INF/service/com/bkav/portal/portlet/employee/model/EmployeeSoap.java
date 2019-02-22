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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.employee.service.http.EmployeeServiceSoap}.
 *
 * @author    ducdvd
 * @see       com.bkav.portal.portlet.employee.service.http.EmployeeServiceSoap
 * @generated
 */
public class EmployeeSoap implements Serializable {
	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setEmplId(model.getEmplId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setMale(model.getMale());
		soapModel.setPhone(model.getPhone());
		soapModel.setAddres(model.getAddres());
		soapModel.setEmail(model.getEmail());
		soapModel.setPostId(model.getPostId());
		soapModel.setDepId(model.getDepId());
		soapModel.setSal(model.getSal());
		soapModel.setBreakDay(model.getBreakDay());
		soapModel.setAddDay(model.getAddDay());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _emplId;
	}

	public void setPrimaryKey(long pk) {
		setEmplId(pk);
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

	private long _emplId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}