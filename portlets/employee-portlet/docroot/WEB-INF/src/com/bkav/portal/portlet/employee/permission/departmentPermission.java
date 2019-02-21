package com.bkav.portal.portlet.employee.permission;

import com.bkav.portal.portlet.employee.model.Department;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class departmentPermission {
	public static final String VIEW = "VIEW";
	public static final String ADD = "ADD";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String PERMISSIONS = "PERMISSIONS";
	
	   public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, threadId, actionId)) {
				throw new PrincipalException();
			}
		}

		public static void check(PermissionChecker permissionChecker, Department department, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, department, actionId)) {
				throw new PrincipalException();
			}
		}

		public static boolean contains(PermissionChecker permissionChecker, Department department, String actionId)
			throws PortalException, SystemException {

			return permissionChecker.hasPermission(department.getGroupId(), Department.class.getName(), department.getPrimaryKey(), actionId);
		}
		
		
		public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
			
			return permissionChecker.hasPermission(groupId, Department.class.getName(), groupId, actionId);
		}
}
