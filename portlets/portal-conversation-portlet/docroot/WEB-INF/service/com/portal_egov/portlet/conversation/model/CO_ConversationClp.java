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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DucDVd
 */
public class CO_ConversationClp extends BaseModelImpl<CO_Conversation>
	implements CO_Conversation {
	public CO_ConversationClp() {
	}

	public Class<?> getModelClass() {
		return CO_Conversation.class;
	}

	public String getModelClassName() {
		return CO_Conversation.class.getName();
	}

	public long getPrimaryKey() {
		return _conversationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setConversationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_conversationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("conversationId", getConversationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("threadId", getThreadId());
		attributes.put("title", getTitle());
		attributes.put("askUserName", getAskUserName());
		attributes.put("askUserInfo", getAskUserInfo());
		attributes.put("askContent", getAskContent());
		attributes.put("answerUserName", getAnswerUserName());
		attributes.put("answerUserInfo", getAnswerUserInfo());
		attributes.put("answerContent", getAnswerContent());
		attributes.put("askDate", getAskDate());
		attributes.put("answerDate", getAnswerDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long conversationId = (Long)attributes.get("conversationId");

		if (conversationId != null) {
			setConversationId(conversationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long threadId = (Long)attributes.get("threadId");

		if (threadId != null) {
			setThreadId(threadId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String askUserName = (String)attributes.get("askUserName");

		if (askUserName != null) {
			setAskUserName(askUserName);
		}

		String askUserInfo = (String)attributes.get("askUserInfo");

		if (askUserInfo != null) {
			setAskUserInfo(askUserInfo);
		}

		String askContent = (String)attributes.get("askContent");

		if (askContent != null) {
			setAskContent(askContent);
		}

		String answerUserName = (String)attributes.get("answerUserName");

		if (answerUserName != null) {
			setAnswerUserName(answerUserName);
		}

		String answerUserInfo = (String)attributes.get("answerUserInfo");

		if (answerUserInfo != null) {
			setAnswerUserInfo(answerUserInfo);
		}

		String answerContent = (String)attributes.get("answerContent");

		if (answerContent != null) {
			setAnswerContent(answerContent);
		}

		Date askDate = (Date)attributes.get("askDate");

		if (askDate != null) {
			setAskDate(askDate);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public BaseModel<?> getCO_ConversationRemoteModel() {
		return _co_ConversationRemoteModel;
	}

	public void setCO_ConversationRemoteModel(
		BaseModel<?> co_ConversationRemoteModel) {
		_co_ConversationRemoteModel = co_ConversationRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CO_ConversationLocalServiceUtil.addCO_Conversation(this);
		}
		else {
			CO_ConversationLocalServiceUtil.updateCO_Conversation(this);
		}
	}

	@Override
	public CO_Conversation toEscapedModel() {
		return (CO_Conversation)Proxy.newProxyInstance(CO_Conversation.class.getClassLoader(),
			new Class[] { CO_Conversation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CO_ConversationClp clone = new CO_ConversationClp();

		clone.setConversationId(getConversationId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setThreadId(getThreadId());
		clone.setTitle(getTitle());
		clone.setAskUserName(getAskUserName());
		clone.setAskUserInfo(getAskUserInfo());
		clone.setAskContent(getAskContent());
		clone.setAnswerUserName(getAnswerUserName());
		clone.setAnswerUserInfo(getAnswerUserInfo());
		clone.setAnswerContent(getAnswerContent());
		clone.setAskDate(getAskDate());
		clone.setAnswerDate(getAnswerDate());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	public int compareTo(CO_Conversation co_Conversation) {
		int value = 0;

		value = DateUtil.compareTo(getAnswerDate(),
				co_Conversation.getAnswerDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CO_ConversationClp co_Conversation = null;

		try {
			co_Conversation = (CO_ConversationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = co_Conversation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{conversationId=");
		sb.append(getConversationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", threadId=");
		sb.append(getThreadId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", askUserName=");
		sb.append(getAskUserName());
		sb.append(", askUserInfo=");
		sb.append(getAskUserInfo());
		sb.append(", askContent=");
		sb.append(getAskContent());
		sb.append(", answerUserName=");
		sb.append(getAnswerUserName());
		sb.append(", answerUserInfo=");
		sb.append(getAnswerUserInfo());
		sb.append(", answerContent=");
		sb.append(getAnswerContent());
		sb.append(", askDate=");
		sb.append(getAskDate());
		sb.append(", answerDate=");
		sb.append(getAnswerDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.conversation.model.CO_Conversation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>conversationId</column-name><column-value><![CDATA[");
		sb.append(getConversationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askUserName</column-name><column-value><![CDATA[");
		sb.append(getAskUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askUserInfo</column-name><column-value><![CDATA[");
		sb.append(getAskUserInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askContent</column-name><column-value><![CDATA[");
		sb.append(getAskContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerUserName</column-name><column-value><![CDATA[");
		sb.append(getAnswerUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerUserInfo</column-name><column-value><![CDATA[");
		sb.append(getAnswerUserInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerContent</column-name><column-value><![CDATA[");
		sb.append(getAnswerContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askDate</column-name><column-value><![CDATA[");
		sb.append(getAskDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerDate</column-name><column-value><![CDATA[");
		sb.append(getAnswerDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _conversationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
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
	private String _statusByUserUuid;
	private Date _statusDate;
	private BaseModel<?> _co_ConversationRemoteModel;
}