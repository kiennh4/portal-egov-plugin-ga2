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

package com.portal_egov.portlet.ykct.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.ykct.service.http.YKCT_EntryServiceSoap}.
 *
 * @author    DucDVd
 * @see       com.portal_egov.portlet.ykct.service.http.YKCT_EntryServiceSoap
 * @generated
 */
public class YKCT_EntrySoap implements Serializable {
	public static YKCT_EntrySoap toSoapModel(YKCT_Entry model) {
		YKCT_EntrySoap soapModel = new YKCT_EntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEntryName(model.getEntryName());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setFileAttachmentURL(model.getFileAttachmentURL());

		return soapModel;
	}

	public static YKCT_EntrySoap[] toSoapModels(YKCT_Entry[] models) {
		YKCT_EntrySoap[] soapModels = new YKCT_EntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YKCT_EntrySoap[][] toSoapModels(YKCT_Entry[][] models) {
		YKCT_EntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YKCT_EntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new YKCT_EntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YKCT_EntrySoap[] toSoapModels(List<YKCT_Entry> models) {
		List<YKCT_EntrySoap> soapModels = new ArrayList<YKCT_EntrySoap>(models.size());

		for (YKCT_Entry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YKCT_EntrySoap[soapModels.size()]);
	}

	public YKCT_EntrySoap() {
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

	public String getEntryName() {
		return _entryName;
	}

	public void setEntryName(String entryName) {
		_entryName = entryName;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getFileAttachmentURL() {
		return _fileAttachmentURL;
	}

	public void setFileAttachmentURL(String fileAttachmentURL) {
		_fileAttachmentURL = fileAttachmentURL;
	}

	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _entryName;
	private long _categoryId;
	private String _fileAttachmentURL;
}