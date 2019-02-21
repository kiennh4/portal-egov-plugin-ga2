/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citizen_inquiry.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;


public class InquiryCategoryIdComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "CitizenInquiry.categoryId ASC";

	public static final String ORDER_BY_DESC = "CitizenInquiry.categoryId DESC";

	public static final String[] ORDER_BY_FIELDS = {"categoryId"};
	
	
	public InquiryCategoryIdComparator(){
		this(false);
	}
	
	public InquiryCategoryIdComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		CitizenInquiry inquiry1 = (CitizenInquiry) obj1;
		CitizenInquiry inquiry2 = (CitizenInquiry) obj2;
		
		
		int comparatorValue = 0;
		
		if(inquiry1.getCategoryId() < inquiry2.getCategoryId()){
			
			comparatorValue = -1;
			
		}else if(inquiry1.getCategoryId() > inquiry2.getCategoryId()){
			
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
