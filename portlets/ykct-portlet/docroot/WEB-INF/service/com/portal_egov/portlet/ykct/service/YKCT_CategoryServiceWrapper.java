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

package com.portal_egov.portlet.ykct.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link YKCT_CategoryService}.
 * </p>
 *
 * @author    DucDVd
 * @see       YKCT_CategoryService
 * @generated
 */
public class YKCT_CategoryServiceWrapper implements YKCT_CategoryService,
	ServiceWrapper<YKCT_CategoryService> {
	public YKCT_CategoryServiceWrapper(
		YKCT_CategoryService ykct_CategoryService) {
		_ykct_CategoryService = ykct_CategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ykct_CategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ykct_CategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ykct_CategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public YKCT_CategoryService getWrappedYKCT_CategoryService() {
		return _ykct_CategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedYKCT_CategoryService(
		YKCT_CategoryService ykct_CategoryService) {
		_ykct_CategoryService = ykct_CategoryService;
	}

	public YKCT_CategoryService getWrappedService() {
		return _ykct_CategoryService;
	}

	public void setWrappedService(YKCT_CategoryService ykct_CategoryService) {
		_ykct_CategoryService = ykct_CategoryService;
	}

	private YKCT_CategoryService _ykct_CategoryService;
}