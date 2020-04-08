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

package com.bkav.portal.portlet.complaints.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Complaints_DLFileEntriesService}.
 * </p>
 *
 * @author    AnhBDb
 * @see       Complaints_DLFileEntriesService
 * @generated
 */
public class Complaints_DLFileEntriesServiceWrapper
	implements Complaints_DLFileEntriesService,
		ServiceWrapper<Complaints_DLFileEntriesService> {
	public Complaints_DLFileEntriesServiceWrapper(
		Complaints_DLFileEntriesService complaints_DLFileEntriesService) {
		_complaints_DLFileEntriesService = complaints_DLFileEntriesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _complaints_DLFileEntriesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_complaints_DLFileEntriesService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _complaints_DLFileEntriesService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Complaints_DLFileEntriesService getWrappedComplaints_DLFileEntriesService() {
		return _complaints_DLFileEntriesService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedComplaints_DLFileEntriesService(
		Complaints_DLFileEntriesService complaints_DLFileEntriesService) {
		_complaints_DLFileEntriesService = complaints_DLFileEntriesService;
	}

	public Complaints_DLFileEntriesService getWrappedService() {
		return _complaints_DLFileEntriesService;
	}

	public void setWrappedService(
		Complaints_DLFileEntriesService complaints_DLFileEntriesService) {
		_complaints_DLFileEntriesService = complaints_DLFileEntriesService;
	}

	private Complaints_DLFileEntriesService _complaints_DLFileEntriesService;
}