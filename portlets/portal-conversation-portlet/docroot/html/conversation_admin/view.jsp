<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","COThreads");
	String tabNames = "COThreads,COConversations,COCategories";
%>

<liferay-portlet:renderURL var="conversationAdminTabURL" >
	<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=conversationAdminTabURL%>">
	<c:if test='<%=Validator.equals(tabs1, "COThreads") %>'>
	    <liferay-util:include page="/html/conversation_admin/co_thread/co_thread_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "COConversations") %>'>
	    <liferay-util:include page="/html/conversation_admin/co_conversation/co_conversation_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "COCategories") %>'>
	    <liferay-util:include page="/html/conversation_admin/co_category/co_category_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>
