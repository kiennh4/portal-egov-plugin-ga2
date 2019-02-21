<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","PropositionCategories");
	String tabNames = "PropositionCategories,CompilationDepartments,VerificationDepartments";
%>

<liferay-portlet:renderURL var="propositionCategoriesAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_category_admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=propositionCategoriesAdminURL%>">
	<c:if test='<%=Validator.equals(tabs1, "PropositionCategories") %>'>
	    <liferay-util:include page="/html/proposition_feedback_category_admin/proposition_category_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "CompilationDepartments") %>'>
	    <liferay-util:include page="/html/proposition_feedback_category_admin/compilation_department_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=Validator.equals(tabs1, "VerificationDepartments") %>'>
	    <liferay-util:include page="/html/proposition_feedback_category_admin/verification_department_admin.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>
