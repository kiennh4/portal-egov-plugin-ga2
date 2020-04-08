package com.bkav.portal.portlet.employee.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class EmployeeSearchTerms extends EmployeeDisplayTerms{

	/**
	 * @param portletRequest
	 */
	public EmployeeSearchTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		name = DAOParamUtil.getLike(portletRequest, NAME);
		createDate = DAOParamUtil.getLike(portletRequest, CREATE_DATE);
	}
}
