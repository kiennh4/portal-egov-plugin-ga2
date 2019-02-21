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

package com.portal_egov.portlet.banner.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.banner.model.BannerGroup;

import java.util.List;

/**
 * The persistence utility for the banner group service. This utility wraps {@link BannerGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see BannerGroupPersistence
 * @see BannerGroupPersistenceImpl
 * @generated
 */
public class BannerGroupUtil {
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
	public static void clearCache(BannerGroup bannerGroup) {
		getPersistence().clearCache(bannerGroup);
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
	public static List<BannerGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BannerGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BannerGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BannerGroup update(BannerGroup bannerGroup, boolean merge)
		throws SystemException {
		return getPersistence().update(bannerGroup, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BannerGroup update(BannerGroup bannerGroup, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bannerGroup, merge, serviceContext);
	}

	/**
	* Caches the banner group in the entity cache if it is enabled.
	*
	* @param bannerGroup the banner group
	*/
	public static void cacheResult(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup) {
		getPersistence().cacheResult(bannerGroup);
	}

	/**
	* Caches the banner groups in the entity cache if it is enabled.
	*
	* @param bannerGroups the banner groups
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> bannerGroups) {
		getPersistence().cacheResult(bannerGroups);
	}

	/**
	* Creates a new banner group with the primary key. Does not add the banner group to the database.
	*
	* @param bannerGroupId the primary key for the new banner group
	* @return the new banner group
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup create(
		long bannerGroupId) {
		return getPersistence().create(bannerGroupId);
	}

	/**
	* Removes the banner group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group that was removed
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup remove(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence().remove(bannerGroupId);
	}

	public static com.portal_egov.portlet.banner.model.BannerGroup updateImpl(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bannerGroup, merge);
	}

	/**
	* Returns the banner group with the primary key or throws a {@link com.portal_egov.portlet.banner.NoSuchBannerGroupException} if it could not be found.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup findByPrimaryKey(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence().findByPrimaryKey(bannerGroupId);
	}

	/**
	* Returns the banner group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group, or <code>null</code> if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup fetchByPrimaryKey(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bannerGroupId);
	}

	/**
	* Returns all the banner groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the banner groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @return the range of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the banner groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the banner groups before and after the current banner group in the ordered set where companyId = &#63;.
	*
	* @param bannerGroupId the primary key of the current banner group
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup[] findByCompany_PrevAndNext(
		long bannerGroupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence()
				   .findByCompany_PrevAndNext(bannerGroupId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the banner groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the banner groups where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @return the range of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the banner groups where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the banner groups before and after the current banner group in the ordered set where groupId = &#63;.
	*
	* @param bannerGroupId the primary key of the current banner group
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup[] findByGroup_PrevAndNext(
		long bannerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence()
				   .findByGroup_PrevAndNext(bannerGroupId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the banner groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banner groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the banner groups that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @return the range of matching banner groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the banner groups that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banner groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the banner groups before and after the current banner group in the ordered set of banner groups that the user has permission to view where groupId = &#63;.
	*
	* @param bannerGroupId the primary key of the current banner group
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.BannerGroup[] filterFindByGroup_PrevAndNext(
		long bannerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(bannerGroupId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the banner groups.
	*
	* @return the banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the banner groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @return the range of banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the banner groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banner groups
	* @param end the upper bound of the range of banner groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the banner groups where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the banner groups where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the banner groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of banner groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of banner groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of banner groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banner groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of banner groups.
	*
	* @return the number of banner groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BannerGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BannerGroupPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.banner.service.ClpSerializer.getServletContextName(),
					BannerGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(BannerGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BannerGroupPersistence persistence) {
	}

	private static BannerGroupPersistence _persistence;
}