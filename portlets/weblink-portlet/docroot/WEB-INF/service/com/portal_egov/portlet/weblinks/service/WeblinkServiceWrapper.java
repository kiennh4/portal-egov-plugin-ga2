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

package com.portal_egov.portlet.weblinks.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WeblinkService}.
 * </p>
 *
 * @author    HungDX
 * @see       WeblinkService
 * @generated
 */
public class WeblinkServiceWrapper implements WeblinkService,
	ServiceWrapper<WeblinkService> {
	public WeblinkServiceWrapper(WeblinkService weblinkService) {
		_weblinkService = weblinkService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _weblinkService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_weblinkService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _weblinkService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WeblinkService getWrappedWeblinkService() {
		return _weblinkService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWeblinkService(WeblinkService weblinkService) {
		_weblinkService = weblinkService;
	}

	public WeblinkService getWrappedService() {
		return _weblinkService;
	}

	public void setWrappedService(WeblinkService weblinkService) {
		_weblinkService = weblinkService;
	}

	private WeblinkService _weblinkService;
}