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

<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<style type="text/css">

	.search-pages{
		padding-top: 5px;
		padding-bottom: 5px;
		text-align: right;
	}
	
	.search-pages a{
		text-decoration: underline;
	}
	
	.subscribe .opens-new-window-accessible{
		display: none;
	}
	
</style>

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>
<%
	if (mergeUrlTags || mergeLayoutTags) {
		String[] compilerTagNames = new String[0];
	
		if (mergeUrlTags) {
			compilerTagNames = (String[])request.getAttribute(WebKeys.TAGS_COMPILER_ENTRIES);
		}
	
		if (mergeLayoutTags) {
			Set<String> layoutTagNames = AssetUtil.getLayoutTagNames(request);
	
			if (!layoutTagNames.isEmpty()) {
				compilerTagNames = ArrayUtil.append(compilerTagNames, layoutTagNames.toArray(new String[layoutTagNames.size()]));
			}
		}
	
		String titleEntry = null;
	
		if ((compilerTagNames != null) && (compilerTagNames.length > 0)) {
			String[] newAssetTagNames = ArrayUtil.append(allAssetTagNames, compilerTagNames);
	
			allAssetTagNames = ArrayUtil.distinct(newAssetTagNames, new StringComparator());
	
			long[] allAssetTagIds = AssetTagLocalServiceUtil.getTagIds(scopeGroupId, allAssetTagNames);
	
			assetEntryQuery.setAllTagIds(allAssetTagIds);
	
			titleEntry = compilerTagNames[compilerTagNames.length - 1];
		}
	
		String portletTitle = HtmlUtil.unescape(portletDisplay.getTitle());
	
		portletTitle = AssetUtil.substituteTagPropertyVariables(scopeGroupId, titleEntry, portletTitle);
	
		renderResponse.setTitle(portletTitle);
	}
	else {
		allAssetTagNames = ArrayUtil.distinct(allAssetTagNames, new StringComparator());
	}
	
	for (String curAssetTagName : allAssetTagNames) {
		try {
			AssetTag assetTag = AssetTagLocalServiceUtil.getTag(scopeGroupId, curAssetTagName);
	
			AssetTagProperty journalTemplateIdProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(assetTag.getTagId(), "journal-template-id");
	
			String journalTemplateId = journalTemplateIdProperty.getValue();
	
			request.setAttribute(WebKeys.JOURNAL_TEMPLATE_ID, journalTemplateId);
	
			break;
		}
		catch (NoSuchTagException nste) {
		}
		catch (NoSuchTagPropertyException nstpe) {
		}
	}
	
	if (enableTagBasedNavigation && selectionStyle.equals("manual") && ((assetEntryQuery.getAllCategoryIds().length > 0) || (assetEntryQuery.getAllTagIds().length > 0))) {
		selectionStyle = "dynamic";
	}
	
	Group group = themeDisplay.getScopeGroup();
	
	
	%>

	<c:if test="<%= (group != null) && (!group.hasStagingGroup() || group.isStagingGroup()) && !portletName.equals(PortletKeys.RELATED_ASSETS) %>">
		<aui:form name="fm">

			<%
			for (long groupId : groupIds) {
			%>

				<div class="lfr-meta-actions add-asset-selector">
					<%@ include file="/html/portlet/asset_publisher/add_asset.jspf" %>
				</div>

			<%
			}
			%>
	
		</aui:form>
	</c:if>

	<%
	PortletURL portletURL = renderResponse.createRenderURL();
	
	if (request.getParameter("topicCategoryIds")!=null)
	{
		portletURL.setParameter("topicCategoryIds",request.getParameter("topicCategoryIds"));
	}
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);

	if (!paginationType.equals("none")) {
		searchContainer.setDelta(delta);
		searchContainer.setDeltaConfigurable(false);
	}
	
	AssetCategory currentCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(assetCategoryId);
	%>

<c:if test="<%= showMetadataDescriptions %>">
	<%
		//Set Portlet Title = cityMapName
		PortletPreferences portletPreference = 	PortletPreferencesFactoryUtil.getLayoutPortletSetup(themeDisplay.getLayout(), PortalUtil.getPortletId(request));			
		
		portletPreference.setValue("portlet-setup-use-custom-title", String.valueOf(true));
		portletPreference.store();
		
	%>
	<c:choose>
		<c:when test='<%= (currentCategory != null) && Validator.isNotNull(assetTagName) && selectionStyle.equals("dynamic") %>'>
			<div class="asset-categorization-title">
				<liferay-ui:message arguments="<%= new String[] {assetCategoryTitle, assetTagName} %>" key="content-with-category-x-and-tag-x" />
			</div>

			<%
			AssetUtil.addPortletBreadcrumbEntries(assetCategoryId, request, portletURL);
			AssetUtil.addPortletBreadcrumbEntry(request, assetTagName, currentURL);
			
			renderResponse.setTitle(assetCategoryTitle);
			%>

		</c:when>
		<c:otherwise>
			<c:if test='<%= (currentCategory != null) && selectionStyle.equals("dynamic") %>'>
				<div class="asset-categorization-title">
					<liferay-ui:message  key="<%= assetCategoryTitle %>" />
				</div>
				<%
				AssetUtil.addPortletBreadcrumbEntries(assetCategoryId, request, portletURL);
				renderResponse.setTitle(assetCategoryTitle);
				%>
			</c:if>

			<c:if test='<%= Validator.isNotNull(assetTagName) && selectionStyle.equals("dynamic") %>'>
				<div class="asset-categorization-title">
					<liferay-ui:message  key="<%= assetTagName %>" />
				</div>

				<%
				AssetUtil.addPortletBreadcrumbEntry(request, assetTagName, currentURL);
				renderResponse.setTitle(assetTagName);
				%>

			</c:if>
		</c:otherwise>
	</c:choose>
</c:if>

<c:choose>
	<c:when test='<%= selectionStyle.equals("dynamic") %>'>
		<%@ include file="/html/portlet/asset_publisher/view_dynamic_list.jspf" %>
	</c:when>
	<c:when test='<%= selectionStyle.equals("manual") %>'>
		<%@ include file="/html/portlet/asset_publisher/view_manual.jspf" %>
	</c:when>
</c:choose>
<c:if test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= paginationType %>" />
</c:if>

<c:if test="<%= enableRSS %>">
	<portlet:resourceURL var="rssURL">
		<portlet:param name="struts_action" value="/asset_publisher/rss" />
	</portlet:resourceURL>

	<div class="subscribe">
		<liferay-ui:icon
			image="rss"
			label="<%= true %>"
			method="get"
			target="_blank"
			url="<%= rssURL %>"
		/>
	</div>

	<liferay-util:html-top>
		<link href="<%= HtmlUtil.escape(rssURL) %>" rel="alternate" title="RSS" type="application/rss+xml" />
	</liferay-util:html-top>
</c:if>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.view_jsp");
%>