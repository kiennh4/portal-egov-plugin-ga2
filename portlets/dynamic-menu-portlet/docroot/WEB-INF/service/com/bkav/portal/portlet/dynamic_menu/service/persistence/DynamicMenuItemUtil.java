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

package com.bkav.portal.portlet.dynamic_menu.service.persistence;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dynamic menu item service. This utility wraps {@link DynamicMenuItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuItemPersistence
 * @see DynamicMenuItemPersistenceImpl
 * @generated
 */
public class DynamicMenuItemUtil {
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
	public static void clearCache(DynamicMenuItem dynamicMenuItem) {
		getPersistence().clearCache(dynamicMenuItem);
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
	public static List<DynamicMenuItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DynamicMenuItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DynamicMenuItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DynamicMenuItem update(DynamicMenuItem dynamicMenuItem,
		boolean merge) throws SystemException {
		return getPersistence().update(dynamicMenuItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DynamicMenuItem update(DynamicMenuItem dynamicMenuItem,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dynamicMenuItem, merge, serviceContext);
	}

	/**
	* Caches the dynamic menu item in the entity cache if it is enabled.
	*
	* @param dynamicMenuItem the dynamic menu item
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem) {
		getPersistence().cacheResult(dynamicMenuItem);
	}

	/**
	* Caches the dynamic menu items in the entity cache if it is enabled.
	*
	* @param dynamicMenuItems the dynamic menu items
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> dynamicMenuItems) {
		getPersistence().cacheResult(dynamicMenuItems);
	}

	/**
	* Creates a new dynamic menu item with the primary key. Does not add the dynamic menu item to the database.
	*
	* @param itemId the primary key for the new dynamic menu item
	* @return the new dynamic menu item
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem create(
		long itemId) {
		return getPersistence().create(itemId);
	}

	/**
	* Removes the dynamic menu item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item that was removed
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem remove(
		long itemId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemId);
	}

	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateImpl(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dynamicMenuItem, merge);
	}

	/**
	* Returns the dynamic menu item with the primary key or throws a {@link com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException} if it could not be found.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByPrimaryKey(
		long itemId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemId);
	}

	/**
	* Returns the dynamic menu item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item, or <code>null</code> if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemId);
	}

	/**
	* Returns all the dynamic menu items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the dynamic menu items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByGroup_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(itemId, groupId, orderByComparator);
	}

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByGroup_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(itemId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMenu(groupId, menuId);
	}

	/**
	* Returns a range of all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMenu(groupId, menuId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMenu(groupId, menuId, start, end, orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByMenu_First(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMenu_First(groupId, menuId, orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByMenu_First(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMenu_First(groupId, menuId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByMenu_Last(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMenu_Last(groupId, menuId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByMenu_Last(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMenu_Last(groupId, menuId, orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByMenu_PrevAndNext(
		long itemId, long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMenu_PrevAndNext(itemId, groupId, menuId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByMenu(
		long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByMenu(groupId, menuId);
	}

	/**
	* Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByMenu(
		long groupId, long menuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByMenu(groupId, menuId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63; and menuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByMenu(
		long groupId, long menuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByMenu(groupId, menuId, start, end,
			orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByMenu_PrevAndNext(
		long itemId, long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByMenu_PrevAndNext(itemId, groupId, menuId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(groupId, parentId);
	}

	/**
	* Returns a range of all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParent(groupId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent(groupId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByParent_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent_First(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByParent_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParent_First(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByParent_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent_Last(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByParent_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParent_Last(groupId, parentId, orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByParent_PrevAndNext(
		long itemId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParent_PrevAndNext(itemId, groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByParent(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByParent(groupId, parentId);
	}

	/**
	* Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByParent(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByParent(groupId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByParent(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParent(groupId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByParent_PrevAndNext(
		long itemId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParent_PrevAndNext(itemId, groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_M_P(groupId, menuId, parentId);
	}

	/**
	* Returns a range of all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_M_P(groupId, menuId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_M_P(groupId, menuId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByG_M_P_First(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_M_P_First(groupId, menuId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByG_M_P_First(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_M_P_First(groupId, menuId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByG_M_P_Last(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_M_P_Last(groupId, menuId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByG_M_P_Last(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_M_P_Last(groupId, menuId, parentId,
			orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByG_M_P_PrevAndNext(
		long itemId, long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_M_P_PrevAndNext(itemId, groupId, menuId, parentId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByG_M_P(
		long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_M_P(groupId, menuId, parentId);
	}

	/**
	* Returns a range of all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByG_M_P(
		long groupId, long menuId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_M_P(groupId, menuId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items that the user has permissions to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByG_M_P(
		long groupId, long menuId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_M_P(groupId, menuId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the dynamic menu items before and after the current dynamic menu item in the ordered set of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param itemId the primary key of the current dynamic menu item
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByG_M_P_PrevAndNext(
		long itemId, long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_M_P_PrevAndNext(itemId, groupId, menuId,
			parentId, orderByComparator);
	}

	/**
	* Returns all the dynamic menu items.
	*
	* @return the dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dynamic menu items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @return the range of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dynamic menu items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dynamic menu items
	* @param end the upper bound of the range of dynamic menu items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dynamic menu items where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the dynamic menu items where groupId = &#63; and menuId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMenu(long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMenu(groupId, menuId);
	}

	/**
	* Removes all the dynamic menu items where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParent(groupId, parentId);
	}

	/**
	* Removes all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_M_P(long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_M_P(groupId, menuId, parentId);
	}

	/**
	* Removes all the dynamic menu items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dynamic menu items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of dynamic menu items where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMenu(long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMenu(groupId, menuId);
	}

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByMenu(long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByMenu(groupId, menuId);
	}

	/**
	* Returns the number of dynamic menu items where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParent(groupId, parentId);
	}

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByParent(groupId, parentId);
	}

	/**
	* Returns the number of dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_M_P(long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_M_P(groupId, menuId, parentId);
	}

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_M_P(long groupId, long menuId,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_M_P(groupId, menuId, parentId);
	}

	/**
	* Returns the number of dynamic menu items.
	*
	* @return the number of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DynamicMenuItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DynamicMenuItemPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.dynamic_menu.service.ClpSerializer.getServletContextName(),
					DynamicMenuItemPersistence.class.getName());

			ReferenceRegistry.registerReference(DynamicMenuItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DynamicMenuItemPersistence persistence) {
	}

	private static DynamicMenuItemPersistence _persistence;
}