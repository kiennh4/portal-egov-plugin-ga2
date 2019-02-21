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

import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;

/**
 * The persistence interface for the tourism map marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerPersistenceImpl
 * @see TourismMapMarkerUtil
 * @generated
 */
public interface TourismMapMarkerPersistence extends BasePersistence<TourismMapMarker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TourismMapMarkerUtil} to access the tourism map marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tourism map marker in the entity cache if it is enabled.
	*
	* @param tourismMapMarker the tourism map marker
	*/
	public void cacheResult(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker);

	/**
	* Caches the tourism map markers in the entity cache if it is enabled.
	*
	* @param tourismMapMarkers the tourism map markers
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> tourismMapMarkers);

	/**
	* Creates a new tourism map marker with the primary key. Does not add the tourism map marker to the database.
	*
	* @param markerId the primary key for the new tourism map marker
	* @return the new tourism map marker
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker create(
		long markerId);

	/**
	* Removes the tourism map marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker that was removed
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker remove(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker updateImpl(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map marker with the primary key or throws a {@link com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByPrimaryKey(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the tourism map marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker, or <code>null</code> if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByPrimaryKey(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tourism map markers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map markers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @return the range of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map markers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the first tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the last tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map markers before and after the current tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param markerId the primary key of the current tourism map marker
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] findByCompany_PrevAndNext(
		long markerId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns all the tourism map markers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map markers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @return the range of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map markers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the first tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the last tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map markers before and after the current tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param markerId the primary key of the current tourism map marker
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] findByGroup_PrevAndNext(
		long markerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns all the tourism map markers that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map markers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map markers that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @return the range of matching tourism map markers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map markers that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map markers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map markers before and after the current tourism map marker in the ordered set of tourism map markers that the user has permission to view where groupId = &#63;.
	*
	* @param markerId the primary key of the current tourism map marker
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] filterFindByGroup_PrevAndNext(
		long markerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns all the tourism map markers where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @return the matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByLocationGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map markers where markerGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param markerGroupId the marker group ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @return the range of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByLocationGroup(
		long markerGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map markers where markerGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param markerGroupId the marker group ID
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByLocationGroup(
		long markerGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByLocationGroup_First(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the first tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByLocationGroup_First(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByLocationGroup_Last(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns the last tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByLocationGroup_Last(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tourism map markers before and after the current tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerId the primary key of the current tourism map marker
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] findByLocationGroup_PrevAndNext(
		long markerId, long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException;

	/**
	* Returns all the tourism map markers.
	*
	* @return the tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tourism map markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @return the range of tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tourism map markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map markers where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map markers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map markers where markerGroupId = &#63; from the database.
	*
	* @param markerGroupId the marker group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLocationGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tourism map markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map markers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map markers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map markers that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map markers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map markers where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @return the number of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocationGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tourism map markers.
	*
	* @return the number of tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}