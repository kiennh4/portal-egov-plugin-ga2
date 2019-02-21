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

<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil" %>

<style type="text/css">
	.view-category .taglib-header {
		border-bottom: 1px solid #e4e4e4;
	}
</style>

<%@ include file="/html/portlet/asset_category_admin/init.jsp" %>

<%
long categoryId = ParamUtil.getLong(request, "categoryId");

AssetCategory category = AssetCategoryServiceUtil.getCategory(categoryId);

List<AssetCategoryProperty> categoryProperties = AssetCategoryPropertyServiceUtil.getCategoryProperties(category.getCategoryId());
%>

<div class="view-category">
	<liferay-ui:header
		localizeTitle="<%= false %>"
		title="<%= category.getTitle(locale) %>"
	/>

	<c:if test="<%= category != null %>">
		<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetCategory.class.getName(), category.getCategoryId(), ActionKeys.UPDATE) %>">
			<aui:button id="editCategoryButton" value="edit" />
		</c:if>

		<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetCategory.class.getName(), category.getCategoryId(), ActionKeys.DELETE) %>">
			<aui:button id="deleteCategoryButton" value="delete" />
		</c:if>
		
		<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, AssetCategory.class.getName(), category.getCategoryId(), ActionKeys.PERMISSIONS) %>">
			<liferay-security:permissionsURL
				modelResource="<%= AssetCategory.class.getName() %>"
				modelResourceDescription="<%= category.getTitle(locale) %>"
				resourcePrimKey="<%= String.valueOf(category.getCategoryId()) %>"
				var="permissionsURL"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>"
			/>

			<aui:button data-url="<%= permissionsURL %>" id="updateCategoryPermissions" value="permissions" />
		</c:if>
		
		<c:if test="<%= AssetPermission.contains(permissionChecker, themeDisplay.getParentGroupId(), ActionKeys.ADD_CATEGORY) %>">
			<aui:button id="addSubCategoryButton" value="add-subcategory" />
		</c:if>

	</c:if>

	<c:if test="<%= Validator.isNotNull(category.getDescription(locale)) %>">
		<div class="category-field">
			<label><liferay-ui:message key="description" />:</label> <%= category.getDescription(locale) %>
		</div>
	</c:if>

<%-- 
/**@INFO : HOOK by HUNGDX at 15/05/2012
  *@NOIDUNG : Hien thi Properties cua Category	
*/
--%>	
	
	<c:if test="<%= !categoryProperties.isEmpty()%>">
		<div class="category-field">
			<label><liferay-ui:message key="properties" />:</label>		
				
			<%
			for (AssetCategoryProperty categoryProperty : categoryProperties) {
				
				String propertyKey = categoryProperty.getKey();
			%>
				<!-- Kiem tra gia tri cua Property Key.Neu key = "link-to-page" thi hien thi ten Trang Web 
					theo plId = property value-->
				<c:choose>				
					<c:when test='<%=Validator.equals(propertyKey,"link-to-page")%>'>
						<%
							String propertyValue = categoryProperty.getValue();
						
							long plId = Long.parseLong(propertyValue);
							
							if(plId > 0)
							{
								Layout selectedLayout = LayoutLocalServiceUtil.getLayout(plId);
								
								if(selectedLayout != null)
								{
						%>
									<span class="property-key"><liferay-ui:message key="<%= categoryProperty.getKey() %>" /></span>
									: 
									<span class="property-value"><liferay-ui:message key="<%= selectedLayout.getName() %>" /></span>
									<br />	
						<%
								}//End if(layout != null)
							}// End if(plId > 0)
							else
							{
						%>
								<span class="property-key"><liferay-ui:message key="<%= categoryProperty.getKey() %>" /></span>
								: 
								<span class="property-value"><liferay-ui:message key="None" /></span>
								<br />	
						<%
							}
						%>
					</c:when>
					
					<c:otherwise>
						<span class="property-key"><liferay-ui:message key="<%= categoryProperty.getKey() %>" /></span>
						: 
						<span class="property-value"><%= categoryProperty.getValue() %></span>
						<br />
					</c:otherwise>
				</c:choose>				
			<%
			}
			%>
<!-- END HOOK -->
		</div>
	</c:if>
</div>