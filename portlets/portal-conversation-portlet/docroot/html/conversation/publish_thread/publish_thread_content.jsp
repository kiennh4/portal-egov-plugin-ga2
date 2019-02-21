<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	CO_Thread publishThread = null;
	
	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	if(threadId > 0){
		publishThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
	}
	
	List<CO_Conversation> publishConversationList = CO_ConversationLocalServiceUtil.findByThreadAndCompanyAndStatus(threadId,
														companyId, CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE);
%>

<c:choose>
	<c:when test='<%=Validator.isNotNull(publishThread) %>'>
	
		<div class ="conversation-thread-content" >
			
			<liferay-portlet:renderURL var="conversationThreadHomePageURL">
				<liferay-portlet:param name="jspPage" value="/html/conversation/view.jsp" />
			</liferay-portlet:renderURL>
		
			<liferay-ui:header title="<%= publishThread.getThreadName() %>" backURL="<%=conversationThreadHomePageURL%>" />
			
			
			
			<div class="thread-metadata">
				<table>
					<tr>
						<td><liferay-ui:message key="co-department-name"/></td>
						<td>:&nbsp;<%=publishThread.getDepartmentName()  %></td>
					</tr>
					
					<c:if test="<%=Validator.isNotNull(publishThread.getParticipants()) %>">
						<tr>
							<td><liferay-ui:message key="co-thread-participants"/></td>
							<td>:&nbsp;<%=publishThread.getParticipants()  %></td>
						</tr>
					</c:if>
					
					<tr>
						<td><liferay-ui:message key="co-thread-start-date"/></td>
						<td>:&nbsp;<%=dateTimeFormat.format(publishThread.getStartDate()) %></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="co-thread-end-date"/></td>
						<td>:&nbsp;<%=dateTimeFormat.format(publishThread.getEndDate()) %></td>
					</tr>
				</table>
			</div>
			
			<div class="thread-content">
				<span><%=publishThread.getThreadDesc() %></span>
			</div>
			
			<div class="thread-conversation-container">
				<%
					for(CO_Conversation publishConversation : publishConversationList){
				%>
					<div class="conversation-entry">
						<div class="conversation-title">
							<a href="javascript:;"><%=publishConversation.getTitle() %></a>
						</div>
						
						<div class="conversation-ask-content">
							<span><%=publishConversation.getAskContent() %></span>
						</div>
						
						<div class="conversation-ask-user-info">
							<span><%=publishConversation.getAskUserName() %></span>
							<span><%=publishConversation.getAskUserInfo() %></span>
						</div>
						
						<div class="conversation-answer-content">
							<span><%=publishConversation.getAnswerContent() %></span>
						</div>
					</div>
				<%
					}//End for(CO_Conversation publishConversation : publishConversationList)
				%>
			</div>
		</div>
		
				
		<div class="conversation-control-row" >
			<span class="back-to-top">
				<a href="#"><liferay-ui:message key="back-to-top"/></a>
			</span>
		</div>
		
		<div style="clear: both;"></div>
		
	</c:when>
	
	<c:otherwise>
		<liferay-ui:message key="your-selected-resource-is-not-exist"/>
	</c:otherwise>
</c:choose>
