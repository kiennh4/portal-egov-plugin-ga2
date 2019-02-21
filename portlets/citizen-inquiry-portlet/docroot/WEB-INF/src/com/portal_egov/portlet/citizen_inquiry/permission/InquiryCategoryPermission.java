/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.citizen_inquiry.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiryCategory;


public class InquiryCategoryPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, CitizenInquiryCategory inquiryCategory, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, inquiryCategory, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, CitizenInquiryCategory inquiryCategory, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(inquiryCategory.getGroupId(), CitizenInquiryCategory.class.getName(), inquiryCategory.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, CitizenInquiryCategory.class.getName(), groupId, actionId);
	}
}
