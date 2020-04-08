/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;


public class PropositionFeedbackComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "Proposition.feedbackCount ASC";

	public static final String ORDER_BY_DESC = "Proposition.feedbackCount DESC";

	public static final String[] ORDER_BY_FIELDS = {"feedbackCount"};
	
	
	public PropositionFeedbackComparator(){
		this(false);
	}
	
	public PropositionFeedbackComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Proposition proposition1 = (Proposition) obj1;
		Proposition proposition2 = (Proposition) obj2;
		
		int comparatorValue = 0;
		
		if(proposition1.getFeedbackCount() > proposition2.getFeedbackCount()){
			
			comparatorValue = 1;
		}else if (proposition1.getFeedbackCount() < proposition2.getFeedbackCount()) {
			
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
