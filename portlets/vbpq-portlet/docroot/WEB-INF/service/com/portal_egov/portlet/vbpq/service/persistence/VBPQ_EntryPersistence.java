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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;

/**
 * The persistence interface for the v b p q_ entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_EntryPersistenceImpl
 * @see VBPQ_EntryUtil
 * @generated
 */
public interface VBPQ_EntryPersistence extends BasePersistence<VBPQ_Entry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VBPQ_EntryUtil} to access the v b p q_ entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the v b p q_ entry in the entity cache if it is enabled.
	*
	* @param vbpq_Entry the v b p q_ entry
	*/
	public void cacheResult(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry);

	/**
	* Caches the v b p q_ entries in the entity cache if it is enabled.
	*
	* @param vbpq_Entries the v b p q_ entries
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> vbpq_Entries);

	/**
	* Creates a new v b p q_ entry with the primary key. Does not add the v b p q_ entry to the database.
	*
	* @param entryId the primary key for the new v b p q_ entry
	* @return the new v b p q_ entry
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry create(long entryId);

	/**
	* Removes the v b p q_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry that was removed
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry remove(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_Entry vbpq_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v b p q_ entry with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException} if it could not be found.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the v b p q_ entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the v b p q_ entry
	* @return the v b p q_ entry, or <code>null</code> if a v b p q_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v b p q_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDepartmentAndCompany_PrevAndNext(
		long entryId, long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByCategoryAndCompany_PrevAndNext(
		long entryId, long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndCompany(
		long docTypeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndCompany_First(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndCompany_First(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndCompany_Last(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndCompany_Last(
		long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDocTypeAndCompany_PrevAndNext(
		long entryId, long docTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndGroup_First(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndGroup_First(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByDocTypeAndGroup_Last(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByDocTypeAndGroup_Last(
		long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByDocTypeAndGroup_PrevAndNext(
		long entryId, long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDocTypeAndGroup(
		long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByDocTypeAndGroup(
		long docTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByDocTypeAndGroup_PrevAndNext(
		long entryId, long docTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		boolean neverExpired, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		boolean neverExpired, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndCompany(
		boolean neverExpired, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndCompany_First(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndCompany_First(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndCompany_Last(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndCompany_Last(
		boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByExpirationAndCompany_PrevAndNext(
		long entryId, boolean neverExpired, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		boolean neverExpired, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndGroup_First(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndGroup_First(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByExpirationAndGroup_Last(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByExpirationAndGroup_Last(
		boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByExpirationAndGroup_PrevAndNext(
		long entryId, boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByExpirationAndGroup(
		boolean neverExpired, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByExpirationAndGroup_PrevAndNext(
		long entryId, boolean neverExpired, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndCompany(
		boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndCompany(
		boolean active, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndCompany(
		boolean active, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByStatusAndCompany_PrevAndNext(
		long entryId, boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the first v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry findByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns the last v b p q_ entry in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ entry, or <code>null</code> if a matching v b p q_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry fetchByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] findByStatusAndGroup_PrevAndNext(
		long entryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Entry[] filterFindByStatusAndGroup_PrevAndNext(
		long entryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_EntryException;

	/**
	* Returns all the v b p q_ entries.
	*
	* @return the v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where departmentId = &#63; and companyId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentAndCompany(long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where departmentId = &#63; and groupId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where categoryId = &#63; and companyId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where docTypeId = &#63; and companyId = &#63; from the database.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDocTypeAndCompany(long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where docTypeId = &#63; and groupId = &#63; from the database.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDocTypeAndGroup(long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where neverExpired = &#63; and companyId = &#63; from the database.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByExpirationAndCompany(boolean neverExpired,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where neverExpired = &#63; and groupId = &#63; from the database.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByExpirationAndGroup(boolean neverExpired, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where active = &#63; and companyId = &#63; from the database.
	*
	* @param active the active
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries where active = &#63; and groupId = &#63; from the database.
	*
	* @param active the active
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentAndCompany(long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where docTypeId = &#63; and companyId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDocTypeAndCompany(long docTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDocTypeAndGroup(long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where docTypeId = &#63; and groupId = &#63;.
	*
	* @param docTypeId the doc type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByDocTypeAndGroup(long docTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where neverExpired = &#63; and companyId = &#63;.
	*
	* @param neverExpired the never expired
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByExpirationAndCompany(boolean neverExpired, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByExpirationAndGroup(boolean neverExpired, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where neverExpired = &#63; and groupId = &#63;.
	*
	* @param neverExpired the never expired
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByExpirationAndGroup(boolean neverExpired,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ entries.
	*
	* @return the number of v b p q_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}