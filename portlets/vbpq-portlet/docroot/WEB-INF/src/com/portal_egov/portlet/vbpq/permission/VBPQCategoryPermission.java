/**
 * @author HungDX
 * @time 9:10:31 AM
 * @project vbpq-portlet
 */
package com.portal_egov.portlet.vbpq.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.vbpq.model.VBPQ_Category;


public class VBPQCategoryPermission {


	public static final String VIEW_CATEGORY = "VIEW";
	public static final String ADD_CATEGORY = "ADD";
	public static final String UPDATE_CATEGORY = "UPDATE";
	public static final String DELETE_CATEGORY = "DELETE";
	public static final String CATEGORY_PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long vbpqCategoryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, vbpqCategoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, VBPQ_Category vbpqCategory, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, vbpqCategory, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, VBPQ_Category vbpqCategory, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(vbpqCategory.getGroupId(), VBPQ_Category.class.getName(), vbpqCategory.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, VBPQ_Category.class.getName(), groupId, actionId);
	}
}
