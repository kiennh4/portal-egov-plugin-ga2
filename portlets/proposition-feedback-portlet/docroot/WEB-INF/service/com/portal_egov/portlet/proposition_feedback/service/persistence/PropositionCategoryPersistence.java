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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.proposition_feedback.model.PropositionCategory;

/**
 * The persistence interface for the proposition category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see PropositionCategoryPersistenceImpl
 * @see PropositionCategoryUtil
 * @generated
 */
public interface PropositionCategoryPersistence extends BasePersistence<PropositionCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PropositionCategoryUtil} to access the proposition category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the proposition category in the entity cache if it is enabled.
	*
	* @param propositionCategory the proposition category
	*/
	public void cacheResult(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory);

	/**
	* Caches the proposition categories in the entity cache if it is enabled.
	*
	* @param propositionCategories the proposition categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> propositionCategories);

	/**
	* Creates a new proposition category with the primary key. Does not add the proposition category to the database.
	*
	* @param categoryId the primary key for the new proposition category
	* @return the new proposition category
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory create(
		long categoryId);

	/**
	* Removes the proposition category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category that was removed
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory updateImpl(
		com.portal_egov.portlet.proposition_feedback.model.PropositionCategory propositionCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposition category with the primary key or throws a {@link com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the proposition category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the proposition category
	* @return the proposition category, or <code>null</code> if a proposition category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the proposition categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category
	* @throws com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndCompany(
		long companyId, int categoryTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndCompany_First(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndCompany_First(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndCompany_Last(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndCompany_Last(
		long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByTypeAndCompany_PrevAndNext(
		long categoryId, long companyId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndGroup_First(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndGroup_First(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByTypeAndGroup_Last(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByTypeAndGroup_Last(
		long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByTypeAndGroup_PrevAndNext(
		long categoryId, long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByTypeAndGroup(
		long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByTypeAndGroup(
		long groupId, int categoryTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, long groupId, int categoryTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndCompany(
		long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the first proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndCompany_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the last proposition category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndCompany_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByParentAndCompany_PrevAndNext(
		long categoryId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the first proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndGroup_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory findByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns the last proposition category in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposition category, or <code>null</code> if a matching proposition category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory fetchByParentAndGroup_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] findByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByParentAndGroup(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> filterFindByParentAndGroup(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.proposition_feedback.model.PropositionCategory[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.proposition_feedback.NoSuchPropositionCategoryException;

	/**
	* Returns all the proposition categories.
	*
	* @return the proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories where companyId = &#63; and categoryTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndCompany(long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories where groupId = &#63; and categoryTypeId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories where companyId = &#63; and parentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposition categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories where companyId = &#63; and categoryTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param categoryTypeId the category type ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndCompany(long companyId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories that the user has permission to view where groupId = &#63; and categoryTypeId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryTypeId the category type ID
	* @return the number of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByTypeAndGroup(long groupId, int categoryTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndCompany(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories that the user has permission to view where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching proposition categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentAndGroup(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposition categories.
	*
	* @return the number of proposition categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}