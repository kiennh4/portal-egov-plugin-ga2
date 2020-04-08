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

package com.portal_egov.portlet.contacts.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author HungDX
 */
public class ContactsPropertyFinderUtil {
	public static java.util.List<com.portal_egov.portlet.contacts.model.ContactsProperty> findByPropertyKey(
		long groupId, long contactId, java.lang.String propertyKey) {
		return getFinder().findByPropertyKey(groupId, contactId, propertyKey);
	}

	public static ContactsPropertyFinder getFinder() {
		if (_finder == null) {
			_finder = (ContactsPropertyFinder)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.contacts.service.ClpSerializer.getServletContextName(),
					ContactsPropertyFinder.class.getName());

			ReferenceRegistry.registerReference(ContactsPropertyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContactsPropertyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContactsPropertyFinderUtil.class,
			"_finder");
	}

	private static ContactsPropertyFinder _finder;
}