package com.portal_egov.portlet.proposition_feedback.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback;


public class PropositionFeedbackPermission {

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

	public static void check(PermissionChecker permissionChecker, PropositionFeedback propositionFeedback, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, propositionFeedback, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, PropositionFeedback propositionFeedback, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(propositionFeedback.getGroupId(), PropositionFeedback.class.getName(), propositionFeedback.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, PropositionFeedback.class.getName(), groupId, actionId);
	}
}
