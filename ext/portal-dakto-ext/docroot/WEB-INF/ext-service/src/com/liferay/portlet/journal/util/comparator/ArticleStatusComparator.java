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

package com.liferay.portlet.journal.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * @author HUNGDX
 */
public class ArticleStatusComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "JournalArticle.status ASC";

	public static final String ORDER_BY_DESC = "JournalArticle.status DESC";

	public static final String[] ORDER_BY_FIELDS = {"status"};

	public ArticleStatusComparator() {
		this(false);
	}

	public ArticleStatusComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		JournalArticle article1 = (JournalArticle)obj1;
		JournalArticle article2 = (JournalArticle)obj2;
		
		int comparatorValue = 0;
		
		if(article1.getStatus() < article2.getStatus()){
			
			comparatorValue = -1;
			
		}else if(article1.getStatus() > article2.getStatus()){
			
			comparatorValue = 1;
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