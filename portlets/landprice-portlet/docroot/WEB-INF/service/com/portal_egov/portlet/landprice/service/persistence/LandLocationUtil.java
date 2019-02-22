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

package com.portal_egov.portlet.landprice.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.landprice.model.LandLocation;

import java.util.List;

/**
 * The persistence utility for the land location service. This utility wraps {@link LandLocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LandLocationPersistence
 * @see LandLocationPersistenceImpl
 * @generated
 */
public class LandLocationUtil {
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
	public static void clearCache(LandLocation landLocation) {
		getPersistence().clearCache(landLocation);
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
	public static List<LandLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LandLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LandLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LandLocation update(LandLocation landLocation, boolean merge)
		throws SystemException {
		return getPersistence().update(landLocation, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LandLocation update(LandLocation landLocation, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(landLocation, merge, serviceContext);
	}

	/**
	* Caches the land location in the entity cache if it is enabled.
	*
	* @param landLocation the land location
	*/
	public static void cacheResult(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation) {
		getPersistence().cacheResult(landLocation);
	}

	/**
	* Caches the land locations in the entity cache if it is enabled.
	*
	* @param landLocations the land locations
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> landLocations) {
		getPersistence().cacheResult(landLocations);
	}

	/**
	* Creates a new land location with the primary key. Does not add the land location to the database.
	*
	* @param locationId the primary key for the new land location
	* @return the new land location
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation create(
		long locationId) {
		return getPersistence().create(locationId);
	}

	/**
	* Removes the land location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the land location
	* @return the land location that was removed
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation remove(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence().remove(locationId);
	}

	public static com.portal_egov.portlet.landprice.model.LandLocation updateImpl(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(landLocation, merge);
	}

	/**
	* Returns the land location with the primary key or throws a {@link com.portal_egov.portlet.landprice.NoSuchLandLocationException} if it could not be found.
	*
	* @param locationId the primary key of the land location
	* @return the land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation findByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence().findByPrimaryKey(locationId);
	}

	/**
	* Returns the land location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param locationId the primary key of the land location
	* @return the land location, or <code>null</code> if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation fetchByPrimaryKey(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(locationId);
	}

	/**
	* Returns all the land locations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the land locations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @return the range of matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the land locations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first land location in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first land location in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land location, or <code>null</code> if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last land location in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last land location in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land location, or <code>null</code> if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the land locations before and after the current land location in the ordered set where groupId = &#63;.
	*
	* @param locationId the primary key of the current land location
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation[] findByGroup_PrevAndNext(
		long locationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence()
				   .findByGroup_PrevAndNext(locationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the land locations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching land locations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the land locations that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @return the range of matching land locations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the land locations that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land locations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the land locations before and after the current land location in the ordered set of land locations that the user has permission to view where groupId = &#63;.
	*
	* @param locationId the primary key of the current land location
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation[] filterFindByGroup_PrevAndNext(
		long locationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(locationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the land locations where parentLocationId = &#63;.
	*
	* @param parentLocationId the parent location ID
	* @return the matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByParentLocation(
		long parentLocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentLocation(parentLocationId);
	}

	/**
	* Returns a range of all the land locations where parentLocationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentLocationId the parent location ID
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @return the range of matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByParentLocation(
		long parentLocationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentLocation(parentLocationId, start, end);
	}

	/**
	* Returns an ordered range of all the land locations where parentLocationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentLocationId the parent location ID
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByParentLocation(
		long parentLocationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentLocation(parentLocationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first land location in the ordered set where parentLocationId = &#63;.
	*
	* @param parentLocationId the parent location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation findByParentLocation_First(
		long parentLocationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence()
				   .findByParentLocation_First(parentLocationId,
			orderByComparator);
	}

	/**
	* Returns the first land location in the ordered set where parentLocationId = &#63;.
	*
	* @param parentLocationId the parent location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land location, or <code>null</code> if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation fetchByParentLocation_First(
		long parentLocationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentLocation_First(parentLocationId,
			orderByComparator);
	}

	/**
	* Returns the last land location in the ordered set where parentLocationId = &#63;.
	*
	* @param parentLocationId the parent location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation findByParentLocation_Last(
		long parentLocationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence()
				   .findByParentLocation_Last(parentLocationId,
			orderByComparator);
	}

	/**
	* Returns the last land location in the ordered set where parentLocationId = &#63;.
	*
	* @param parentLocationId the parent location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land location, or <code>null</code> if a matching land location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation fetchByParentLocation_Last(
		long parentLocationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentLocation_Last(parentLocationId,
			orderByComparator);
	}

	/**
	* Returns the land locations before and after the current land location in the ordered set where parentLocationId = &#63;.
	*
	* @param locationId the primary key of the current land location
	* @param parentLocationId the parent location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land location
	* @throws com.portal_egov.portlet.landprice.NoSuchLandLocationException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation[] findByParentLocation_PrevAndNext(
		long locationId, long parentLocationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		return getPersistence()
				   .findByParentLocation_PrevAndNext(locationId,
			parentLocationId, orderByComparator);
	}

	/**
	* Returns all the land locations.
	*
	* @return the land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the land locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @return the range of land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the land locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of land locations
	* @param end the upper bound of the range of land locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of land locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the land locations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the land locations where parentLocationId = &#63; from the database.
	*
	* @param parentLocationId the parent location ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentLocation(long parentLocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentLocation(parentLocationId);
	}

	/**
	* Removes all the land locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of land locations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of land locations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching land locations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of land locations where parentLocationId = &#63;.
	*
	* @param parentLocationId the parent location ID
	* @return the number of matching land locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentLocation(long parentLocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentLocation(parentLocationId);
	}

	/**
	* Returns the number of land locations.
	*
	* @return the number of land locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LandLocationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LandLocationPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.landprice.service.ClpSerializer.getServletContextName(),
					LandLocationPersistence.class.getName());

			ReferenceRegistry.registerReference(LandLocationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LandLocationPersistence persistence) {
	}

	private static LandLocationPersistence _persistence;
}