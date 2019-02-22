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

import com.portal_egov.portlet.banner.model.BannerGroup;

/**
 * The persistence interface for the banner group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see BannerGroupPersistenceImpl
 * @see BannerGroupUtil
 * @generated
 */
public interface BannerGroupPersistence extends BasePersistence<BannerGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerGroupUtil} to access the banner group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the banner group in the entity cache if it is enabled.
	*
	* @param bannerGroup the banner group
	*/
	public void cacheResult(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup);

	/**
	* Caches the banner groups in the entity cache if it is enabled.
	*
	* @param bannerGroups the banner groups
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> bannerGroups);

	/**
	* Creates a new banner group with the primary key. Does not add the banner group to the database.
	*
	* @param bannerGroupId the primary key for the new banner group
	* @return the new banner group
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup create(
		long bannerGroupId);

	/**
	* Removes the banner group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group that was removed
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup remove(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	public com.portal_egov.portlet.banner.model.BannerGroup updateImpl(
		com.portal_egov.portlet.banner.model.BannerGroup bannerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the banner group with the primary key or throws a {@link com.portal_egov.portlet.banner.NoSuchBannerGroupException} if it could not be found.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup findByPrimaryKey(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns the banner group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bannerGroupId the primary key of the banner group
	* @return the banner group, or <code>null</code> if a banner group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup fetchByPrimaryKey(
		long bannerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the banner groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns the first banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns the last banner group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.BannerGroup[] findByCompany_PrevAndNext(
		long bannerGroupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns all the banner groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns the first banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group
	* @throws com.portal_egov.portlet.banner.NoSuchBannerGroupException if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns the last banner group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching banner group, or <code>null</code> if a matching banner group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.banner.model.BannerGroup fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.BannerGroup[] findByGroup_PrevAndNext(
		long bannerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns all the banner groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching banner groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.banner.model.BannerGroup[] filterFindByGroup_PrevAndNext(
		long bannerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.banner.NoSuchBannerGroupException;

	/**
	* Returns all the banner groups.
	*
	* @return the banner groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.banner.model.BannerGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banner groups where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banner groups where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banner groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banner groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banner groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banner groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banner groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching banner groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banner groups.
	*
	* @return the number of banner groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}