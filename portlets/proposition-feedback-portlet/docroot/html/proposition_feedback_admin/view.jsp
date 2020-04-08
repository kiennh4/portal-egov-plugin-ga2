<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","Propositions");
	String tabNames = "Propositions,Feedbacks";
%>

<liferay-portlet:renderURL var="propositionAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=propositionAdminURL%>">
	<c:if test='<%=Validator.equals(tabs1, "Propositions") %>'>
	    <liferay-util:include page="/html/proposition_feedback_admin/proposition_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "Feedbacks") %>'>
	    <liferay-util:include page="/html/proposition_feedback_admin/feedback_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>
