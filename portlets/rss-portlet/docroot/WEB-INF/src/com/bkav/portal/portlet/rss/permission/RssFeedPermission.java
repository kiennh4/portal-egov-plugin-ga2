/**
 * @author HungDX
 * @time 8:45:12 AM
 * @project conversation-portlet
 */
package com.bkav.portal.portlet.rss.permission;

import com.bkav.portal.portlet.rss.model.RssFeed;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


public class RssFeedPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, RssFeed feed, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, feed, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, RssFeed feed, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(feed.getGroupId(), RssFeed.class.getName(), feed.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, RssFeed.class.getName(), groupId, actionId);
	}
}
