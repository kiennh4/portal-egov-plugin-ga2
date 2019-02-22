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

import com.portal_egov.portlet.landprice.model.LandPrice;

import java.util.List;

/**
 * The persistence utility for the land price service. This utility wraps {@link LandPricePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LandPricePersistence
 * @see LandPricePersistenceImpl
 * @generated
 */
public class LandPriceUtil {
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
	public static void clearCache(LandPrice landPrice) {
		getPersistence().clearCache(landPrice);
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
	public static List<LandPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LandPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LandPrice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LandPrice update(LandPrice landPrice, boolean merge)
		throws SystemException {
		return getPersistence().update(landPrice, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LandPrice update(LandPrice landPrice, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(landPrice, merge, serviceContext);
	}

	/**
	* Caches the land price in the entity cache if it is enabled.
	*
	* @param landPrice the land price
	*/
	public static void cacheResult(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice) {
		getPersistence().cacheResult(landPrice);
	}

	/**
	* Caches the land prices in the entity cache if it is enabled.
	*
	* @param landPrices the land prices
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> landPrices) {
		getPersistence().cacheResult(landPrices);
	}

	/**
	* Creates a new land price with the primary key. Does not add the land price to the database.
	*
	* @param priceId the primary key for the new land price
	* @return the new land price
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice create(
		long priceId) {
		return getPersistence().create(priceId);
	}

	/**
	* Removes the land price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param priceId the primary key of the land price
	* @return the land price that was removed
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice remove(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence().remove(priceId);
	}

	public static com.portal_egov.portlet.landprice.model.LandPrice updateImpl(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(landPrice, merge);
	}

	/**
	* Returns the land price with the primary key or throws a {@link com.portal_egov.portlet.landprice.NoSuchLandPriceException} if it could not be found.
	*
	* @param priceId the primary key of the land price
	* @return the land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByPrimaryKey(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence().findByPrimaryKey(priceId);
	}

	/**
	* Returns the land price with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param priceId the primary key of the land price
	* @return the land price, or <code>null</code> if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByPrimaryKey(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(priceId);
	}

	/**
	* Returns all the land prices where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the land prices where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @return the range of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the land prices where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the land prices before and after the current land price in the ordered set where groupId = &#63;.
	*
	* @param priceId the primary key of the current land price
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice[] findByGroup_PrevAndNext(
		long priceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByGroup_PrevAndNext(priceId, groupId, orderByComparator);
	}

	/**
	* Returns all the land prices that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching land prices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the land prices that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @return the range of matching land prices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the land prices that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land prices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the land prices before and after the current land price in the ordered set of land prices that the user has permission to view where groupId = &#63;.
	*
	* @param priceId the primary key of the current land price
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice[] filterFindByGroup_PrevAndNext(
		long priceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(priceId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the land prices where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocation(locationId);
	}

	/**
	* Returns a range of all the land prices where locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationId the location ID
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @return the range of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocation(locationId, start, end);
	}

	/**
	* Returns an ordered range of all the land prices where locationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param locationId the location ID
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocation(locationId, start, end, orderByComparator);
	}

	/**
	* Returns the first land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByLocation_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByLocation_First(locationId, orderByComparator);
	}

	/**
	* Returns the first land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByLocation_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocation_First(locationId, orderByComparator);
	}

	/**
	* Returns the last land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByLocation_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByLocation_Last(locationId, orderByComparator);
	}

	/**
	* Returns the last land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByLocation_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocation_Last(locationId, orderByComparator);
	}

	/**
	* Returns the land prices before and after the current land price in the ordered set where locationId = &#63;.
	*
	* @param priceId the primary key of the current land price
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice[] findByLocation_PrevAndNext(
		long priceId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByLocation_PrevAndNext(priceId, locationId,
			orderByComparator);
	}

	/**
	* Returns all the land prices where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @return the matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatisticYear(statisticYear);
	}

	/**
	* Returns a range of all the land prices where statisticYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param statisticYear the statistic year
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @return the range of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatisticYear(statisticYear, start, end);
	}

	/**
	* Returns an ordered range of all the land prices where statisticYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param statisticYear the statistic year
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatisticYear(statisticYear, start, end,
			orderByComparator);
	}

	/**
	* Returns the first land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByStatisticYear_First(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByStatisticYear_First(statisticYear, orderByComparator);
	}

	/**
	* Returns the first land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByStatisticYear_First(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatisticYear_First(statisticYear, orderByComparator);
	}

	/**
	* Returns the last land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice findByStatisticYear_Last(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByStatisticYear_Last(statisticYear, orderByComparator);
	}

	/**
	* Returns the last land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice fetchByStatisticYear_Last(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatisticYear_Last(statisticYear, orderByComparator);
	}

	/**
	* Returns the land prices before and after the current land price in the ordered set where statisticYear = &#63;.
	*
	* @param priceId the primary key of the current land price
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandPrice[] findByStatisticYear_PrevAndNext(
		long priceId, int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException {
		return getPersistence()
				   .findByStatisticYear_PrevAndNext(priceId, statisticYear,
			orderByComparator);
	}

	/**
	* Returns all the land prices.
	*
	* @return the land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the land prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @return the range of land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the land prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of land prices
	* @param end the upper bound of the range of land prices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of land prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the land prices where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the land prices where locationId = &#63; from the database.
	*
	* @param locationId the location ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocation(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocation(locationId);
	}

	/**
	* Removes all the land prices where statisticYear = &#63; from the database.
	*
	* @param statisticYear the statistic year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatisticYear(int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatisticYear(statisticYear);
	}

	/**
	* Removes all the land prices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of land prices where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of land prices that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching land prices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of land prices where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the number of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocation(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocation(locationId);
	}

	/**
	* Returns the number of land prices where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @return the number of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatisticYear(int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatisticYear(statisticYear);
	}

	/**
	* Returns the number of land prices.
	*
	* @return the number of land prices
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LandPricePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LandPricePersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.landprice.service.ClpSerializer.getServletContextName(),
					LandPricePersistence.class.getName());

			ReferenceRegistry.registerReference(LandPriceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LandPricePersistence persistence) {
	}

	private static LandPricePersistence _persistence;
}