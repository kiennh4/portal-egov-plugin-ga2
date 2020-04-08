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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.compaints.service.http.ComplaintServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.compaints.service.http.ComplaintServiceSoap
 * @generated
 */
public class ComplaintSoap implements Serializable {
	public static ComplaintSoap toSoapModel(Complaint model) {
		ComplaintSoap soapModel = new ComplaintSoap();

		soapModel.setComplaintId(model.getComplaintId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setComplaintTitle(model.getComplaintTitle());
		soapModel.setComplaintDescription(model.getComplaintDescription());
		soapModel.setComplaintContent(model.getComplaintContent());
		soapModel.setFileAttachmentURL(model.getFileAttachmentURL());
		soapModel.setComplaintStatus(model.getComplaintStatus());

		return soapModel;
	}

	public static ComplaintSoap[] toSoapModels(Complaint[] models) {
		ComplaintSoap[] soapModels = new ComplaintSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ComplaintSoap[][] toSoapModels(Complaint[][] models) {
		ComplaintSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ComplaintSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ComplaintSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ComplaintSoap[] toSoapModels(List<Complaint> models) {
		List<ComplaintSoap> soapModels = new ArrayList<ComplaintSoap>(models.size());

		for (Complaint model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ComplaintSoap[soapModels.size()]);
	}

	public ComplaintSoap() {
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

	public String getComplaintTitle() {
		return _complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		_complaintTitle = complaintTitle;
	}

	public String getComplaintDescription() {
		return _complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		_complaintDescription = complaintDescription;
	}

	public String getComplaintContent() {
		return _complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		_complaintContent = complaintContent;
	}

	public String getFileAttachmentURL() {
		return _fileAttachmentURL;
	}

	public void setFileAttachmentURL(String fileAttachmentURL) {
		_fileAttachmentURL = fileAttachmentURL;
	}

	public int getComplaintStatus() {
		return _complaintStatus;
	}

	public void setComplaintStatus(int complaintStatus) {
		_complaintStatus = complaintStatus;
	}

	private long _complaintId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _complaintTitle;
	private String _complaintDescription;
	private String _complaintContent;
	private String _fileAttachmentURL;
	private int _complaintStatus;
}