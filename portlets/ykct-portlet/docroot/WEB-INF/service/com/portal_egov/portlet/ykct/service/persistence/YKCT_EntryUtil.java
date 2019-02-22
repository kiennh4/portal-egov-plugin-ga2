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

import com.portal_egov.portlet.ykct.model.YKCT_Entry;

import java.util.List;

/**
 * The persistence utility for the y k c t_ entry service. This utility wraps {@link YKCT_EntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_EntryPersistence
 * @see YKCT_EntryPersistenceImpl
 * @generated
 */
public class YKCT_EntryUtil {
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
	public static void clearCache(YKCT_Entry ykct_Entry) {
		getPersistence().clearCache(ykct_Entry);
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
	public static List<YKCT_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YKCT_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YKCT_Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static YKCT_Entry update(YKCT_Entry ykct_Entry, boolean merge)
		throws SystemException {
		return getPersistence().update(ykct_Entry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static YKCT_Entry update(YKCT_Entry ykct_Entry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ykct_Entry, merge, serviceContext);
	}

	/**
	* Caches the y k c t_ entry in the entity cache if it is enabled.
	*
	* @param ykct_Entry the y k c t_ entry
	*/
	public static void cacheResult(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry) {
		getPersistence().cacheResult(ykct_Entry);
	}

	/**
	* Caches the y k c t_ entries in the entity cache if it is enabled.
	*
	* @param ykct_Entries the y k c t_ entries
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> ykct_Entries) {
		getPersistence().cacheResult(ykct_Entries);
	}

	/**
	* Creates a new y k c t_ entry with the primary key. Does not add the y k c t_ entry to the database.
	*
	* @param entryId the primary key for the new y k c t_ entry
	* @return the new y k c t_ entry
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry create(
		long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	* Removes the y k c t_ entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry that was removed
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry remove(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence().remove(entryId);
	}

	public static com.portal_egov.portlet.ykct.model.YKCT_Entry updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_Entry ykct_Entry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ykct_Entry, merge);
	}

	/**
	* Returns the y k c t_ entry with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException} if it could not be found.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	* Returns the y k c t_ entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entryId the primary key of the y k c t_ entry
	* @return the y k c t_ entry, or <code>null</code> if a y k c t_ entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByPrimaryKey(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	* Returns all the y k c t_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry[] findByCompany_PrevAndNext(
		long entryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(entryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the y k c t_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry[] findByGroup_PrevAndNext(
		long entryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(entryId, groupId, orderByComparator);
	}

	/**
	* Returns all the y k c t_ entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ entry in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ entry, or <code>null</code> if a matching y k c t_ entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.ykct.model.YKCT_Entry[] findByCategory_PrevAndNext(
		long entryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_EntryException {
		return getPersistence()
				   .findByCategory_PrevAndNext(entryId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the y k c t_ entries.
	*
	* @return the y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the y k c t_ entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the y k c t_ entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the y k c t_ entries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Removes all the y k c t_ entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of y k c t_ entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of y k c t_ entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of y k c t_ entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Returns the number of y k c t_ entries.
	*
	* @return the number of y k c t_ entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YKCT_EntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YKCT_EntryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.ykct.service.ClpSerializer.getServletContextName(),
					YKCT_EntryPersistence.class.getName());

			ReferenceRegistry.registerReference(YKCT_EntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(YKCT_EntryPersistence persistence) {
	}

	private static YKCT_EntryPersistence _persistence;
}