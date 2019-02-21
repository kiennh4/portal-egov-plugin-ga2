<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	int yearRange = 10;
	
	long selectedUserId = ParamUtil.getLong(request, "userId",0L);

	long selectedCategoryId = ParamUtil.getLong(request, "categoryId",0L);
	
	boolean statisticByTimeRange = ParamUtil.getBoolean(request, "statisticByTimeRange",false);
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date currentDate = calendar.getTime();

	int fromDay = ParamUtil.getInteger(request, "fromDay",currentDate.getDate());
	int fromMonth = ParamUtil.getInteger(request, "fromMonth",currentDate.getMonth());
	int fromYear = ParamUtil.getInteger(request, "fromYear",currentDate.getYear() + 1900);

	int endDay = ParamUtil.getInteger(request, "endDay",currentDate.getDate());
	int endMonth = ParamUtil.getInteger(request, "endMonth",currentDate.getMonth());
	int endYear = ParamUtil.getInteger(request, "endYear",currentDate.getYear() + 1900);
	
	List<User> companyUsers = UserLocalServiceUtil.getCompanyUsers(companyId, 0, -1);
	
	List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
%>
				
<liferay-portlet:renderURL var="statisticHomePageURL">
	<liferay-portlet:param name="jspPage" value="/html/view/view.jsp" />
</liferay-portlet:renderURL>
				
<liferay-portlet:renderURL var="statisticFormURL">
	<liferay-portlet:param name="jspPage" value="/html/view/statistic_form_results.jsp" />
</liferay-portlet:renderURL>

<div class="statistic-form">
	<aui:form name="fm" method="POST" action="<%=statisticFormURL %>">
			
		<aui:input type="checkbox" name="statisticByTimeRange" value="<%=statisticByTimeRange%>" />
						
		<div id="<portlet:namespace/>statisticTimeRangeWrapper">
			<div class="form-row">
				<div><liferay-ui:message key="statistic-from-date"/>:</div>
				
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />startDatePicker"></div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=fromDay %>" dayParam="fromDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=fromMonth %>" monthParam="fromMonth" 
						yearValue="<%=fromYear  %>" yearParam="fromYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
				/>
			</div>
			<div class="form-row">
				<span><liferay-ui:message key="statistic-to-date"/>:</span>
				
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />endDatePicker"></div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=endDay %>" dayParam="endDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=endMonth %>" monthParam="endMonth" 
						yearValue="<%=endYear%>" yearParam="endYear" 
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
			
			<aui:button type="submit" value="view-statistic"/>
			
			<aui:button value="back-to-home-page" href="<%=statisticHomePageURL %>"/>
		</div>
	</aui:form>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />statisticByTimeRangeCheckbox','<portlet:namespace/>statisticTimeRangeWrapper');
</aui:script>
