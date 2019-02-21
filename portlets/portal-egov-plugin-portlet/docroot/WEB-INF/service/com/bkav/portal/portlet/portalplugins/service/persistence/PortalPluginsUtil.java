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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the portal plugins service. This utility wraps {@link PortalPluginsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see PortalPluginsPersistence
 * @see PortalPluginsPersistenceImpl
 * @generated
 */
public class PortalPluginsUtil {
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
	public static void clearCache(PortalPlugins portalPlugins) {
		getPersistence().clearCache(portalPlugins);
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
	public static List<PortalPlugins> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortalPlugins> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortalPlugins> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PortalPlugins update(PortalPlugins portalPlugins,
		boolean merge) throws SystemException {
		return getPersistence().update(portalPlugins, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PortalPlugins update(PortalPlugins portalPlugins,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portalPlugins, merge, serviceContext);
	}

	/**
	* Caches the portal plugins in the entity cache if it is enabled.
	*
	* @param portalPlugins the portal plugins
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins) {
		getPersistence().cacheResult(portalPlugins);
	}

	/**
	* Caches the portal pluginses in the entity cache if it is enabled.
	*
	* @param portalPluginses the portal pluginses
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> portalPluginses) {
		getPersistence().cacheResult(portalPluginses);
	}

	/**
	* Creates a new portal plugins with the primary key. Does not add the portal plugins to the database.
	*
	* @param pluginId the primary key for the new portal plugins
	* @return the new portal plugins
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins create(
		long pluginId) {
		return getPersistence().create(pluginId);
	}

	/**
	* Removes the portal plugins with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins that was removed
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins remove(
		long pluginId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(pluginId);
	}

	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins updateImpl(
		com.bkav.portal.portlet.portalplugins.model.PortalPlugins portalPlugins,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portalPlugins, merge);
	}

	/**
	* Returns the portal plugins with the primary key or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPrimaryKey(
		long pluginId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(pluginId);
	}

	/**
	* Returns the portal plugins with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pluginId the primary key of the portal plugins
	* @return the portal plugins, or <code>null</code> if a portal plugins with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByPrimaryKey(
		long pluginId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(pluginId);
	}

	/**
	* Returns all the portal pluginses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last portal plugins in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] findByGroupId_PrevAndNext(
		long pluginId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(pluginId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the portal pluginses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching portal pluginses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] filterFindByGroupId_PrevAndNext(
		long pluginId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(pluginId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the portal pluginses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last portal plugins in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] findByCompanyId_PrevAndNext(
		long pluginId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(pluginId, companyId,
			orderByComparator);
	}

	/**
	* Returns the portal plugins where pluginCode = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException} if it could not be found.
	*
	* @param pluginCode the plugin code
	* @return the matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPluginCode(pluginCode);
	}

	/**
	* Returns the portal plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByPluginCode(
		java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPluginCode(pluginCode);
	}

	/**
	* Returns the portal plugins where pluginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pluginCode the plugin code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByPluginCode(
		java.lang.String pluginCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPluginCode(pluginCode, retrieveFromCache);
	}

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
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCodeAndVersion(pluginCode, pluginVersion, groupId);
	}

	/**
	* Returns the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCodeAndVersion(pluginCode, pluginVersion, groupId);
	}

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
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCodeAndVersion(pluginCode, pluginVersion, groupId,
			retrieveFromCache);
	}

	/**
	* Returns all the portal pluginses where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @return the matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByePortalId(
		long ePortalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByePortalId(ePortalId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByePortalId(
		long ePortalId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByePortalId(ePortalId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByePortalId(
		long ePortalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByePortalId(ePortalId, start, end, orderByComparator);
	}

	/**
	* Returns the first portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByePortalId_First(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByePortalId_First(ePortalId, orderByComparator);
	}

	/**
	* Returns the first portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByePortalId_First(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByePortalId_First(ePortalId, orderByComparator);
	}

	/**
	* Returns the last portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins findByePortalId_Last(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByePortalId_Last(ePortalId, orderByComparator);
	}

	/**
	* Returns the last portal plugins in the ordered set where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portal plugins, or <code>null</code> if a matching portal plugins could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins fetchByePortalId_Last(
		long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByePortalId_Last(ePortalId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins[] findByePortalId_PrevAndNext(
		long pluginId, long ePortalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByePortalId_PrevAndNext(pluginId, ePortalId,
			orderByComparator);
	}

	/**
	* Returns all the portal pluginses.
	*
	* @return the portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portal pluginses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the portal pluginses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes the portal plugins where pluginCode = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @return the portal plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins removeByPluginCode(
		java.lang.String pluginCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPluginCode(pluginCode);
	}

	/**
	* Removes the portal plugins where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63; from the database.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the portal plugins that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.PortalPlugins removeByCodeAndVersion(
		java.lang.String pluginCode, double pluginVersion, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchPortalPluginsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByCodeAndVersion(pluginCode, pluginVersion, groupId);
	}

	/**
	* Removes all the portal pluginses where ePortalId = &#63; from the database.
	*
	* @param ePortalId the e portal ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByePortalId(long ePortalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByePortalId(ePortalId);
	}

	/**
	* Removes all the portal pluginses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of portal pluginses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of portal pluginses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching portal pluginses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of portal pluginses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of portal pluginses where pluginCode = &#63;.
	*
	* @param pluginCode the plugin code
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPluginCode(java.lang.String pluginCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPluginCode(pluginCode);
	}

	/**
	* Returns the number of portal pluginses where pluginCode = &#63; and pluginVersion = &#63; and groupId = &#63;.
	*
	* @param pluginCode the plugin code
	* @param pluginVersion the plugin version
	* @param groupId the group ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCodeAndVersion(java.lang.String pluginCode,
		double pluginVersion, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCodeAndVersion(pluginCode, pluginVersion, groupId);
	}

	/**
	* Returns the number of portal pluginses where ePortalId = &#63;.
	*
	* @param ePortalId the e portal ID
	* @return the number of matching portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByePortalId(long ePortalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByePortalId(ePortalId);
	}

	/**
	* Returns the number of portal pluginses.
	*
	* @return the number of portal pluginses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortalPluginsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortalPluginsPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.portalplugins.service.ClpSerializer.getServletContextName(),
					PortalPluginsPersistence.class.getName());

			ReferenceRegistry.registerReference(PortalPluginsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PortalPluginsPersistence persistence) {
	}

	private static PortalPluginsPersistence _persistence;
}