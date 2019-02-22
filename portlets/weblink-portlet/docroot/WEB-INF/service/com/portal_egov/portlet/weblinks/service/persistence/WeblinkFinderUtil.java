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

package com.portal_egov.portlet.weblinks.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class WeblinkFinderUtil {
	public static java.util.List<com.portal_egov.portlet.weblinks.model.Weblink> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static WeblinkFinder getFinder() {
		if (_finder == null) {
			_finder = (WeblinkFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.weblinks.service.ClpSerializer.getServletContextName(),
					WeblinkFinder.class.getName());

			ReferenceRegistry.registerReference(WeblinkFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(WeblinkFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(WeblinkFinderUtil.class, "_finder");
	}

	private static WeblinkFinder _finder;
}