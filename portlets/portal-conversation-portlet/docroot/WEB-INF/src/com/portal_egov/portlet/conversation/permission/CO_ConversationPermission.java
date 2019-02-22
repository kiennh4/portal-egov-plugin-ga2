/**
 * @author HungDX
 * @time 8:45:24 AM
 * @project conversation-portlet
 */
package com.portal_egov.portlet.conversation.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.portal_egov.portlet.conversation.model.CO_Conversation;


public class CO_ConversationPermission {

	public static final String VIEW_CONVERSATION = "VIEW_CONVERSATION";
	public static final String ADD_CONVERSATION = "ADD_CONVERSATION";
	public static final String ADD_ANSWERCONTENT = "ADD_ANSWERCONTENT";
	public static final String UPDATE_CONVERSATION = "UPDATE_CONVERSATION";
	public static final String DELETE_CONVERSATION = "DELETE_CONVERSATION";
	public static final String CONVERSATION_PERMISSIONS = "CONVERSATION_PERMISSIONS";
	
	public static void check(PermissionChecker permissionChecker, long categoryId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, categoryId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, CO_Conversation coConversation, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, coConversation, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, CO_Conversation coConversation, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(coConversation.getGroupId(), CO_Conversation.class.getName(), coConversation.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, CO_Conversation.class.getName(), groupId, actionId);
	}
}
