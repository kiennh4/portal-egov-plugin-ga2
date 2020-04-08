<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	PortletPreferences preferences = PortalUtil.getPreferences(request);

	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String fromEmailName = preferences.getValue("fromEmailName", "Admin");
	
	String fromEmailAddress = preferences.getValue("fromEmailAddress", "admin@portal-egov.com");
	
	String toEmailAddress = preferences.getValue("toEmailAddress", StringPool.BLANK);
	
	String emailSubject = preferences.getValue("emailSubject", "[Portal eGov]Thông báo có câu hỏi mới");
	
	boolean autoSendEmail = GetterUtil.getBoolean(preferences.getValue("autoSendEmail", "true"));
%>

<liferay-portlet:renderURL var="faqAdminRenderURL">
	<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp" />
</liferay-portlet:renderURL>
		
<liferay-portlet:actionURL name="updateFAQSettings" var="updateFAQSettingsActionURL">
	<liferay-portlet:param  name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:actionURL>

<div class="legal-faq-update-form">
	<aui:form name="faq_settings_form" method="post" action="<%=updateFAQSettingsActionURL %>">
		
		<aui:input type="checkbox" label="auto-send-email-to-administrator-when-receive-new-question?" name="autoSendEmail" value="<%=autoSendEmail%>"/>
		
		<div id="<portlet:namespace />emailSettingsWrapper" class="aui-helper-hidden">
		
			<aui:input label="from-email-name" name="fromEmailName" value="<%=fromEmailName %>"/>
			
			<aui:input label="from-email-address" name="fromEmailAddress" value="<%=fromEmailAddress %>"/>
		
			<aui:input label="to-email-address" name="toEmailAddress" value="<%=toEmailAddress %>"/>
			
			<aui:input label="email-subject" name="emailSubject" value="<%=emailSubject %>"/>
			
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			
			<aui:button value="cancel" href="<%=faqAdminRenderURL %>"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />autoSendEmailCheckbox','<portlet:namespace />emailSettingsWrapper');
</aui:script>
