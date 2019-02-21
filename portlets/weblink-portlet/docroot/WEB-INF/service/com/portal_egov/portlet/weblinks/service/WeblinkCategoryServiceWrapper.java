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
 * This class is a wrapper for {@link WeblinkCategoryService}.
 * </p>
 *
 * @author    HungDX
 * @see       WeblinkCategoryService
 * @generated
 */
public class WeblinkCategoryServiceWrapper implements WeblinkCategoryService,
	ServiceWrapper<WeblinkCategoryService> {
	public WeblinkCategoryServiceWrapper(
		WeblinkCategoryService weblinkCategoryService) {
		_weblinkCategoryService = weblinkCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _weblinkCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_weblinkCategoryService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _weblinkCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WeblinkCategoryService getWrappedWeblinkCategoryService() {
		return _weblinkCategoryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWeblinkCategoryService(
		WeblinkCategoryService weblinkCategoryService) {
		_weblinkCategoryService = weblinkCategoryService;
	}

	public WeblinkCategoryService getWrappedService() {
		return _weblinkCategoryService;
	}

	public void setWrappedService(WeblinkCategoryService weblinkCategoryService) {
		_weblinkCategoryService = weblinkCategoryService;
	}

	private WeblinkCategoryService _weblinkCategoryService;
}