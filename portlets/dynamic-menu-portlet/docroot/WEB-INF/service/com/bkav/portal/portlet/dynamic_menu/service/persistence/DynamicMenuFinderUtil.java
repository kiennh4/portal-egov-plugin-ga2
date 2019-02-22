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

package com.bkav.portal.portlet.dynamic_menu.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author hungdx
 */
public class DynamicMenuFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static DynamicMenuFinder getFinder() {
		if (_finder == null) {
			_finder = (DynamicMenuFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.dynamic_menu.service.ClpSerializer.getServletContextName(),
					DynamicMenuFinder.class.getName());

			ReferenceRegistry.registerReference(DynamicMenuFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DynamicMenuFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DynamicMenuFinderUtil.class,
			"_finder");
	}

	private static DynamicMenuFinder _finder;
}