package com.portal_egov.portlet.proposition_feedback.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.proposition_feedback.model.Proposition;


public class PropositionPermission {

	public static final String VIEW = "VIEW";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String PERMISSIONS = "PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long categoryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, categoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, Proposition proposition, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, proposition, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, Proposition proposition, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(proposition.getGroupId(), Proposition.class.getName(), proposition.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, Proposition.class.getName(), groupId, actionId);
	}
}
