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
 * This class is a wrapper for {@link TTHC_EntryService}.
 * </p>
 *
 * @author    HungDX
 * @see       TTHC_EntryService
 * @generated
 */
public class TTHC_EntryServiceWrapper implements TTHC_EntryService,
	ServiceWrapper<TTHC_EntryService> {
	public TTHC_EntryServiceWrapper(TTHC_EntryService tthc_EntryService) {
		_tthc_EntryService = tthc_EntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tthc_EntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tthc_EntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tthc_EntryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TTHC_EntryService getWrappedTTHC_EntryService() {
		return _tthc_EntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTTHC_EntryService(TTHC_EntryService tthc_EntryService) {
		_tthc_EntryService = tthc_EntryService;
	}

	public TTHC_EntryService getWrappedService() {
		return _tthc_EntryService;
	}

	public void setWrappedService(TTHC_EntryService tthc_EntryService) {
		_tthc_EntryService = tthc_EntryService;
	}

	private TTHC_EntryService _tthc_EntryService;
}