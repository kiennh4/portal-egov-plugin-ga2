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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.ykct.service.http.YKCT_DlFileEntriesServiceSoap}.
 *
 * @author    DucDVd
 * @see       com.portal_egov.portlet.ykct.service.http.YKCT_DlFileEntriesServiceSoap
 * @generated
 */
public class YKCT_DlFileEntriesSoap implements Serializable {
	public static YKCT_DlFileEntriesSoap toSoapModel(YKCT_DlFileEntries model) {
		YKCT_DlFileEntriesSoap soapModel = new YKCT_DlFileEntriesSoap();

		soapModel.setId(model.getId());
		soapModel.setYkctEntryId(model.getYkctEntryId());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static YKCT_DlFileEntriesSoap[] toSoapModels(
		YKCT_DlFileEntries[] models) {
		YKCT_DlFileEntriesSoap[] soapModels = new YKCT_DlFileEntriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YKCT_DlFileEntriesSoap[][] toSoapModels(
		YKCT_DlFileEntries[][] models) {
		YKCT_DlFileEntriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YKCT_DlFileEntriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YKCT_DlFileEntriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YKCT_DlFileEntriesSoap[] toSoapModels(
		List<YKCT_DlFileEntries> models) {
		List<YKCT_DlFileEntriesSoap> soapModels = new ArrayList<YKCT_DlFileEntriesSoap>(models.size());

		for (YKCT_DlFileEntries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YKCT_DlFileEntriesSoap[soapModels.size()]);
	}

	public YKCT_DlFileEntriesSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getYkctEntryId() {
		return _ykctEntryId;
	}

	public void setYkctEntryId(long ykctEntryId) {
		_ykctEntryId = ykctEntryId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _id;
	private long _ykctEntryId;
	private long _fileEntryId;
}