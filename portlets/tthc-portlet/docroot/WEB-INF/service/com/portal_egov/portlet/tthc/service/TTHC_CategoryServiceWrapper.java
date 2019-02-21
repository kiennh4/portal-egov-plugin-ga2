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

package com.portal_egov.portlet.tthc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TTHC_CategoryService}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_CategoryService
 * @generated
 */
public class TTHC_CategoryServiceWrapper implements TTHC_CategoryService,
	ServiceWrapper<TTHC_CategoryService> {
	public TTHC_CategoryServiceWrapper(
		TTHC_CategoryService tthc_CategoryService) {
		_tthc_CategoryService = tthc_CategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc_CategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc_CategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tthc_CategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC_CategoryService getWrappedTTHC_CategoryService() {
		return _tthc_CategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC_CategoryService(
		TTHC_CategoryService tthc_CategoryService) {
		_tthc_CategoryService = tthc_CategoryService;
	}

	public TTHC_CategoryService getWrappedService() {
		return _tthc_CategoryService;
	}

	public void setWrappedService(TTHC_CategoryService tthc_CategoryService) {
		_tthc_CategoryService = tthc_CategoryService;
	}

	private TTHC_CategoryService _tthc_CategoryService;
}