<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<c:choose>
	<c:when test="<%=numbersOfVideoDisplay != 0 %>">
		<c:if test='<%=Validator.equals(displayStyle, "default-style") %>'>
			<liferay-util:include page="/html/view/display-style/default-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
			
		<c:if test='<%=Validator.equals(displayStyle, "gallery-style") %>'>
			<liferay-util:include page="/html/view/display-style/gallery-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
					
		<c:if test='<%=Validator.equals(displayStyle, "slider-style") %>'>
			<liferay-util:include page="/html/view/display-style/slider-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
		<c:if test='<%=Validator.equals(displayStyle, "abstract-style") %>'>
			<liferay-util:include page="/html/view/display-style/abstract-style.jsp" servletContext="<%=getServletContext() %>"/>
		</c:if>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>

