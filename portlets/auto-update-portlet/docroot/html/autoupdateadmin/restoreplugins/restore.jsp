<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateRestore"%>
<%@include file = "/html/autoupdateadmin/restoreplugins/init.jsp" %>
<%
	String[] pluginCode = ParamUtil.getParameterValues(request, "pluginCode");

	for (String code : pluginCode)
	{
		response.getWriter().println(AutoUpdateRestore.isRestoredPlugin(code));
	}
%>