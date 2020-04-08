/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;


public class PropositionStatusComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "Proposition.status ASC";

	public static final String ORDER_BY_DESC = "Proposition.status DESC";

	public static final String[] ORDER_BY_FIELDS = {"status"};
	
	
	public PropositionStatusComparator(){
		this(false);
	}
	
	public PropositionStatusComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Proposition proposition1 = (Proposition) obj1;
		Proposition proposition2 = (Proposition) obj2;
		
		int comparatorValue = 0;
		
		if(proposition1.getStatus() > proposition2.getStatus()){
			
			comparatorValue = 1;
		}else if (proposition1.getStatus() < proposition2.getStatus()) {
			
			comparatorValue = -1;
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
