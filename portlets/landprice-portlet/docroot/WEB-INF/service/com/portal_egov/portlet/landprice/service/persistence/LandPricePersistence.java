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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.landprice.model.LandPrice;

/**
 * The persistence interface for the land price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see LandPricePersistenceImpl
 * @see LandPriceUtil
 * @generated
 */
public interface LandPricePersistence extends BasePersistence<LandPrice> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LandPriceUtil} to access the land price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the land price in the entity cache if it is enabled.
	*
	* @param landPrice the land price
	*/
	public void cacheResult(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice);

	/**
	* Caches the land prices in the entity cache if it is enabled.
	*
	* @param landPrices the land prices
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> landPrices);

	/**
	* Creates a new land price with the primary key. Does not add the land price to the database.
	*
	* @param priceId the primary key for the new land price
	* @return the new land price
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice create(
		long priceId);

	/**
	* Removes the land price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param priceId the primary key of the land price
	* @return the land price that was removed
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice remove(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	public com.portal_egov.portlet.landprice.model.LandPrice updateImpl(
		com.portal_egov.portlet.landprice.model.LandPrice landPrice,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the land price with the primary key or throws a {@link com.portal_egov.portlet.landprice.NoSuchLandPriceException} if it could not be found.
	*
	* @param priceId the primary key of the land price
	* @return the land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByPrimaryKey(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the land price with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param priceId the primary key of the land price
	* @return the land price, or <code>null</code> if a land price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByPrimaryKey(
		long priceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the land prices where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the first land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the last land price in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.landprice.model.LandPrice[] findByGroup_PrevAndNext(
		long priceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns all the land prices that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching land prices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.landprice.model.LandPrice[] filterFindByGroup_PrevAndNext(
		long priceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns all the land prices where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByLocation(
		long locationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByLocation_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the first land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByLocation_First(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByLocation_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the last land price in the ordered set where locationId = &#63;.
	*
	* @param locationId the location ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByLocation_Last(
		long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.landprice.model.LandPrice[] findByLocation_PrevAndNext(
		long priceId, long locationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns all the land prices where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @return the matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findByStatisticYear(
		int statisticYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByStatisticYear_First(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the first land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByStatisticYear_First(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price
	* @throws com.portal_egov.portlet.landprice.NoSuchLandPriceException if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice findByStatisticYear_Last(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns the last land price in the ordered set where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land price, or <code>null</code> if a matching land price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.landprice.model.LandPrice fetchByStatisticYear_Last(
		int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.landprice.model.LandPrice[] findByStatisticYear_PrevAndNext(
		long priceId, int statisticYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandPriceException;

	/**
	* Returns all the land prices.
	*
	* @return the land prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.landprice.model.LandPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the land prices where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the land prices where locationId = &#63; from the database.
	*
	* @param locationId the location ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLocation(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the land prices where statisticYear = &#63; from the database.
	*
	* @param statisticYear the statistic year
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatisticYear(int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the land prices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of land prices where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of land prices that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching land prices that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of land prices where locationId = &#63;.
	*
	* @param locationId the location ID
	* @return the number of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocation(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of land prices where statisticYear = &#63;.
	*
	* @param statisticYear the statistic year
	* @return the number of matching land prices
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatisticYear(int statisticYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of land prices.
	*
	* @return the number of land prices
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}