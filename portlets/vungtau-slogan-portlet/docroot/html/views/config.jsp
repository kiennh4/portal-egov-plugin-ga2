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

<%
	
	String taglibOnSubmit = "event.preventDefault(); _vungtauslogan_WAR_vungtausloganportlet_submitSloganSettingForm();";
	
	String redirectURL = ParamUtil.getString(request, "redirectURL");
%>


<liferay-portlet:actionURL portletConfiguration="true" var="portletConfigActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<div class="vungtau-contact-portlet-config-form">
	<aui:form name="portletConfigForm" method="post" action="<%=portletConfigActionURL%>">
		
		<h3 class="config-title"><liferay-ui:message key="display-setting"/></h3>
		
		<div class="lfr-form-row">
			<liferay-ui:input-editor name="slogan" height="400" initMethod="initSloganContentEditor"/>
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="cancelBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>
<aui:script>
	function <portlet:namespace />initSloganContentEditor() {
		return "<%= UnicodeFormatter.toString(slogan)%>";
	}
</aui:script>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />submitSloganSettingForm',
		function() {
			var A = AUI();
			
			var sloganContent = window.<portlet:namespace />slogan.getHTML();
			
			console.log(sloganContent);
			
	
			
			document.<portlet:namespace />fm.submit();
		}
	);
</aui:script>