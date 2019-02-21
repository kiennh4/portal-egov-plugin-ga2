/**
 * @author HUNGDX
 * @time 10:37:22 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.inquiry.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class InquirySearchTerms extends InquiryDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public InquirySearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		inquiryContent = DAOParamUtil.getLike(portletRequest, INQUIRY_CONTENT);
	}
}
