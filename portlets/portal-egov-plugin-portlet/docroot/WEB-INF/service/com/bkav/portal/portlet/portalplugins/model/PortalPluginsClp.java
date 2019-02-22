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

import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AnhBDb
 */
public class PortalPluginsClp extends BaseModelImpl<PortalPlugins>
	implements PortalPlugins {
	public PortalPluginsClp() {
	}

	public Class<?> getModelClass() {
		return PortalPlugins.class;
	}

	public String getModelClassName() {
		return PortalPlugins.class.getName();
	}

	public long getPrimaryKey() {
		return _pluginId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPluginId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pluginId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pluginId", getPluginId());
		attributes.put("pluginName", getPluginName());
		attributes.put("pluginCode", getPluginCode());
		attributes.put("pluginVersion", getPluginVersion());
		attributes.put("pluginType", getPluginType());
		attributes.put("ePortalId", getEPortalId());
		attributes.put("isImportant", getIsImportant());
		attributes.put("pluginDescription", getPluginDescription());
		attributes.put("pluginUpdateInfo", getPluginUpdateInfo());
		attributes.put("pluginSize", getPluginSize());
		attributes.put("warFileId", getWarFileId());
		attributes.put("signFileId", getSignFileId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pluginId = (Long)attributes.get("pluginId");

		if (pluginId != null) {
			setPluginId(pluginId);
		}

		String pluginName = (String)attributes.get("pluginName");

		if (pluginName != null) {
			setPluginName(pluginName);
		}

		String pluginCode = (String)attributes.get("pluginCode");

		if (pluginCode != null) {
			setPluginCode(pluginCode);
		}

		Double pluginVersion = (Double)attributes.get("pluginVersion");

		if (pluginVersion != null) {
			setPluginVersion(pluginVersion);
		}

		Integer pluginType = (Integer)attributes.get("pluginType");

		if (pluginType != null) {
			setPluginType(pluginType);
		}

		Long ePortalId = (Long)attributes.get("ePortalId");

		if (ePortalId != null) {
			setEPortalId(ePortalId);
		}

		Integer isImportant = (Integer)attributes.get("isImportant");

		if (isImportant != null) {
			setIsImportant(isImportant);
		}

		String pluginDescription = (String)attributes.get("pluginDescription");

		if (pluginDescription != null) {
			setPluginDescription(pluginDescription);
		}

		String pluginUpdateInfo = (String)attributes.get("pluginUpdateInfo");

		if (pluginUpdateInfo != null) {
			setPluginUpdateInfo(pluginUpdateInfo);
		}

		Double pluginSize = (Double)attributes.get("pluginSize");

		if (pluginSize != null) {
			setPluginSize(pluginSize);
		}

		Long warFileId = (Long)attributes.get("warFileId");

		if (warFileId != null) {
			setWarFileId(warFileId);
		}

		Long signFileId = (Long)attributes.get("signFileId");

		if (signFileId != null) {
			setSignFileId(signFileId);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	public long getPluginId() {
		return _pluginId;
	}

	public void setPluginId(long pluginId) {
		_pluginId = pluginId;
	}

	public String getPluginName() {
		return _pluginName;
	}

	public void setPluginName(String pluginName) {
		_pluginName = pluginName;
	}

	public String getPluginCode() {
		return _pluginCode;
	}

	public void setPluginCode(String pluginCode) {
		_pluginCode = pluginCode;
	}

	public double getPluginVersion() {
		return _pluginVersion;
	}

	public void setPluginVersion(double pluginVersion) {
		_pluginVersion = pluginVersion;
	}

	public int getPluginType() {
		return _pluginType;
	}

	public void setPluginType(int pluginType) {
		_pluginType = pluginType;
	}

	public long getEPortalId() {
		return _ePortalId;
	}

	public void setEPortalId(long ePortalId) {
		_ePortalId = ePortalId;
	}

	public int getIsImportant() {
		return _isImportant;
	}

	public void setIsImportant(int isImportant) {
		_isImportant = isImportant;
	}

	public String getPluginDescription() {
		return _pluginDescription;
	}

	public void setPluginDescription(String pluginDescription) {
		_pluginDescription = pluginDescription;
	}

	public String getPluginUpdateInfo() {
		return _pluginUpdateInfo;
	}

	public void setPluginUpdateInfo(String pluginUpdateInfo) {
		_pluginUpdateInfo = pluginUpdateInfo;
	}

	public double getPluginSize() {
		return _pluginSize;
	}

	public void setPluginSize(double pluginSize) {
		_pluginSize = pluginSize;
	}

	public long getWarFileId() {
		return _warFileId;
	}

	public void setWarFileId(long warFileId) {
		_warFileId = warFileId;
	}

	public long getSignFileId() {
		return _signFileId;
	}

	public void setSignFileId(long signFileId) {
		_signFileId = signFileId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public BaseModel<?> getPortalPluginsRemoteModel() {
		return _portalPluginsRemoteModel;
	}

	public void setPortalPluginsRemoteModel(
		BaseModel<?> portalPluginsRemoteModel) {
		_portalPluginsRemoteModel = portalPluginsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PortalPluginsLocalServiceUtil.addPortalPlugins(this);
		}
		else {
			PortalPluginsLocalServiceUtil.updatePortalPlugins(this);
		}
	}

	@Override
	public PortalPlugins toEscapedModel() {
		return (PortalPlugins)Proxy.newProxyInstance(PortalPlugins.class.getClassLoader(),
			new Class[] { PortalPlugins.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortalPluginsClp clone = new PortalPluginsClp();

		clone.setPluginId(getPluginId());
		clone.setPluginName(getPluginName());
		clone.setPluginCode(getPluginCode());
		clone.setPluginVersion(getPluginVersion());
		clone.setPluginType(getPluginType());
		clone.setEPortalId(getEPortalId());
		clone.setIsImportant(getIsImportant());
		clone.setPluginDescription(getPluginDescription());
		clone.setPluginUpdateInfo(getPluginUpdateInfo());
		clone.setPluginSize(getPluginSize());
		clone.setWarFileId(getWarFileId());
		clone.setSignFileId(getSignFileId());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());

		return clone;
	}

	public int compareTo(PortalPlugins portalPlugins) {
		int value = 0;

		if (getPluginVersion() < portalPlugins.getPluginVersion()) {
			value = -1;
		}
		else if (getPluginVersion() > portalPlugins.getPluginVersion()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getModifyDate(),
				portalPlugins.getModifyDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getPluginName().compareTo(portalPlugins.getPluginName());

		value = value * -1;

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

		PortalPluginsClp portalPlugins = null;

		try {
			portalPlugins = (PortalPluginsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = portalPlugins.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{pluginId=");
		sb.append(getPluginId());
		sb.append(", pluginName=");
		sb.append(getPluginName());
		sb.append(", pluginCode=");
		sb.append(getPluginCode());
		sb.append(", pluginVersion=");
		sb.append(getPluginVersion());
		sb.append(", pluginType=");
		sb.append(getPluginType());
		sb.append(", ePortalId=");
		sb.append(getEPortalId());
		sb.append(", isImportant=");
		sb.append(getIsImportant());
		sb.append(", pluginDescription=");
		sb.append(getPluginDescription());
		sb.append(", pluginUpdateInfo=");
		sb.append(getPluginUpdateInfo());
		sb.append(", pluginSize=");
		sb.append(getPluginSize());
		sb.append(", warFileId=");
		sb.append(getWarFileId());
		sb.append(", signFileId=");
		sb.append(getSignFileId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.portalplugins.model.PortalPlugins");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pluginId</column-name><column-value><![CDATA[");
		sb.append(getPluginId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginName</column-name><column-value><![CDATA[");
		sb.append(getPluginName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginCode</column-name><column-value><![CDATA[");
		sb.append(getPluginCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginVersion</column-name><column-value><![CDATA[");
		sb.append(getPluginVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginType</column-name><column-value><![CDATA[");
		sb.append(getPluginType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ePortalId</column-name><column-value><![CDATA[");
		sb.append(getEPortalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isImportant</column-name><column-value><![CDATA[");
		sb.append(getIsImportant());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginDescription</column-name><column-value><![CDATA[");
		sb.append(getPluginDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginUpdateInfo</column-name><column-value><![CDATA[");
		sb.append(getPluginUpdateInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pluginSize</column-name><column-value><![CDATA[");
		sb.append(getPluginSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>warFileId</column-name><column-value><![CDATA[");
		sb.append(getWarFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signFileId</column-name><column-value><![CDATA[");
		sb.append(getSignFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
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
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _pluginId;
	private String _pluginName;
	private String _pluginCode;
	private double _pluginVersion;
	private int _pluginType;
	private long _ePortalId;
	private int _isImportant;
	private String _pluginDescription;
	private String _pluginUpdateInfo;
	private double _pluginSize;
	private long _warFileId;
	private long _signFileId;
	private Date _createDate;
	private Date _modifyDate;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private String _userName;
	private BaseModel<?> _portalPluginsRemoteModel;
}