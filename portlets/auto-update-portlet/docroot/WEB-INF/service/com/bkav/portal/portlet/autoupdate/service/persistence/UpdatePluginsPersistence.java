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

package com.bkav.portal.portlet.autoupdate.service.persistence;

import com.bkav.portal.portlet.autoupdate.model.UpdatePlugins;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the update plugins service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see UpdatePluginsPersistenceImpl
 * @see UpdatePluginsUtil
 * @generated
 */
public interface UpdatePluginsPersistence extends BasePersistence<UpdatePlugins> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UpdatePluginsUtil} to access the update plugins persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the update plugins in the entity cache if it is enabled.
	*
	* @param updatePlugins the update plugins
	*/
	public void cacheResult(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins);

	/**
	* Caches the update pluginses in the entity cache if it is enabled.
	*
	* @param updatePluginses the update pluginses
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> updatePluginses);

	/**
	* Creates a new update plugins with the primary key. Does not add the update plugins to the database.
	*
	* @param pluginId the primary key for the new update plugins
	* @return the new update plugins
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins create(
		long pluginId);

	/**
	* Removes the update plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins that was removed
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins remove(
		long pluginId)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updateImpl(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins with the primary key or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPrimaryKey(
		long pluginId)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins, or <code>null</code> if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPrimaryKey(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins where pluginCode = &#63; or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @return the matching update plugins
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCode(
		java.lang.String pluginCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the matching update plugins
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the update pluginses.
	*
	* @return the update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the update pluginses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update pluginses
	* @param end the upper bound of the range of update pluginses (not inclusive)
	* @return the range of update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the update pluginses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update pluginses
	* @param end the upper bound of the range of update pluginses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the update plugins where pluginCode = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @return the update plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins removeByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the update plugins where pluginCode = &#63; and currentVersion = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the update plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.autoupdate.model.UpdatePlugins removeByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the update pluginses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of update pluginses where pluginCode = &#63;.
	*
	* @param pluginCode the plugin code
	* @return the number of matching update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPluginCode(java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of update pluginses where pluginCode = &#63; and currentVersion = &#63;.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the number of matching update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countByPluginCodeAndVersion(java.lang.String pluginCode,
		double currentVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of update pluginses.
	*
	* @return the number of update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}