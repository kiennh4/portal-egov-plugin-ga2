/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.legal_faq.search;

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
import com.portal_egov.portlet.legal_faq.comparator.FAQComparatorUtil;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;


public class FAQEntrySearch extends SearchContainer<LegalFAQEntry>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-data";
	
	public FAQEntrySearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new FAQEntryDisplayTerms(portletRequest), new FAQEntrySearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		FAQEntryDisplayTerms displayTerms = (FAQEntryDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(FAQEntryDisplayTerms.ASK_TITLE, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(FAQ_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(FAQ_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(FAQ_ADMIN_PORTLET_NAMESPACE, "order-by-col", "status");
				orderByType = preferences.getValue(FAQ_ADMIN_PORTLET_NAMESPACE, "order-by-type", "asc");
			}

			OrderByComparator orderByComparator = FAQComparatorUtil.getFAQOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static final String FAQ_ADMIN_PORTLET_NAMESPACE = "_legal_faq_management_WAR_legal_fagportlet";
	
	private static Log _log = LogFactoryUtil.getLog(FAQEntrySearch.class);
}
