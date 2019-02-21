<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal_egov.portlet.asset_statistics.util.AssetStatisticsUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	int userIndex = 0;
	
	long totalAssetCounter = AssetStatisticsUtil.countByGroup(groupId);

	List<User> userList = UserLocalServiceUtil.getGroupUsers(groupId);
%>

<div class="statistics-wrapper">

	<liferay-util:include page="/html/view/statistic_form.jsp" servletContext="<%=this.getServletContext() %>"/>
		
	<div class="statistic-info">
		<span><liferay-ui:message key="total-user"/>: <%=userList.size() %></span>
		<br/>
		<span><liferay-ui:message key="total-asset"/>: <%=totalAssetCounter %></span>
	</div>
		
	<div class="statistic-details">
		<table class="taglib-search-iterator">
			<tr class="results-header">
				<th><liferay-ui:message key="STT"/></th>
				<th><liferay-ui:message key="user-name"/></th>
				<th><liferay-ui:message key="full-name"/></th>
				<th><liferay-ui:message key="user-email"/></th>
				<th><liferay-ui:message key="asset-counter"/></th>
			</tr>
			
			<%
			for(User user : userList){
				
				userIndex ++;
				
				long assetCounter = AssetStatisticsUtil.getAssetCounter(groupId, 0, user.getUserId(), StringPool.BLANK, StringPool.BLANK);
			%>
			
			<tr class="results-row">
				<td class="first"><%=userIndex %></td>
				<td><%=user.getScreenName() %></td>
				<td><%=user.getFullName() %></td>
				<td><%=user.getEmailAddress() %></td>
				<td><%=assetCounter %></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>		
<div class="statistics-wrapper">