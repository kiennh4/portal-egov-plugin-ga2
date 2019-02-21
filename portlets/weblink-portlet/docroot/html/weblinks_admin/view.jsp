<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks_admin/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","Weblinks");
	String tabNames = "Weblinks,WeblinkCategories";
%>

<liferay-portlet:renderURL var="weblinkAdminHomePageURL" >
	<liferay-portlet:param name="jspPage" value="/html/weblinks_admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=weblinkAdminHomePageURL.toString() %>">

	<c:if test='<%=tabs1.equals("Weblinks") %>'>
	    <liferay-util:include page="/html/weblinks_admin/weblink/weblinks.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("WeblinkCategories") %>'>
	    <liferay-util:include page="/html/weblinks_admin/weblink_category/weblink_categories.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>