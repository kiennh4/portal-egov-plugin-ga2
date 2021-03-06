<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="portletConfigActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div class="vungtau-viewport-portlet-config-form">
	<aui:form name="portletConfigForm" method="post" action="<%=portletConfigActionURL%>">
		
		<h3 class="config-title"><liferay-ui:message key="display-setting-viewport"/></h3>
		
		<div class="lfr-form-row">
			<liferay-ui:input-editor name="viewport" height="400" width="500" initMethod="initSloganContentEditor" toolbarSet="liferayArticle"/>
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	function <portlet:namespace />initSloganContentEditor() {
		return "<%= UnicodeFormatter.toString(viewport)%>";
	}
</aui:script>
