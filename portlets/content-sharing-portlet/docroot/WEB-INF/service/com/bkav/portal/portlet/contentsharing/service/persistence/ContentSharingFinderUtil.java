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

package com.bkav.portal.portlet.contentsharing.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author anhbdb
 */
public class ContentSharingFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.contentsharing.model.ContentSharing> getListAudioFileByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .getListAudioFileByCompanyId(companyId, start, end, obc);
	}

	public static ContentSharingFinder getFinder() {
		if (_finder == null) {
			_finder = (ContentSharingFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.contentsharing.service.ClpSerializer.getServletContextName(),
					ContentSharingFinder.class.getName());

			ReferenceRegistry.registerReference(ContentSharingFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContentSharingFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContentSharingFinderUtil.class,
			"_finder");
	}

	private static ContentSharingFinder _finder;
}