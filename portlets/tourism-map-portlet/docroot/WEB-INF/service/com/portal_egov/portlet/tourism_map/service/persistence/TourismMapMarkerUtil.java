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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.tourism_map.model.TourismMapMarker;

import java.util.List;

/**
 * The persistence utility for the tourism map marker service. This utility wraps {@link TourismMapMarkerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerPersistence
 * @see TourismMapMarkerPersistenceImpl
 * @generated
 */
public class TourismMapMarkerUtil {
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
	public static void clearCache(TourismMapMarker tourismMapMarker) {
		getPersistence().clearCache(tourismMapMarker);
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
	public static List<TourismMapMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TourismMapMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TourismMapMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TourismMapMarker update(TourismMapMarker tourismMapMarker,
		boolean merge) throws SystemException {
		return getPersistence().update(tourismMapMarker, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TourismMapMarker update(TourismMapMarker tourismMapMarker,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tourismMapMarker, merge, serviceContext);
	}

	/**
	* Caches the tourism map marker in the entity cache if it is enabled.
	*
	* @param tourismMapMarker the tourism map marker
	*/
	public static void cacheResult(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker) {
		getPersistence().cacheResult(tourismMapMarker);
	}

	/**
	* Caches the tourism map markers in the entity cache if it is enabled.
	*
	* @param tourismMapMarkers the tourism map markers
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> tourismMapMarkers) {
		getPersistence().cacheResult(tourismMapMarkers);
	}

	/**
	* Creates a new tourism map marker with the primary key. Does not add the tourism map marker to the database.
	*
	* @param markerId the primary key for the new tourism map marker
	* @return the new tourism map marker
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker create(
		long markerId) {
		return getPersistence().create(markerId);
	}

	/**
	* Removes the tourism map marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker that was removed
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker remove(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence().remove(markerId);
	}

	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker updateImpl(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tourismMapMarker, merge);
	}

	/**
	* Returns the tourism map marker with the primary key or throws a {@link com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByPrimaryKey(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence().findByPrimaryKey(markerId);
	}

	/**
	* Returns the tourism map marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker, or <code>null</code> if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByPrimaryKey(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(markerId);
	}

	/**
	* Returns all the tourism map markers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] findByCompany_PrevAndNext(
		long markerId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence()
				   .findByCompany_PrevAndNext(markerId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the tourism map markers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] findByGroup_PrevAndNext(
		long markerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence()
				   .findByGroup_PrevAndNext(markerId, groupId, orderByComparator);
	}

	/**
	* Returns all the tourism map markers that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map markers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] filterFindByGroup_PrevAndNext(
		long markerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(markerId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the tourism map markers where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @return the matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByLocationGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationGroup(markerGroupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByLocationGroup(
		long markerGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocationGroup(markerGroupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByLocationGroup(
		long markerGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocationGroup(markerGroupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByLocationGroup_First(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence()
				   .findByLocationGroup_First(markerGroupId, orderByComparator);
	}

	/**
	* Returns the first tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByLocationGroup_First(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationGroup_First(markerGroupId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker findByLocationGroup_Last(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence()
				   .findByLocationGroup_Last(markerGroupId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker in the ordered set where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker, or <code>null</code> if a matching tourism map marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchByLocationGroup_Last(
		long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocationGroup_Last(markerGroupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarker[] findByLocationGroup_PrevAndNext(
		long markerId, long markerGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		return getPersistence()
				   .findByLocationGroup_PrevAndNext(markerId, markerGroupId,
			orderByComparator);
	}

	/**
	* Returns all the tourism map markers.
	*
	* @return the tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tourism map markers where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the tourism map markers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the tourism map markers where markerGroupId = &#63; from the database.
	*
	* @param markerGroupId the marker group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocationGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocationGroup(markerGroupId);
	}

	/**
	* Removes all the tourism map markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tourism map markers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of tourism map markers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of tourism map markers that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map markers that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of tourism map markers where markerGroupId = &#63;.
	*
	* @param markerGroupId the marker group ID
	* @return the number of matching tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocationGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocationGroup(markerGroupId);
	}

	/**
	* Returns the number of tourism map markers.
	*
	* @return the number of tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TourismMapMarkerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TourismMapMarkerPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.tourism_map.service.ClpSerializer.getServletContextName(),
					TourismMapMarkerPersistence.class.getName());

			ReferenceRegistry.registerReference(TourismMapMarkerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TourismMapMarkerPersistence persistence) {
	}

	private static TourismMapMarkerPersistence _persistence;
}