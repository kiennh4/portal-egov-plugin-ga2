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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.vbpq.service.http.VBPQ_EntryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.vbpq.service.http.VBPQ_EntryServiceSoap
 * @generated
 */
public class VBPQ_EntrySoap implements Serializable {
	public static VBPQ_EntrySoap toSoapModel(VBPQ_Entry model) {
		VBPQ_EntrySoap soapModel = new VBPQ_EntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setDocTypeId(model.getDocTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setEntryName(model.getEntryName());
		soapModel.setEntryCode(model.getEntryCode());
		soapModel.setEntryDesc(model.getEntryDesc());
		soapModel.setFileAttachmentURL(model.getFileAttachmentURL());
		soapModel.setPublicatorName(model.getPublicatorName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setExecuteDate(model.getExecuteDate());
		soapModel.setExpirationDate(model.getExpirationDate());
		soapModel.setNeverExpired(model.getNeverExpired());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static VBPQ_EntrySoap[] toSoapModels(VBPQ_Entry[] models) {
		VBPQ_EntrySoap[] soapModels = new VBPQ_EntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VBPQ_EntrySoap[][] toSoapModels(VBPQ_Entry[][] models) {
		VBPQ_EntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VBPQ_EntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VBPQ_EntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VBPQ_EntrySoap[] toSoapModels(List<VBPQ_Entry> models) {
		List<VBPQ_EntrySoap> soapModels = new ArrayList<VBPQ_EntrySoap>(models.size());

		for (VBPQ_Entry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VBPQ_EntrySoap[soapModels.size()]);
	}

	public VBPQ_EntrySoap() {
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

	public long getDocTypeId() {
		return _docTypeId;
	}

	public void setDocTypeId(long docTypeId) {
		_docTypeId = docTypeId;
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

	public String getEntryName() {
		return _entryName;
	}

	public void setEntryName(String entryName) {
		_entryName = entryName;
	}

	public String getEntryCode() {
		return _entryCode;
	}

	public void setEntryCode(String entryCode) {
		_entryCode = entryCode;
	}

	public String getEntryDesc() {
		return _entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		_entryDesc = entryDesc;
	}

	public String getFileAttachmentURL() {
		return _fileAttachmentURL;
	}

	public void setFileAttachmentURL(String fileAttachmentURL) {
		_fileAttachmentURL = fileAttachmentURL;
	}

	public String getPublicatorName() {
		return _publicatorName;
	}

	public void setPublicatorName(String publicatorName) {
		_publicatorName = publicatorName;
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

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public Date getExecuteDate() {
		return _executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		_executeDate = executeDate;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public boolean getNeverExpired() {
		return _neverExpired;
	}

	public boolean isNeverExpired() {
		return _neverExpired;
	}

	public void setNeverExpired(boolean neverExpired) {
		_neverExpired = neverExpired;
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

	private long _entryId;
	private long _departmentId;
	private long _categoryId;
	private long _docTypeId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private String _entryName;
	private String _entryCode;
	private String _entryDesc;
	private String _fileAttachmentURL;
	private String _publicatorName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private Date _executeDate;
	private Date _expirationDate;
	private boolean _neverExpired;
	private boolean _active;
}