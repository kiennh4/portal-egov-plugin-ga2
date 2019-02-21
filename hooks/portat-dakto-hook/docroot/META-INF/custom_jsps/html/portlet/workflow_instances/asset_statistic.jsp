<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@ include file="/html/portlet/workflow_instances/init.jsp" %>

<style type="text/css">
	.statistic-form .form-label{
		float: left;
		color: #757575;
		font-weight: bold;
		margin-top: 5px;
		margin-right: 5px;
	}
	
	.statistic-form select{
		color: #757575;
		border-radius: 0px;
		padding: 4px 0px;
	}
		
	.statistic-form input{
		color: #757575;
	}
	
	.statistic-results{
		color: #757575;
		font-weight: bold;
		padding-top: 30px;
	}
		
	.statistic-results .result-header{
		margin-bottom: 0px !important;
	}
	
	.statistic-results .result-row{
		padding: 10px 0px;
		border-bottom: 1px solid #d2d2d2;
	}
			
	.statistic-results .result-row .total-value{
		color: #ff5800;
	}
	
</style>

<%
	int yearRange = 10;
	
	long userId = PortalUtil.getUserId(request);

	long groupId = PortalUtil.getScopeGroupId(request);

	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date currentDate = calendar.getTime();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
	Date fromDate = calendar.getTime();
	Date endDate = calendar.getTime();
	
	int fromDay = ParamUtil.getInteger(request, "fromDay",1);
	int fromMonth = ParamUtil.getInteger(request, "fromMonth",currentDate.getMonth());
	int fromYear = ParamUtil.getInteger(request, "fromYear",currentDate.getYear() + 1900);
	
	if(fromDay > 0 && fromMonth >= 0 && fromYear > 0){
		
		fromDate = PortalUtil.getDate(fromMonth, fromDay, fromYear, themeDisplay.getTimeZone(), new PortalException());
	}
	
	int endDay = ParamUtil.getInteger(request, "endDay",currentDate.getDate());
	int endMonth = ParamUtil.getInteger(request, "endMonth",currentDate.getMonth());
	int endYear = ParamUtil.getInteger(request, "endYear",currentDate.getYear() + 1900);
	
	if(endDay > 0 && endMonth >= 0 && endYear > 0){
		
		endDate = PortalUtil.getDate(endMonth, endDay, endYear, themeDisplay.getTimeZone(), new PortalException());
	}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	
	portletURL.setParameter("tabs1", "submissions");
	portletURL.setParameter("tabs2", "asset-statistic");
%>

<div class="statistic-form">
	<aui:form name="fm" method="post" action="<%=portletURL %>">
		<span class="form-label"><liferay-ui:message key="statistic-from-date"/></span>
		
		<liferay-ui:input-date
				disabled="<%= false %>"
				dayValue="<%=fromDay %>" dayParam="fromDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
				monthValue="<%=fromMonth %>" monthParam="fromMonth" 
				yearValue="<%=fromYear  %>" yearParam="fromYear" 
				yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
				yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
		/>
		
		<div class="aui-datepicker" id="<portlet:namespace />startDatePicker"></div>
		
		<span class="form-label"><liferay-ui:message key="statistic-to-date"/></span>
		
		<liferay-ui:input-date
				disabled="<%= false %>"
				dayValue="<%=endDay %>" dayParam="endDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
				monthValue="<%=endMonth %>" monthParam="endMonth" 
				yearValue="<%=endYear%>" yearParam="endYear" 
				yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
				yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
		/>
		
		<div class="aui-datepicker" id="<portlet:namespace />endDatePicker"></div>
		
		<aui:button type="submit" value="view-statistic"/>
	</aui:form>
</div>

<div style="clear: both;"></div>

<div class="statistic-results">
	<div class="result-header lfr-message-info">
		<liferay-ui:message arguments="<%= PortalUtil.getUserName(userId, StringPool.BLANK) %>" 
							key="asset-statistic-result-for-user-x" />
	</div>	
	
	<div class="result-detail">
	
		<div class="result-row">
			<liferay-ui:message key="total-published-assets"/>
			<span class="total-value"><%=_getCounterValue(groupId, userId, fromDate, endDate, 0) %></span>
		</div>
			
		<div class="result-row">
			<liferay-ui:message key="total-pending-assets"/>
			<span class="total-value"><%=_getCounterValue(groupId, userId, fromDate, endDate, 1) %></span>
		</div>
	</div>
</div>

<%!

protected static long _getCounterValue(long groupId,long userId,Date fromDate,Date endDate,int status){
	
	try {
		
		ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticle.class,classLoader);
		
		Criterion groupIdCriterion = RestrictionsFactoryUtil.eq("groupId", groupId);
		
		Criterion userIdCriterion = RestrictionsFactoryUtil.eq("userId", userId);
		
		Criterion statusCriterion = RestrictionsFactoryUtil.eq("status", status);
		
		Criterion createDateCriterion = RestrictionsFactoryUtil.between("createDate", fromDate, endDate);
		
		Criterion queryCriterion = RestrictionsFactoryUtil.and(groupIdCriterion, userIdCriterion);
		
		queryCriterion = RestrictionsFactoryUtil.and(queryCriterion,
			RestrictionsFactoryUtil.and(statusCriterion, createDateCriterion));
		
		dynamicQuery.add(queryCriterion);
		
		return JournalArticleLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	}
	catch (Exception e) {
		_log.error(e);
		return 0;
	}
}
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.workflow_instances.asset_statistic_jsp");
%>