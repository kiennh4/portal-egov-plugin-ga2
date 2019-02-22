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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the update plugins service. This utility wraps {@link UpdatePluginsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anhbdb
 * @see UpdatePluginsPersistence
 * @see UpdatePluginsPersistenceImpl
 * @generated
 */
public class UpdatePluginsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UpdatePlugins updatePlugins) {
		getPersistence().clearCache(updatePlugins);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UpdatePlugins> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpdatePlugins> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpdatePlugins> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UpdatePlugins update(UpdatePlugins updatePlugins,
		boolean merge) throws SystemException {
		return getPersistence().update(updatePlugins, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UpdatePlugins update(UpdatePlugins updatePlugins,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(updatePlugins, merge, serviceContext);
	}

	/**
	* Caches the update plugins in the entity cache if it is enabled.
	*
	* @param updatePlugins the update plugins
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins) {
		getPersistence().cacheResult(updatePlugins);
	}

	/**
	* Caches the update pluginses in the entity cache if it is enabled.
	*
	* @param updatePluginses the update pluginses
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> updatePluginses) {
		getPersistence().cacheResult(updatePluginses);
	}

	/**
	* Creates a new update plugins with the primary key. Does not add the update plugins to the database.
	*
	* @param pluginId the primary key for the new update plugins
	* @return the new update plugins
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins create(
		long pluginId) {
		return getPersistence().create(pluginId);
	}

	/**
	* Removes the update plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins that was removed
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins remove(
		long pluginId)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(pluginId);
	}

	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updateImpl(
		com.bkav.portal.portlet.autoupdate.model.UpdatePlugins updatePlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(updatePlugins, merge);
	}

	/**
	* Returns the update plugins with the primary key or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPrimaryKey(
		long pluginId)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(pluginId);
	}

	/**
	* Returns the update plugins with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pluginId the primary key of the update plugins
	* @return the update plugins, or <code>null</code> if a update plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPrimaryKey(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(pluginId);
	}

	/**
	* Returns the update plugins where pluginCode = &#63; or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @return the matching update plugins
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPluginCode(pluginCode);
	}

	/**
	* Returns the update plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPluginCode(pluginCode);
	}

	/**
	* Returns the update plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCode(
		java.lang.String pluginCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPluginCode(pluginCode, retrieveFromCache);
	}

	/**
	* Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or throws a {@link com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the matching update plugins
	* @throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins findByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPluginCodeAndVersion(pluginCode, currentVersion);
	}

	/**
	* Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPluginCodeAndVersion(pluginCode, currentVersion);
	}

	/**
	* Returns the update plugins where pluginCode = &#63; and currentVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching update plugins, or <code>null</code> if a matching update plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins fetchByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPluginCodeAndVersion(pluginCode, currentVersion,
			retrieveFromCache);
	}

	/**
	* Returns all the update pluginses.
	*
	* @return the update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.autoupdate.model.UpdatePlugins> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the update plugins where pluginCode = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @return the update plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins removeByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPluginCode(pluginCode);
	}

	/**
	* Removes the update plugins where pluginCode = &#63; and currentVersion = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the update plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.autoupdate.model.UpdatePlugins removeByPluginCodeAndVersion(
		java.lang.String pluginCode, double currentVersion)
		throws com.bkav.portal.portlet.autoupdate.NoSuchUpdatePluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByPluginCodeAndVersion(pluginCode, currentVersion);
	}

	/**
	* Removes all the update pluginses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of update pluginses where pluginCode = &#63;.
	*
	* @param pluginCode the plugin code
	* @return the number of matching update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPluginCode(java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPluginCode(pluginCode);
	}

	/**
	* Returns the number of update pluginses where pluginCode = &#63; and currentVersion = &#63;.
	*
	* @param pluginCode the plugin code
	* @param currentVersion the current version
	* @return the number of matching update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPluginCodeAndVersion(java.lang.String pluginCode,
		double currentVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPluginCodeAndVersion(pluginCode, currentVersion);
	}

	/**
	* Returns the number of update pluginses.
	*
	* @return the number of update pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UpdatePluginsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UpdatePluginsPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.autoupdate.service.ClpSerializer.getServletContextName(),
					UpdatePluginsPersistence.class.getName());

			ReferenceRegistry.registerReference(UpdatePluginsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UpdatePluginsPersistence persistence) {
	}

	private static UpdatePluginsPersistence _persistence;
}