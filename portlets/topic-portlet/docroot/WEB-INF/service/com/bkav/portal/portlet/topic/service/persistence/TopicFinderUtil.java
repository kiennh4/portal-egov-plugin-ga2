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

package com.bkav.portal.portlet.topic.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author anhbdb
 */
public class TopicFinderUtil {
	public static java.util.List<com.bkav.portal.portlet.topic.model.Topic> findByTopicName(
		long groupId, java.lang.String topicName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder().findByTopicName(groupId, topicName, start, end, obc);
	}

	public static TopicFinder getFinder() {
		if (_finder == null) {
			_finder = (TopicFinder)PortletBeanLocatorUtil.locate(com.bkav.portal.portlet.topic.service.ClpSerializer.getServletContextName(),
					TopicFinder.class.getName());

			ReferenceRegistry.registerReference(TopicFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(TopicFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TopicFinderUtil.class, "_finder");
	}

	private static TopicFinder _finder;
}