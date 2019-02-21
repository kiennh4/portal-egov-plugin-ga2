<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/vbpq_dynamic_menu/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="vbpq_settings_form" method="post" action="<%=configurationURL %>">
	<div class="portlet-config-form">
					
		<aui:input label="year-range" name="yearRange" value="<%=yearRange %>" >
			<aui:validator name="digits" />
			<aui:validator name="min">'0'</aui:validator>
		</aui:input>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
</aui:form>
		