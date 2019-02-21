<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.bkav.portal_egov.portlet.asset_statistics.util.AssetStatisticsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>


<%
	int indexEntry = 0;

	int vocabularyIndex = 0;
	
	long userId = ParamUtil.getLong(request, "userId");
	
	long categoryId = ParamUtil.getLong(request, "categoryId");
	
	boolean statisticByTimeRange = ParamUtil.getBoolean(request, "statisticByTimeRange",false);
	
	String fromDate = "";
	
	String endDate = "";	

	int fromDay = ParamUtil.getInteger(request, "fromDay",0);
	int fromMonth = ParamUtil.getInteger(request, "fromMonth",0);
	int fromYear = ParamUtil.getInteger(request, "fromYear",0);
	
	int endDay = ParamUtil.getInteger(request, "endDay",0);
	int endMonth = ParamUtil.getInteger(request, "endMonth",0);
	int endYear = ParamUtil.getInteger(request, "endYear",0);
	
	
	if(statisticByTimeRange){
		
		Date currentDate = CalendarFactoryUtil.getCalendar().getTime();
		
		SimpleDateFormat dateFormat_ = new SimpleDateFormat("yyyyMMdd");
		
		fromDate = dateFormat_.format(currentDate);
		endDate = dateFormat_.format(currentDate);

		
		
		if(fromDay > 0 && fromMonth > 0 && fromYear > 0){
			
			fromDate = dateFormat_.format(PortalUtil.getDate(fromMonth, fromDay, fromYear, themeDisplay.getTimeZone(), new PortalException()));
		}

		
		
		if(endDay > 0 && endMonth > 0 && endYear > 0){
			
			endDate = dateFormat_.format(PortalUtil.getDate(endMonth, endDay, endYear, themeDisplay.getTimeZone(), new PortalException()));
		}
	}

	int counter = AssetStatisticsUtil.getAssetCounter(groupId, categoryId, userId, fromDate, endDate);
	
	List<AssetVocabulary> vocabularyList = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
	
%>
<div class="statistics-wrapper">

	<liferay-util:include page="/html/view/statistic_form.jsp" servletContext="<%=this.getServletContext() %>"/>
	
	<div class="statistic-results">
		<c:choose>
			<c:when test="<%=userId > 0 && categoryId <=0 %>">
				<%
				User statisticUser = UserLocalServiceUtil.getUser(userId);
				%>
				
				<div class="statistic-info">
					<liferay-ui:message key="statistic-details-by-category-for-user"/>
					<span style="color: #bc0000;"> <%=statisticUser.getScreenName() %></span>
					<br/><br/>
					<span><liferay-ui:message key="total-asset"/>:</span>
					<span style="color: #bc0000;">  <%=counter %></span>
					<br/><br/>
					<span><liferay-ui:message key="statistics-detail"/></span>
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
								
								int assetCounter = AssetStatisticsUtil.getAssetCounter(groupId, rootCategory.getCategoryId(), userId, fromDate, endDate);
								
								if(assetCounter > 0){
								
									String categoryName = "&nbsp;&nbsp;&nbsp;&nbsp; - " + rootCategory.getName();
							%>
										
									<tr class="results-row">
										<td class="first"></td>
										<td><%=categoryName %></td>
										<td><%=assetCounter %></td>
									</tr>
							<%
									buildUserCategoryTree(groupId, rootCategory.getCategoryId(), userId, fromDate, endDate, 1, out);
								}
							}
							%>
						<%
						}
						%>
					</table>
				</div>
				
			</c:when>
			
			<c:when test="<%=userId <= 0 && categoryId > 0 %>">
				
				<%
				AssetCategory statisticCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
				
				String statisticCategoryName = "&nbsp;&nbsp;&nbsp;&nbsp; - " + statisticCategory.getName();
				
				AssetVocabulary statisticVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(statisticCategory.getVocabularyId());
				
				int categoryAssetCounter = AssetStatisticsUtil.getCategoryAssetCounter(groupId, categoryId, userId, fromDate, endDate);
				
				%>
								
				<div class="statistic-info">
					<liferay-ui:message key="statistic-details-for-category"/>
					<span style="color: #bc0000;"><%=statisticCategory.getName()%></span>
					<br/><br/>
					<span><liferay-ui:message key="total-asset"/>:</span>
					<span style="color: #bc0000;">  <%=counter %></span>
					<br/><br/>
					<span><liferay-ui:message key="statistics-detail"/></span>
				</div>
				
				<div class="statistic-details">
					<table class="taglib-search-iterator">
						<tr class="results-header">
							<th><liferay-ui:message key="category"/></th>
							<th><liferay-ui:message key="asset-counter"/></th>
						</tr>
												
						<tr class="results-row vocabulary-name">
							<td><%=statisticVocabulary.getName() %></td>
							<td></td>
						</tr>
																
						<tr class="results-row">
							<td><%=statisticCategoryName %></td>
							<td><%=categoryAssetCounter %></td>
						</tr>
						
						<%
						
						if(AssetCategoryLocalServiceUtil.getChildCategoriesCount(categoryId) > 0){
							
							buildSubCategoryTree(groupId, categoryId, userId, fromDate, endDate, 1, out);
						}
						%>
					</table>
				</div>
			</c:when>
			
			<c:when test="<%=userId > 0 && categoryId > 0 %>">
								
				<%
				AssetCategory statisticCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
				
				String statisticCategoryName = "&nbsp;&nbsp;&nbsp;&nbsp; - " + statisticCategory.getName();
				
				AssetVocabulary statisticVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(statisticCategory.getVocabularyId());
				
				int categoryAssetCounter = AssetStatisticsUtil.getCategoryAssetCounter(groupId, categoryId, userId, fromDate, endDate);
				
				%>
												
				<div class="statistic-info">
					<liferay-ui:message arguments="<%= new String[] {PortalUtil.getUserName(userId, StringPool.BLANK), statisticCategory.getName()} %>" 
										key="statistic-details-for-user-x-and-category-x" />
					<br/><br/>
					<span><liferay-ui:message key="total-asset"/>:</span>
					<span style="color: #bc0000;">  <%=counter %></span>
					<br/><br/>
					<span><liferay-ui:message key="statistics-detail"/></span>
				</div>
				
				<div class="statistic-details">
					<table class="taglib-search-iterator">
						<tr class="results-header">
							<th><liferay-ui:message key="category"/></th>
							<th><liferay-ui:message key="asset-counter"/></th>
						</tr>
												
						<tr class="results-row vocabulary-name">
							<td><%=statisticVocabulary.getName() %></td>
							<td></td>
						</tr>
																
						<tr class="results-row">
							<td><%=statisticCategoryName %></td>
							<td><%=categoryAssetCounter %></td>
						</tr>
						
						<%
						
						if(AssetCategoryLocalServiceUtil.getChildCategoriesCount(categoryId) > 0){
							
							buildSubCategoryTree(groupId, categoryId, userId, fromDate, endDate, 1, out);
						}
						%>
					</table>
				</div>
			</c:when>
			
			<c:otherwise>
									
				<div class="statistic-info">
					<span><liferay-ui:message key="total-asset"/>:</span>
					<span style="color: #bc0000;">  <%=counter %></span>
					<br/><br/>
					<span><liferay-ui:message key="statistics-detail"/></span>
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
								
								String categoryName = "&nbsp;&nbsp;&nbsp;&nbsp; - " + rootCategory.getName();
								long assetCounter = AssetStatisticsUtil.countByCategory(groupId, rootCategory.getCategoryId());
							%>
										
								<tr class="results-row">
									<td class="first"></td>
									<td><%=categoryName %></td>
									<td><%=assetCounter %></td>
								</tr>
							<%
								buildCategoryTree(groupId, rootCategory.getCategoryId(), 1, out);
							}
							%>
						<%
						}
						%>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%!
	protected void buildSubCategoryTree(long groupId,long parentCategoryId,long userId,String fromDate,String endDate,int treeLevel,JspWriter jspWriter){
		
		try{
			
			List<AssetCategory> subCategoryList = AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);
			
			if(subCategoryList.size() > 0){
				
				for(AssetCategory subCategory : subCategoryList){
					
					int assetCounter = AssetStatisticsUtil.getCategoryAssetCounter(groupId, subCategory.getCategoryId(), userId, fromDate, endDate);
					
					if(assetCounter > 0){
						
						String categoryNamePrefix = "";
						String counterPrefix = "";
						
						if(treeLevel > 0){
							
							for(int i = 0; i< treeLevel; i++){
								
								categoryNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
								counterPrefix += "&nbsp;&nbsp;&nbsp;&nbsp;";
							}
						}
						
						String categoryName = categoryNamePrefix + subCategory.getName();
						
						jspWriter.println("<tr class=\"results-row\" >");
						jspWriter.println("<td>" + categoryName + "</td>");
						jspWriter.println("<td>" + counterPrefix + assetCounter + "</td>");
						jspWriter.println("</tr>");
						
						int nextTreeLevel = treeLevel + 1;
						
						buildSubCategoryTree(groupId, subCategory.getCategoryId(), userId, fromDate, endDate, nextTreeLevel, jspWriter);
					}
				}
			}
		}catch(Exception e){
			
		}
	}
%>






















