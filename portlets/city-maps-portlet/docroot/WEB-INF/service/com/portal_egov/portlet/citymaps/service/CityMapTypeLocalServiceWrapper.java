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
 * This class is a wrapper for {@link CityMapTypeLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       CityMapTypeLocalService
 * @generated
 */
public class CityMapTypeLocalServiceWrapper implements CityMapTypeLocalService,
	ServiceWrapper<CityMapTypeLocalService> {
	public CityMapTypeLocalServiceWrapper(
		CityMapTypeLocalService cityMapTypeLocalService) {
		_cityMapTypeLocalService = cityMapTypeLocalService;
	}

	/**
	* Adds the city map type to the database. Also notifies the appropriate model listeners.
	*
	* @param cityMapType the city map type
	* @return the city map type that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType addCityMapType(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.addCityMapType(cityMapType);
	}

	/**
	* Creates a new city map type with the primary key. Does not add the city map type to the database.
	*
	* @param typeId the primary key for the new city map type
	* @return the new city map type
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType createCityMapType(
		long typeId) {
		return _cityMapTypeLocalService.createCityMapType(typeId);
	}

	/**
	* Deletes the city map type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the city map type
	* @return the city map type that was removed
	* @throws PortalException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType deleteCityMapType(
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.deleteCityMapType(typeId);
	}

	/**
	* Deletes the city map type from the database. Also notifies the appropriate model listeners.
	*
	* @param cityMapType the city map type
	* @return the city map type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType deleteCityMapType(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.deleteCityMapType(cityMapType);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cityMapTypeLocalService.dynamicQuery();
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
		return _cityMapTypeLocalService.dynamicQuery(dynamicQuery);
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
		return _cityMapTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _cityMapTypeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cityMapTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.citymaps.model.CityMapType fetchCityMapType(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.fetchCityMapType(typeId);
	}

	/**
	* Returns the city map type with the primary key.
	*
	* @param typeId the primary key of the city map type
	* @return the city map type
	* @throws PortalException if a city map type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType getCityMapType(
		long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.getCityMapType(typeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> getCityMapTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.getCityMapTypes(start, end);
	}

	/**
	* Returns the number of city map types.
	*
	* @return the number of city map types
	* @throws SystemException if a system exception occurred
	*/
	public int getCityMapTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.getCityMapTypesCount();
	}

	/**
	* Updates the city map type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMapType the city map type
	* @return the city map type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType updateCityMapType(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.updateCityMapType(cityMapType);
	}

	/**
	* Updates the city map type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMapType the city map type
	* @param merge whether to merge the city map type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the city map type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.citymaps.model.CityMapType updateCityMapType(
		com.portal_egov.portlet.citymaps.model.CityMapType cityMapType,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.updateCityMapType(cityMapType, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cityMapTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cityMapTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cityMapTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.countByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.citymaps.model.CityMapType> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.findByGroup(groupId, start, end);
	}

	public com.portal_egov.portlet.citymaps.model.CityMapType addMapType(
		long companyId, long groupId, long userId, java.lang.String userName,
		java.lang.String typeName, java.lang.String typeDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.addMapType(companyId, groupId, userId,
			userName, typeName, typeDesc, serviceContext);
	}

	public com.portal_egov.portlet.citymaps.model.CityMapType updateMapType(
		long typeId, long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String typeName,
		java.lang.String typeDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cityMapTypeLocalService.updateMapType(typeId, companyId,
			groupId, userId, userName, typeName, typeDesc);
	}

	public java.lang.String getMapTypeName(java.lang.String typeId) {
		return _cityMapTypeLocalService.getMapTypeName(typeId);
	}

	public void deleteMapType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapTypeException {
		_cityMapTypeLocalService.deleteMapType(typeId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CityMapTypeLocalService getWrappedCityMapTypeLocalService() {
		return _cityMapTypeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCityMapTypeLocalService(
		CityMapTypeLocalService cityMapTypeLocalService) {
		_cityMapTypeLocalService = cityMapTypeLocalService;
	}

	public CityMapTypeLocalService getWrappedService() {
		return _cityMapTypeLocalService;
	}

	public void setWrappedService(
		CityMapTypeLocalService cityMapTypeLocalService) {
		_cityMapTypeLocalService = cityMapTypeLocalService;
	}

	private CityMapTypeLocalService _cityMapTypeLocalService;
}