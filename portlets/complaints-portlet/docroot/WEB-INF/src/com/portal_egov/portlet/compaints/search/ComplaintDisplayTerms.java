/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.compaints.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class ComplaintDisplayTerms extends DisplayTerms{

	public static final String COMPLAINT_TITLE = "complaintTitle";
	/**
	 * @param portletRequest
	 */
	public ComplaintDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		complaintTitle = ParamUtil.getString(portletRequest, COMPLAINT_TITLE);
	}

	public String getName() {

		return complaintTitle;
	}
	
	protected String complaintTitle;
}
