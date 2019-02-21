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

package com.portal_egov.portlet.citizen_inquiry.service.persistence;

/**
 * @author HungDX
 */
public interface CitizenInquiryFinder {
	public java.util.List<com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry> findByKeyword(
		long groupId, long categoryId, java.lang.String keyword, int start,
		int end, boolean allInquiry,
		com.liferay.portal.kernel.util.OrderByComparator obc);
}