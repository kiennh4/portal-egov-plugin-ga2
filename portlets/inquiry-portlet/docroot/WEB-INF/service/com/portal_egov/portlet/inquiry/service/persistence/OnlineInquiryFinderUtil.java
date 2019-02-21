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

package com.portal_egov.portlet.inquiry.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class OnlineInquiryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.inquiry.model.OnlineInquiry> findByKeyword(
		long groupId, java.lang.String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder().findByKeyword(groupId, keyword, start, end, obc);
	}

	public static OnlineInquiryFinder getFinder() {
		if (_finder == null) {
			_finder = (OnlineInquiryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.inquiry.service.ClpSerializer.getServletContextName(),
					OnlineInquiryFinder.class.getName());

			ReferenceRegistry.registerReference(OnlineInquiryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(OnlineInquiryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(OnlineInquiryFinderUtil.class,
			"_finder");
	}

	private static OnlineInquiryFinder _finder;
}