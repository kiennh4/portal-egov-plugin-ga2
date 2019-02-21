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

package com.bkav.portal_egov.portlet.asset_statistics.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StatisticEntity}.
 * </p>
 *
 * @author    HungDX
 * @see       StatisticEntity
 * @generated
 */
public class StatisticEntityWrapper implements StatisticEntity,
	ModelWrapper<StatisticEntity> {
	public StatisticEntityWrapper(StatisticEntity statisticEntity) {
		_statisticEntity = statisticEntity;
	}

	public Class<?> getModelClass() {
		return StatisticEntity.class;
	}

	public String getModelClassName() {
		return StatisticEntity.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entityId", getEntityId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityName", getEntityName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
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

		String entityName = (String)attributes.get("entityName");

		if (entityName != null) {
			setEntityName(entityName);
		}
	}

	/**
	* Returns the primary key of this statistic entity.
	*
	* @return the primary key of this statistic entity
	*/
	public long getPrimaryKey() {
		return _statisticEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this statistic entity.
	*
	* @param primaryKey the primary key of this statistic entity
	*/
	public void setPrimaryKey(long primaryKey) {
		_statisticEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entity ID of this statistic entity.
	*
	* @return the entity ID of this statistic entity
	*/
	public long getEntityId() {
		return _statisticEntity.getEntityId();
	}

	/**
	* Sets the entity ID of this statistic entity.
	*
	* @param entityId the entity ID of this statistic entity
	*/
	public void setEntityId(long entityId) {
		_statisticEntity.setEntityId(entityId);
	}

	/**
	* Returns the company ID of this statistic entity.
	*
	* @return the company ID of this statistic entity
	*/
	public long getCompanyId() {
		return _statisticEntity.getCompanyId();
	}

	/**
	* Sets the company ID of this statistic entity.
	*
	* @param companyId the company ID of this statistic entity
	*/
	public void setCompanyId(long companyId) {
		_statisticEntity.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this statistic entity.
	*
	* @return the group ID of this statistic entity
	*/
	public long getGroupId() {
		return _statisticEntity.getGroupId();
	}

	/**
	* Sets the group ID of this statistic entity.
	*
	* @param groupId the group ID of this statistic entity
	*/
	public void setGroupId(long groupId) {
		_statisticEntity.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this statistic entity.
	*
	* @return the user ID of this statistic entity
	*/
	public long getUserId() {
		return _statisticEntity.getUserId();
	}

	/**
	* Sets the user ID of this statistic entity.
	*
	* @param userId the user ID of this statistic entity
	*/
	public void setUserId(long userId) {
		_statisticEntity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this statistic entity.
	*
	* @return the user uuid of this statistic entity
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticEntity.getUserUuid();
	}

	/**
	* Sets the user uuid of this statistic entity.
	*
	* @param userUuid the user uuid of this statistic entity
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_statisticEntity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this statistic entity.
	*
	* @return the user name of this statistic entity
	*/
	public java.lang.String getUserName() {
		return _statisticEntity.getUserName();
	}

	/**
	* Sets the user name of this statistic entity.
	*
	* @param userName the user name of this statistic entity
	*/
	public void setUserName(java.lang.String userName) {
		_statisticEntity.setUserName(userName);
	}

	/**
	* Returns the create date of this statistic entity.
	*
	* @return the create date of this statistic entity
	*/
	public java.util.Date getCreateDate() {
		return _statisticEntity.getCreateDate();
	}

	/**
	* Sets the create date of this statistic entity.
	*
	* @param createDate the create date of this statistic entity
	*/
	public void setCreateDate(java.util.Date createDate) {
		_statisticEntity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this statistic entity.
	*
	* @return the modified date of this statistic entity
	*/
	public java.util.Date getModifiedDate() {
		return _statisticEntity.getModifiedDate();
	}

	/**
	* Sets the modified date of this statistic entity.
	*
	* @param modifiedDate the modified date of this statistic entity
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_statisticEntity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the entity name of this statistic entity.
	*
	* @return the entity name of this statistic entity
	*/
	public java.lang.String getEntityName() {
		return _statisticEntity.getEntityName();
	}

	/**
	* Sets the entity name of this statistic entity.
	*
	* @param entityName the entity name of this statistic entity
	*/
	public void setEntityName(java.lang.String entityName) {
		_statisticEntity.setEntityName(entityName);
	}

	public boolean isNew() {
		return _statisticEntity.isNew();
	}

	public void setNew(boolean n) {
		_statisticEntity.setNew(n);
	}

	public boolean isCachedModel() {
		return _statisticEntity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_statisticEntity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _statisticEntity.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _statisticEntity.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statisticEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statisticEntity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statisticEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatisticEntityWrapper((StatisticEntity)_statisticEntity.clone());
	}

	public int compareTo(
		com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity statisticEntity) {
		return _statisticEntity.compareTo(statisticEntity);
	}

	@Override
	public int hashCode() {
		return _statisticEntity.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity> toCacheModel() {
		return _statisticEntity.toCacheModel();
	}

	public com.bkav.portal_egov.portlet.asset_statistics.model.StatisticEntity toEscapedModel() {
		return new StatisticEntityWrapper(_statisticEntity.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statisticEntity.toString();
	}

	public java.lang.String toXmlString() {
		return _statisticEntity.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statisticEntity.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public StatisticEntity getWrappedStatisticEntity() {
		return _statisticEntity;
	}

	public StatisticEntity getWrappedModel() {
		return _statisticEntity;
	}

	public void resetOriginalValues() {
		_statisticEntity.resetOriginalValues();
	}

	private StatisticEntity _statisticEntity;
}