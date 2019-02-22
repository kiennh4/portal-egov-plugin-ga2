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
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.employee.service.http.DepartmentServiceSoap}.
 *
 * @author    ducdvd
 * @see       com.bkav.portal.portlet.employee.service.http.DepartmentServiceSoap
 * @generated
 */
public class DepartmentSoap implements Serializable {
	public static DepartmentSoap toSoapModel(Department model) {
		DepartmentSoap soapModel = new DepartmentSoap();

		soapModel.setDepId(model.getDepId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDepName(model.getDepName());
		soapModel.setDepAddres(model.getDepAddres());
		soapModel.setDepPhone(model.getDepPhone());

		return soapModel;
	}

	public static DepartmentSoap[] toSoapModels(Department[] models) {
		DepartmentSoap[] soapModels = new DepartmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepartmentSoap[][] toSoapModels(Department[][] models) {
		DepartmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DepartmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepartmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepartmentSoap[] toSoapModels(List<Department> models) {
		List<DepartmentSoap> soapModels = new ArrayList<DepartmentSoap>(models.size());

		for (Department model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DepartmentSoap[soapModels.size()]);
	}

	public DepartmentSoap() {
	}

	public long getPrimaryKey() {
		return _depId;
	}

	public void setPrimaryKey(long pk) {
		setDepId(pk);
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

	private long _depId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _depName;
	private String _depAddres;
	private String _depPhone;
}