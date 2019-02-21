/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class FeedbackSearchTerms extends FeedbackDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public FeedbackSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		feedbackTitle = DAOParamUtil.getLike(portletRequest, FEEDBACK_TITLE);
	}
}
