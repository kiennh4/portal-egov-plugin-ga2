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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UpdatePlugins}.
 * </p>
 *
 * @author    anhbdb
 * @see       UpdatePlugins
 * @generated
 */
public class UpdatePluginsWrapper implements UpdatePlugins,
	ModelWrapper<UpdatePlugins> {
	public UpdatePluginsWrapper(UpdatePlugins updatePlugins) {
		_updatePlugins = updatePlugins;
	}

	public Class<?> getModelClass() {
		return UpdatePlugins.class;
	}

	public String getModelClassName() {
		return UpdatePlugins.class.getName();
	}

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

	/**
	* Returns the primary key of this update plugins.
	*
	* @return the primary key of this update plugins
	*/
	public long getPrimaryKey() {
		return _updatePlugins.getPrimaryKey();
	}

	/**
	* Sets the primary key of this update plugins.
	*
	* @param primaryKey the primary key of this update plugins
	*/
	public void setPrimaryKey(long primaryKey) {
		_updatePlugins.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the plugin ID of this update plugins.
	*
	* @return the plugin ID of this update plugins
	*/
	public long getPluginId() {
		return _updatePlugins.getPluginId();
	}

	/**
	* Sets the plugin ID of this update plugins.
	*
	* @param pluginId the plugin ID of this update plugins
	*/
	public void setPluginId(long pluginId) {
		_updatePlugins.setPluginId(pluginId);
	}

	/**
	* Returns the plugin name of this update plugins.
	*
	* @return the plugin name of this update plugins
	*/
	public java.lang.String getPluginName() {
		return _updatePlugins.getPluginName();
	}

	/**
	* Sets the plugin name of this update plugins.
	*
	* @param pluginName the plugin name of this update plugins
	*/
	public void setPluginName(java.lang.String pluginName) {
		_updatePlugins.setPluginName(pluginName);
	}

	/**
	* Returns the plugin code of this update plugins.
	*
	* @return the plugin code of this update plugins
	*/
	public java.lang.String getPluginCode() {
		return _updatePlugins.getPluginCode();
	}

	/**
	* Sets the plugin code of this update plugins.
	*
	* @param pluginCode the plugin code of this update plugins
	*/
	public void setPluginCode(java.lang.String pluginCode) {
		_updatePlugins.setPluginCode(pluginCode);
	}

	/**
	* Returns the plugin type of this update plugins.
	*
	* @return the plugin type of this update plugins
	*/
	public int getPluginType() {
		return _updatePlugins.getPluginType();
	}

	/**
	* Sets the plugin type of this update plugins.
	*
	* @param pluginType the plugin type of this update plugins
	*/
	public void setPluginType(int pluginType) {
		_updatePlugins.setPluginType(pluginType);
	}

	/**
	* Returns the current version of this update plugins.
	*
	* @return the current version of this update plugins
	*/
	public double getCurrentVersion() {
		return _updatePlugins.getCurrentVersion();
	}

	/**
	* Sets the current version of this update plugins.
	*
	* @param currentVersion the current version of this update plugins
	*/
	public void setCurrentVersion(double currentVersion) {
		_updatePlugins.setCurrentVersion(currentVersion);
	}

	/**
	* Returns the previous versions of this update plugins.
	*
	* @return the previous versions of this update plugins
	*/
	public java.lang.String getPreviousVersions() {
		return _updatePlugins.getPreviousVersions();
	}

	/**
	* Sets the previous versions of this update plugins.
	*
	* @param previousVersions the previous versions of this update plugins
	*/
	public void setPreviousVersions(java.lang.String previousVersions) {
		_updatePlugins.setPreviousVersions(previousVersions);
	}

	/**
	* Returns the current size of this update plugins.
	*
	* @return the current size of this update plugins
	*/
	public double getCurrentSize() {
		return _updatePlugins.getCurrentSize();
	}

	/**
	* Sets the current size of this update plugins.
	*
	* @param currentSize the current size of this update plugins
	*/
	public void setCurrentSize(double currentSize) {
		_updatePlugins.setCurrentSize(currentSize);
	}

	/**
	* Returns the create date of this update plugins.
	*
	* @return the create date of this update plugins
	*/
	public java.util.Date getCreateDate() {
		return _updatePlugins.getCreateDate();
	}

	/**
	* Sets the create date of this update plugins.
	*
	* @param createDate the create date of this update plugins
	*/
	public void setCreateDate(java.util.Date createDate) {
		_updatePlugins.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this update plugins.
	*
	* @return the modify date of this update plugins
	*/
	public java.util.Date getModifyDate() {
		return _updatePlugins.getModifyDate();
	}

	/**
	* Sets the modify date of this update plugins.
	*
	* @param modifyDate the modify date of this update plugins
	*/
	public void setModifyDate(java.util.Date modifyDate) {
		_updatePlugins.setModifyDate(modifyDate);
	}

	/**
	* Returns the server company ID of this update plugins.
	*
	* @return the server company ID of this update plugins
	*/
	public long getServerCompanyId() {
		return _updatePlugins.getServerCompanyId();
	}

	/**
	* Sets the server company ID of this update plugins.
	*
	* @param serverCompanyId the server company ID of this update plugins
	*/
	public void setServerCompanyId(long serverCompanyId) {
		_updatePlugins.setServerCompanyId(serverCompanyId);
	}

	public boolean isNew() {
		return _updatePlugins.isNew();
	}

	public void setNew(boolean n) {
		_updatePlugins.setNew(n);
	}

	public boolean isCachedModel() {
		return _updatePlugins.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_updatePlugins.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _updatePlugins.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _updatePlugins.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_updatePlugins.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _updatePlugins.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_updatePlugins.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UpdatePluginsWrapper((UpdatePlugins)_updatePlugins.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins) {
		return _updatePlugins.compareTo(updatePlugins);
	}

	@Override
	public int hashCode() {
		return _updatePlugins.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> toCacheModel() {
		return _updatePlugins.toCacheModel();
	}

	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins toEscapedModel() {
		return new UpdatePluginsWrapper(_updatePlugins.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _updatePlugins.toString();
	}

	public java.lang.String toXmlString() {
		return _updatePlugins.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_updatePlugins.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UpdatePlugins getWrappedUpdatePlugins() {
		return _updatePlugins;
	}

	public UpdatePlugins getWrappedModel() {
		return _updatePlugins;
	}

	public void resetOriginalValues() {
		_updatePlugins.resetOriginalValues();
	}

	private UpdatePlugins _updatePlugins;
}