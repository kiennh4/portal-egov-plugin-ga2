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

package com.portal_egov.portlet.conversation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CO_CategoryService}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_CategoryService
 * @generated
 */
public class CO_CategoryServiceWrapper implements CO_CategoryService,
	ServiceWrapper<CO_CategoryService> {
	public CO_CategoryServiceWrapper(CO_CategoryService co_CategoryService) {
		_co_CategoryService = co_CategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _co_CategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_co_CategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _co_CategoryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CO_CategoryService getWrappedCO_CategoryService() {
		return _co_CategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCO_CategoryService(
		CO_CategoryService co_CategoryService) {
		_co_CategoryService = co_CategoryService;
	}

	public CO_CategoryService getWrappedService() {
		return _co_CategoryService;
	}

	public void setWrappedService(CO_CategoryService co_CategoryService) {
		_co_CategoryService = co_CategoryService;
	}

	private CO_CategoryService _co_CategoryService;
}