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

import com.portal_egov.portlet.vbpq.model.VBPQ_Category;

import java.util.List;

/**
 * The persistence utility for the v b p q_ category service. This utility wraps {@link VBPQ_CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_CategoryPersistence
 * @see VBPQ_CategoryPersistenceImpl
 * @generated
 */
public class VBPQ_CategoryUtil {
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
	public static void clearCache(VBPQ_Category vbpq_Category) {
		getPersistence().clearCache(vbpq_Category);
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
	public static List<VBPQ_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VBPQ_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VBPQ_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VBPQ_Category update(VBPQ_Category vbpq_Category,
		boolean merge) throws SystemException {
		return getPersistence().update(vbpq_Category, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VBPQ_Category update(VBPQ_Category vbpq_Category,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vbpq_Category, merge, serviceContext);
	}

	/**
	* Caches the v b p q_ category in the entity cache if it is enabled.
	*
	* @param vbpq_Category the v b p q_ category
	*/
	public static void cacheResult(
		com.portal_egov.portlet.vbpq.model.VBPQ_Category vbpq_Category) {
		getPersistence().cacheResult(vbpq_Category);
	}

	/**
	* Caches the v b p q_ categories in the entity cache if it is enabled.
	*
	* @param vbpq_Categories the v b p q_ categories
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> vbpq_Categories) {
		getPersistence().cacheResult(vbpq_Categories);
	}

	/**
	* Creates a new v b p q_ category with the primary key. Does not add the v b p q_ category to the database.
	*
	* @param categoryId the primary key for the new v b p q_ category
	* @return the new v b p q_ category
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the v b p q_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the v b p q_ category
	* @return the v b p q_ category that was removed
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_Category vbpq_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vbpq_Category, merge);
	}

	/**
	* Returns the v b p q_ category with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the v b p q_ category
	* @return the v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the v b p q_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the v b p q_ category
	* @return the v b p q_ category, or <code>null</code> if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the v b p q_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the v b p q_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndCompany(
		long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndCompany(parentId, companyId);
	}

	/**
	* Returns a range of all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(parentId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(parentId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndCompany_First(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByParentAndCompany_First(parentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndCompany_First(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_First(parentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndCompany_Last(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByParentAndCompany_Last(parentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndCompany_Last(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_Last(parentId, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByParentAndCompany_PrevAndNext(
		long categoryId, long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByParentAndCompany_PrevAndNext(categoryId, parentId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndGroup(parentId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(parentId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(parentId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndGroup_First(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByParentAndGroup_First(parentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndGroup_First(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_First(parentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndGroup_Last(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByParentAndGroup_Last(parentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndGroup_Last(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_Last(parentId, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByParentAndGroup_PrevAndNext(categoryId, parentId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByParentAndGroup(parentId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(parentId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories that the user has permissions to view where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByParentAndGroup(
		long parentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(parentId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .filterFindByParentAndGroup_PrevAndNext(categoryId,
			parentId, groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndCompany(
		int typeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndCompany(typeId, companyId);
	}

	/**
	* Returns a range of all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndCompany(
		int typeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndCompany(typeId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndCompany(
		int typeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndCompany(typeId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndCompany_First(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByTypeAndCompany_First(typeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndCompany_First(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndCompany_First(typeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndCompany_Last(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByTypeAndCompany_Last(typeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndCompany_Last(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndCompany_Last(typeId, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByTypeAndCompany_PrevAndNext(
		long categoryId, int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByTypeAndCompany_PrevAndNext(categoryId, typeId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndGroup(
		int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndGroup(typeId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndGroup(
		int typeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndGroup(typeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndGroup(
		int typeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndGroup(typeId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndGroup_First(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByTypeAndGroup_First(typeId, groupId, orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndGroup_First(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndGroup_First(typeId, groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndGroup_Last(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByTypeAndGroup_Last(typeId, groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndGroup_Last(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndGroup_Last(typeId, groupId, orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByTypeAndGroup_PrevAndNext(
		long categoryId, int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByTypeAndGroup_PrevAndNext(categoryId, typeId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByTypeAndGroup(
		int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByTypeAndGroup(typeId, groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByTypeAndGroup(
		int typeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTypeAndGroup(typeId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories that the user has permissions to view where typeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByTypeAndGroup(
		int typeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTypeAndGroup(typeId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .filterFindByTypeAndGroup_PrevAndNext(categoryId, typeId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndCompany(
		boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndCompany(active, companyId);
	}

	/**
	* Returns a range of all the v b p q_ categories where active = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndCompany(
		boolean active, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(active, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where active = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param companyId the company ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndCompany(
		boolean active, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(active, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByStatusAndCompany_First(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByStatusAndCompany_Last(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(active, companyId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByStatusAndCompany_PrevAndNext(
		long categoryId, boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(categoryId, active,
			companyId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(active, groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(active, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(active, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByStatusAndGroup_First(active, groupId,
			orderByComparator);
	}

	/**
	* Returns the first v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(active, groupId,
			orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByStatusAndGroup_Last(active, groupId, orderByComparator);
	}

	/**
	* Returns the last v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(active, groupId,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByStatusAndGroup_PrevAndNext(
		long categoryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(categoryId, active,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatusAndGroup(active, groupId);
	}

	/**
	* Returns a range of all the v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(active, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories that the user has permissions to view where active = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param active the active
	* @param groupId the group ID
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(active, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the v b p q_ categories before and after the current v b p q_ category in the ordered set of v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current v b p q_ category
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByStatusAndGroup_PrevAndNext(
		long categoryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(categoryId, active,
			groupId, orderByComparator);
	}

	/**
	* Returns all the v b p q_ categories.
	*
	* @return the v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the v b p q_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @return the range of v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the v b p q_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v b p q_ categories
	* @param end the upper bound of the range of v b p q_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the v b p q_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the v b p q_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the v b p q_ categories where parentId = &#63; and companyId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndCompany(parentId, companyId);
	}

	/**
	* Removes all the v b p q_ categories where parentId = &#63; and groupId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndGroup(parentId, groupId);
	}

	/**
	* Removes all the v b p q_ categories where typeId = &#63; and companyId = &#63; from the database.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndCompany(int typeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeAndCompany(typeId, companyId);
	}

	/**
	* Removes all the v b p q_ categories where typeId = &#63; and groupId = &#63; from the database.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndGroup(int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeAndGroup(typeId, groupId);
	}

	/**
	* Removes all the v b p q_ categories where active = &#63; and companyId = &#63; from the database.
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
	* Removes all the v b p q_ categories where active = &#63; and groupId = &#63; from the database.
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
	* Removes all the v b p q_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of v b p q_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of v b p q_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of v b p q_ categories where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndCompany(parentId, companyId);
	}

	/**
	* Returns the number of v b p q_ categories where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndGroup(parentId, groupId);
	}

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByParentAndGroup(parentId, groupId);
	}

	/**
	* Returns the number of v b p q_ categories where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndCompany(int typeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeAndCompany(typeId, companyId);
	}

	/**
	* Returns the number of v b p q_ categories where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndGroup(int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeAndGroup(typeId, groupId);
	}

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByTypeAndGroup(int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByTypeAndGroup(typeId, groupId);
	}

	/**
	* Returns the number of v b p q_ categories where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndCompany(active, companyId);
	}

	/**
	* Returns the number of v b p q_ categories where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(active, groupId);
	}

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatusAndGroup(active, groupId);
	}

	/**
	* Returns the number of v b p q_ categories.
	*
	* @return the number of v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VBPQ_CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VBPQ_CategoryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.vbpq.service.ClpSerializer.getServletContextName(),
					VBPQ_CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(VBPQ_CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VBPQ_CategoryPersistence persistence) {
	}

	private static VBPQ_CategoryPersistence _persistence;
}