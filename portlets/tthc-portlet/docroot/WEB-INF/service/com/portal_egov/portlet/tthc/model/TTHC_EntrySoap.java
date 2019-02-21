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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.tthc.service.http.TTHC_EntryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.tthc.service.http.TTHC_EntryServiceSoap
 * @generated
 */
public class TTHC_EntrySoap implements Serializable {
	public static TTHC_EntrySoap toSoapModel(TTHC_Entry model) {
		TTHC_EntrySoap soapModel = new TTHC_EntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setAudienceId(model.getAudienceId());
		soapModel.setResultTypeId(model.getResultTypeId());
		soapModel.setEntryCode(model.getEntryCode());
		soapModel.setEntryName(model.getEntryName());
		soapModel.setEntryDesc(model.getEntryDesc());
		soapModel.setProcessGuide(model.getProcessGuide());
		soapModel.setProcessType(model.getProcessType());
		soapModel.setProcessTime(model.getProcessTime());
		soapModel.setProcessFee(model.getProcessFee());
		soapModel.setProcessRequirement(model.getProcessRequirement());
		soapModel.setProcessFoundationDocument(model.getProcessFoundationDocument());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TTHC_EntrySoap[] toSoapModels(TTHC_Entry[] models) {
		TTHC_EntrySoap[] soapModels = new TTHC_EntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTHC_EntrySoap[][] toSoapModels(TTHC_Entry[][] models) {
		TTHC_EntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTHC_EntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTHC_EntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTHC_EntrySoap[] toSoapModels(List<TTHC_Entry> models) {
		List<TTHC_EntrySoap> soapModels = new ArrayList<TTHC_EntrySoap>(models.size());

		for (TTHC_Entry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTHC_EntrySoap[soapModels.size()]);
	}

	public TTHC_EntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
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

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getAudienceId() {
		return _audienceId;
	}

	public void setAudienceId(long audienceId) {
		_audienceId = audienceId;
	}

	public long getResultTypeId() {
		return _resultTypeId;
	}

	public void setResultTypeId(long resultTypeId) {
		_resultTypeId = resultTypeId;
	}

	public String getEntryCode() {
		return _entryCode;
	}

	public void setEntryCode(String entryCode) {
		_entryCode = entryCode;
	}

	public String getEntryName() {
		return _entryName;
	}

	public void setEntryName(String entryName) {
		_entryName = entryName;
	}

	public String getEntryDesc() {
		return _entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		_entryDesc = entryDesc;
	}

	public String getProcessGuide() {
		return _processGuide;
	}

	public void setProcessGuide(String processGuide) {
		_processGuide = processGuide;
	}

	public String getProcessType() {
		return _processType;
	}

	public void setProcessType(String processType) {
		_processType = processType;
	}

	public String getProcessTime() {
		return _processTime;
	}

	public void setProcessTime(String processTime) {
		_processTime = processTime;
	}

	public String getProcessFee() {
		return _processFee;
	}

	public void setProcessFee(String processFee) {
		_processFee = processFee;
	}

	public String getProcessRequirement() {
		return _processRequirement;
	}

	public void setProcessRequirement(String processRequirement) {
		_processRequirement = processRequirement;
	}

	public String getProcessFoundationDocument() {
		return _processFoundationDocument;
	}

	public void setProcessFoundationDocument(String processFoundationDocument) {
		_processFoundationDocument = processFoundationDocument;
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

	private long _entryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _levelId;
	private long _departmentId;
	private long _categoryId;
	private long _audienceId;
	private long _resultTypeId;
	private String _entryCode;
	private String _entryName;
	private String _entryDesc;
	private String _processGuide;
	private String _processType;
	private String _processTime;
	private String _processFee;
	private String _processRequirement;
	private String _processFoundationDocument;
	private Date _createDate;
	private Date _modifiedDate;
}