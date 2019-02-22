/**
 * @author HungDX
 * @time 9:10:31 AM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.ykct.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.ykct.model.YKCT_Category;


public class YKCTCategoryPermission {


	public static final String VIEW_CATEGORY = "VIEW";
	public static final String ADD_CATEGORY = "ADD";
	public static final String UPDATE_CATEGORY = "UPDATE";
	public static final String DELETE_CATEGORY = "DELETE";
	public static final String CATEGORY_PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long ykctCategoryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, ykctCategoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, YKCT_Category ykctCategory, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, ykctCategory, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, YKCT_Category ykctCategory, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(ykctCategory.getGroupId(), YKCT_Category.class.getName(), ykctCategory.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, YKCT_Category.class.getName(), groupId, actionId);
	}
}
