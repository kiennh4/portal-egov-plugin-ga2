/**
 * @author HUNGDX
 * @time 10:36:41 AM
 * @project weblinks-portlet
 */
package com.portal_egov.portlet.inquiry.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;


public class InquiryDisplayTerms extends DisplayTerms{

	public static final String INQUIRY_CONTENT = "inquiryContent";
	/**
	 * @param portletRequest
	 */
	public InquiryDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		inquiryContent = ParamUtil.getString(portletRequest, INQUIRY_CONTENT);
	}

	public String getName() {

		return inquiryContent;
	}
	
	protected String inquiryContent;
}
