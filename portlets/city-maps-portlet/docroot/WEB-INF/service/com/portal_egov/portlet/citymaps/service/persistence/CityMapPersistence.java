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

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.citymaps.model.CityMap;

/**
 * The persistence interface for the city map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CityMapPersistenceImpl
 * @see CityMapUtil
 * @generated
 */
public interface CityMapPersistence extends BasePersistence<CityMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityMapUtil} to access the city map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the city map in the entity cache if it is enabled.
	*
	* @param cityMap the city map
	*/
	public void cacheResult(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap);

	/**
	* Caches the city maps in the entity cache if it is enabled.
	*
	* @param cityMaps the city maps
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> cityMaps);

	/**
	* Creates a new city map with the primary key. Does not add the city map to the database.
	*
	* @param mapId the primary key for the new city map
	* @return the new city map
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap create(long mapId);

	/**
	* Removes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the city map
	* @return the city map that was removed
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap remove(long mapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	public com.portal_egov.portlet.citymaps.model.CityMap updateImpl(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city map with the primary key or throws a {@link com.portal_egov.portlet.citymaps.NoSuchCityMapException} if it could not be found.
	*
	* @param mapId the primary key of the city map
	* @return the city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByPrimaryKey(
		long mapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the city map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mapId the primary key of the city map
	* @return the city map, or <code>null</code> if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByPrimaryKey(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the city maps where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the first city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the last city map in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.citymaps.model.CityMap[] findByCompany_PrevAndNext(
		long mapId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns all the city maps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the first city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the last city map in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.citymaps.model.CityMap[] findByGroup_PrevAndNext(
		long mapId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns all the city maps that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching city maps that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.citymaps.model.CityMap[] filterFindByGroup_PrevAndNext(
		long mapId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns all the city maps where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @return the matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long mapTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long mapTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long mapTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByType_First(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the first city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByType_First(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapException if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap findByType_Last(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns the last city map in the ordered set where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map, or <code>null</code> if a matching city map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap fetchByType_Last(
		long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.portal_egov.portlet.citymaps.model.CityMap[] findByType_PrevAndNext(
		long mapId, long mapTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException;

	/**
	* Returns all the city maps.
	*
	* @return the city maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city maps where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city maps where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city maps where mapTypeId = &#63; from the database.
	*
	* @param mapTypeId the map type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(long mapTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city maps where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city maps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city maps that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching city maps that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city maps where mapTypeId = &#63;.
	*
	* @param mapTypeId the map type ID
	* @return the number of matching city maps
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(long mapTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city maps.
	*
	* @return the number of city maps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}