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
import com.portal_egov.portlet.legal_faq.model.LegalFAQCategory;



/**
 * @author HungDX
 *
 */
public class LegalFAQCategoryPermission {

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

	public static void check(PermissionChecker permissionChecker, LegalFAQCategory legalFAQCategory, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, legalFAQCategory, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, LegalFAQCategory legalFAQCategory, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(legalFAQCategory.getGroupId(), LegalFAQCategory.class.getName(), legalFAQCategory.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, LegalFAQCategory.class.getName(), groupId, actionId);
	}
}
