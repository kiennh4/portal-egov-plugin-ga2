/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.compaints.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ComplaintSearchTerms extends ComplaintDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public ComplaintSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		complaintTitle = DAOParamUtil.getLike(portletRequest, COMPLAINT_TITLE);
	}
}
