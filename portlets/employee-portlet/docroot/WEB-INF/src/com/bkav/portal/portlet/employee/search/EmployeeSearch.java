package com.bkav.portal.portlet.employee.search;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.bkav.portal.portlet.employee.comparator.EmployeeCreateDateComparator;
import com.bkav.portal.portlet.employee.comparator.EmployeeNameComparator;
import com.bkav.portal.portlet.employee.model.Employee;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;


public class EmployeeSearch extends SearchContainer<Employee>{
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-entry-found";
	
	public EmployeeSearch(PortletRequest portletRequest,PortletURL iteratorURL){
		
		super(portletRequest, new EmployeeDisplayTerms(portletRequest), new EmployeeSearchTerms(portletRequest), 
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, null, EMPTY_RESULTS_MESSAGE);

		EmployeeDisplayTerms displayTerms = (EmployeeDisplayTerms) getDisplayTerms();

		iteratorURL.setParameter(EmployeeDisplayTerms.NAME, displayTerms.getName());
		iteratorURL.setParameter(EmployeeDisplayTerms.CREATE_DATE, displayTerms.getCreateDate());

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(EMPLOYEE_ADMIN_PORTLET_NAMESPACE, "emlployee-by-col", orderByCol);
				preferences.setValue(EMPLOYEE_ADMIN_PORTLET_NAMESPACE, "emlployee-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(EMPLOYEE_ADMIN_PORTLET_NAMESPACE, "emlployee-by-col", "name");
				orderByType = preferences.getValue(EMPLOYEE_ADMIN_PORTLET_NAMESPACE, "emlployee-by-col", "desc");
			}

			OrderByComparator orderByComparator = getOrderByComparator(orderByCol, orderByType);

			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	protected static OrderByComparator getOrderByComparator(String orderByColumn, String orderByType) {

		if (Validator.isNull(orderByColumn) || Validator.isNull(orderByType)) {
			return null;
		}

		boolean ascending = false;

		if (orderByType.equals("asc")) {
			ascending = true;
		}
		
		if(Validator.equals(orderByColumn, "name")){
			
			return new EmployeeNameComparator(ascending);
			
		}else if(Validator.equals(orderByColumn, "createDate")){
			
			return new EmployeeCreateDateComparator(ascending);
			
		}

		return null;
	}
	
	private static Log _log = LogFactoryUtil.getLog(EmployeeSearch.class);
	
	private static final String EMPLOYEE_ADMIN_PORTLET_NAMESPACE = "_admin_WAR_employeeportlet";
}