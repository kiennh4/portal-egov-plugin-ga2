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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;

/**
 * The persistence interface for the legal f a q category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LegalFAQCategoryPersistenceImpl
 * @see LegalFAQCategoryUtil
 * @generated
 */
public interface LegalFAQCategoryPersistence extends BasePersistence<LegalFAQCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalFAQCategoryUtil} to access the legal f a q category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the legal f a q category in the entity cache if it is enabled.
	*
	* @param legalFAQCategory the legal f a q category
	*/
	public void cacheResult(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory);

	/**
	* Caches the legal f a q categories in the entity cache if it is enabled.
	*
	* @param legalFAQCategories the legal f a q categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> legalFAQCategories);

	/**
	* Creates a new legal f a q category with the primary key. Does not add the legal f a q category to the database.
	*
	* @param categoryId the primary key for the new legal f a q category
	* @return the new legal f a q category
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory create(
		long categoryId);

	/**
	* Removes the legal f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category that was removed
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory updateImpl(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q category with the primary key or throws a {@link com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the legal f a q category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the legal f a q category
	* @return the legal f a q category, or <code>null</code> if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legal f a q categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the first legal f a q category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the last legal f a q category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q categories before and after the current legal f a q category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current legal f a q category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns all the legal f a q categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the first legal f a q category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the last legal f a q category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q categories before and after the current legal f a q category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current legal f a q category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns all the legal f a q categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching legal f a q categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of matching legal f a q categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q categories before and after the current legal f a q category in the ordered set of legal f a q categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current legal f a q category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns all the legal f a q categories where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q categories where companyId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q categories where companyId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findByParent(
		long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByParent_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the first legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByParent_First(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory findByParent_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns the last legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legal f a q category, or <code>null</code> if a matching legal f a q category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory fetchByParent_Last(
		long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legal f a q categories before and after the current legal f a q category in the ordered set where companyId = &#63; and parentId = &#63;.
	*
	* @param categoryId the primary key of the current legal f a q category
	* @param companyId the company ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legal f a q category
	* @throws com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException if a legal f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory[] findByParent_PrevAndNext(
		long categoryId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.legal_faq.NoSuchLegalFAQCategoryException;

	/**
	* Returns all the legal f a q categories.
	*
	* @return the legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legal f a q categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @return the range of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legal f a q categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of legal f a q categories
	* @param end the upper bound of the range of legal f a q categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q categories where companyId = &#63; and parentId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParent(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legal f a q categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching legal f a q categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q categories where companyId = &#63; and parentId = &#63;.
	*
	* @param companyId the company ID
	* @param parentId the parent ID
	* @return the number of matching legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParent(long companyId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legal f a q categories.
	*
	* @return the number of legal f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}