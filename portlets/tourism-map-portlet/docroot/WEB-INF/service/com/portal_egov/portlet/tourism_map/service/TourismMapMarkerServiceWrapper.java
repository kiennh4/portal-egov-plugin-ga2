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
 * This class is a wrapper for {@link TourismMapMarkerService}.
 * </p>
 *
 * @author    HungDX
 * @see       TourismMapMarkerService
 * @generated
 */
public class TourismMapMarkerServiceWrapper implements TourismMapMarkerService,
	ServiceWrapper<TourismMapMarkerService> {
	public TourismMapMarkerServiceWrapper(
		TourismMapMarkerService tourismMapMarkerService) {
		_tourismMapMarkerService = tourismMapMarkerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tourismMapMarkerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tourismMapMarkerService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tourismMapMarkerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.portal_egov.portlet.tourism_map.model.TourismMapMarker getMarker(
		long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tourismMapMarkerService.getMarker(markerId);
	}

	public com.liferay.portal.kernel.json.JSONObject getJSONMarkersByGroup(
		long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _tourismMapMarkerService.getJSONMarkersByGroup(markerGroupId);
	}

	public com.liferay.portal.kernel.json.JSONObject getJSONMarkers(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _tourismMapMarkerService.getJSONMarkers(groupId);
	}

	public void deleteMarker(long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tourismMapMarkerService.deleteMarker(markerId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TourismMapMarkerService getWrappedTourismMapMarkerService() {
		return _tourismMapMarkerService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTourismMapMarkerService(
		TourismMapMarkerService tourismMapMarkerService) {
		_tourismMapMarkerService = tourismMapMarkerService;
	}

	public TourismMapMarkerService getWrappedService() {
		return _tourismMapMarkerService;
	}

	public void setWrappedService(
		TourismMapMarkerService tourismMapMarkerService) {
		_tourismMapMarkerService = tourismMapMarkerService;
	}

	private TourismMapMarkerService _tourismMapMarkerService;
}