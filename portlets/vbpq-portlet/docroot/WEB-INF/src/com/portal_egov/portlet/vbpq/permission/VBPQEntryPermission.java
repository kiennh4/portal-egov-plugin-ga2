/**
 * @author HungDX
 * @time 9:10:23 AM
 * @project vbpq-portlet
 */

package com.portal_egov.portlet.vbpq.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.vbpq.model.VBPQ_Entry;


public class VBPQEntryPermission {

	public static final String VIEW_VBPQ = "VIEW";
	public static final String ADD_VBPQ = "ADD";
	public static final String UPDATE_VBPQ = "UPDATE";
	public static final String DELETE_VBPQ = "DELETE";
	public static final String VBPQ_PERMISSIONS = "PERMISSIONS";
	public static final String FILE_ATTACHMENT_CONFIG = "CONFIG";
	
	public static void check(PermissionChecker permissionChecker, long vbpqEntryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, vbpqEntryId, actionId)) {
			throw new PrincipalException();
		}
	}

	
	
	public static void check(PermissionChecker permissionChecker, VBPQ_Entry vbpqEntry, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, vbpqEntry, actionId)) {
			throw new PrincipalException();
		}
	}


	public static boolean contains(PermissionChecker permissionChecker, VBPQ_Entry vbpqEntry, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(vbpqEntry.getGroupId(), VBPQ_Entry.class.getName(), vbpqEntry.getPrimaryKey(), actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, VBPQ_Entry.class.getName(), groupId, actionId);
	}
}
