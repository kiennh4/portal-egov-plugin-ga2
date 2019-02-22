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

package com.portal_egov.portlet.proposition_feedback.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class PropositionFeedbackFinderUtil {
	public static java.util.List<com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback> findByKeyword(
		long groupId, long propositionId, java.lang.String keyword,
		int feedbackStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .findByKeyword(groupId, propositionId, keyword,
			feedbackStatus, start, end, obc);
	}

	public static PropositionFeedbackFinder getFinder() {
		if (_finder == null) {
			_finder = (PropositionFeedbackFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.proposition_feedback.service.ClpSerializer.getServletContextName(),
					PropositionFeedbackFinder.class.getName());

			ReferenceRegistry.registerReference(PropositionFeedbackFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PropositionFeedbackFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PropositionFeedbackFinderUtil.class,
			"_finder");
	}

	private static PropositionFeedbackFinder _finder;
}