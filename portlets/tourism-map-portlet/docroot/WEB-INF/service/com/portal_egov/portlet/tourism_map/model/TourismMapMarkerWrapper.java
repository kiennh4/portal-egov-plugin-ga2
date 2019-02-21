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
 * This class is a wrapper for {@link TourismMapMarker}.
 * </p>
 *
 * @author    HungDX
 * @see       TourismMapMarker
 * @generated
 */
public class TourismMapMarkerWrapper implements TourismMapMarker,
	ModelWrapper<TourismMapMarker> {
	public TourismMapMarkerWrapper(TourismMapMarker tourismMapMarker) {
		_tourismMapMarker = tourismMapMarker;
	}

	public Class<?> getModelClass() {
		return TourismMapMarker.class;
	}

	public String getModelClassName() {
		return TourismMapMarker.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("markerId", getMarkerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("markerGroupId", getMarkerGroupId());
		attributes.put("markerTitle", getMarkerTitle());
		attributes.put("markerInfo", getMarkerInfo());
		attributes.put("markerAddress", getMarkerAddress());
		attributes.put("markerImageId", getMarkerImageId());
		attributes.put("markerLongitude", getMarkerLongitude());
		attributes.put("markerLatitude", getMarkerLatitude());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long markerId = (Long)attributes.get("markerId");

		if (markerId != null) {
			setMarkerId(markerId);
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

		Long markerGroupId = (Long)attributes.get("markerGroupId");

		if (markerGroupId != null) {
			setMarkerGroupId(markerGroupId);
		}

		String markerTitle = (String)attributes.get("markerTitle");

		if (markerTitle != null) {
			setMarkerTitle(markerTitle);
		}

		String markerInfo = (String)attributes.get("markerInfo");

		if (markerInfo != null) {
			setMarkerInfo(markerInfo);
		}

		String markerAddress = (String)attributes.get("markerAddress");

		if (markerAddress != null) {
			setMarkerAddress(markerAddress);
		}

		Long markerImageId = (Long)attributes.get("markerImageId");

		if (markerImageId != null) {
			setMarkerImageId(markerImageId);
		}

		String markerLongitude = (String)attributes.get("markerLongitude");

		if (markerLongitude != null) {
			setMarkerLongitude(markerLongitude);
		}

		String markerLatitude = (String)attributes.get("markerLatitude");

		if (markerLatitude != null) {
			setMarkerLatitude(markerLatitude);
		}
	}

	/**
	* Returns the primary key of this tourism map marker.
	*
	* @return the primary key of this tourism map marker
	*/
	public long getPrimaryKey() {
		return _tourismMapMarker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tourism map marker.
	*
	* @param primaryKey the primary key of this tourism map marker
	*/
	public void setPrimaryKey(long primaryKey) {
		_tourismMapMarker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marker ID of this tourism map marker.
	*
	* @return the marker ID of this tourism map marker
	*/
	public long getMarkerId() {
		return _tourismMapMarker.getMarkerId();
	}

	/**
	* Sets the marker ID of this tourism map marker.
	*
	* @param markerId the marker ID of this tourism map marker
	*/
	public void setMarkerId(long markerId) {
		_tourismMapMarker.setMarkerId(markerId);
	}

	/**
	* Returns the company ID of this tourism map marker.
	*
	* @return the company ID of this tourism map marker
	*/
	public long getCompanyId() {
		return _tourismMapMarker.getCompanyId();
	}

	/**
	* Sets the company ID of this tourism map marker.
	*
	* @param companyId the company ID of this tourism map marker
	*/
	public void setCompanyId(long companyId) {
		_tourismMapMarker.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this tourism map marker.
	*
	* @return the group ID of this tourism map marker
	*/
	public long getGroupId() {
		return _tourismMapMarker.getGroupId();
	}

	/**
	* Sets the group ID of this tourism map marker.
	*
	* @param groupId the group ID of this tourism map marker
	*/
	public void setGroupId(long groupId) {
		_tourismMapMarker.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this tourism map marker.
	*
	* @return the user ID of this tourism map marker
	*/
	public long getUserId() {
		return _tourismMapMarker.getUserId();
	}

	/**
	* Sets the user ID of this tourism map marker.
	*
	* @param userId the user ID of this tourism map marker
	*/
	public void setUserId(long userId) {
		_tourismMapMarker.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tourism map marker.
	*
	* @return the user uuid of this tourism map marker
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarker.getUserUuid();
	}

	/**
	* Sets the user uuid of this tourism map marker.
	*
	* @param userUuid the user uuid of this tourism map marker
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_tourismMapMarker.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tourism map marker.
	*
	* @return the user name of this tourism map marker
	*/
	public java.lang.String getUserName() {
		return _tourismMapMarker.getUserName();
	}

	/**
	* Sets the user name of this tourism map marker.
	*
	* @param userName the user name of this tourism map marker
	*/
	public void setUserName(java.lang.String userName) {
		_tourismMapMarker.setUserName(userName);
	}

	/**
	* Returns the create date of this tourism map marker.
	*
	* @return the create date of this tourism map marker
	*/
	public java.util.Date getCreateDate() {
		return _tourismMapMarker.getCreateDate();
	}

	/**
	* Sets the create date of this tourism map marker.
	*
	* @param createDate the create date of this tourism map marker
	*/
	public void setCreateDate(java.util.Date createDate) {
		_tourismMapMarker.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tourism map marker.
	*
	* @return the modified date of this tourism map marker
	*/
	public java.util.Date getModifiedDate() {
		return _tourismMapMarker.getModifiedDate();
	}

	/**
	* Sets the modified date of this tourism map marker.
	*
	* @param modifiedDate the modified date of this tourism map marker
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tourismMapMarker.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the marker group ID of this tourism map marker.
	*
	* @return the marker group ID of this tourism map marker
	*/
	public long getMarkerGroupId() {
		return _tourismMapMarker.getMarkerGroupId();
	}

	/**
	* Sets the marker group ID of this tourism map marker.
	*
	* @param markerGroupId the marker group ID of this tourism map marker
	*/
	public void setMarkerGroupId(long markerGroupId) {
		_tourismMapMarker.setMarkerGroupId(markerGroupId);
	}

	/**
	* Returns the marker title of this tourism map marker.
	*
	* @return the marker title of this tourism map marker
	*/
	public java.lang.String getMarkerTitle() {
		return _tourismMapMarker.getMarkerTitle();
	}

	/**
	* Sets the marker title of this tourism map marker.
	*
	* @param markerTitle the marker title of this tourism map marker
	*/
	public void setMarkerTitle(java.lang.String markerTitle) {
		_tourismMapMarker.setMarkerTitle(markerTitle);
	}

	/**
	* Returns the marker info of this tourism map marker.
	*
	* @return the marker info of this tourism map marker
	*/
	public java.lang.String getMarkerInfo() {
		return _tourismMapMarker.getMarkerInfo();
	}

	/**
	* Sets the marker info of this tourism map marker.
	*
	* @param markerInfo the marker info of this tourism map marker
	*/
	public void setMarkerInfo(java.lang.String markerInfo) {
		_tourismMapMarker.setMarkerInfo(markerInfo);
	}

	/**
	* Returns the marker address of this tourism map marker.
	*
	* @return the marker address of this tourism map marker
	*/
	public java.lang.String getMarkerAddress() {
		return _tourismMapMarker.getMarkerAddress();
	}

	/**
	* Sets the marker address of this tourism map marker.
	*
	* @param markerAddress the marker address of this tourism map marker
	*/
	public void setMarkerAddress(java.lang.String markerAddress) {
		_tourismMapMarker.setMarkerAddress(markerAddress);
	}

	/**
	* Returns the marker image ID of this tourism map marker.
	*
	* @return the marker image ID of this tourism map marker
	*/
	public long getMarkerImageId() {
		return _tourismMapMarker.getMarkerImageId();
	}

	/**
	* Sets the marker image ID of this tourism map marker.
	*
	* @param markerImageId the marker image ID of this tourism map marker
	*/
	public void setMarkerImageId(long markerImageId) {
		_tourismMapMarker.setMarkerImageId(markerImageId);
	}

	/**
	* Returns the marker longitude of this tourism map marker.
	*
	* @return the marker longitude of this tourism map marker
	*/
	public java.lang.String getMarkerLongitude() {
		return _tourismMapMarker.getMarkerLongitude();
	}

	/**
	* Sets the marker longitude of this tourism map marker.
	*
	* @param markerLongitude the marker longitude of this tourism map marker
	*/
	public void setMarkerLongitude(java.lang.String markerLongitude) {
		_tourismMapMarker.setMarkerLongitude(markerLongitude);
	}

	/**
	* Returns the marker latitude of this tourism map marker.
	*
	* @return the marker latitude of this tourism map marker
	*/
	public java.lang.String getMarkerLatitude() {
		return _tourismMapMarker.getMarkerLatitude();
	}

	/**
	* Sets the marker latitude of this tourism map marker.
	*
	* @param markerLatitude the marker latitude of this tourism map marker
	*/
	public void setMarkerLatitude(java.lang.String markerLatitude) {
		_tourismMapMarker.setMarkerLatitude(markerLatitude);
	}

	public boolean isNew() {
		return _tourismMapMarker.isNew();
	}

	public void setNew(boolean n) {
		_tourismMapMarker.setNew(n);
	}

	public boolean isCachedModel() {
		return _tourismMapMarker.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tourismMapMarker.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tourismMapMarker.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tourismMapMarker.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tourismMapMarker.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tourismMapMarker.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tourismMapMarker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TourismMapMarkerWrapper((TourismMapMarker)_tourismMapMarker.clone());
	}

	public int compareTo(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker) {
		return _tourismMapMarker.compareTo(tourismMapMarker);
	}

	@Override
	public int hashCode() {
		return _tourismMapMarker.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> toCacheModel() {
		return _tourismMapMarker.toCacheModel();
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker toEscapedModel() {
		return new TourismMapMarkerWrapper(_tourismMapMarker.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tourismMapMarker.toString();
	}

	public java.lang.String toXmlString() {
		return _tourismMapMarker.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tourismMapMarker.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TourismMapMarker getWrappedTourismMapMarker() {
		return _tourismMapMarker;
	}

	public TourismMapMarker getWrappedModel() {
		return _tourismMapMarker;
	}

	public void resetOriginalValues() {
		_tourismMapMarker.resetOriginalValues();
	}

	private TourismMapMarker _tourismMapMarker;
}