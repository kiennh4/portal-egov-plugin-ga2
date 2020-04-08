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
 * This class is a wrapper for {@link TourismMapMarkerGroupService}.
 * </p>
 *
 * @author    HungDX
 * @see       TourismMapMarkerGroupService
 * @generated
 */
public class TourismMapMarkerGroupServiceWrapper
	implements TourismMapMarkerGroupService,
		ServiceWrapper<TourismMapMarkerGroupService> {
	public TourismMapMarkerGroupServiceWrapper(
		TourismMapMarkerGroupService tourismMapMarkerGroupService) {
		_tourismMapMarkerGroupService = tourismMapMarkerGroupService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tourismMapMarkerGroupService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tourismMapMarkerGroupService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tourismMapMarkerGroupService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.liferay.portal.kernel.json.JSONObject getJSONmarkerGroups(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _tourismMapMarkerGroupService.getJSONmarkerGroups(groupId);
	}

	public void deleteMarkerGroup(long markerGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.tourism_map.NoSuchTourismMapMarkerGroupException {
		_tourismMapMarkerGroupService.deleteMarkerGroup(markerGroupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TourismMapMarkerGroupService getWrappedTourismMapMarkerGroupService() {
		return _tourismMapMarkerGroupService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTourismMapMarkerGroupService(
		TourismMapMarkerGroupService tourismMapMarkerGroupService) {
		_tourismMapMarkerGroupService = tourismMapMarkerGroupService;
	}

	public TourismMapMarkerGroupService getWrappedService() {
		return _tourismMapMarkerGroupService;
	}

	public void setWrappedService(
		TourismMapMarkerGroupService tourismMapMarkerGroupService) {
		_tourismMapMarkerGroupService = tourismMapMarkerGroupService;
	}

	private TourismMapMarkerGroupService _tourismMapMarkerGroupService;
}