/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class PropositionDisplayTerms extends DisplayTerms{

	public static final String PROPOSITION_NAME = "propositionName";
	/**
	 * @param portletRequest
	 */
	public PropositionDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		propositionName = ParamUtil.getString(portletRequest, PROPOSITION_NAME);
	}

	public String getName() {

		return propositionName;
	}
	
	protected String propositionName;
}
