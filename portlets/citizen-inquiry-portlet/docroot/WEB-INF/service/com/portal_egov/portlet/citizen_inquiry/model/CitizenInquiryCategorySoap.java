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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.citizen_inquiry.service.http.CitizenInquiryCategoryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.citizen_inquiry.service.http.CitizenInquiryCategoryServiceSoap
 * @generated
 */
public class CitizenInquiryCategorySoap implements Serializable {
	public static CitizenInquiryCategorySoap toSoapModel(
		CitizenInquiryCategory model) {
		CitizenInquiryCategorySoap soapModel = new CitizenInquiryCategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCategoryDesc(model.getCategoryDesc());

		return soapModel;
	}

	public static CitizenInquiryCategorySoap[] toSoapModels(
		CitizenInquiryCategory[] models) {
		CitizenInquiryCategorySoap[] soapModels = new CitizenInquiryCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CitizenInquiryCategorySoap[][] toSoapModels(
		CitizenInquiryCategory[][] models) {
		CitizenInquiryCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CitizenInquiryCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CitizenInquiryCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CitizenInquiryCategorySoap[] toSoapModels(
		List<CitizenInquiryCategory> models) {
		List<CitizenInquiryCategorySoap> soapModels = new ArrayList<CitizenInquiryCategorySoap>(models.size());

		for (CitizenInquiryCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CitizenInquiryCategorySoap[soapModels.size()]);
	}

	public CitizenInquiryCategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return _categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		_categoryDesc = categoryDesc;
	}

	private long _categoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _categoryName;
	private String _categoryDesc;
}