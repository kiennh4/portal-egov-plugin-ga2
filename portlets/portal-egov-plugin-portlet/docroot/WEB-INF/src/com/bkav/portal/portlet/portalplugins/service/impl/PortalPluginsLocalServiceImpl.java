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

package com.bkav.portal.portlet.portalplugins.service.impl;

import java.util.Date;
import java.util.List;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;
import com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil;
import com.bkav.portal.portlet.portalplugins.service.base.PortalPluginsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

/**
 * The implementation of the portal plugins local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author AnhBDb
 * @see com.bkav.portal.portlet.portalplugins.service.base.PortalPluginsLocalServiceBaseImpl
 * @see com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil
 */
public class PortalPluginsLocalServiceImpl extends
		PortalPluginsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.bkav.portal
	 * .portlet.portalplugins.service.PortalPluginsLocalServiceUtil} to access
	 * the portal plugins local service.
	 */
	public List<PortalPlugins> findByGroupId(long groupId)
			throws SystemException, PortalException {
		return portalPluginsPersistence.findByGroupId(groupId);
	}

	public PortalPlugins findByPluginCode(String pluginCode)
			throws SystemException, PortalException {
		return portalPluginsPersistence.findByPluginCode(pluginCode);
	}
	
	public List<PortalPlugins> findByEportalId( long ePortalId)
			throws SystemException, PortalException {
		return portalPluginsPersistence.findByePortalId(ePortalId);
	}

	public PortalPlugins findByPluginCodeAndVersion(long groupId,
			String pluginCode, long pluginVersion) throws SystemException,
			PortalException {
		return portalPluginsPersistence.findByCodeAndVersion(pluginCode,
				pluginVersion, groupId);
	}
	
	public List<PortalPlugins> findPortalPluginsByFilter (long groupId, String pluginName, String pluginCode, int pluginType, long ePortalId, int start, int end) throws SystemException, PortalException
	{
		return portalPluginsFinder.findPortalPluginsByFilter(groupId, pluginName, pluginCode, pluginType, ePortalId, start, end, null);
	}
	
	public void addPortalPlugin(long groupId, long companyId, long userId,
			String userName, String pluginName, String pluginCode,
			double pluginVersion, int pluginType, long ePortalId,
			int isImportant, String pluginDescription, String pluginUpdateInfo,
			double pluginSize, long warFileId, long signFileId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		long pluginId = counterLocalService.increment();
		Date now = new Date();

		PortalPlugins plugin = portalPluginsPersistence.create(pluginId);

		plugin.setGroupId(groupId);
		plugin.setCompanyId(companyId);
		plugin.setUserId(userId);
		plugin.setUserName(userName);
		plugin.setPluginName(pluginName);
		plugin.setPluginCode(pluginCode);
		plugin.setPluginVersion(pluginVersion);
		plugin.setPluginType(pluginType);
		plugin.setEPortalId(ePortalId);
		plugin.setIsImportant(isImportant);
		plugin.setPluginDescription(pluginDescription);
		plugin.setPluginUpdateInfo(pluginUpdateInfo);
		plugin.setPluginSize(pluginSize);
		plugin.setWarFileId(warFileId);
		plugin.setSignFileId(signFileId);
		plugin.setCreateDate(now);
		plugin.setModifyDate(now);

		portalPluginsPersistence.update(plugin, false);

		if (serviceContext.isAddGroupPermissions()
				|| serviceContext.isAddGuestPermissions()) {

			addPortalPluginsResources(plugin,
					serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		} else {

			addPortalPluginsResources(plugin,
					serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
	}

	public void updatePortalPlugin(long pluginId, String pluginName,
			String pluginCode, double pluginVersion, int pluginType,
			long ePortalId, int isImportant, String pluginDescription,
			String pluginUpdateInfo, double pluginSize, long warFileId,
			long signFileId) throws SystemException, PortalException {
		Date now = new Date();

		PortalPlugins plugin = portalPluginsPersistence
				.fetchByPrimaryKey(pluginId);

		plugin.setPluginName(pluginName);
		plugin.setPluginCode(pluginCode);
		plugin.setPluginVersion(pluginVersion);
		plugin.setPluginType(pluginType);
		plugin.setEPortalId(ePortalId);
		plugin.setIsImportant(isImportant);
		plugin.setPluginDescription(pluginDescription);
		plugin.setPluginUpdateInfo(pluginUpdateInfo);
		plugin.setPluginSize(pluginSize);
		plugin.setWarFileId(warFileId);
		plugin.setSignFileId(signFileId);
		plugin.setModifyDate(now);

		portalPluginsPersistence.update(plugin, false);
	}
	
	public void deletePortalPlugin(long pluginId) throws SystemException, PortalException {
		PortalPlugins plugin = portalPluginsPersistence
				.fetchByPrimaryKey(pluginId);
		
		if (plugin!=null)
		{
			try {
				DLAppServiceUtil.deleteFileEntry(plugin.getWarFileId());
				DLAppServiceUtil.deleteFileEntry(plugin.getSignFileId());
			}
			catch (Exception e)
			{
				
			}
			PortalPluginsLocalServiceUtil.deletePortalPlugins(plugin);
		}
	}

	private void addPortalPluginsResources(PortalPlugins plugin,
			boolean addGroupPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(plugin.getCompanyId(),
				plugin.getGroupId(), plugin.getUserId(),
				PortalPlugins.class.getName(), plugin.getPrimaryKey(), false,
				addGroupPermissions, addGuestPermissions);
	}

	private void addPortalPluginsResources(PortalPlugins plugin,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(plugin.getCompanyId(),
				plugin.getGroupId(), plugin.getUserId(),
				PortalPlugins.class.getName(), plugin.getPrimaryKey(),
				groupPermissions, guestPermissions);
	}

}