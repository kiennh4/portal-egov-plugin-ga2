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
import com.portal_egov.portlet.landprice.model.LandPrice;

public class LandPricePermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, LandPrice landPrice, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, landPrice, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, LandPrice landPrice, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(landPrice.getGroupId(), LandPrice.class.getName(), landPrice.getPrimaryKey(), actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, LandPrice.class.getName(), groupId, actionId);
	}
}
