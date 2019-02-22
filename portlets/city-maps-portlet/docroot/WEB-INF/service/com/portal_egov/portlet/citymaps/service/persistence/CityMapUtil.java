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

package com.portal_egov.portlet.citymaps.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.citymaps.model.CityMap;

import java.util.List;

/**
 * The persistence utility for the city map service. This utility wraps {@link CityMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CityMapPersistence
 * @see CityMapPersistenceImpl
 * @generated
 */
public class CityMapUtil {
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
	public static void clearCache(CityMap cityMap) {
		getPersistence().clearCache(cityMap);
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
	public static List<CityMap> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CityMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CityMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CityMap update(CityMap cityMap, boolean merge)
		throws SystemException {
		return getPersistence().update(cityMap, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CityMap update(CityMap cityMap, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cityMap, merge, serviceContext);
	}

	/**
	* Caches the city map in the entity cache if it is enabled.
	*
	* @param cityMap the city map
	*/
	public static void cacheResult(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap) {
		getPersistence().cacheResult(cityMap);
	}

	/**
	* Caches the city maps in the entity cache if it is enabled.
	*
	* @param cityMaps the city maps
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> cityMaps) {
		getPersistence().cacheResult(cityMaps);
	}

	/**
	* Creates a new city map with the primary key. Does not add the city map to the database.
	*
	* @param mapId the primary key for the new city map
	* @return the new city map
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap create(
		long mapId) {
		return getPersistence().create(mapId);
	}

	/**
	* Removes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the city map
	* @return the city map that was removed
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap remove(
		long mapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().remove(mapId);
	}

	public static com.portal_egov.portlet.citymaps.model.CityMap updateImpl(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cityMap, merge);
	}

	/**
	* Returns the city map with the primary key or throws a {@link com.portal_egov.portlet.citymaps.NoSuchCityMapException} if it could not be found.
	*
	* @param mapId the primary key of the city map
	* @return the city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByPrimaryKey(
		long mapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByPrimaryKey(mapId);
	}

	/**
	* Returns the city map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapId the primary key of the city map
	* @return the city map, or <code>null</code> if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByPrimaryKey(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mapId);
	}

	/**
	* Returns all the city maps where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

	/**
	* Returns a range of all the city maps where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @return the range of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the city maps where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the city maps before and after the current city map in the ordered set where companyId = &#63;.
	*
	* @param mapId the primary key of the current city map
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap[] findByCompany_PrevAndNext(
		long mapId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence()
				   .findByCompany_PrevAndNext(mapId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the city maps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

	/**
	* Returns a range of all the city maps where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @return the range of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the city maps where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the city maps before and after the current city map in the ordered set where groupId = &#63;.
	*
	* @param mapId the primary key of the current city map
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap[] findByGroup_PrevAndNext(
		long mapId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence()
				   .findByGroup_PrevAndNext(mapId, groupId, orderByComparator);
	}

	/**
	* Returns all the city maps that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching city maps that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

	/**
	* Returns a range of all the city maps that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @return the range of matching city maps that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the city maps that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city maps that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the city maps before and after the current city map in the ordered set of city maps that the user has permission to view where groupId = &#63;.
	*
	* @param mapId the primary key of the current city map
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap[] filterFindByGroup_PrevAndNext(
		long mapId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(mapId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the city maps where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @return the matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long mapTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(mapTypeId);
	}

	/**
	* Returns a range of all the city maps where mapTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mapTypeId the map type ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @return the range of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long mapTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(mapTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the city maps where mapTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mapTypeId the map type ID
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long mapTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType(mapTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByType_First(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByType_First(mapTypeId, orderByComparator);
	}

	/**
	* Returns the first city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByType_First(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(mapTypeId, orderByComparator);
	}

	/**
	* Returns the last city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap findByType_Last(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence().findByType_Last(mapTypeId, orderByComparator);
	}

	/**
	* Returns the last city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap fetchByType_Last(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(mapTypeId, orderByComparator);
	}

	/**
	* Returns the city maps before and after the current city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapId the primary key of the current city map
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap[] findByType_PrevAndNext(
		long mapId, long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		return getPersistence()
				   .findByType_PrevAndNext(mapId, mapTypeId, orderByComparator);
	}

	/**
	* Returns all the city maps.
	*
	* @return the city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the city maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @return the range of city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the city maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city maps
	* @param end the upper bound of the range of city maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of city maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the city maps where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the city maps where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the city maps where mapTypeId = &#63; from the database.
	*
	* @param mapTypeId the map type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(long mapTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(mapTypeId);
	}

	/**
	* Removes all the city maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of city maps where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of city maps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of city maps that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching city maps that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of city maps where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @return the number of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(long mapTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(mapTypeId);
	}

	/**
	* Returns the number of city maps.
	*
	* @return the number of city maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CityMapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CityMapPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.citymaps.service.ClpSerializer.getServletContextName(),
					CityMapPersistence.class.getName());

			ReferenceRegistry.registerReference(CityMapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CityMapPersistence persistence) {
	}

	private static CityMapPersistence _persistence;
}