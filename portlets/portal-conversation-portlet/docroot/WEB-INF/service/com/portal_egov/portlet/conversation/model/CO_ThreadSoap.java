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
 * This class is used by SOAP remote services, specifically {@link com.portal_egov.portlet.conversation.service.http.CO_ThreadServiceSoap}.
 *
 * @author    DucDVd
 * @see       com.portal_egov.portlet.conversation.service.http.CO_ThreadServiceSoap
 * @generated
 */
public class CO_ThreadSoap implements Serializable {
	public static CO_ThreadSoap toSoapModel(CO_Thread model) {
		CO_ThreadSoap soapModel = new CO_ThreadSoap();

		soapModel.setThreadId(model.getThreadId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setParentThreadId(model.getParentThreadId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setThreadName(model.getThreadName());
		soapModel.setDepartmentName(model.getDepartmentName());
		soapModel.setParticipants(model.getParticipants());
		soapModel.setThreadDesc(model.getThreadDesc());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setConversationCount(model.getConversationCount());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static CO_ThreadSoap[] toSoapModels(CO_Thread[] models) {
		CO_ThreadSoap[] soapModels = new CO_ThreadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CO_ThreadSoap[][] toSoapModels(CO_Thread[][] models) {
		CO_ThreadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CO_ThreadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CO_ThreadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CO_ThreadSoap[] toSoapModels(List<CO_Thread> models) {
		List<CO_ThreadSoap> soapModels = new ArrayList<CO_ThreadSoap>(models.size());

		for (CO_Thread model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CO_ThreadSoap[soapModels.size()]);
	}

	public CO_ThreadSoap() {
	}

	public long getPrimaryKey() {
		return _threadId;
	}

	public void setPrimaryKey(long pk) {
		setThreadId(pk);
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

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _threadId;
	private long _companyId;
	private long _groupId;
	private long _userId;
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
	private Date _statusDate;
}