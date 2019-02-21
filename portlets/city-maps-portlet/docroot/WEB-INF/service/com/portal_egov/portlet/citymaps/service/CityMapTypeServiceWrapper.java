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
 * This class is a wrapper for {@link CityMapTypeService}.
 * </p>
 *
 * @author    HungDX
 * @see       CityMapTypeService
 * @generated
 */
public class CityMapTypeServiceWrapper implements CityMapTypeService,
	ServiceWrapper<CityMapTypeService> {
	public CityMapTypeServiceWrapper(CityMapTypeService cityMapTypeService) {
		_cityMapTypeService = cityMapTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cityMapTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cityMapTypeService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cityMapTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.liferay.portal.kernel.json.JSONObject getJSONMapType(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _cityMapTypeService.getJSONMapType(groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CityMapTypeService getWrappedCityMapTypeService() {
		return _cityMapTypeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCityMapTypeService(
		CityMapTypeService cityMapTypeService) {
		_cityMapTypeService = cityMapTypeService;
	}

	public CityMapTypeService getWrappedService() {
		return _cityMapTypeService;
	}

	public void setWrappedService(CityMapTypeService cityMapTypeService) {
		_cityMapTypeService = cityMapTypeService;
	}

	private CityMapTypeService _cityMapTypeService;
}