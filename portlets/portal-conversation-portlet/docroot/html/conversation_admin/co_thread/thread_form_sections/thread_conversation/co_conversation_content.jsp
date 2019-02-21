<%@page import="com.portal_egov.portlet.conversation.util.ConversationUtil"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">
	.co-conversation-content{
		font-size: 12px;
		color: #434343;
	}
	
	.co-conversation-content table{
		padding: 0px;
		margin: 0px;
		border-collapse: collapse;
	}
		
	.co-conversation-content table tr{
		border-bottom: 1px dotted #d2d2d2;
		height: 35px;
	}
				
	.co-conversation-content table tr td{
		padding-left: 10px;
	}
			
	.co-conversation-content table tr td:first-child{
		min-width: 120px;
		padding-left: 0px;
		color: #bc0000;
	}
</style>

<%@include file="/html/init.jsp"%>

<%

	long conversationId = ParamUtil.getLong(request, "conversationId",0L);
	
	CO_Conversation conversation = null;
	
	if(conversationId > 0L){
		
		conversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
	}
%>

<c:choose>
	<c:when test="<%=conversation != null %>">
		<%
		String conversationStatus = ConversationUtil.getConversationStatusTitle(conversationId);
		%>
		<div class="co-conversation-content">
			<table>
				<tr>
					<td><liferay-ui:message key="id"/></td>
					<td><%=conversationId %></td>
				</tr>
															
				<tr>
					<td><liferay-ui:message key="ask-user-name"/></td>
					<td><%=conversation.getAskUserName() %></td>
				</tr>
																			
				<tr>
					<td><liferay-ui:message key="conversation-ask-date"/></td>
					<td><%=dateTimeFormat.format(conversation.getAskDate()) %></td>
				</tr>
							
				<tr>
					<td><liferay-ui:message key="title"/></td>
					<td><%=conversation.getTitle() %></td>
				</tr>
															
				<tr>
					<td><liferay-ui:message key="ask-content"/></td>
					<td><%=conversation.getAskContent() %></td>
				</tr>
																			
				<tr>
					<td><liferay-ui:message key="answer-content"/></td>
					<td><%=conversation.getAnswerContent() %></td>
				</tr>
																							
				<tr>
					<td><liferay-ui:message key="answer-user-name"/></td>
					<td><%=conversation.getAnswerUserName() %></td>
				</tr>
																											
				<tr>
					<td><liferay-ui:message key="answer-date"/></td>
					<td><%=dateTimeFormat.format(conversation.getAnswerDate()) %></td>
				</tr>
																															
				<tr>
					<td><liferay-ui:message key="status"/></td>
					<td><liferay-ui:message key="<%=conversationStatus %>"/></td>
				</tr>
			</table>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="portlet-msg-info">
			<liferay-ui:message key="no-conversation-exist-with-primary-key"/>
			&nbsp;<%=conversationId %>
		</div>
	</c:otherwise>
</c:choose>

				

			
