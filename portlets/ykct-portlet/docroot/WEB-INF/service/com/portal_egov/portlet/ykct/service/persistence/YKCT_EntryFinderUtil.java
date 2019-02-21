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
public class YKCT_EntryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.ykct.model.YKCT_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long categoryId, int start,
		int end) {
		return getFinder()
				   .findByMultiCondition(groupId, keyword, categoryId, start,
			end);
	}

	public static YKCT_EntryFinder getFinder() {
		if (_finder == null) {
			_finder = (YKCT_EntryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.ykct.service.ClpSerializer.getServletContextName(),
					YKCT_EntryFinder.class.getName());

			ReferenceRegistry.registerReference(YKCT_EntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(YKCT_EntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(YKCT_EntryFinderUtil.class,
			"_finder");
	}

	private static YKCT_EntryFinder _finder;
}