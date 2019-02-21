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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dynamic menu service. This utility wraps {@link DynamicMenuPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hungdx
 * @see DynamicMenuPersistence
 * @see DynamicMenuPersistenceImpl
 * @generated
 */
public class DynamicMenuUtil {
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
	public static void clearCache(DynamicMenu dynamicMenu) {
		getPersistence().clearCache(dynamicMenu);
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
	public static List<DynamicMenu> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DynamicMenu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DynamicMenu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DynamicMenu update(DynamicMenu dynamicMenu, boolean merge)
		throws SystemException {
		return getPersistence().update(dynamicMenu, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DynamicMenu update(DynamicMenu dynamicMenu, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dynamicMenu, merge, serviceContext);
	}

	/**
	* Caches the dynamic menu in the entity cache if it is enabled.
	*
	* @param dynamicMenu the dynamic menu
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu) {
		getPersistence().cacheResult(dynamicMenu);
	}

	/**
	* Caches the dynamic menus in the entity cache if it is enabled.
	*
	* @param dynamicMenus the dynamic menus
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> dynamicMenus) {
		getPersistence().cacheResult(dynamicMenus);
	}

	/**
	* Creates a new dynamic menu with the primary key. Does not add the dynamic menu to the database.
	*
	* @param menuId the primary key for the new dynamic menu
	* @return the new dynamic menu
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu create(
		long menuId) {
		return getPersistence().create(menuId);
	}

	/**
	* Removes the dynamic menu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu that was removed
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu remove(
		long menuId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(menuId);
	}

	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu updateImpl(
		com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu dynamicMenu,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dynamicMenu, merge);
	}

	/**
	* Returns the dynamic menu with the primary key or throws a {@link com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException} if it could not be found.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu findByPrimaryKey(
		long menuId)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(menuId);
	}

	/**
	* Returns the dynamic menu with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param menuId the primary key of the dynamic menu
	* @return the dynamic menu, or <code>null</code> if a dynamic menu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchByPrimaryKey(
		long menuId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(menuId);
	}

	/**
	* Returns all the dynamic menus where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic menu, or <code>null</code> if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu
	* @throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last dynamic menu in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic menu, or <code>null</code> if a matching dynamic menu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu[] findByGroup_PrevAndNext(
		long menuId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(menuId, groupId, orderByComparator);
	}

	/**
	* Returns all the dynamic menus that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching dynamic menus that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu[] filterFindByGroup_PrevAndNext(
		long menuId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.dynamic_menu.NoSuchDynamicMenuException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(menuId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the dynamic menus.
	*
	* @return the dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dynamic menus where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the dynamic menus from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dynamic menus where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of dynamic menus that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching dynamic menus that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of dynamic menus.
	*
	* @return the number of dynamic menus
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DynamicMenuPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DynamicMenuPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.dynamic_menu.service.ClpSerializer.getServletContextName(),
					DynamicMenuPersistence.class.getName());

			ReferenceRegistry.registerReference(DynamicMenuUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DynamicMenuPersistence persistence) {
	}

	private static DynamicMenuPersistence _persistence;
}