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
	String  tabs1 = ParamUtil.getString(request,"tabs1","Departments");
	String tabNames = "Departments,Categories,DocumentTypes";
%>

<liferay-portlet:renderURL var="vbpqCategoryAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/vbpq_category_admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=vbpqCategoryAdminURL.toString() %>">

	<c:if test='<%=tabs1.equals("Departments") %>'>
	    <liferay-util:include page="/html/vbpq_category_admin/admin_tab/vbpq_departments.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("Categories") %>'>
	    <liferay-util:include page="/html/vbpq_category_admin/admin_tab/vbpq_categories.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("DocumentTypes") %>'>
		<liferay-util:include page="/html/vbpq_category_admin/admin_tab/vbpq_doctypes.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>
