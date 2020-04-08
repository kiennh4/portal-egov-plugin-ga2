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

package com.portal_egov.portlet.compaints.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;

/**
 * The persistence interface for the complaint_ dl file entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see Complaint_DlFileEntriesPersistenceImpl
 * @see Complaint_DlFileEntriesUtil
 * @generated
 */
public interface Complaint_DlFileEntriesPersistence extends BasePersistence<Complaint_DlFileEntries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Complaint_DlFileEntriesUtil} to access the complaint_ dl file entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the complaint_ dl file entries in the entity cache if it is enabled.
	*
	* @param complaint_DlFileEntries the complaint_ dl file entries
	*/
	public void cacheResult(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries);

	/**
	* Caches the complaint_ dl file entrieses in the entity cache if it is enabled.
	*
	* @param complaint_DlFileEntrieses the complaint_ dl file entrieses
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> complaint_DlFileEntrieses);

	/**
	* Creates a new complaint_ dl file entries with the primary key. Does not add the complaint_ dl file entries to the database.
	*
	* @param id the primary key for the new complaint_ dl file entries
	* @return the new complaint_ dl file entries
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries create(
		long id);

	/**
	* Removes the complaint_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries that was removed
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries updateImpl(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaint_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException} if it could not be found.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns the complaint_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries, or <code>null</code> if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complaint_ dl file entrieses where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @return the matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaint_ dl file entrieses where complaintId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param complaintId the complaint ID
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @return the range of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaint_ dl file entrieses where complaintId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param complaintId the complaint ID
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByComplaint_First(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns the first complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByComplaint_First(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByComplaint_Last(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns the last complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByComplaint_Last(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaint_ dl file entrieses before and after the current complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param id the primary key of the current complaint_ dl file entries
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries[] findByComplaint_PrevAndNext(
		long id, long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns all the complaint_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaint_ dl file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @return the range of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaint_ dl file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByDLFile_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns the first complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByDLFile_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByDLFile_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns the last complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByDLFile_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complaint_ dl file entrieses before and after the current complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param id the primary key of the current complaint_ dl file entries
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries[] findByDLFile_PrevAndNext(
		long id, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException;

	/**
	* Returns all the complaint_ dl file entrieses.
	*
	* @return the complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complaint_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @return the range of complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complaint_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of complaint_ dl file entrieses
	* @param end the upper bound of the range of complaint_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaint_ dl file entrieses where complaintId = &#63; from the database.
	*
	* @param complaintId the complaint ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByComplaint(long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaint_ dl file entrieses where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDLFile(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complaint_ dl file entrieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaint_ dl file entrieses where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @return the number of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByComplaint(long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaint_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDLFile(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complaint_ dl file entrieses.
	*
	* @return the number of complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}