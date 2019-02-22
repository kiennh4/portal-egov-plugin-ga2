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

package com.portal_egov.portlet.citizen_inquiry.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.citizen_inquiry.service.http.CitizenInquiryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.citizen_inquiry.service.http.CitizenInquiryServiceSoap
 * @generated
 */
public class CitizenInquirySoap implements Serializable {
	public static CitizenInquirySoap toSoapModel(CitizenInquiry model) {
		CitizenInquirySoap soapModel = new CitizenInquirySoap();

		soapModel.setInquiryId(model.getInquiryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCitizenName(model.getCitizenName());
		soapModel.setCitizenPhone(model.getCitizenPhone());
		soapModel.setCitizenEmail(model.getCitizenEmail());
		soapModel.setCitizenAddress(model.getCitizenAddress());
		soapModel.setInquiryTitle(model.getInquiryTitle());
		soapModel.setInquiryContent(model.getInquiryContent());
		soapModel.setInquiryFeedback(model.getInquiryFeedback());
		soapModel.setInquiryFeedbackUser(model.getInquiryFeedbackUser());
		soapModel.setInquiryFeedbackDate(model.getInquiryFeedbackDate());
		soapModel.setInquiryStatus(model.getInquiryStatus());
		soapModel.setApproved(model.getApproved());

		return soapModel;
	}

	public static CitizenInquirySoap[] toSoapModels(CitizenInquiry[] models) {
		CitizenInquirySoap[] soapModels = new CitizenInquirySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CitizenInquirySoap[][] toSoapModels(CitizenInquiry[][] models) {
		CitizenInquirySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CitizenInquirySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CitizenInquirySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CitizenInquirySoap[] toSoapModels(List<CitizenInquiry> models) {
		List<CitizenInquirySoap> soapModels = new ArrayList<CitizenInquirySoap>(models.size());

		for (CitizenInquiry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CitizenInquirySoap[soapModels.size()]);
	}

	public CitizenInquirySoap() {
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCitizenName() {
		return _citizenName;
	}

	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	public String getCitizenPhone() {
		return _citizenPhone;
	}

	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	public String getCitizenEmail() {
		return _citizenEmail;
	}

	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	public String getCitizenAddress() {
		return _citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		_citizenAddress = citizenAddress;
	}

	public String getInquiryTitle() {
		return _inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		_inquiryTitle = inquiryTitle;
	}

	public String getInquiryContent() {
		return _inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		_inquiryContent = inquiryContent;
	}

	public String getInquiryFeedback() {
		return _inquiryFeedback;
	}

	public void setInquiryFeedback(String inquiryFeedback) {
		_inquiryFeedback = inquiryFeedback;
	}

	public String getInquiryFeedbackUser() {
		return _inquiryFeedbackUser;
	}

	public void setInquiryFeedbackUser(String inquiryFeedbackUser) {
		_inquiryFeedbackUser = inquiryFeedbackUser;
	}

	public Date getInquiryFeedbackDate() {
		return _inquiryFeedbackDate;
	}

	public void setInquiryFeedbackDate(Date inquiryFeedbackDate) {
		_inquiryFeedbackDate = inquiryFeedbackDate;
	}

	public int getInquiryStatus() {
		return _inquiryStatus;
	}

	public void setInquiryStatus(int inquiryStatus) {
		_inquiryStatus = inquiryStatus;
	}

	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
	}

	private long _inquiryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private String _citizenAddress;
	private String _inquiryTitle;
	private String _inquiryContent;
	private String _inquiryFeedback;
	private String _inquiryFeedbackUser;
	private Date _inquiryFeedbackDate;
	private int _inquiryStatus;
	private boolean _approved;
}