/**
 * @author HungDX
 * @time 8:44:56 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.conversation.model.CO_Category;


public class CO_CategoryPermission {


	public static final String VIEW_CATEGORY = "VIEW";
	public static final String UPDATE_CATEGORY = "UPDATE";
	public static final String DELETE_CATEGORY = "DELETE";
	public static final String CATEGORY_PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long categoryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, categoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, CO_Category coCategory, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, coCategory, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, CO_Category coCategory, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(coCategory.getGroupId(), CO_Category.class.getName(), coCategory.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, CO_Category.class.getName(), groupId, actionId);
	}
}
