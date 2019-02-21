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

<style type="text/css">

	.tags-admin-container{
		border: none;
	}
	
	.tags-admin-container .lfr-header-row{
		margin-bottom: 10px;
		border-radius: 4px;
		background: url("/html/portlet/asset_tag_admin/images/toolbar_header_bg.png") repeat-x scroll 0 0 #D9D9D9;
    	border: 1px solid #C9C9C9;
	}
			
	.tags-admin-container .lfr-header-row .toolbar{
		display: inline-block;
	}
	
	.tags-admin-container .lfr-header-row .toolbar .aui-button,
	.tags-admin-container .lfr-header-row .toolbar .lfr-actions{
		display: block;
		float: left;
		margin-left: 0;
		margin-right: .3em;
	}
		
	.tags-admin-container .lfr-header-row .lfr-search-combobox{
		border: none;
	}
			
	.tags-admin-container .lfr-header-row .tags-search-combobox input[type="text"]{
		margin-top: 2px;
		display: inline-block;
		padding: 6px 5px !important;
		color: #555555;
		vertical-align: middle;
		-webkit-border-radius: 3px !important;
		   -moz-border-radius: 3px !important;
		        border-radius: 3px !important;
		background-color: #ffffff !important;
		border: 1px solid #cccccc ;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
		   -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
		        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075) !important;
		-webkit-transition: border linear 0.2s, box-shadow linear 0.2s !important;
		   -moz-transition: border linear 0.2s, box-shadow linear 0.2s !important;
		     -o-transition: border linear 0.2s, box-shadow linear 0.2s !important;
		        transition: border linear 0.2s, box-shadow linear 0.2s !important;
	}
		
	.tags-admin-container .lfr-header-row .tags-search-combobox input[type="text"]:focus{
	  border-color: rgba(82, 168, 236, 0.8) !important;
	  outline: 0;
	  outline: thin dotted \9;
	  /* IE6-9 */
	
	  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	     -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	          box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6) !important;
	}
	
	.portlet-asset-tag-admin .tags-admin-container .results-header {
		background: #e2eef3;
		font-weight: bold;
		padding: 5px 10px;
		position: relative;
		border-bottom: 1px solid #E4E4E4;
	}
	.tags-admin-container input[type="submit"],
	.tags-admin-container input[type="button"],
	.tags-admin-container input[type="reset"],
	.tags-admin-container  button,
	.tags-admin-container .lfr-header-row .lfr-actions {
		border-color: #C8C9CA #9E9E9E #9E9E9E #C8C9CA!important;
	}

</style>

<%@ include file="/html/portlet/asset_tag_admin/init.jsp" %>

<aui:form name="fm">

<div class="tags-admin-container lfr-app-column-view">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="toolbar" align="left">
				<c:if test="<%= AssetPermission.contains(permissionChecker, themeDisplay.getParentGroupId(), ActionKeys.ADD_TAG) %>">
					<aui:button cssClass="add-tag-button" name="addTagButton" value="add-tag" />
				</c:if>

				<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, themeDisplay.getParentGroupId(), ActionKeys.PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="com.liferay.portlet.asset"
						modelResourceDescription="<%= themeDisplay.getScopeGroupName() %>"
						resourcePrimKey="<%= String.valueOf(themeDisplay.getParentGroupId()) %>"
						var="permissionsURL"
						windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>

					<aui:button data-url="<%= permissionsURL %>" name="tagsPermissionsButton" value="permissions" />
				</c:if>
				
				<liferay-ui:icon-menu
					direction="down"
					icon=""
					message="actions"
					showExpanded="<%= false %>"
					showWhenSingleIcon="true"
				>
					<liferay-ui:icon
						id="deleteSelectedTags"
						image="delete"
						url="javascript:;"
					/>

					<liferay-ui:icon
						id="mergeSelectedTags"
						image="../common/all_pages"
						message="merge"
						url="javascript:;"
					/>
				</liferay-ui:icon-menu>
			</div>

			<div class="lfr-search-combobox search-button-container tags-search-combobox">
				<aui:input cssClass="first keywords lfr-search-combobox-item tags-admin-search" label="" name="tagsAdminSearchInput" type="text" />
			</div>
		</div>
	</div>

	<div class="tags-admin-content-wrapper" style="border: 1px solid #d2d2d2;border-radius: 2px;">
		<aui:layout cssClass="tags-admin-content">
			<aui:column columnWidth="35" cssClass="tags-admin-list-container">
				<div class="results-header">
					<aui:input inline="<%= true %>" label="tags" inlineLabel="right" name="checkAllTags" type="checkbox" title='<%= LanguageUtil.get(pageContext, "check-all-tags") %>' />
				</div>

				<div class="tags-admin-list lfr-component"></div>

				<div class="tags-paginator"></div>
			</aui:column>

			<aui:column columnWidth="65" cssClass="tags-admin-edit-tag">
				<div class="results-header">
					<div style="margin-left: 1em;">
						<liferay-ui:message key="tag-details" />
					</div>
				</div>

				<div class="tag-view-container"></div>
			</aui:column>
		</aui:layout>
	</div>
</div>

</aui:form>

<aui:script use="liferay-tags-admin">
	new Liferay.Portlet.AssetTagsAdmin(
		{
			portletId: '<%= portletDisplay.getId() %>',
			tagsPerPage: <%= SearchContainer.DEFAULT_DELTA %>,
			tagsPerPageOptions: [<%= StringUtil.merge(PropsValues.SEARCH_CONTAINER_PAGE_DELTA_VALUES) %>]
		}
	);
</aui:script>