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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e portals service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see ePortalsPersistenceImpl
 * @see ePortalsUtil
 * @generated
 */
public interface ePortalsPersistence extends BasePersistence<ePortals> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ePortalsUtil} to access the e portals persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e portals in the entity cache if it is enabled.
	*
	* @param ePortals the e portals
	*/
	public void cacheResult(
		com.bkav.portal.portlet.portalplugins.model.ePortals ePortals);

	/**
	* Caches the e portalses in the entity cache if it is enabled.
	*
	* @param ePortalses the e portalses
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> ePortalses);

	/**
	* Creates a new e portals with the primary key. Does not add the e portals to the database.
	*
	* @param eportalId the primary key for the new e portals
	* @return the new e portals
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals create(
		long eportalId);

	/**
	* Removes the e portals with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eportalId the primary key of the e portals
	* @return the e portals that was removed
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals remove(
		long eportalId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.portalplugins.model.ePortals updateImpl(
		com.bkav.portal.portlet.portalplugins.model.ePortals ePortals,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals with the primary key or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	*
	* @param eportalId the primary key of the e portals
	* @return the e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByPrimaryKey(
		long eportalId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eportalId the primary key of the e portals
	* @return the e portals, or <code>null</code> if a e portals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByPrimaryKey(
		long eportalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.portalplugins.model.ePortals[] findByGroupId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.portalplugins.model.ePortals[] filterFindByGroupId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByCompanyId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByCompanyId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findByCompanyId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByCompanyId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByCompanyId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByCompanyId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e portals in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByCompanyId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.portalplugins.model.ePortals[] findByCompanyId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByCompanyId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByCompanyId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> filterFindByCompanyId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.bkav.portal.portlet.portalplugins.model.ePortals[] filterFindByCompanyId_PrevAndNext(
		long eportalId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals where eportalCode = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	*
	* @param eportalCode the eportal code
	* @return the matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByePortalCode(
		java.lang.String eportalCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals where eportalCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eportalCode the eportal code
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalCode(
		java.lang.String eportalCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals where eportalCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eportalCode the eportal code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalCode(
		java.lang.String eportalCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals where eportalDomain = &#63; and groupId = &#63; or throws a {@link com.bkav.portal.portlet.portalplugins.NoSuchePortalsException} if it could not be found.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the matching e portals
	* @throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals findByePortalDomain(
		java.lang.String eportalDomain, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals where eportalDomain = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalDomain(
		java.lang.String eportalDomain, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e portals where eportalDomain = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching e portals, or <code>null</code> if a matching e portals could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals fetchByePortalDomain(
		java.lang.String eportalDomain, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e portalses.
	*
	* @return the e portalses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.bkav.portal.portlet.portalplugins.model.ePortals> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e portalses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e portalses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e portals where eportalCode = &#63; from the database.
	*
	* @param eportalCode the eportal code
	* @return the e portals that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals removeByePortalCode(
		java.lang.String eportalCode)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the e portals where eportalDomain = &#63; and groupId = &#63; from the database.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the e portals that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.portalplugins.model.ePortals removeByePortalDomain(
		java.lang.String eportalDomain, long groupId)
		throws com.bkav.portal.portlet.portalplugins.NoSuchePortalsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e portalses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching e portalses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses where eportalCode = &#63;.
	*
	* @param eportalCode the eportal code
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public int countByePortalCode(java.lang.String eportalCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses where eportalDomain = &#63; and groupId = &#63;.
	*
	* @param eportalDomain the eportal domain
	* @param groupId the group ID
	* @return the number of matching e portalses
	* @throws SystemException if a system exception occurred
	*/
	public int countByePortalDomain(java.lang.String eportalDomain, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e portalses.
	*
	* @return the number of e portalses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}