/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citymaps.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class CityMapSearchTerms extends CityMapDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public CityMapSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		mapName = DAOParamUtil.getLike(portletRequest, MAP_NAME);
	}
}
