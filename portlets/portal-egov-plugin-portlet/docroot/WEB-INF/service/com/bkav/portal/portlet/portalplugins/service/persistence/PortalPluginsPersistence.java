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

package com.bkav.portal.portlet.portalplugins.service.persistence;

import com.bkav.portal.portlet.portalplugins.model.PortalPlugins;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the portal plugins service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see PortalPluginsPersistenceImpl
 * @see PortalPluginsUtil
 * @generated
 */
public interface PortalPluginsPersistence extends BasePersistence<PortalPlugins> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortalPluginsUtil} to access the portal plugins persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the portal plugins in the entity cache if it is enabled.
	*
	* @param portalPlugins the portal plugins
	*/
	public void cacheResult(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins);

	/**
	* Caches the portal pluginses in the entity cache if it is enabled.
	*
	* @param portalPluginses the portal pluginses
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> portalPluginses);

	/**
	* Creates a new portal plugins with the primary key. Does not add the portal plugins to the database.
	*
	* @param pluginId the primary key for the new portal plugins
	* @return the new portal plugins
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins create(
		long pluginId);

	/**
	* Removes the portal plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins that was removed
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins remove(
		long pluginId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins updateImpl(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins with the primary key or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPrimaryKey(
		long pluginId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins, or <code>null</code> if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByPrimaryKey(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portal pluginses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portal pluginses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @return the range of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portal pluginses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal pluginses before and after the current portal plugins in the ordered set where groupId = &#63;.
	*
	* @param pluginId the primary key of the current portal plugins
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] findByGroupId_PrevAndNext(
		long pluginId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portal pluginses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching portal pluginses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portal pluginses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @return the range of matching portal pluginses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portal pluginses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portal pluginses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal pluginses before and after the current portal plugins in the ordered set of portal pluginses that the user has permission to view where groupId = &#63;.
	*
	* @param pluginId the primary key of the current portal plugins
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] filterFindByGroupId_PrevAndNext(
		long pluginId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portal pluginses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portal pluginses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @return the range of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portal pluginses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal pluginses before and after the current portal plugins in the ordered set where companyId = &#63;.
	*
	* @param pluginId the primary key of the current portal plugins
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] findByCompanyId_PrevAndNext(
		long pluginId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins where pluginCode = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @return the matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByPluginCode(
		java.lang.String pluginCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portal pluginses where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @return the matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByePortalId(
		long ePortalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portal pluginses where ePortalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ePortalId the e portal ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @return the range of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByePortalId(
		long ePortalId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portal pluginses where ePortalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ePortalId the e portal ID
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByePortalId(
		long ePortalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByePortalId_First(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByePortalId_First(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByePortalId_Last(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByePortalId_Last(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portal pluginses before and after the current portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param pluginId the primary key of the current portal plugins
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] findByePortalId_PrevAndNext(
		long pluginId, long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portal pluginses.
	*
	* @return the portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the portal pluginses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @return the range of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the portal pluginses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portal pluginses
	* @param end the upper bound of the range of portal pluginses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portal pluginses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portal pluginses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the portal plugins where pluginCode = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @return the portal plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins removeByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the portal plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.PortalPlugins removeByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portal pluginses where ePortalId = &#63; from the database.
	*
	* @param ePortalId the e portal ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByePortalId(long ePortalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portal pluginses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching portal pluginses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses where pluginCode = &#63;.
	*
	* @param pluginCode the plugin code
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPluginCode(java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63;.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCodeAndVersion(java.lang.String pluginCode,
		double pluginVersion, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByePortalId(long ePortalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portal pluginses.
	*
	* @return the number of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}