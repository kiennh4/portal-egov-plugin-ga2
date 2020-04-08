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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.proposition_feedback.service.http.PropositionServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.proposition_feedback.service.http.PropositionServiceSoap
 * @generated
 */
public class PropositionSoap implements Serializable {
	public static PropositionSoap toSoapModel(Proposition model) {
		PropositionSoap soapModel = new PropositionSoap();

		soapModel.setPropositionId(model.getPropositionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCompilationDepartmentId(model.getCompilationDepartmentId());
		soapModel.setVerificationDepartmentId(model.getVerificationDepartmentId());
		soapModel.setPropositionName(model.getPropositionName());
		soapModel.setPropositionDesc(model.getPropositionDesc());
		soapModel.setPropositionContent(model.getPropositionContent());
		soapModel.setDocumentFileId(model.getDocumentFileId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setFeedbackCount(model.getFeedbackCount());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static PropositionSoap[] toSoapModels(Proposition[] models) {
		PropositionSoap[] soapModels = new PropositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PropositionSoap[][] toSoapModels(Proposition[][] models) {
		PropositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PropositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PropositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PropositionSoap[] toSoapModels(List<Proposition> models) {
		List<PropositionSoap> soapModels = new ArrayList<PropositionSoap>(models.size());

		for (Proposition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PropositionSoap[soapModels.size()]);
	}

	public PropositionSoap() {
	}

	public long getPrimaryKey() {
		return _propositionId;
	}

	public void setPrimaryKey(long pk) {
		setPropositionId(pk);
	}

	public long getPropositionId() {
		return _propositionId;
	}

	public void setPropositionId(long propositionId) {
		_propositionId = propositionId;
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getCompilationDepartmentId() {
		return _compilationDepartmentId;
	}

	public void setCompilationDepartmentId(long compilationDepartmentId) {
		_compilationDepartmentId = compilationDepartmentId;
	}

	public long getVerificationDepartmentId() {
		return _verificationDepartmentId;
	}

	public void setVerificationDepartmentId(long verificationDepartmentId) {
		_verificationDepartmentId = verificationDepartmentId;
	}

	public String getPropositionName() {
		return _propositionName;
	}

	public void setPropositionName(String propositionName) {
		_propositionName = propositionName;
	}

	public String getPropositionDesc() {
		return _propositionDesc;
	}

	public void setPropositionDesc(String propositionDesc) {
		_propositionDesc = propositionDesc;
	}

	public String getPropositionContent() {
		return _propositionContent;
	}

	public void setPropositionContent(String propositionContent) {
		_propositionContent = propositionContent;
	}

	public long getDocumentFileId() {
		return _documentFileId;
	}

	public void setDocumentFileId(long documentFileId) {
		_documentFileId = documentFileId;
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

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	public int getFeedbackCount() {
		return _feedbackCount;
	}

	public void setFeedbackCount(int feedbackCount) {
		_feedbackCount = feedbackCount;
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

	private long _propositionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _categoryId;
	private long _compilationDepartmentId;
	private long _verificationDepartmentId;
	private String _propositionName;
	private String _propositionDesc;
	private String _propositionContent;
	private long _documentFileId;
	private Date _createDate;
	private Date _modifiedDate;
	private int _viewCount;
	private int _feedbackCount;
	private int _status;
	private long _statusByUserId;
	private Date _statusDate;
}