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

package com.portal_egov.portlet.citymaps.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.citymaps.service.http.CityMapTypeServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.citymaps.service.http.CityMapTypeServiceSoap
 * @generated
 */
public class CityMapTypeSoap implements Serializable {
	public static CityMapTypeSoap toSoapModel(CityMapType model) {
		CityMapTypeSoap soapModel = new CityMapTypeSoap();

		soapModel.setTypeId(model.getTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTypeName(model.getTypeName());
		soapModel.setTypeDesc(model.getTypeDesc());

		return soapModel;
	}

	public static CityMapTypeSoap[] toSoapModels(CityMapType[] models) {
		CityMapTypeSoap[] soapModels = new CityMapTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CityMapTypeSoap[][] toSoapModels(CityMapType[][] models) {
		CityMapTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CityMapTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CityMapTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CityMapTypeSoap[] toSoapModels(List<CityMapType> models) {
		List<CityMapTypeSoap> soapModels = new ArrayList<CityMapTypeSoap>(models.size());

		for (CityMapType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CityMapTypeSoap[soapModels.size()]);
	}

	public CityMapTypeSoap() {
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long pk) {
		setTypeId(pk);
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
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

	public String getTypeName() {
		return _typeName;
	}

	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	public String getTypeDesc() {
		return _typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		_typeDesc = typeDesc;
	}

	private long _typeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _typeName;
	private String _typeDesc;
}