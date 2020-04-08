/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.legal_faq.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class FAQEntrySearchTerms extends FAQEntryDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public FAQEntrySearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		askTitle = DAOParamUtil.getLike(portletRequest, ASK_TITLE);
	}
}
