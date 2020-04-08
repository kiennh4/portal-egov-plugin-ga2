/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.contacts.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.contacts.NoSuchContactsException;
import com.portal_egov.portlet.contacts.model.Contacts;
import com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil;


public class ContactsPermission {

	public static final String VIEW = "VIEW";
	public static final String ADD = "ADD";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long contactId, String actionId)
		throws PortalException, SystemException {
		
		Contacts contact = ContactsLocalServiceUtil.getContacts(contactId);
		
		if(contact == null){
			throw new NoSuchContactsException();
		
		}else{
			
			if (!contains(permissionChecker, contact, actionId)) {
				throw new PrincipalException();
			}
		}
	}

	public static void check(PermissionChecker permissionChecker, Contacts contact, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, contact, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, Contacts contact, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(contact.getGroupId(), Contacts.class.getName(), contact.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, Contacts.class.getName(), groupId, actionId);
	}
}
