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

package com.portal_egov.portlet.vbpq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VBPQ_EntryService}.
 * </p>
 *
 * @author    HungDX
 * @see       VBPQ_EntryService
 * @generated
 */
public class VBPQ_EntryServiceWrapper implements VBPQ_EntryService,
	ServiceWrapper<VBPQ_EntryService> {
	public VBPQ_EntryServiceWrapper(VBPQ_EntryService vbpq_EntryService) {
		_vbpq_EntryService = vbpq_EntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vbpq_EntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vbpq_EntryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vbpq_EntryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VBPQ_EntryService getWrappedVBPQ_EntryService() {
		return _vbpq_EntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVBPQ_EntryService(VBPQ_EntryService vbpq_EntryService) {
		_vbpq_EntryService = vbpq_EntryService;
	}

	public VBPQ_EntryService getWrappedService() {
		return _vbpq_EntryService;
	}

	public void setWrappedService(VBPQ_EntryService vbpq_EntryService) {
		_vbpq_EntryService = vbpq_EntryService;
	}

	private VBPQ_EntryService _vbpq_EntryService;
}