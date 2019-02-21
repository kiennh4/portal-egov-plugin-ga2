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

package com.portal_egov.portlet.vbpq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;

import java.util.List;

/**
 * The persistence utility for the v b p q_ entry service. This utility wraps {@link VBPQ_EntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_EntryPersistence
 * @see VBPQ_EntryPersistenceImpl
 * @generated
 */
public class VBPQ_EntryUtil {
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
	public static void clearCache(VBPQ_Entry vbpq_Entry) {
		getPersistence().clearCache(vbpq_Entry);
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
	public static List<VBPQ_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VBPQ_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VBPQ_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VBPQ_Entry update(VBPQ_Entry vbpq_Entry, boolean merge)
		throws SystemException {
		return getPersistence().update(vbpq_Entry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VBPQ_Entry update(VBPQ_Entry vbpq_Entry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vbpq_Entry, merge, serviceContext);
	}

	/**
	* Caches the v b p q_ entry in the entity cache if it is enabled.
	*
	* @param vbpq_Entry the v b p q_ entry
	*/
	public static void cacheResult(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry) {
		getPersistence().cacheResult(vbpq_Entry);
	}

	/**
	* Caches the v b p q_ entries in the entity cache if it is enabled.
	*
	* @param vbpq_Entries the v b p q_ entries
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> vbpq_Entries) {
		getPersistence().cacheResult(vbpq_Entries);
	}

	/**
	* Creates a new v b p q_ entry with the primary key. Does not add the v b p q_ entry to the database.
	*
	* @param entryId the primary key for the new v b p q_ entry
	* @return the new v b p q_ entry
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the v b p q_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry that was removed
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence().remove(entryId);
	}

	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vbpq_Entry, merge);
	}

	/**
	* Returns the v b p q_ entry with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException} if it could not be found.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the v b p q_ entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry, or <code>null</code> if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the v b p q_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the v b p q_ entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(entryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(entryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(departmentId, companyId);
	}

	/**
	* Returns a range of all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(departmentId, companyId, start,
			end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndCompany(departmentId, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDepartmentAndCompany_First(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndCompany_First(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDepartmentAndCompany_Last(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndCompany_Last(departmentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDepartmentAndCompany_PrevAndNext(
		long entryId, long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDepartmentAndCompany_PrevAndNext(entryId,
			departmentId, companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndGroup(departmentId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartmentAndGroup(departmentId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDepartmentAndGroup_First(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndGroup_First(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDepartmentAndGroup_Last(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartmentAndGroup_Last(departmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDepartmentAndGroup_PrevAndNext(entryId, departmentId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(departmentId, groupId,
			start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries that the user has permissions to view where departmentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup(departmentId, groupId,
			start, end, orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .filterFindByDepartmentAndGroup_PrevAndNext(entryId,
			departmentId, groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Returns a range of all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(categoryId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(categoryId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCategoryAndCompany_First(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_First(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCategoryAndCompany_Last(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_Last(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByCategoryAndCompany_PrevAndNext(
		long entryId, long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCategoryAndCompany_PrevAndNext(entryId, categoryId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCategoryAndGroup_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCategoryAndGroup_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByCategoryAndGroup_PrevAndNext(entryId, categoryId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(categoryId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(categoryId, groupId, start,
			end, orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .filterFindByCategoryAndGroup_PrevAndNext(entryId,
			categoryId, groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocTypeAndCompany(docTypeId, companyId);
	}

	/**
	* Returns a range of all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocTypeAndCompany(docTypeId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocTypeAndCompany(docTypeId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndCompany_First(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDocTypeAndCompany_First(docTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndCompany_First(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocTypeAndCompany_First(docTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndCompany_Last(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDocTypeAndCompany_Last(docTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndCompany_Last(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocTypeAndCompany_Last(docTypeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDocTypeAndCompany_PrevAndNext(
		long entryId, long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDocTypeAndCompany_PrevAndNext(entryId, docTypeId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocTypeAndGroup(docTypeId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocTypeAndGroup(docTypeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocTypeAndGroup(docTypeId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndGroup_First(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDocTypeAndGroup_First(docTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndGroup_First(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocTypeAndGroup_First(docTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndGroup_Last(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDocTypeAndGroup_Last(docTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndGroup_Last(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocTypeAndGroup_Last(docTypeId, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDocTypeAndGroup_PrevAndNext(
		long entryId, long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByDocTypeAndGroup_PrevAndNext(entryId, docTypeId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDocTypeAndGroup(
		long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByDocTypeAndGroup(docTypeId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDocTypeAndGroup(docTypeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries that the user has permissions to view where docTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByDocTypeAndGroup(docTypeId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByDocTypeAndGroup_PrevAndNext(
		long entryId, long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .filterFindByDocTypeAndGroup_PrevAndNext(entryId, docTypeId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		boolean neverExpired, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationAndCompany(neverExpired, companyId);
	}

	/**
	* Returns a range of all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		boolean neverExpired, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationAndCompany(neverExpired, companyId, start,
			end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		boolean neverExpired, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationAndCompany(neverExpired, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndCompany_First(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByExpirationAndCompany_First(neverExpired, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndCompany_First(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpirationAndCompany_First(neverExpired, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndCompany_Last(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByExpirationAndCompany_Last(neverExpired, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndCompany_Last(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpirationAndCompany_Last(neverExpired, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByExpirationAndCompany_PrevAndNext(
		long entryId, boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByExpirationAndCompany_PrevAndNext(entryId,
			neverExpired, companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		boolean neverExpired, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExpirationAndGroup(neverExpired, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationAndGroup(neverExpired, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationAndGroup(neverExpired, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndGroup_First(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByExpirationAndGroup_First(neverExpired, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndGroup_First(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpirationAndGroup_First(neverExpired, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndGroup_Last(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByExpirationAndGroup_Last(neverExpired, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndGroup_Last(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpirationAndGroup_Last(neverExpired, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByExpirationAndGroup_PrevAndNext(
		long entryId, boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByExpirationAndGroup_PrevAndNext(entryId, neverExpired,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByExpirationAndGroup(neverExpired, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByExpirationAndGroup(neverExpired, groupId,
			start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries that the user has permissions to view where neverExpired = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByExpirationAndGroup(neverExpired, groupId,
			start, end, orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByExpirationAndGroup_PrevAndNext(
		long entryId, boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .filterFindByExpirationAndGroup_PrevAndNext(entryId,
			neverExpired, groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndCompany(
		boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndCompany(active, companyId);
	}

	/**
	* Returns a range of all the v b p q_ entries where active = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndCompany(
		boolean active, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(active, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where active = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndCompany(
		boolean active, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(active, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByStatusAndCompany_First(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByStatusAndCompany_Last(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByStatusAndCompany_PrevAndNext(
		long entryId, boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(entryId, active,
			companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(active, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(active, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(active, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByStatusAndGroup_First(active, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(active, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByStatusAndGroup_Last(active, groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(active, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByStatusAndGroup_PrevAndNext(
		long entryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(entryId, active, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatusAndGroup(active, groupId);
	}

	/**
	* Returns a range of all the v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(active, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries that the user has permissions to view where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(active, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ entries before and after the current v b p q_ entry in the ordered set of v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param entryId the primary key of the current v b p q_ entry
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByStatusAndGroup_PrevAndNext(
		long entryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(entryId, active,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ entries.
	*
	* @return the v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v b p q_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @return the range of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ entries
	* @param end the upper bound of the range of v b p q_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v b p q_ entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the v b p q_ entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the v b p q_ entries where departmentId = &#63; and companyId = &#63; from the database.
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
	* Removes all the v b p q_ entries where departmentId = &#63; and groupId = &#63; from the database.
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
	* Removes all the v b p q_ entries where categoryId = &#63; and companyId = &#63; from the database.
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
	* Removes all the v b p q_ entries where categoryId = &#63; and groupId = &#63; from the database.
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
	* Removes all the v b p q_ entries where docTypeId = &#63; and companyId = &#63; from the database.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDocTypeAndCompany(long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDocTypeAndCompany(docTypeId, companyId);
	}

	/**
	* Removes all the v b p q_ entries where docTypeId = &#63; and groupId = &#63; from the database.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDocTypeAndGroup(long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDocTypeAndGroup(docTypeId, groupId);
	}

	/**
	* Removes all the v b p q_ entries where neverExpired = &#63; and companyId = &#63; from the database.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExpirationAndCompany(boolean neverExpired,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExpirationAndCompany(neverExpired, companyId);
	}

	/**
	* Removes all the v b p q_ entries where neverExpired = &#63; and groupId = &#63; from the database.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExpirationAndGroup(boolean neverExpired,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExpirationAndGroup(neverExpired, groupId);
	}

	/**
	* Removes all the v b p q_ entries where active = &#63; and companyId = &#63; from the database.
	*
	* @param active the active
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndCompany(active, companyId);
	}

	/**
	* Removes all the v b p q_ entries where active = &#63; and groupId = &#63; from the database.
	*
	* @param active the active
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndGroup(active, groupId);
	}

	/**
	* Removes all the v b p q_ entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v b p q_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of v b p q_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentAndCompany(long departmentId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDepartmentAndCompany(departmentId, companyId);
	}

	/**
	* Returns the number of v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByDepartmentAndGroup(long departmentId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByDepartmentAndGroup(departmentId, groupId);
	}

	/**
	* Returns the number of v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Returns the number of v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryAndGroup(long categoryId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns the number of v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDocTypeAndCompany(long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDocTypeAndCompany(docTypeId, companyId);
	}

	/**
	* Returns the number of v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDocTypeAndGroup(long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDocTypeAndGroup(docTypeId, groupId);
	}

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByDocTypeAndGroup(long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByDocTypeAndGroup(docTypeId, groupId);
	}

	/**
	* Returns the number of v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExpirationAndCompany(boolean neverExpired,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByExpirationAndCompany(neverExpired, companyId);
	}

	/**
	* Returns the number of v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExpirationAndGroup(boolean neverExpired,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExpirationAndGroup(neverExpired, groupId);
	}

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByExpirationAndGroup(boolean neverExpired,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByExpirationAndGroup(neverExpired, groupId);
	}

	/**
	* Returns the number of v b p q_ entries where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndCompany(active, companyId);
	}

	/**
	* Returns the number of v b p q_ entries where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(active, groupId);
	}

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatusAndGroup(active, groupId);
	}

	/**
	* Returns the number of v b p q_ entries.
	*
	* @return the number of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VBPQ_EntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VBPQ_EntryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.vbpq.service.ClpSerializer.getServletContextName(),
					VBPQ_EntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VBPQ_EntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VBPQ_EntryPersistence persistence) {
	}

	private static VBPQ_EntryPersistence _persistence;
}