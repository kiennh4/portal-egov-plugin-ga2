<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","FAQEntries");
	String tabNames = "FAQEntries,FAQCategories,Settings";
%>

<liferay-portlet:renderURL var="legalFAQManagementURL" >
	<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=legalFAQManagementURL.toString() %>">

	<c:if test='<%=tabs1.equals("FAQEntries") %>'>
	    <liferay-util:include page="/html/legal_faq_management_portlet/faq_entry/faq_entry_management.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>

	<c:if test='<%=tabs1.equals("FAQCategories") %>'>
	    <liferay-util:include page="/html/legal_faq_management_portlet/faq_category/category_manegement.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>

	<c:if test='<%=tabs1.equals("Settings") %>'>
	    <liferay-util:include page="/html/legal_faq_management_portlet/settings.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>