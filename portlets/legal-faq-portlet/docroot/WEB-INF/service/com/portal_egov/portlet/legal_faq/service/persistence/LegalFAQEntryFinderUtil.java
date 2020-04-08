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

package com.portal_egov.portlet.legal_faq.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class LegalFAQEntryFinderUtil {
	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getFinder()
				   .findByKeyword(groupId, categoryId, keyword, start, end, obc);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByKeywordAndStatus(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end) {
		return getFinder()
				   .findByKeywordAndStatus(groupId, categoryId, keyword, start,
			end);
	}

	public static java.util.List<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> findByViewCount(
		long groupId, long categoryId, int start, int end) {
		return getFinder().findByViewCount(groupId, categoryId, start, end);
	}

	public static LegalFAQEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (LegalFAQEntryFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.legal_faq.service.ClpSerializer.getServletContextName(),
					LegalFAQEntryFinder.class.getName());

			ReferenceRegistry.registerReference(LegalFAQEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(LegalFAQEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(LegalFAQEntryFinderUtil.class,
			"_finder");
	}

	private static LegalFAQEntryFinder _finder;
}