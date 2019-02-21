<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateConnector"%>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateAdminUtil"%>
<%@page import="com.bkav.portal.portlet.autoupdate.model.UpdatePlugins"%>


<%@include file = "/html/autoupdateadmin/init.jsp" %>

<%
	List<UpdatePlugins> listPlugins = AutoUpdateConnector.getAllAvailablePlugins("localhost:8086");
%>

<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","update-plugins");
	String tabNames = "update-plugins,restore-plugins,update-settings";
%>

<liferay-portlet:renderURL var="updateHomePageAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/autoupdateadmin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=updateHomePageAdminURL.toString() %>">

	<c:if test='<%=tabs1.equals("update-plugins") %>'>
	    <liferay-util:include page="/html/autoupdateadmin/updateplugins/view.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
	
	<c:if test='<%=tabs1.equals("restore-plugins") %>'>
	    <liferay-util:include page="/html/autoupdateadmin/restoreplugins/view.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("update-settings") %>'>
	    <liferay-util:include page="/html/autoupdateadmin/updatesettings/view.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>