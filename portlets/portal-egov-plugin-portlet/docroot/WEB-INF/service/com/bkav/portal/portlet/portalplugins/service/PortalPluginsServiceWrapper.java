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

package com.bkav.portal.portlet.portalplugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PortalPluginsService}.
 * </p>
 *
 * @author    AnhBDb
 * @see       PortalPluginsService
 * @generated
 */
public class PortalPluginsServiceWrapper implements PortalPluginsService,
	ServiceWrapper<PortalPluginsService> {
	public PortalPluginsServiceWrapper(
		PortalPluginsService portalPluginsService) {
		_portalPluginsService = portalPluginsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _portalPluginsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portalPluginsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portalPluginsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portalPluginsService.findByGroupId(groupId);
	}

	public java.util.List<com.bkav.portal.portlet.portalplugins.model.PortalPlugins> findByEportalCode(
		java.lang.String ePortalCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portalPluginsService.findByEportalCode(ePortalCode);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PortalPluginsService getWrappedPortalPluginsService() {
		return _portalPluginsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPortalPluginsService(
		PortalPluginsService portalPluginsService) {
		_portalPluginsService = portalPluginsService;
	}

	public PortalPluginsService getWrappedService() {
		return _portalPluginsService;
	}

	public void setWrappedService(PortalPluginsService portalPluginsService) {
		_portalPluginsService = portalPluginsService;
	}

	private PortalPluginsService _portalPluginsService;
}