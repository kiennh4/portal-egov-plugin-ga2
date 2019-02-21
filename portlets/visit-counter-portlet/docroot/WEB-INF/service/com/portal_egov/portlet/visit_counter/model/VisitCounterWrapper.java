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
 * This class is a wrapper for {@link VisitCounter}.
 * </p>
 *
 * @author    HungDX
 * @see       VisitCounter
 * @generated
 */
public class VisitCounterWrapper implements VisitCounter,
	ModelWrapper<VisitCounter> {
	public VisitCounterWrapper(VisitCounter visitCounter) {
		_visitCounter = visitCounter;
	}

	public Class<?> getModelClass() {
		return VisitCounter.class;
	}

	public String getModelClassName() {
		return VisitCounter.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("counterId", getCounterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("totalHitCounter", getTotalHitCounter());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long counterId = (Long)attributes.get("counterId");

		if (counterId != null) {
			setCounterId(counterId);
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

		Integer totalHitCounter = (Integer)attributes.get("totalHitCounter");

		if (totalHitCounter != null) {
			setTotalHitCounter(totalHitCounter);
		}
	}

	/**
	* Returns the primary key of this visit counter.
	*
	* @return the primary key of this visit counter
	*/
	public long getPrimaryKey() {
		return _visitCounter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this visit counter.
	*
	* @param primaryKey the primary key of this visit counter
	*/
	public void setPrimaryKey(long primaryKey) {
		_visitCounter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the counter ID of this visit counter.
	*
	* @return the counter ID of this visit counter
	*/
	public long getCounterId() {
		return _visitCounter.getCounterId();
	}

	/**
	* Sets the counter ID of this visit counter.
	*
	* @param counterId the counter ID of this visit counter
	*/
	public void setCounterId(long counterId) {
		_visitCounter.setCounterId(counterId);
	}

	/**
	* Returns the company ID of this visit counter.
	*
	* @return the company ID of this visit counter
	*/
	public long getCompanyId() {
		return _visitCounter.getCompanyId();
	}

	/**
	* Sets the company ID of this visit counter.
	*
	* @param companyId the company ID of this visit counter
	*/
	public void setCompanyId(long companyId) {
		_visitCounter.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this visit counter.
	*
	* @return the group ID of this visit counter
	*/
	public long getGroupId() {
		return _visitCounter.getGroupId();
	}

	/**
	* Sets the group ID of this visit counter.
	*
	* @param groupId the group ID of this visit counter
	*/
	public void setGroupId(long groupId) {
		_visitCounter.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this visit counter.
	*
	* @return the user ID of this visit counter
	*/
	public long getUserId() {
		return _visitCounter.getUserId();
	}

	/**
	* Sets the user ID of this visit counter.
	*
	* @param userId the user ID of this visit counter
	*/
	public void setUserId(long userId) {
		_visitCounter.setUserId(userId);
	}

	/**
	* Returns the user uuid of this visit counter.
	*
	* @return the user uuid of this visit counter
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _visitCounter.getUserUuid();
	}

	/**
	* Sets the user uuid of this visit counter.
	*
	* @param userUuid the user uuid of this visit counter
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_visitCounter.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this visit counter.
	*
	* @return the user name of this visit counter
	*/
	public java.lang.String getUserName() {
		return _visitCounter.getUserName();
	}

	/**
	* Sets the user name of this visit counter.
	*
	* @param userName the user name of this visit counter
	*/
	public void setUserName(java.lang.String userName) {
		_visitCounter.setUserName(userName);
	}

	/**
	* Returns the create date of this visit counter.
	*
	* @return the create date of this visit counter
	*/
	public java.util.Date getCreateDate() {
		return _visitCounter.getCreateDate();
	}

	/**
	* Sets the create date of this visit counter.
	*
	* @param createDate the create date of this visit counter
	*/
	public void setCreateDate(java.util.Date createDate) {
		_visitCounter.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this visit counter.
	*
	* @return the modified date of this visit counter
	*/
	public java.util.Date getModifiedDate() {
		return _visitCounter.getModifiedDate();
	}

	/**
	* Sets the modified date of this visit counter.
	*
	* @param modifiedDate the modified date of this visit counter
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_visitCounter.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the total hit counter of this visit counter.
	*
	* @return the total hit counter of this visit counter
	*/
	public int getTotalHitCounter() {
		return _visitCounter.getTotalHitCounter();
	}

	/**
	* Sets the total hit counter of this visit counter.
	*
	* @param totalHitCounter the total hit counter of this visit counter
	*/
	public void setTotalHitCounter(int totalHitCounter) {
		_visitCounter.setTotalHitCounter(totalHitCounter);
	}

	public boolean isNew() {
		return _visitCounter.isNew();
	}

	public void setNew(boolean n) {
		_visitCounter.setNew(n);
	}

	public boolean isCachedModel() {
		return _visitCounter.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_visitCounter.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _visitCounter.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _visitCounter.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_visitCounter.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _visitCounter.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_visitCounter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VisitCounterWrapper((VisitCounter)_visitCounter.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.visit_counter.model.VisitCounter visitCounter) {
		return _visitCounter.compareTo(visitCounter);
	}

	@Override
	public int hashCode() {
		return _visitCounter.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.visit_counter.model.VisitCounter> toCacheModel() {
		return _visitCounter.toCacheModel();
	}

	public com.portal_egov.portlet.visit_counter.model.VisitCounter toEscapedModel() {
		return new VisitCounterWrapper(_visitCounter.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _visitCounter.toString();
	}

	public java.lang.String toXmlString() {
		return _visitCounter.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounter.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VisitCounter getWrappedVisitCounter() {
		return _visitCounter;
	}

	public VisitCounter getWrappedModel() {
		return _visitCounter;
	}

	public void resetOriginalValues() {
		_visitCounter.resetOriginalValues();
	}

	private VisitCounter _visitCounter;
}