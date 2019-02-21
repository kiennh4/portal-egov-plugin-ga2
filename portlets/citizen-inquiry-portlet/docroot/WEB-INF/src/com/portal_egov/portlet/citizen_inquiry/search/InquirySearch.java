/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citizen_inquiry.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.portal_egov.portlet.citizen_inquiry.comparator.InquiryApprovedStatusComparator;
import com.portal_egov.portlet.citizen_inquiry.comparator.InquiryCategoryIdComparator;
import com.portal_egov.portlet.citizen_inquiry.comparator.InquiryCreateDateComparator;
import com.portal_egov.portlet.citizen_inquiry.comparator.InquiryFeedbackDateComparator;
import com.portal_egov.portlet.citizen_inquiry.comparator.InquiryModifiedDateComparator;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry;


public class InquirySearch extends SearchContainer<CitizenInquiry>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";
	
	public InquirySearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new InquiryDisplayTerms(portletRequest), new InquirySearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		InquiryDisplayTerms displayTerms = (InquiryDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(InquiryDisplayTerms.INQUIRY_TITLE, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(INQUIRY_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(INQUIRY_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(INQUIRY_ADMIN_PORTLET_NAMESPACE, "order-by-col", "createDate");
				orderByType = preferences.getValue(INQUIRY_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = getOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private OrderByComparator getOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}

		if(Validator.equals(orderByColumn, "categoryId")){
			
			return new InquiryCategoryIdComparator(ascending);
		
		}else if(Validator.equals(orderByColumn, "approvedStatus")){
			
			return new InquiryApprovedStatusComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "inquiryFeedbackDate")){
			
			return new InquiryFeedbackDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "createDate")){
			
			return new InquiryCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modifiedDate")){
			
			return new InquiryModifiedDateComparator(ascending);
		}

		return null;
	}
	private static final String INQUIRY_ADMIN_PORTLET_NAMESPACE = "_weblinks_admin_WAR_weblinksportlet";
	
	private static Log _log = LogFactoryUtil.getLog(InquirySearch.class);
}
