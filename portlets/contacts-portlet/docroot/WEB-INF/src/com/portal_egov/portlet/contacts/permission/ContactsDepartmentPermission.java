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
import com.portal_egov.portlet.contacts.NoSuchContactsDepartmentException;
import com.portal_egov.portlet.contacts.model.ContactsDepartment;
import com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil;


public class ContactsDepartmentPermission {

	public static final String VIEW = "VIEW";
	public static final String ADD = "ADD";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long departmentId, String actionId)
		throws PortalException, SystemException {
		
		ContactsDepartment contactDepartment = ContactsDepartmentLocalServiceUtil.getContactsDepartment(departmentId);
		
		if(contactDepartment == null){
			
			throw new NoSuchContactsDepartmentException();
		
		}else{
			
			
			if (!contains(permissionChecker, contactDepartment, actionId)) {
				throw new PrincipalException();
			}
		}

	}

	public static void check(PermissionChecker permissionChecker, ContactsDepartment contactDepartment, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, contactDepartment, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, ContactsDepartment contactDepartment, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(contactDepartment.getGroupId(), ContactsDepartment.class.getName(), contactDepartment.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, ContactsDepartment.class.getName(), groupId, actionId);
	}
}
