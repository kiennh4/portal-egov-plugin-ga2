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

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
Folder folder = (Folder)request.getAttribute("view.jsp-folder");

long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));

long repositoryId = GetterUtil.getLong((String)request.getAttribute("view.jsp-repositoryId"));

List<DLFileEntryType> fileEntryTypes = Collections.emptyList();

if ((folder == null) || folder.isSupportsMetadata()) {
	fileEntryTypes = DLFileEntryTypeLocalServiceUtil.getFolderFileEntryTypes(DLUtil.getGroupIds(themeDisplay), folderId, true);
}
%>

<liferay-ui:icon-menu align="left" direction="down" icon="" message="add" showExpanded="<%= false %>" showWhenSingleIcon="<%= true %>">
	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_FOLDER) %>">
		<portlet:renderURL var="addFolderURL">
			<portlet:param name="struts_action" value="/document_library/edit_folder" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="parentFolderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="folder" message='<%= (folder != null) ? "subfolder" : "folder" %>' url="<%= addFolderURL %>" />
	</c:if>

	<c:if test="<%= ((folder == null) || folder.isSupportsMultipleUpload()) && DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_DOCUMENT) %>">
		<portlet:renderURL var="editFileEntryURL">
			<portlet:param name="struts_action" value="/document_library/upload_multiple_file_entries" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon cssClass="aui-helper-hidden upload-multiple-documents" image="../document_library/add_multiple_documents" message="upload-files" url="<%= editFileEntryURL %>" />
	</c:if>
</liferay-ui:icon-menu>

<aui:script use="aui-base,aui-swf">
	if (A.SWF.isFlashVersionAtLeast(9)) {
		var uploadMultipleDocumentsIcon = A.all('.upload-multiple-documents:hidden');

		uploadMultipleDocumentsIcon.show();
	}
</aui:script>