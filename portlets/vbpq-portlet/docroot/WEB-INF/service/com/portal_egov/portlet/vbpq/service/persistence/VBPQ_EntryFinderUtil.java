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

package com.portal_egov.portlet.vbpq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class VBPQ_EntryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.vbpq.model.VBPQ_Entry> findByMultiCondition(
		long groupId, java.lang.String keyword, long departmentId,
		long categoryId, long docTypeId, java.lang.String startDate,
		java.lang.String endDate, int expirationStatus, int start, int end) {
		return getFinder()
				   .findByMultiCondition(groupId, keyword, departmentId,
			categoryId, docTypeId, startDate, endDate, expirationStatus, start,
			end);
	}

	public static VBPQ_EntryFinder getFinder() {
		if (_finder == null) {
			_finder = (VBPQ_EntryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.vbpq.service.ClpSerializer.getServletContextName(),
					VBPQ_EntryFinder.class.getName());

			ReferenceRegistry.registerReference(VBPQ_EntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VBPQ_EntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VBPQ_EntryFinderUtil.class,
			"_finder");
	}

	private static VBPQ_EntryFinder _finder;
}