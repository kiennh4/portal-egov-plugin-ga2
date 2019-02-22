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

package com.portal_egov.portlet.tthc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.tthc.model.TTHC_Category;

/**
 * The persistence interface for the t t h c_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TTHC_CategoryPersistenceImpl
 * @see TTHC_CategoryUtil
 * @generated
 */
public interface TTHC_CategoryPersistence extends BasePersistence<TTHC_Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTHC_CategoryUtil} to access the t t h c_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the t t h c_ category in the entity cache if it is enabled.
	*
	* @param tthc_Category the t t h c_ category
	*/
	public void cacheResult(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category);

	/**
	* Caches the t t h c_ categories in the entity cache if it is enabled.
	*
	* @param tthc_Categories the t t h c_ categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> tthc_Categories);

	/**
	* Creates a new t t h c_ category with the primary key. Does not add the t t h c_ category to the database.
	*
	* @param categoryId the primary key for the new t t h c_ category
	* @return the new t t h c_ category
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category create(
		long categoryId);

	/**
	* Removes the t t h c_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the t t h c_ category
	* @return the t t h c_ category that was removed
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	public com.portal_egov.portlet.tthc.model.TTHC_Category updateImpl(
		com.portal_egov.portlet.tthc.model.TTHC_Category tthc_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ category with the primary key or throws a {@link com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the t t h c_ category
	* @return the t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the t t h c_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the t t h c_ category
	* @return the t t h c_ category, or <code>null</code> if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t t h c_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the first t t h c_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the last t t h c_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the first t t h c_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the last t t h c_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set of t t h c_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @return the matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndCompany(
		long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories where parentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories where parentId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndCompany(
		long parentId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByParentAndCompany_First(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the first t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByParentAndCompany_First(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByParentAndCompany_Last(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the last t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByParentAndCompany_Last(
		long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where parentId = &#63; and companyId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param parentId the parent ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] findByParentAndCompany_PrevAndNext(
		long categoryId, long parentId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByParentAndGroup(
		long parentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByParentAndGroup_First(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the first t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByParentAndGroup_First(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByParentAndGroup_Last(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the last t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByParentAndGroup_Last(
		long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where parentId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] findByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByParentAndGroup(
		long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByParentAndGroup(
		long parentId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories that the user has permissions to view where parentId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByParentAndGroup(
		long parentId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set of t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param parentId the parent ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long parentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @return the matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndCompany(
		int categoryTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndCompany(
		int categoryTypeId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndCompany(
		int categoryTypeId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByTypeAndCompany_First(
		int categoryTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByTypeAndCompany_First(
		int categoryTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByTypeAndCompany_Last(
		int categoryTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByTypeAndCompany_Last(
		int categoryTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] findByTypeAndCompany_PrevAndNext(
		long categoryId, int categoryTypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @return the matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndGroup(
		int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndGroup(
		int categoryTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findByTypeAndGroup(
		int categoryTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByTypeAndGroup_First(
		int categoryTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the first t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByTypeAndGroup_First(
		int categoryTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category findByTypeAndGroup_Last(
		int categoryTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns the last t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c_ category, or <code>null</code> if a matching t t h c_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category fetchByTypeAndGroup_Last(
		int categoryTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] findByTypeAndGroup_PrevAndNext(
		long categoryId, int categoryTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @return the matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByTypeAndGroup(
		int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByTypeAndGroup(
		int categoryTypeId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories that the user has permissions to view where categoryTypeId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> filterFindByTypeAndGroup(
		int categoryTypeId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c_ categories before and after the current t t h c_ category in the ordered set of t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryId the primary key of the current t t h c_ category
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c_ category
	* @throws com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException if a t t h c_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tthc.model.TTHC_Category[] filterFindByTypeAndGroup_PrevAndNext(
		long categoryId, int categoryTypeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tthc.NoSuchTTHC_CategoryException;

	/**
	* Returns all the t t h c_ categories.
	*
	* @return the t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @return the range of t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c_ categories
	* @param end the upper bound of the range of t t h c_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories where parentId = &#63; and companyId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories where parentId = &#63; and groupId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories where categoryTypeId = &#63; and companyId = &#63; from the database.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndCompany(int categoryTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories where categoryTypeId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndGroup(int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories where parentId = &#63; and companyId = &#63;.
	*
	* @param parentId the parent ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndCompany(long parentId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories that the user has permission to view where parentId = &#63; and groupId = &#63;.
	*
	* @param parentId the parent ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentAndGroup(long parentId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories where categoryTypeId = &#63; and companyId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param companyId the company ID
	* @return the number of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndCompany(int categoryTypeId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndGroup(int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories that the user has permission to view where categoryTypeId = &#63; and groupId = &#63;.
	*
	* @param categoryTypeId the category type ID
	* @param groupId the group ID
	* @return the number of matching t t h c_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByTypeAndGroup(int categoryTypeId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c_ categories.
	*
	* @return the number of t t h c_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}