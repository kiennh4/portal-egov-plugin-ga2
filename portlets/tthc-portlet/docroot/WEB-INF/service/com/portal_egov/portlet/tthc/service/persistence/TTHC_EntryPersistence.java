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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.tthc.model.TTHC_Entry;

/**
 * The persistence interface for the t t h c_ entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_EntryPersistenceImpl
 * @see TTHC_EntryUtil
 * @generated
 */
public interface TTHC_EntryPersistence extends BasePersistence<TTHC_Entry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTHC_EntryUtil} to access the t t h c_ entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the t t h c_ entry in the entity cache if it is enabled.
	*
	* @param tthc_Entry the t t h c_ entry
	*/
	public void cacheResult(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry);

	/**
	* Caches the t t h c_ entries in the entity cache if it is enabled.
	*
	* @param tthc_Entries the t t h c_ entries
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> tthc_Entries);

	/**
	* Creates a new t t h c_ entry with the primary key. Does not add the t t h c_ entry to the database.
	*
	* @param entryId the primary key for the new t t h c_ entry
	* @return the new t t h c_ entry
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry create(long entryId);

	/**
	* Removes the t t h c_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry that was removed
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry remove(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	public com.portal_egov.portlet.tthc.model.TTHC_Entry updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Entry tthc_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ entry with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException} if it could not be found.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the t t h c_ entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the t t h c_ entry
	* @return the t t h c_ entry, or <code>null</code> if a t t h c_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t t h c_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndCompany(
		long levelId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndCompany_First(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndCompany_First(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndCompany_Last(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndCompany_Last(
		long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByLevelAndCompany_PrevAndNext(
		long entryId, long levelId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByLevelAndGroup(
		long levelId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndGroup_First(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndGroup_First(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByLevelAndGroup_Last(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByLevelAndGroup_Last(
		long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByLevelAndGroup_PrevAndNext(
		long entryId, long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByLevelAndGroup(
		long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByLevelAndGroup(
		long levelId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByLevelAndGroup(
		long levelId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByLevelAndGroup_PrevAndNext(
		long entryId, long levelId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndCompany(
		long departmentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndCompany_First(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndCompany_Last(
		long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByDepartmentAndCompany_PrevAndNext(
		long entryId, long departmentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndGroup_First(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByDepartmentAndGroup_Last(
		long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByDepartmentAndGroup(
		long departmentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByDepartmentAndGroup_PrevAndNext(
		long entryId, long departmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByCategoryAndCompany_PrevAndNext(
		long entryId, long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByCategoryAndGroup_PrevAndNext(
		long entryId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndCompany(
		long audienceId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndCompany_First(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndCompany_First(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndCompany_Last(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndCompany_Last(
		long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByAudienceAndCompany_PrevAndNext(
		long entryId, long audienceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByAudienceAndGroup(
		long audienceId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndGroup_First(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndGroup_First(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByAudienceAndGroup_Last(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByAudienceAndGroup_Last(
		long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByAudienceAndGroup_PrevAndNext(
		long entryId, long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByAudienceAndGroup(
		long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByAudienceAndGroup(
		long audienceId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByAudienceAndGroup(
		long audienceId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByAudienceAndGroup_PrevAndNext(
		long entryId, long audienceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndCompany(
		long resultTypeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndCompany_First(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndCompany_First(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndCompany_Last(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndCompany_Last(
		long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByResultTypeAndCompany_PrevAndNext(
		long entryId, long resultTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndGroup_First(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the first t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndGroup_First(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry findByResultTypeAndGroup_Last(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns the last t t h c_ entry in the ordered set where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ entry, or <code>null</code> if a matching t t h c_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Entry fetchByResultTypeAndGroup_Last(
		long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] findByResultTypeAndGroup_PrevAndNext(
		long entryId, long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByResultTypeAndGroup(
		long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> filterFindByResultTypeAndGroup(
		long resultTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.tthc.model.TTHC_Entry[] filterFindByResultTypeAndGroup_PrevAndNext(
		long entryId, long resultTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_EntryException;

	/**
	* Returns all the t t h c_ entries.
	*
	* @return the t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where levelId = &#63; and companyId = &#63; from the database.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLevelAndCompany(long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where levelId = &#63; and groupId = &#63; from the database.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where departmentId = &#63; and companyId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentAndCompany(long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where departmentId = &#63; and groupId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where categoryId = &#63; and companyId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where audienceId = &#63; and companyId = &#63; from the database.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAudienceAndCompany(long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where audienceId = &#63; and groupId = &#63; from the database.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAudienceAndGroup(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where resultTypeId = &#63; and companyId = &#63; from the database.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResultTypeAndCompany(long resultTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries where resultTypeId = &#63; and groupId = &#63; from the database.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResultTypeAndGroup(long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where levelId = &#63; and companyId = &#63;.
	*
	* @param levelId the level ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByLevelAndCompany(long levelId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where levelId = &#63; and groupId = &#63;.
	*
	* @param levelId the level ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByLevelAndGroup(long levelId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where departmentId = &#63; and companyId = &#63;.
	*
	* @param departmentId the department ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentAndCompany(long departmentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where departmentId = &#63; and groupId = &#63;.
	*
	* @param departmentId the department ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByDepartmentAndGroup(long departmentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where audienceId = &#63; and companyId = &#63;.
	*
	* @param audienceId the audience ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByAudienceAndCompany(long audienceId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByAudienceAndGroup(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where audienceId = &#63; and groupId = &#63;.
	*
	* @param audienceId the audience ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByAudienceAndGroup(long audienceId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where resultTypeId = &#63; and companyId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByResultTypeAndCompany(long resultTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByResultTypeAndGroup(long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries that the user has permission to view where resultTypeId = &#63; and groupId = &#63;.
	*
	* @param resultTypeId the result type ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ entries that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByResultTypeAndGroup(long resultTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ entries.
	*
	* @return the number of t t h c_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}