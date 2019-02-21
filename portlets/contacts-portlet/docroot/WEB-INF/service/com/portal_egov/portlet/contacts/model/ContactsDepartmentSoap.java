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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.contacts.service.http.ContactsDepartmentServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.contacts.service.http.ContactsDepartmentServiceSoap
 * @generated
 */
public class ContactsDepartmentSoap implements Serializable {
	public static ContactsDepartmentSoap toSoapModel(ContactsDepartment model) {
		ContactsDepartmentSoap soapModel = new ContactsDepartmentSoap();

		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setParentId(model.getParentId());
		soapModel.setDepartmentName(model.getDepartmentName());
		soapModel.setDepartmentAddress(model.getDepartmentAddress());
		soapModel.setDepartmentPhone(model.getDepartmentPhone());
		soapModel.setDepartmentWebsite(model.getDepartmentWebsite());
		soapModel.setDepartmentEmail(model.getDepartmentEmail());
		soapModel.setDisplayPriority(model.getDisplayPriority());
		soapModel.setDepartmentStatus(model.getDepartmentStatus());

		return soapModel;
	}

	public static ContactsDepartmentSoap[] toSoapModels(
		ContactsDepartment[] models) {
		ContactsDepartmentSoap[] soapModels = new ContactsDepartmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactsDepartmentSoap[][] toSoapModels(
		ContactsDepartment[][] models) {
		ContactsDepartmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactsDepartmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactsDepartmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactsDepartmentSoap[] toSoapModels(
		List<ContactsDepartment> models) {
		List<ContactsDepartmentSoap> soapModels = new ArrayList<ContactsDepartmentSoap>(models.size());

		for (ContactsDepartment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactsDepartmentSoap[soapModels.size()]);
	}

	public ContactsDepartmentSoap() {
	}

	public long getPrimaryKey() {
		return _departmentId;
	}

	public void setPrimaryKey(long pk) {
		setDepartmentId(pk);
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

	private long _departmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}