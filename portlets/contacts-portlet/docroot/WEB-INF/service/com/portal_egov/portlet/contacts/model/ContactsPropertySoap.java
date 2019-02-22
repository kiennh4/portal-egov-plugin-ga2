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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.contacts.service.http.ContactsPropertyServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.contacts.service.http.ContactsPropertyServiceSoap
 * @generated
 */
public class ContactsPropertySoap implements Serializable {
	public static ContactsPropertySoap toSoapModel(ContactsProperty model) {
		ContactsPropertySoap soapModel = new ContactsPropertySoap();

		soapModel.setPropertyId(model.getPropertyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setContactId(model.getContactId());
		soapModel.setPropertyKey(model.getPropertyKey());
		soapModel.setPropertyValue(model.getPropertyValue());
		soapModel.setPropertyType(model.getPropertyType());

		return soapModel;
	}

	public static ContactsPropertySoap[] toSoapModels(ContactsProperty[] models) {
		ContactsPropertySoap[] soapModels = new ContactsPropertySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactsPropertySoap[][] toSoapModels(
		ContactsProperty[][] models) {
		ContactsPropertySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactsPropertySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactsPropertySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactsPropertySoap[] toSoapModels(
		List<ContactsProperty> models) {
		List<ContactsPropertySoap> soapModels = new ArrayList<ContactsPropertySoap>(models.size());

		for (ContactsProperty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactsPropertySoap[soapModels.size()]);
	}

	public ContactsPropertySoap() {
	}

	public long getPrimaryKey() {
		return _propertyId;
	}

	public void setPrimaryKey(long pk) {
		setPropertyId(pk);
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

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
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

	private long _propertyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _contactId;
	private String _propertyKey;
	private String _propertyValue;
	private String _propertyType;
}