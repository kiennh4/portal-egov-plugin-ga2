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

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dynamic menu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuPersistenceImpl
 * @see DynamicMenuUtil
 * @generated
 */
public interface DynamicMenuPersistence extends BasePersistence<DynamicMenu> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DynamicMenuUtil} to access the dynamic menu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the dynamic menu in the entity cache if it is enabled.
	*
	* @param dynamicMenu the dynamic menu
	*/
	public void cacheResult(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu);

	/**
	* Caches the dynamic menus in the entity cache if it is enabled.
	*
	* @param dynamicMenus the dynamic menus
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> dynamicMenus);

	/**
	* Creates a new dynamic menu with the primary key. Does not add the dynamic menu to the database.
	*
	* @param menuId the primary key for the new dynamic menu
	* @return the new dynamic menu
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu create(
		long menuId);

	/**
	* Removes the dynamic menu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu that was removed
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu remove(
		long menuId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu updateImpl(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dynamic menu with the primary key or throws a {@link com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException} if it could not be found.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu findByPrimaryKey(
		long menuId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dynamic menu with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu, or <code>null</code> if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchByPrimaryKey(
		long menuId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menus where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dynamic menus where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @return the range of matching dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dynamic menus where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu, or <code>null</code> if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu, or <code>null</code> if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dynamic menus before and after the current dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param menuId the primary key of the current dynamic menu
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu[] findByGroup_PrevAndNext(
		long menuId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menus that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menus that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dynamic menus that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @return the range of matching dynamic menus that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dynamic menus that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic menus that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dynamic menus before and after the current dynamic menu in the ordered set of dynamic menus that the user has permission to view where groupId = &#63;.
	*
	* @param menuId the primary key of the current dynamic menu
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu[] filterFindByGroup_PrevAndNext(
		long menuId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dynamic menus.
	*
	* @return the dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dynamic menus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @return the range of dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dynamic menus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dynamic menus
	* @param end the upper bound of the range of dynamic menus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menus where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dynamic menus from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menus where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menus that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menus that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dynamic menus.
	*
	* @return the number of dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}