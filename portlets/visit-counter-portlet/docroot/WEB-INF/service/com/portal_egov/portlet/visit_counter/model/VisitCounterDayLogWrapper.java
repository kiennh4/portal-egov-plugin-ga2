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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VisitCounterDayLog}.
 * </p>
 *
 * @author    HungDX
 * @see       VisitCounterDayLog
 * @generated
 */
public class VisitCounterDayLogWrapper implements VisitCounterDayLog,
	ModelWrapper<VisitCounterDayLog> {
	public VisitCounterDayLogWrapper(VisitCounterDayLog visitCounterDayLog) {
		_visitCounterDayLog = visitCounterDayLog;
	}

	public Class<?> getModelClass() {
		return VisitCounterDayLog.class;
	}

	public String getModelClassName() {
		return VisitCounterDayLog.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("daylogId", getDaylogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("hitCounter", getHitCounter());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String daylogId = (String)attributes.get("daylogId");

		if (daylogId != null) {
			setDaylogId(daylogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer hitCounter = (Integer)attributes.get("hitCounter");

		if (hitCounter != null) {
			setHitCounter(hitCounter);
		}
	}

	/**
	* Returns the primary key of this visit counter day log.
	*
	* @return the primary key of this visit counter day log
	*/
	public java.lang.String getPrimaryKey() {
		return _visitCounterDayLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this visit counter day log.
	*
	* @param primaryKey the primary key of this visit counter day log
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_visitCounterDayLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the daylog ID of this visit counter day log.
	*
	* @return the daylog ID of this visit counter day log
	*/
	public java.lang.String getDaylogId() {
		return _visitCounterDayLog.getDaylogId();
	}

	/**
	* Sets the daylog ID of this visit counter day log.
	*
	* @param daylogId the daylog ID of this visit counter day log
	*/
	public void setDaylogId(java.lang.String daylogId) {
		_visitCounterDayLog.setDaylogId(daylogId);
	}

	/**
	* Returns the company ID of this visit counter day log.
	*
	* @return the company ID of this visit counter day log
	*/
	public long getCompanyId() {
		return _visitCounterDayLog.getCompanyId();
	}

	/**
	* Sets the company ID of this visit counter day log.
	*
	* @param companyId the company ID of this visit counter day log
	*/
	public void setCompanyId(long companyId) {
		_visitCounterDayLog.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this visit counter day log.
	*
	* @return the group ID of this visit counter day log
	*/
	public long getGroupId() {
		return _visitCounterDayLog.getGroupId();
	}

	/**
	* Sets the group ID of this visit counter day log.
	*
	* @param groupId the group ID of this visit counter day log
	*/
	public void setGroupId(long groupId) {
		_visitCounterDayLog.setGroupId(groupId);
	}

	/**
	* Returns the hit counter of this visit counter day log.
	*
	* @return the hit counter of this visit counter day log
	*/
	public int getHitCounter() {
		return _visitCounterDayLog.getHitCounter();
	}

	/**
	* Sets the hit counter of this visit counter day log.
	*
	* @param hitCounter the hit counter of this visit counter day log
	*/
	public void setHitCounter(int hitCounter) {
		_visitCounterDayLog.setHitCounter(hitCounter);
	}

	public boolean isNew() {
		return _visitCounterDayLog.isNew();
	}

	public void setNew(boolean n) {
		_visitCounterDayLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _visitCounterDayLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_visitCounterDayLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _visitCounterDayLog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _visitCounterDayLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_visitCounterDayLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _visitCounterDayLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_visitCounterDayLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VisitCounterDayLogWrapper((VisitCounterDayLog)_visitCounterDayLog.clone());
	}

	public int compareTo(VisitCounterDayLog visitCounterDayLog) {
		return _visitCounterDayLog.compareTo(visitCounterDayLog);
	}

	@Override
	public int hashCode() {
		return _visitCounterDayLog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<VisitCounterDayLog> toCacheModel() {
		return _visitCounterDayLog.toCacheModel();
	}

	public VisitCounterDayLog toEscapedModel() {
		return new VisitCounterDayLogWrapper(_visitCounterDayLog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _visitCounterDayLog.toString();
	}

	public java.lang.String toXmlString() {
		return _visitCounterDayLog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_visitCounterDayLog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VisitCounterDayLog getWrappedVisitCounterDayLog() {
		return _visitCounterDayLog;
	}

	public VisitCounterDayLog getWrappedModel() {
		return _visitCounterDayLog;
	}

	public void resetOriginalValues() {
		_visitCounterDayLog.resetOriginalValues();
	}

	private VisitCounterDayLog _visitCounterDayLog;
}