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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class LandLocationClp extends BaseModelImpl<LandLocation>
	implements LandLocation {
	public LandLocationClp() {
	}

	public Class<?> getModelClass() {
		return LandLocation.class;
	}

	public String getModelClassName() {
		return LandLocation.class.getName();
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLocationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_locationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getParentLocationId() {
		return _parentLocationId;
	}

	public void setParentLocationId(long parentLocationId) {
		_parentLocationId = parentLocationId;
	}

	public String getLocationName() {
		return _locationName;
	}

	public void setLocationName(String locationName) {
		_locationName = locationName;
	}

	public String getLocationInfo() {
		return _locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		_locationInfo = locationInfo;
	}

	public BaseModel<?> getLandLocationRemoteModel() {
		return _landLocationRemoteModel;
	}

	public void setLandLocationRemoteModel(BaseModel<?> landLocationRemoteModel) {
		_landLocationRemoteModel = landLocationRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LandLocationLocalServiceUtil.addLandLocation(this);
		}
		else {
			LandLocationLocalServiceUtil.updateLandLocation(this);
		}
	}

	@Override
	public LandLocation toEscapedModel() {
		return (LandLocation)Proxy.newProxyInstance(LandLocation.class.getClassLoader(),
			new Class[] { LandLocation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LandLocationClp clone = new LandLocationClp();

		clone.setLocationId(getLocationId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setParentLocationId(getParentLocationId());
		clone.setLocationName(getLocationName());
		clone.setLocationInfo(getLocationInfo());

		return clone;
	}

	public int compareTo(LandLocation landLocation) {
		int value = 0;

		if (getParentLocationId() < landLocation.getParentLocationId()) {
			value = -1;
		}
		else if (getParentLocationId() > landLocation.getParentLocationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LandLocationClp landLocation = null;

		try {
			landLocation = (LandLocationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = landLocation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{locationId=");
		sb.append(getLocationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", parentLocationId=");
		sb.append(getParentLocationId());
		sb.append(", locationName=");
		sb.append(getLocationName());
		sb.append(", locationInfo=");
		sb.append(getLocationInfo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.landprice.model.LandLocation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentLocationId</column-name><column-value><![CDATA[");
		sb.append(getParentLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationName</column-name><column-value><![CDATA[");
		sb.append(getLocationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationInfo</column-name><column-value><![CDATA[");
		sb.append(getLocationInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _locationId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _parentLocationId;
	private String _locationName;
	private String _locationInfo;
	private BaseModel<?> _landLocationRemoteModel;
}