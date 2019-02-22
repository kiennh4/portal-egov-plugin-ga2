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

package com.portal_egov.portlet.visit_counter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VisitCounterLogService}.
 * </p>
 *
 * @author    HungDX
 * @see       VisitCounterLogService
 * @generated
 */
public class VisitCounterLogServiceWrapper implements VisitCounterLogService,
	ServiceWrapper<VisitCounterLogService> {
	public VisitCounterLogServiceWrapper(
		VisitCounterLogService visitCounterLogService) {
		_visitCounterLogService = visitCounterLogService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _visitCounterLogService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_visitCounterLogService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _visitCounterLogService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VisitCounterLogService getWrappedVisitCounterLogService() {
		return _visitCounterLogService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVisitCounterLogService(
		VisitCounterLogService visitCounterLogService) {
		_visitCounterLogService = visitCounterLogService;
	}

	public VisitCounterLogService getWrappedService() {
		return _visitCounterLogService;
	}

	public void setWrappedService(VisitCounterLogService visitCounterLogService) {
		_visitCounterLogService = visitCounterLogService;
	}

	private VisitCounterLogService _visitCounterLogService;
}