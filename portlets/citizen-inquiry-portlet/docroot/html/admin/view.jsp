<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","Inquiries");
	String tabNames = "Inquiries,Categories";
%>

<liferay-portlet:renderURL var="inquiryAdminHomePageURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=inquiryAdminHomePageURL %>">
	<c:if test='<%=tabs1.equals("Inquiries") %>'>
	    <liferay-util:include page="/html/admin/inquiry/inquiries.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("Categories") %>'>
	    <liferay-util:include page="/html/admin/inquiry_category/inquiry_categories.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>