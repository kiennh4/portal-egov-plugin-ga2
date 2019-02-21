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

package com.bkav.portal.portlet.autoupdate.model;

import com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anhbdb
 */
public class UpdatePluginsClp extends BaseModelImpl<UpdatePlugins>
	implements UpdatePlugins {
	public UpdatePluginsClp() {
	}

	public Class<?> getModelClass() {
		return UpdatePlugins.class;
	}

	public String getModelClassName() {
		return UpdatePlugins.class.getName();
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
		attributes.put("pluginType", getPluginType());
		attributes.put("currentVersion", getCurrentVersion());
		attributes.put("previousVersions", getPreviousVersions());
		attributes.put("currentSize", getCurrentSize());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("serverCompanyId", getServerCompanyId());

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

		Integer pluginType = (Integer)attributes.get("pluginType");

		if (pluginType != null) {
			setPluginType(pluginType);
		}

		Double currentVersion = (Double)attributes.get("currentVersion");

		if (currentVersion != null) {
			setCurrentVersion(currentVersion);
		}

		String previousVersions = (String)attributes.get("previousVersions");

		if (previousVersions != null) {
			setPreviousVersions(previousVersions);
		}

		Double currentSize = (Double)attributes.get("currentSize");

		if (currentSize != null) {
			setCurrentSize(currentSize);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Long serverCompanyId = (Long)attributes.get("serverCompanyId");

		if (serverCompanyId != null) {
			setServerCompanyId(serverCompanyId);
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

	public int getPluginType() {
		return _pluginType;
	}

	public void setPluginType(int pluginType) {
		_pluginType = pluginType;
	}

	public double getCurrentVersion() {
		return _currentVersion;
	}

	public void setCurrentVersion(double currentVersion) {
		_currentVersion = currentVersion;
	}

	public String getPreviousVersions() {
		return _previousVersions;
	}

	public void setPreviousVersions(String previousVersions) {
		_previousVersions = previousVersions;
	}

	public double getCurrentSize() {
		return _currentSize;
	}

	public void setCurrentSize(double currentSize) {
		_currentSize = currentSize;
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

	public long getServerCompanyId() {
		return _serverCompanyId;
	}

	public void setServerCompanyId(long serverCompanyId) {
		_serverCompanyId = serverCompanyId;
	}

	public BaseModel<?> getUpdatePluginsRemoteModel() {
		return _updatePluginsRemoteModel;
	}

	public void setUpdatePluginsRemoteModel(
		BaseModel<?> updatePluginsRemoteModel) {
		_updatePluginsRemoteModel = updatePluginsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UpdatePluginsLocalServiceUtil.addUpdatePlugins(this);
		}
		else {
			UpdatePluginsLocalServiceUtil.updateUpdatePlugins(this);
		}
	}

	@Override
	public UpdatePlugins toEscapedModel() {
		return (UpdatePlugins)Proxy.newProxyInstance(UpdatePlugins.class.getClassLoader(),
			new Class[] { UpdatePlugins.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UpdatePluginsClp clone = new UpdatePluginsClp();

		clone.setPluginId(getPluginId());
		clone.setPluginName(getPluginName());
		clone.setPluginCode(getPluginCode());
		clone.setPluginType(getPluginType());
		clone.setCurrentVersion(getCurrentVersion());
		clone.setPreviousVersions(getPreviousVersions());
		clone.setCurrentSize(getCurrentSize());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setServerCompanyId(getServerCompanyId());

		return clone;
	}

	public int compareTo(UpdatePlugins updatePlugins) {
		long primaryKey = updatePlugins.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UpdatePluginsClp updatePlugins = null;

		try {
			updatePlugins = (UpdatePluginsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = updatePlugins.getPrimaryKey();

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

		sb.append("{pluginId=");
		sb.append(getPluginId());
		sb.append(", pluginName=");
		sb.append(getPluginName());
		sb.append(", pluginCode=");
		sb.append(getPluginCode());
		sb.append(", pluginType=");
		sb.append(getPluginType());
		sb.append(", currentVersion=");
		sb.append(getCurrentVersion());
		sb.append(", previousVersions=");
		sb.append(getPreviousVersions());
		sb.append(", currentSize=");
		sb.append(getCurrentSize());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", serverCompanyId=");
		sb.append(getServerCompanyId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.bkav.portal.portlet.autoupdate.model.UpdatePlugins");
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
			"<column><column-name>pluginType</column-name><column-value><![CDATA[");
		sb.append(getPluginType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentVersion</column-name><column-value><![CDATA[");
		sb.append(getCurrentVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousVersions</column-name><column-value><![CDATA[");
		sb.append(getPreviousVersions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentSize</column-name><column-value><![CDATA[");
		sb.append(getCurrentSize());
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
			"<column><column-name>serverCompanyId</column-name><column-value><![CDATA[");
		sb.append(getServerCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _pluginId;
	private String _pluginName;
	private String _pluginCode;
	private int _pluginType;
	private double _currentVersion;
	private String _previousVersions;
	private double _currentSize;
	private Date _createDate;
	private Date _modifyDate;
	private long _serverCompanyId;
	private BaseModel<?> _updatePluginsRemoteModel;
}