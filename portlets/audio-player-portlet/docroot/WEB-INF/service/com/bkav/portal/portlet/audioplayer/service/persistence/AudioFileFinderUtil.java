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

package com.bkav.portal.portlet.audioplayer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author anhbdb
 */
public class AudioFileFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.audioplayer.model.AudioFile> findByAudioName(
		long groupId, java.lang.String audioName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder().findByAudioName(groupId, audioName, start, end, obc);
	}

	public static AudioFileFinder getFinder() {
		if (_finder == null) {
			_finder = (AudioFileFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.audioplayer.service.ClpSerializer.getServletContextName(),
					AudioFileFinder.class.getName());

			ReferenceRegistry.registerReference(AudioFileFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AudioFileFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AudioFileFinderUtil.class, "_finder");
	}

	private static AudioFileFinder _finder;
}