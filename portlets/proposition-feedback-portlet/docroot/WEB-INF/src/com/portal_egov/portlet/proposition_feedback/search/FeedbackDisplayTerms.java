/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.proposition_feedback.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class FeedbackDisplayTerms extends DisplayTerms{

	public static final String FEEDBACK_TITLE = "feedbackTitle";
	/**
	 * @param portletRequest
	 */
	public FeedbackDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		feedbackTitle = ParamUtil.getString(portletRequest, FEEDBACK_TITLE);
	}

	public String getName() {

		return feedbackTitle;
	}
	
	protected String feedbackTitle;
}
