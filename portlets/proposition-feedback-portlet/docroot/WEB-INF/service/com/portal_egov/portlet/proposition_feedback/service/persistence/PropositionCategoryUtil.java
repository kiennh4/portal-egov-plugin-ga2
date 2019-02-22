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

package com.portal_egov.portlet.proposition_feedback.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;

import java.util.List;

/**
 * The persistence utility for the proposition category service. This utility wraps {@link PropositionCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionCategoryPersistence
 * @see PropositionCategoryPersistenceImpl
 * @generated
 */
public class PropositionCategoryUtil {
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
	public static void clearCache(PropositionCategory propositionCategory) {
		getPersistence().clearCache(propositionCategory);
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
	public static List<PropositionCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PropositionCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PropositionCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PropositionCategory update(
		PropositionCategory propositionCategory, boolean merge)
		throws SystemException {
		return getPersistence().update(propositionCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PropositionCategory update(
		PropositionCategory propositionCategory, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(propositionCategory, merge, serviceContext);
	}

	/**
	* Caches the proposition category in the entity cache if it is enabled.
	*
	* @param propositionCategory the proposition category
	*/
	public static void cacheResult(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory) {
		getPersistence().cacheResult(propositionCategory);
	}

	/**
	* Caches the proposition categories in the entity cache if it is enabled.
	*
	* @param propositionCategories the proposition categories
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> propositionCategories) {
		getPersistence().cacheResult(propositionCategories);
	}

	/**
	* Creates a new proposition category with the primary key. Does not add the proposition category to the database.
	*
	* @param categoryId the primary key for the new proposition category
	* @return the new proposition category
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the proposition category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category that was removed
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(propositionCategory, merge);
	}

	/**
	* Returns the proposition category with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the proposition category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category, or <code>null</code> if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the proposition categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the proposition categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the proposition categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the proposition categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the proposition categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the proposition categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set of proposition categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndCompany(companyId, categoryTypeId);
	}

	/**
	* Returns a range of all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndCompany(companyId, categoryTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndCompany(companyId, categoryTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndCompany_First(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByTypeAndCompany_First(companyId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndCompany_First(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndCompany_First(companyId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndCompany_Last(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByTypeAndCompany_Last(companyId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndCompany_Last(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndCompany_Last(companyId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByTypeAndCompany_PrevAndNext(
		long categoryId, long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByTypeAndCompany_PrevAndNext(categoryId, companyId,
			categoryTypeId, orderByComparator);
	}

	/**
	* Returns all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypeAndGroup(groupId, categoryTypeId);
	}

	/**
	* Returns a range of all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndGroup(groupId, categoryTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndGroup(groupId, categoryTypeId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndGroup_First(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByTypeAndGroup_First(groupId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndGroup_First(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndGroup_First(groupId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndGroup_Last(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByTypeAndGroup_Last(groupId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndGroup_Last(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndGroup_Last(groupId, categoryTypeId,
			orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByTypeAndGroup_PrevAndNext(
		long categoryId, long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByTypeAndGroup_PrevAndNext(categoryId, groupId,
			categoryTypeId, orderByComparator);
	}

	/**
	* Returns all the proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByTypeAndGroup(
		long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByTypeAndGroup(groupId, categoryTypeId);
	}

	/**
	* Returns a range of all the proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTypeAndGroup(groupId, categoryTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories that the user has permissions to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByTypeAndGroup(groupId, categoryTypeId, start,
			end, orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set of proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .filterFindByTypeAndGroup_PrevAndNext(categoryId, groupId,
			categoryTypeId, orderByComparator);
	}

	/**
	* Returns all the proposition categories where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndCompany(companyId, parentId);
	}

	/**
	* Returns a range of all the proposition categories where companyId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories where companyId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndCompany(companyId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByParentAndCompany_First(companyId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_First(companyId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByParentAndCompany_Last(companyId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndCompany_Last(companyId, parentId,
			orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByParentAndCompany_PrevAndNext(
		long categoryId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByParentAndCompany_PrevAndNext(categoryId, companyId,
			parentId, orderByComparator);
	}

	/**
	* Returns all the proposition categories where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentAndGroup(groupId, parentId);
	}

	/**
	* Returns a range of all the proposition categories where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(groupId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentAndGroup(groupId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByParentAndGroup_First(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_First(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByParentAndGroup_Last(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentAndGroup_Last(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .findByParentAndGroup_PrevAndNext(categoryId, groupId,
			parentId, orderByComparator);
	}

	/**
	* Returns all the proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByParentAndGroup(groupId, parentId);
	}

	/**
	* Returns a range of all the proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories that the user has permissions to view where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentAndGroup(groupId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the proposition categories before and after the current proposition category in the ordered set of proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param categoryId the primary key of the current proposition category
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException {
		return getPersistence()
				   .filterFindByParentAndGroup_PrevAndNext(categoryId, groupId,
			parentId, orderByComparator);
	}

	/**
	* Returns all the proposition categories.
	*
	* @return the proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the proposition categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @return the range of proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the proposition categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of proposition categories
	* @param end the upper bound of the range of proposition categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the proposition categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the proposition categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the proposition categories where companyId = &#63; and categoryTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndCompany(long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeAndCompany(companyId, categoryTypeId);
	}

	/**
	* Removes all the proposition categories where groupId = &#63; and categoryTypeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypeAndGroup(groupId, categoryTypeId);
	}

	/**
	* Removes all the proposition categories where companyId = &#63; and parentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndCompany(companyId, parentId);
	}

	/**
	* Removes all the proposition categories where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentAndGroup(groupId, parentId);
	}

	/**
	* Removes all the proposition categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of proposition categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of proposition categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of proposition categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndCompany(long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeAndCompany(companyId, categoryTypeId);
	}

	/**
	* Returns the number of proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypeAndGroup(groupId, categoryTypeId);
	}

	/**
	* Returns the number of proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the number of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByTypeAndGroup(groupId, categoryTypeId);
	}

	/**
	* Returns the number of proposition categories where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndCompany(companyId, parentId);
	}

	/**
	* Returns the number of proposition categories where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentAndGroup(groupId, parentId);
	}

	/**
	* Returns the number of proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByParentAndGroup(groupId, parentId);
	}

	/**
	* Returns the number of proposition categories.
	*
	* @return the number of proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PropositionCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PropositionCategoryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.proposition_feedback.service.ClpSerializer.getServletContextName(),
					PropositionCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(PropositionCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PropositionCategoryPersistence persistence) {
	}

	private static PropositionCategoryPersistence _persistence;
}