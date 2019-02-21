<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandPriceLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandPrice"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	int statisticYear = ParamUtil.getInteger(request, "statisticYear",currentYear);

	long locationId = ParamUtil.getLong(request, "locationId");
	
	List<LandPrice> landPriceList = LandPriceLocalServiceUtil.findByKeyword(groupId, locationId, StringPool.BLANK, statisticYear, 0, -1, null);
%>

<c:choose>
	<c:when test="<%=landPriceList.size() > 0 %>">
	
	<liferay-portlet:renderURL var="landPriceViewURL" >
		<liferay-portlet:param name="locationId" value="<%=String.valueOf(locationId) %>"/>
	</liferay-portlet:renderURL>
	
	<span style="font-weight: bold;margin-right: 5px;"><liferay-ui:message key="statistic-year"/></span>
	
	<select name="statisticYear" 
				onChange="javascript:location.href = '<%= landPriceViewURL.toString() %>&<portlet:namespace/>statisticYear=' + this.value;">
		<aui:option label="<%=currentYear %>" value="<%=currentYear %>" selected="<%=statisticYear == currentYear %>"/>
		<aui:option label="<%=currentYear-1 %>" value="<%=currentYear-1 %>" selected="<%=statisticYear == currentYear-1 %>"/>
		<aui:option label="<%=currentYear-2 %>" value="<%=currentYear-2 %>" selected="<%=statisticYear == currentYear-2 %>"/>
		<aui:option label="<%=currentYear-3 %>" value="<%=currentYear-3 %>" selected="<%=statisticYear == currentYear-3 %>"/>
	</select>
	
	<%
	
		if(landPriceList.size() > 0){
			
			LandPrice firstPriceEntry = landPriceList.get(0);
			
			String priceTitle = StringUtil.shorten(firstPriceEntry.getTitle(), 80);
			
			String priceContent = firstPriceEntry.getContent();
			
			renderResponse.setTitle(priceTitle);
	%>	
		<div class="land-price-content">
			<span><%=priceContent %></span>
		</div>
	<%
		}
	%>
	</c:when>
	
	<c:otherwise>
		<div class="portlet-msg-info">
			<liferay-ui:message key="no-land-price-found"/>
		</div>
	</c:otherwise>
</c:choose>