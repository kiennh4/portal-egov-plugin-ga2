<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","TTHCLevels");
	String tabNames = "TTHCLevels,TTHCDepartments,TTHCCategories,Audiences,ResultTypes";
%>

<liferay-portlet:renderURL var="tthcCategoryAdminPortletURL" >
	<liferay-portlet:param name="jspPage" value="/html/tthc_category_admin/tthc_category_admin.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=tthcCategoryAdminPortletURL%>">
				
	<c:if test='<%=tabs1.equals("TTHCLevels") %>'>
	    <liferay-util:include page="/html/tthc_category_admin/levels/levels.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("TTHCDepartments") %>'>
	    <liferay-util:include page="/html/tthc_category_admin/departments/departments.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("TTHCCategories") %>'>
	    <liferay-util:include page="/html/tthc_category_admin/categories/categories.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("Audiences") %>'>
		<liferay-util:include page="/html/tthc_category_admin/audiences/audiences.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("ResultTypes") %>'>
		<liferay-util:include page="/html/tthc_category_admin/result_types/result_types.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>	
</liferay-ui:tabs>