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

package com.portal_egov.portlet.citymaps.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CityMapLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       CityMapLocalService
 * @generated
 */
public class CityMapLocalServiceWrapper implements CityMapLocalService,
	ServiceWrapper<CityMapLocalService> {
	public CityMapLocalServiceWrapper(CityMapLocalService cityMapLocalService) {
		_cityMapLocalService = cityMapLocalService;
	}

	/**
	* Adds the city map to the database. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @return the city map that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap addCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.addCityMap(cityMap);
	}

	/**
	* Creates a new city map with the primary key. Does not add the city map to the database.
	*
	* @param mapId the primary key for the new city map
	* @return the new city map
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap createCityMap(
		long mapId) {
		return _cityMapLocalService.createCityMap(mapId);
	}

	/**
	* Deletes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the city map
	* @return the city map that was removed
	* @throws PortalException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap deleteCityMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.deleteCityMap(mapId);
	}

	/**
	* Deletes the city map from the database. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @return the city map that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap deleteCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.deleteCityMap(cityMap);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cityMapLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.citymaps.model.CityMap fetchCityMap(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.fetchCityMap(mapId);
	}

	/**
	* Returns the city map with the primary key.
	*
	* @param mapId the primary key of the city map
	* @return the city map
	* @throws PortalException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap getCityMap(long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.getCityMap(mapId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> getCityMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.getCityMaps(start, end);
	}

	/**
	* Returns the number of city maps.
	*
	* @return the number of city maps
	* @throws SystemException if a system exception occurred
	*/
	public int getCityMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.getCityMapsCount();
	}

	/**
	* Updates the city map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @return the city map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap updateCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.updateCityMap(cityMap);
	}

	/**
	* Updates the city map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @param merge whether to merge the city map with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the city map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMap updateCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.updateCityMap(cityMap, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cityMapLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cityMapLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cityMapLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.countByGroup(groupId);
	}

	public int countByType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.countByType(typeId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByType(typeId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long typeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByType(typeId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByKeyword(
		long groupId, long mapTypeId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.findByKeyword(groupId, mapTypeId, keyword,
			start, end, obc);
	}

	public com.portal_egov.portlet.citymaps.model.CityMap addMap(
		long companyId, long groupId, long userId, java.lang.String userName,
		long mapTypeId, long mapImageId, java.lang.String mapName,
		java.lang.String mapDesc, java.lang.String mapSumary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.addMap(companyId, groupId, userId,
			userName, mapTypeId, mapImageId, mapName, mapDesc, mapSumary,
			serviceContext);
	}

	public com.portal_egov.portlet.citymaps.model.CityMap updateMap(
		long companyId, long groupId, long userId, java.lang.String userName,
		long mapId, long mapTypeId, long mapImageId, java.lang.String mapName,
		java.lang.String mapDesc, java.lang.String mapSumary)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapLocalService.updateMap(companyId, groupId, userId,
			userName, mapId, mapTypeId, mapImageId, mapName, mapDesc, mapSumary);
	}

	public void deleteMap(long mapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		_cityMapLocalService.deleteMap(mapId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CityMapLocalService getWrappedCityMapLocalService() {
		return _cityMapLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCityMapLocalService(
		CityMapLocalService cityMapLocalService) {
		_cityMapLocalService = cityMapLocalService;
	}

	public CityMapLocalService getWrappedService() {
		return _cityMapLocalService;
	}

	public void setWrappedService(CityMapLocalService cityMapLocalService) {
		_cityMapLocalService = cityMapLocalService;
	}

	private CityMapLocalService _cityMapLocalService;
}