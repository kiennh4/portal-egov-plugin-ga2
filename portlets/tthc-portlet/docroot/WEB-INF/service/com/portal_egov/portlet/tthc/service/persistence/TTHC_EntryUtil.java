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

package com.portal_egov.portlet.tthc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.tthc.model.TTHC_Entry;

import java.util.List;

/**
 * The persistence utility for the t t h c_ entry service. This utility wraps {@link TTHC_EntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_EntryPersistence
 * @see TTHC_EntryPersistenceImpl
 * @generated
 */
public class TTHC_EntryUtil {
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
	public static void clearCache(TTHC_Entry tthc_Entry) {
		getPersistence().clearCache(tthc_Entry);
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
	public static List<TTHC_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTHC_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTHC_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TTHC_Entry update(TTHC_Entry tthc_Entry, boolean merge)
		throws SystemException {
		return getPersistence().update(tthc_Entry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TTHC_Entry update(TTHC_Entry tthc_Entry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tthc_Entry, merge, serviceContext);
	}

	/**
	* Caches the t t h c_ entry in the entity cache if it is enabled.
	*
	* @param tthc_Entry the t t h c_ entry
	*/
	public static void cacheResult(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry) {
		getPersistence().cacheResult(tthc_Entry);
	}

	/**
	* Caches the t t h c_ entries in the entity cache if it is enabled.
	*
	* @param tthc_Entries the t t h c_ entries
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> tthc_Entries) {
		getPersistence().cacheResult(tthc_Entries);
	}

	/**
	* Creates a new t t h c_ entry with the primary key. Does not add the t t h c_ entry to the database.
	*
	* @param entryId the primary key for the new t t h c_ entry
	* @return the new t t h c_ entry
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the t t h c_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry that was removed
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence().remove(entryId);
	}

	public static com.portal_egov.portlet.tthc.model.TTHC_Entry updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tthc_Entry, merge);
	}

	/**
	* Returns the t t h c_ entry with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException} if it could not be found.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the t t h c_ entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry, or <code>null</code> if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the t t h c_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the t t h c_ entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(entryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(entryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndCompany(levelId, companyId);
	}

	/**
	* Returns a range of all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndCompany(levelId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndCompany(levelId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndCompany_First(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByLevelAndCompany_First(levelId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndCompany_First(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndCompany_First(levelId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndCompany_Last(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByLevelAndCompany_Last(levelId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndCompany_Last(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndCompany_Last(levelId, companyId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByLevelAndCompany_PrevAndNext(
		long entryId, long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByLevelAndCompany_PrevAndNext(entryId, levelId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndGroup(levelId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndGroup(levelId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndGroup(levelId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndGroup_First(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByLevelAndGroup_First(levelId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndGroup_First(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndGroup_First(levelId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndGroup_Last(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByLevelAndGroup_Last(levelId, groupId, orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndGroup_Last(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndGroup_Last(levelId, groupId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByLevelAndGroup_PrevAndNext(
		long entryId, long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByLevelAndGroup_PrevAndNext(entryId, levelId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByLevelAndGroup(
		long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByLevelAndGroup(levelId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByLevelAndGroup(
		long levelId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByLevelAndGroup(levelId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries that the user has permissions to view where levelId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByLevelAndGroup(
		long levelId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByLevelAndGroup(levelId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByLevelAndGroup_PrevAndNext(
		long entryId, long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .filterFindByLevelAndGroup_PrevAndNext(entryId, levelId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(departmentId, companyId);
	}

	/**
	* Returns a range of all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(departmentId, companyId, start,
			end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(departmentId, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByDepartmentAndCompany_First(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndCompany_First(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByDepartmentAndCompany_Last(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndCompany_Last(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByDepartmentAndCompany_PrevAndNext(
		long entryId, long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByDepartmentAndCompany_PrevAndNext(entryId,
			departmentId, companyId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndGroup(departmentId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndGroup(departmentId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByDepartmentAndGroup_First(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndGroup_First(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByDepartmentAndGroup_Last(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndGroup_Last(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByDepartmentAndGroup_PrevAndNext(entryId, departmentId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(departmentId, groupId,
			start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries that the user has permissions to view where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(departmentId, groupId,
			start, end, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup_PrevAndNext(entryId,
			departmentId, groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Returns a range of all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(categoryId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(categoryId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCategoryAndCompany_First(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_First(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCategoryAndCompany_Last(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_Last(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByCategoryAndCompany_PrevAndNext(
		long entryId, long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCategoryAndCompany_PrevAndNext(entryId, categoryId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCategoryAndGroup_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCategoryAndGroup_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByCategoryAndGroup_PrevAndNext(entryId, categoryId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(categoryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(categoryId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .filterFindByCategoryAndGroup_PrevAndNext(entryId,
			categoryId, groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudienceAndCompany(audienceId, companyId);
	}

	/**
	* Returns a range of all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudienceAndCompany(audienceId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudienceAndCompany(audienceId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndCompany_First(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByAudienceAndCompany_First(audienceId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndCompany_First(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAudienceAndCompany_First(audienceId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndCompany_Last(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByAudienceAndCompany_Last(audienceId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndCompany_Last(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAudienceAndCompany_Last(audienceId, companyId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByAudienceAndCompany_PrevAndNext(
		long entryId, long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByAudienceAndCompany_PrevAndNext(entryId, audienceId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAudienceAndGroup(audienceId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudienceAndGroup(audienceId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAudienceAndGroup(audienceId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndGroup_First(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByAudienceAndGroup_First(audienceId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndGroup_First(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAudienceAndGroup_First(audienceId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndGroup_Last(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByAudienceAndGroup_Last(audienceId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndGroup_Last(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAudienceAndGroup_Last(audienceId, groupId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByAudienceAndGroup_PrevAndNext(
		long entryId, long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByAudienceAndGroup_PrevAndNext(entryId, audienceId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByAudienceAndGroup(
		long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByAudienceAndGroup(audienceId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByAudienceAndGroup(
		long audienceId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByAudienceAndGroup(audienceId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries that the user has permissions to view where audienceId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByAudienceAndGroup(
		long audienceId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByAudienceAndGroup(audienceId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByAudienceAndGroup_PrevAndNext(
		long entryId, long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .filterFindByAudienceAndGroup_PrevAndNext(entryId,
			audienceId, groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResultTypeAndCompany(resultTypeId, companyId);
	}

	/**
	* Returns a range of all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResultTypeAndCompany(resultTypeId, companyId, start,
			end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResultTypeAndCompany(resultTypeId, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndCompany_First(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByResultTypeAndCompany_First(resultTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndCompany_First(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResultTypeAndCompany_First(resultTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndCompany_Last(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByResultTypeAndCompany_Last(resultTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndCompany_Last(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResultTypeAndCompany_Last(resultTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByResultTypeAndCompany_PrevAndNext(
		long entryId, long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByResultTypeAndCompany_PrevAndNext(entryId,
			resultTypeId, companyId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResultTypeAndGroup(resultTypeId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResultTypeAndGroup(resultTypeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResultTypeAndGroup(resultTypeId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndGroup_First(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByResultTypeAndGroup_First(resultTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndGroup_First(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResultTypeAndGroup_First(resultTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndGroup_Last(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByResultTypeAndGroup_Last(resultTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndGroup_Last(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResultTypeAndGroup_Last(resultTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByResultTypeAndGroup_PrevAndNext(
		long entryId, long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .findByResultTypeAndGroup_PrevAndNext(entryId, resultTypeId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByResultTypeAndGroup(
		long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByResultTypeAndGroup(resultTypeId, groupId);
	}

	/**
	* Returns a range of all the t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByResultTypeAndGroup(resultTypeId, groupId,
			start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries that the user has permissions to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByResultTypeAndGroup(resultTypeId, groupId,
			start, end, orderByComparator);
	}

	/**
	* Returns the t t h c_ entries before and after the current t t h c_ entry in the ordered set of t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current t t h c_ entry
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByResultTypeAndGroup_PrevAndNext(
		long entryId, long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException {
		return getPersistence()
				   .filterFindByResultTypeAndGroup_PrevAndNext(entryId,
			resultTypeId, groupId, orderByComparator);
	}

	/**
	* Returns all the t t h c_ entries.
	*
	* @return the t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t t h c_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @return the range of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t t h c_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ entries
	* @param end the upper bound of the range of t t h c_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t t h c_ entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the t t h c_ entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the t t h c_ entries where levelId = &#63; and companyId = &#63; from the database.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevelAndCompany(long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLevelAndCompany(levelId, companyId);
	}

	/**
	* Removes all the t t h c_ entries where levelId = &#63; and groupId = &#63; from the database.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLevelAndGroup(levelId, groupId);
	}

	/**
	* Removes all the t t h c_ entries where departmentId = &#63; and companyId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentAndCompany(long departmentId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentAndCompany(departmentId, companyId);
	}

	/**
	* Removes all the t t h c_ entries where departmentId = &#63; and groupId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartmentAndGroup(long departmentId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Removes all the t t h c_ entries where categoryId = &#63; and companyId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndCompany(long categoryId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Removes all the t t h c_ entries where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Removes all the t t h c_ entries where audienceId = &#63; and companyId = &#63; from the database.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAudienceAndCompany(long audienceId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAudienceAndCompany(audienceId, companyId);
	}

	/**
	* Removes all the t t h c_ entries where audienceId = &#63; and groupId = &#63; from the database.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAudienceAndGroup(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAudienceAndGroup(audienceId, groupId);
	}

	/**
	* Removes all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63; from the database.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResultTypeAndCompany(long resultTypeId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResultTypeAndCompany(resultTypeId, companyId);
	}

	/**
	* Removes all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63; from the database.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResultTypeAndGroup(long resultTypeId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResultTypeAndGroup(resultTypeId, groupId);
	}

	/**
	* Removes all the t t h c_ entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t t h c_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of t t h c_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of t t h c_ entries where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLevelAndCompany(long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLevelAndCompany(levelId, companyId);
	}

	/**
	* Returns the number of t t h c_ entries where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLevelAndGroup(levelId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByLevelAndGroup(levelId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentAndCompany(long departmentId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentAndCompany(departmentId, companyId);
	}

	/**
	* Returns the number of t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByDepartmentAndGroup(long departmentId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Returns the number of t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryAndGroup(long categoryId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAudienceAndCompany(long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAudienceAndCompany(audienceId, companyId);
	}

	/**
	* Returns the number of t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAudienceAndGroup(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAudienceAndGroup(audienceId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByAudienceAndGroup(long audienceId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByAudienceAndGroup(audienceId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResultTypeAndCompany(long resultTypeId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResultTypeAndCompany(resultTypeId, companyId);
	}

	/**
	* Returns the number of t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResultTypeAndGroup(long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResultTypeAndGroup(resultTypeId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByResultTypeAndGroup(long resultTypeId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByResultTypeAndGroup(resultTypeId, groupId);
	}

	/**
	* Returns the number of t t h c_ entries.
	*
	* @return the number of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TTHC_EntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TTHC_EntryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.tthc.service.ClpSerializer.getServletContextName(),
					TTHC_EntryPersistence.class.getName());

			ReferenceRegistry.registerReference(TTHC_EntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TTHC_EntryPersistence persistence) {
	}

	private static TTHC_EntryPersistence _persistence;
}