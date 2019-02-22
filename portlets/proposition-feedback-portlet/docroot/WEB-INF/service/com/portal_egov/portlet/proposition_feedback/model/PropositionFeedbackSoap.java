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

package com.portal_egov.portlet.proposition_feedback.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.proposition_feedback.service.http.PropositionFeedbackServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.proposition_feedback.service.http.PropositionFeedbackServiceSoap
 * @generated
 */
public class PropositionFeedbackSoap implements Serializable {
	public static PropositionFeedbackSoap toSoapModel(PropositionFeedback model) {
		PropositionFeedbackSoap soapModel = new PropositionFeedbackSoap();

		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPropositionId(model.getPropositionId());
		soapModel.setFeedbackFileAttId(model.getFeedbackFileAttId());
		soapModel.setFeedbackTitle(model.getFeedbackTitle());
		soapModel.setFeedbackContent(model.getFeedbackContent());
		soapModel.setCitizenName(model.getCitizenName());
		soapModel.setCitizenEmail(model.getCitizenEmail());
		soapModel.setCitizenPhone(model.getCitizenPhone());
		soapModel.setCitizenAddress(model.getCitizenAddress());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static PropositionFeedbackSoap[] toSoapModels(
		PropositionFeedback[] models) {
		PropositionFeedbackSoap[] soapModels = new PropositionFeedbackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PropositionFeedbackSoap[][] toSoapModels(
		PropositionFeedback[][] models) {
		PropositionFeedbackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PropositionFeedbackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PropositionFeedbackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PropositionFeedbackSoap[] toSoapModels(
		List<PropositionFeedback> models) {
		List<PropositionFeedbackSoap> soapModels = new ArrayList<PropositionFeedbackSoap>(models.size());

		for (PropositionFeedback model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PropositionFeedbackSoap[soapModels.size()]);
	}

	public PropositionFeedbackSoap() {
	}

	public long getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(long pk) {
		setFeedbackId(pk);
	}

	public long getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
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

	public long getPropositionId() {
		return _propositionId;
	}

	public void setPropositionId(long propositionId) {
		_propositionId = propositionId;
	}

	public long getFeedbackFileAttId() {
		return _feedbackFileAttId;
	}

	public void setFeedbackFileAttId(long feedbackFileAttId) {
		_feedbackFileAttId = feedbackFileAttId;
	}

	public String getFeedbackTitle() {
		return _feedbackTitle;
	}

	public void setFeedbackTitle(String feedbackTitle) {
		_feedbackTitle = feedbackTitle;
	}

	public String getFeedbackContent() {
		return _feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		_feedbackContent = feedbackContent;
	}

	public String getCitizenName() {
		return _citizenName;
	}

	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	public String getCitizenEmail() {
		return _citizenEmail;
	}

	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	public String getCitizenPhone() {
		return _citizenPhone;
	}

	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	public String getCitizenAddress() {
		return _citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		_citizenAddress = citizenAddress;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _feedbackId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _propositionId;
	private long _feedbackFileAttId;
	private String _feedbackTitle;
	private String _feedbackContent;
	private String _citizenName;
	private String _citizenEmail;
	private String _citizenPhone;
	private String _citizenAddress;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private Date _statusDate;
}