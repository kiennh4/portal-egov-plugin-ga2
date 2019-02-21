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

package com.portal_egov.portlet.visit_counter.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VisitCounterLog}.
 * </p>
 *
 * @author    HungDX
 * @see       VisitCounterLog
 * @generated
 */
public class VisitCounterLogWrapper implements VisitCounterLog,
	ModelWrapper<VisitCounterLog> {
	public VisitCounterLogWrapper(VisitCounterLog visitCounterLog) {
		_visitCounterLog = visitCounterLog;
	}

	public Class<?> getModelClass() {
		return VisitCounterLog.class;
	}

	public String getModelClassName() {
		return VisitCounterLog.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visitorIp", getVisitorIp());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("hitCounter", getHitCounter());
		attributes.put("lastAccessPageId", getLastAccessPageId());
		attributes.put("lastAccessDate", getLastAccessDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String visitorIp = (String)attributes.get("visitorIp");

		if (visitorIp != null) {
			setVisitorIp(visitorIp);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer hitCounter = (Integer)attributes.get("hitCounter");

		if (hitCounter != null) {
			setHitCounter(hitCounter);
		}

		Long lastAccessPageId = (Long)attributes.get("lastAccessPageId");

		if (lastAccessPageId != null) {
			setLastAccessPageId(lastAccessPageId);
		}

		Date lastAccessDate = (Date)attributes.get("lastAccessDate");

		if (lastAccessDate != null) {
			setLastAccessDate(lastAccessDate);
		}
	}

	/**
	* Returns the primary key of this visit counter log.
	*
	* @return the primary key of this visit counter log
	*/
	public java.lang.String getPrimaryKey() {
		return _visitCounterLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this visit counter log.
	*
	* @param primaryKey the primary key of this visit counter log
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_visitCounterLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the visitor ip of this visit counter log.
	*
	* @return the visitor ip of this visit counter log
	*/
	public java.lang.String getVisitorIp() {
		return _visitCounterLog.getVisitorIp();
	}

	/**
	* Sets the visitor ip of this visit counter log.
	*
	* @param visitorIp the visitor ip of this visit counter log
	*/
	public void setVisitorIp(java.lang.String visitorIp) {
		_visitCounterLog.setVisitorIp(visitorIp);
	}

	/**
	* Returns the company ID of this visit counter log.
	*
	* @return the company ID of this visit counter log
	*/
	public long getCompanyId() {
		return _visitCounterLog.getCompanyId();
	}

	/**
	* Sets the company ID of this visit counter log.
	*
	* @param companyId the company ID of this visit counter log
	*/
	public void setCompanyId(long companyId) {
		_visitCounterLog.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this visit counter log.
	*
	* @return the group ID of this visit counter log
	*/
	public long getGroupId() {
		return _visitCounterLog.getGroupId();
	}

	/**
	* Sets the group ID of this visit counter log.
	*
	* @param groupId the group ID of this visit counter log
	*/
	public void setGroupId(long groupId) {
		_visitCounterLog.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this visit counter log.
	*
	* @return the user ID of this visit counter log
	*/
	public long getUserId() {
		return _visitCounterLog.getUserId();
	}

	/**
	* Sets the user ID of this visit counter log.
	*
	* @param userId the user ID of this visit counter log
	*/
	public void setUserId(long userId) {
		_visitCounterLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this visit counter log.
	*
	* @return the user uuid of this visit counter log
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounterLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this visit counter log.
	*
	* @param userUuid the user uuid of this visit counter log
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_visitCounterLog.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this visit counter log.
	*
	* @return the user name of this visit counter log
	*/
	public java.lang.String getUserName() {
		return _visitCounterLog.getUserName();
	}

	/**
	* Sets the user name of this visit counter log.
	*
	* @param userName the user name of this visit counter log
	*/
	public void setUserName(java.lang.String userName) {
		_visitCounterLog.setUserName(userName);
	}

	/**
	* Returns the create date of this visit counter log.
	*
	* @return the create date of this visit counter log
	*/
	public java.util.Date getCreateDate() {
		return _visitCounterLog.getCreateDate();
	}

	/**
	* Sets the create date of this visit counter log.
	*
	* @param createDate the create date of this visit counter log
	*/
	public void setCreateDate(java.util.Date createDate) {
		_visitCounterLog.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this visit counter log.
	*
	* @return the modified date of this visit counter log
	*/
	public java.util.Date getModifiedDate() {
		return _visitCounterLog.getModifiedDate();
	}

	/**
	* Sets the modified date of this visit counter log.
	*
	* @param modifiedDate the modified date of this visit counter log
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_visitCounterLog.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the hit counter of this visit counter log.
	*
	* @return the hit counter of this visit counter log
	*/
	public int getHitCounter() {
		return _visitCounterLog.getHitCounter();
	}

	/**
	* Sets the hit counter of this visit counter log.
	*
	* @param hitCounter the hit counter of this visit counter log
	*/
	public void setHitCounter(int hitCounter) {
		_visitCounterLog.setHitCounter(hitCounter);
	}

	/**
	* Returns the last access page ID of this visit counter log.
	*
	* @return the last access page ID of this visit counter log
	*/
	public long getLastAccessPageId() {
		return _visitCounterLog.getLastAccessPageId();
	}

	/**
	* Sets the last access page ID of this visit counter log.
	*
	* @param lastAccessPageId the last access page ID of this visit counter log
	*/
	public void setLastAccessPageId(long lastAccessPageId) {
		_visitCounterLog.setLastAccessPageId(lastAccessPageId);
	}

	/**
	* Returns the last access date of this visit counter log.
	*
	* @return the last access date of this visit counter log
	*/
	public java.util.Date getLastAccessDate() {
		return _visitCounterLog.getLastAccessDate();
	}

	/**
	* Sets the last access date of this visit counter log.
	*
	* @param lastAccessDate the last access date of this visit counter log
	*/
	public void setLastAccessDate(java.util.Date lastAccessDate) {
		_visitCounterLog.setLastAccessDate(lastAccessDate);
	}

	public boolean isNew() {
		return _visitCounterLog.isNew();
	}

	public void setNew(boolean n) {
		_visitCounterLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _visitCounterLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_visitCounterLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _visitCounterLog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _visitCounterLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_visitCounterLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _visitCounterLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_visitCounterLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VisitCounterLogWrapper((VisitCounterLog)_visitCounterLog.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.visit_counter.model.VisitCounterLog visitCounterLog) {
		return _visitCounterLog.compareTo(visitCounterLog);
	}

	@Override
	public int hashCode() {
		return _visitCounterLog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.visit_counter.model.VisitCounterLog> toCacheModel() {
		return _visitCounterLog.toCacheModel();
	}

	public com.portal_egov.portlet.visit_counter.model.VisitCounterLog toEscapedModel() {
		return new VisitCounterLogWrapper(_visitCounterLog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _visitCounterLog.toString();
	}

	public java.lang.String toXmlString() {
		return _visitCounterLog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterLog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VisitCounterLog getWrappedVisitCounterLog() {
		return _visitCounterLog;
	}

	public VisitCounterLog getWrappedModel() {
		return _visitCounterLog;
	}

	public void resetOriginalValues() {
		_visitCounterLog.resetOriginalValues();
	}

	private VisitCounterLog _visitCounterLog;
}