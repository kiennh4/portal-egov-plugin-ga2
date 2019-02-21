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

package com.bkav.portal.portlet.autoupdate.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;
import com.bkav.portal.portlet.autoupdate.service.base.UpdatePluginsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * The implementation of the update plugins local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anhbdb
 * @see com.bkav.portal.portlet.autoupdate.service.base.UpdatePluginsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalServiceUtil
 */
public class UpdatePluginsLocalServiceImpl
	extends UpdatePluginsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalServiceUtil} to access the update plugins local service.
	 */
	public List<UpdatePlugins> findAll () throws SystemException, PortalException 
	{
		return updatePluginsPersistence.findAll();
	}
	
	public UpdatePlugins findByPluginCode (String pluginCode) throws SystemException, PortalException 
	{
		return updatePluginsPersistence.findByPluginCode(pluginCode);
	}
	
	public UpdatePlugins fetchByPluginCode (String pluginCode) throws SystemException, PortalException 
	{
		return updatePluginsPersistence.fetchByPluginCode(pluginCode);
	}
	
	public UpdatePlugins findByPluginCodeAndVersion (String pluginCode, double version) throws SystemException, PortalException 
	{
		return updatePluginsPersistence.findByPluginCodeAndVersion(pluginCode, version);
	}
	
	public void addPlugin (String pluginName, String pluginCode, long serverCompanyId, double currentVersion, double currentSize, int pluginType) throws SystemException, PortalException
	{
		long pluginId = counterLocalService.increment();
		
		UpdatePlugins plugin = updatePluginsPersistence.create(pluginId);
		Date now = new Date();
		
		plugin.setPluginName(pluginName);
		plugin.setPluginCode(pluginCode);
		plugin.setCurrentVersion(currentVersion);
		plugin.setCurrentSize(currentSize);
		plugin.setPreviousVersions(StringUtil.valueOf(currentVersion));
		plugin.setPluginType(pluginType);
		plugin.setCreateDate(now);
		plugin.setModifyDate(now);
		plugin.setServerCompanyId(serverCompanyId);
		
		updatePluginsPersistence.update(plugin, false);
	}
	
	public void updatePlugin (long pluginId, String pluginName,  long serverCompanyId, double currentVersion, double currentSize, int pluginType, String pluginCode, String previousVersions) throws SystemException, PortalException
	{
		UpdatePlugins plugin = updatePluginsPersistence.fetchByPrimaryKey(pluginId);
		if (pluginCode.equals(plugin.getPluginCode()))
		{
			plugin.setPluginName(pluginName);
			plugin.setCurrentVersion(currentVersion);
			plugin.setCurrentSize(currentSize);
			plugin.setPluginType(pluginType);
			plugin.setPreviousVersions(previousVersions);
			plugin.setServerCompanyId(serverCompanyId);
			
			updatePluginsPersistence.update(plugin, false);
		}
		else
		{
			throw new EntityNotFoundException();
		}
	}
	
	public void updateVersioPlugin (long pluginId, double currentVerion, String previousVerion) throws SystemException, PortalException
	{
		UpdatePlugins plugin = updatePluginsPersistence.fetchByPrimaryKey(pluginId);
		if (plugin!=null)
		{
			plugin.setCurrentVersion(currentVerion);
			plugin.setPreviousVersions(previousVerion);
			
			updatePluginsPersistence.update(plugin, false);
		}
	}
}