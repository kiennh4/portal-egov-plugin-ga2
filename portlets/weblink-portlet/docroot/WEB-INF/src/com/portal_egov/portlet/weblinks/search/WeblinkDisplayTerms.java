/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.weblinks.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class WeblinkDisplayTerms extends DisplayTerms{

	public static final String WEBLINK_NAME = "weblinkName";
	/**
	 * @param portletRequest
	 */
	public WeblinkDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		weblinkName = ParamUtil.getString(portletRequest, WEBLINK_NAME);
	}

	public String getName() {

		return weblinkName;
	}
	
	protected String weblinkName;
}
