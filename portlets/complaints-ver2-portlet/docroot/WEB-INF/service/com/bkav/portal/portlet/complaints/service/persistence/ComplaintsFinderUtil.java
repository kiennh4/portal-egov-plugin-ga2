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

package com.bkav.portal.portlet.complaints.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author AnhBDb
 */
public class ComplaintsFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.complaints.model.Complaints> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder().findByKeyword(groupId, keyword, start, end, obc);
	}

	public static ComplaintsFinder getFinder() {
		if (_finder == null) {
			_finder = (ComplaintsFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.complaints.service.ClpSerializer.getServletContextName(),
					ComplaintsFinder.class.getName());

			ReferenceRegistry.registerReference(ComplaintsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ComplaintsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ComplaintsFinderUtil.class,
			"_finder");
	}

	private static ComplaintsFinder _finder;
}