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

package com.portal_egov.portlet.vbpq.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.vbpq.service.http.VBPQ_CategoryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.vbpq.service.http.VBPQ_CategoryServiceSoap
 * @generated
 */
public class VBPQ_CategorySoap implements Serializable {
	public static VBPQ_CategorySoap toSoapModel(VBPQ_Category model) {
		VBPQ_CategorySoap soapModel = new VBPQ_CategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setParentId(model.getParentId());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCategoryDesc(model.getCategoryDesc());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());
		soapModel.setDisplayPriority(model.getDisplayPriority());

		return soapModel;
	}

	public static VBPQ_CategorySoap[] toSoapModels(VBPQ_Category[] models) {
		VBPQ_CategorySoap[] soapModels = new VBPQ_CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VBPQ_CategorySoap[][] toSoapModels(VBPQ_Category[][] models) {
		VBPQ_CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VBPQ_CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VBPQ_CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VBPQ_CategorySoap[] toSoapModels(List<VBPQ_Category> models) {
		List<VBPQ_CategorySoap> soapModels = new ArrayList<VBPQ_CategorySoap>(models.size());

		for (VBPQ_Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VBPQ_CategorySoap[soapModels.size()]);
	}

	public VBPQ_CategorySoap() {
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

	public int getTypeId() {
		return _typeId;
	}

	public void setTypeId(int typeId) {
		_typeId = typeId;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public int getDisplayPriority() {
		return _displayPriority;
	}

	public void setDisplayPriority(int displayPriority) {
		_displayPriority = displayPriority;
	}

	private long _categoryId;
	private long _parentId;
	private int _typeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _categoryName;
	private String _categoryDesc;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private int _displayPriority;
}