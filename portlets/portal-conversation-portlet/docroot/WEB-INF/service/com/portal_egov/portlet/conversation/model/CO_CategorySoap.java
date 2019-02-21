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

package com.portal_egov.portlet.conversation.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.conversation.service.http.CO_CategoryServiceSoap}.
 *
 * @author    DucDVd
 * @see       com.portal_egov.portlet.conversation.service.http.CO_CategoryServiceSoap
 * @generated
 */
public class CO_CategorySoap implements Serializable {
	public static CO_CategorySoap toSoapModel(CO_Category model) {
		CO_CategorySoap soapModel = new CO_CategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setParentCategoryId(model.getParentCategoryId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCategoryDesc(model.getCategoryDesc());
		soapModel.setThreadCount(model.getThreadCount());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CO_CategorySoap[] toSoapModels(CO_Category[] models) {
		CO_CategorySoap[] soapModels = new CO_CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CO_CategorySoap[][] toSoapModels(CO_Category[][] models) {
		CO_CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CO_CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CO_CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CO_CategorySoap[] toSoapModels(List<CO_Category> models) {
		List<CO_CategorySoap> soapModels = new ArrayList<CO_CategorySoap>(models.size());

		for (CO_Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CO_CategorySoap[soapModels.size()]);
	}

	public CO_CategorySoap() {
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

	public long getParentCategoryId() {
		return _parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		_parentCategoryId = parentCategoryId;
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

	public int getThreadCount() {
		return _threadCount;
	}

	public void setThreadCount(int threadCount) {
		_threadCount = threadCount;
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

	private long _categoryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _parentCategoryId;
	private String _categoryName;
	private String _categoryDesc;
	private int _threadCount;
	private Date _createDate;
	private Date _modifiedDate;
}