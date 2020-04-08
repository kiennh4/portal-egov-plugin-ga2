/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.bkav.portal.portlet.dynamic_menu.permission;

import com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


public class DynamicMenuItemPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, DynamicMenuItem menuItem, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, menuItem, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, DynamicMenuItem menuItem, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(menuItem.getGroupId(), DynamicMenuItem.class.getName(), 
			menuItem.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, DynamicMenuItem.class.getName(), groupId, actionId);
	}
}
