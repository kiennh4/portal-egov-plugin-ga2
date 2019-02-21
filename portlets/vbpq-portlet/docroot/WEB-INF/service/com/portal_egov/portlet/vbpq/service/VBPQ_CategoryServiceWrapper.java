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
 * This class is a wrapper for {@link VBPQ_CategoryService}.
 * </p>
 *
 * @author    HungDX
 * @see       VBPQ_CategoryService
 * @generated
 */
public class VBPQ_CategoryServiceWrapper implements VBPQ_CategoryService,
	ServiceWrapper<VBPQ_CategoryService> {
	public VBPQ_CategoryServiceWrapper(
		VBPQ_CategoryService vbpq_CategoryService) {
		_vbpq_CategoryService = vbpq_CategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vbpq_CategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vbpq_CategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vbpq_CategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VBPQ_CategoryService getWrappedVBPQ_CategoryService() {
		return _vbpq_CategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVBPQ_CategoryService(
		VBPQ_CategoryService vbpq_CategoryService) {
		_vbpq_CategoryService = vbpq_CategoryService;
	}

	public VBPQ_CategoryService getWrappedService() {
		return _vbpq_CategoryService;
	}

	public void setWrappedService(VBPQ_CategoryService vbpq_CategoryService) {
		_vbpq_CategoryService = vbpq_CategoryService;
	}

	private VBPQ_CategoryService _vbpq_CategoryService;
}