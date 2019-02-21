/**
 * @author HUNGDX
 * @time 2:18:13 PM
 * @project legal_faq-portlet
 */
package com.portal_egov.portlet.legal_faq.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;


public class FAQComparatorUtil {


	public static OrderByComparator getFAQOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "ask-title")){
			
			return new FAQTitleComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "category-id")){
			
			return new FAQCategoryIdComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "create-date")){
			
			return new FAQCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "publish-status")){
			
			return new FAQPublishStatusComparator(ascending);
		}else if(Validator.equals(orderByColumn, "status")){
			
			return new FAQStatusComparator(ascending);
		}

		return null;
	}
}
