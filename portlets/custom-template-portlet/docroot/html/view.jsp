<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalService"%>
<%@page import="com.liferay.portal.service.LayoutServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>
<!-- <link rel="stylesheet" href="/custom-template-portlet/css/bootstrap.min.css">
<script src="/custom-template-portlet/css/bootstrap.min.js"></script> -->
<%
	String styleViewPath = "/html/template/" + displayStyle.trim()
			+ "/view.jsp";

	String linkToLayoutUuid = GetterUtil.getString(preferences
			.getValue("portletSetupLinkToLayoutUuid", null));

	String linkToPage = "";

	if ((linkToLayoutUuid != null) && (!linkToLayoutUuid.equals(""))) {
		Layout layout = LayoutLocalServiceUtil
				.fetchLayoutByUuidAndGroupId(linkToLayoutUuid, groupId);
		
		if (layout != null) {
			linkToPage = layout.getFriendlyURL();
		}
	}
%>
<div class="custom-template">
	<c:choose>
	<c:when test='<%=Validator.isNotNull(displayStyle)%>'>
		<liferay-util:include page="<%=styleViewPath%>"
			servletContext="<%=this.getServletContext()%>" />
	</c:when>
	<c:otherwise>
		<%
			renderRequest.setAttribute(
							WebKeys.PORTLET_CONFIGURATOR_VISIBILITY,
							Boolean.FALSE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%=portletDisplay.getURLConfiguration()%>"
				label="please-config-this-portlet-to-display-assets"
				onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>
</div>

