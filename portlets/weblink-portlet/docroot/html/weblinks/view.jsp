<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks/init.jsp"%>

<c:choose>
	<c:when test='<%=Validator.equals(displayStyle, multiTabsDisplayStyle) %>'>
		<liferay-util:include page="/html/weblinks/view_style/multi_tabs_style.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:when>
	
	<c:when test='<%=Validator.equals(displayStyle, listTitleDisplayStyle) %>'>
		<liferay-util:include page="/html/weblinks/view_style/weblink_list_style.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:when>
	
	<c:otherwise>
		<liferay-util:include page="/html/weblinks/view_style/default_style.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:otherwise>
</c:choose>
