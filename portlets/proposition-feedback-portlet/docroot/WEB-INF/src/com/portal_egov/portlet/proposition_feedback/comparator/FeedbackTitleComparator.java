/**
 * @author HUNGDX
 * @time 11:24:00 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;


public class FeedbackTitleComparator extends OrderByComparator{


	public static final String ORDER_BY_ASC = "PropositionFeedback.feedbackTitle ASC";

	public static final String ORDER_BY_DESC = "PropositionFeedback.feedbackTitle DESC";

	public static final String[] ORDER_BY_FIELDS = {"feedbackTitle"};
	
	
	public FeedbackTitleComparator(){
		this(false);
	}
	
	public FeedbackTitleComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		PropositionFeedback feedback1 = (PropositionFeedback) obj1;
		PropositionFeedback feedback2 = (PropositionFeedback) obj2;
		
		int comparatorValue = feedback1.getFeedbackTitle().toLowerCase().compareTo(feedback2.getFeedbackTitle().toLowerCase()); 
		
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
