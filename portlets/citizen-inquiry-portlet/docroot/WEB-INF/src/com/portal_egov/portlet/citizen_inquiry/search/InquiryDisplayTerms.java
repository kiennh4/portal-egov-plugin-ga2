/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.citizen_inquiry.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class InquiryDisplayTerms extends DisplayTerms{

	public static final String INQUIRY_TITLE = "inquiryTitle";
	/**
	 * @param portletRequest
	 */
	public InquiryDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		inquiryTitle = ParamUtil.getString(portletRequest, INQUIRY_TITLE);
	}

	public String getName() {

		return inquiryTitle;
	}
	
	protected String inquiryTitle;
}
