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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.ykct.model.YKCT_Category;

/**
 * The persistence interface for the y k c t_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see YKCT_CategoryPersistenceImpl
 * @see YKCT_CategoryUtil
 * @generated
 */
public interface YKCT_CategoryPersistence extends BasePersistence<YKCT_Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YKCT_CategoryUtil} to access the y k c t_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the y k c t_ category in the entity cache if it is enabled.
	*
	* @param ykct_Category the y k c t_ category
	*/
	public void cacheResult(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category);

	/**
	* Caches the y k c t_ categories in the entity cache if it is enabled.
	*
	* @param ykct_Categories the y k c t_ categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> ykct_Categories);

	/**
	* Creates a new y k c t_ category with the primary key. Does not add the y k c t_ category to the database.
	*
	* @param categoryId the primary key for the new y k c t_ category
	* @return the new y k c t_ category
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category create(
		long categoryId);

	/**
	* Removes the y k c t_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category that was removed
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	public com.portal_egov.portlet.ykct.model.YKCT_Category updateImpl(
		com.portal_egov.portlet.ykct.model.YKCT_Category ykct_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the y k c t_ category with the primary key or throws a {@link com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns the y k c t_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the y k c t_ category
	* @return the y k c t_ category, or <code>null</code> if a y k c t_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the y k c t_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns the first y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns the last y k c t_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.ykct.model.YKCT_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns all the y k c t_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns the first y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category
	* @throws com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns the last y k c t_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y k c t_ category, or <code>null</code> if a matching y k c t_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.ykct.model.YKCT_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.ykct.model.YKCT_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.ykct.NoSuchYKCT_CategoryException;

	/**
	* Returns all the y k c t_ categories.
	*
	* @return the y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y k c t_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y k c t_ categories.
	*
	* @return the number of y k c t_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}