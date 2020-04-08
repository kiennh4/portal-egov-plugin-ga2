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

package com.portal_egov.portlet.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ContactsDepartmentPropertyService}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsDepartmentPropertyService
 * @generated
 */
public class ContactsDepartmentPropertyServiceWrapper
	implements ContactsDepartmentPropertyService,
		ServiceWrapper<ContactsDepartmentPropertyService> {
	public ContactsDepartmentPropertyServiceWrapper(
		ContactsDepartmentPropertyService contactsDepartmentPropertyService) {
		_contactsDepartmentPropertyService = contactsDepartmentPropertyService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contactsDepartmentPropertyService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactsDepartmentPropertyService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactsDepartmentPropertyService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContactsDepartmentPropertyService getWrappedContactsDepartmentPropertyService() {
		return _contactsDepartmentPropertyService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContactsDepartmentPropertyService(
		ContactsDepartmentPropertyService contactsDepartmentPropertyService) {
		_contactsDepartmentPropertyService = contactsDepartmentPropertyService;
	}

	public ContactsDepartmentPropertyService getWrappedService() {
		return _contactsDepartmentPropertyService;
	}

	public void setWrappedService(
		ContactsDepartmentPropertyService contactsDepartmentPropertyService) {
		_contactsDepartmentPropertyService = contactsDepartmentPropertyService;
	}

	private ContactsDepartmentPropertyService _contactsDepartmentPropertyService;
}