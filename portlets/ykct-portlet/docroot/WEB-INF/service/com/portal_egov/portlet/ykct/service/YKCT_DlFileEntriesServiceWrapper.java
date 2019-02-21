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
 * This class is a wrapper for {@link YKCT_DlFileEntriesService}.
 * </p>
 *
 * @author    DucDVd
 * @see       YKCT_DlFileEntriesService
 * @generated
 */
public class YKCT_DlFileEntriesServiceWrapper
	implements YKCT_DlFileEntriesService,
		ServiceWrapper<YKCT_DlFileEntriesService> {
	public YKCT_DlFileEntriesServiceWrapper(
		YKCT_DlFileEntriesService ykct_DlFileEntriesService) {
		_ykct_DlFileEntriesService = ykct_DlFileEntriesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ykct_DlFileEntriesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ykct_DlFileEntriesService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ykct_DlFileEntriesService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public YKCT_DlFileEntriesService getWrappedYKCT_DlFileEntriesService() {
		return _ykct_DlFileEntriesService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedYKCT_DlFileEntriesService(
		YKCT_DlFileEntriesService ykct_DlFileEntriesService) {
		_ykct_DlFileEntriesService = ykct_DlFileEntriesService;
	}

	public YKCT_DlFileEntriesService getWrappedService() {
		return _ykct_DlFileEntriesService;
	}

	public void setWrappedService(
		YKCT_DlFileEntriesService ykct_DlFileEntriesService) {
		_ykct_DlFileEntriesService = ykct_DlFileEntriesService;
	}

	private YKCT_DlFileEntriesService _ykct_DlFileEntriesService;
}