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

package com.portal_egov.portlet.tthc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.tthc.service.http.TTHC_CategoryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.tthc.service.http.TTHC_CategoryServiceSoap
 * @generated
 */
public class TTHC_CategorySoap implements Serializable {
	public static TTHC_CategorySoap toSoapModel(TTHC_Category model) {
		TTHC_CategorySoap soapModel = new TTHC_CategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setParentId(model.getParentId());
		soapModel.setCategoryTypeId(model.getCategoryTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCategoryDesc(model.getCategoryDesc());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDisplayPriority(model.getDisplayPriority());

		return soapModel;
	}

	public static TTHC_CategorySoap[] toSoapModels(TTHC_Category[] models) {
		TTHC_CategorySoap[] soapModels = new TTHC_CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTHC_CategorySoap[][] toSoapModels(TTHC_Category[][] models) {
		TTHC_CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTHC_CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTHC_CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTHC_CategorySoap[] toSoapModels(List<TTHC_Category> models) {
		List<TTHC_CategorySoap> soapModels = new ArrayList<TTHC_CategorySoap>(models.size());

		for (TTHC_Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTHC_CategorySoap[soapModels.size()]);
	}

	public TTHC_CategorySoap() {
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

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public int getCategoryTypeId() {
		return _categoryTypeId;
	}

	public void setCategoryTypeId(int categoryTypeId) {
		_categoryTypeId = categoryTypeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_displayPriority = displayPriority;
	}

	private long _categoryId;
	private long _parentId;
	private int _categoryTypeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _categoryName;
	private String _categoryDesc;
	private Date _createDate;
	private Date _modifiedDate;
	private int _displayPriority;
}