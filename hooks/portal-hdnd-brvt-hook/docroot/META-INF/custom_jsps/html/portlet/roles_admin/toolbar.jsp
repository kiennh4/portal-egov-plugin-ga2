<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/roles_admin/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>

<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewRolesURL">
		<portlet:param name="struts_action" value="/roles_admin/view" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewRolesURL %>"><liferay-ui:message key="view-all" /></a>
	</span>

	<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_ROLE) %>">
		<portlet:renderURL var="viewRolesURL">
			<portlet:param name="struts_action" value="/roles_admin/view" />
		</portlet:renderURL>

		<liferay-portlet:renderURL varImpl="addRoleURL">
			<portlet:param name="struts_action" value="/roles_admin/edit_role" />
			<portlet:param name="redirect" value="<%= viewRolesURL %>" />
			<portlet:param name="type" value="<%= String.valueOf(RoleConstants.TYPE_REGULAR) %>" />
		</liferay-portlet:renderURL>
		
		<span class="lfr-toolbar-button add-button">
			<a href="<%= addRoleURL.toString() %>"><liferay-ui:message key="add-new" /></a>
		</span>
	</c:if>
</div>