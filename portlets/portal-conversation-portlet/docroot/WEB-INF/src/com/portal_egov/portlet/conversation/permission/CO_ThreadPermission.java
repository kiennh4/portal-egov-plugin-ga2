/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.conversation.model.CO_Thread;


public class CO_ThreadPermission {

	public static final String VIEW_THREAD = "VIEW_THREAD";
	public static final String ADD_THREAD = "ADD_THREAD";
	public static final String UPDATE_THREAD = "UPDATE_THREAD";
	public static final String UPDATE_THREAD_STATUS = "UPDATE_THREAD_STATUS";
	public static final String DELETE_THREAD = "DELETE_THREAD";
	public static final String THREAD_PERMISSIONS = "THREAD_PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, CO_Thread coThread, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, coThread, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, CO_Thread coThread, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(coThread.getGroupId(), CO_Thread.class.getName(), coThread.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, CO_Thread.class.getName(), groupId, actionId);
	}
}
