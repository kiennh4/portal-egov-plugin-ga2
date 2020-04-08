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

package com.bkav.portal.portlet.video.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author hungdx
 */
public class VideoEntryFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end) {
		return getFinder().findByKeyword(groupId, keyword, start, end);
	}

	public static java.util.List<com.bkav.portal.portlet.video.model.VideoEntry> findByCategoryId(
		long groupId, long categoryId, int start, int end) {
		return getFinder().findByCategoryId(groupId, categoryId, start, end);
	}

	public static VideoEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (VideoEntryFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.video.service.ClpSerializer.getServletContextName(),
					VideoEntryFinder.class.getName());

			ReferenceRegistry.registerReference(VideoEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VideoEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VideoEntryFinderUtil.class,
			"_finder");
	}

	private static VideoEntryFinder _finder;
}