/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.weblinks.search;

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
import com.portal_egov.portlet.weblinks.model.Weblink;
import com.portal_egov.portlet.weblinks.util.WeblinkUtil;


public class WeblinkSearch extends SearchContainer<Weblink>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";
	
	public WeblinkSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new WeblinkDisplayTerms(portletRequest), new WeblinkSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		WeblinkDisplayTerms displayTerms = (WeblinkDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(WeblinkDisplayTerms.WEBLINK_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(WEBLINK_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(WEBLINK_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(WEBLINK_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(WEBLINK_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = WeblinkUtil.getWeblinkOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static final String WEBLINK_ADMIN_PORTLET_NAMESPACE = "_weblinks_admin_WAR_weblinksportlet";
	
	private static Log _log = LogFactoryUtil.getLog(WeblinkSearch.class);
}
