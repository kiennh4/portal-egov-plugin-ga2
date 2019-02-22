/**
 * @author HUNGDX
 * @time 8:57:17 AM
 * @project proposition_feedback-portlet
 */
package com.portal_egov.portlet.proposition_feedback.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;


public class PropositionComparatorUtil {

	public static OrderByComparator getPropositionOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "proposition-name")){
			
			return new PropositionTitleComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "feedback-count")){
			
			return new PropositionFeedbackComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "user-name")){
			
			return new PropositionUserNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "proposition-status")){
			
			return new PropositionStatusComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modified-date")){
			
			return new PropositionModifiedDateComparator(ascending);
		}

		return null;
	}
}
