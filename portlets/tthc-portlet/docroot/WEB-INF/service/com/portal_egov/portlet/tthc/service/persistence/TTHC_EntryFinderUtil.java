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

package com.portal_egov.portlet.tthc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class TTHC_EntryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.tthc.model.TTHC_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long levelId,
		long departmentId, long categoryId, long audienceId, long resultTypeId,
		int start, int end) {
		return getFinder()
				   .findByMultiCondition(groupId, keyword, levelId,
			departmentId, categoryId, audienceId, resultTypeId, start, end);
	}

	public static TTHC_EntryFinder getFinder() {
		if (_finder == null) {
			_finder = (TTHC_EntryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.tthc.service.ClpSerializer.getServletContextName(),
					TTHC_EntryFinder.class.getName());

			ReferenceRegistry.registerReference(TTHC_EntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TTHC_EntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TTHC_EntryFinderUtil.class,
			"_finder");
	}

	private static TTHC_EntryFinder _finder;
}