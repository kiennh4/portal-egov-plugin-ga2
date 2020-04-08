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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.complaints.service.http.ComplaintsServiceSoap}.
 *
 * @author    AnhBDb
 * @see       com.bkav.portal.portlet.complaints.service.http.ComplaintsServiceSoap
 * @generated
 */
public class ComplaintsSoap implements Serializable {
	public static ComplaintsSoap toSoapModel(Complaints model) {
		ComplaintsSoap soapModel = new ComplaintsSoap();

		soapModel.setComplaintId(model.getComplaintId());
		soapModel.setComplaintNumber(model.getComplaintNumber());
		soapModel.setSigningDate(model.getSigningDate());
		soapModel.setComplaintName(model.getComplaintName());
		soapModel.setComplaintDesc(model.getComplaintDesc());
		soapModel.setComplaintContent(model.getComplaintContent());
		soapModel.setReplyDocument(model.getReplyDocument());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ComplaintsSoap[] toSoapModels(Complaints[] models) {
		ComplaintsSoap[] soapModels = new ComplaintsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ComplaintsSoap[][] toSoapModels(Complaints[][] models) {
		ComplaintsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ComplaintsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ComplaintsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ComplaintsSoap[] toSoapModels(List<Complaints> models) {
		List<ComplaintsSoap> soapModels = new ArrayList<ComplaintsSoap>(models.size());

		for (Complaints model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ComplaintsSoap[soapModels.size()]);
	}

	public ComplaintsSoap() {
	}

	public long getPrimaryKey() {
		return _complaintId;
	}

	public void setPrimaryKey(long pk) {
		setComplaintId(pk);
	}

	public long getComplaintId() {
		return _complaintId;
	}

	public void setComplaintId(long complaintId) {
		_complaintId = complaintId;
	}

	public String getComplaintNumber() {
		return _complaintNumber;
	}

	public void setComplaintNumber(String complaintNumber) {
		_complaintNumber = complaintNumber;
	}

	public Date getSigningDate() {
		return _signingDate;
	}

	public void setSigningDate(Date signingDate) {
		_signingDate = signingDate;
	}

	public String getComplaintName() {
		return _complaintName;
	}

	public void setComplaintName(String complaintName) {
		_complaintName = complaintName;
	}

	public String getComplaintDesc() {
		return _complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		_complaintDesc = complaintDesc;
	}

	public String getComplaintContent() {
		return _complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		_complaintContent = complaintContent;
	}

	public String getReplyDocument() {
		return _replyDocument;
	}

	public void setReplyDocument(String replyDocument) {
		_replyDocument = replyDocument;
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

	private long _complaintId;
	private String _complaintNumber;
	private Date _signingDate;
	private String _complaintName;
	private String _complaintDesc;
	private String _complaintContent;
	private String _replyDocument;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}