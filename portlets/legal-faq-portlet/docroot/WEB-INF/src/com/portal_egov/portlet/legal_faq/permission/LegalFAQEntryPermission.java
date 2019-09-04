/**
 * @author HungDX
 * @time 9:17:05 AM
 * @project tthc-portlet
 */
package com.portal_egov.portlet.legal_faq.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;



/**
 * @author HungDX
 *
 */
public class LegalFAQEntryPermission {


	public static final String VIEW = "VIEW";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String PERMISSIONS = "PERMISSIONS";
	public static final String FILE_ATTACHMENT_CONFIG = "CONFIG";
	
	
	public static void check(PermissionChecker permissionChecker, long entryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, entryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, LegalFAQEntry legalFAQEntry, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, legalFAQEntry, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, LegalFAQEntry legalFAQEntry, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(legalFAQEntry.getGroupId(), LegalFAQEntry.class.getName(), legalFAQEntry.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, LegalFAQEntry.class.getName(), groupId, actionId);
	}
}
