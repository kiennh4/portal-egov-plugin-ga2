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
 * This class is a wrapper for {@link CO_ThreadService}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_ThreadService
 * @generated
 */
public class CO_ThreadServiceWrapper implements CO_ThreadService,
	ServiceWrapper<CO_ThreadService> {
	public CO_ThreadServiceWrapper(CO_ThreadService co_ThreadService) {
		_co_ThreadService = co_ThreadService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _co_ThreadService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_co_ThreadService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _co_ThreadService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CO_ThreadService getWrappedCO_ThreadService() {
		return _co_ThreadService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCO_ThreadService(CO_ThreadService co_ThreadService) {
		_co_ThreadService = co_ThreadService;
	}

	public CO_ThreadService getWrappedService() {
		return _co_ThreadService;
	}

	public void setWrappedService(CO_ThreadService co_ThreadService) {
		_co_ThreadService = co_ThreadService;
	}

	private CO_ThreadService _co_ThreadService;
}