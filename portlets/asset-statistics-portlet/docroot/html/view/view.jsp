<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>


<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","statistic-by-category");
	String tabNames = "statistic-by-category,statistic-by-tag,statistic-by-user,statistic-detail";
%>

<liferay-portlet:renderURL var="statisticAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/view/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=statisticAdminURL.toString() %>">
	<c:if test='<%=tabs1.equals("statistic-by-category") %>'>
	    <liferay-util:include page="/html/view/category/category_statistics.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("statistic-by-tag") %>'>
	    <liferay-util:include page="/html/view/tag/tag_statistics.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("statistic-by-user") %>'>
	    <liferay-util:include page="/html/view/user/user_statistics.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=tabs1.equals("statistic-detail") %>'>
	    <liferay-util:include page="/html/view/detail/statistic.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>

