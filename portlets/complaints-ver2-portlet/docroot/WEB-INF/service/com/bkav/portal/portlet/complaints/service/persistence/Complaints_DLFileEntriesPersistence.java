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

package com.bkav.portal.portlet.complaints.service.persistence;

import com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the complaints_ d l file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhBDb
 * @see Complaints_DLFileEntriesPersistenceImpl
 * @see Complaints_DLFileEntriesUtil
 * @generated
 */
public interface Complaints_DLFileEntriesPersistence extends BasePersistence<Complaints_DLFileEntries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Complaints_DLFileEntriesUtil} to access the complaints_ d l file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the complaints_ d l file entries in the entity cache if it is enabled.
	*
	* @param complaints_DLFileEntries the complaints_ d l file entries
	*/
	public void cacheResult(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries);

	/**
	* Caches the complaints_ d l file entrieses in the entity cache if it is enabled.
	*
	* @param complaints_DLFileEntrieses the complaints_ d l file entrieses
	*/
	public void cacheResult(
		java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> complaints_DLFileEntrieses);

	/**
	* Creates a new complaints_ d l file entries with the primary key. Does not add the complaints_ d l file entries to the database.
	*
	* @param id the primary key for the new complaints_ d l file entries
	* @return the new complaints_ d l file entries
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries create(
		long id);

	/**
	* Removes the complaints_ d l file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the complaints_ d l file entries
	* @return the complaints_ d l file entries that was removed
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries remove(
		long id)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries updateImpl(
		com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries complaints_DLFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints_ d l file entries with the primary key or throws a {@link com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException} if it could not be found.
	*
	* @param id the primary key of the complaints_ d l file entries
	* @return the complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries findByPrimaryKey(
		long id)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints_ d l file entries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the complaints_ d l file entries
	* @return the complaints_ d l file entries, or <code>null</code> if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaints_ d l file entrieses where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @return the matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByComplaintId(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaints_ d l file entrieses where complaintId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param complaintId the complaint ID
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @return the range of matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByComplaintId(
		long complaintId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaints_ d l file entrieses where complaintId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param complaintId the complaint ID
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByComplaintId(
		long complaintId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints_ d l file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries findByComplaintId_First(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints_ d l file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries fetchByComplaintId_First(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints_ d l file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries findByComplaintId_Last(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints_ d l file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries fetchByComplaintId_Last(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints_ d l file entrieses before and after the current complaints_ d l file entries in the ordered set where complaintId = &#63;.
	*
	* @param id the primary key of the current complaints_ d l file entries
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries[] findByComplaintId_PrevAndNext(
		long id, long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaints_ d l file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByDLFileEntry(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaints_ d l file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @return the range of matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByDLFileEntry(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaints_ d l file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findByDLFileEntry(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries findByDLFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries fetchByDLFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries findByDLFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaints_ d l file entries, or <code>null</code> if a matching complaints_ d l file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries fetchByDLFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaints_ d l file entrieses before and after the current complaints_ d l file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param id the primary key of the current complaints_ d l file entries
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaints_ d l file entries
	* @throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException if a complaints_ d l file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries[] findByDLFileEntry_PrevAndNext(
		long id, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.bkav.portal.portlet.complaints.NoSuchComplaints_DLFileEntriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaints_ d l file entrieses.
	*
	* @return the complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaints_ d l file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @return the range of complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaints_ d l file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaints_ d l file entrieses
	* @param end the upper bound of the range of complaints_ d l file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bkav.portal.portlet.complaints.model.Complaints_DLFileEntries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaints_ d l file entrieses where complaintId = &#63; from the database.
	*
	* @param complaintId the complaint ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByComplaintId(long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaints_ d l file entrieses where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDLFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaints_ d l file entrieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaints_ d l file entrieses where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @return the number of matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByComplaintId(long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaints_ d l file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDLFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaints_ d l file entrieses.
	*
	* @return the number of complaints_ d l file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}