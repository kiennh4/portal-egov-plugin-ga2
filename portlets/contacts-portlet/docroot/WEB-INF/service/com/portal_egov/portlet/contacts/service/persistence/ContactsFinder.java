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

/**
 * @author HungDX
 */
public interface ContactsFinder {
	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByKeyword(
		long groupId, java.lang.String keyword, int contactStatus, int start,
		int end);

	public java.util.List<com.portal_egov.portlet.contacts.model.Contacts> findByKeywordAndDepartment(
		long groupId, long departmentId, java.lang.String keyword,
		int contactStatus, int start, int end);
}