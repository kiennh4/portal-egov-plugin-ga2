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

package com.portal_egov.portlet.ykct.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author DucDVd
 */
public class YKCT_CategoryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Category> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static YKCT_CategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (YKCT_CategoryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.ykct.service.ClpSerializer.getServletContextName(),
					YKCT_CategoryFinder.class.getName());

			ReferenceRegistry.registerReference(YKCT_CategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(YKCT_CategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(YKCT_CategoryFinderUtil.class,
			"_finder");
	}

	private static YKCT_CategoryFinder _finder;
}