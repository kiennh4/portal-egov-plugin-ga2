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

package com.portal_egov.portlet.tourism_map.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TourismMapMarkerLocalService}.
 * </p>
 *
 * @author    HungDX
 * @see       TourismMapMarkerLocalService
 * @generated
 */
public class TourismMapMarkerLocalServiceWrapper
	implements TourismMapMarkerLocalService,
		ServiceWrapper<TourismMapMarkerLocalService> {
	public TourismMapMarkerLocalServiceWrapper(
		TourismMapMarkerLocalService tourismMapMarkerLocalService) {
		_tourismMapMarkerLocalService = tourismMapMarkerLocalService;
	}

	/**
	* Adds the tourism map marker to the database. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarker the tourism map marker
	* @return the tourism map marker that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker addTourismMapMarker(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.addTourismMapMarker(tourismMapMarker);
	}

	/**
	* Creates a new tourism map marker with the primary key. Does not add the tourism map marker to the database.
	*
	* @param markerId the primary key for the new tourism map marker
	* @return the new tourism map marker
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker createTourismMapMarker(
		long markerId) {
		return _tourismMapMarkerLocalService.createTourismMapMarker(markerId);
	}

	/**
	* Deletes the tourism map marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker that was removed
	* @throws PortalException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker deleteTourismMapMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.deleteTourismMapMarker(markerId);
	}

	/**
	* Deletes the tourism map marker from the database. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarker the tourism map marker
	* @return the tourism map marker that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker deleteTourismMapMarker(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.deleteTourismMapMarker(tourismMapMarker);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tourismMapMarkerLocalService.dynamicQuery();
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
		return _tourismMapMarkerLocalService.dynamicQuery(dynamicQuery);
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
		return _tourismMapMarkerLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _tourismMapMarkerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _tourismMapMarkerLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker fetchTourismMapMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.fetchTourismMapMarker(markerId);
	}

	/**
	* Returns the tourism map marker with the primary key.
	*
	* @param markerId the primary key of the tourism map marker
	* @return the tourism map marker
	* @throws PortalException if a tourism map marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker getTourismMapMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.getTourismMapMarker(markerId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tourism map markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tourism map markers
	* @param end the upper bound of the range of tourism map markers (not inclusive)
	* @return the range of tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> getTourismMapMarkers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.getTourismMapMarkers(start, end);
	}

	/**
	* Returns the number of tourism map markers.
	*
	* @return the number of tourism map markers
	* @throws SystemException if a system exception occurred
	*/
	public int getTourismMapMarkersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.getTourismMapMarkersCount();
	}

	/**
	* Updates the tourism map marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarker the tourism map marker
	* @return the tourism map marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker updateTourismMapMarker(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.updateTourismMapMarker(tourismMapMarker);
	}

	/**
	* Updates the tourism map marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tourismMapMarker the tourism map marker
	* @param merge whether to merge the tourism map marker with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tourism map marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker updateTourismMapMarker(
		com.portal_egov.portlet.tourism_map.model.TourismMapMarker tourismMapMarker,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.updateTourismMapMarker(tourismMapMarker,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tourismMapMarkerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tourismMapMarkerLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tourismMapMarkerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.tourism_map.model.TourismMapMarker> findByMarkerGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.findByMarkerGroup(markerGroupId);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker getMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.getMarker(markerId);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker addMarker(
		long companyId, long groupId, long userId, java.lang.String userName,
		long markerGroupId, java.lang.String markerTitle,
		java.lang.String markerInfo, java.lang.String markerAddress,
		long markerImageId, java.lang.String markerLongitude,
		java.lang.String markerLatitude,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.addMarker(companyId, groupId,
			userId, userName, markerGroupId, markerTitle, markerInfo,
			markerAddress, markerImageId, markerLongitude, markerLatitude,
			serviceContext);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker updateMarker(
		long markerId, long companyId, long groupId, long userId,
		java.lang.String userName, long markerGroupId,
		java.lang.String markerTitle, java.lang.String markerInfo,
		java.lang.String markerAddress, long markerImageId,
		java.lang.String markerLongitude, java.lang.String markerLatitude)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerLocalService.updateMarker(markerId, companyId,
			groupId, userId, userName, markerGroupId, markerTitle, markerInfo,
			markerAddress, markerImageId, markerLongitude, markerLatitude);
	}

	public void deleteMarker(long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerException {
		_tourismMapMarkerLocalService.deleteMarker(markerId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TourismMapMarkerLocalService getWrappedTourismMapMarkerLocalService() {
		return _tourismMapMarkerLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTourismMapMarkerLocalService(
		TourismMapMarkerLocalService tourismMapMarkerLocalService) {
		_tourismMapMarkerLocalService = tourismMapMarkerLocalService;
	}

	public TourismMapMarkerLocalService getWrappedService() {
		return _tourismMapMarkerLocalService;
	}

	public void setWrappedService(
		TourismMapMarkerLocalService tourismMapMarkerLocalService) {
		_tourismMapMarkerLocalService = tourismMapMarkerLocalService;
	}

	private TourismMapMarkerLocalService _tourismMapMarkerLocalService;
}