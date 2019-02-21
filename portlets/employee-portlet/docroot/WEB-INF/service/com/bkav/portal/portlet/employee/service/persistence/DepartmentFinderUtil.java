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

package com.bkav.portal.portlet.employee.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ducdvd
 */
public class DepartmentFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.employee.model.Department> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static DepartmentFinder getFinder() {
		if (_finder == null) {
			_finder = (DepartmentFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.employee.service.ClpSerializer.getServletContextName(),
					DepartmentFinder.class.getName());

			ReferenceRegistry.registerReference(DepartmentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DepartmentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DepartmentFinderUtil.class,
			"_finder");
	}

	private static DepartmentFinder _finder;
}