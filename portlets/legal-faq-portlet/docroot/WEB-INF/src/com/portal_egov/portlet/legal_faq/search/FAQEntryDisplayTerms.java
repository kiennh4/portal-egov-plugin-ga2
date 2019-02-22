/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.legal_faq.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class FAQEntryDisplayTerms extends DisplayTerms{

	public static final String ASK_TITLE = "askTitle";
	/**
	 * @param portletRequest
	 */
	public FAQEntryDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		askTitle = ParamUtil.getString(portletRequest, ASK_TITLE);
	}

	public String getName() {

		return askTitle;
	}
	
	protected String askTitle;
}
