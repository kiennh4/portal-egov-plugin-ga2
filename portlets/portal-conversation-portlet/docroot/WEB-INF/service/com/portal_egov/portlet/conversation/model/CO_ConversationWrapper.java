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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CO_Conversation}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_Conversation
 * @generated
 */
public class CO_ConversationWrapper implements CO_Conversation,
	ModelWrapper<CO_Conversation> {
	public CO_ConversationWrapper(CO_Conversation co_Conversation) {
		_co_Conversation = co_Conversation;
	}

	public Class<?> getModelClass() {
		return CO_Conversation.class;
	}

	public String getModelClassName() {
		return CO_Conversation.class.getName();
	}

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

	/**
	* Returns the primary key of this c o_ conversation.
	*
	* @return the primary key of this c o_ conversation
	*/
	public long getPrimaryKey() {
		return _co_Conversation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c o_ conversation.
	*
	* @param primaryKey the primary key of this c o_ conversation
	*/
	public void setPrimaryKey(long primaryKey) {
		_co_Conversation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the conversation ID of this c o_ conversation.
	*
	* @return the conversation ID of this c o_ conversation
	*/
	public long getConversationId() {
		return _co_Conversation.getConversationId();
	}

	/**
	* Sets the conversation ID of this c o_ conversation.
	*
	* @param conversationId the conversation ID of this c o_ conversation
	*/
	public void setConversationId(long conversationId) {
		_co_Conversation.setConversationId(conversationId);
	}

	/**
	* Returns the company ID of this c o_ conversation.
	*
	* @return the company ID of this c o_ conversation
	*/
	public long getCompanyId() {
		return _co_Conversation.getCompanyId();
	}

	/**
	* Sets the company ID of this c o_ conversation.
	*
	* @param companyId the company ID of this c o_ conversation
	*/
	public void setCompanyId(long companyId) {
		_co_Conversation.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this c o_ conversation.
	*
	* @return the group ID of this c o_ conversation
	*/
	public long getGroupId() {
		return _co_Conversation.getGroupId();
	}

	/**
	* Sets the group ID of this c o_ conversation.
	*
	* @param groupId the group ID of this c o_ conversation
	*/
	public void setGroupId(long groupId) {
		_co_Conversation.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this c o_ conversation.
	*
	* @return the user ID of this c o_ conversation
	*/
	public long getUserId() {
		return _co_Conversation.getUserId();
	}

	/**
	* Sets the user ID of this c o_ conversation.
	*
	* @param userId the user ID of this c o_ conversation
	*/
	public void setUserId(long userId) {
		_co_Conversation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this c o_ conversation.
	*
	* @return the user uuid of this c o_ conversation
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_Conversation.getUserUuid();
	}

	/**
	* Sets the user uuid of this c o_ conversation.
	*
	* @param userUuid the user uuid of this c o_ conversation
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_co_Conversation.setUserUuid(userUuid);
	}

	/**
	* Returns the thread ID of this c o_ conversation.
	*
	* @return the thread ID of this c o_ conversation
	*/
	public long getThreadId() {
		return _co_Conversation.getThreadId();
	}

	/**
	* Sets the thread ID of this c o_ conversation.
	*
	* @param threadId the thread ID of this c o_ conversation
	*/
	public void setThreadId(long threadId) {
		_co_Conversation.setThreadId(threadId);
	}

	/**
	* Returns the title of this c o_ conversation.
	*
	* @return the title of this c o_ conversation
	*/
	public java.lang.String getTitle() {
		return _co_Conversation.getTitle();
	}

	/**
	* Sets the title of this c o_ conversation.
	*
	* @param title the title of this c o_ conversation
	*/
	public void setTitle(java.lang.String title) {
		_co_Conversation.setTitle(title);
	}

	/**
	* Returns the ask user name of this c o_ conversation.
	*
	* @return the ask user name of this c o_ conversation
	*/
	public java.lang.String getAskUserName() {
		return _co_Conversation.getAskUserName();
	}

	/**
	* Sets the ask user name of this c o_ conversation.
	*
	* @param askUserName the ask user name of this c o_ conversation
	*/
	public void setAskUserName(java.lang.String askUserName) {
		_co_Conversation.setAskUserName(askUserName);
	}

	/**
	* Returns the ask user info of this c o_ conversation.
	*
	* @return the ask user info of this c o_ conversation
	*/
	public java.lang.String getAskUserInfo() {
		return _co_Conversation.getAskUserInfo();
	}

	/**
	* Sets the ask user info of this c o_ conversation.
	*
	* @param askUserInfo the ask user info of this c o_ conversation
	*/
	public void setAskUserInfo(java.lang.String askUserInfo) {
		_co_Conversation.setAskUserInfo(askUserInfo);
	}

	/**
	* Returns the ask content of this c o_ conversation.
	*
	* @return the ask content of this c o_ conversation
	*/
	public java.lang.String getAskContent() {
		return _co_Conversation.getAskContent();
	}

	/**
	* Sets the ask content of this c o_ conversation.
	*
	* @param askContent the ask content of this c o_ conversation
	*/
	public void setAskContent(java.lang.String askContent) {
		_co_Conversation.setAskContent(askContent);
	}

	/**
	* Returns the answer user name of this c o_ conversation.
	*
	* @return the answer user name of this c o_ conversation
	*/
	public java.lang.String getAnswerUserName() {
		return _co_Conversation.getAnswerUserName();
	}

	/**
	* Sets the answer user name of this c o_ conversation.
	*
	* @param answerUserName the answer user name of this c o_ conversation
	*/
	public void setAnswerUserName(java.lang.String answerUserName) {
		_co_Conversation.setAnswerUserName(answerUserName);
	}

	/**
	* Returns the answer user info of this c o_ conversation.
	*
	* @return the answer user info of this c o_ conversation
	*/
	public java.lang.String getAnswerUserInfo() {
		return _co_Conversation.getAnswerUserInfo();
	}

	/**
	* Sets the answer user info of this c o_ conversation.
	*
	* @param answerUserInfo the answer user info of this c o_ conversation
	*/
	public void setAnswerUserInfo(java.lang.String answerUserInfo) {
		_co_Conversation.setAnswerUserInfo(answerUserInfo);
	}

	/**
	* Returns the answer content of this c o_ conversation.
	*
	* @return the answer content of this c o_ conversation
	*/
	public java.lang.String getAnswerContent() {
		return _co_Conversation.getAnswerContent();
	}

	/**
	* Sets the answer content of this c o_ conversation.
	*
	* @param answerContent the answer content of this c o_ conversation
	*/
	public void setAnswerContent(java.lang.String answerContent) {
		_co_Conversation.setAnswerContent(answerContent);
	}

	/**
	* Returns the ask date of this c o_ conversation.
	*
	* @return the ask date of this c o_ conversation
	*/
	public java.util.Date getAskDate() {
		return _co_Conversation.getAskDate();
	}

	/**
	* Sets the ask date of this c o_ conversation.
	*
	* @param askDate the ask date of this c o_ conversation
	*/
	public void setAskDate(java.util.Date askDate) {
		_co_Conversation.setAskDate(askDate);
	}

	/**
	* Returns the answer date of this c o_ conversation.
	*
	* @return the answer date of this c o_ conversation
	*/
	public java.util.Date getAnswerDate() {
		return _co_Conversation.getAnswerDate();
	}

	/**
	* Sets the answer date of this c o_ conversation.
	*
	* @param answerDate the answer date of this c o_ conversation
	*/
	public void setAnswerDate(java.util.Date answerDate) {
		_co_Conversation.setAnswerDate(answerDate);
	}

	/**
	* Returns the create date of this c o_ conversation.
	*
	* @return the create date of this c o_ conversation
	*/
	public java.util.Date getCreateDate() {
		return _co_Conversation.getCreateDate();
	}

	/**
	* Sets the create date of this c o_ conversation.
	*
	* @param createDate the create date of this c o_ conversation
	*/
	public void setCreateDate(java.util.Date createDate) {
		_co_Conversation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this c o_ conversation.
	*
	* @return the modified date of this c o_ conversation
	*/
	public java.util.Date getModifiedDate() {
		return _co_Conversation.getModifiedDate();
	}

	/**
	* Sets the modified date of this c o_ conversation.
	*
	* @param modifiedDate the modified date of this c o_ conversation
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_co_Conversation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this c o_ conversation.
	*
	* @return the status of this c o_ conversation
	*/
	public int getStatus() {
		return _co_Conversation.getStatus();
	}

	/**
	* Sets the status of this c o_ conversation.
	*
	* @param status the status of this c o_ conversation
	*/
	public void setStatus(int status) {
		_co_Conversation.setStatus(status);
	}

	/**
	* Returns the status by user ID of this c o_ conversation.
	*
	* @return the status by user ID of this c o_ conversation
	*/
	public long getStatusByUserId() {
		return _co_Conversation.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this c o_ conversation.
	*
	* @param statusByUserId the status by user ID of this c o_ conversation
	*/
	public void setStatusByUserId(long statusByUserId) {
		_co_Conversation.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this c o_ conversation.
	*
	* @return the status by user uuid of this c o_ conversation
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_Conversation.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this c o_ conversation.
	*
	* @param statusByUserUuid the status by user uuid of this c o_ conversation
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_co_Conversation.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status date of this c o_ conversation.
	*
	* @return the status date of this c o_ conversation
	*/
	public java.util.Date getStatusDate() {
		return _co_Conversation.getStatusDate();
	}

	/**
	* Sets the status date of this c o_ conversation.
	*
	* @param statusDate the status date of this c o_ conversation
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_co_Conversation.setStatusDate(statusDate);
	}

	public boolean isNew() {
		return _co_Conversation.isNew();
	}

	public void setNew(boolean n) {
		_co_Conversation.setNew(n);
	}

	public boolean isCachedModel() {
		return _co_Conversation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_co_Conversation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _co_Conversation.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _co_Conversation.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_co_Conversation.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _co_Conversation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_co_Conversation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CO_ConversationWrapper((CO_Conversation)_co_Conversation.clone());
	}

	public int compareTo(CO_Conversation co_Conversation) {
		return _co_Conversation.compareTo(co_Conversation);
	}

	@Override
	public int hashCode() {
		return _co_Conversation.hashCode();
	}

	public com.liferay.portal.model.CacheModel<CO_Conversation> toCacheModel() {
		return _co_Conversation.toCacheModel();
	}

	public CO_Conversation toEscapedModel() {
		return new CO_ConversationWrapper(_co_Conversation.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _co_Conversation.toString();
	}

	public java.lang.String toXmlString() {
		return _co_Conversation.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_co_Conversation.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CO_Conversation getWrappedCO_Conversation() {
		return _co_Conversation;
	}

	public CO_Conversation getWrappedModel() {
		return _co_Conversation;
	}

	public void resetOriginalValues() {
		_co_Conversation.resetOriginalValues();
	}

	private CO_Conversation _co_Conversation;
}