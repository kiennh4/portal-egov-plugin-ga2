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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the city map local service. This utility wraps {@link com.portal_egov.portlet.citymaps.service.impl.CityMapLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see CityMapLocalService
 * @see com.portal_egov.portlet.citymaps.service.base.CityMapLocalServiceBaseImpl
 * @see com.portal_egov.portlet.citymaps.service.impl.CityMapLocalServiceImpl
 * @generated
 */
public class CityMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.citymaps.service.impl.CityMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the city map to the database. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @return the city map that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap addCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCityMap(cityMap);
	}

	/**
	* Creates a new city map with the primary key. Does not add the city map to the database.
	*
	* @param mapId the primary key for the new city map
	* @return the new city map
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap createCityMap(
		long mapId) {
		return getService().createCityMap(mapId);
	}

	/**
	* Deletes the city map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mapId the primary key of the city map
	* @return the city map that was removed
	* @throws PortalException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap deleteCityMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCityMap(mapId);
	}

	/**
	* Deletes the city map from the database. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @return the city map that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap deleteCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCityMap(cityMap);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.portal_egov.portlet.citymaps.model.CityMap fetchCityMap(
		long mapId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCityMap(mapId);
	}

	/**
	* Returns the city map with the primary key.
	*
	* @param mapId the primary key of the city map
	* @return the city map
	* @throws PortalException if a city map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap getCityMap(
		long mapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCityMap(mapId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> getCityMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCityMaps(start, end);
	}

	/**
	* Returns the number of city maps.
	*
	* @return the number of city maps
	* @throws SystemException if a system exception occurred
	*/
	public static int getCityMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCityMapsCount();
	}

	/**
	* Updates the city map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @return the city map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap updateCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCityMap(cityMap);
	}

	/**
	* Updates the city map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cityMap the city map
	* @param merge whether to merge the city map with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the city map that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.citymaps.model.CityMap updateCityMap(
		com.portal_egov.portlet.citymaps.model.CityMap cityMap, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCityMap(cityMap, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int countByType(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByType(typeId);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByType(typeId);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByType(
		long typeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByType(typeId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.citymaps.model.CityMap> findByKeyword(
		long groupId, long mapTypeId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByKeyword(groupId, mapTypeId, keyword, start, end, obc);
	}

	public static com.portal_egov.portlet.citymaps.model.CityMap addMap(
		long companyId, long groupId, long userId, java.lang.String userName,
		long mapTypeId, long mapImageId, java.lang.String mapName,
		java.lang.String mapDesc,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMap(companyId, groupId, userId, userName, mapTypeId,
			mapImageId, mapName, mapDesc, serviceContext);
	}

	public static com.portal_egov.portlet.citymaps.model.CityMap updateMap(
		long companyId, long groupId, long userId, java.lang.String userName,
		long mapId, long mapTypeId, long mapImageId, java.lang.String mapName,
		java.lang.String mapDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMap(companyId, groupId, userId, userName, mapId,
			mapTypeId, mapImageId, mapName, mapDesc);
	}

	public static void deleteMap(long mapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.citymaps.NoSuchCityMapException {
		getService().deleteMap(mapId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CityMapLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CityMapLocalService.class.getName());

			if (invokableLocalService instanceof CityMapLocalService) {
				_service = (CityMapLocalService)invokableLocalService;
			}
			else {
				_service = new CityMapLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CityMapLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CityMapLocalService service) {
	}

	private static CityMapLocalService _service;
}