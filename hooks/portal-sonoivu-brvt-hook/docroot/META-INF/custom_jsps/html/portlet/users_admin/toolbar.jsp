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

<%@ include file="/html/portlet/users_admin/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view");
%>

<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewUsersURL">
		<portlet:param name="struts_action" value="/users_admin/view" />
		<portlet:param name="usersListView" value="<%= UserConstants.LIST_VIEW_TREE %>" />
		<portlet:param name="saveUsersListView" value="<%= Boolean.TRUE.toString() %>" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewUsersURL %>"><liferay-ui:message key="view-all" /></a>
	</span>

		<c:if test="<%= PortalPermissionUtil.contains(permissionChecker, ActionKeys.ADD_USER) %>">
			<portlet:renderURL var="addUserURL">
				<portlet:param name="struts_action" value="/users_admin/edit_user" />
				<portlet:param name="redirect" value="<%= viewUsersURL %>" />
			</portlet:renderURL>

			<span class="lfr-toolbar-button add-button">
				<a href="<%= addUserURL %>"><liferay-ui:message key="add-user" /></a>
			</span>
		</c:if>
</div>

<aui:script>
	function <portlet:namespace />exportUsers() {
		document.<portlet:namespace />fm.method = "post";
		submitForm(document.<portlet:namespace />fm, "<portlet:actionURL><portlet:param name="struts_action" value="/users_admin/export_users" /></portlet:actionURL>&etag=0&strip=0&compress=0", false);
	}
</aui:script>