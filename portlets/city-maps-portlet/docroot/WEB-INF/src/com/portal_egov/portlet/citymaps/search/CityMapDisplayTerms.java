/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citymaps.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class CityMapDisplayTerms extends DisplayTerms{

	public static final String MAP_NAME = "mapName";
	/**
	 * @param portletRequest
	 */
	public CityMapDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		mapName = ParamUtil.getString(portletRequest, MAP_NAME);
	}

	public String getName() {

		return mapName;
	}
	
	protected String mapName;
}
