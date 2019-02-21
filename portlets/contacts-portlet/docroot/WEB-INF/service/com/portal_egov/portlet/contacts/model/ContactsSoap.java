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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.contacts.service.http.ContactsServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.contacts.service.http.ContactsServiceSoap
 * @generated
 */
public class ContactsSoap implements Serializable {
	public static ContactsSoap toSoapModel(Contacts model) {
		ContactsSoap soapModel = new ContactsSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setImageId(model.getImageId());
		soapModel.setContactName(model.getContactName());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setPhoneNumbers(model.getPhoneNumbers());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobile(model.getMobile());
		soapModel.setEmail(model.getEmail());
		soapModel.setDisplayPriority(model.getDisplayPriority());
		soapModel.setContactStatus(model.getContactStatus());

		return soapModel;
	}

	public static ContactsSoap[] toSoapModels(Contacts[] models) {
		ContactsSoap[] soapModels = new ContactsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactsSoap[][] toSoapModels(Contacts[][] models) {
		ContactsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactsSoap[] toSoapModels(List<Contacts> models) {
		List<ContactsSoap> soapModels = new ArrayList<ContactsSoap>(models.size());

		for (Contacts model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactsSoap[soapModels.size()]);
	}

	public ContactsSoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
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

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getPhoneNumbers() {
		return _phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		_phoneNumbers = phoneNumbers;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_displayPriority = displayPriority;
	}

	public int getContactStatus() {
		return _contactStatus;
	}

	public void setContactStatus(int contactStatus) {
		_contactStatus = contactStatus;
	}

	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _departmentId;
	private long _imageId;
	private String _contactName;
	private String _jobTitle;
	private String _phoneNumbers;
	private String _homePhone;
	private String _mobile;
	private String _email;
	private int _displayPriority;
	private int _contactStatus;
}