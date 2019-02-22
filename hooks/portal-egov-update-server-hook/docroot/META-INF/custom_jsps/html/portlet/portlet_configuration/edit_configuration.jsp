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

<%@ include file="/html/portlet/portlet_configuration/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
String returnToFullPageURL = ParamUtil.getString(request, "returnToFullPageURL");

String path = (String)request.getAttribute(WebKeys.CONFIGURATION_ACTION_PATH);
%>

<c:if test="<%= !layout.isTypeControlPanel() && !windowState.equals(LiferayWindowState.EXCLUSIVE) %>">
	<liferay-util:include page="/html/portlet/portlet_configuration/tabs1.jsp">
		<liferay-util:param name="tabs1" value="setup" />
	</liferay-util:include>
</c:if>

<%--
	@HungDX 08/05/2014
	Hide Portlet Import/Export wizard
 --%>

<c:if test="<%= Validator.isNotNull(portletResource) && Validator.isNotNull(path) %>">
	<liferay-util:include page="<%= path %>" portletId="<%= portletResource %>" />
</c:if>