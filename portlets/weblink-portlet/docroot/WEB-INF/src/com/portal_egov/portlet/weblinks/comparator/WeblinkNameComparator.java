/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.weblinks.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.weblinks.model.Weblink;


public class WeblinkNameComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "Weblink.weblinkName ASC";

	public static final String ORDER_BY_DESC = "Weblink.weblinkName DESC";

	public static final String[] ORDER_BY_FIELDS = {"weblinkName"};
	
	
	public WeblinkNameComparator(){
		this(false);
	}
	
	public WeblinkNameComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Weblink weblink1 = (Weblink) obj1;
		Weblink weblink2 = (Weblink) obj2;
		
		int comparatorValue = weblink1.getWeblinkName().toLowerCase().compareTo(weblink2.getWeblinkName().toLowerCase()); 
		
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
