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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;

import java.util.List;

/**
 * The persistence utility for the citizen inquiry category service. This utility wraps {@link CitizenInquiryCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CitizenInquiryCategoryPersistence
 * @see CitizenInquiryCategoryPersistenceImpl
 * @generated
 */
public class CitizenInquiryCategoryUtil {
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
	public static void clearCache(CitizenInquiryCategory citizenInquiryCategory) {
		getPersistence().clearCache(citizenInquiryCategory);
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
	public static List<CitizenInquiryCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CitizenInquiryCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CitizenInquiryCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CitizenInquiryCategory update(
		CitizenInquiryCategory citizenInquiryCategory, boolean merge)
		throws SystemException {
		return getPersistence().update(citizenInquiryCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CitizenInquiryCategory update(
		CitizenInquiryCategory citizenInquiryCategory, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(citizenInquiryCategory, merge, serviceContext);
	}

	/**
	* Caches the citizen inquiry category in the entity cache if it is enabled.
	*
	* @param citizenInquiryCategory the citizen inquiry category
	*/
	public static void cacheResult(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory) {
		getPersistence().cacheResult(citizenInquiryCategory);
	}

	/**
	* Caches the citizen inquiry categories in the entity cache if it is enabled.
	*
	* @param citizenInquiryCategories the citizen inquiry categories
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> citizenInquiryCategories) {
		getPersistence().cacheResult(citizenInquiryCategories);
	}

	/**
	* Creates a new citizen inquiry category with the primary key. Does not add the citizen inquiry category to the database.
	*
	* @param categoryId the primary key for the new citizen inquiry category
	* @return the new citizen inquiry category
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory create(
		long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the citizen inquiry category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category that was removed
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory remove(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory updateImpl(
		com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory citizenInquiryCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(citizenInquiryCategory, merge);
	}

	/**
	* Returns the citizen inquiry category with the primary key or throws a {@link com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the citizen inquiry category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the citizen inquiry category
	* @return the citizen inquiry category, or <code>null</code> if a citizen inquiry category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the citizen inquiry categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last citizen inquiry category in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory[] findByCompany_PrevAndNext(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence()
				   .findByCompany_PrevAndNext(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the citizen inquiry categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category
	* @throws com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last citizen inquiry category in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching citizen inquiry category, or <code>null</code> if a matching citizen inquiry category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory[] findByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence()
				   .findByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the citizen inquiry categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching citizen inquiry categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory[] filterFindByGroup_PrevAndNext(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citizen_inquiry.NoSuchCitizenInquiryCategoryException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the citizen inquiry categories.
	*
	* @return the citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the citizen inquiry categories where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the citizen inquiry categories where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the citizen inquiry categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of citizen inquiry categories where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of citizen inquiry categories where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of citizen inquiry categories that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching citizen inquiry categories that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of citizen inquiry categories.
	*
	* @return the number of citizen inquiry categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CitizenInquiryCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CitizenInquiryCategoryPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.citizen_inquiry.service.ClpSerializer.getServletContextName(),
					CitizenInquiryCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CitizenInquiryCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CitizenInquiryCategoryPersistence persistence) {
	}

	private static CitizenInquiryCategoryPersistence _persistence;
}