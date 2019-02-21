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

package com.portal_egov.portlet.citymaps.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CityMapType}.
 * </p>
 *
 * @author    HungDX
 * @see       CityMapType
 * @generated
 */
public class CityMapTypeWrapper implements CityMapType,
	ModelWrapper<CityMapType> {
	public CityMapTypeWrapper(CityMapType cityMapType) {
		_cityMapType = cityMapType;
	}

	public Class<?> getModelClass() {
		return CityMapType.class;
	}

	public String getModelClassName() {
		return CityMapType.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeId", getTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typeName", getTypeName());
		attributes.put("typeDesc", getTypeDesc());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
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

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}

		String typeDesc = (String)attributes.get("typeDesc");

		if (typeDesc != null) {
			setTypeDesc(typeDesc);
		}
	}

	/**
	* Returns the primary key of this city map type.
	*
	* @return the primary key of this city map type
	*/
	public long getPrimaryKey() {
		return _cityMapType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this city map type.
	*
	* @param primaryKey the primary key of this city map type
	*/
	public void setPrimaryKey(long primaryKey) {
		_cityMapType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the type ID of this city map type.
	*
	* @return the type ID of this city map type
	*/
	public long getTypeId() {
		return _cityMapType.getTypeId();
	}

	/**
	* Sets the type ID of this city map type.
	*
	* @param typeId the type ID of this city map type
	*/
	public void setTypeId(long typeId) {
		_cityMapType.setTypeId(typeId);
	}

	/**
	* Returns the company ID of this city map type.
	*
	* @return the company ID of this city map type
	*/
	public long getCompanyId() {
		return _cityMapType.getCompanyId();
	}

	/**
	* Sets the company ID of this city map type.
	*
	* @param companyId the company ID of this city map type
	*/
	public void setCompanyId(long companyId) {
		_cityMapType.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this city map type.
	*
	* @return the group ID of this city map type
	*/
	public long getGroupId() {
		return _cityMapType.getGroupId();
	}

	/**
	* Sets the group ID of this city map type.
	*
	* @param groupId the group ID of this city map type
	*/
	public void setGroupId(long groupId) {
		_cityMapType.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this city map type.
	*
	* @return the user ID of this city map type
	*/
	public long getUserId() {
		return _cityMapType.getUserId();
	}

	/**
	* Sets the user ID of this city map type.
	*
	* @param userId the user ID of this city map type
	*/
	public void setUserId(long userId) {
		_cityMapType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this city map type.
	*
	* @return the user uuid of this city map type
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapType.getUserUuid();
	}

	/**
	* Sets the user uuid of this city map type.
	*
	* @param userUuid the user uuid of this city map type
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_cityMapType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this city map type.
	*
	* @return the user name of this city map type
	*/
	public java.lang.String getUserName() {
		return _cityMapType.getUserName();
	}

	/**
	* Sets the user name of this city map type.
	*
	* @param userName the user name of this city map type
	*/
	public void setUserName(java.lang.String userName) {
		_cityMapType.setUserName(userName);
	}

	/**
	* Returns the create date of this city map type.
	*
	* @return the create date of this city map type
	*/
	public java.util.Date getCreateDate() {
		return _cityMapType.getCreateDate();
	}

	/**
	* Sets the create date of this city map type.
	*
	* @param createDate the create date of this city map type
	*/
	public void setCreateDate(java.util.Date createDate) {
		_cityMapType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this city map type.
	*
	* @return the modified date of this city map type
	*/
	public java.util.Date getModifiedDate() {
		return _cityMapType.getModifiedDate();
	}

	/**
	* Sets the modified date of this city map type.
	*
	* @param modifiedDate the modified date of this city map type
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cityMapType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type name of this city map type.
	*
	* @return the type name of this city map type
	*/
	public java.lang.String getTypeName() {
		return _cityMapType.getTypeName();
	}

	/**
	* Sets the type name of this city map type.
	*
	* @param typeName the type name of this city map type
	*/
	public void setTypeName(java.lang.String typeName) {
		_cityMapType.setTypeName(typeName);
	}

	/**
	* Returns the type desc of this city map type.
	*
	* @return the type desc of this city map type
	*/
	public java.lang.String getTypeDesc() {
		return _cityMapType.getTypeDesc();
	}

	/**
	* Sets the type desc of this city map type.
	*
	* @param typeDesc the type desc of this city map type
	*/
	public void setTypeDesc(java.lang.String typeDesc) {
		_cityMapType.setTypeDesc(typeDesc);
	}

	public boolean isNew() {
		return _cityMapType.isNew();
	}

	public void setNew(boolean n) {
		_cityMapType.setNew(n);
	}

	public boolean isCachedModel() {
		return _cityMapType.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cityMapType.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cityMapType.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cityMapType.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cityMapType.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cityMapType.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cityMapType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CityMapTypeWrapper((CityMapType)_cityMapType.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType) {
		return _cityMapType.compareTo(cityMapType);
	}

	@Override
	public int hashCode() {
		return _cityMapType.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.citymaps.model.CityMapType> toCacheModel() {
		return _cityMapType.toCacheModel();
	}

	public com.portal_egov.portlet.citymaps.model.CityMapType toEscapedModel() {
		return new CityMapTypeWrapper(_cityMapType.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cityMapType.toString();
	}

	public java.lang.String toXmlString() {
		return _cityMapType.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cityMapType.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CityMapType getWrappedCityMapType() {
		return _cityMapType;
	}

	public CityMapType getWrappedModel() {
		return _cityMapType;
	}

	public void resetOriginalValues() {
		_cityMapType.resetOriginalValues();
	}

	private CityMapType _cityMapType;
}