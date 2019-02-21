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

package com.bkav.portal_egov.portlet.asset_statistics.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link StatisticEntityService}.
 * </p>
 *
 * @author    HungDX
 * @see       StatisticEntityService
 * @generated
 */
public class StatisticEntityServiceWrapper implements StatisticEntityService,
	ServiceWrapper<StatisticEntityService> {
	public StatisticEntityServiceWrapper(
		StatisticEntityService statisticEntityService) {
		_statisticEntityService = statisticEntityService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _statisticEntityService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statisticEntityService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statisticEntityService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public StatisticEntityService getWrappedStatisticEntityService() {
		return _statisticEntityService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedStatisticEntityService(
		StatisticEntityService statisticEntityService) {
		_statisticEntityService = statisticEntityService;
	}

	public StatisticEntityService getWrappedService() {
		return _statisticEntityService;
	}

	public void setWrappedService(StatisticEntityService statisticEntityService) {
		_statisticEntityService = statisticEntityService;
	}

	private StatisticEntityService _statisticEntityService;
}