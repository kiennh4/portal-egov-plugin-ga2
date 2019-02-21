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

package com.portal_egov.portlet.landprice.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LandLocation}.
 * </p>
 *
 * @author    HungDX
 * @see       LandLocation
 * @generated
 */
public class LandLocationWrapper implements LandLocation,
	ModelWrapper<LandLocation> {
	public LandLocationWrapper(LandLocation landLocation) {
		_landLocation = landLocation;
	}

	public Class<?> getModelClass() {
		return LandLocation.class;
	}

	public String getModelClassName() {
		return LandLocation.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentLocationId", getParentLocationId());
		attributes.put("locationName", getLocationName());
		attributes.put("locationInfo", getLocationInfo());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
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

		Long parentLocationId = (Long)attributes.get("parentLocationId");

		if (parentLocationId != null) {
			setParentLocationId(parentLocationId);
		}

		String locationName = (String)attributes.get("locationName");

		if (locationName != null) {
			setLocationName(locationName);
		}

		String locationInfo = (String)attributes.get("locationInfo");

		if (locationInfo != null) {
			setLocationInfo(locationInfo);
		}
	}

	/**
	* Returns the primary key of this land location.
	*
	* @return the primary key of this land location
	*/
	public long getPrimaryKey() {
		return _landLocation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this land location.
	*
	* @param primaryKey the primary key of this land location
	*/
	public void setPrimaryKey(long primaryKey) {
		_landLocation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this land location.
	*
	* @return the location ID of this land location
	*/
	public long getLocationId() {
		return _landLocation.getLocationId();
	}

	/**
	* Sets the location ID of this land location.
	*
	* @param locationId the location ID of this land location
	*/
	public void setLocationId(long locationId) {
		_landLocation.setLocationId(locationId);
	}

	/**
	* Returns the company ID of this land location.
	*
	* @return the company ID of this land location
	*/
	public long getCompanyId() {
		return _landLocation.getCompanyId();
	}

	/**
	* Sets the company ID of this land location.
	*
	* @param companyId the company ID of this land location
	*/
	public void setCompanyId(long companyId) {
		_landLocation.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this land location.
	*
	* @return the group ID of this land location
	*/
	public long getGroupId() {
		return _landLocation.getGroupId();
	}

	/**
	* Sets the group ID of this land location.
	*
	* @param groupId the group ID of this land location
	*/
	public void setGroupId(long groupId) {
		_landLocation.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this land location.
	*
	* @return the user ID of this land location
	*/
	public long getUserId() {
		return _landLocation.getUserId();
	}

	/**
	* Sets the user ID of this land location.
	*
	* @param userId the user ID of this land location
	*/
	public void setUserId(long userId) {
		_landLocation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this land location.
	*
	* @return the user uuid of this land location
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _landLocation.getUserUuid();
	}

	/**
	* Sets the user uuid of this land location.
	*
	* @param userUuid the user uuid of this land location
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_landLocation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this land location.
	*
	* @return the user name of this land location
	*/
	public java.lang.String getUserName() {
		return _landLocation.getUserName();
	}

	/**
	* Sets the user name of this land location.
	*
	* @param userName the user name of this land location
	*/
	public void setUserName(java.lang.String userName) {
		_landLocation.setUserName(userName);
	}

	/**
	* Returns the create date of this land location.
	*
	* @return the create date of this land location
	*/
	public java.util.Date getCreateDate() {
		return _landLocation.getCreateDate();
	}

	/**
	* Sets the create date of this land location.
	*
	* @param createDate the create date of this land location
	*/
	public void setCreateDate(java.util.Date createDate) {
		_landLocation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this land location.
	*
	* @return the modified date of this land location
	*/
	public java.util.Date getModifiedDate() {
		return _landLocation.getModifiedDate();
	}

	/**
	* Sets the modified date of this land location.
	*
	* @param modifiedDate the modified date of this land location
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_landLocation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the parent location ID of this land location.
	*
	* @return the parent location ID of this land location
	*/
	public long getParentLocationId() {
		return _landLocation.getParentLocationId();
	}

	/**
	* Sets the parent location ID of this land location.
	*
	* @param parentLocationId the parent location ID of this land location
	*/
	public void setParentLocationId(long parentLocationId) {
		_landLocation.setParentLocationId(parentLocationId);
	}

	/**
	* Returns the location name of this land location.
	*
	* @return the location name of this land location
	*/
	public java.lang.String getLocationName() {
		return _landLocation.getLocationName();
	}

	/**
	* Sets the location name of this land location.
	*
	* @param locationName the location name of this land location
	*/
	public void setLocationName(java.lang.String locationName) {
		_landLocation.setLocationName(locationName);
	}

	/**
	* Returns the location info of this land location.
	*
	* @return the location info of this land location
	*/
	public java.lang.String getLocationInfo() {
		return _landLocation.getLocationInfo();
	}

	/**
	* Sets the location info of this land location.
	*
	* @param locationInfo the location info of this land location
	*/
	public void setLocationInfo(java.lang.String locationInfo) {
		_landLocation.setLocationInfo(locationInfo);
	}

	public boolean isNew() {
		return _landLocation.isNew();
	}

	public void setNew(boolean n) {
		_landLocation.setNew(n);
	}

	public boolean isCachedModel() {
		return _landLocation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_landLocation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _landLocation.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _landLocation.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_landLocation.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _landLocation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_landLocation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LandLocationWrapper((LandLocation)_landLocation.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation) {
		return _landLocation.compareTo(landLocation);
	}

	@Override
	public int hashCode() {
		return _landLocation.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.landprice.model.LandLocation> toCacheModel() {
		return _landLocation.toCacheModel();
	}

	public com.portal_egov.portlet.landprice.model.LandLocation toEscapedModel() {
		return new LandLocationWrapper(_landLocation.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _landLocation.toString();
	}

	public java.lang.String toXmlString() {
		return _landLocation.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_landLocation.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LandLocation getWrappedLandLocation() {
		return _landLocation;
	}

	public LandLocation getWrappedModel() {
		return _landLocation;
	}

	public void resetOriginalValues() {
		_landLocation.resetOriginalValues();
	}

	private LandLocation _landLocation;
}