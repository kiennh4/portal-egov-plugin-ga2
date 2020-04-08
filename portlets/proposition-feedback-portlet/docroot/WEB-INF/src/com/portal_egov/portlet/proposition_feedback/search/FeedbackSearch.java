/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.search;

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
import com.portal_egov.portlet.proposition_feedback.comparator.FeedbackComparatorUtil;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;


public class FeedbackSearch extends SearchContainer<Proposition>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-were-found";
	
	public FeedbackSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new PropositionDisplayTerms(portletRequest), new PropositionSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		PropositionDisplayTerms displayTerms = (PropositionDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(FeedbackDisplayTerms.FEEDBACK_TITLE, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(PROPOSITION_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(PROPOSITION_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(PROPOSITION_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(PROPOSITION_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = FeedbackComparatorUtil.getFeedbackOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static final String PROPOSITION_ADMIN_PORTLET_NAMESPACE = "_proposition_feedback_admin_WAR_proposition_feedbackportlet";
	
	private static Log _log = LogFactoryUtil.getLog(FeedbackSearch.class);
}
