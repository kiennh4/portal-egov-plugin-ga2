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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.vbpq.service.http.VBPQ_DlFileEntriesServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.vbpq.service.http.VBPQ_DlFileEntriesServiceSoap
 * @generated
 */
public class VBPQ_DlFileEntriesSoap implements Serializable {
	public static VBPQ_DlFileEntriesSoap toSoapModel(VBPQ_DlFileEntries model) {
		VBPQ_DlFileEntriesSoap soapModel = new VBPQ_DlFileEntriesSoap();

		soapModel.setId(model.getId());
		soapModel.setVbpqEntryId(model.getVbpqEntryId());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static VBPQ_DlFileEntriesSoap[] toSoapModels(
		VBPQ_DlFileEntries[] models) {
		VBPQ_DlFileEntriesSoap[] soapModels = new VBPQ_DlFileEntriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VBPQ_DlFileEntriesSoap[][] toSoapModels(
		VBPQ_DlFileEntries[][] models) {
		VBPQ_DlFileEntriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VBPQ_DlFileEntriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VBPQ_DlFileEntriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VBPQ_DlFileEntriesSoap[] toSoapModels(
		List<VBPQ_DlFileEntries> models) {
		List<VBPQ_DlFileEntriesSoap> soapModels = new ArrayList<VBPQ_DlFileEntriesSoap>(models.size());

		for (VBPQ_DlFileEntries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VBPQ_DlFileEntriesSoap[soapModels.size()]);
	}

	public VBPQ_DlFileEntriesSoap() {
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

	public long getVbpqEntryId() {
		return _vbpqEntryId;
	}

	public void setVbpqEntryId(long vbpqEntryId) {
		_vbpqEntryId = vbpqEntryId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _id;
	private long _vbpqEntryId;
	private long _fileEntryId;
}