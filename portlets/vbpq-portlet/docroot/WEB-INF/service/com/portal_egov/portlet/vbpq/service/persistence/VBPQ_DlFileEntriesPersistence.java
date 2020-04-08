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

import com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries;

/**
 * The persistence interface for the v b p q_ dl file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_DlFileEntriesPersistenceImpl
 * @see VBPQ_DlFileEntriesUtil
 * @generated
 */
public interface VBPQ_DlFileEntriesPersistence extends BasePersistence<VBPQ_DlFileEntries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VBPQ_DlFileEntriesUtil} to access the v b p q_ dl file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the v b p q_ dl file entries in the entity cache if it is enabled.
	*
	* @param vbpq_DlFileEntries the v b p q_ dl file entries
	*/
	public void cacheResult(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries);

	/**
	* Caches the v b p q_ dl file entrieses in the entity cache if it is enabled.
	*
	* @param vbpq_DlFileEntrieses the v b p q_ dl file entrieses
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> vbpq_DlFileEntrieses);

	/**
	* Creates a new v b p q_ dl file entries with the primary key. Does not add the v b p q_ dl file entries to the database.
	*
	* @param id the primary key for the new v b p q_ dl file entries
	* @return the new v b p q_ dl file entries
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries create(long id);

	/**
	* Removes the v b p q_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the v b p q_ dl file entries
	* @return the v b p q_ dl file entries that was removed
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries vbpq_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v b p q_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException} if it could not be found.
	*
	* @param id the primary key of the v b p q_ dl file entries
	* @return the v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns the v b p q_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the v b p q_ dl file entries
	* @return the v b p q_ dl file entries, or <code>null</code> if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @return the matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByVBPQEntry(
		long vbpqEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vbpqEntryId the vbpq entry ID
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @return the range of matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByVBPQEntry(
		long vbpqEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vbpqEntryId the vbpq entry ID
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByVBPQEntry(
		long vbpqEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries findByVBPQEntry_First(
		long vbpqEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns the first v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries fetchByVBPQEntry_First(
		long vbpqEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries findByVBPQEntry_Last(
		long vbpqEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns the last v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries fetchByVBPQEntry_Last(
		long vbpqEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v b p q_ dl file entrieses before and after the current v b p q_ dl file entries in the ordered set where vbpqEntryId = &#63;.
	*
	* @param id the primary key of the current v b p q_ dl file entries
	* @param vbpqEntryId the vbpq entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries[] findByVBPQEntry_PrevAndNext(
		long id, long vbpqEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns all the v b p q_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByDLFileEntry(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v b p q_ dl file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @return the range of matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByDLFileEntry(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v b p q_ dl file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findByDLFileEntry(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries findByDLFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns the first v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries fetchByDLFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries findByDLFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns the last v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ dl file entries, or <code>null</code> if a matching v b p q_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries fetchByDLFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v b p q_ dl file entrieses before and after the current v b p q_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param id the primary key of the current v b p q_ dl file entries
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ dl file entries
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException if a v b p q_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries[] findByDLFileEntry_PrevAndNext(
		long id, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_DlFileEntriesException;

	/**
	* Returns all the v b p q_ dl file entrieses.
	*
	* @return the v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the v b p q_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @return the range of v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the v b p q_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ dl file entrieses
	* @param end the upper bound of the range of v b p q_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_DlFileEntries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ dl file entrieses where vbpqEntryId = &#63; from the database.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVBPQEntry(long vbpqEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ dl file entrieses where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDLFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ dl file entrieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ dl file entrieses where vbpqEntryId = &#63;.
	*
	* @param vbpqEntryId the vbpq entry ID
	* @return the number of matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByVBPQEntry(long vbpqEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDLFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ dl file entrieses.
	*
	* @return the number of v b p q_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}