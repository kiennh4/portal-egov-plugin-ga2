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

import com.portal_egov.portlet.conversation.model.CO_Thread;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CO_Thread in entity cache.
 *
 * @author DucDVd
 * @see CO_Thread
 * @generated
 */
public class CO_ThreadCacheModel implements CacheModel<CO_Thread>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{threadId=");
		sb.append(threadId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", parentThreadId=");
		sb.append(parentThreadId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", threadName=");
		sb.append(threadName);
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append(", participants=");
		sb.append(participants);
		sb.append(", threadDesc=");
		sb.append(threadDesc);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", conversationCount=");
		sb.append(conversationCount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	public CO_Thread toEntityModel() {
		CO_ThreadImpl co_ThreadImpl = new CO_ThreadImpl();

		co_ThreadImpl.setThreadId(threadId);
		co_ThreadImpl.setCompanyId(companyId);
		co_ThreadImpl.setGroupId(groupId);
		co_ThreadImpl.setUserId(userId);
		co_ThreadImpl.setParentThreadId(parentThreadId);
		co_ThreadImpl.setCategoryId(categoryId);

		if (threadName == null) {
			co_ThreadImpl.setThreadName(StringPool.BLANK);
		}
		else {
			co_ThreadImpl.setThreadName(threadName);
		}

		if (departmentName == null) {
			co_ThreadImpl.setDepartmentName(StringPool.BLANK);
		}
		else {
			co_ThreadImpl.setDepartmentName(departmentName);
		}

		if (participants == null) {
			co_ThreadImpl.setParticipants(StringPool.BLANK);
		}
		else {
			co_ThreadImpl.setParticipants(participants);
		}

		if (threadDesc == null) {
			co_ThreadImpl.setThreadDesc(StringPool.BLANK);
		}
		else {
			co_ThreadImpl.setThreadDesc(threadDesc);
		}

		if (startDate == Long.MIN_VALUE) {
			co_ThreadImpl.setStartDate(null);
		}
		else {
			co_ThreadImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			co_ThreadImpl.setEndDate(null);
		}
		else {
			co_ThreadImpl.setEndDate(new Date(endDate));
		}

		if (createDate == Long.MIN_VALUE) {
			co_ThreadImpl.setCreateDate(null);
		}
		else {
			co_ThreadImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			co_ThreadImpl.setModifiedDate(null);
		}
		else {
			co_ThreadImpl.setModifiedDate(new Date(modifiedDate));
		}

		co_ThreadImpl.setViewCount(viewCount);
		co_ThreadImpl.setConversationCount(conversationCount);
		co_ThreadImpl.setStatus(status);
		co_ThreadImpl.setStatusByUserId(statusByUserId);

		if (statusDate == Long.MIN_VALUE) {
			co_ThreadImpl.setStatusDate(null);
		}
		else {
			co_ThreadImpl.setStatusDate(new Date(statusDate));
		}

		co_ThreadImpl.resetOriginalValues();

		return co_ThreadImpl;
	}

	public long threadId;
	public long companyId;
	public long groupId;
	public long userId;
	public long parentThreadId;
	public long categoryId;
	public String threadName;
	public String departmentName;
	public String participants;
	public String threadDesc;
	public long startDate;
	public long endDate;
	public long createDate;
	public long modifiedDate;
	public int viewCount;
	public int conversationCount;
	public int status;
	public long statusByUserId;
	public long statusDate;
}