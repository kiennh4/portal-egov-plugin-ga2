/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.compaints.search;

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
import com.portal_egov.portlet.compaints.comparator.ComplaintCreateDateComparator;
import com.portal_egov.portlet.compaints.comparator.ComplaintModifiedDateComparator;
import com.portal_egov.portlet.compaints.model.Complaint;


public class ComplaintSearch extends SearchContainer<Complaint>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";
	
	public ComplaintSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new ComplaintDisplayTerms(portletRequest), new ComplaintSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		ComplaintDisplayTerms displayTerms = (ComplaintDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(ComplaintDisplayTerms.COMPLAINT_TITLE, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(COMPLAINT_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(COMPLAINT_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(COMPLAINT_ADMIN_PORTLET_NAMESPACE, "order-by-col", "createDate");
				orderByType = preferences.getValue(COMPLAINT_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
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

		if(Validator.equals(orderByColumn, "createDate")){
			
			return new ComplaintCreateDateComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "modifiedDate")){
			
			return new ComplaintModifiedDateComparator(ascending);
		}

		return null;
	}
	private static final String COMPLAINT_ADMIN_PORTLET_NAMESPACE = "_complaints_admin_WAR_complaintsportlet";
	
	private static Log _log = LogFactoryUtil.getLog(ComplaintSearch.class);
}
