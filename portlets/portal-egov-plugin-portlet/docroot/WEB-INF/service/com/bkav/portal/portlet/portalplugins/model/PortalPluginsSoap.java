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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bkav.portal.portlet.portalplugins.service.http.PortalPluginsServiceSoap}.
 *
 * @author    AnhBDb
 * @see       com.bkav.portal.portlet.portalplugins.service.http.PortalPluginsServiceSoap
 * @generated
 */
public class PortalPluginsSoap implements Serializable {
	public static PortalPluginsSoap toSoapModel(PortalPlugins model) {
		PortalPluginsSoap soapModel = new PortalPluginsSoap();

		soapModel.setPluginId(model.getPluginId());
		soapModel.setPluginName(model.getPluginName());
		soapModel.setPluginCode(model.getPluginCode());
		soapModel.setPluginVersion(model.getPluginVersion());
		soapModel.setPluginType(model.getPluginType());
		soapModel.setEPortalId(model.getEPortalId());
		soapModel.setIsImportant(model.getIsImportant());
		soapModel.setPluginDescription(model.getPluginDescription());
		soapModel.setPluginUpdateInfo(model.getPluginUpdateInfo());
		soapModel.setPluginSize(model.getPluginSize());
		soapModel.setWarFileId(model.getWarFileId());
		soapModel.setSignFileId(model.getSignFileId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static PortalPluginsSoap[] toSoapModels(PortalPlugins[] models) {
		PortalPluginsSoap[] soapModels = new PortalPluginsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortalPluginsSoap[][] toSoapModels(PortalPlugins[][] models) {
		PortalPluginsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortalPluginsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortalPluginsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortalPluginsSoap[] toSoapModels(List<PortalPlugins> models) {
		List<PortalPluginsSoap> soapModels = new ArrayList<PortalPluginsSoap>(models.size());

		for (PortalPlugins model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortalPluginsSoap[soapModels.size()]);
	}

	public PortalPluginsSoap() {
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
	private long _companyId;
	private String _userName;
}