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
public class ContactsDepartmentFinderUtil {
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsDepartment> findByKeyword(
		long groupId, long parentId, java.lang.String keyword,
		int departmentStatus, int start, int end) {
		return getFinder()
				   .findByKeyword(groupId, parentId, keyword, departmentStatus,
			start, end);
	}

	public static ContactsDepartmentFinder getFinder() {
		if (_finder == null) {
			_finder = (ContactsDepartmentFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsDepartmentFinder.class.getName());

			ReferenceRegistry.registerReference(ContactsDepartmentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContactsDepartmentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContactsDepartmentFinderUtil.class,
			"_finder");
	}

	private static ContactsDepartmentFinder _finder;
}