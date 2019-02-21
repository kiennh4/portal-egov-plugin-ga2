<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.visit_counter.util.VisitCounterUtil"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@include file="/html/init.jsp"%>

<%

	String visitorIp = com.liferay.portal.util.PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();
	
	String sessionIp = (String)session.getAttribute("visitorIp");

	if(Validator.isNull(sessionIp) || !Validator.equals(sessionIp, visitorIp)){
		
		session.setAttribute("visitorIp", visitorIp);
		
		VisitCounterUtil.updateCounter(companyId, groupId, userId, userName);
		
		long lastAccessPageId = themeDisplay.getPlid();
		
		VisitCounterUtil.updateCounterLog(companyId, groupId, userId, userName, visitorIp, lastAccessPageId);
	}

	int totalCounterValue = VisitCounterUtil.getTotalVisitCounter(groupId);
	
	int onlineVisitorCounterValue = VisitCounterUtil.getOnlineVisiterCounter();
	
	Date now = new Date();

	SimpleDateFormat df = new SimpleDateFormat("ddMMYYYY");
	
	VisitCounterUtil.updateCounterDayLog(companyId, groupId, df.format(now));

%>
<style>
	.visit-counter-content {
		margin: 0;
		padding: 0;
		font-weight: bold;
		color: #434343;
		text-shadow: 1px 1px white
	}
	
	.visit-counter-content .total-visit-counter {
		padding-bottom: 5px
	}
	
	.visit-counter-content .counter-value {
		color: #bc0000
	}
</style>
<c:choose>
	<c:when test='<%=displayStyle.equals("style-1")%>'>
		<div class="visit-counter-data-container-style-1">
			<div class = "visit-counter-content">
				<div class="total-visit-counter">
					<span><liferay-ui:message key="total-visit-counter"/>:</span>
					<span class="counter-value"><%=totalCounterValue %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="online-visitor-counter"/>:</span>
					<span class="counter-value"><%=onlineVisitorCounterValue %></span>
				</div>
			</div>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="visit-counter-data-container-style-2">
	
			<div class = "visit-counter-content">
			
<!-- 				<div class="total-visit-counter" style = "font-size:14px;"> -->
				<div class="total-visit-counter">
					<span><liferay-ui:message key="total-visit-counter"/>:</span>
					<span class="counter-value"><%=totalCounterValue %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="online-visitor-counter"/>:</span>
					<span class="counter-value"><%=onlineVisitorCounterValue %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="today-visitor-counter"/>:</span>
					<span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(1) %></span>
				</div>
				
				<div class="online-visitor-counter">
					<liferay-ui:message key="yesterday-visitor-counter"/>:</span>
					<span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(2) %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="thisweek-visitor-counter"/>:</span>
					<span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(3) %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="lastweek-visitor-counter"/>:</span>
					<span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(4) %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="thismonth-visitor-counter"/>:</span>
					<span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(5) %></span>
				</div>
				
				<div class="online-visitor-counter">
					<span><liferay-ui:message key="lastmonth-visitor-counter"/>:</span>
					<span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(6) %></span>
				</div>
				<%-- 
				<div class="online-visitor-counter">
					<table style = "width:100%">
						<tr>
							<td width = "70%"><span><liferay-ui:message key="today-visitor-counter"/>:</span></td>
							<td align = "center"><span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(1) %></span></td>
						</tr>
						<tr>
							<td width = "70%"><span><liferay-ui:message key="yesterday-visitor-counter"/>:</span></td>
							<td align = "center"><span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(2) %></span></td>
						</tr>
						<tr>
							<td width = "70%"><span><liferay-ui:message key="thisweek-visitor-counter"/>:</span></td>
							<td align = "center"><span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(3) %></span></td>
						</tr>
						<tr>
							<td width = "70%"><span><liferay-ui:message key="lastweek-visitor-counter"/>:</span></td>
							<td align = "center"><span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(4) %></span></td>
						</tr>
						<tr>
							<td width = "70%"><span><liferay-ui:message key="thismonth-visitor-counter"/>:</span></td>
							<td align = "center"><span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(5) %></span></td>
						</tr>
						<tr>
							<td width = "70%"><span><liferay-ui:message key="lastmonth-visitor-counter"/>:</span></td>
							<td align = "center"><span class="counter-value"><%=VisitCounterUtil.getVisitorCounterDay(6) %></span></td>
						</tr>
					</table>
				</div>
				--%>
			</div>
		</div>
	</c:otherwise>
</c:choose>
