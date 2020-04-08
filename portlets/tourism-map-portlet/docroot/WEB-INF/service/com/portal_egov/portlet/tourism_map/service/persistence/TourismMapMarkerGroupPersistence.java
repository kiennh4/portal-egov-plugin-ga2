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

package com.portal_egov.portlet.tourism_map.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;

/**
 * The persistence interface for the tourism map marker group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerGroupPersistenceImpl
 * @see TourismMapMarkerGroupUtil
 * @generated
 */
public interface TourismMapMarkerGroupPersistence extends BasePersistence<TourismMapMarkerGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TourismMapMarkerGroupUtil} to access the tourism map marker group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tourism map marker group in the entity cache if it is enabled.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	*/
	public void cacheResult(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup);

	/**
	* Caches the tourism map marker groups in the entity cache if it is enabled.
	*
	* @param tourismMapMarkerGroups the tourism map marker groups
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> tourismMapMarkerGroups);

	/**
	* Creates a new tourism map marker group with the primary key. Does not add the tourism map marker group to the database.
	*
	* @param markerGroupId the primary key for the new tourism map marker group
	* @return the new tourism map marker group
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup create(
		long markerGroupId);

	/**
	* Removes the tourism map marker group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group that was removed
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup remove(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateImpl(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map marker group with the primary key or throws a {@link com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException} if it could not be found.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByPrimaryKey(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns the tourism map marker group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group, or <code>null</code> if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByPrimaryKey(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tourism map marker groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map marker groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @return the range of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map marker groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns the first tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns the last tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map marker groups before and after the current tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param markerGroupId the primary key of the current tourism map marker group
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup[] findByCompany_PrevAndNext(
		long markerGroupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns all the tourism map marker groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map marker groups where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @return the range of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map marker groups where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns the first tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns the last tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map marker groups before and after the current tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param markerGroupId the primary key of the current tourism map marker group
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup[] findByGroup_PrevAndNext(
		long markerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns all the tourism map marker groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map marker groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map marker groups that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @return the range of matching tourism map marker groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map marker groups that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map marker groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map marker groups before and after the current tourism map marker group in the ordered set of tourism map marker groups that the user has permission to view where groupId = &#63;.
	*
	* @param markerGroupId the primary key of the current tourism map marker group
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup[] filterFindByGroup_PrevAndNext(
		long markerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException;

	/**
	* Returns all the tourism map marker groups.
	*
	* @return the tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map marker groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @return the range of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map marker groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tourism map marker groups
	* @param end the upper bound of the range of tourism map marker groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map marker groups where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map marker groups where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map marker groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map marker groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map marker groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map marker groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map marker groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map marker groups.
	*
	* @return the number of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}