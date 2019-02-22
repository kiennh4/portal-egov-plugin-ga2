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

package com.portal_egov.portlet.landprice.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the land location local service. This utility wraps {@link com.portal_egov.portlet.landprice.service.impl.LandLocationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author HungDX
 * @see LandLocationLocalService
 * @see com.portal_egov.portlet.landprice.service.base.LandLocationLocalServiceBaseImpl
 * @see com.portal_egov.portlet.landprice.service.impl.LandLocationLocalServiceImpl
 * @generated
 */
public class LandLocationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.landprice.service.impl.LandLocationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the land location to the database. Also notifies the appropriate model listeners.
	*
	* @param landLocation the land location
	* @return the land location that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation addLandLocation(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLandLocation(landLocation);
	}

	/**
	* Creates a new land location with the primary key. Does not add the land location to the database.
	*
	* @param locationId the primary key for the new land location
	* @return the new land location
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation createLandLocation(
		long locationId) {
		return getService().createLandLocation(locationId);
	}

	/**
	* Deletes the land location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the land location
	* @return the land location that was removed
	* @throws PortalException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation deleteLandLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLandLocation(locationId);
	}

	/**
	* Deletes the land location from the database. Also notifies the appropriate model listeners.
	*
	* @param landLocation the land location
	* @return the land location that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation deleteLandLocation(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLandLocation(landLocation);
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

	public static com.portal_egov.portlet.landprice.model.LandLocation fetchLandLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLandLocation(locationId);
	}

	/**
	* Returns the land location with the primary key.
	*
	* @param locationId the primary key of the land location
	* @return the land location
	* @throws PortalException if a land location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation getLandLocation(
		long locationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLandLocation(locationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> getLandLocations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLandLocations(start, end);
	}

	/**
	* Returns the number of land locations.
	*
	* @return the number of land locations
	* @throws SystemException if a system exception occurred
	*/
	public static int getLandLocationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLandLocationsCount();
	}

	/**
	* Updates the land location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landLocation the land location
	* @return the land location that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation updateLandLocation(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLandLocation(landLocation);
	}

	/**
	* Updates the land location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landLocation the land location
	* @param merge whether to merge the land location with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the land location that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.landprice.model.LandLocation updateLandLocation(
		com.portal_egov.portlet.landprice.model.LandLocation landLocation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLandLocation(landLocation, merge);
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

	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByParentLocation(
		long parentLocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByParentLocation(parentLocationId);
	}

	public static java.util.List<com.portal_egov.portlet.landprice.model.LandLocation> findByKeyword(
		long groupId, long parentLocationId, java.lang.String keyword,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .findByKeyword(groupId, parentLocationId, keyword, start,
			end, obc);
	}

	public static com.portal_egov.portlet.landprice.model.LandLocation addLocation(
		long companyId, long groupId, long userId, java.lang.String userName,
		long parentLocationId, java.lang.String locationName,
		java.lang.String locationInfo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLocation(companyId, groupId, userId, userName,
			parentLocationId, locationName, locationInfo, serviceContext);
	}

	public static com.portal_egov.portlet.landprice.model.LandLocation updateLocation(
		long locationId, long companyId, long groupId, long userId,
		java.lang.String userName, long parentLocationId,
		java.lang.String locationName, java.lang.String locationInfo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLocation(locationId, companyId, groupId, userId,
			userName, parentLocationId, locationName, locationInfo,
			serviceContext);
	}

	public static void deleteLocation(long locationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.landprice.NoSuchLandLocationException {
		getService().deleteLocation(locationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LandLocationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LandLocationLocalService.class.getName());

			if (invokableLocalService instanceof LandLocationLocalService) {
				_service = (LandLocationLocalService)invokableLocalService;
			}
			else {
				_service = new LandLocationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LandLocationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LandLocationLocalService service) {
	}

	private static LandLocationLocalService _service;
}