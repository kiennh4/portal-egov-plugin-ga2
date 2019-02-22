<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	String threadDescription = "";

	CO_Thread coThread = null;
	
	if(threadId > 0){
		
		coThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
		
		if(coThread != null){
			threadDescription = coThread.getThreadDesc();
		}
	}
%>

	<h3><liferay-ui:message key="thread-information" /></h3>
				
	<aui:input type="text" name="threadName" label="co-thread-name" value='<%= coThread != null ? coThread.getThreadName() : "" %>' >
		<aui:validator name="required" />
	</aui:input>
		
	<aui:input type="textarea" name="departmentName" label="co-department-name" value='<%= coThread != null ? coThread.getDepartmentName() : ""%>'>
		<aui:validator name="required" />
	</aui:input>

	<h3><liferay-ui:message key="thread-description-content" /></h3>
		
	<liferay-ui:input-editor name="threadDescEditor" height="400" initMethod="initThreadDescEditor"/>
	
	<aui:input type="hidden" name="threadDesc"/>
		
	<aui:script>
		function <portlet:namespace />initThreadDescEditor() {
			return "<%= UnicodeFormatter.toString(threadDescription)%>";
		}
	</aui:script>
			
