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

package com.portal_egov.portlet.weblinks.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.weblinks.model.WeblinkCategory;

/**
 * The persistence interface for the weblink category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see WeblinkCategoryPersistenceImpl
 * @see WeblinkCategoryUtil
 * @generated
 */
public interface WeblinkCategoryPersistence extends BasePersistence<WeblinkCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WeblinkCategoryUtil} to access the weblink category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the weblink category in the entity cache if it is enabled.
	*
	* @param weblinkCategory the weblink category
	*/
	public void cacheResult(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory);

	/**
	* Caches the weblink categories in the entity cache if it is enabled.
	*
	* @param weblinkCategories the weblink categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> weblinkCategories);

	/**
	* Creates a new weblink category with the primary key. Does not add the weblink category to the database.
	*
	* @param categoryId the primary key for the new weblink category
	* @return the new weblink category
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory create(
		long categoryId);

	/**
	* Removes the weblink category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the weblink category
	* @return the weblink category that was removed
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	public com.portal_egov.portlet.weblinks.model.WeblinkCategory updateImpl(
		com.portal_egov.portlet.weblinks.model.WeblinkCategory weblinkCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the weblink category with the primary key or throws a {@link com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the weblink category
	* @return the weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns the weblink category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the weblink category
	* @return the weblink category, or <code>null</code> if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the weblink categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the weblink categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @return the range of matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the weblink categories where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first weblink category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns the first weblink category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink category, or <code>null</code> if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last weblink category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns the last weblink category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink category, or <code>null</code> if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the weblink categories before and after the current weblink category in the ordered set where companyId = &#63;.
	*
	* @param categoryId the primary key of the current weblink category
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns all the weblink categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the weblink categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @return the range of matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the weblink categories where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first weblink category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns the first weblink category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching weblink category, or <code>null</code> if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last weblink category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns the last weblink category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching weblink category, or <code>null</code> if a matching weblink category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the weblink categories before and after the current weblink category in the ordered set where groupId = &#63;.
	*
	* @param categoryId the primary key of the current weblink category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns all the weblink categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching weblink categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the weblink categories that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @return the range of matching weblink categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the weblink categories that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching weblink categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the weblink categories before and after the current weblink category in the ordered set of weblink categories that the user has permission to view where groupId = &#63;.
	*
	* @param categoryId the primary key of the current weblink category
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next weblink category
	* @throws com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException if a weblink category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.weblinks.model.WeblinkCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.weblinks.NoSuchWeblinkCategoryException;

	/**
	* Returns all the weblink categories.
	*
	* @return the weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the weblink categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @return the range of weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the weblink categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of weblink categories
	* @param end the upper bound of the range of weblink categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.weblinks.model.WeblinkCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblink categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblink categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the weblink categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblink categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblink categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblink categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching weblink categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of weblink categories.
	*
	* @return the number of weblink categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}