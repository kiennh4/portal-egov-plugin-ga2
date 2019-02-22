/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.legal_faq.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;


public class FAQStatusComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "LegalFAQEntry.status ASC";

	public static final String ORDER_BY_DESC = "LegalFAQEntry.status DESC";

	public static final String[] ORDER_BY_FIELDS = {"status"};
	
	
	public FAQStatusComparator(){
		this(false);
	}
	
	public FAQStatusComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		LegalFAQEntry faq1 = (LegalFAQEntry) obj1;
		LegalFAQEntry faq2 = (LegalFAQEntry) obj2;
		
		
		int comparatorValue = 0;
		
		if(faq1.getStatus() < faq2.getStatus()){
			
			comparatorValue = -1;
			
		}else if(faq1.getStatus() > faq2.getStatus()){
			
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
