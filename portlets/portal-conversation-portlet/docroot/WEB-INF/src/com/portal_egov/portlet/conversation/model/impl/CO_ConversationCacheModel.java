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

package com.portal_egov.portlet.conversation.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.portal_egov.portlet.conversation.model.CO_Conversation;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CO_Conversation in entity cache.
 *
 * @author DucDVd
 * @see CO_Conversation
 * @generated
 */
public class CO_ConversationCacheModel implements CacheModel<CO_Conversation>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{conversationId=");
		sb.append(conversationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", threadId=");
		sb.append(threadId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", askUserName=");
		sb.append(askUserName);
		sb.append(", askUserInfo=");
		sb.append(askUserInfo);
		sb.append(", askContent=");
		sb.append(askContent);
		sb.append(", answerUserName=");
		sb.append(answerUserName);
		sb.append(", answerUserInfo=");
		sb.append(answerUserInfo);
		sb.append(", answerContent=");
		sb.append(answerContent);
		sb.append(", askDate=");
		sb.append(askDate);
		sb.append(", answerDate=");
		sb.append(answerDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public CO_Conversation toEntityModel() {
		CO_ConversationImpl co_ConversationImpl = new CO_ConversationImpl();

		co_ConversationImpl.setConversationId(conversationId);
		co_ConversationImpl.setCompanyId(companyId);
		co_ConversationImpl.setGroupId(groupId);
		co_ConversationImpl.setUserId(userId);
		co_ConversationImpl.setThreadId(threadId);

		if (title == null) {
			co_ConversationImpl.setTitle(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setTitle(title);
		}

		if (askUserName == null) {
			co_ConversationImpl.setAskUserName(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setAskUserName(askUserName);
		}

		if (askUserInfo == null) {
			co_ConversationImpl.setAskUserInfo(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setAskUserInfo(askUserInfo);
		}

		if (askContent == null) {
			co_ConversationImpl.setAskContent(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setAskContent(askContent);
		}

		if (answerUserName == null) {
			co_ConversationImpl.setAnswerUserName(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setAnswerUserName(answerUserName);
		}

		if (answerUserInfo == null) {
			co_ConversationImpl.setAnswerUserInfo(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setAnswerUserInfo(answerUserInfo);
		}

		if (answerContent == null) {
			co_ConversationImpl.setAnswerContent(StringPool.BLANK);
		}
		else {
			co_ConversationImpl.setAnswerContent(answerContent);
		}

		if (askDate == Long.MIN_VALUE) {
			co_ConversationImpl.setAskDate(null);
		}
		else {
			co_ConversationImpl.setAskDate(new Date(askDate));
		}

		if (answerDate == Long.MIN_VALUE) {
			co_ConversationImpl.setAnswerDate(null);
		}
		else {
			co_ConversationImpl.setAnswerDate(new Date(answerDate));
		}

		if (createDate == Long.MIN_VALUE) {
			co_ConversationImpl.setCreateDate(null);
		}
		else {
			co_ConversationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			co_ConversationImpl.setModifiedDate(null);
		}
		else {
			co_ConversationImpl.setModifiedDate(new Date(modifiedDate));
		}

		co_ConversationImpl.setStatus(status);
		co_ConversationImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			co_ConversationImpl.setStatusDate(null);
		}
		else {
			co_ConversationImpl.setStatusDate(new Date(statusDate));
		}

		co_ConversationImpl.resetOriginalValues();

		return co_ConversationImpl;
	}

	public long conversationId;
	public long companyId;
	public long groupId;
	public long userId;
	public long threadId;
	public String title;
	public String askUserName;
	public String askUserInfo;
	public String askContent;
	public String answerUserName;
	public String answerUserInfo;
	public String answerContent;
	public long askDate;
	public long answerDate;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public long statusDate;
}