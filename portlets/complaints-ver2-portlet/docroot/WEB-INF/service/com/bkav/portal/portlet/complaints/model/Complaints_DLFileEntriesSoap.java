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

package com.bkav.portal.portlet.complaints.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.complaints.service.http.Complaints_DLFileEntriesServiceSoap}.
 *
 * @author    AnhBDb
 * @see       com.bkav.portal.portlet.complaints.service.http.Complaints_DLFileEntriesServiceSoap
 * @generated
 */
public class Complaints_DLFileEntriesSoap implements Serializable {
	public static Complaints_DLFileEntriesSoap toSoapModel(
		Complaints_DLFileEntries model) {
		Complaints_DLFileEntriesSoap soapModel = new Complaints_DLFileEntriesSoap();

		soapModel.setId(model.getId());
		soapModel.setComplaintId(model.getComplaintId());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static Complaints_DLFileEntriesSoap[] toSoapModels(
		Complaints_DLFileEntries[] models) {
		Complaints_DLFileEntriesSoap[] soapModels = new Complaints_DLFileEntriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Complaints_DLFileEntriesSoap[][] toSoapModels(
		Complaints_DLFileEntries[][] models) {
		Complaints_DLFileEntriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Complaints_DLFileEntriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Complaints_DLFileEntriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Complaints_DLFileEntriesSoap[] toSoapModels(
		List<Complaints_DLFileEntries> models) {
		List<Complaints_DLFileEntriesSoap> soapModels = new ArrayList<Complaints_DLFileEntriesSoap>(models.size());

		for (Complaints_DLFileEntries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Complaints_DLFileEntriesSoap[soapModels.size()]);
	}

	public Complaints_DLFileEntriesSoap() {
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

	public long getComplaintId() {
		return _complaintId;
	}

	public void setComplaintId(long complaintId) {
		_complaintId = complaintId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	private long _id;
	private long _complaintId;
	private long _fileEntryId;
}