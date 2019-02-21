/**
 * @author HUNGDX
 * @time 10:33:32 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citymaps.search;

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
import com.portal_egov.portlet.citymaps.model.CityMap;
import com.portal_egov.portlet.citymaps.util.CityMapUtil;


public class CityMapSearch extends SearchContainer<CityMap>{
	
	public CityMapSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new CityMapDisplayTerms(portletRequest), new CityMapSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_CITY_MAP_SEARCH_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		CityMapDisplayTerms displayTerms = (CityMapDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(CityMapDisplayTerms.MAP_NAME, displayTerms.getName());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(CITYMAP_ADMIN_PORTLET_NAMESPACE, "order-by-col", orderByCol);
				preferences.setValue(CITYMAP_ADMIN_PORTLET_NAMESPACE, "order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(CITYMAP_ADMIN_PORTLET_NAMESPACE, "order-by-col", "modified-date");
				orderByType = preferences.getValue(CITYMAP_ADMIN_PORTLET_NAMESPACE, "order-by-col", "desc");
			}

			OrderByComparator orderByComparator = CityMapUtil.getOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static final int DEFAULT_CITY_MAP_SEARCH_DELTA = 10;
	
	private static final String EMPTY_RESULTS_MESSAGE = "no-map-were-found";
	
	private static final String CITYMAP_ADMIN_PORTLET_NAMESPACE = "_citymaps_admin_WAR_city_mapsportlet";
	
	private static Log _log = LogFactoryUtil.getLog(CityMapSearch.class);
}
