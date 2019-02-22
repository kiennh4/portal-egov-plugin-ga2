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

package com.portal_egov.portlet.inquiry.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.inquiry.service.http.OnlineInquiryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.inquiry.service.http.OnlineInquiryServiceSoap
 * @generated
 */
public class OnlineInquirySoap implements Serializable {
	public static OnlineInquirySoap toSoapModel(OnlineInquiry model) {
		OnlineInquirySoap soapModel = new OnlineInquirySoap();

		soapModel.setInquiryId(model.getInquiryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFullName(model.getFullName());
		soapModel.setPhoneNumbers(model.getPhoneNumbers());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setInquiryContent(model.getInquiryContent());
		soapModel.setInquiryStatus(model.getInquiryStatus());

		return soapModel;
	}

	public static OnlineInquirySoap[] toSoapModels(OnlineInquiry[] models) {
		OnlineInquirySoap[] soapModels = new OnlineInquirySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OnlineInquirySoap[][] toSoapModels(OnlineInquiry[][] models) {
		OnlineInquirySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OnlineInquirySoap[models.length][models[0].length];
		}
		else {
			soapModels = new OnlineInquirySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OnlineInquirySoap[] toSoapModels(List<OnlineInquiry> models) {
		List<OnlineInquirySoap> soapModels = new ArrayList<OnlineInquirySoap>(models.size());

		for (OnlineInquiry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OnlineInquirySoap[soapModels.size()]);
	}

	public OnlineInquirySoap() {
	}

	public long getPrimaryKey() {
		return _inquiryId;
	}

	public void setPrimaryKey(long pk) {
		setInquiryId(pk);
	}

	public long getInquiryId() {
		return _inquiryId;
	}

	public void setInquiryId(long inquiryId) {
		_inquiryId = inquiryId;
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getPhoneNumbers() {
		return _phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		_phoneNumbers = phoneNumbers;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getInquiryContent() {
		return _inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		_inquiryContent = inquiryContent;
	}

	public int getInquiryStatus() {
		return _inquiryStatus;
	}

	public void setInquiryStatus(int inquiryStatus) {
		_inquiryStatus = inquiryStatus;
	}

	private long _inquiryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fullName;
	private String _phoneNumbers;
	private String _emailAddress;
	private String _inquiryContent;
	private int _inquiryStatus;
}