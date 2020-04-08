<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String styleViewPath = "/html/style/" + displayStyle.trim() + "/view.jsp";
%>

<aui:form name="fm">
	<div class="lfr-meta-actions" style="padding: 0px;">
		<%@ include file="/html/add_asset.jspf" %>
	</div>
</aui:form>

<c:choose>
	<c:when test='<%=Validator.isNotNull(displayStyle) %>'>
		<liferay-util:include page="<%=styleViewPath %>" servletContext="<%=this.getServletContext() %>"/>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-config-this-portlet-to-display-assets" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>
