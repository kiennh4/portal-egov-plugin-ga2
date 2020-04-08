package com.bkav.portal.portlet.employee.search;

import javax.portlet.PortletRequest;


import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class EmployeeDisplayTerms extends DisplayTerms{

	public static final String NAME = "name";
	public static final String CREATE_DATE = "createDate";
	/**
	 * @param portletRequest
	 */
	public EmployeeDisplayTerms(PortletRequest portletRequest) {

		super(portletRequest);
		
		name = ParamUtil.getString(portletRequest, NAME);
		createDate = ParamUtil.getString(portletRequest, CREATE_DATE);
	}

	public String getName() {

		return name;
	}
	
	public String getCreateDate() {

		return createDate;
	}
	
	protected String name;
	protected String createDate;
}
