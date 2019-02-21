<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal_egov.portlet.asset_statistics.util.AssetStatisticsUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%

	int vocabularyIndex = 0;

	long totalVocabularyCounter = AssetStatisticsUtil.getGroupVocabularyCounter(groupId);

	long totalCategoryCounter = AssetStatisticsUtil.getGroupCategoryCounter(groupId);

	long totalAssetCounter = AssetStatisticsUtil.countByGroup(groupId);
	
	List<AssetVocabulary> vocabularyList = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
%>


<div class="statistics-wrapper">
	
	<liferay-util:include page="/html/view/statistic_form.jsp" servletContext="<%=this.getServletContext() %>"/>
	
	<div class="statistic-info">
		<span><liferay-ui:message key="total-vocabulary"/>: <%=totalVocabularyCounter %></span>
		<br/>
		<span><liferay-ui:message key="total-category"/>: <%=totalCategoryCounter %></span>
		<br/>
		<span><liferay-ui:message key="total-asset"/>: <%=totalAssetCounter %></span>
	</div>
	
	<div class="statistic-details">
		<table class="taglib-search-iterator">
			<tr class="results-header">
				<th><liferay-ui:message key="STT"/></th>
				<th><liferay-ui:message key="category"/></th>
				<th><liferay-ui:message key="asset-counter"/></th>
			</tr>
			
			<%
			for(AssetVocabulary vocabulary : vocabularyList){
				
				vocabularyIndex ++;
				
				long vocabularyId = vocabulary.getVocabularyId();
				String vocabularyName = vocabulary.getName();
				
				List<AssetCategory> categoryList = AssetCategoryLocalServiceUtil.getVocabularyRootCategories(vocabularyId, 0, -1, null);
			%>
			
			<tr class="results-row vocabulary-name">
				<td class="first"><%=vocabularyIndex %></td>
				<td><%=vocabularyName %></td>
				<td></td>
			</tr>
				<%
				for(AssetCategory rootCategory : categoryList){
					
					long categoryId = rootCategory.getCategoryId();
					String categoryName = "&nbsp;&nbsp;&nbsp;&nbsp; - " + rootCategory.getName();
					long assetCounter = AssetStatisticsUtil.countByCategory(groupId, categoryId);
				%>
							
					<tr class="results-row">
						<td class="first"></td>
						<td><%=categoryName %></td>
						<td><%=assetCounter %></td>
					</tr>
				<%
					buildCategoryTree(groupId, categoryId, 1, out);
				}
				%>
			<%
			}
			%>
		</table>
	</div>
	<%
		int indexEntry = 0;
	%>
</div>
