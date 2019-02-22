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

package com.bkav.portal.portlet.autoupdate.model.impl;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UpdatePlugins in entity cache.
 *
 * @author anhbdb
 * @see UpdatePlugins
 * @generated
 */
public class UpdatePluginsCacheModel implements CacheModel<UpdatePlugins>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{pluginId=");
		sb.append(pluginId);
		sb.append(", pluginName=");
		sb.append(pluginName);
		sb.append(", pluginCode=");
		sb.append(pluginCode);
		sb.append(", pluginType=");
		sb.append(pluginType);
		sb.append(", currentVersion=");
		sb.append(currentVersion);
		sb.append(", previousVersions=");
		sb.append(previousVersions);
		sb.append(", currentSize=");
		sb.append(currentSize);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", serverCompanyId=");
		sb.append(serverCompanyId);
		sb.append("}");

		return sb.toString();
	}

	public UpdatePlugins toEntityModel() {
		UpdatePluginsImpl updatePluginsImpl = new UpdatePluginsImpl();

		updatePluginsImpl.setPluginId(pluginId);

		if (pluginName == null) {
			updatePluginsImpl.setPluginName(StringPool.BLANK);
		}
		else {
			updatePluginsImpl.setPluginName(pluginName);
		}

		if (pluginCode == null) {
			updatePluginsImpl.setPluginCode(StringPool.BLANK);
		}
		else {
			updatePluginsImpl.setPluginCode(pluginCode);
		}

		updatePluginsImpl.setPluginType(pluginType);
		updatePluginsImpl.setCurrentVersion(currentVersion);

		if (previousVersions == null) {
			updatePluginsImpl.setPreviousVersions(StringPool.BLANK);
		}
		else {
			updatePluginsImpl.setPreviousVersions(previousVersions);
		}

		updatePluginsImpl.setCurrentSize(currentSize);

		if (createDate == Long.MIN_VALUE) {
			updatePluginsImpl.setCreateDate(null);
		}
		else {
			updatePluginsImpl.setCreateDate(new Date(createDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			updatePluginsImpl.setModifyDate(null);
		}
		else {
			updatePluginsImpl.setModifyDate(new Date(modifyDate));
		}

		updatePluginsImpl.setServerCompanyId(serverCompanyId);

		updatePluginsImpl.resetOriginalValues();

		return updatePluginsImpl;
	}

	public long pluginId;
	public String pluginName;
	public String pluginCode;
	public int pluginType;
	public double currentVersion;
	public String previousVersions;
	public double currentSize;
	public long createDate;
	public long modifyDate;
	public long serverCompanyId;
}