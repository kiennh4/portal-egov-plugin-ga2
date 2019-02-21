/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PropositionSearchTerms extends PropositionDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public PropositionSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		propositionName = DAOParamUtil.getLike(portletRequest, PROPOSITION_NAME);
	}
}
