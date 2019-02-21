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
import com.portal_egov.portlet.tthc.model.TTHC_Category;



/**
 * @author HungDX
 *
 */
public class TTHCCategoryPermission {

	public static final String VIEW_CATEGORY = "VIEW";
	public static final String ADD_CATEGORY = "ADD";
	public static final String UPDATE_CATEGORY = "UPDATE";
	public static final String DELETE_CATEGORY = "DELETE";
	public static final String CATEGORY_PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long tthcCategoryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, tthcCategoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, TTHC_Category tthcCategory, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, tthcCategory, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, TTHC_Category tthcCategory, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(tthcCategory.getGroupId(), TTHC_Category.class.getName(), tthcCategory.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, TTHC_Category.class.getName(), groupId, actionId);
	}
}
