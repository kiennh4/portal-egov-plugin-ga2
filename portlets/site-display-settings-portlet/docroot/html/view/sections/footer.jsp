<%@page import="com.bkav.portal.portlet.site_display_setting.util.SiteSettingUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	String footerContent = SiteSettingUtil.getFooterContent(layoutSetId);
	
	String taglibOnSubmit = "event.preventDefault(); _site_display_settings_WAR_sitedisplaysettingsportlet_submitFooterSettingForm();";
	
	String redirectURL = ParamUtil.getString(request, "redirectURL");
%>

<div class="section-content">
	<h3><liferay-ui:message key="footer"/></h3>
	
	<liferay-portlet:actionURL name="updateFooterContent" var="updateFooterContentActionURL" >
		<liferay-portlet:param name="redirectURL" value="<%=redirectURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form method="post" name="fm" action="<%=updateFooterContentActionURL %>" onSubmit="<%=taglibOnSubmit %>">
		
		<liferay-ui:input-editor name="footerContent" height="400" initMethod="initFooterContentEditor"/>
	
		<aui:input type="hidden" name="footerContent"/>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />initFooterContentEditor() {
		return "<%= UnicodeFormatter.toString(footerContent)%>";
	}
</aui:script>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />submitFooterSettingForm',
		function() {
			var A = AUI();
			
			var footerContent = window.<portlet:namespace />footerContent.getHTML();
			
			console.log(footerContent);
			
			var footerContentInput = A.one('#<portlet:namespace />footerContent');
			
			if(footerContentInput){
				footerContentInput.val(footerContent);
			}
			
			document.<portlet:namespace />fm.submit();
		}
	);
</aui:script>
