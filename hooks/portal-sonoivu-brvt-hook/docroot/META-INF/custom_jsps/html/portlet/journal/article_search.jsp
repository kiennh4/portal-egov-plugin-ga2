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

	@Date : 22/11/2012
	@user: HungDX
	@Content: Override.Sua noi dung hien thi
--%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<style type="text/css">
	
	.portlet-journal .aui-search-bar input[type="text"]{
		width: 400px !important;
		border-radius: 2px !important;
	}
</style>

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
ArticleSearch searchContainer = (ArticleSearch)request.getAttribute("liferay-ui:search:searchContainer");

ArticleDisplayTerms displayTerms = (ArticleDisplayTerms)searchContainer.getDisplayTerms();

%>
<div>
	<span class="aui-search-bar">
		<aui:input name="<%= displayTerms.TITLE %>" inlineField="<%= true %>" label="" type="text" value="<%= displayTerms.getTitle() %>" 
					placeHolder='<%=LanguageUtil.get(locale, "article-search") %>'/>
		
		<input class="aui-field-input aui-field-input-text" id="_15_toggle_id_journal_article_searchadvancedSearch" name="_15_advancedSearch" type="hidden" value="true">
		
		<aui:button type="submit" value="search"/>
	</span>
</div>
<%
boolean showAddArticleButtonButton = false;
boolean showPermissionsButton = false;
boolean showSubscribeLink = false;

if (portletName.equals(PortletKeys.JOURNAL)) {
	showAddArticleButtonButton = JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ARTICLE);
	showPermissionsButton = JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
	showSubscribeLink = JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.SUBSCRIBE);
}
%>

<c:if test="<%= showAddArticleButtonButton || showPermissionsButton %>">
	<aui:button-row cssClass="add-permission-button-row">
		<c:if test="<%= showAddArticleButtonButton %>">
			<div class="add-article-selector">
				<%@ include file="/html/portlet/journal/add_article.jspf" %>
			</div>
		</c:if>

		<c:if test="<%= showPermissionsButton %>">
			<liferay-security:permissionsURL
				modelResource="com.liferay.portlet.journal"
				modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
				resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
				var="permissionsURL"
			/>

			<aui:button href="<%= permissionsURL %>" value="article-permissions" />
		</c:if>
	</aui:button-row>
</c:if>

<c:if test="<%= Validator.isNotNull(displayTerms.getStructureId()) %>">
	<aui:input name="<%= displayTerms.STRUCTURE_ID %>" type="hidden" value="<%= displayTerms.getStructureId() %>" />

	<div class="portlet-msg-info">

		<%
		JournalStructure structure = JournalStructureLocalServiceUtil.getStructure(scopeGroupId, displayTerms.getStructureId());
		%>

		<liferay-ui:message arguments="<%= structure.getName(locale) %>" key="showing-content-filtered-by-structure-x" /> (<a href="javascript:<portlet:namespace />addArticle();"><liferay-ui:message key="add-new-web-content" /></a>)
	</div>
</c:if>

<c:if test="<%= Validator.isNotNull(displayTerms.getTemplateId()) %>">
	<aui:input name="<%= displayTerms.TEMPLATE_ID %>" type="hidden" value="<%= displayTerms.getTemplateId() %>" />

	<div class="portlet-msg-info">

		<%
		JournalTemplate template = JournalTemplateLocalServiceUtil.getTemplate(scopeGroupId, displayTerms.getTemplateId());
		%>

		<liferay-ui:message arguments="<%= template.getName(locale) %>" key="showing-content-filtered-by-template-x" /> (<a href="javascript:<portlet:namespace />addArticle();"><liferay-ui:message key="add-new-web-content" /></a>)
	</div>
</c:if>

<aui:script>
	AUI().ready('aui-base',function(A){
		
		A.all('.toggle-link a').on(
			'click',
			function() {
						
				var advancedSearch = false;
					
				var articleAdvancedSearchContainer = A.one('#toggle_id_journal_article_searchadvanced');
				
				if(articleAdvancedSearchContainer && !articleAdvancedSearchContainer.hasClass('aui-helper-hidden')){
					
					advancedSearch = true;
				}
		
				var basicSearchInput = A.one('#<portlet:namespace />toggle_id_journal_article_searchkeywords');
				var advanceSearchTitleInput = A.one('#<portlet:namespace />title');
	
				if(basicSearchInput && advanceSearchTitleInput){
					
					var basicSearchKeyword = basicSearchInput.val();
					var advancedSearchKeyword = advanceSearchTitleInput.val();
					
					if(advancedSearch){
						advanceSearchTitleInput.focus();
						advanceSearchTitleInput.val(basicSearchKeyword);
					}else{
						basicSearchInput.focus();
						basicSearchInput.val(advancedSearchKeyword);
					}
				}
			}
		);
	});
</aui:script>


<aui:script>
	
	function <portlet:namespace />addArticle() {
		var url = '<liferay-portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" portletName="<%= PortletKeys.JOURNAL %>"><portlet:param name="struts_action" value="/journal/edit_article" /><portlet:param name="redirect" value="<%= currentURL %>" /><portlet:param name="backURL" value="<%= currentURL %>" /><portlet:param name="structureId" value="<%= displayTerms.getStructureId() %>" /><portlet:param name="templateId" value="<%= displayTerms.getTemplateId() %>" /></liferay-portlet:renderURL>';

		if (toggle_id_journal_article_searchcurClickValue == 'basic') {
			url += '&<portlet:namespace /><%= displayTerms.TITLE %>=' + document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>.value;

			submitForm(document.hrefFm, url);
		}
		else {
			document.<portlet:namespace />fm.method = 'post';

			submitForm(document.<portlet:namespace />fm, url);
		}
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) || windowState.equals(LiferayWindowState.POP_UP) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.ARTICLE_ID %>);
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.KEYWORDS %>);
	</c:if>
</aui:script>