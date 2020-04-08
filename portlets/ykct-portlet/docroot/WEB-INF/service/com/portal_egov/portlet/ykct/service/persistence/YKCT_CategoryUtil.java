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

import com.portal_egov.portlet.ykct.model.YKCT_Category;

import java.util.List;

/**
 * The persistence utility for the y k c t_ category service. This utility wraps {@link YKCT_CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_CategoryPersistence
 * @see YKCT_CategoryPersistenceImpl
 * @generated
 */
public class YKCT_CategoryUtil {
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
	public static void clearCache(YKCT_Category ykct_Category) {
		getPersistence().clearCache(ykct_Category);
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
	public static List<YKCT_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YKCT_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YKCT_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static YKCT_Category update(YKCT_Category ykct_Category,
		boolean merge) throws SystemException {
		return getPersistence().update(ykct_Category, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static YKCT_Category update(YKCT_Category ykct_Category,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ykct_Category, merge, serviceContext);
	}

	/**
	* Caches the y k c t_ category in the entity cache if it is enabled.
	*
	* @param ykct_Category the y k c t_ category
	*/
	public static void cacheResult(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category) {
		getPersistence().cacheResult(ykct_Category);
	}

	/**
	* Caches the y k c t_ categories in the entity cache if it is enabled.
	*
	* @param ykct_Categories the y k c t_ categories
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> ykct_Categories) {
		getPersistence().cacheResult(ykct_Categories);
	}

	/**
	* Creates a new y k c t_ category with the primary key. Does not add the y k c t_ category to the database.
	*
	* @param categoryId the primary key for the new y k c t_ category
	* @return the new y k c t_ category
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the y k c t_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category that was removed
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.portal_egov.portlet.ykct.model.YKCT_Category updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ykct_Category, merge);
	}

	/**
	* Returns the y k c t_ category with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the y k c t_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category, or <code>null</code> if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the y k c t_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the y k c t_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @return the range of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the y k c t_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the y k c t_ categories before and after the current y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current y k c t_ category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the y k c t_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the y k c t_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @return the range of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the y k c t_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the y k c t_ categories before and after the current y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current y k c t_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.ykct.model.YKCT_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the y k c t_ categories.
	*
	* @return the y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the y k c t_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @return the range of y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the y k c t_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y k c t_ categories
	* @param end the upper bound of the range of y k c t_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the y k c t_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the y k c t_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the y k c t_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of y k c t_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of y k c t_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of y k c t_ categories.
	*
	* @return the number of y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YKCT_CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YKCT_CategoryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.ykct.service.ClpSerializer.getServletContextName(),
					YKCT_CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(YKCT_CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(YKCT_CategoryPersistence persistence) {
	}

	private static YKCT_CategoryPersistence _persistence;
}