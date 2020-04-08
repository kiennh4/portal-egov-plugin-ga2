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

package com.portal_egov.portlet.conversation.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.conversation.model.CO_Category;

import java.util.List;

/**
 * The persistence utility for the c o_ category service. This utility wraps {@link CO_CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_CategoryPersistence
 * @see CO_CategoryPersistenceImpl
 * @generated
 */
public class CO_CategoryUtil {
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
	public static void clearCache(CO_Category co_Category) {
		getPersistence().clearCache(co_Category);
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
	public static List<CO_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CO_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CO_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CO_Category update(CO_Category co_Category, boolean merge)
		throws SystemException {
		return getPersistence().update(co_Category, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CO_Category update(CO_Category co_Category, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(co_Category, merge, serviceContext);
	}

	/**
	* Caches the c o_ category in the entity cache if it is enabled.
	*
	* @param co_Category the c o_ category
	*/
	public static void cacheResult(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category) {
		getPersistence().cacheResult(co_Category);
	}

	/**
	* Caches the c o_ categories in the entity cache if it is enabled.
	*
	* @param co_Categories the c o_ categories
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> co_Categories) {
		getPersistence().cacheResult(co_Categories);
	}

	/**
	* Creates a new c o_ category with the primary key. Does not add the c o_ category to the database.
	*
	* @param categoryId the primary key for the new c o_ category
	* @return the new c o_ category
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the c o_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category that was removed
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Category updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(co_Category, merge);
	}

	/**
	* Returns the c o_ category with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the c o_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category, or <code>null</code> if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the c o_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the c o_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the c o_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the c o_ categories before and after the current c o_ category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current c o_ category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the c o_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the c o_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the c o_ categories before and after the current c o_ category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current c o_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the c o_ categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the c o_ categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the c o_ categories before and after the current c o_ category in the ordered set of c o_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current c o_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentCategoryId);
	}

	/**
	* Returns a range of all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentCategoryId, start,
			end);
	}

	/**
	* Returns an ordered range of all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentCategoryId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByParentAndCompany_First(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByParentAndCompany_First(companyId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndCompany_First(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_First(companyId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByParentAndCompany_Last(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByParentAndCompany_Last(companyId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndCompany_Last(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_Last(companyId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the c o_ categories before and after the current c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param categoryId the primary key of the current c o_ category
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category[] findByParentAndCompany_PrevAndNext(
		long categoryId, long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByParentAndCompany_PrevAndNext(categoryId, companyId,
			parentCategoryId, orderByComparator);
	}

	/**
	* Returns all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndGroup(groupId, parentCategoryId);
	}

	/**
	* Returns a range of all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(groupId, parentCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(groupId, parentCategoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByParentAndGroup_First(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByParentAndGroup_First(groupId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndGroup_First(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_First(groupId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category findByParentAndGroup_Last(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByParentAndGroup_Last(groupId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndGroup_Last(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_Last(groupId, parentCategoryId,
			orderByComparator);
	}

	/**
	* Returns the c o_ categories before and after the current c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param categoryId the primary key of the current c o_ category
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category[] findByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .findByParentAndGroup_PrevAndNext(categoryId, groupId,
			parentCategoryId, orderByComparator);
	}

	/**
	* Returns all the c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByParentAndGroup(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentCategoryId);
	}

	/**
	* Returns a range of all the c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentCategoryId,
			start, end);
	}

	/**
	* Returns an ordered range of all the c o_ categories that the user has permissions to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentCategoryId,
			start, end, orderByComparator);
	}

	/**
	* Returns the c o_ categories before and after the current c o_ category in the ordered set of c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param categoryId the primary key of the current c o_ category
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException {
		return getPersistence()
				   .filterFindByParentAndGroup_PrevAndNext(categoryId, groupId,
			parentCategoryId, orderByComparator);
	}

	/**
	* Returns all the c o_ categories.
	*
	* @return the c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the c o_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @return the range of c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the c o_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ categories
	* @param end the upper bound of the range of c o_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the c o_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the c o_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the c o_ categories where companyId = &#63; and parentCategoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndCompany(long companyId,
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndCompany(companyId, parentCategoryId);
	}

	/**
	* Removes all the c o_ categories where groupId = &#63; and parentCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndGroup(long groupId,
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndGroup(groupId, parentCategoryId);
	}

	/**
	* Removes all the c o_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c o_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of c o_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of c o_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndCompany(long companyId,
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentAndCompany(companyId, parentCategoryId);
	}

	/**
	* Returns the number of c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndGroup(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndGroup(groupId, parentCategoryId);
	}

	/**
	* Returns the number of c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the number of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParentAndGroup(long groupId,
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByParentAndGroup(groupId, parentCategoryId);
	}

	/**
	* Returns the number of c o_ categories.
	*
	* @return the number of c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CO_CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CO_CategoryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.conversation.service.ClpSerializer.getServletContextName(),
					CO_CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CO_CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CO_CategoryPersistence persistence) {
	}

	private static CO_CategoryPersistence _persistence;
}