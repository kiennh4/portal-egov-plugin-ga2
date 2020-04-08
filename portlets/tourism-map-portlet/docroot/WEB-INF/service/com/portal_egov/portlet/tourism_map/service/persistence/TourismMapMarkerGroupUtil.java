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

import com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup;

import java.util.List;

/**
 * The persistence utility for the tourism map marker group service. This utility wraps {@link TourismMapMarkerGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see TourismMapMarkerGroupPersistence
 * @see TourismMapMarkerGroupPersistenceImpl
 * @generated
 */
public class TourismMapMarkerGroupUtil {
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
	public static void clearCache(TourismMapMarkerGroup tourismMapMarkerGroup) {
		getPersistence().clearCache(tourismMapMarkerGroup);
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
	public static List<TourismMapMarkerGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TourismMapMarkerGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TourismMapMarkerGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TourismMapMarkerGroup update(
		TourismMapMarkerGroup tourismMapMarkerGroup, boolean merge)
		throws SystemException {
		return getPersistence().update(tourismMapMarkerGroup, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TourismMapMarkerGroup update(
		TourismMapMarkerGroup tourismMapMarkerGroup, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(tourismMapMarkerGroup, merge, serviceContext);
	}

	/**
	* Caches the tourism map marker group in the entity cache if it is enabled.
	*
	* @param tourismMapMarkerGroup the tourism map marker group
	*/
	public static void cacheResult(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup) {
		getPersistence().cacheResult(tourismMapMarkerGroup);
	}

	/**
	* Caches the tourism map marker groups in the entity cache if it is enabled.
	*
	* @param tourismMapMarkerGroups the tourism map marker groups
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> tourismMapMarkerGroups) {
		getPersistence().cacheResult(tourismMapMarkerGroups);
	}

	/**
	* Creates a new tourism map marker group with the primary key. Does not add the tourism map marker group to the database.
	*
	* @param markerGroupId the primary key for the new tourism map marker group
	* @return the new tourism map marker group
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup create(
		long markerGroupId) {
		return getPersistence().create(markerGroupId);
	}

	/**
	* Removes the tourism map marker group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group that was removed
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup remove(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence().remove(markerGroupId);
	}

	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup updateImpl(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup tourismMapMarkerGroup,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tourismMapMarkerGroup, merge);
	}

	/**
	* Returns the tourism map marker group with the primary key or throws a {@link com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException} if it could not be found.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByPrimaryKey(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence().findByPrimaryKey(markerGroupId);
	}

	/**
	* Returns the tourism map marker group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerGroupId the primary key of the tourism map marker group
	* @return the tourism map marker group, or <code>null</code> if a tourism map marker group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByPrimaryKey(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(markerGroupId);
	}

	/**
	* Returns all the tourism map marker groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker group in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup[] findByCompany_PrevAndNext(
		long markerGroupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence()
				   .findByCompany_PrevAndNext(markerGroupId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the tourism map marker groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group
	* @throws com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last tourism map marker group in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tourism map marker group, or <code>null</code> if a matching tourism map marker group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup[] findByGroup_PrevAndNext(
		long markerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence()
				   .findByGroup_PrevAndNext(markerGroupId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the tourism map marker groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tourism map marker groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup[] filterFindByGroup_PrevAndNext(
		long markerGroupId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(markerGroupId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the tourism map marker groups.
	*
	* @return the tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarkerGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tourism map marker groups where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the tourism map marker groups where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the tourism map marker groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tourism map marker groups where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of tourism map marker groups where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of tourism map marker groups that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tourism map marker groups that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of tourism map marker groups.
	*
	* @return the number of tourism map marker groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TourismMapMarkerGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TourismMapMarkerGroupPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.tourism_map.service.ClpSerializer.getServletContextName(),
					TourismMapMarkerGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(TourismMapMarkerGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TourismMapMarkerGroupPersistence persistence) {
	}

	private static TourismMapMarkerGroupPersistence _persistence;
}