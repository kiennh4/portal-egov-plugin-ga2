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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.banner.model.Banner;

/**
 * The persistence interface for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see BannerPersistenceImpl
 * @see BannerUtil
 * @generated
 */
public interface BannerPersistence extends BasePersistence<Banner> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerUtil} to access the banner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the banner in the entity cache if it is enabled.
	*
	* @param banner the banner
	*/
	public void cacheResult(com.portal_egov.portlet.banner.model.Banner banner);

	/**
	* Caches the banners in the entity cache if it is enabled.
	*
	* @param banners the banners
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.banner.model.Banner> banners);

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public com.portal_egov.portlet.banner.model.Banner create(long bannerId);

	/**
	* Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner
	* @return the banner that was removed
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner remove(long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	public com.portal_egov.portlet.banner.model.Banner updateImpl(
		com.portal_egov.portlet.banner.model.Banner banner, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the banner with the primary key or throws a {@link com.portal_egov.portlet.banner.NoSuchBannerException} if it could not be found.
	*
	* @param bannerId the primary key of the banner
	* @return the banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByPrimaryKey(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the banner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bannerId the primary key of the banner
	* @return the banner, or <code>null</code> if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByPrimaryKey(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the banners where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the first banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the last banner in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.Banner[] findByCompany_PrevAndNext(
		long bannerId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns all the banners where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the first banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the last banner in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.Banner[] findByGroup_PrevAndNext(
		long bannerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns all the banners that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banners that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.Banner[] filterFindByGroup_PrevAndNext(
		long bannerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns all the banners where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findByBannerGroup(
		long bannerGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByBannerGroup_First(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the first banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByBannerGroup_First(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner
	* @throws com.portal_egov.portlet.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner findByBannerGroup_Last(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns the last banner in the ordered set where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.Banner fetchByBannerGroup_Last(
		long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.Banner[] findByBannerGroup_PrevAndNext(
		long bannerId, long bannerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerException;

	/**
	* Returns all the banners.
	*
	* @return the banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.Banner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners where bannerGroupId = &#63; from the database.
	*
	* @param bannerGroupId the banner group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBannerGroup(long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banners that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners where bannerGroupId = &#63;.
	*
	* @param bannerGroupId the banner group ID
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByBannerGroup(long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}