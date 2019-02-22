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

package com.portal_egov.portlet.citizen_inquiry.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class InquiryModifiedDateComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "CitizenInquiry.modifiedDate ASC";

	public static final String ORDER_BY_DESC = "CitizenInquiry.modifiedDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"modifiedDate"};

	public InquiryModifiedDateComparator() {

		this(false);
	}

	public InquiryModifiedDateComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		CitizenInquiry inquiry1 = (CitizenInquiry) obj1;
		CitizenInquiry inquiry2 = (CitizenInquiry) obj2;

		int value = DateUtil.compareTo(inquiry1.getModifiedDate(), inquiry2.getModifiedDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}