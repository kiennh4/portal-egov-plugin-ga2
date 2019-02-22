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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the contacts department remote service. This utility wraps {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author HungDX
 * @see ContactsDepartmentService
 * @see com.portal_egov.portlet.contacts.service.base.ContactsDepartmentServiceBaseImpl
 * @see com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentServiceImpl
 * @generated
 */
public class ContactsDepartmentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.contacts.service.impl.ContactsDepartmentServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.portal_egov.portlet.contacts.model.ContactsDepartment getDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDepartment(departmentId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getGroupDepartments(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return getService().getGroupDepartments(groupId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getChildDepartments(
		long groupId, long parentDepartmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return getService().getChildDepartments(groupId, parentDepartmentId);
	}

	public static int countChildDepartment(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countChildDepartment(groupId, departmentId);
	}

	public static void updateDepartmentState(long departmentId,
		int displayPriority)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		getService().updateDepartmentState(departmentId, displayPriority);
	}

	public static void updateDepartmentParent(long departmentId,
		long parentDepartmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		getService().updateDepartmentParent(departmentId, parentDepartmentId);
	}

	public static void deleteDepartment(long groupId, long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		getService().deleteDepartment(groupId, departmentId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactsDepartmentService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactsDepartmentService.class.getName());

			if (invokableService instanceof ContactsDepartmentService) {
				_service = (ContactsDepartmentService)invokableService;
			}
			else {
				_service = new ContactsDepartmentServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ContactsDepartmentServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ContactsDepartmentService service) {
	}

	private static ContactsDepartmentService _service;
}