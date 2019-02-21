<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/html/init.jsp"%>

<c:choose>
	<c:when test="<%=selectedValues.length <= 0 %>">
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>
	
		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-this-portlet-to-display-data" 
				onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:when>
	<c:otherwise>
		<c:if test='<%=Validator.equals(displayStyle,defaultDisplayStyle)%>'>				
			<liferay-util:include page="/html/view/view_style/default_style.jsp" servletContext="<%=getServletContext() %>"/>		
		</c:if>
			
		<c:if test='<%=Validator.equals(displayStyle,listTitleDisplayStyle)%>'>			
			<liferay-util:include page="/html/view/view_style/list_title_style.jsp" servletContext="<%=getServletContext() %>"/>		
		</c:if>
					
		<c:if test='<%=Validator.equals(displayStyle,sliderDisplayStyle)%>'>			
			<liferay-util:include page="/html/view/view_style/slider_style.jsp" servletContext="<%=getServletContext() %>"/>		
		</c:if>
	</c:otherwise>
</c:choose>
