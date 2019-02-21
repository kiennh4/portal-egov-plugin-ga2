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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries;

import java.util.List;

/**
 * The persistence utility for the complaint_ dl file entries service. This utility wraps {@link Complaint_DlFileEntriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see Complaint_DlFileEntriesPersistence
 * @see Complaint_DlFileEntriesPersistenceImpl
 * @generated
 */
public class Complaint_DlFileEntriesUtil {
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
	public static void clearCache(
		Complaint_DlFileEntries complaint_DlFileEntries) {
		getPersistence().clearCache(complaint_DlFileEntries);
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
	public static List<Complaint_DlFileEntries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Complaint_DlFileEntries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Complaint_DlFileEntries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Complaint_DlFileEntries update(
		Complaint_DlFileEntries complaint_DlFileEntries, boolean merge)
		throws SystemException {
		return getPersistence().update(complaint_DlFileEntries, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Complaint_DlFileEntries update(
		Complaint_DlFileEntries complaint_DlFileEntries, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(complaint_DlFileEntries, merge, serviceContext);
	}

	/**
	* Caches the complaint_ dl file entries in the entity cache if it is enabled.
	*
	* @param complaint_DlFileEntries the complaint_ dl file entries
	*/
	public static void cacheResult(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries) {
		getPersistence().cacheResult(complaint_DlFileEntries);
	}

	/**
	* Caches the complaint_ dl file entrieses in the entity cache if it is enabled.
	*
	* @param complaint_DlFileEntrieses the complaint_ dl file entrieses
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> complaint_DlFileEntrieses) {
		getPersistence().cacheResult(complaint_DlFileEntrieses);
	}

	/**
	* Creates a new complaint_ dl file entries with the primary key. Does not add the complaint_ dl file entries to the database.
	*
	* @param id the primary key for the new complaint_ dl file entries
	* @return the new complaint_ dl file entries
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the complaint_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries that was removed
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence().remove(id);
	}

	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries updateImpl(
		com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries complaint_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(complaint_DlFileEntries, merge);
	}

	/**
	* Returns the complaint_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException} if it could not be found.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the complaint_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the complaint_ dl file entries
	* @return the complaint_ dl file entries, or <code>null</code> if a complaint_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the complaint_ dl file entrieses where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @return the matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByComplaint(complaintId);
	}

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
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByComplaint(complaintId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByComplaint(
		long complaintId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComplaint(complaintId, start, end, orderByComparator);
	}

	/**
	* Returns the first complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByComplaint_First(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence()
				   .findByComplaint_First(complaintId, orderByComparator);
	}

	/**
	* Returns the first complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByComplaint_First(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComplaint_First(complaintId, orderByComparator);
	}

	/**
	* Returns the last complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByComplaint_Last(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence()
				   .findByComplaint_Last(complaintId, orderByComparator);
	}

	/**
	* Returns the last complaint_ dl file entries in the ordered set where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByComplaint_Last(
		long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComplaint_Last(complaintId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries[] findByComplaint_PrevAndNext(
		long id, long complaintId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence()
				   .findByComplaint_PrevAndNext(id, complaintId,
			orderByComparator);
	}

	/**
	* Returns all the complaint_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDLFile(fileEntryId);
	}

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
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDLFile(fileEntryId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findByDLFile(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDLFile(fileEntryId, start, end, orderByComparator);
	}

	/**
	* Returns the first complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByDLFile_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence()
				   .findByDLFile_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the first complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByDLFile_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDLFile_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries
	* @throws com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries findByDLFile_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence().findByDLFile_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last complaint_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complaint_ dl file entries, or <code>null</code> if a matching complaint_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries fetchByDLFile_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDLFile_Last(fileEntryId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries[] findByDLFile_PrevAndNext(
		long id, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.compaints.NoSuchComplaint_DlFileEntriesException {
		return getPersistence()
				   .findByDLFile_PrevAndNext(id, fileEntryId, orderByComparator);
	}

	/**
	* Returns all the complaint_ dl file entrieses.
	*
	* @return the complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the complaint_ dl file entrieses where complaintId = &#63; from the database.
	*
	* @param complaintId the complaint ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByComplaint(long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByComplaint(complaintId);
	}

	/**
	* Removes all the complaint_ dl file entrieses where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDLFile(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDLFile(fileEntryId);
	}

	/**
	* Removes all the complaint_ dl file entrieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of complaint_ dl file entrieses where complaintId = &#63;.
	*
	* @param complaintId the complaint ID
	* @return the number of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByComplaint(long complaintId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByComplaint(complaintId);
	}

	/**
	* Returns the number of complaint_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDLFile(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDLFile(fileEntryId);
	}

	/**
	* Returns the number of complaint_ dl file entrieses.
	*
	* @return the number of complaint_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Complaint_DlFileEntriesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Complaint_DlFileEntriesPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.compaints.service.ClpSerializer.getServletContextName(),
					Complaint_DlFileEntriesPersistence.class.getName());

			ReferenceRegistry.registerReference(Complaint_DlFileEntriesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(Complaint_DlFileEntriesPersistence persistence) {
	}

	private static Complaint_DlFileEntriesPersistence _persistence;
}