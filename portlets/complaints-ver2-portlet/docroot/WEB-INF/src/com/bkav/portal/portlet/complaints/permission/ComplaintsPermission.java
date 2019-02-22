package com.bkav.portal.portlet.complaints.permission;

import com.bkav.portal.portlet.complaints.model.Complaints;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ComplaintsPermission {
	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, threadId, actionId)) {
				throw new PrincipalException();
			}
		}

		public static void check(PermissionChecker permissionChecker, Complaints complaint, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, complaint, actionId)) {
				throw new PrincipalException();
			}
		}

		public static boolean contains(PermissionChecker permissionChecker, Complaints complaint, String actionId)
			throws PortalException, SystemException {

			return permissionChecker.hasPermission(complaint.getGroupId(), Complaints.class.getName(), complaint.getPrimaryKey(), actionId);
		}
		
		
		public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
			
			return permissionChecker.hasPermission(groupId, Complaints.class.getName(), groupId, actionId);
		}
}
