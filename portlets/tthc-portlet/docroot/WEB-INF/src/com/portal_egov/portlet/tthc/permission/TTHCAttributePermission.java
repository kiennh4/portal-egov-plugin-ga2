/**
 * @author HungDX
 * @time 9:17:05 AM
 * @project tthc-portlet
 */
package com.portal_egov.portlet.tthc.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.tthc.model.TTHC_Attribute;


/**
 * @author HungDX
 *
 */
public class TTHCAttributePermission {

	public static final String VIEW_ATTRIBUTE = "VIEW";
	public static final String ADD_ATTRIBUTE = "ADD";
	public static final String UPDATE_ATTRIBUTE = "UPDATE";
	public static final String DELETE_ATTRIBUTE = "DELETE";	
	public static final String ATTRIBUTE_PERMISSIONS = "PERMISSIONS";
	
	
	public static void check(PermissionChecker permissionChecker, long tthcAttributeId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, tthcAttributeId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, TTHC_Attribute tthcAttribute, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, tthcAttribute, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, TTHC_Attribute tthcAttribute, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(tthcAttribute.getGroupId(), TTHC_Attribute.class.getName(), tthcAttribute.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, TTHC_Attribute.class.getName(), groupId, actionId);
	}
}
