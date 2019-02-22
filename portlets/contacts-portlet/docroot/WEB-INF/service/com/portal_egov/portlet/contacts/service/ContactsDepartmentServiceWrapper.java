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
 * This class is a wrapper for {@link ContactsDepartmentService}.
 * </p>
 *
 * @author    HungDX
 * @see       ContactsDepartmentService
 * @generated
 */
public class ContactsDepartmentServiceWrapper
	implements ContactsDepartmentService,
		ServiceWrapper<ContactsDepartmentService> {
	public ContactsDepartmentServiceWrapper(
		ContactsDepartmentService contactsDepartmentService) {
		_contactsDepartmentService = contactsDepartmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contactsDepartmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactsDepartmentService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contactsDepartmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.portal_egov.portlet.contacts.model.ContactsDepartment getDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentService.getDepartment(departmentId);
	}

	public com.liferay.portal.kernel.json.JSONObject getGroupDepartments(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _contactsDepartmentService.getGroupDepartments(groupId);
	}

	public com.liferay.portal.kernel.json.JSONObject getChildDepartments(
		long groupId, long parentDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _contactsDepartmentService.getChildDepartments(groupId,
			parentDepartmentId);
	}

	public int countChildDepartment(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactsDepartmentService.countChildDepartment(groupId,
			departmentId);
	}

	public void updateDepartmentState(long departmentId, int displayPriority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_contactsDepartmentService.updateDepartmentState(departmentId,
			displayPriority);
	}

	public void updateDepartmentParent(long departmentId,
		long parentDepartmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_contactsDepartmentService.updateDepartmentParent(departmentId,
			parentDepartmentId);
	}

	public void deleteDepartment(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_contactsDepartmentService.deleteDepartment(groupId, departmentId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContactsDepartmentService getWrappedContactsDepartmentService() {
		return _contactsDepartmentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContactsDepartmentService(
		ContactsDepartmentService contactsDepartmentService) {
		_contactsDepartmentService = contactsDepartmentService;
	}

	public ContactsDepartmentService getWrappedService() {
		return _contactsDepartmentService;
	}

	public void setWrappedService(
		ContactsDepartmentService contactsDepartmentService) {
		_contactsDepartmentService = contactsDepartmentService;
	}

	private ContactsDepartmentService _contactsDepartmentService;
}