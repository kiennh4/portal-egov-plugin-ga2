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

package com.portal_egov.portlet.compaints.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Complaint_DlFileEntriesService}.
 * </p>
 *
 * @author    HungDX
 * @see       Complaint_DlFileEntriesService
 * @generated
 */
public class Complaint_DlFileEntriesServiceWrapper
	implements Complaint_DlFileEntriesService,
		ServiceWrapper<Complaint_DlFileEntriesService> {
	public Complaint_DlFileEntriesServiceWrapper(
		Complaint_DlFileEntriesService complaint_DlFileEntriesService) {
		_complaint_DlFileEntriesService = complaint_DlFileEntriesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _complaint_DlFileEntriesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_complaint_DlFileEntriesService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _complaint_DlFileEntriesService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public Complaint_DlFileEntriesService getWrappedComplaint_DlFileEntriesService() {
		return _complaint_DlFileEntriesService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedComplaint_DlFileEntriesService(
		Complaint_DlFileEntriesService complaint_DlFileEntriesService) {
		_complaint_DlFileEntriesService = complaint_DlFileEntriesService;
	}

	public Complaint_DlFileEntriesService getWrappedService() {
		return _complaint_DlFileEntriesService;
	}

	public void setWrappedService(
		Complaint_DlFileEntriesService complaint_DlFileEntriesService) {
		_complaint_DlFileEntriesService = complaint_DlFileEntriesService;
	}

	private Complaint_DlFileEntriesService _complaint_DlFileEntriesService;
}