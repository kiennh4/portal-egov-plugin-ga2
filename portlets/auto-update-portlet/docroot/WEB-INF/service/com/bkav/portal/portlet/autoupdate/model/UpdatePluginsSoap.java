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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.autoupdate.service.http.UpdatePluginsServiceSoap}.
 *
 * @author    anhbdb
 * @see       com.bkav.portal.portlet.autoupdate.service.http.UpdatePluginsServiceSoap
 * @generated
 */
public class UpdatePluginsSoap implements Serializable {
	public static UpdatePluginsSoap toSoapModel(UpdatePlugins model) {
		UpdatePluginsSoap soapModel = new UpdatePluginsSoap();

		soapModel.setPluginId(model.getPluginId());
		soapModel.setPluginName(model.getPluginName());
		soapModel.setPluginCode(model.getPluginCode());
		soapModel.setPluginType(model.getPluginType());
		soapModel.setCurrentVersion(model.getCurrentVersion());
		soapModel.setPreviousVersions(model.getPreviousVersions());
		soapModel.setCurrentSize(model.getCurrentSize());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setServerCompanyId(model.getServerCompanyId());

		return soapModel;
	}

	public static UpdatePluginsSoap[] toSoapModels(UpdatePlugins[] models) {
		UpdatePluginsSoap[] soapModels = new UpdatePluginsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UpdatePluginsSoap[][] toSoapModels(UpdatePlugins[][] models) {
		UpdatePluginsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UpdatePluginsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UpdatePluginsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UpdatePluginsSoap[] toSoapModels(List<UpdatePlugins> models) {
		List<UpdatePluginsSoap> soapModels = new ArrayList<UpdatePluginsSoap>(models.size());

		for (UpdatePlugins model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UpdatePluginsSoap[soapModels.size()]);
	}

	public UpdatePluginsSoap() {
	}

	public long getPrimaryKey() {
		return _pluginId;
	}

	public void setPrimaryKey(long pk) {
		setPluginId(pk);
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
}