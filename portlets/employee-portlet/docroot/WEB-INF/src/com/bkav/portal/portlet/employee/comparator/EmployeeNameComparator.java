package com.bkav.portal.portlet.employee.comparator;


import com.bkav.portal.portlet.employee.model.Employee;
import com.liferay.portal.kernel.util.OrderByComparator;


/**
 * 
 * @author HungDX
 *
 */
public class EmployeeNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "Employee.name ASC";

	public static final String ORDER_BY_DESC = "Employee.name DESC";

	public static final String[] ORDER_BY_FIELDS = {"name"};

	public EmployeeNameComparator() {

		this(false);
	}

	public EmployeeNameComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Employee employee1 = (Employee) obj1;
		Employee employee2 = (Employee) obj2;

		int value = employee1.getName().toLowerCase().compareTo(employee2.getName().toLowerCase());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {

		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {

		return _ascending;
	}

	private boolean _ascending;

}