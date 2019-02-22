/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.weblinks.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.weblinks.model.Weblink;


public class WeblinkCategoryIdComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "Weblink.weblinkCategoryId ASC";

	public static final String ORDER_BY_DESC = "Weblink.weblinkCategoryId DESC";

	public static final String[] ORDER_BY_FIELDS = {"weblinkCategoryId"};
	
	
	public WeblinkCategoryIdComparator(){
		this(false);
	}
	
	public WeblinkCategoryIdComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Weblink weblink1 = (Weblink) obj1;
		Weblink weblink2 = (Weblink) obj2;
		
		
		int comparatorValue = 0;
		
		if(weblink1.getWeblinkCategoryId() < weblink2.getWeblinkCategoryId()){
			
			comparatorValue = -1;
			
		}else if(weblink1.getWeblinkCategoryId() > weblink2.getWeblinkCategoryId()){
			
			comparatorValue = 1;
		}
		
		if(_ascending){
			return comparatorValue;
		}else{
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
