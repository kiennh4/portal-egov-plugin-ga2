<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<c:choose>
	<c:when test="<%=selectedMenuId > 0 %>">
		<c:if test='<%=Validator.equals(displayStyle,"style-1") %>'>
			<liferay-util:include page="/html/style/style-1.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
			
		<c:if test='<%=Validator.equals(displayStyle,"style-2") %>'>
			<liferay-util:include page="/html/style/style-2.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
	</c:when>
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>
