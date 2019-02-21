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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dynamic menu item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuItemPersistenceImpl
 * @see DynamicMenuItemUtil
 * @generated
 */
public interface DynamicMenuItemPersistence extends BasePersistence<DynamicMenuItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DynamicMenuItemUtil} to access the dynamic menu item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the dynamic menu item in the entity cache if it is enabled.
	*
	* @param dynamicMenuItem the dynamic menu item
	*/
	public void cacheResult(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem);

	/**
	* Caches the dynamic menu items in the entity cache if it is enabled.
	*
	* @param dynamicMenuItems the dynamic menu items
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> dynamicMenuItems);

	/**
	* Creates a new dynamic menu item with the primary key. Does not add the dynamic menu item to the database.
	*
	* @param itemId the primary key for the new dynamic menu item
	* @return the new dynamic menu item
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem create(
		long itemId);

	/**
	* Removes the dynamic menu item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item that was removed
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem remove(
		long itemId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem updateImpl(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem dynamicMenuItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dynamic menu item with the primary key or throws a {@link com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException} if it could not be found.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByPrimaryKey(
		long itemId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dynamic menu item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the dynamic menu item
	* @return the dynamic menu item, or <code>null</code> if a dynamic menu item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByGroup_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByGroup_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByMenu(
		long groupId, long menuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByMenu_First(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByMenu_First(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByMenu_Last(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByMenu_Last(
		long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByMenu_PrevAndNext(
		long itemId, long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByMenu(
		long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByMenu(
		long groupId, long menuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByMenu(
		long groupId, long menuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByMenu_PrevAndNext(
		long itemId, long groupId, long menuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByParent(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByParent_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByParent_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByParent_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dynamic menu item in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu item, or <code>null</code> if a matching dynamic menu item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByParent_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByParent_PrevAndNext(
		long itemId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByParent(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByParent(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByParent(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByParent_PrevAndNext(
		long itemId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findByG_M_P(
		long groupId, long menuId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByG_M_P_First(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByG_M_P_First(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem findByG_M_P_Last(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem fetchByG_M_P_Last(
		long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] findByG_M_P_PrevAndNext(
		long itemId, long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByG_M_P(
		long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByG_M_P(
		long groupId, long menuId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> filterFindByG_M_P(
		long groupId, long menuId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem[] filterFindByG_M_P_PrevAndNext(
		long itemId, long groupId, long menuId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menu items.
	*
	* @return the dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menu items where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menu items where groupId = &#63; and menuId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMenu(long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menu items where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_M_P(long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menu items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public int countByMenu(long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByMenu(long groupId, long menuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public int countByParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParent(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_M_P(long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items that the user has permission to view where groupId = &#63; and menuId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param menuId the menu ID
	* @param parentId the parent ID
	* @return the number of matching dynamic menu items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_M_P(long groupId, long menuId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menu items.
	*
	* @return the number of dynamic menu items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}