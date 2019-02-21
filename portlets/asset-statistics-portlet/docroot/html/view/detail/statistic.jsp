<%@page import="java.util.Calendar"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
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
<%@include file="/html/view/init.jsp"%>
<%
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
	
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<liferay-portlet:renderURL var="statisticHomePageURL">
	<liferay-portlet:param name="jspPage" value="/html/view/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/view/detail/statistic.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL %>" method="post" name="searchForm">

	<liferay-portlet:renderURLParams varImpl="assetSearchURL" />
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="userId" value="<%=  String.valueOf(userId) %>" />
		<portlet:param name="categoryId" value="<%=  String.valueOf(categoryId) %>" />
		<portlet:param name="statisticByTimeRange" value="<%=  String.valueOf(statisticByTimeRange) %>" />
		<portlet:param name="fromDay" value="<%=  String.valueOf(fromDay) %>" />
		<portlet:param name="fromMonth" value="<%=  String.valueOf(fromMonth) %>" />
		<portlet:param name="fromYear" value="<%=  String.valueOf(fromYear) %>" />
		<portlet:param name="endDay" value="<%=  String.valueOf(endDay) %>" />
		<portlet:param name="endMonth" value="<%=  String.valueOf(endMonth) %>" />
		<portlet:param name="endYear" value="<%=  String.valueOf(endYear) %>" />
		<portlet:param name="mvcPath" value="/html/view/detail/statistic.jsp" />
	</liferay-portlet:renderURL>
	<liferay-ui:search-container
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="no-article"
		iteratorURL="<%= iteratorURL %>"
	>
	
	<%
	//long userId = ParamUtil.getLong(request, "userId");
	
	//long categoryId = ParamUtil.getLong(request, "categoryId");	

	//SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>

<%
	int yearRange = 10;
	
	long selectedUserId = ParamUtil.getLong(request, "userId",0L);

	long selectedCategoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	boolean statisticByTimeRange_ = ParamUtil.getBoolean(request, "statisticByTimeRange",false);
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date currentDate = calendar.getTime();

	int fromDay_ = ParamUtil.getInteger(request, "fromDay",currentDate.getDate());
	int fromMonth_ = ParamUtil.getInteger(request, "fromMonth",currentDate.getMonth());
	int fromYear_ = ParamUtil.getInteger(request, "fromYear",currentDate.getYear() + 1900);

	int endDay_ = ParamUtil.getInteger(request, "endDay",currentDate.getDate());
	int endMonth_ = ParamUtil.getInteger(request, "endMonth",currentDate.getMonth());
	int endYear_ = ParamUtil.getInteger(request, "endYear",currentDate.getYear() + 1900);
	
	List<User> companyUsers = UserLocalServiceUtil.getCompanyUsers(companyId, 0, -1);
	
	List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
%>

<aui:button value="back-to-home-page" href="<%=statisticHomePageURL %>"/>

<liferay-ui:search-toggle
	buttonLabel="Search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_student_search">
	
	<aui:input type="checkbox" name="statisticByTimeRange" value="<%=statisticByTimeRange_%>" />
						
		<div id="<portlet:namespace/>statisticTimeRangeWrapper">
			<div class="form-row">
				<div><liferay-ui:message key="statistic-from-date"/>:</div>
				
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />startDatePicker"></div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=fromDay_ %>" dayParam="fromDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=fromMonth_ %>" monthParam="fromMonth" 
						yearValue="<%=fromYear_  %>" yearParam="fromYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
				/>
			</div>
			<div class="form-row">
				<span><liferay-ui:message key="statistic-to-date"/>:</span>
				
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />endDatePicker"></div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=endDay_ %>" dayParam="endDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=endMonth_ %>" monthParam="endMonth" 
						yearValue="<%=endYear_%>" yearParam="endYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
				/>
			</div>
		</div>
		
		<div>
			<select name="userId" label="user">	
				<aui:option label="all-user" value="0" selected="<%=selectedUserId == 0L %>"/>
				
				<%
				for(User user : companyUsers){
				%>
				<aui:option label="<%=user.getFullName() %>" value="<%=user.getUserId() %>" selected="<%=selectedUserId == user.getUserId() %>"/>
				<%
				}
				%>
			</select>
			
			<select name="categoryId" label="category">
				<aui:option label="all-category" value="0" selected="<%=selectedCategoryId == 0L %>"/>
				<%
				for(AssetVocabulary vocabulary : vocabularies){
					
					List<AssetCategory> rootCategoryList = 
									AssetCategoryLocalServiceUtil.getVocabularyRootCategories(vocabulary.getVocabularyId(), 0, -1, null);
				%>
					<optgroup label="<%=vocabulary.getName()%>">
					<%
					for(AssetCategory rootCategory : rootCategoryList){
					%>
						<aui:option value="<%=rootCategory.getCategoryId()%>" label="<%=rootCategory.getName() %>"
							selected="<%=rootCategory.getCategoryId() == selectedCategoryId%>"
							
						/>
					<%
						buildCategoryTreeSelector(groupId, rootCategory.getCategoryId(),selectedCategoryId, 1, out);
					}
					%>
					</optgroup>
				<%
				}
				%>
			</select>
		</div>

	<aui:script>
		Liferay.Util.toggleBoxes('<portlet:namespace />statisticByTimeRangeCheckbox','<portlet:namespace/>statisticTimeRangeWrapper');
	</aui:script>
	
</liferay-ui:search-toggle>
	
	
<%-- 		<liferay-ui:search-form --%>
<%-- 			page="/html/view/assetentry_search.jsp" --%>
<%-- 			servletContext="<%= application %>" --%>
<%-- 		/> --%>
		
		
		
		<liferay-ui:search-container-results>
			<%
				//DisplayTerms displayTerms =searchContainer.getDisplayTerms();
				if (displayTerms.isAdvancedSearch()) {
						
				total = AssetStatisticsUtil.getAssetEntry(groupId, 
						categoryId, userId, String.valueOf(statisticByTimeRange),
						fromDay, fromMonth, fromYear,
						endDay, endMonth, endYear,
						themeDisplay).size();
				
// 				searchContainer.setTotal(total);
				
// 				searchContainer.setResults();
				
				pageContext.setAttribute("results", ListUtil.subList( AssetStatisticsUtil.getAssetEntry(groupId, 
						categoryId, userId, String.valueOf(statisticByTimeRange),
						fromDay, fromMonth, fromYear,
						endDay, endMonth, endYear,
						themeDisplay),searchContainer.getStart(), searchContainer.getEnd()));
				pageContext.setAttribute("total", total);
				
				}else {
					
				String searchkeywords = displayTerms.getKeywords();
			
				String numbesearchkeywords = Validator.isNumber(searchkeywords) ? searchkeywords : String.valueOf(0);
				
				total =AssetStatisticsUtil.getAssetEntry(groupId, 
						Long.parseLong(numbesearchkeywords), Long.parseLong(numbesearchkeywords), String.valueOf(statisticByTimeRange),
						Integer.parseInt(numbesearchkeywords), Integer.parseInt(numbesearchkeywords),Integer.parseInt(numbesearchkeywords),
						Integer.parseInt(numbesearchkeywords), Integer.parseInt(numbesearchkeywords),Integer.parseInt(numbesearchkeywords),
						themeDisplay).size();
			
// 				searchContainer.setResults(ListUtil.subList( AssetStatisticsUtil.getAssetEntry(groupId, Long.parseLong(numbesearchkeywords)
// 						,  Long.parseLong(numbesearchkeywords), null, null),searchContainer.getStart(), searchContainer.getEnd()));
				
				pageContext.setAttribute("results", ListUtil.subList(AssetStatisticsUtil.getAssetEntry(groupId, 
						Long.parseLong(numbesearchkeywords), Long.parseLong(numbesearchkeywords), String.valueOf(statisticByTimeRange),
						Integer.parseInt(numbesearchkeywords), Integer.parseInt(numbesearchkeywords),Integer.parseInt(numbesearchkeywords),
						Integer.parseInt(numbesearchkeywords), Integer.parseInt(numbesearchkeywords),Integer.parseInt(numbesearchkeywords),
						themeDisplay),searchContainer.getStart(), searchContainer.getEnd()));
				pageContext.setAttribute("total", total);
				}
					
			%>
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row
			className="com.liferay.portlet.asset.model.AssetEntry"
			keyProperty="entryId"
			modelVar="assetEntry">
			
<%-- 			<liferay-portlet:renderURL varImpl="rowURL" windowState="POP_UP"> --%>
<%-- 				<portlet:param name="backURL" value="<%= searchURL.toString() %>" /> --%>
<%-- 				<portlet:param name="mvcPath" value="/html/view/detail/view-content.jsp" /> --%>
<%-- 				<portlet:param name="redirect" value="<%= searchURL.toString() %>" /> --%>
<%-- 				<portlet:param name="companyId" value="<%= String.valueOf(companyId) %>" /> --%>
<%-- 				<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" /> --%>
<%-- 				<portlet:param name="objectId" value="<%= String.valueOf(assetEntry.getEntryId()) %>" /> --%>
<%-- 			</liferay-portlet:renderURL> --%>
			
			<%
			
				AssetRenderer assetRenderer = null;

				String title = "";
				
				String status = "";
				
				String publishDate = "";
				
				try {
					assetRenderer = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(JournalArticle.class.getName()).getAssetRenderer(assetEntry.getClassPK());
					title = assetRenderer.getTitle(PortalUtil.getLocale(request));
					
					JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
					
					status = LanguageUtil.get(pageContext, WorkflowConstants.toLabel(article.getStatus()));
					
					publishDate = dateFormat.format(article.getDisplayDate());
				}
				catch (Exception e) {
					
				}
				
				String rowURL = "javascript:;";
				
				rowURL = "javascript:"+ renderResponse.getNamespace() 
						+ "viewDetail('/html/view/detail/view-content.jsp'"
						+ ","+PortalUtil.getCompanyId(request)
						+ ","+groupId
						+ ","+assetEntry.getEntryId()
						+")";
				
			
			%>
			
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="title"
					value = "<%=title %>"
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="modified-date"
					value = "<%=StringUtil.valueOf(dateFormat.format(assetEntry.getModifiedDate()))%>"
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="publish-date"
					value="<%=publishDate%>"
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="author"
					value='<%=assetEntry.getUserName()%>'
				/>
				
				<liferay-ui:search-container-column-text
					href="<%=rowURL %>"
					name="status"
					value="<%=status %>"/>
					
						
		</liferay-ui:search-container-row>	
		
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
		
	</liferay-ui:search-container>

</aui:form>

<aui:script use="aui-dialog" >
AUI().ready('aui-base','liferay-portlet-url',function(A){
	Liferay.provide(
		window,
		'<portlet:namespace/>viewDetail',
		function(url, companyId, groupId, objectId){

			var viewDetailUrl = Liferay.PortletURL.createRenderURL();
										
			viewDetailUrl.setPortletId('asset_statistic_WAR_assetstatisticsportlet');
			viewDetailUrl.setWindowState('pop_up'); 
			viewDetailUrl.setParameter('jspPage', url);
			viewDetailUrl.setParameter('companyId', companyId);
			viewDetailUrl.setParameter('groupId',groupId);
			viewDetailUrl.setParameter('objectId',objectId);
			
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 800,
					height:700,
					draggable: true,
        			resizable: false,
					cache: false
				},
				title: '<liferay-ui:message key="detail" />',
				uri: viewDetailUrl
			};
			
			Liferay.Util.openWindow(dialogWidow);	
			
			//location.href = viewDetailUrl;			
			
		}
	);
});
	
</aui:script>
