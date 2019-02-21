/**
 * @author HUNGDX
 * @time 8:57:17 AM
 * @project proposition_feedback-portlet
 */
package com.portal_egov.portlet.proposition_feedback.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;


public class FeedbackComparatorUtil {

	public static OrderByComparator getFeedbackOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "feedback-title")){
			
			return new FeedbackTitleComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "proposition-name")){
			
			return new FeedbackPropositionComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "feedback-date")){
			
			return new FeedbackDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "feedback-status")){
			
			return new FeedbackStatusComparator(ascending);
			
		}

		return null;
	}
}
