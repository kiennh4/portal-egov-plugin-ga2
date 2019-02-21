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

import com.portal_egov.portlet.banner.model.Banner;

import java.util.List;

/**
 * The persistence utility for the banner service. This utility wraps {@link BannerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see BannerPersistence
 * @see BannerPersistenceImpl
 * @generated
 */
public class BannerUtil {
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
	public static void clearCache(Banner banner) {
		getPersistence().clearCache(banner);
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
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Banner update(Banner banner, boolean merge)
		throws SystemException {
		return getPersistence().update(banner, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Banner update(Banner banner, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(banner, merge, serviceContext);
	}

	/**
	* Caches the banner in the entity cache if it is enabled.
	*
	* @param banner the banner
	*/
	public static void cacheResult(
		com.portal_egov.portlet.banner.model.Banner banner) {
		getPersistence().cacheResult(banner);
	}

	/**
	* Caches the banners in the entity cache if it is enabled.
	*
	* @param banners the banners
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.banner.model.Banner> banners) {
		getPersistence().cacheResult(banners);
	}

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public static com.portal_egov.portlet.banner.model.Banner create(
		long bannerId) {
		return getPersistence().create(bannerId);
	}

	/**
	* Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner
	* @return the banner that was removed
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner remove(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence().remove(bannerId);
	}

	public static com.portal_egov.portlet.banner.model.Banner updateImpl(
		com.portal_egov.portlet.banner.model.Banner banner, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(banner, merge);
	}

	/**
	* Returns the banner with the primary key or throws a {@link com.portal_egov.portlet.banner.NoSuchBannerException} if it could not be found.
	*
	* @param bannerId the primary key of the banner
	* @return the banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByPrimaryKey(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence().findByPrimaryKey(bannerId);
	}

	/**
	* Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bannerId the primary key of the banner
	* @return the banner, or <code>null</code> if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByPrimaryKey(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bannerId);
	}

	/**
	* Returns all the banners where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the banners where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the banners where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the banners before and after the current banner in the ordered set where companyId = &#63;.
	*
	* @param bannerId the primary key of the current banner
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner[] findByCompany_PrevAndNext(
		long bannerId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence()
				   .findByCompany_PrevAndNext(bannerId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the banners where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the banners where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the banners where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the banners before and after the current banner in the ordered set where groupId = &#63;.
	*
	* @param bannerId the primary key of the current banner
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner[] findByGroup_PrevAndNext(
		long bannerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence()
				   .findByGroup_PrevAndNext(bannerId, groupId, orderByComparator);
	}

	/**
	* Returns all the banners that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banners that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the banners that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of matching banners that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the banners that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banners that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the banners before and after the current banner in the ordered set of banners that the user has permission to view where groupId = &#63;.
	*
	* @param bannerId the primary key of the current banner
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner[] filterFindByGroup_PrevAndNext(
		long bannerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(bannerId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the banners where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBannerGroup(bannerGroupId);
	}

	/**
	* Returns a range of all the banners where bannerGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bannerGroupId the banner group ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBannerGroup(bannerGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the banners where bannerGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bannerGroupId the banner group ID
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBannerGroup(bannerGroupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByBannerGroup_First(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence()
				   .findByBannerGroup_First(bannerGroupId, orderByComparator);
	}

	/**
	* Returns the first banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByBannerGroup_First(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBannerGroup_First(bannerGroupId, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner findByBannerGroup_Last(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence()
				   .findByBannerGroup_Last(bannerGroupId, orderByComparator);
	}

	/**
	* Returns the last banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner fetchByBannerGroup_Last(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBannerGroup_Last(bannerGroupId, orderByComparator);
	}

	/**
	* Returns the banners before and after the current banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerId the primary key of the current banner
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.banner.model.Banner[] findByBannerGroup_PrevAndNext(
		long bannerId, long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException {
		return getPersistence()
				   .findByBannerGroup_PrevAndNext(bannerId, bannerGroupId,
			orderByComparator);
	}

	/**
	* Returns all the banners.
	*
	* @return the banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the banners where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the banners where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the banners where bannerGroupId = &#63; from the database.
	*
	* @param bannerGroupId the banner group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBannerGroup(long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBannerGroup(bannerGroupId);
	}

	/**
	* Removes all the banners from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of banners where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of banners where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of banners that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banners that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of banners where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBannerGroup(long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBannerGroup(bannerGroupId);
	}

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BannerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BannerPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.banner.service.ClpSerializer.getServletContextName(),
					BannerPersistence.class.getName());

			ReferenceRegistry.registerReference(BannerUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BannerPersistence persistence) {
	}

	private static BannerPersistence _persistence;
}