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
import com.portal_egov.portlet.tthc.model.TTHC_Entry;



/**
 * @author HungDX
 *
 */
public class TTHCEntryPermission {

	public static final String VIEW_TTHC = "VIEW";
	public static final String ADD_TTHC = "ADD";
	public static final String UPDATE_TTHC = "UPDATE";
	public static final String DELETE_TTHC = "DELETE";
	public static final String FILE_ATTACHMENT_CONFIG = "CONFIG";
	public static final String TTHC_PERMISSIONS = "PERMISSIONS";
	
	
	public static void check(PermissionChecker permissionChecker, long tthcEntryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, tthcEntryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, TTHC_Entry tthcEntry, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, tthcEntry, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, TTHC_Entry tthcEntry, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(tthcEntry.getGroupId(), TTHC_Entry.class.getName(), tthcEntry.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, TTHC_Entry.class.getName(), groupId, actionId);
	}
}
