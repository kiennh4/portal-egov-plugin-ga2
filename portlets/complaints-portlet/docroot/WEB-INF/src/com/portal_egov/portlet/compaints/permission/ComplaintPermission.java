/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.compaints.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.compaints.model.Complaint;

public class ComplaintPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, Complaint complaint, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, complaint, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, Complaint complaint, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(complaint.getGroupId(), Complaint.class.getName(), complaint.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, Complaint.class.getName(), groupId, actionId);
	}
}
