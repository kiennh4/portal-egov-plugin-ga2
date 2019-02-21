<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.bkav.portal.portlet.site_display_setting.util.SiteSettingUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>
<%
	String sloganContent = SiteSettingUtil.getSloganContent(layoutSetId);
	
	String taglibOnSubmit = "event.preventDefault(); _site_display_settings_WAR_sitedisplaysettingsportlet_submitSloganSettingForm();";
	
	String redirectURL = ParamUtil.getString(request, "redirectURL");
%>

<div class="section-content">
	<h3><liferay-ui:message key="slogan"/></h3>
	
	<liferay-portlet:actionURL name="updateSloganContent" var="updateSloganContentActionURL" >
		<liferay-portlet:param name="redirectURL" value="<%=redirectURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form method="post" name="fm" action="<%=updateSloganContentActionURL %>" onSubmit="<%=taglibOnSubmit %>">
		
		<liferay-ui:input-editor name="sloganContent" height="400" initMethod="initSloganContentEditor"/>
	
		<aui:input type="hidden" name="sloganContent"/>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />initSloganContentEditor() {
		return "<%= UnicodeFormatter.toString(sloganContent)%>";
	}
</aui:script>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />submitSloganSettingForm',
		function() {
			var A = AUI();
			
			var sloganContent = window.<portlet:namespace />sloganContent.getHTML();
			
			console.log(sloganContent);
			
			var sloganContentInput = A.one('#<portlet:namespace />sloganContent');
			
			if(sloganContentInput){
				sloganContentInput.val(sloganContent);
			}
			
			document.<portlet:namespace />fm.submit();
		}
	);
</aui:script>
