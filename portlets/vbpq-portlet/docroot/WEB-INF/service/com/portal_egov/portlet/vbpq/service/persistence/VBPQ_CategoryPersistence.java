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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.vbpq.model.VBPQ_Category;

/**
 * The persistence interface for the v b p q_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VBPQ_CategoryPersistenceImpl
 * @see VBPQ_CategoryUtil
 * @generated
 */
public interface VBPQ_CategoryPersistence extends BasePersistence<VBPQ_Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VBPQ_CategoryUtil} to access the v b p q_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the v b p q_ category in the entity cache if it is enabled.
	*
	* @param vbpq_Category the v b p q_ category
	*/
	public void cacheResult(
		com.portal_egov.portlet.vbpq.model.VBPQ_Category vbpq_Category);

	/**
	* Caches the v b p q_ categories in the entity cache if it is enabled.
	*
	* @param vbpq_Categories the v b p q_ categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> vbpq_Categories);

	/**
	* Creates a new v b p q_ category with the primary key. Does not add the v b p q_ category to the database.
	*
	* @param categoryId the primary key for the new v b p q_ category
	* @return the new v b p q_ category
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category create(
		long categoryId);

	/**
	* Removes the v b p q_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the v b p q_ category
	* @return the v b p q_ category that was removed
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	public com.portal_egov.portlet.vbpq.model.VBPQ_Category updateImpl(
		com.portal_egov.portlet.vbpq.model.VBPQ_Category vbpq_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the v b p q_ category with the primary key or throws a {@link com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the v b p q_ category
	* @return the v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the v b p q_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the v b p q_ category
	* @return the v b p q_ category, or <code>null</code> if a v b p q_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the v b p q_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category
	* @throws com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndCompany(
		long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndCompany_First(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndCompany_First(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndCompany_Last(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndCompany_Last(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByParentAndCompany_PrevAndNext(
		long categoryId, long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndGroup_First(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndGroup_First(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByParentAndGroup_Last(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByParentAndGroup_Last(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByParentAndGroup(
		long parentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndCompany(
		int typeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndCompany(
		int typeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndCompany(
		int typeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndCompany_First(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndCompany_First(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndCompany_Last(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndCompany_Last(
		int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByTypeAndCompany_PrevAndNext(
		long categoryId, int typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndGroup(
		int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndGroup(
		int typeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByTypeAndGroup(
		int typeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndGroup_First(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndGroup_First(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByTypeAndGroup_Last(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByTypeAndGroup_Last(
		int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByTypeAndGroup_PrevAndNext(
		long categoryId, int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByTypeAndGroup(
		int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByTypeAndGroup(
		int typeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByTypeAndGroup(
		int typeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, int typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndCompany(
		boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndCompany(
		boolean active, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndCompany(
		boolean active, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndCompany_First(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndCompany_Last(
		boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByStatusAndCompany_PrevAndNext(
		long categoryId, boolean active, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the first v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndGroup_First(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category findByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns the last v b p q_ category in the ordered set where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching v b p q_ category, or <code>null</code> if a matching v b p q_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category fetchByStatusAndGroup_Last(
		boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] findByStatusAndGroup_PrevAndNext(
		long categoryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByStatusAndGroup(
		boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> filterFindByStatusAndGroup(
		boolean active, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.vbpq.model.VBPQ_Category[] filterFindByStatusAndGroup_PrevAndNext(
		long categoryId, boolean active, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.vbpq.NoSuchVBPQ_CategoryException;

	/**
	* Returns all the v b p q_ categories.
	*
	* @return the v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where parentId = &#63; and companyId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where parentId = &#63; and groupId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where typeId = &#63; and companyId = &#63; from the database.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndCompany(int typeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where typeId = &#63; and groupId = &#63; from the database.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndGroup(int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where active = &#63; and companyId = &#63; from the database.
	*
	* @param active the active
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories where active = &#63; and groupId = &#63; from the database.
	*
	* @param active the active
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v b p q_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where typeId = &#63; and companyId = &#63;.
	*
	* @param typeId the type ID
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndCompany(int typeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndGroup(int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where typeId = &#63; and groupId = &#63;.
	*
	* @param typeId the type ID
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByTypeAndGroup(int typeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where active = &#63; and companyId = &#63;.
	*
	* @param active the active
	* @param companyId the company ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(boolean active, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories that the user has permission to view where active = &#63; and groupId = &#63;.
	*
	* @param active the active
	* @param groupId the group ID
	* @return the number of matching v b p q_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(boolean active, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of v b p q_ categories.
	*
	* @return the number of v b p q_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}