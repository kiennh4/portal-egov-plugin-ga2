/**
 * @author HUNGDX
 * @time 11:06:56 AM
 * @project contacts-portlet
 */
package com.portal_egov.portlet.contacts.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.portal_egov.portlet.contacts.model.Contacts;


public class ContactPriorityComparator extends OrderByComparator{

	public static final String ORDER_BY_ASC = "Contacts.displayPriority ASC";

	public static final String[] ORDER_BY_FIELDS = {"displayPriority"};

	public ContactPriorityComparator() {
		
	}

	public ContactPriorityComparator(Contacts contact, boolean lessThan) {
		_contact = contact;
		_lessThan = lessThan;
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.util.OrderByComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object obj1, Object obj2) {

		Contacts contact1 = (Contacts) obj1;
		Contacts contact2 = (Contacts) obj2;
		
		int priority1 = contact1.getDisplayPriority();
		int priority2 = contact2.getDisplayPriority();

		if (priority1 > priority2) {
			
			return 1;
			
		}else if (priority1 < priority2) {
			
			return -1;
			
		}else{
			
			if(_contact != null){
				
				if (Validator.equals(_contact, contact1)) {
					if (_lessThan) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else if (Validator.equals(_contact, contact2)) {
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

	private Contacts _contact;
	private boolean _lessThan;
	
}
