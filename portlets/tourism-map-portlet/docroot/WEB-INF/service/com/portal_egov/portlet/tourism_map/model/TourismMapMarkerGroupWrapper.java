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

package com.portal_egov.portlet.tourism_map.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TourismMapMarkerGroup}.
 * </p>
 *
 * @author    HungDX
 * @see       TourismMapMarkerGroup
 * @generated
 */
public class TourismMapMarkerGroupWrapper implements TourismMapMarkerGroup,
	ModelWrapper<TourismMapMarkerGroup> {
	public TourismMapMarkerGroupWrapper(
		TourismMapMarkerGroup tourismMapMarkerGroup) {
		_tourismMapMarkerGroup = tourismMapMarkerGroup;
	}

	public Class<?> getModelClass() {
		return TourismMapMarkerGroup.class;
	}

	public String getModelClassName() {
		return TourismMapMarkerGroup.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("markerGroupId", getMarkerGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("markerGroupName", getMarkerGroupName());
		attributes.put("markerGroupInfo", getMarkerGroupInfo());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long markerGroupId = (Long)attributes.get("markerGroupId");

		if (markerGroupId != null) {
			setMarkerGroupId(markerGroupId);
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

		String markerGroupName = (String)attributes.get("markerGroupName");

		if (markerGroupName != null) {
			setMarkerGroupName(markerGroupName);
		}

		String markerGroupInfo = (String)attributes.get("markerGroupInfo");

		if (markerGroupInfo != null) {
			setMarkerGroupInfo(markerGroupInfo);
		}
	}

	/**
	* Returns the primary key of this tourism map marker group.
	*
	* @return the primary key of this tourism map marker group
	*/
	public long getPrimaryKey() {
		return _tourismMapMarkerGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tourism map marker group.
	*
	* @param primaryKey the primary key of this tourism map marker group
	*/
	public void setPrimaryKey(long primaryKey) {
		_tourismMapMarkerGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marker group ID of this tourism map marker group.
	*
	* @return the marker group ID of this tourism map marker group
	*/
	public long getMarkerGroupId() {
		return _tourismMapMarkerGroup.getMarkerGroupId();
	}

	/**
	* Sets the marker group ID of this tourism map marker group.
	*
	* @param markerGroupId the marker group ID of this tourism map marker group
	*/
	public void setMarkerGroupId(long markerGroupId) {
		_tourismMapMarkerGroup.setMarkerGroupId(markerGroupId);
	}

	/**
	* Returns the company ID of this tourism map marker group.
	*
	* @return the company ID of this tourism map marker group
	*/
	public long getCompanyId() {
		return _tourismMapMarkerGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this tourism map marker group.
	*
	* @param companyId the company ID of this tourism map marker group
	*/
	public void setCompanyId(long companyId) {
		_tourismMapMarkerGroup.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this tourism map marker group.
	*
	* @return the group ID of this tourism map marker group
	*/
	public long getGroupId() {
		return _tourismMapMarkerGroup.getGroupId();
	}

	/**
	* Sets the group ID of this tourism map marker group.
	*
	* @param groupId the group ID of this tourism map marker group
	*/
	public void setGroupId(long groupId) {
		_tourismMapMarkerGroup.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this tourism map marker group.
	*
	* @return the user ID of this tourism map marker group
	*/
	public long getUserId() {
		return _tourismMapMarkerGroup.getUserId();
	}

	/**
	* Sets the user ID of this tourism map marker group.
	*
	* @param userId the user ID of this tourism map marker group
	*/
	public void setUserId(long userId) {
		_tourismMapMarkerGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tourism map marker group.
	*
	* @return the user uuid of this tourism map marker group
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this tourism map marker group.
	*
	* @param userUuid the user uuid of this tourism map marker group
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tourismMapMarkerGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tourism map marker group.
	*
	* @return the user name of this tourism map marker group
	*/
	public java.lang.String getUserName() {
		return _tourismMapMarkerGroup.getUserName();
	}

	/**
	* Sets the user name of this tourism map marker group.
	*
	* @param userName the user name of this tourism map marker group
	*/
	public void setUserName(java.lang.String userName) {
		_tourismMapMarkerGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this tourism map marker group.
	*
	* @return the create date of this tourism map marker group
	*/
	public java.util.Date getCreateDate() {
		return _tourismMapMarkerGroup.getCreateDate();
	}

	/**
	* Sets the create date of this tourism map marker group.
	*
	* @param createDate the create date of this tourism map marker group
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tourismMapMarkerGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tourism map marker group.
	*
	* @return the modified date of this tourism map marker group
	*/
	public java.util.Date getModifiedDate() {
		return _tourismMapMarkerGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this tourism map marker group.
	*
	* @param modifiedDate the modified date of this tourism map marker group
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tourismMapMarkerGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the marker group name of this tourism map marker group.
	*
	* @return the marker group name of this tourism map marker group
	*/
	public java.lang.String getMarkerGroupName() {
		return _tourismMapMarkerGroup.getMarkerGroupName();
	}

	/**
	* Sets the marker group name of this tourism map marker group.
	*
	* @param markerGroupName the marker group name of this tourism map marker group
	*/
	public void setMarkerGroupName(java.lang.String markerGroupName) {
		_tourismMapMarkerGroup.setMarkerGroupName(markerGroupName);
	}

	/**
	* Returns the marker group info of this tourism map marker group.
	*
	* @return the marker group info of this tourism map marker group
	*/
	public java.lang.String getMarkerGroupInfo() {
		return _tourismMapMarkerGroup.getMarkerGroupInfo();
	}

	/**
	* Sets the marker group info of this tourism map marker group.
	*
	* @param markerGroupInfo the marker group info of this tourism map marker group
	*/
	public void setMarkerGroupInfo(java.lang.String markerGroupInfo) {
		_tourismMapMarkerGroup.setMarkerGroupInfo(markerGroupInfo);
	}

	public boolean isNew() {
		return _tourismMapMarkerGroup.isNew();
	}

	public void setNew(boolean n) {
		_tourismMapMarkerGroup.setNew(n);
	}

	public boolean isCachedModel() {
		return _tourismMapMarkerGroup.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tourismMapMarkerGroup.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tourismMapMarkerGroup.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tourismMapMarkerGroup.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tourismMapMarkerGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tourismMapMarkerGroup.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tourismMapMarkerGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TourismMapMarkerGroupWrapper((TourismMapMarkerGroup)_tourismMapMarkerGroup.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup) {
		return _tourismMapMarkerGroup.compareTo(tourismMapMarkerGroup);
	}

	@Override
	public int hashCode() {
		return _tourismMapMarkerGroup.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> toCacheModel() {
		return _tourismMapMarkerGroup.toCacheModel();
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup toEscapedModel() {
		return new TourismMapMarkerGroupWrapper(_tourismMapMarkerGroup.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tourismMapMarkerGroup.toString();
	}

	public java.lang.String toXmlString() {
		return _tourismMapMarkerGroup.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tourismMapMarkerGroup.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TourismMapMarkerGroup getWrappedTourismMapMarkerGroup() {
		return _tourismMapMarkerGroup;
	}

	public TourismMapMarkerGroup getWrappedModel() {
		return _tourismMapMarkerGroup;
	}

	public void resetOriginalValues() {
		_tourismMapMarkerGroup.resetOriginalValues();
	}

	private TourismMapMarkerGroup _tourismMapMarkerGroup;
}