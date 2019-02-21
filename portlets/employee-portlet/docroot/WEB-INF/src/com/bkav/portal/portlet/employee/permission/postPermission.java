package com.bkav.portal.portlet.employee.permission;

import com.bkav.portal.portlet.employee.model.Post;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class postPermission {
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

		public static void check(PermissionChecker permissionChecker, Post post, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, post, actionId)) {
				throw new PrincipalException();
			}
		}

		public static boolean contains(PermissionChecker permissionChecker, Post post, String actionId)
			throws PortalException, SystemException {

			return permissionChecker.hasPermission(post.getGroupId(), Post.class.getName(), post.getPrimaryKey(), actionId);
		}
		
		
		public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
			
			return permissionChecker.hasPermission(groupId, Post.class.getName(), groupId, actionId);
		}
}
