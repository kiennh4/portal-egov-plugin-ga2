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

import com.bkav.portal.portlet.portalplugins.model.ePortals;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e portals service. This utility wraps {@link ePortalsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see ePortalsPersistence
 * @see ePortalsPersistenceImpl
 * @generated
 */
public class ePortalsUtil {
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
	public static void clearCache(ePortals ePortals) {
		getPersistence().clearCache(ePortals);
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
	public static List<ePortals> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ePortals> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ePortals> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ePortals update(ePortals ePortals, boolean merge)
		throws SystemException {
		return getPersistence().update(ePortals, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ePortals update(ePortals ePortals, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ePortals, merge, serviceContext);
	}

	/**
	* Caches the e portals in the entity cache if it is enabled.
	*
	* @param ePortals the e portals
	*/
	public static void cacheResult(
		com.bkav.portal.portlet.portalplugins.model.ePortals ePortals) {
		getPersistence().cacheResult(ePortals);
	}

	/**
	* Caches the e portalses in the entity cache if it is enabled.
	*
	* @param ePortalses the e portalses
	*/
	public static void cacheResult(
		java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> ePortalses) {
		getPersistence().cacheResult(ePortalses);
	}

	/**
	* Creates a new e portals with the primary key. Does not add the e portals to the database.
	*
	* @param eportalId the primary key for the new e portals
	* @return the new e portals
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals create(
		long eportalId) {
		return getPersistence().create(eportalId);
	}

	/**
	* Removes the e portals with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eportalId the primary key of the e portals
	* @return the e portals that was removed
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals remove(
		long eportalId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eportalId);
	}

	public static com.bkav.portal.portlet.portalplugins.model.ePortals updateImpl(
		com.bkav.portal.portlet.portalplugins.model.ePortals ePortals,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ePortals, merge);
	}

	/**
	* Returns the e portals with the primary key or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	*
	* @param eportalId the primary key of the e portals
	* @return the e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByPrimaryKey(
		long eportalId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eportalId);
	}

	/**
	* Returns the e portals with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eportalId the primary key of the e portals
	* @return the e portals, or <code>null</code> if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByPrimaryKey(
		long eportalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eportalId);
	}

	/**
	* Returns all the e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the e portalses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @return the range of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e portalses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e portalses before and after the current e portals in the ordered set where groupId = &#63;.
	*
	* @param eportalId the primary key of the current e portals
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals[] findByGroupId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(eportalId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the e portalses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @return the range of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e portalses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the e portalses before and after the current e portals in the ordered set of e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param eportalId the primary key of the current e portals
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals[] filterFindByGroupId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(eportalId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByCompanyId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(groupId);
	}

	/**
	* Returns a range of all the e portalses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @return the range of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByCompanyId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e portalses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByCompanyId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByCompanyId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByCompanyId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByCompanyId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByCompanyId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompanyId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the e portalses before and after the current e portals in the ordered set where groupId = &#63;.
	*
	* @param eportalId the primary key of the current e portals
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals[] findByCompanyId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(eportalId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByCompanyId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(groupId);
	}

	/**
	* Returns a range of all the e portalses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @return the range of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByCompanyId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the e portalses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByCompanyId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the e portalses before and after the current e portals in the ordered set of e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param eportalId the primary key of the current e portals
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals[] filterFindByCompanyId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId_PrevAndNext(eportalId, groupId,
			orderByComparator);
	}

	/**
	* Returns the e portals where eportalCode = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	*
	* @param eportalCode the eportal code
	* @return the matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByePortalCode(
		java.lang.String eportalCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByePortalCode(eportalCode);
	}

	/**
	* Returns the e portals where eportalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eportalCode the eportal code
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalCode(
		java.lang.String eportalCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByePortalCode(eportalCode);
	}

	/**
	* Returns the e portals where eportalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eportalCode the eportal code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalCode(
		java.lang.String eportalCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByePortalCode(eportalCode, retrieveFromCache);
	}

	/**
	* Returns the e portals where eportalDomain = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals findByePortalDomain(
		java.lang.String eportalDomain, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByePortalDomain(eportalDomain, groupId);
	}

	/**
	* Returns the e portals where eportalDomain = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalDomain(
		java.lang.String eportalDomain, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByePortalDomain(eportalDomain, groupId);
	}

	/**
	* Returns the e portals where eportalDomain = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalDomain(
		java.lang.String eportalDomain, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByePortalDomain(eportalDomain, groupId,
			retrieveFromCache);
	}

	/**
	* Returns all the e portalses.
	*
	* @return the e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e portalses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @return the range of e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e portalses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of e portalses
	* @param end the upper bound of the range of e portalses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e portalses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the e portalses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(groupId);
	}

	/**
	* Removes the e portals where eportalCode = &#63; from the database.
	*
	* @param eportalCode the eportal code
	* @return the e portals that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals removeByePortalCode(
		java.lang.String eportalCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByePortalCode(eportalCode);
	}

	/**
	* Removes the e portals where eportalDomain = &#63; and groupId = &#63; from the database.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the e portals that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bkav.portal.portlet.portalplugins.model.ePortals removeByePortalDomain(
		java.lang.String eportalDomain, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByePortalDomain(eportalDomain, groupId);
	}

	/**
	* Removes all the e portalses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(groupId);
	}

	/**
	* Returns the number of e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCompanyId(groupId);
	}

	/**
	* Returns the number of e portalses where eportalCode = &#63;.
	*
	* @param eportalCode the eportal code
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByePortalCode(java.lang.String eportalCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByePortalCode(eportalCode);
	}

	/**
	* Returns the number of e portalses where eportalDomain = &#63; and groupId = &#63;.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByePortalDomain(java.lang.String eportalDomain,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByePortalDomain(eportalDomain, groupId);
	}

	/**
	* Returns the number of e portalses.
	*
	* @return the number of e portalses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ePortalsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ePortalsPersistence)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.portalplugins.service.ClpSerializer.getServletContextName(),
					ePortalsPersistence.class.getName());

			ReferenceRegistry.registerReference(ePortalsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ePortalsPersistence persistence) {
	}

	private static ePortalsPersistence _persistence;
}