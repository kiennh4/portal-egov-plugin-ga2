/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.citymaps.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.citymaps.model.CityMapType;


public class CityMapTypePermission {

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

	public static void check(PermissionChecker permissionChecker, CityMapType cityMapType, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, cityMapType, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, CityMapType cityMapType, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(cityMapType.getGroupId(), CityMapType.class.getName(), cityMapType.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, CityMapType.class.getName(), groupId, actionId);
	}
}
