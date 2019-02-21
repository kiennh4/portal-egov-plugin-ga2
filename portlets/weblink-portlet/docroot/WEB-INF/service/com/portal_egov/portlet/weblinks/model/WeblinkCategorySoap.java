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

package com.portal_egov.portlet.weblinks.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.weblinks.service.http.WeblinkCategoryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.weblinks.service.http.WeblinkCategoryServiceSoap
 * @generated
 */
public class WeblinkCategorySoap implements Serializable {
	public static WeblinkCategorySoap toSoapModel(WeblinkCategory model) {
		WeblinkCategorySoap soapModel = new WeblinkCategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCategoryDesc(model.getCategoryDesc());
		soapModel.setCategoryIconId(model.getCategoryIconId());

		return soapModel;
	}

	public static WeblinkCategorySoap[] toSoapModels(WeblinkCategory[] models) {
		WeblinkCategorySoap[] soapModels = new WeblinkCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WeblinkCategorySoap[][] toSoapModels(
		WeblinkCategory[][] models) {
		WeblinkCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WeblinkCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new WeblinkCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WeblinkCategorySoap[] toSoapModels(
		List<WeblinkCategory> models) {
		List<WeblinkCategorySoap> soapModels = new ArrayList<WeblinkCategorySoap>(models.size());

		for (WeblinkCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WeblinkCategorySoap[soapModels.size()]);
	}

	public WeblinkCategorySoap() {
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

	public long getCategoryIconId() {
		return _categoryIconId;
	}

	public void setCategoryIconId(long categoryIconId) {
		_categoryIconId = categoryIconId;
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
	private long _categoryIconId;
}