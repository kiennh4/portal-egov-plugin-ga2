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
public class PostFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.employee.model.Post> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static PostFinder getFinder() {
		if (_finder == null) {
			_finder = (PostFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.employee.service.ClpSerializer.getServletContextName(),
					PostFinder.class.getName());

			ReferenceRegistry.registerReference(PostFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(PostFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PostFinderUtil.class, "_finder");
	}

	private static PostFinder _finder;
}