/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.weblinks.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class WeblinkSearchTerms extends WeblinkDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public WeblinkSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		weblinkName = DAOParamUtil.getLike(portletRequest, WEBLINK_NAME);
	}
}
