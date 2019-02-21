<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/ykctadmin/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","ykct_entry");
	String tabNames = "ykct_entry,ykct_category";
%>

<liferay-portlet:renderURL var="ykctEntryAdminHomePageURL" >
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=ykctEntryAdminHomePageURL.toString() %>">

	<c:if test='<%=tabs1.equals("ykct_entry") %>'>
	    <liferay-util:include page="/html/ykctadmin/ykct_entry/view.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("ykct_category") %>'>
	    <liferay-util:include page="/html/ykctadmin/ykct_category/view.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
</liferay-ui:tabs>