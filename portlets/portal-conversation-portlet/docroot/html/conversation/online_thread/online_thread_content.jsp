<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="/portal-conversation-portlet/js/service.js" ></script>

<script type="text/javascript" src="/portal-conversation-portlet/js/thread_conversation_loader.js" ></script>

<%@include file="/html/init.jsp"%>

<%
	CO_Thread onlineThread = null;
	
	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	if(threadId > 0){
		onlineThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
	}
%>

<c:choose>
	<c:when test='<%=Validator.isNotNull(onlineThread) %>'>
	
	<%
	
		List<CO_Conversation> publishThreadConversationList = CO_ConversationLocalServiceUtil.findByThreadAndGroupAndStatus(threadId,
																		scopeGroupId, CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE);
	%>
	
		<div class ="conversation-thread-content" >
			
			<liferay-portlet:renderURL var="conversationThreadHomePageURL">
				<liferay-portlet:param name="jspPage" value="/html/conversation/view.jsp" />
			</liferay-portlet:renderURL>
		
			<liferay-ui:header title="<%= onlineThread.getThreadName() %>" backURL="<%=conversationThreadHomePageURL%>" />
			
			<liferay-ui:success key="send-question-success" message="send-success-thankyou-for-your-question"/>
			
			<liferay-ui:error key="send-question-error" message="ERROR"/>
			
			<div class="thread-metadata">
				<table>
					<tr>
						<td><liferay-ui:message key="co-department-name"/></td>
						<td>:&nbsp;<%=onlineThread.getDepartmentName()  %></td>
					</tr>
					
					<c:if test="<%=Validator.isNotNull(onlineThread.getParticipants()) %>">
						<tr>
							<td><liferay-ui:message key="co-thread-participants"/></td>
							<td>:&nbsp;<%=onlineThread.getParticipants()  %></td>
						</tr>
					</c:if>
					
					<tr>
						<td><liferay-ui:message key="co-thread-start-date"/></td>
						<td>:&nbsp;<%=dateTimeFormat.format(onlineThread.getStartDate()) %></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="co-thread-end-date"/></td>
						<td>:&nbsp;<%=dateTimeFormat.format(onlineThread.getEndDate()) %></td>
					</tr>
				</table>
			</div>
						
			<div class="thread-content">
				<span><%=onlineThread.getThreadDesc() %></span>
			</div>
			
			<!-- Container chua danh sach cau hoi va cau tra loi -->
			<div id='<portlet:namespace/>threadConversationContainer' class="thread-conversation-container"></div>
			
			<div class="loading-message"><liferay-ui:message key="loading-conversation"/></div>
			
			<div id='<portlet:namespace/>loadingAnimationContainer'></div>
					
			<div class="conversation-control-row" >
				<span class="back-to-top">
					<a href="#"><liferay-ui:message key="back-to-top"/></a>
				</span>
				|
				<span class="give-ask">
					<a id='<portlet:namespace/>giveAskBtn' href="javascript:;"><liferay-ui:message key="send-question"/></a>
				</span>
			</div>
			
			<div style="clear: both;"></div>
		</div>
	</c:when>
	
	<c:otherwise>
		<liferay-ui:message key="your-selected-resource-is-not-exist"/>
	</c:otherwise>
</c:choose>

<liferay-portlet:renderURL var="giveAskFormRenderURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/conversation/give_ask_form.jsp"/>
	<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>"/>
	<liferay-portlet:param name="threadType" value="onlineThread"/>
</liferay-portlet:renderURL>


<aui:script use="portal-egov-thread-conversation-loader">
	
	new Liferay.Portlet.ConversationLoader(
		{
			portletId: '<%= portletId %>',
			scopeGroupId: <%= scopeGroupId %>,
			threadId: <%= threadId %>,
			container: '<portlet:namespace/>threadConversationContainer',
			loadingContainer: '<portlet:namespace/>loadingAnimationContainer'
		}
	);
</aui:script>
