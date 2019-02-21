<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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
	CO_Thread openThread = null;
	
	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	if(threadId > 0){
		openThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
	}
%>

<c:choose>
	<c:when test='<%=Validator.isNotNull(openThread) %>'>
	
		<div class ="conversation-thread-content" >
	
			<liferay-portlet:renderURL var="conversationThreadHomePageURL">
				<liferay-portlet:param name="jspPage" value="/html/conversation/view.jsp" />
			</liferay-portlet:renderURL>
		
			<liferay-ui:header title="<%= openThread.getThreadName() %>" backURL="<%=conversationThreadHomePageURL%>" />
			
			<liferay-ui:success key="send-question-success" message="send-success-thankyou-for-your-question"/>
			
			<liferay-ui:error key="send-question-error" message="ERROR"/>
			
			<div class="thread-metadata">
				<table>
					<tr>
						<td><liferay-ui:message key="co-department-name"/></td>
						<td>:&nbsp;<%=openThread.getDepartmentName()  %></td>
					</tr>
					
					<c:if test="<%=Validator.isNotNull(openThread.getParticipants()) %>">
						<tr>
							<td><liferay-ui:message key="co-thread-participants"/></td>
							<td>:&nbsp;<%=openThread.getParticipants()  %></td>
						</tr>
					</c:if>
					
					<tr>
						<td><liferay-ui:message key="co-thread-start-date"/></td>
						<td>:&nbsp;<%=dateTimeFormat.format(openThread.getStartDate()) %></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="co-thread-end-date"/></td>
						<td>:&nbsp;<%=dateTimeFormat.format(openThread.getEndDate()) %></td>
					</tr>
				</table>
			</div>
			
			<div class="thread-content">
				<span><%=openThread.getThreadDesc() %></span>
			</div>
		</div>
		
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
	</c:when>
	
	<c:otherwise>
		<liferay-ui:message key="your-selected-resource-is-not-exist"/>
	</c:otherwise>
</c:choose>

<liferay-portlet:renderURL var="giveAskFormRenderURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/conversation/give_ask_form.jsp"/>
	<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>"/>
	<liferay-portlet:param name="threadType" value="openThread"/>
</liferay-portlet:renderURL>

<script type="text/javascript">
	AUI().ready('aui-dialog',function(A){
		
		var giveAskFormPanel = null;
		
		var giveAskBtn = A.one('#<portlet:namespace/>giveAskBtn');
		
		if(giveAskBtn){
			
			giveAskBtn.on('click',function(){
				
				if(!giveAskFormPanel){
					
					giveAskFormPanel = new A.Dialog(
						{
							centered: true,
							cssClass: 'conversation-give-ask-dialog',
							title: Liferay.Language.get('give-ask'),
							resizable: true,
							width: 550,
							height: 650,
							zIndex: 1000
						}
					).render();
					
					giveAskFormPanel.plug(
						A.Plugin.IO,
						{
							autoLoad: false,
							uri: '<%=giveAskFormRenderURL %>'
						}
					);
				
					giveAskFormPanel.hide();
				}
				
				giveAskFormPanel.show();
				
				giveAskFormPanel.io.start();
			});
		}
	});
</script>
