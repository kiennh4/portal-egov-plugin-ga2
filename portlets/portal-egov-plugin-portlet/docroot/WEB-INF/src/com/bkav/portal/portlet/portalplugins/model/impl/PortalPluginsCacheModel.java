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

package com.bkav.portal.portlet.portalplugins.model.impl;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PortalPlugins in entity cache.
 *
 * @author AnhBDb
 * @see PortalPlugins
 * @generated
 */
public class PortalPluginsCacheModel implements CacheModel<PortalPlugins>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{pluginId=");
		sb.append(pluginId);
		sb.append(", pluginName=");
		sb.append(pluginName);
		sb.append(", pluginCode=");
		sb.append(pluginCode);
		sb.append(", pluginVersion=");
		sb.append(pluginVersion);
		sb.append(", pluginType=");
		sb.append(pluginType);
		sb.append(", ePortalId=");
		sb.append(ePortalId);
		sb.append(", isImportant=");
		sb.append(isImportant);
		sb.append(", pluginDescription=");
		sb.append(pluginDescription);
		sb.append(", pluginUpdateInfo=");
		sb.append(pluginUpdateInfo);
		sb.append(", pluginSize=");
		sb.append(pluginSize);
		sb.append(", warFileId=");
		sb.append(warFileId);
		sb.append(", signFileId=");
		sb.append(signFileId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	public PortalPlugins toEntityModel() {
		PortalPluginsImpl portalPluginsImpl = new PortalPluginsImpl();

		portalPluginsImpl.setPluginId(pluginId);

		if (pluginName == null) {
			portalPluginsImpl.setPluginName(StringPool.BLANK);
		}
		else {
			portalPluginsImpl.setPluginName(pluginName);
		}

		if (pluginCode == null) {
			portalPluginsImpl.setPluginCode(StringPool.BLANK);
		}
		else {
			portalPluginsImpl.setPluginCode(pluginCode);
		}

		portalPluginsImpl.setPluginVersion(pluginVersion);
		portalPluginsImpl.setPluginType(pluginType);
		portalPluginsImpl.setEPortalId(ePortalId);
		portalPluginsImpl.setIsImportant(isImportant);

		if (pluginDescription == null) {
			portalPluginsImpl.setPluginDescription(StringPool.BLANK);
		}
		else {
			portalPluginsImpl.setPluginDescription(pluginDescription);
		}

		if (pluginUpdateInfo == null) {
			portalPluginsImpl.setPluginUpdateInfo(StringPool.BLANK);
		}
		else {
			portalPluginsImpl.setPluginUpdateInfo(pluginUpdateInfo);
		}

		portalPluginsImpl.setPluginSize(pluginSize);
		portalPluginsImpl.setWarFileId(warFileId);
		portalPluginsImpl.setSignFileId(signFileId);

		if (createDate == Long.MIN_VALUE) {
			portalPluginsImpl.setCreateDate(null);
		}
		else {
			portalPluginsImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			portalPluginsImpl.setModifyDate(null);
		}
		else {
			portalPluginsImpl.setModifyDate(new Date(modifyDate));
		}

		portalPluginsImpl.setGroupId(groupId);
		portalPluginsImpl.setUserId(userId);
		portalPluginsImpl.setCompanyId(companyId);

		if (userName == null) {
			portalPluginsImpl.setUserName(StringPool.BLANK);
		}
		else {
			portalPluginsImpl.setUserName(userName);
		}

		portalPluginsImpl.resetOriginalValues();

		return portalPluginsImpl;
	}

	public long pluginId;
	public String pluginName;
	public String pluginCode;
	public double pluginVersion;
	public int pluginType;
	public long ePortalId;
	public int isImportant;
	public String pluginDescription;
	public String pluginUpdateInfo;
	public double pluginSize;
	public long warFileId;
	public long signFileId;
	public long createDate;
	public long modifyDate;
	public long groupId;
	public long userId;
	public long companyId;
	public String userName;
}