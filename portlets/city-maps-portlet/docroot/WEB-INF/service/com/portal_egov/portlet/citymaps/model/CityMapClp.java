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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HungDX
 */
public class CityMapClp extends BaseModelImpl<CityMap> implements CityMap {
	public CityMapClp() {
	}

	public Class<?> getModelClass() {
		return CityMap.class;
	}

	public String getModelClassName() {
		return CityMap.class.getName();
	}

	public long getPrimaryKey() {
		return _mapId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMapId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_mapId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getMapId() {
		return _mapId;
	}

	public void setMapId(long mapId) {
		_mapId = mapId;
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

	public long getMapTypeId() {
		return _mapTypeId;
	}

	public void setMapTypeId(long mapTypeId) {
		_mapTypeId = mapTypeId;
	}

	public long getMapImageId() {
		return _mapImageId;
	}

	public void setMapImageId(long mapImageId) {
		_mapImageId = mapImageId;
	}

	public String getMapName() {
		return _mapName;
	}

	public void setMapName(String mapName) {
		_mapName = mapName;
	}

	public String getMapDesc() {
		return _mapDesc;
	}

	public void setMapDesc(String mapDesc) {
		_mapDesc = mapDesc;
	}

	public BaseModel<?> getCityMapRemoteModel() {
		return _cityMapRemoteModel;
	}

	public void setCityMapRemoteModel(BaseModel<?> cityMapRemoteModel) {
		_cityMapRemoteModel = cityMapRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CityMapLocalServiceUtil.addCityMap(this);
		}
		else {
			CityMapLocalServiceUtil.updateCityMap(this);
		}
	}

	@Override
	public CityMap toEscapedModel() {
		return (CityMap)Proxy.newProxyInstance(CityMap.class.getClassLoader(),
			new Class[] { CityMap.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CityMapClp clone = new CityMapClp();

		clone.setMapId(getMapId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setMapTypeId(getMapTypeId());
		clone.setMapImageId(getMapImageId());
		clone.setMapName(getMapName());
		clone.setMapDesc(getMapDesc());

		return clone;
	}

	public int compareTo(CityMap cityMap) {
		int value = 0;

		if (getMapTypeId() < cityMap.getMapTypeId()) {
			value = -1;
		}
		else if (getMapTypeId() > cityMap.getMapTypeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getMapName().compareTo(cityMap.getMapName());

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

		CityMapClp cityMap = null;

		try {
			cityMap = (CityMapClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cityMap.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{mapId=");
		sb.append(getMapId());
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
		sb.append(", mapTypeId=");
		sb.append(getMapTypeId());
		sb.append(", mapImageId=");
		sb.append(getMapImageId());
		sb.append(", mapName=");
		sb.append(getMapName());
		sb.append(", mapDesc=");
		sb.append(getMapDesc());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.citymaps.model.CityMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mapId</column-name><column-value><![CDATA[");
		sb.append(getMapId());
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
			"<column><column-name>mapTypeId</column-name><column-value><![CDATA[");
		sb.append(getMapTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapImageId</column-name><column-value><![CDATA[");
		sb.append(getMapImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapName</column-name><column-value><![CDATA[");
		sb.append(getMapName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapDesc</column-name><column-value><![CDATA[");
		sb.append(getMapDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _mapId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mapTypeId;
	private long _mapImageId;
	private String _mapName;
	private String _mapDesc;
	private BaseModel<?> _cityMapRemoteModel;
}