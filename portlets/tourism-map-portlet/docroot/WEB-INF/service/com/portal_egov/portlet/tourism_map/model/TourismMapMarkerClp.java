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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.tourism_map.service.TourismMapMarkerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class TourismMapMarkerClp extends BaseModelImpl<TourismMapMarker>
	implements TourismMapMarker {
	public TourismMapMarkerClp() {
	}

	public Class<?> getModelClass() {
		return TourismMapMarker.class;
	}

	public String getModelClassName() {
		return TourismMapMarker.class.getName();
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMarkerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_markerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_markerId = markerId;
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

	public long getMarkerGroupId() {
		return _markerGroupId;
	}

	public void setMarkerGroupId(long markerGroupId) {
		_markerGroupId = markerGroupId;
	}

	public String getMarkerTitle() {
		return _markerTitle;
	}

	public void setMarkerTitle(String markerTitle) {
		_markerTitle = markerTitle;
	}

	public String getMarkerInfo() {
		return _markerInfo;
	}

	public void setMarkerInfo(String markerInfo) {
		_markerInfo = markerInfo;
	}

	public String getMarkerAddress() {
		return _markerAddress;
	}

	public void setMarkerAddress(String markerAddress) {
		_markerAddress = markerAddress;
	}

	public long getMarkerImageId() {
		return _markerImageId;
	}

	public void setMarkerImageId(long markerImageId) {
		_markerImageId = markerImageId;
	}

	public String getMarkerLongitude() {
		return _markerLongitude;
	}

	public void setMarkerLongitude(String markerLongitude) {
		_markerLongitude = markerLongitude;
	}

	public String getMarkerLatitude() {
		return _markerLatitude;
	}

	public void setMarkerLatitude(String markerLatitude) {
		_markerLatitude = markerLatitude;
	}

	public BaseModel<?> getTourismMapMarkerRemoteModel() {
		return _tourismMapMarkerRemoteModel;
	}

	public void setTourismMapMarkerRemoteModel(
		BaseModel<?> tourismMapMarkerRemoteModel) {
		_tourismMapMarkerRemoteModel = tourismMapMarkerRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TourismMapMarkerLocalServiceUtil.addTourismMapMarker(this);
		}
		else {
			TourismMapMarkerLocalServiceUtil.updateTourismMapMarker(this);
		}
	}

	@Override
	public TourismMapMarker toEscapedModel() {
		return (TourismMapMarker)Proxy.newProxyInstance(TourismMapMarker.class.getClassLoader(),
			new Class[] { TourismMapMarker.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TourismMapMarkerClp clone = new TourismMapMarkerClp();

		clone.setMarkerId(getMarkerId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMarkerGroupId(getMarkerGroupId());
		clone.setMarkerTitle(getMarkerTitle());
		clone.setMarkerInfo(getMarkerInfo());
		clone.setMarkerAddress(getMarkerAddress());
		clone.setMarkerImageId(getMarkerImageId());
		clone.setMarkerLongitude(getMarkerLongitude());
		clone.setMarkerLatitude(getMarkerLatitude());

		return clone;
	}

	public int compareTo(TourismMapMarker tourismMapMarker) {
		int value = 0;

		if (getMarkerGroupId() < tourismMapMarker.getMarkerGroupId()) {
			value = -1;
		}
		else if (getMarkerGroupId() > tourismMapMarker.getMarkerGroupId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getMarkerTitle().compareTo(tourismMapMarker.getMarkerTitle());

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

		TourismMapMarkerClp tourismMapMarker = null;

		try {
			tourismMapMarker = (TourismMapMarkerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tourismMapMarker.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{markerId=");
		sb.append(getMarkerId());
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
		sb.append(", markerGroupId=");
		sb.append(getMarkerGroupId());
		sb.append(", markerTitle=");
		sb.append(getMarkerTitle());
		sb.append(", markerInfo=");
		sb.append(getMarkerInfo());
		sb.append(", markerAddress=");
		sb.append(getMarkerAddress());
		sb.append(", markerImageId=");
		sb.append(getMarkerImageId());
		sb.append(", markerLongitude=");
		sb.append(getMarkerLongitude());
		sb.append(", markerLatitude=");
		sb.append(getMarkerLatitude());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.tourism_map.model.TourismMapMarker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>markerId</column-name><column-value><![CDATA[");
		sb.append(getMarkerId());
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
			"<column><column-name>markerGroupId</column-name><column-value><![CDATA[");
		sb.append(getMarkerGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerTitle</column-name><column-value><![CDATA[");
		sb.append(getMarkerTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerInfo</column-name><column-value><![CDATA[");
		sb.append(getMarkerInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerAddress</column-name><column-value><![CDATA[");
		sb.append(getMarkerAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerImageId</column-name><column-value><![CDATA[");
		sb.append(getMarkerImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerLongitude</column-name><column-value><![CDATA[");
		sb.append(getMarkerLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markerLatitude</column-name><column-value><![CDATA[");
		sb.append(getMarkerLatitude());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _markerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _markerGroupId;
	private String _markerTitle;
	private String _markerInfo;
	private String _markerAddress;
	private long _markerImageId;
	private String _markerLongitude;
	private String _markerLatitude;
	private BaseModel<?> _tourismMapMarkerRemoteModel;
}