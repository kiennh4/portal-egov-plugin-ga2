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

package com.portal_egov.portlet.weblinks.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.weblinks.model.Weblink;

/**
 * 
 * @author HuyMQ
 *
 */
public class WeblinkCreateDateComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "Weblink.createDate ASC";

	public static final String ORDER_BY_DESC = "Weblink.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};

	public WeblinkCreateDateComparator() {

		this(false);
	}

	public WeblinkCreateDateComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Weblink weblink1 = (Weblink) obj1;
		Weblink weblink2 = (Weblink) obj2;

		int value = DateUtil.compareTo(weblink1.getCreateDate(), weblink2.getCreateDate());

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