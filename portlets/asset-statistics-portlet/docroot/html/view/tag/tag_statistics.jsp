<%@page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetTag"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal_egov.portlet.asset_statistics.util.AssetStatisticsUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	int tagIndex = 0;
	
	long totalAssetCounter = AssetStatisticsUtil.countByGroup(groupId);

	List<AssetTag> assetTagList = AssetTagLocalServiceUtil.getGroupTags(groupId);
%>

<div class="statistics-wrapper">

	<liferay-util:include page="/html/view/statistic_form.jsp" servletContext="<%=this.getServletContext() %>"/>
		
	<div class="statistic-info">
		<span><liferay-ui:message key="total-tag"/>: <%=assetTagList.size() %></span>
		<br/>
		<span><liferay-ui:message key="total-asset"/>: <%=totalAssetCounter %></span>
	</div>
		
	<div class="statistic-details">
		<table class="taglib-search-iterator">
			<tr class="results-header">
				<th><liferay-ui:message key="STT"/></th>
				<th><liferay-ui:message key="tag-name"/></th>
				<th><liferay-ui:message key="asset-counter"/></th>
			</tr>
			
			<%
			for(AssetTag assetTag : assetTagList){
				
				tagIndex ++;
				
				long assetCounter = AssetStatisticsUtil.countByTag(groupId, assetTag.getTagId());
			%>
			
			<tr class="results-row">
				<td class="first"><%=tagIndex %></td>
				<td><%=assetTag.getName() %></td>
				<td><%=assetCounter %></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>		
<div class="statistics-wrapper">