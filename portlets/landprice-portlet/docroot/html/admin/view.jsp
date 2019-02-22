<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","LandPrice");
	String tabNames = "LandPrice,LandLocation";
%>

<liferay-portlet:renderURL var="landPriceAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=landPriceAdminURL.toString() %>">

	<c:if test='<%=tabs1.equals("LandPrice") %>'>
	    <liferay-util:include page="/html/admin/land_price/land_price.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
			
	<c:if test='<%=tabs1.equals("LandLocation") %>'>
	    <liferay-util:include page="/html/admin/land_location/land_location.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
</liferay-ui:tabs>

