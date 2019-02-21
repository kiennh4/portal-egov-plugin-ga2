/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.landprice.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.landprice.model.LandLocation;

public class LandLocationPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, LandLocation landLocation, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, landLocation, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, LandLocation landLocation, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(landLocation.getGroupId(), LandLocation.class.getName(), landLocation.getPrimaryKey(), actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, LandLocation.class.getName(), groupId, actionId);
	}
}
