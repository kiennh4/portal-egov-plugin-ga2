/**
 * @author HungDX
 * @time 9:10:23 AM
 * @project vbpq-portlet
 */

package com.portal_egov.portlet.ykct.permission;

import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.ykct.model.YKCT_Entry;


public class YKCTEntryPermission {

	public static final String VIEW_YKCT = "VIEW";
	public static final String ADD_YKCT = "ADD";
	public static final String UPDATE_YKCT = "UPDATE";
	public static final String DELETE_YKCT = "DELETE";
	public static final String YKCT_PERMISSIONS = "PERMISSIONS";
	public static final String FILE_ATTACHMENT_CONFIG = "CONFIG";
	
	public static void check(PermissionChecker permissionChecker, long ykctEntryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, ykctEntryId, actionId)) {
			throw new PrincipalException();
		}
	}

	
	
	public static void check(PermissionChecker permissionChecker, YKCT_Entry ykctEntry, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, ykctEntry, actionId)) {
			throw new PrincipalException();
		}
	}


	public static boolean contains(PermissionChecker permissionChecker, YKCT_Entry ykctEntry, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(ykctEntry.getGroupId(), YKCT_Entry.class.getName(), ykctEntry.getPrimaryKey(), actionId);
	}
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, YKCT_Entry.class.getName(), groupId, actionId);
	}
}
