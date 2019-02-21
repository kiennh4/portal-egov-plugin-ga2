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

package com.portal_egov.portlet.citizen_inquiry.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;

/**
 * The persistence interface for the citizen inquiry category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryCategoryPersistenceImpl
 * @see CitizenInquiryCategoryUtil
 * @generated
 */
public interface CitizenInquiryCategoryPersistence extends BasePersistence<CitizenInquiryCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CitizenInquiryCategoryUtil} to access the citizen inquiry category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the citizen inquiry category in the entity cache if it is enabled.
	*
	* @param citizenInquiryCategory the citizen inquiry category
	*/
	public void cacheResult(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory);

	/**
	* Caches the citizen inquiry categories in the entity cache if it is enabled.
	*
	* @param citizenInquiryCategories the citizen inquiry categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> citizenInquiryCategories);

	/**
	* Creates a new citizen inquiry category with the primary key. Does not add the citizen inquiry category to the database.
	*
	* @param categoryId the primary key for the new citizen inquiry category
	* @return the new citizen inquiry category
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory create(
		long categoryId);

	/**
	* Removes the citizen inquiry category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category that was removed
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory updateImpl(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiry category with the primary key or throws a {@link com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns the citizen inquiry category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category, or <code>null</code> if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the citizen inquiry categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiry categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @return the range of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiry categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns the first citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns the last citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiry categories before and after the current citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current citizen inquiry category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns all the citizen inquiry categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiry categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @return the range of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiry categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns the first citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns the last citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiry categories before and after the current citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current citizen inquiry category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns all the citizen inquiry categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizen inquiry categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiry categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @return the range of matching citizen inquiry categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiry categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching citizen inquiry categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the citizen inquiry categories before and after the current citizen inquiry category in the ordered set of citizen inquiry categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current citizen inquiry category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException;

	/**
	* Returns all the citizen inquiry categories.
	*
	* @return the citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the citizen inquiry categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @return the range of citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the citizen inquiry categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of citizen inquiry categories
	* @param end the upper bound of the range of citizen inquiry categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiry categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiry categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the citizen inquiry categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiry categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiry categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiry categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizen inquiry categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of citizen inquiry categories.
	*
	* @return the number of citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}