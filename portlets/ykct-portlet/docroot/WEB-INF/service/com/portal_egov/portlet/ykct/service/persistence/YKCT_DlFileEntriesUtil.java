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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries;

import java.util.List;

/**
 * The persistence utility for the y k c t_ dl file entries service. This utility wraps {@link YKCT_DlFileEntriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_DlFileEntriesPersistence
 * @see YKCT_DlFileEntriesPersistenceImpl
 * @generated
 */
public class YKCT_DlFileEntriesUtil {
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
	public static void clearCache(YKCT_DlFileEntries ykct_DlFileEntries) {
		getPersistence().clearCache(ykct_DlFileEntries);
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
	public static List<YKCT_DlFileEntries> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YKCT_DlFileEntries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YKCT_DlFileEntries> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static YKCT_DlFileEntries update(
		YKCT_DlFileEntries ykct_DlFileEntries, boolean merge)
		throws SystemException {
		return getPersistence().update(ykct_DlFileEntries, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static YKCT_DlFileEntries update(
		YKCT_DlFileEntries ykct_DlFileEntries, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ykct_DlFileEntries, merge, serviceContext);
	}

	/**
	* Caches the y k c t_ dl file entries in the entity cache if it is enabled.
	*
	* @param ykct_DlFileEntries the y k c t_ dl file entries
	*/
	public static void cacheResult(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries) {
		getPersistence().cacheResult(ykct_DlFileEntries);
	}

	/**
	* Caches the y k c t_ dl file entrieses in the entity cache if it is enabled.
	*
	* @param ykct_DlFileEntrieses the y k c t_ dl file entrieses
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> ykct_DlFileEntrieses) {
		getPersistence().cacheResult(ykct_DlFileEntrieses);
	}

	/**
	* Creates a new y k c t_ dl file entries with the primary key. Does not add the y k c t_ dl file entries to the database.
	*
	* @param id the primary key for the new y k c t_ dl file entries
	* @return the new y k c t_ dl file entries
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the y k c t_ dl file entries with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the y k c t_ dl file entries
	* @return the y k c t_ dl file entries that was removed
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence().remove(id);
	}

	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries ykct_DlFileEntries,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ykct_DlFileEntries, merge);
	}

	/**
	* Returns the y k c t_ dl file entries with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException} if it could not be found.
	*
	* @param id the primary key of the y k c t_ dl file entries
	* @return the y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the y k c t_ dl file entries with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the y k c t_ dl file entries
	* @return the y k c t_ dl file entries, or <code>null</code> if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the y k c t_ dl file entrieses where ykctEntryId = &#63;.
	*
	* @param ykctEntryId the ykct entry ID
	* @return the matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByYKCTEntry(
		long ykctEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYKCTEntry(ykctEntryId);
	}

	/**
	* Returns a range of all the y k c t_ dl file entrieses where ykctEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ykctEntryId the ykct entry ID
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @return the range of matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByYKCTEntry(
		long ykctEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByYKCTEntry(ykctEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the y k c t_ dl file entrieses where ykctEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ykctEntryId the ykct entry ID
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByYKCTEntry(
		long ykctEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByYKCTEntry(ykctEntryId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	*
	* @param ykctEntryId the ykct entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries findByYKCTEntry_First(
		long ykctEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence()
				   .findByYKCTEntry_First(ykctEntryId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	*
	* @param ykctEntryId the ykct entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries fetchByYKCTEntry_First(
		long ykctEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYKCTEntry_First(ykctEntryId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	*
	* @param ykctEntryId the ykct entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries findByYKCTEntry_Last(
		long ykctEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence()
				   .findByYKCTEntry_Last(ykctEntryId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	*
	* @param ykctEntryId the ykct entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries fetchByYKCTEntry_Last(
		long ykctEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByYKCTEntry_Last(ykctEntryId, orderByComparator);
	}

	/**
	* Returns the y k c t_ dl file entrieses before and after the current y k c t_ dl file entries in the ordered set where ykctEntryId = &#63;.
	*
	* @param id the primary key of the current y k c t_ dl file entries
	* @param ykctEntryId the ykct entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries[] findByYKCTEntry_PrevAndNext(
		long id, long ykctEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence()
				   .findByYKCTEntry_PrevAndNext(id, ykctEntryId,
			orderByComparator);
	}

	/**
	* Returns all the y k c t_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByDLFileEntry(
		long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDLFileEntry(fileEntryId);
	}

	/**
	* Returns a range of all the y k c t_ dl file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @return the range of matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByDLFileEntry(
		long fileEntryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDLFileEntry(fileEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the y k c t_ dl file entrieses where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findByDLFileEntry(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDLFileEntry(fileEntryId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries findByDLFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence()
				   .findByDLFileEntry_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries fetchByDLFileEntry_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDLFileEntry_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries findByDLFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence()
				   .findByDLFileEntry_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ dl file entries, or <code>null</code> if a matching y k c t_ dl file entries could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries fetchByDLFileEntry_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDLFileEntry_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the y k c t_ dl file entrieses before and after the current y k c t_ dl file entries in the ordered set where fileEntryId = &#63;.
	*
	* @param id the primary key of the current y k c t_ dl file entries
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ dl file entries
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException if a y k c t_ dl file entries with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries[] findByDLFileEntry_PrevAndNext(
		long id, long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_DlFileEntriesException {
		return getPersistence()
				   .findByDLFileEntry_PrevAndNext(id, fileEntryId,
			orderByComparator);
	}

	/**
	* Returns all the y k c t_ dl file entrieses.
	*
	* @return the y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the y k c t_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @return the range of y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the y k c t_ dl file entrieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ dl file entrieses
	* @param end the upper bound of the range of y k c t_ dl file entrieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_DlFileEntries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the y k c t_ dl file entrieses where ykctEntryId = &#63; from the database.
	*
	* @param ykctEntryId the ykct entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByYKCTEntry(long ykctEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByYKCTEntry(ykctEntryId);
	}

	/**
	* Removes all the y k c t_ dl file entrieses where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDLFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDLFileEntry(fileEntryId);
	}

	/**
	* Removes all the y k c t_ dl file entrieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of y k c t_ dl file entrieses where ykctEntryId = &#63;.
	*
	* @param ykctEntryId the ykct entry ID
	* @return the number of matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByYKCTEntry(long ykctEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByYKCTEntry(ykctEntryId);
	}

	/**
	* Returns the number of y k c t_ dl file entrieses where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDLFileEntry(long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDLFileEntry(fileEntryId);
	}

	/**
	* Returns the number of y k c t_ dl file entrieses.
	*
	* @return the number of y k c t_ dl file entrieses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YKCT_DlFileEntriesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YKCT_DlFileEntriesPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.ykct.service.ClpSerializer.getServletContextName(),
					YKCT_DlFileEntriesPersistence.class.getName());

			ReferenceRegistry.registerReference(YKCT_DlFileEntriesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(YKCT_DlFileEntriesPersistence persistence) {
	}

	private static YKCT_DlFileEntriesPersistence _persistence;
}