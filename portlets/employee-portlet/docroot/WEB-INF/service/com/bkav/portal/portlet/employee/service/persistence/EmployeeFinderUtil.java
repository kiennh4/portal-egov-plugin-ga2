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
public class EmployeeFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.employee.model.Employee> findByKeyword(
		long groupId, long depId, long postId, java.lang.String keyword,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc,
		java.lang.String check, java.lang.String createDate,
		java.lang.String endDate, java.lang.String checkEndDate) {
		return getFinder()
				   .findByKeyword(groupId, depId, postId, keyword, start, end,
			obc, check, createDate, endDate, checkEndDate);
	}

	public static EmployeeFinder getFinder() {
		if (_finder == null) {
			_finder = (EmployeeFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.employee.service.ClpSerializer.getServletContextName(),
					EmployeeFinder.class.getName());

			ReferenceRegistry.registerReference(EmployeeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EmployeeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EmployeeFinderUtil.class, "_finder");
	}

	private static EmployeeFinder _finder;
}