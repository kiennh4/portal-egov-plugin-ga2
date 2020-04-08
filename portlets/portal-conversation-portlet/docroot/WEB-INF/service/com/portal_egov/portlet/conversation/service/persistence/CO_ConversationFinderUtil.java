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

package com.portal_egov.portlet.conversation.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author DucDVd
 */
public class CO_ConversationFinderUtil {
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int conversationStatus) {
		return getFinder()
				   .findByKeywordAndStatus(companyId, keyword,
			conversationStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findUnpublishEntry(
		long groupId, java.lang.String searchKeyword) {
		return getFinder().findUnpublishEntry(groupId, searchKeyword);
	}

	public static CO_ConversationFinder getFinder() {
		if (_finder == null) {
			_finder = (CO_ConversationFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.conversation.service.ClpSerializer.getServletContextName(),
					CO_ConversationFinder.class.getName());

			ReferenceRegistry.registerReference(CO_ConversationFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CO_ConversationFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CO_ConversationFinderUtil.class,
			"_finder");
	}

	private static CO_ConversationFinder _finder;
}