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

package com.portal_egov.portlet.proposition_feedback.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class FeedbackDateComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "PropositionFeedback.createDate ASC";

	public static final String ORDER_BY_DESC = "PropositionFeedback.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};

	public FeedbackDateComparator() {

		this(false);
	}

	public FeedbackDateComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		PropositionFeedback feedback1 = (PropositionFeedback) obj1;
		PropositionFeedback feedback2 = (PropositionFeedback) obj2;

		int value = DateUtil.compareTo(feedback1.getCreateDate(), feedback2.getCreateDate());

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