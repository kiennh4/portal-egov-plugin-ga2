/**
 * @author HUNGDX
 * @time 11:06:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.portal_egov.portlet.contacts.model.ContactsDepartment;


public class DepartmentPriorityComparator extends OrderByComparator{

	public static final String ORDER_BY_ASC = "ContactsDepartment.displayPriority ASC";

	public static final String[] ORDER_BY_FIELDS = {"displayPriority"};

	public DepartmentPriorityComparator() {
		
	}

	public DepartmentPriorityComparator(ContactsDepartment department, boolean lessThan) {
		_department = department;
		_lessThan = lessThan;
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.util.OrderByComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object obj1, Object obj2) {

		ContactsDepartment department1 = (ContactsDepartment) obj1;
		ContactsDepartment department2 = (ContactsDepartment) obj2;
		
		int priority1 = department1.getDisplayPriority();
		int priority2 = department2.getDisplayPriority();

		if (priority1 > priority2) {
			
			return 1;
			
		}else if (priority1 < priority2) {
			
			return -1;
			
		}else{
			
			if(_department != null){
				
				if (Validator.equals(_department, department1)) {
					if (_lessThan) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else if (Validator.equals(_department, department2)) {
					if (_lessThan) {
						return -1;
					}
					else {
						return 1;
					}
				}
			}
			
			return 0;
		}
	}


	@Override
	public String getOrderBy() {
		return ORDER_BY_ASC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return true;
	}

	private ContactsDepartment _department;
	private boolean _lessThan;
	
}
