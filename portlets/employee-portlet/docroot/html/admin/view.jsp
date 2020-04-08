<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","employee");
	String tabNames = "employee,post,dep,statistical";
%>

<liferay-portlet:renderURL var="adminHomePageURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=adminHomePageURL.toString() %>">

	<c:if test='<%=tabs1.equals("employee") %>'>
	    <liferay-util:include page="/html/admin/employee/employees.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("post") %>'>
	    <liferay-util:include page="/html/admin/post/posts.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=tabs1.equals("dep") %>'>
	    <liferay-util:include page="/html/admin/dep/deps.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=tabs1.equals("statistical") %>'>
	    <liferay-util:include page="/html/admin/statistical/statisticals.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>