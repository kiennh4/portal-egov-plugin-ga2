<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long conversationId = ParamUtil.getLong(request, "conversationId",0L);
	
	String answerContent = "";

	CO_Conversation conversation = null;

	if(conversationId > 0){
		
		conversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
		
		if(conversation != null){
			
			answerContent = conversation.getAnswerContent();
		}
	}
%>

	<h3><liferay-ui:message key="answer-content" /></h3>
	
	<aui:input type="text" name="answerUserName" value='<%= conversation != null ? conversation.getAnswerUserName() : ""%>'/>

	<div class="co-conversation-update-form-row">
		<span style="display: block;"><liferay-ui:message key="conversation-answer-content"/>(*)</span>
		
		<liferay-ui:input-editor width="60%" height="60%" name="answerContentEditor" initMethod="initAnswerContentEditor"/>
		
		<aui:input type="hidden" name="answerContent"/>
	</div>
		
	<aui:script>
		function <portlet:namespace />initAnswerContentEditor() {
			return "<%= UnicodeFormatter.toString(answerContent)%>";
		}
	</aui:script>
			
