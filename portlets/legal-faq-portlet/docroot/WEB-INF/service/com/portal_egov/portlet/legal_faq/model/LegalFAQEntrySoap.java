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

package com.portal_egov.portlet.legal_faq.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.legal_faq.service.http.LegalFAQEntryServiceSoap}.
 *
 * @author    HungDX
 * @see       com.portal_egov.portlet.legal_faq.service.http.LegalFAQEntryServiceSoap
 * @generated
 */
public class LegalFAQEntrySoap implements Serializable {
	public static LegalFAQEntrySoap toSoapModel(LegalFAQEntry model) {
		LegalFAQEntrySoap soapModel = new LegalFAQEntrySoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCitizenName(model.getCitizenName());
		soapModel.setCitizenPhone(model.getCitizenPhone());
		soapModel.setCitizenEmail(model.getCitizenEmail());
		soapModel.setCitizenAddress(model.getCitizenAddress());
		soapModel.setAskDate(model.getAskDate());
		soapModel.setAskTitle(model.getAskTitle());
		soapModel.setAskContent(model.getAskContent());
		soapModel.setAnswerDate(model.getAnswerDate());
		soapModel.setAnswerContent(model.getAnswerContent());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setPublishStatus(model.getPublishStatus());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static LegalFAQEntrySoap[] toSoapModels(LegalFAQEntry[] models) {
		LegalFAQEntrySoap[] soapModels = new LegalFAQEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalFAQEntrySoap[][] toSoapModels(LegalFAQEntry[][] models) {
		LegalFAQEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalFAQEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalFAQEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalFAQEntrySoap[] toSoapModels(List<LegalFAQEntry> models) {
		List<LegalFAQEntrySoap> soapModels = new ArrayList<LegalFAQEntrySoap>(models.size());

		for (LegalFAQEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalFAQEntrySoap[soapModels.size()]);
	}

	public LegalFAQEntrySoap() {
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

	public String getCitizenName() {
		return _citizenName;
	}

	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;
	}

	public String getCitizenPhone() {
		return _citizenPhone;
	}

	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;
	}

	public String getCitizenEmail() {
		return _citizenEmail;
	}

	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;
	}

	public String getCitizenAddress() {
		return _citizenAddress;
	}

	public void setCitizenAddress(String citizenAddress) {
		_citizenAddress = citizenAddress;
	}

	public Date getAskDate() {
		return _askDate;
	}

	public void setAskDate(Date askDate) {
		_askDate = askDate;
	}

	public String getAskTitle() {
		return _askTitle;
	}

	public void setAskTitle(String askTitle) {
		_askTitle = askTitle;
	}

	public String getAskContent() {
		return _askContent;
	}

	public void setAskContent(String askContent) {
		_askContent = askContent;
	}

	public Date getAnswerDate() {
		return _answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;
	}

	public String getAnswerContent() {
		return _answerContent;
	}

	public void setAnswerContent(String answerContent) {
		_answerContent = answerContent;
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

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public int getViewCount() {
		return _viewCount;
	}

	public void setViewCount(int viewCount) {
		_viewCount = viewCount;
	}

	public int getPublishStatus() {
		return _publishStatus;
	}

	public void setPublishStatus(int publishStatus) {
		_publishStatus = publishStatus;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _entryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _categoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private String _citizenAddress;
	private Date _askDate;
	private String _askTitle;
	private String _askContent;
	private Date _answerDate;
	private String _answerContent;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private long _attachmentId;
	private int _viewCount;
	private int _publishStatus;
	private int _status;
}