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

import com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DucDVd
 */
public class CO_ThreadClp extends BaseModelImpl<CO_Thread> implements CO_Thread {
	public CO_ThreadClp() {
	}

	public Class<?> getModelClass() {
		return CO_Thread.class;
	}

	public String getModelClassName() {
		return CO_Thread.class.getName();
	}

	public long getPrimaryKey() {
		return _threadId;
	}

	public void setPrimaryKey(long primaryKey) {
		setThreadId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_threadId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("threadId", getThreadId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("parentThreadId", getParentThreadId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("threadName", getThreadName());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("participants", getParticipants());
		attributes.put("threadDesc", getThreadDesc());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("viewCount", getViewCount());
		attributes.put("conversationCount", getConversationCount());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long threadId = (Long)attributes.get("threadId");

		if (threadId != null) {
			setThreadId(threadId);
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

		Long parentThreadId = (Long)attributes.get("parentThreadId");

		if (parentThreadId != null) {
			setParentThreadId(parentThreadId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String threadName = (String)attributes.get("threadName");

		if (threadName != null) {
			setThreadName(threadName);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String participants = (String)attributes.get("participants");

		if (participants != null) {
			setParticipants(participants);
		}

		String threadDesc = (String)attributes.get("threadDesc");

		if (threadDesc != null) {
			setThreadDesc(threadDesc);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer conversationCount = (Integer)attributes.get("conversationCount");

		if (conversationCount != null) {
			setConversationCount(conversationCount);
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

	public long getThreadId() {
		return _threadId;
	}

	public void setThreadId(long threadId) {
		_threadId = threadId;
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

	public long getParentThreadId() {
		return _parentThreadId;
	}

	public void setParentThreadId(long parentThreadId) {
		_parentThreadId = parentThreadId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getThreadName() {
		return _threadName;
	}

	public void setThreadName(String threadName) {
		_threadName = threadName;
	}

	public String getDepartmentName() {
		return _departmentName;
	}

	public void setDepartmentName(String departmentName) {
		_departmentName = departmentName;
	}

	public String getParticipants() {
		return _participants;
	}

	public void setParticipants(String participants) {
		_participants = participants;
	}

	public String getThreadDesc() {
		return _threadDesc;
	}

	public void setThreadDesc(String threadDesc) {
		_threadDesc = threadDesc;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
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

	public int getConversationCount() {
		return _conversationCount;
	}

	public void setConversationCount(int conversationCount) {
		_conversationCount = conversationCount;
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

	public BaseModel<?> getCO_ThreadRemoteModel() {
		return _co_ThreadRemoteModel;
	}

	public void setCO_ThreadRemoteModel(BaseModel<?> co_ThreadRemoteModel) {
		_co_ThreadRemoteModel = co_ThreadRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CO_ThreadLocalServiceUtil.addCO_Thread(this);
		}
		else {
			CO_ThreadLocalServiceUtil.updateCO_Thread(this);
		}
	}

	@Override
	public CO_Thread toEscapedModel() {
		return (CO_Thread)Proxy.newProxyInstance(CO_Thread.class.getClassLoader(),
			new Class[] { CO_Thread.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CO_ThreadClp clone = new CO_ThreadClp();

		clone.setThreadId(getThreadId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setParentThreadId(getParentThreadId());
		clone.setCategoryId(getCategoryId());
		clone.setThreadName(getThreadName());
		clone.setDepartmentName(getDepartmentName());
		clone.setParticipants(getParticipants());
		clone.setThreadDesc(getThreadDesc());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setViewCount(getViewCount());
		clone.setConversationCount(getConversationCount());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusDate(getStatusDate());

		return clone;
	}

	public int compareTo(CO_Thread co_Thread) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(), co_Thread.getStartDate());

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

		CO_ThreadClp co_Thread = null;

		try {
			co_Thread = (CO_ThreadClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = co_Thread.getPrimaryKey();

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

		sb.append("{threadId=");
		sb.append(getThreadId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", parentThreadId=");
		sb.append(getParentThreadId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", threadName=");
		sb.append(getThreadName());
		sb.append(", departmentName=");
		sb.append(getDepartmentName());
		sb.append(", participants=");
		sb.append(getParticipants());
		sb.append(", threadDesc=");
		sb.append(getThreadDesc());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", conversationCount=");
		sb.append(getConversationCount());
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
		sb.append("com.portal_egov.portlet.conversation.model.CO_Thread");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>threadId</column-name><column-value><![CDATA[");
		sb.append(getThreadId());
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
			"<column><column-name>parentThreadId</column-name><column-value><![CDATA[");
		sb.append(getParentThreadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadName</column-name><column-value><![CDATA[");
		sb.append(getThreadName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentName</column-name><column-value><![CDATA[");
		sb.append(getDepartmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participants</column-name><column-value><![CDATA[");
		sb.append(getParticipants());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>threadDesc</column-name><column-value><![CDATA[");
		sb.append(getThreadDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
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
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conversationCount</column-name><column-value><![CDATA[");
		sb.append(getConversationCount());
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

	private long _threadId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _parentThreadId;
	private long _categoryId;
	private String _threadName;
	private String _departmentName;
	private String _participants;
	private String _threadDesc;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _viewCount;
	private int _conversationCount;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private Date _statusDate;
	private BaseModel<?> _co_ThreadRemoteModel;
}