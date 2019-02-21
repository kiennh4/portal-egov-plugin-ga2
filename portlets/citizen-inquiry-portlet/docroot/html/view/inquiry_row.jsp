<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<%@include file="/html/init.jsp"%>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	CitizenInquiry inquiry = (CitizenInquiry)row.getObject();
%>
	
<liferay-portlet:renderURL var="viewInquiryContentURL">
	<liferay-portlet:param name="jspPage" value="/html/view/inquiry_content.jsp"/>
	<liferay-portlet:param name="inquiryId" value="<%=String.valueOf(inquiry.getInquiryId()) %>"/>
</liferay-portlet:renderURL>

<div class="inquiry-entry">
	<div class="inquiry-title">
		<a href="<%=viewInquiryContentURL%>"><%=StringUtil.shorten(inquiry.getInquiryTitle(), 100) %></a>
	</div>
	
	<div class="inquiry-summary">
		<span><%=StringUtil.shorten(inquiry.getInquiryContent(), 300) %></span>
	</div>
	
	<div class="inquiry-info">
		<span><liferay-ui:message key="citizen-name"/>: &nbsp; <%=inquiry.getCitizenName() %></span>
		<br/>
		<span><liferay-ui:message key="inquiry-create-date"/>: &nbsp; <%=dateFormat.format(inquiry.getCreateDate()) %></span>
	</div>
</div>

<sc
