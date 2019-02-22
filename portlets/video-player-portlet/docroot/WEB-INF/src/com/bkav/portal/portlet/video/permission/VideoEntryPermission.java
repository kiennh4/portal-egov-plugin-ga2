/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.bkav.portal.portlet.video.permission;

import com.bkav.portal.portlet.video.model.VideoEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


public class VideoEntryPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, VideoEntry video, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, video, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, VideoEntry video, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(video.getGroupId(), VideoEntry.class.getName(), video.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, VideoEntry.class.getName(), groupId, actionId);
	}
}
