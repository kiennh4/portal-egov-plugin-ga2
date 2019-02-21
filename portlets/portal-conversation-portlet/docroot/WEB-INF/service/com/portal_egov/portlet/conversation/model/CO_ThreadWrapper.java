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
 * This class is a wrapper for {@link CO_Thread}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_Thread
 * @generated
 */
public class CO_ThreadWrapper implements CO_Thread, ModelWrapper<CO_Thread> {
	public CO_ThreadWrapper(CO_Thread co_Thread) {
		_co_Thread = co_Thread;
	}

	public Class<?> getModelClass() {
		return CO_Thread.class;
	}

	public String getModelClassName() {
		return CO_Thread.class.getName();
	}

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

	/**
	* Returns the primary key of this c o_ thread.
	*
	* @return the primary key of this c o_ thread
	*/
	public long getPrimaryKey() {
		return _co_Thread.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c o_ thread.
	*
	* @param primaryKey the primary key of this c o_ thread
	*/
	public void setPrimaryKey(long primaryKey) {
		_co_Thread.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the thread ID of this c o_ thread.
	*
	* @return the thread ID of this c o_ thread
	*/
	public long getThreadId() {
		return _co_Thread.getThreadId();
	}

	/**
	* Sets the thread ID of this c o_ thread.
	*
	* @param threadId the thread ID of this c o_ thread
	*/
	public void setThreadId(long threadId) {
		_co_Thread.setThreadId(threadId);
	}

	/**
	* Returns the company ID of this c o_ thread.
	*
	* @return the company ID of this c o_ thread
	*/
	public long getCompanyId() {
		return _co_Thread.getCompanyId();
	}

	/**
	* Sets the company ID of this c o_ thread.
	*
	* @param companyId the company ID of this c o_ thread
	*/
	public void setCompanyId(long companyId) {
		_co_Thread.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this c o_ thread.
	*
	* @return the group ID of this c o_ thread
	*/
	public long getGroupId() {
		return _co_Thread.getGroupId();
	}

	/**
	* Sets the group ID of this c o_ thread.
	*
	* @param groupId the group ID of this c o_ thread
	*/
	public void setGroupId(long groupId) {
		_co_Thread.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this c o_ thread.
	*
	* @return the user ID of this c o_ thread
	*/
	public long getUserId() {
		return _co_Thread.getUserId();
	}

	/**
	* Sets the user ID of this c o_ thread.
	*
	* @param userId the user ID of this c o_ thread
	*/
	public void setUserId(long userId) {
		_co_Thread.setUserId(userId);
	}

	/**
	* Returns the user uuid of this c o_ thread.
	*
	* @return the user uuid of this c o_ thread
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_Thread.getUserUuid();
	}

	/**
	* Sets the user uuid of this c o_ thread.
	*
	* @param userUuid the user uuid of this c o_ thread
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_co_Thread.setUserUuid(userUuid);
	}

	/**
	* Returns the parent thread ID of this c o_ thread.
	*
	* @return the parent thread ID of this c o_ thread
	*/
	public long getParentThreadId() {
		return _co_Thread.getParentThreadId();
	}

	/**
	* Sets the parent thread ID of this c o_ thread.
	*
	* @param parentThreadId the parent thread ID of this c o_ thread
	*/
	public void setParentThreadId(long parentThreadId) {
		_co_Thread.setParentThreadId(parentThreadId);
	}

	/**
	* Returns the category ID of this c o_ thread.
	*
	* @return the category ID of this c o_ thread
	*/
	public long getCategoryId() {
		return _co_Thread.getCategoryId();
	}

	/**
	* Sets the category ID of this c o_ thread.
	*
	* @param categoryId the category ID of this c o_ thread
	*/
	public void setCategoryId(long categoryId) {
		_co_Thread.setCategoryId(categoryId);
	}

	/**
	* Returns the thread name of this c o_ thread.
	*
	* @return the thread name of this c o_ thread
	*/
	public java.lang.String getThreadName() {
		return _co_Thread.getThreadName();
	}

	/**
	* Sets the thread name of this c o_ thread.
	*
	* @param threadName the thread name of this c o_ thread
	*/
	public void setThreadName(java.lang.String threadName) {
		_co_Thread.setThreadName(threadName);
	}

	/**
	* Returns the department name of this c o_ thread.
	*
	* @return the department name of this c o_ thread
	*/
	public java.lang.String getDepartmentName() {
		return _co_Thread.getDepartmentName();
	}

	/**
	* Sets the department name of this c o_ thread.
	*
	* @param departmentName the department name of this c o_ thread
	*/
	public void setDepartmentName(java.lang.String departmentName) {
		_co_Thread.setDepartmentName(departmentName);
	}

	/**
	* Returns the participants of this c o_ thread.
	*
	* @return the participants of this c o_ thread
	*/
	public java.lang.String getParticipants() {
		return _co_Thread.getParticipants();
	}

	/**
	* Sets the participants of this c o_ thread.
	*
	* @param participants the participants of this c o_ thread
	*/
	public void setParticipants(java.lang.String participants) {
		_co_Thread.setParticipants(participants);
	}

	/**
	* Returns the thread desc of this c o_ thread.
	*
	* @return the thread desc of this c o_ thread
	*/
	public java.lang.String getThreadDesc() {
		return _co_Thread.getThreadDesc();
	}

	/**
	* Sets the thread desc of this c o_ thread.
	*
	* @param threadDesc the thread desc of this c o_ thread
	*/
	public void setThreadDesc(java.lang.String threadDesc) {
		_co_Thread.setThreadDesc(threadDesc);
	}

	/**
	* Returns the start date of this c o_ thread.
	*
	* @return the start date of this c o_ thread
	*/
	public java.util.Date getStartDate() {
		return _co_Thread.getStartDate();
	}

	/**
	* Sets the start date of this c o_ thread.
	*
	* @param startDate the start date of this c o_ thread
	*/
	public void setStartDate(java.util.Date startDate) {
		_co_Thread.setStartDate(startDate);
	}

	/**
	* Returns the end date of this c o_ thread.
	*
	* @return the end date of this c o_ thread
	*/
	public java.util.Date getEndDate() {
		return _co_Thread.getEndDate();
	}

	/**
	* Sets the end date of this c o_ thread.
	*
	* @param endDate the end date of this c o_ thread
	*/
	public void setEndDate(java.util.Date endDate) {
		_co_Thread.setEndDate(endDate);
	}

	/**
	* Returns the create date of this c o_ thread.
	*
	* @return the create date of this c o_ thread
	*/
	public java.util.Date getCreateDate() {
		return _co_Thread.getCreateDate();
	}

	/**
	* Sets the create date of this c o_ thread.
	*
	* @param createDate the create date of this c o_ thread
	*/
	public void setCreateDate(java.util.Date createDate) {
		_co_Thread.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this c o_ thread.
	*
	* @return the modified date of this c o_ thread
	*/
	public java.util.Date getModifiedDate() {
		return _co_Thread.getModifiedDate();
	}

	/**
	* Sets the modified date of this c o_ thread.
	*
	* @param modifiedDate the modified date of this c o_ thread
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_co_Thread.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the view count of this c o_ thread.
	*
	* @return the view count of this c o_ thread
	*/
	public int getViewCount() {
		return _co_Thread.getViewCount();
	}

	/**
	* Sets the view count of this c o_ thread.
	*
	* @param viewCount the view count of this c o_ thread
	*/
	public void setViewCount(int viewCount) {
		_co_Thread.setViewCount(viewCount);
	}

	/**
	* Returns the conversation count of this c o_ thread.
	*
	* @return the conversation count of this c o_ thread
	*/
	public int getConversationCount() {
		return _co_Thread.getConversationCount();
	}

	/**
	* Sets the conversation count of this c o_ thread.
	*
	* @param conversationCount the conversation count of this c o_ thread
	*/
	public void setConversationCount(int conversationCount) {
		_co_Thread.setConversationCount(conversationCount);
	}

	/**
	* Returns the status of this c o_ thread.
	*
	* @return the status of this c o_ thread
	*/
	public int getStatus() {
		return _co_Thread.getStatus();
	}

	/**
	* Sets the status of this c o_ thread.
	*
	* @param status the status of this c o_ thread
	*/
	public void setStatus(int status) {
		_co_Thread.setStatus(status);
	}

	/**
	* Returns the status by user ID of this c o_ thread.
	*
	* @return the status by user ID of this c o_ thread
	*/
	public long getStatusByUserId() {
		return _co_Thread.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this c o_ thread.
	*
	* @param statusByUserId the status by user ID of this c o_ thread
	*/
	public void setStatusByUserId(long statusByUserId) {
		_co_Thread.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this c o_ thread.
	*
	* @return the status by user uuid of this c o_ thread
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_Thread.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this c o_ thread.
	*
	* @param statusByUserUuid the status by user uuid of this c o_ thread
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_co_Thread.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status date of this c o_ thread.
	*
	* @return the status date of this c o_ thread
	*/
	public java.util.Date getStatusDate() {
		return _co_Thread.getStatusDate();
	}

	/**
	* Sets the status date of this c o_ thread.
	*
	* @param statusDate the status date of this c o_ thread
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_co_Thread.setStatusDate(statusDate);
	}

	public boolean isNew() {
		return _co_Thread.isNew();
	}

	public void setNew(boolean n) {
		_co_Thread.setNew(n);
	}

	public boolean isCachedModel() {
		return _co_Thread.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_co_Thread.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _co_Thread.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _co_Thread.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_co_Thread.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _co_Thread.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_co_Thread.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CO_ThreadWrapper((CO_Thread)_co_Thread.clone());
	}

	public int compareTo(CO_Thread co_Thread) {
		return _co_Thread.compareTo(co_Thread);
	}

	@Override
	public int hashCode() {
		return _co_Thread.hashCode();
	}

	public com.liferay.portal.model.CacheModel<CO_Thread> toCacheModel() {
		return _co_Thread.toCacheModel();
	}

	public CO_Thread toEscapedModel() {
		return new CO_ThreadWrapper(_co_Thread.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _co_Thread.toString();
	}

	public java.lang.String toXmlString() {
		return _co_Thread.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_co_Thread.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CO_Thread getWrappedCO_Thread() {
		return _co_Thread;
	}

	public CO_Thread getWrappedModel() {
		return _co_Thread;
	}

	public void resetOriginalValues() {
		_co_Thread.resetOriginalValues();
	}

	private CO_Thread _co_Thread;
}