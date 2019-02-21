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
 * This class is a wrapper for {@link CityMap}.
 * </p>
 *
 * @author    HungDX
 * @see       CityMap
 * @generated
 */
public class CityMapWrapper implements CityMap, ModelWrapper<CityMap> {
	public CityMapWrapper(CityMap cityMap) {
		_cityMap = cityMap;
	}

	public Class<?> getModelClass() {
		return CityMap.class;
	}

	public String getModelClassName() {
		return CityMap.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapId", getMapId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mapTypeId", getMapTypeId());
		attributes.put("mapImageId", getMapImageId());
		attributes.put("mapName", getMapName());
		attributes.put("mapDesc", getMapDesc());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long mapId = (Long)attributes.get("mapId");

		if (mapId != null) {
			setMapId(mapId);
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

		Long mapTypeId = (Long)attributes.get("mapTypeId");

		if (mapTypeId != null) {
			setMapTypeId(mapTypeId);
		}

		Long mapImageId = (Long)attributes.get("mapImageId");

		if (mapImageId != null) {
			setMapImageId(mapImageId);
		}

		String mapName = (String)attributes.get("mapName");

		if (mapName != null) {
			setMapName(mapName);
		}

		String mapDesc = (String)attributes.get("mapDesc");

		if (mapDesc != null) {
			setMapDesc(mapDesc);
		}
	}

	/**
	* Returns the primary key of this city map.
	*
	* @return the primary key of this city map
	*/
	public long getPrimaryKey() {
		return _cityMap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this city map.
	*
	* @param primaryKey the primary key of this city map
	*/
	public void setPrimaryKey(long primaryKey) {
		_cityMap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the map ID of this city map.
	*
	* @return the map ID of this city map
	*/
	public long getMapId() {
		return _cityMap.getMapId();
	}

	/**
	* Sets the map ID of this city map.
	*
	* @param mapId the map ID of this city map
	*/
	public void setMapId(long mapId) {
		_cityMap.setMapId(mapId);
	}

	/**
	* Returns the company ID of this city map.
	*
	* @return the company ID of this city map
	*/
	public long getCompanyId() {
		return _cityMap.getCompanyId();
	}

	/**
	* Sets the company ID of this city map.
	*
	* @param companyId the company ID of this city map
	*/
	public void setCompanyId(long companyId) {
		_cityMap.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this city map.
	*
	* @return the group ID of this city map
	*/
	public long getGroupId() {
		return _cityMap.getGroupId();
	}

	/**
	* Sets the group ID of this city map.
	*
	* @param groupId the group ID of this city map
	*/
	public void setGroupId(long groupId) {
		_cityMap.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this city map.
	*
	* @return the user ID of this city map
	*/
	public long getUserId() {
		return _cityMap.getUserId();
	}

	/**
	* Sets the user ID of this city map.
	*
	* @param userId the user ID of this city map
	*/
	public void setUserId(long userId) {
		_cityMap.setUserId(userId);
	}

	/**
	* Returns the user uuid of this city map.
	*
	* @return the user uuid of this city map
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMap.getUserUuid();
	}

	/**
	* Sets the user uuid of this city map.
	*
	* @param userUuid the user uuid of this city map
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_cityMap.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this city map.
	*
	* @return the user name of this city map
	*/
	public java.lang.String getUserName() {
		return _cityMap.getUserName();
	}

	/**
	* Sets the user name of this city map.
	*
	* @param userName the user name of this city map
	*/
	public void setUserName(java.lang.String userName) {
		_cityMap.setUserName(userName);
	}

	/**
	* Returns the create date of this city map.
	*
	* @return the create date of this city map
	*/
	public java.util.Date getCreateDate() {
		return _cityMap.getCreateDate();
	}

	/**
	* Sets the create date of this city map.
	*
	* @param createDate the create date of this city map
	*/
	public void setCreateDate(java.util.Date createDate) {
		_cityMap.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this city map.
	*
	* @return the modified date of this city map
	*/
	public java.util.Date getModifiedDate() {
		return _cityMap.getModifiedDate();
	}

	/**
	* Sets the modified date of this city map.
	*
	* @param modifiedDate the modified date of this city map
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cityMap.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the map type ID of this city map.
	*
	* @return the map type ID of this city map
	*/
	public long getMapTypeId() {
		return _cityMap.getMapTypeId();
	}

	/**
	* Sets the map type ID of this city map.
	*
	* @param mapTypeId the map type ID of this city map
	*/
	public void setMapTypeId(long mapTypeId) {
		_cityMap.setMapTypeId(mapTypeId);
	}

	/**
	* Returns the map image ID of this city map.
	*
	* @return the map image ID of this city map
	*/
	public long getMapImageId() {
		return _cityMap.getMapImageId();
	}

	/**
	* Sets the map image ID of this city map.
	*
	* @param mapImageId the map image ID of this city map
	*/
	public void setMapImageId(long mapImageId) {
		_cityMap.setMapImageId(mapImageId);
	}

	/**
	* Returns the map name of this city map.
	*
	* @return the map name of this city map
	*/
	public java.lang.String getMapName() {
		return _cityMap.getMapName();
	}

	/**
	* Sets the map name of this city map.
	*
	* @param mapName the map name of this city map
	*/
	public void setMapName(java.lang.String mapName) {
		_cityMap.setMapName(mapName);
	}

	/**
	* Returns the map desc of this city map.
	*
	* @return the map desc of this city map
	*/
	public java.lang.String getMapDesc() {
		return _cityMap.getMapDesc();
	}

	/**
	* Sets the map desc of this city map.
	*
	* @param mapDesc the map desc of this city map
	*/
	public void setMapDesc(java.lang.String mapDesc) {
		_cityMap.setMapDesc(mapDesc);
	}

	public boolean isNew() {
		return _cityMap.isNew();
	}

	public void setNew(boolean n) {
		_cityMap.setNew(n);
	}

	public boolean isCachedModel() {
		return _cityMap.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cityMap.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cityMap.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cityMap.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cityMap.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cityMap.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cityMap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CityMapWrapper((CityMap)_cityMap.clone());
	}

	public int compareTo(com.portal_egov.portlet.citymaps.model.CityMap cityMap) {
		return _cityMap.compareTo(cityMap);
	}

	@Override
	public int hashCode() {
		return _cityMap.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.citymaps.model.CityMap> toCacheModel() {
		return _cityMap.toCacheModel();
	}

	public com.portal_egov.portlet.citymaps.model.CityMap toEscapedModel() {
		return new CityMapWrapper(_cityMap.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cityMap.toString();
	}

	public java.lang.String toXmlString() {
		return _cityMap.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cityMap.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CityMap getWrappedCityMap() {
		return _cityMap;
	}

	public CityMap getWrappedModel() {
		return _cityMap;
	}

	public void resetOriginalValues() {
		_cityMap.resetOriginalValues();
	}

	private CityMap _cityMap;
}