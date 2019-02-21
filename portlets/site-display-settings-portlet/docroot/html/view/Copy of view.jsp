<%@page import="com.liferay.portlet.documentlibrary.ImageSizeException"%>
<%@page import="com.liferay.portal.ImageTypeException"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	String siteName = "new-site";	

	Group group = GroupLocalServiceUtil.getGroup(groupId);
	
	if(group != null){
		
		siteName = group.getDescriptiveName(locale);
	}
	
	String[] formNavigatorCategoryNames = {"display-settings"};
	
	String[] formNavigatorSection = {"header","footer"};
	
	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitSettingForm();";
%>

<h3>layoutSetId = <%=layoutSetId %></h3>

<liferay-portlet:actionURL name="updateSiteSettings" var="updateSiteSettingsActionURL"/>

<div class="site-display-update-form">
	<liferay-ui:header title="<%=siteName %>" />
	
	<liferay-ui:error exception="<%= ImageTypeException.class %>" message="invalid-banner-image-file-type" />
	
	<liferay-ui:error exception="<%= ImageSizeException.class %>" message="please-enter-a-banner-with-a-valid-file-size-no-larger-than-x" />
	
	<aui:form enctype="multipart/form-data" method="post" name="fm" action="<%=updateSiteSettingsActionURL %>" onSubmit="<%=taglibOnSubmit %>">
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/view/sections/"
		/>
	</aui:form>
</div>

<aui:script use="aui-base,aui-loading-mask,aui-overlay-context-panel">
	Liferay.provide(
		window,
		'<portlet:namespace />submitSettingForm',
		function() {
			var A = AUI();
									
			var portletContainer = A.one('#portlet_site_display_settings_WAR_sitedisplaysettingsportlet');
			
			portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
			
			portletContainer.loadingmask.toggle();
			
			var footerContent = window.<portlet:namespace />footerContent.getHTML();
			
			var footerContentInput = A.one('#<portlet:namespace />footerContent');
			
			if(footerContentInput){
				footerContentInput.val(footerContent);
			}
			
			document.<portlet:namespace />fm.submit();
		}
	);
</aui:script>
