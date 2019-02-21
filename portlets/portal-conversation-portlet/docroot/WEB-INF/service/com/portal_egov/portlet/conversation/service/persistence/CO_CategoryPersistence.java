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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.conversation.model.CO_Category;

/**
 * The persistence interface for the c o_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_CategoryPersistenceImpl
 * @see CO_CategoryUtil
 * @generated
 */
public interface CO_CategoryPersistence extends BasePersistence<CO_Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CO_CategoryUtil} to access the c o_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the c o_ category in the entity cache if it is enabled.
	*
	* @param co_Category the c o_ category
	*/
	public void cacheResult(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category);

	/**
	* Caches the c o_ categories in the entity cache if it is enabled.
	*
	* @param co_Categories the c o_ categories
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> co_Categories);

	/**
	* Creates a new c o_ category with the primary key. Does not add the c o_ category to the database.
	*
	* @param categoryId the primary key for the new c o_ category
	* @return the new c o_ category
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category create(
		long categoryId);

	/**
	* Removes the c o_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category that was removed
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	public com.portal_egov.portlet.conversation.model.CO_Category updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Category co_Category,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ category with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_CategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the c o_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the c o_ category
	* @return the c o_ category, or <code>null</code> if a c o_ category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c o_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns all the c o_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_CategoryException if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns all the c o_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns all the c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndCompany(
		long companyId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category findByParentAndCompany_First(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the first c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndCompany_First(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category findByParentAndCompany_Last(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the last c o_ category in the ordered set where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndCompany_Last(
		long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category[] findByParentAndCompany_PrevAndNext(
		long categoryId, long companyId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns all the c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category findByParentAndGroup_First(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the first c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndGroup_First(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category findByParentAndGroup_Last(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns the last c o_ category in the ordered set where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ category, or <code>null</code> if a matching c o_ category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Category fetchByParentAndGroup_Last(
		long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category[] findByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns all the c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByParentAndGroup(
		long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> filterFindByParentAndGroup(
		long groupId, long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.conversation.model.CO_Category[] filterFindByParentAndGroup_PrevAndNext(
		long categoryId, long groupId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_CategoryException;

	/**
	* Returns all the c o_ categories.
	*
	* @return the c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ categories where companyId = &#63; and parentCategoryId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndCompany(long companyId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ categories where groupId = &#63; and parentCategoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentAndGroup(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories where companyId = &#63; and parentCategoryId = &#63;.
	*
	* @param companyId the company ID
	* @param parentCategoryId the parent category ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndCompany(long companyId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the number of matching c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentAndGroup(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories that the user has permission to view where groupId = &#63; and parentCategoryId = &#63;.
	*
	* @param groupId the group ID
	* @param parentCategoryId the parent category ID
	* @return the number of matching c o_ categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentAndGroup(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ categories.
	*
	* @return the number of c o_ categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}