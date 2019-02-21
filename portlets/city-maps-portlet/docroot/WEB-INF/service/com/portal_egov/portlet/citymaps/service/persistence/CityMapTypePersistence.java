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

import com.portal_egov.portlet.citymaps.model.CityMapType;

/**
 * The persistence interface for the city map type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see CityMapTypePersistenceImpl
 * @see CityMapTypeUtil
 * @generated
 */
public interface CityMapTypePersistence extends BasePersistence<CityMapType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityMapTypeUtil} to access the city map type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the city map type in the entity cache if it is enabled.
	*
	* @param cityMapType the city map type
	*/
	public void cacheResult(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType);

	/**
	* Caches the city map types in the entity cache if it is enabled.
	*
	* @param cityMapTypes the city map types
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> cityMapTypes);

	/**
	* Creates a new city map type with the primary key. Does not add the city map type to the database.
	*
	* @param typeId the primary key for the new city map type
	* @return the new city map type
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType create(
		long typeId);

	/**
	* Removes the city map type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the city map type
	* @return the city map type that was removed
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType remove(
		long typeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	public com.portal_egov.portlet.citymaps.model.CityMapType updateImpl(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city map type with the primary key or throws a {@link com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException} if it could not be found.
	*
	* @param typeId the primary key of the city map type
	* @return the city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType findByPrimaryKey(
		long typeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns the city map type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeId the primary key of the city map type
	* @return the city map type, or <code>null</code> if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType fetchByPrimaryKey(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the city map types where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the city map types where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @return the range of matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the city map types where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first city map type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns the first city map type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map type, or <code>null</code> if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last city map type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns the last city map type in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map type, or <code>null</code> if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city map types before and after the current city map type in the ordered set where companyId = &#63;.
	*
	* @param typeId the primary key of the current city map type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType[] findByCompany_PrevAndNext(
		long typeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns all the city map types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the city map types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @return the range of matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the city map types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first city map type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns the first city map type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching city map type, or <code>null</code> if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last city map type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns the last city map type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching city map type, or <code>null</code> if a matching city map type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city map types before and after the current city map type in the ordered set where groupId = &#63;.
	*
	* @param typeId the primary key of the current city map type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType[] findByGroup_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns all the city map types that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching city map types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the city map types that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @return the range of matching city map types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the city map types that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching city map types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the city map types before and after the current city map type in the ordered set of city map types that the user has permission to view where groupId = &#63;.
	*
	* @param typeId the primary key of the current city map type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next city map type
	* @throws com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType[] filterFindByGroup_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException;

	/**
	* Returns all the city map types.
	*
	* @return the city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the city map types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @return the range of city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the city map types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of city map types
	* @param end the upper bound of the range of city map types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of city map types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city map types where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city map types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the city map types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city map types where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city map types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching city map types
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city map types that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching city map types that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of city map types.
	*
	* @return the number of city map types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}