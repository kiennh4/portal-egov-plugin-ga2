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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.tthc.service.http.TTHC_AttributeServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.tthc.service.http.TTHC_AttributeServiceSoap
 * @generated
 */
public class TTHC_AttributeSoap implements Serializable {
	public static TTHC_AttributeSoap toSoapModel(TTHC_Attribute model) {
		TTHC_AttributeSoap soapModel = new TTHC_AttributeSoap();

		soapModel.setAttributeId(model.getAttributeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTthcEntryId(model.getTthcEntryId());
		soapModel.setAttributeTypeId(model.getAttributeTypeId());
		soapModel.setAttributeIndex(model.getAttributeIndex());
		soapModel.setAttributeName(model.getAttributeName());
		soapModel.setAttributeValue(model.getAttributeValue());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TTHC_AttributeSoap[] toSoapModels(TTHC_Attribute[] models) {
		TTHC_AttributeSoap[] soapModels = new TTHC_AttributeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTHC_AttributeSoap[][] toSoapModels(TTHC_Attribute[][] models) {
		TTHC_AttributeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTHC_AttributeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTHC_AttributeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTHC_AttributeSoap[] toSoapModels(List<TTHC_Attribute> models) {
		List<TTHC_AttributeSoap> soapModels = new ArrayList<TTHC_AttributeSoap>(models.size());

		for (TTHC_Attribute model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTHC_AttributeSoap[soapModels.size()]);
	}

	public TTHC_AttributeSoap() {
	}

	public long getPrimaryKey() {
		return _attributeId;
	}

	public void setPrimaryKey(long pk) {
		setAttributeId(pk);
	}

	public long getAttributeId() {
		return _attributeId;
	}

	public void setAttributeId(long attributeId) {
		_attributeId = attributeId;
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

	public long getTthcEntryId() {
		return _tthcEntryId;
	}

	public void setTthcEntryId(long tthcEntryId) {
		_tthcEntryId = tthcEntryId;
	}

	public int getAttributeTypeId() {
		return _attributeTypeId;
	}

	public void setAttributeTypeId(int attributeTypeId) {
		_attributeTypeId = attributeTypeId;
	}

	public int getAttributeIndex() {
		return _attributeIndex;
	}

	public void setAttributeIndex(int attributeIndex) {
		_attributeIndex = attributeIndex;
	}

	public String getAttributeName() {
		return _attributeName;
	}

	public void setAttributeName(String attributeName) {
		_attributeName = attributeName;
	}

	public String getAttributeValue() {
		return _attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		_attributeValue = attributeValue;
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

	private long _attributeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _tthcEntryId;
	private int _attributeTypeId;
	private int _attributeIndex;
	private String _attributeName;
	private String _attributeValue;
	private Date _createDate;
	private Date _modifiedDate;
}