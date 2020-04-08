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

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/portlet/search/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

if (Validator.isNotNull(redirect)) {
	portletDisplay.setURLBack(redirect);
}

String primarySearch = ParamUtil.getString(request, "primarySearch");

if (Validator.isNotNull(primarySearch)) {
	portalPreferences.setValue(PortletKeys.SEARCH, "primary-search", primarySearch);
}
else {
	primarySearch = portalPreferences.getValue(PortletKeys.SEARCH, "primary-search", StringPool.BLANK);
}

long groupId = ParamUtil.getLong(request, "groupId",PortalUtil.getScopeGroupId(request));

Group group = themeDisplay.getScopeGroup();

String keywords = ParamUtil.getString(request, "keywords");

String format = ParamUtil.getString(request, "format");

List<String> portletTitles = new ArrayList<String>();

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/search/search");
portletURL.setParameter("keywords", keywords);
portletURL.setParameter("format", format);

request.setAttribute("search.jsp-portletURL", portletURL);
%>

<style type="text/css">
	
	.portal_egov_global_search{
		padding: 5px;
	}
		
	.portal_egov_global_search .portal_egov_global_search_form_wrapper{
		background-color: #F1F1F1;
		border: 1px solid #E5E5E5;
		padding-top: 5px;
		padding-bottom: 5px;
		width: 100%;
	}
				
	.portal_egov_global_search_form_wrapper .portal_egov_global_search_form{
		margin-top: 10px;
		margin-bottom: 10px;
	}
				
	.portal_egov_global_search_form_wrapper .portal_egov_global_search_form .search-title{
		font-size: 14px;
		font-weight: bold;
		color: #00528B;
		margin-left: 10px;
		margin-right: 10px;
	}

	.portal_egov_global_search_form_wrapper .portal_egov_global_search_form .search-btn{
		border: 1px solid #E5E5E5;
	}
			
	.portal_egov_global_search .portal_egov_global_search_results_wrapper{
		padding-bottom: 5px;
		padding-top: 10px;
	}
				
	.portal_egov_global_search .portal_egov_global_search_results_wrapper .menu .search-facet{
		border-top: 1px solid #E5E5E5 !important;
		padding: 10px 0px;
	}
					
	.portal_egov_global_search .portal_egov_global_search_results_wrapper .menu .search-facet ul{
		margin: 0px;
		padding: 0px;
	}
						
	.portal_egov_global_search .portal_egov_global_search_results_wrapper .menu .search-facet ul li{
		height: 25px;
	}
	
	.portal_egov_global_search .portal_egov_global_search_results_wrapper .menu .search-facet ul li{
		height: 25px;
	}
							
	.portal_egov_global_search .portal_egov_global_search_results_wrapper .menu .search-facet .facet-value{
		font-size: 12px;
	}
								
	.portal_egov_global_search .portal_egov_global_search_results_wrapper .menu .search-facet .facet-value .frequency{
		font-size: 11px;
		color: #999999;
	}
											
	.portal_egov_global_search_results_wrapper .search-results-info{
		font-size: 12px;
		color: #999999;
		font-weight: bold;
		padding-left: 20px;
		padding-bottom: 20px;
	}
									
	.portal_egov_global_search_results_wrapper .lfr-search-container .results-grid{
		border: 0 none;
		padding-left: 10px;
	}
								
	.portal_egov_global_search_results_wrapper .lfr-search-container .results-header{
		display: none;
	}
										
	.portal_egov_global_search_results_wrapper .lfr-search-container .results-row td{
		height: 40px;
	}
									
	.portal_egov_global_search_results_wrapper .lfr-search-container .results-row td{
		border: 0 none;
	}
										
	.portal_egov_global_search_results_wrapper .lfr-search-container .search-results{
		display: none;
	}
										
	.portal_egov_global_search_results_wrapper .asset-entry .asset-entry-title{
		font-size: 12px;
		color: #00528B;
		font-weight: bold;
	}
											
	.portal_egov_global_search_results_wrapper .asset-entry .asset-entry-title a img{
		position: relative;
		top: 3px;
	}
												
	.portal_egov_global_search_results_wrapper .asset-entry .asset-entry-summary{
		display: block;
		text-align: justify;
	}
											
	.portal_egov_global_search_results_wrapper .asset-entry .asset-entry-type{
		font-size: 10px;
	}
											
	.portal_egov_global_search_results_wrapper .asset-entry .asset-vocabulary{
		background: url("/html/portlet/search/images/data_type_icon/asset_tag_icon.png") no-repeat scroll 0 50% transparent;
		padding: 2px 5px 2px 20px;
	}
</style>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="struts_action" value="/search/search" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
	
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	
	<aui:input name="format" type="hidden" value="<%= format %>" />

	<div class="portal_egov_global_search">
	
		<div class="portal_egov_global_search_form_wrapper">
		
			<div class="portal_egov_global_search_form">
			
				<span class="search-title"><liferay-ui:message key="portal-egov-content-search"/></span>
				
				<aui:input inlineField="<%= true %>" label="" name="keywords" size="30" value="<%= keywords %>" placeholder="search-keyword" />
				
				<aui:button class="search-btn" align="absmiddle" border="0"  value="search" onClick='<%= renderResponse.getNamespace() + "search();" %>' />
			</div>
		</div>
		
		<div class="portal_egov_global_search_results_wrapper">
			<%@ include file="/html/portlet/search/main_search.jspf" %>
		
			<c:if test="<%= displayOpenSearchResults %>">
				<liferay-ui:panel collapsible="<%= true %>" cssClass="open-search-panel" extended="<%= true %>" id="searchOpenSearchPanelContainer" 
									persistState="<%= true %>" title="open-search">
					<%@ include file="/html/portlet/search/open_search.jspf" %>
				</liferay-ui:panel>
			</c:if>
		</div>
	</div>
</aui:form>

<aui:script use="aui-base">
	var pageLinks = A.one('.portlet-search .result .page-links');

	if (pageLinks) {
		pageLinks.delegate(
			'click',
			function(event) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= SearchContainer.DEFAULT_CUR_PARAM %>.value = 1;

				submitForm(document.<portlet:namespace />fm);

				event.preventDefault();
			},
			'a.first'
		);

		pageLinks.delegate(
			'click',
			function(event) {
				submitForm(document.<portlet:namespace />fm);

				event.preventDefault();
			},
			'a.previous'
		);

		pageLinks.delegate(
			'click',
			function(event) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= SearchContainer.DEFAULT_CUR_PARAM %>.value = parseInt(document.<portlet:namespace />fm.<portlet:namespace /><%= SearchContainer.DEFAULT_CUR_PARAM %>.value) + 2;

				submitForm(document.<portlet:namespace />fm);

				event.preventDefault();
			},
			'a.next'
		);
	}

	var resultsGrid = A.one('.portlet-search .result .results-grid');

	if (resultsGrid) {
		resultsGrid.delegate(
			'click',
			function(event) {
				var handle = event.currentTarget;
				var rowTD = handle.ancestor('.results-row td');

				var documentFields = rowTD.one('.asset-entry .asset-entry-fields');

				if (handle.text() == '[+]') {
					documentFields.show();
					handle.text('[-]');
				}
				else if (handle.text() == '[-]') {
					documentFields.hide();
					handle.text('[+]');
				}
			},
			'.results-row td .asset-entry .toggle-details'
		);
	}

	Liferay.provide(
		window,
		'<portlet:namespace />addSearchProvider',
		function() {
			window.external.AddSearchProvider("<%= themeDisplay.getPortalURL() %><%= PortalUtil.getPathMain() %>/search/open_search_description.xml?p_l_id=<%= themeDisplay.getPlid() %>&groupId=<%= groupId %>");
		},
		['aui-base']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />search',
		function() {
			var keywords = document.<portlet:namespace />fm.<portlet:namespace />keywords.value;

			keywords = keywords.replace(/^\s+|\s+$/, '');

			if (keywords != '') {
				submitForm(document.<portlet:namespace />fm);
			}
		},
		['aui-base']
	);

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />keywords);
	</c:if>
</aui:script>

<%
String pageSubtitle = LanguageUtil.get(pageContext, "search-results");
String pageDescription = LanguageUtil.get(pageContext, "search-results");
String pageKeywords = LanguageUtil.get(pageContext, "search");

if (!portletTitles.isEmpty()) {
	pageDescription = LanguageUtil.get(pageContext, "searched") + StringPool.SPACE + StringUtil.merge(portletTitles, StringPool.COMMA_AND_SPACE);
}

if (Validator.isNotNull(keywords)) {
	pageKeywords = keywords;

	if (StringUtil.startsWith(pageKeywords, Field.ASSET_TAG_NAMES + StringPool.COLON)) {
		pageKeywords = StringUtil.replace(pageKeywords, Field.ASSET_TAG_NAMES + StringPool.COLON, StringPool.BLANK);
	}
}

PortalUtil.setPageSubtitle(pageSubtitle, request);
PortalUtil.setPageDescription(pageDescription, request);
PortalUtil.setPageKeywords(pageKeywords, request);
%>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.search.search_jsp");
%>