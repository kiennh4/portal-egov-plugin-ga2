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

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;

/**
 * 
 * @author HuyMQ
 *
 */
public class InquiryApprovedStatusComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "CitizenInquiry.approved ASC";

	public static final String ORDER_BY_DESC = "CitizenInquiry.approved DESC";

	public static final String[] ORDER_BY_FIELDS = {"approved"};

	public InquiryApprovedStatusComparator() {

		this(false);
	}

	public InquiryApprovedStatusComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		CitizenInquiry inquiry1 = (CitizenInquiry) obj1;
		CitizenInquiry inquiry2 = (CitizenInquiry) obj2;
		
		int comparatorValue = 0;
		
		boolean review1Status = inquiry1.getApproved();
		
		boolean review2Status = inquiry2.getApproved();
		
		if(!review1Status && review2Status){
			
			comparatorValue = 1;
			
		}else if(review1Status && !review2Status){
			
			comparatorValue = -1;
		}
		
		if (_ascending) {
			
			return comparatorValue;
		}
		else {
			return -comparatorValue;
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