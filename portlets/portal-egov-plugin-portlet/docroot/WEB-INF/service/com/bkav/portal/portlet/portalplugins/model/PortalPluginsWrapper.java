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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PortalPlugins}.
 * </p>
 *
 * @author    AnhBDb
 * @see       PortalPlugins
 * @generated
 */
public class PortalPluginsWrapper implements PortalPlugins,
	ModelWrapper<PortalPlugins> {
	public PortalPluginsWrapper(PortalPlugins portalPlugins) {
		_portalPlugins = portalPlugins;
	}

	public Class<?> getModelClass() {
		return PortalPlugins.class;
	}

	public String getModelClassName() {
		return PortalPlugins.class.getName();
	}

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

	/**
	* Returns the primary key of this portal plugins.
	*
	* @return the primary key of this portal plugins
	*/
	public long getPrimaryKey() {
		return _portalPlugins.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portal plugins.
	*
	* @param primaryKey the primary key of this portal plugins
	*/
	public void setPrimaryKey(long primaryKey) {
		_portalPlugins.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the plugin ID of this portal plugins.
	*
	* @return the plugin ID of this portal plugins
	*/
	public long getPluginId() {
		return _portalPlugins.getPluginId();
	}

	/**
	* Sets the plugin ID of this portal plugins.
	*
	* @param pluginId the plugin ID of this portal plugins
	*/
	public void setPluginId(long pluginId) {
		_portalPlugins.setPluginId(pluginId);
	}

	/**
	* Returns the plugin name of this portal plugins.
	*
	* @return the plugin name of this portal plugins
	*/
	public java.lang.String getPluginName() {
		return _portalPlugins.getPluginName();
	}

	/**
	* Sets the plugin name of this portal plugins.
	*
	* @param pluginName the plugin name of this portal plugins
	*/
	public void setPluginName(java.lang.String pluginName) {
		_portalPlugins.setPluginName(pluginName);
	}

	/**
	* Returns the plugin code of this portal plugins.
	*
	* @return the plugin code of this portal plugins
	*/
	public java.lang.String getPluginCode() {
		return _portalPlugins.getPluginCode();
	}

	/**
	* Sets the plugin code of this portal plugins.
	*
	* @param pluginCode the plugin code of this portal plugins
	*/
	public void setPluginCode(java.lang.String pluginCode) {
		_portalPlugins.setPluginCode(pluginCode);
	}

	/**
	* Returns the plugin version of this portal plugins.
	*
	* @return the plugin version of this portal plugins
	*/
	public double getPluginVersion() {
		return _portalPlugins.getPluginVersion();
	}

	/**
	* Sets the plugin version of this portal plugins.
	*
	* @param pluginVersion the plugin version of this portal plugins
	*/
	public void setPluginVersion(double pluginVersion) {
		_portalPlugins.setPluginVersion(pluginVersion);
	}

	/**
	* Returns the plugin type of this portal plugins.
	*
	* @return the plugin type of this portal plugins
	*/
	public int getPluginType() {
		return _portalPlugins.getPluginType();
	}

	/**
	* Sets the plugin type of this portal plugins.
	*
	* @param pluginType the plugin type of this portal plugins
	*/
	public void setPluginType(int pluginType) {
		_portalPlugins.setPluginType(pluginType);
	}

	/**
	* Returns the e portal ID of this portal plugins.
	*
	* @return the e portal ID of this portal plugins
	*/
	public long getEPortalId() {
		return _portalPlugins.getEPortalId();
	}

	/**
	* Sets the e portal ID of this portal plugins.
	*
	* @param ePortalId the e portal ID of this portal plugins
	*/
	public void setEPortalId(long ePortalId) {
		_portalPlugins.setEPortalId(ePortalId);
	}

	/**
	* Returns the is important of this portal plugins.
	*
	* @return the is important of this portal plugins
	*/
	public int getIsImportant() {
		return _portalPlugins.getIsImportant();
	}

	/**
	* Sets the is important of this portal plugins.
	*
	* @param isImportant the is important of this portal plugins
	*/
	public void setIsImportant(int isImportant) {
		_portalPlugins.setIsImportant(isImportant);
	}

	/**
	* Returns the plugin description of this portal plugins.
	*
	* @return the plugin description of this portal plugins
	*/
	public java.lang.String getPluginDescription() {
		return _portalPlugins.getPluginDescription();
	}

	/**
	* Sets the plugin description of this portal plugins.
	*
	* @param pluginDescription the plugin description of this portal plugins
	*/
	public void setPluginDescription(java.lang.String pluginDescription) {
		_portalPlugins.setPluginDescription(pluginDescription);
	}

	/**
	* Returns the plugin update info of this portal plugins.
	*
	* @return the plugin update info of this portal plugins
	*/
	public java.lang.String getPluginUpdateInfo() {
		return _portalPlugins.getPluginUpdateInfo();
	}

	/**
	* Sets the plugin update info of this portal plugins.
	*
	* @param pluginUpdateInfo the plugin update info of this portal plugins
	*/
	public void setPluginUpdateInfo(java.lang.String pluginUpdateInfo) {
		_portalPlugins.setPluginUpdateInfo(pluginUpdateInfo);
	}

	/**
	* Returns the plugin size of this portal plugins.
	*
	* @return the plugin size of this portal plugins
	*/
	public double getPluginSize() {
		return _portalPlugins.getPluginSize();
	}

	/**
	* Sets the plugin size of this portal plugins.
	*
	* @param pluginSize the plugin size of this portal plugins
	*/
	public void setPluginSize(double pluginSize) {
		_portalPlugins.setPluginSize(pluginSize);
	}

	/**
	* Returns the war file ID of this portal plugins.
	*
	* @return the war file ID of this portal plugins
	*/
	public long getWarFileId() {
		return _portalPlugins.getWarFileId();
	}

	/**
	* Sets the war file ID of this portal plugins.
	*
	* @param warFileId the war file ID of this portal plugins
	*/
	public void setWarFileId(long warFileId) {
		_portalPlugins.setWarFileId(warFileId);
	}

	/**
	* Returns the sign file ID of this portal plugins.
	*
	* @return the sign file ID of this portal plugins
	*/
	public long getSignFileId() {
		return _portalPlugins.getSignFileId();
	}

	/**
	* Sets the sign file ID of this portal plugins.
	*
	* @param signFileId the sign file ID of this portal plugins
	*/
	public void setSignFileId(long signFileId) {
		_portalPlugins.setSignFileId(signFileId);
	}

	/**
	* Returns the create date of this portal plugins.
	*
	* @return the create date of this portal plugins
	*/
	public java.util.Date getCreateDate() {
		return _portalPlugins.getCreateDate();
	}

	/**
	* Sets the create date of this portal plugins.
	*
	* @param createDate the create date of this portal plugins
	*/
	public void setCreateDate(java.util.Date createDate) {
		_portalPlugins.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this portal plugins.
	*
	* @return the modify date of this portal plugins
	*/
	public java.util.Date getModifyDate() {
		return _portalPlugins.getModifyDate();
	}

	/**
	* Sets the modify date of this portal plugins.
	*
	* @param modifyDate the modify date of this portal plugins
	*/
	public void setModifyDate(java.util.Date modifyDate) {
		_portalPlugins.setModifyDate(modifyDate);
	}

	/**
	* Returns the group ID of this portal plugins.
	*
	* @return the group ID of this portal plugins
	*/
	public long getGroupId() {
		return _portalPlugins.getGroupId();
	}

	/**
	* Sets the group ID of this portal plugins.
	*
	* @param groupId the group ID of this portal plugins
	*/
	public void setGroupId(long groupId) {
		_portalPlugins.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this portal plugins.
	*
	* @return the user ID of this portal plugins
	*/
	public long getUserId() {
		return _portalPlugins.getUserId();
	}

	/**
	* Sets the user ID of this portal plugins.
	*
	* @param userId the user ID of this portal plugins
	*/
	public void setUserId(long userId) {
		_portalPlugins.setUserId(userId);
	}

	/**
	* Returns the user uuid of this portal plugins.
	*
	* @return the user uuid of this portal plugins
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portalPlugins.getUserUuid();
	}

	/**
	* Sets the user uuid of this portal plugins.
	*
	* @param userUuid the user uuid of this portal plugins
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_portalPlugins.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this portal plugins.
	*
	* @return the company ID of this portal plugins
	*/
	public long getCompanyId() {
		return _portalPlugins.getCompanyId();
	}

	/**
	* Sets the company ID of this portal plugins.
	*
	* @param companyId the company ID of this portal plugins
	*/
	public void setCompanyId(long companyId) {
		_portalPlugins.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this portal plugins.
	*
	* @return the user name of this portal plugins
	*/
	public java.lang.String getUserName() {
		return _portalPlugins.getUserName();
	}

	/**
	* Sets the user name of this portal plugins.
	*
	* @param userName the user name of this portal plugins
	*/
	public void setUserName(java.lang.String userName) {
		_portalPlugins.setUserName(userName);
	}

	public boolean isNew() {
		return _portalPlugins.isNew();
	}

	public void setNew(boolean n) {
		_portalPlugins.setNew(n);
	}

	public boolean isCachedModel() {
		return _portalPlugins.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_portalPlugins.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _portalPlugins.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _portalPlugins.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portalPlugins.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portalPlugins.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portalPlugins.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortalPluginsWrapper((PortalPlugins)_portalPlugins.clone());
	}

	public int compareTo(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins) {
		return _portalPlugins.compareTo(portalPlugins);
	}

	@Override
	public int hashCode() {
		return _portalPlugins.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> toCacheModel() {
		return _portalPlugins.toCacheModel();
	}

	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins toEscapedModel() {
		return new PortalPluginsWrapper(_portalPlugins.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portalPlugins.toString();
	}

	public java.lang.String toXmlString() {
		return _portalPlugins.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portalPlugins.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PortalPlugins getWrappedPortalPlugins() {
		return _portalPlugins;
	}

	public PortalPlugins getWrappedModel() {
		return _portalPlugins;
	}

	public void resetOriginalValues() {
		_portalPlugins.resetOriginalValues();
	}

	private PortalPlugins _portalPlugins;
}