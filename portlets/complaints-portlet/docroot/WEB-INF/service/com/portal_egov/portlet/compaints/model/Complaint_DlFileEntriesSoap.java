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

package com.portal_egov.portlet.compaints.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.compaints.service.http.Complaint_DlFileEntriesServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.compaints.service.http.Complaint_DlFileEntriesServiceSoap
 * @generated
 */
public class Complaint_DlFileEntriesSoap implements Serializable {
	public static Complaint_DlFileEntriesSoap toSoapModel(
		Complaint_DlFileEntries model) {
		Complaint_DlFileEntriesSoap soapModel = new Complaint_DlFileEntriesSoap();

		soapModel.setId(model.getId());
		soapModel.setComplaintId(model.getComplaintId());
		soapModel.setFileEntryId(model.getFileEntryId());

		return soapModel;
	}

	public static Complaint_DlFileEntriesSoap[] toSoapModels(
		Complaint_DlFileEntries[] models) {
		Complaint_DlFileEntriesSoap[] soapModels = new Complaint_DlFileEntriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Complaint_DlFileEntriesSoap[][] toSoapModels(
		Complaint_DlFileEntries[][] models) {
		Complaint_DlFileEntriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Complaint_DlFileEntriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Complaint_DlFileEntriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Complaint_DlFileEntriesSoap[] toSoapModels(
		List<Complaint_DlFileEntries> models) {
		List<Complaint_DlFileEntriesSoap> soapModels = new ArrayList<Complaint_DlFileEntriesSoap>(models.size());

		for (Complaint_DlFileEntries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Complaint_DlFileEntriesSoap[soapModels.size()]);
	}

	public Complaint_DlFileEntriesSoap() {
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