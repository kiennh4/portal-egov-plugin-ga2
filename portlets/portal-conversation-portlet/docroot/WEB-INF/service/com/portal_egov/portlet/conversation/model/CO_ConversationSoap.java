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

package com.portal_egov.portlet.conversation.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.conversation.service.http.CO_ConversationServiceSoap}.
 *
 * @author    DucDVd
 * @see       com.portal_egov.portlet.conversation.service.http.CO_ConversationServiceSoap
 * @generated
 */
public class CO_ConversationSoap implements Serializable {
	public static CO_ConversationSoap toSoapModel(CO_Conversation model) {
		CO_ConversationSoap soapModel = new CO_ConversationSoap();

		soapModel.setConversationId(model.getConversationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setThreadId(model.getThreadId());
		soapModel.setTitle(model.getTitle());
		soapModel.setAskUserName(model.getAskUserName());
		soapModel.setAskUserInfo(model.getAskUserInfo());
		soapModel.setAskContent(model.getAskContent());
		soapModel.setAnswerUserName(model.getAnswerUserName());
		soapModel.setAnswerUserInfo(model.getAnswerUserInfo());
		soapModel.setAnswerContent(model.getAnswerContent());
		soapModel.setAskDate(model.getAskDate());
		soapModel.setAnswerDate(model.getAnswerDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static CO_ConversationSoap[] toSoapModels(CO_Conversation[] models) {
		CO_ConversationSoap[] soapModels = new CO_ConversationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CO_ConversationSoap[][] toSoapModels(
		CO_Conversation[][] models) {
		CO_ConversationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CO_ConversationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CO_ConversationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CO_ConversationSoap[] toSoapModels(
		List<CO_Conversation> models) {
		List<CO_ConversationSoap> soapModels = new ArrayList<CO_ConversationSoap>(models.size());

		for (CO_Conversation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CO_ConversationSoap[soapModels.size()]);
	}

	public CO_ConversationSoap() {
	}

	public long getPrimaryKey() {
		return _conversationId;
	}

	public void setPrimaryKey(long pk) {
		setConversationId(pk);
	}

	public long getConversationId() {
		return _conversationId;
	}

	public void setConversationId(long conversationId) {
		_conversationId = conversationId;
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

	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_threadId = threadId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAskUserName() {
		return _askUserName;
	}

	public void setAskUserName(String askUserName) {
		_askUserName = askUserName;
	}

	public String getAskUserInfo() {
		return _askUserInfo;
	}

	public void setAskUserInfo(String askUserInfo) {
		_askUserInfo = askUserInfo;
	}

	public String getAskContent() {
		return _askContent;
	}

	public void setAskContent(String askContent) {
		_askContent = askContent;
	}

	public String getAnswerUserName() {
		return _answerUserName;
	}

	public void setAnswerUserName(String answerUserName) {
		_answerUserName = answerUserName;
	}

	public String getAnswerUserInfo() {
		return _answerUserInfo;
	}

	public void setAnswerUserInfo(String answerUserInfo) {
		_answerUserInfo = answerUserInfo;
	}

	public String getAnswerContent() {
		return _answerContent;
	}

	public void setAnswerContent(String answerContent) {
		_answerContent = answerContent;
	}

	public Date getAskDate() {
		return _askDate;
	}

	public void setAskDate(Date askDate) {
		_askDate = askDate;
	}

	public Date getAnswerDate() {
		return _answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;
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

	private long _conversationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _threadId;
	private String _title;
	private String _askUserName;
	private String _askUserInfo;
	private String _askContent;
	private String _answerUserName;
	private String _answerUserInfo;
	private String _answerContent;
	private Date _askDate;
	private Date _answerDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private Date _statusDate;
}