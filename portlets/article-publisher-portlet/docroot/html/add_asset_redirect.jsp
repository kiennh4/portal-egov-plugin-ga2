<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>

<%@ include file="/html/init.jsp" %>

<%
	Portlet selPortlet = PortletLocalServiceUtil.getPortletById(PortalUtil.getCompanyId(request), portletDisplay.getId());
%>

<aui:script use="aui-base">
	Liferay.fire(
		'closeWindow',
		{
			id: '<%= renderResponse.getNamespace() %>',
			portletAjaxable: <%= selPortlet.isAjaxable() %>,
			refresh: '<%= portletDisplay.getId() %>'
		}
	);
</aui:script>