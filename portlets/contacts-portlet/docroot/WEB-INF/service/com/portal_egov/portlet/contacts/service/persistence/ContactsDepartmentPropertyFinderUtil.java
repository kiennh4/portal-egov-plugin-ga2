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

package com.portal_egov.portlet.contacts.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class ContactsDepartmentPropertyFinderUtil {
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty> findByPropertyKey(
		long groupId, long departmentId, java.lang.String propertyKey) {
		return getFinder().findByPropertyKey(groupId, departmentId, propertyKey);
	}

	public static ContactsDepartmentPropertyFinder getFinder() {
		if (_finder == null) {
			_finder = (ContactsDepartmentPropertyFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsDepartmentPropertyFinder.class.getName());

			ReferenceRegistry.registerReference(ContactsDepartmentPropertyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContactsDepartmentPropertyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContactsDepartmentPropertyFinderUtil.class,
			"_finder");
	}

	private static ContactsDepartmentPropertyFinder _finder;
}