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

<%@page import="com.bkav.portal.portlet.autoupdate.util.UpdatePluginsModel"%>
<%@page import="com.bkav.portal.portlet.autoupdate.util.AutoUpdateAdminUtil"%>
<%@page import="com.bkav.portal.portlet.autoupdate.util.AutoUpdateConnector"%>
<%@page import="java.util.List"%>
<style type="text/css">
	#panel-manage-content .lfr-panel-titlebar .lfr-panel-title-single{
		padding: 0px !important;
	}

</style>

<%@ include file="/html/portlet/control_panel_menu/init.jsp" %>

<h1 class="user-greeting">er	<liferay-ui:message key="control-panel" />
</h1>

<div class="portal-add-content">
	<div class="control-panel-tools">
		<aui:input cssClass="search-panels" inputCssClass="search-panels-input" label="" name="searchPanel" />
	</div>

	<liferay-ui:panel-container extended="<%= true %>" id="controlPanelMenuAddContentPanelContainer" persistState="<%= true %>">

		<%
		String ppid = GetterUtil.getString((String)request.getAttribute("control_panel.jsp-ppid"), layoutTypePortlet.getStateMaxPortletId());

		String category = PortalUtil.getControlPanelCategory(ppid, themeDisplay);

		String[] allCategories = PortletCategoryKeys.ALL;
		
		String controlPanelCategory = HttpUtil.getParameter(PortalUtil.getCurrentURL(request), "controlPanelCategory", false);

		if (Validator.isNotNull(controlPanelCategory)) {
			allCategories = new String[] {controlPanelCategory};
		}

		for (String curCategory : allCategories) {
			
			
			
			Collection<Portlet> categoryPortlets = PortalUtil.getControlPanelPortlets(themeDisplay.getCompanyId(), curCategory);

			List<Layout> scopeLayouts = new ArrayList<Layout>();

			String curGroupLabel = null;
			Group curGroup = null;

			String title = null;

			if (curCategory.equals(PortletCategoryKeys.MY)) {
				title = HtmlUtil.escape(StringUtil.shorten(user.getFullName(), 25));
			}
			else if (curCategory.equals(PortletCategoryKeys.CONTENT)) {
				Layout scopeLayout = null;

				curGroup = themeDisplay.getScopeGroup();

				if (curGroup.isLayout()) {
					scopeLayout = LayoutLocalServiceUtil.getLayout(curGroup.getClassPK());

					curGroup = scopeLayout.getGroup();
				}

				List<Group> manageableSites = null;

				if (Validator.isNotNull(controlPanelCategory)) {
					manageableSites = new ArrayList<Group>();

					if (curGroup.isUser()) {
						manageableSites.add(user.getGroup());
					}
					else {
						long groupId = GetterUtil.getLong(HttpUtil.getParameter(PortalUtil.getCurrentURL(request), "doAsGroupId", false));

						Group group = GroupLocalServiceUtil.getGroup(groupId);

						manageableSites.add(group);
					}
				}
				else {
					manageableSites = GroupServiceUtil.getManageableSites(categoryPortlets, PropsValues.CONTROL_PANEL_NAVIGATION_MAX_SITES);

					Group userGroup = user.getGroup();

					if (userGroup.hasPrivateLayouts() || userGroup.hasPublicLayouts()) {
						manageableSites.add(0, userGroup);
					}

					if (PortalUtil.isCompanyControlPanelVisible(themeDisplay)) {
						Group companyGroup = GroupLocalServiceUtil.getCompanyGroup(themeDisplay.getCompanyId());

						manageableSites.add(0, companyGroup);
					}
				}

				Group curLiveGroup = curGroup;

				if (curGroup.isStagingGroup()) {
					curLiveGroup = curGroup.getLiveGroup();
				}

				if (!manageableSites.isEmpty() && !manageableSites.contains(curLiveGroup)) {
					if (curLiveGroup.isSite() && PortletPermissionUtil.contains(permissionChecker, curLiveGroup.getGroupId(), 0, categoryPortlets, ActionKeys.ACCESS_IN_CONTROL_PANEL)) {
						manageableSites.add(0, curLiveGroup);
					}
					else {
						curGroup = manageableSites.get(0);

						curLiveGroup = curGroup;

						themeDisplay.setScopeGroupId(curGroup.getGroupId());
					}
				}

				String curGroupName = null;

				if (curGroup.isUser() && (curGroup.getClassPK() == user.getUserId())) {
					curGroupName = LanguageUtil.format(pageContext, "x-personal-site", curLiveGroup.getDescriptiveName(locale));
				}
				else {
					curGroupName = curLiveGroup.getDescriptiveName(locale);
				}

				if (category.equals(PortletCategoryKeys.CONTENT)) {
					PortalUtil.addPortletBreadcrumbEntry(request, curGroupName, null);
				}

				if (scopeLayout == null) {
					curGroupLabel = LanguageUtil.get(pageContext, "default");
				}
				else {
					curGroupLabel = scopeLayout.getName(locale);

					if (category.equals(PortletCategoryKeys.CONTENT)) {
						PortalUtil.addPortletBreadcrumbEntry(request, curGroupLabel, null);
					}
				}
				%>

				<liferay-util:buffer var="groupSelectorIconMenu">
							<%
							String image = "site_icon";

							if (curGroup.isCompany()) {
								image = "folder";
							}
							else if (curGroup.isOrganization()) {
								image = "organization_icon";
							}
							else if (curGroup.isUser()) {
								image = "user_icon";
							}
							%>

							<liferay-ui:icon
								cssClass="lfr-panel-title-single"
								image="<%= image %>"
								label="<%= true %>"
								message="<%= HtmlUtil.escape(StringUtil.shorten(curGroupName, 25)) %>"
							/>
				</liferay-util:buffer>

				<%
				scopeLayouts.addAll(LayoutLocalServiceUtil.getScopeGroupLayouts(curGroup.getGroupId(), false));
				scopeLayouts.addAll(LayoutLocalServiceUtil.getScopeGroupLayouts(curGroup.getGroupId(), true));

				title = groupSelectorIconMenu;
			}
			else if (curCategory.equals(PortletCategoryKeys.PORTAL) && (CompanyLocalServiceUtil.getCompaniesCount(false) > 1)) {
				title = HtmlUtil.escape(company.getName());
			}
			else {
				title = LanguageUtil.get(pageContext, "category." + curCategory);
			}

			List<Portlet> portlets = PortalUtil.getControlPanelPortlets(curCategory, themeDisplay);
		%>

			<liferay-util:buffer var="categoryPortletsContent">
				<c:if test="<%= !scopeLayouts.isEmpty() && curCategory.equals(PortletCategoryKeys.CONTENT) %>">
					<div class="nobr lfr-title-scope-selector">
						<liferay-ui:icon-menu align="left" direction="down" icon="" message='<%= LanguageUtil.get(pageContext, "scope") + StringPool.COLON + StringPool.SPACE + curGroupLabel %>'>
							<liferay-ui:icon
								image="folder"
								message="default"
								url='<%= HttpUtil.setParameter(PortalUtil.getCurrentURL(request), "doAsGroupId", curGroup.getGroupId()) %>'
							/>

							<%
							for (Layout curScopeLayout : scopeLayouts) {
							%>

								<liferay-ui:icon
									image="folder"
									message="<%= HtmlUtil.escape(curScopeLayout.getName(locale)) %>"
									url='<%= HttpUtil.setParameter(PortalUtil.getCurrentURL(request), "doAsGroupId", curScopeLayout.getScopeGroup().getGroupId()) %>'
								/>

							<%
							}
							%>

						</liferay-ui:icon-menu>
					</div>
				</c:if>

				<ul class="category-portlets">

					<%
					for (Portlet portlet : portlets) {
						if (portlet.isActive() && !portlet.isInstanceable()) {
							String portletId = portlet.getPortletId();
							
							String portletName_ = PortalUtil.getPortletTitle(portlet, application, locale);
							
							if (portletId.equals("autoupdateadmin_WAR_autoupdateportlet"))
							{
								List<UpdatePluginsModel> listAvailablePlugins_ = AutoUpdateConnector.getAllAvailablePlugins("localhost:8086");

								List<UpdatePluginsModel> listUpdatePlugins_ = AutoUpdateAdminUtil.getUpdatePlugins(listAvailablePlugins_);
								
								portletName_ = portletName_ + "<span style = \"color: red;font-weight:blod;font-size:13px\">  "+listUpdatePlugins_.size()+"  </span>";
							}
					%>

							<li class="<%= ppid.equals(portletId) ? "selected-portlet" : "" %>">
								<a href="<liferay-portlet:renderURL doAsGroupId="<%= themeDisplay.getScopeGroupId() %>" portletName="<%= portlet.getRootPortletId() %>" windowState="<%= WindowState.MAXIMIZED.toString() %>" />" id="<portlet:namespace />portlet_<%= portletId %>">
									<c:choose>
										<c:when test="<%= Validator.isNull(portlet.getIcon()) %>">
											<liferay-ui:icon src='<%= themeDisplay.getPathContext() + "/html/icons/default.png" %>' />
										</c:when>
										<c:otherwise>
											<liferay-portlet:icon-portlet portlet="<%= portlet %>" />
										</c:otherwise>
									</c:choose>

									<%= portletName_%>
								</a>
							</li>

					<%
						}
					}
					%>

				</ul>
			</liferay-util:buffer>

			<c:choose>
				<c:when test="<%= Validator.isNotNull(controlPanelCategory) %>">
					<div class="lfr-panel-container" id="controlPanelMenuAddContentPanelContainer">
						<div class="lfr-panel lfr-component panel-page-category lfr-extended" id="panel-manage-content">
							<div class="lfr-panel-content">

								<%= categoryPortletsContent %>

							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<c:if test="<%= !portlets.isEmpty() %>">
						<liferay-ui:panel collapsible="<%= true %>" cssClass="lfr-component panel-page-category" extended="<%= true %>" id='<%= "panel-manage-" + curCategory %>' persistState="<%= true %>" title="<%= title %>">

							<%= categoryPortletsContent %>

						</liferay-ui:panel>
					</c:if>
				</c:otherwise>
			</c:choose>

		<%
		}
		%>

	</liferay-ui:panel-container>
</div>

<aui:script use="liferay-panel">
	var trigger = A.one('#<portlet:namespace />groupSelector a');

	var panelContainer = Liferay.Panel.get('controlPanelMenuAddContentPanelContainer');

	if (trigger && panelContainer) {
		trigger.on(
			'click',
			function(event) {
				panelContainer.once(
					'collapse',
					function(event) {
						event.preventDefault();
					}
				);
			}
		);
	}
</aui:script>