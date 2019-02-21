<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	Portlet selPortlet = PortletLocalServiceUtil.getPortletById(companyId, portletId);
%>

<aui:script use="aui-base">
	Liferay.fire(
		'closeWindow',
		{
			id: '<portlet:namespace/>cityMapDialog',
			portletAjaxable: <%= selPortlet.isAjaxable() %>,
			refresh: '<%=portletId %>'
		}
	);
</aui:script>

