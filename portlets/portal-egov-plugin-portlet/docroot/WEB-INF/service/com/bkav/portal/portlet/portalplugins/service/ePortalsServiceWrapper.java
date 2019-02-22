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

package com.bkav.portal.portlet.portalplugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ePortalsService}.
 * </p>
 *
 * @author    AnhBDb
 * @see       ePortalsService
 * @generated
 */
public class ePortalsServiceWrapper implements ePortalsService,
	ServiceWrapper<ePortalsService> {
	public ePortalsServiceWrapper(ePortalsService ePortalsService) {
		_ePortalsService = ePortalsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ePortalsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ePortalsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ePortalsService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ePortalsService getWrappedePortalsService() {
		return _ePortalsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedePortalsService(ePortalsService ePortalsService) {
		_ePortalsService = ePortalsService;
	}

	public ePortalsService getWrappedService() {
		return _ePortalsService;
	}

	public void setWrappedService(ePortalsService ePortalsService) {
		_ePortalsService = ePortalsService;
	}

	private ePortalsService _ePortalsService;
}