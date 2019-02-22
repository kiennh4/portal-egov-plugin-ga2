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

package com.portal_egov.portlet.banner.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.banner.model.Banner;

/**
 * 
 * @author HuyMQ
 *
 */
public class BannerUserNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "Banner.userName ASC";

	public static final String ORDER_BY_DESC = "Banner.userName DESC";

	public static final String[] ORDER_BY_FIELDS = {"userName"};

	public BannerUserNameComparator() {

		this(false);
	}

	public BannerUserNameComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Banner banner1 = (Banner) obj1;
		Banner banner2 = (Banner) obj2;

		int value = banner1.getUserName().toLowerCase().compareTo(banner2.getUserName().toLowerCase());

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