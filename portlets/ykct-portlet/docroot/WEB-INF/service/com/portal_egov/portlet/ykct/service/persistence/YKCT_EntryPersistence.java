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

package com.portal_egov.portlet.ykct.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.ykct.model.YKCT_Entry;

/**
 * The persistence interface for the y k c t_ entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_EntryPersistenceImpl
 * @see YKCT_EntryUtil
 * @generated
 */
public interface YKCT_EntryPersistence extends BasePersistence<YKCT_Entry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YKCT_EntryUtil} to access the y k c t_ entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the y k c t_ entry in the entity cache if it is enabled.
	*
	* @param ykct_Entry the y k c t_ entry
	*/
	public void cacheResult(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry);

	/**
	* Caches the y k c t_ entries in the entity cache if it is enabled.
	*
	* @param ykct_Entries the y k c t_ entries
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> ykct_Entries);

	/**
	* Creates a new y k c t_ entry with the primary key. Does not add the y k c t_ entry to the database.
	*
	* @param entryId the primary key for the new y k c t_ entry
	* @return the new y k c t_ entry
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry create(long entryId);

	/**
	* Removes the y k c t_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry that was removed
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry remove(long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	public com.portal_egov.portlet.ykct.model.YKCT_Entry updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the y k c t_ entry with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException} if it could not be found.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the y k c t_ entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry, or <code>null</code> if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the y k c t_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y k c t_ entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @return the range of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y k c t_ entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the first y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the last y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the y k c t_ entries before and after the current y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param entryId the primary key of the current y k c t_ entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns all the y k c t_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y k c t_ entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @return the range of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y k c t_ entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the first y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the last y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the y k c t_ entries before and after the current y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param entryId the primary key of the current y k c t_ entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns all the y k c t_ entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y k c t_ entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @return the range of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y k c t_ entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the first y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns the last y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the y k c t_ entries before and after the current y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param entryId the primary key of the current y k c t_ entry
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Entry[] findByCategory_PrevAndNext(
		long entryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException;

	/**
	* Returns all the y k c t_ entries.
	*
	* @return the y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y k c t_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @return the range of y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y k c t_ entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ entries
	* @param end the upper bound of the range of y k c t_ entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ entries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ entries.
	*
	* @return the number of y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}