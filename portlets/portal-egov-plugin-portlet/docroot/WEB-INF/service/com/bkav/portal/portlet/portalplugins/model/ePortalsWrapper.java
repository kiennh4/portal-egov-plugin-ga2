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

package com.bkav.portal.portlet.portalplugins.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ePortals}.
 * </p>
 *
 * @author    AnhBDb
 * @see       ePortals
 * @generated
 */
public class ePortalsWrapper implements ePortals, ModelWrapper<ePortals> {
	public ePortalsWrapper(ePortals ePortals) {
		_ePortals = ePortals;
	}

	public Class<?> getModelClass() {
		return ePortals.class;
	}

	public String getModelClassName() {
		return ePortals.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eportalId", getEportalId());
		attributes.put("eportalName", getEportalName());
		attributes.put("eportalCode", getEportalCode());
		attributes.put("eportalDomain", getEportalDomain());
		attributes.put("eportalVersion", getEportalVersion());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long eportalId = (Long)attributes.get("eportalId");

		if (eportalId != null) {
			setEportalId(eportalId);
		}

		String eportalName = (String)attributes.get("eportalName");

		if (eportalName != null) {
			setEportalName(eportalName);
		}

		String eportalCode = (String)attributes.get("eportalCode");

		if (eportalCode != null) {
			setEportalCode(eportalCode);
		}

		String eportalDomain = (String)attributes.get("eportalDomain");

		if (eportalDomain != null) {
			setEportalDomain(eportalDomain);
		}

		String eportalVersion = (String)attributes.get("eportalVersion");

		if (eportalVersion != null) {
			setEportalVersion(eportalVersion);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	/**
	* Returns the primary key of this e portals.
	*
	* @return the primary key of this e portals
	*/
	public long getPrimaryKey() {
		return _ePortals.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e portals.
	*
	* @param primaryKey the primary key of this e portals
	*/
	public void setPrimaryKey(long primaryKey) {
		_ePortals.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eportal ID of this e portals.
	*
	* @return the eportal ID of this e portals
	*/
	public long getEportalId() {
		return _ePortals.getEportalId();
	}

	/**
	* Sets the eportal ID of this e portals.
	*
	* @param eportalId the eportal ID of this e portals
	*/
	public void setEportalId(long eportalId) {
		_ePortals.setEportalId(eportalId);
	}

	/**
	* Returns the eportal name of this e portals.
	*
	* @return the eportal name of this e portals
	*/
	public java.lang.String getEportalName() {
		return _ePortals.getEportalName();
	}

	/**
	* Sets the eportal name of this e portals.
	*
	* @param eportalName the eportal name of this e portals
	*/
	public void setEportalName(java.lang.String eportalName) {
		_ePortals.setEportalName(eportalName);
	}

	/**
	* Returns the eportal code of this e portals.
	*
	* @return the eportal code of this e portals
	*/
	public java.lang.String getEportalCode() {
		return _ePortals.getEportalCode();
	}

	/**
	* Sets the eportal code of this e portals.
	*
	* @param eportalCode the eportal code of this e portals
	*/
	public void setEportalCode(java.lang.String eportalCode) {
		_ePortals.setEportalCode(eportalCode);
	}

	/**
	* Returns the eportal domain of this e portals.
	*
	* @return the eportal domain of this e portals
	*/
	public java.lang.String getEportalDomain() {
		return _ePortals.getEportalDomain();
	}

	/**
	* Sets the eportal domain of this e portals.
	*
	* @param eportalDomain the eportal domain of this e portals
	*/
	public void setEportalDomain(java.lang.String eportalDomain) {
		_ePortals.setEportalDomain(eportalDomain);
	}

	/**
	* Returns the eportal version of this e portals.
	*
	* @return the eportal version of this e portals
	*/
	public java.lang.String getEportalVersion() {
		return _ePortals.getEportalVersion();
	}

	/**
	* Sets the eportal version of this e portals.
	*
	* @param eportalVersion the eportal version of this e portals
	*/
	public void setEportalVersion(java.lang.String eportalVersion) {
		_ePortals.setEportalVersion(eportalVersion);
	}

	/**
	* Returns the create date of this e portals.
	*
	* @return the create date of this e portals
	*/
	public java.util.Date getCreateDate() {
		return _ePortals.getCreateDate();
	}

	/**
	* Sets the create date of this e portals.
	*
	* @param createDate the create date of this e portals
	*/
	public void setCreateDate(java.util.Date createDate) {
		_ePortals.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this e portals.
	*
	* @return the modify date of this e portals
	*/
	public java.util.Date getModifyDate() {
		return _ePortals.getModifyDate();
	}

	/**
	* Sets the modify date of this e portals.
	*
	* @param modifyDate the modify date of this e portals
	*/
	public void setModifyDate(java.util.Date modifyDate) {
		_ePortals.setModifyDate(modifyDate);
	}

	/**
	* Returns the group ID of this e portals.
	*
	* @return the group ID of this e portals
	*/
	public long getGroupId() {
		return _ePortals.getGroupId();
	}

	/**
	* Sets the group ID of this e portals.
	*
	* @param groupId the group ID of this e portals
	*/
	public void setGroupId(long groupId) {
		_ePortals.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e portals.
	*
	* @return the company ID of this e portals
	*/
	public long getCompanyId() {
		return _ePortals.getCompanyId();
	}

	/**
	* Sets the company ID of this e portals.
	*
	* @param companyId the company ID of this e portals
	*/
	public void setCompanyId(long companyId) {
		_ePortals.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e portals.
	*
	* @return the user ID of this e portals
	*/
	public long getUserId() {
		return _ePortals.getUserId();
	}

	/**
	* Sets the user ID of this e portals.
	*
	* @param userId the user ID of this e portals
	*/
	public void setUserId(long userId) {
		_ePortals.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e portals.
	*
	* @return the user uuid of this e portals
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ePortals.getUserUuid();
	}

	/**
	* Sets the user uuid of this e portals.
	*
	* @param userUuid the user uuid of this e portals
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_ePortals.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e portals.
	*
	* @return the user name of this e portals
	*/
	public java.lang.String getUserName() {
		return _ePortals.getUserName();
	}

	/**
	* Sets the user name of this e portals.
	*
	* @param userName the user name of this e portals
	*/
	public void setUserName(java.lang.String userName) {
		_ePortals.setUserName(userName);
	}

	public boolean isNew() {
		return _ePortals.isNew();
	}

	public void setNew(boolean n) {
		_ePortals.setNew(n);
	}

	public boolean isCachedModel() {
		return _ePortals.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ePortals.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ePortals.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ePortals.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ePortals.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ePortals.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ePortals.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ePortalsWrapper((ePortals)_ePortals.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.portalplugins.model.ePortals ePortals) {
		return _ePortals.compareTo(ePortals);
	}

	@Override
	public int hashCode() {
		return _ePortals.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.portalplugins.model.ePortals> toCacheModel() {
		return _ePortals.toCacheModel();
	}

	public com.bkav.portal.portlet.portalplugins.model.ePortals toEscapedModel() {
		return new ePortalsWrapper(_ePortals.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ePortals.toString();
	}

	public java.lang.String toXmlString() {
		return _ePortals.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ePortals.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ePortals getWrappedePortals() {
		return _ePortals;
	}

	public ePortals getWrappedModel() {
		return _ePortals;
	}

	public void resetOriginalValues() {
		_ePortals.resetOriginalValues();
	}

	private ePortals _ePortals;
}