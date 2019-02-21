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
 * This class is a wrapper for {@link TTHC_AttributeService}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_AttributeService
 * @generated
 */
public class TTHC_AttributeServiceWrapper implements TTHC_AttributeService,
	ServiceWrapper<TTHC_AttributeService> {
	public TTHC_AttributeServiceWrapper(
		TTHC_AttributeService tthc_AttributeService) {
		_tthc_AttributeService = tthc_AttributeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc_AttributeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc_AttributeService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tthc_AttributeService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC_AttributeService getWrappedTTHC_AttributeService() {
		return _tthc_AttributeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC_AttributeService(
		TTHC_AttributeService tthc_AttributeService) {
		_tthc_AttributeService = tthc_AttributeService;
	}

	public TTHC_AttributeService getWrappedService() {
		return _tthc_AttributeService;
	}

	public void setWrappedService(TTHC_AttributeService tthc_AttributeService) {
		_tthc_AttributeService = tthc_AttributeService;
	}

	private TTHC_AttributeService _tthc_AttributeService;
}