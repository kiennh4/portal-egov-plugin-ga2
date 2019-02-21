<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int conversationStatus = CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE;

	long conversationId = ParamUtil.getLong(request, "conversationId",0L);
	
	long threadId = 0L;
	
	String askContent = "";

	CO_Conversation conversation = null;

	Calendar calendar = CalendarFactoryUtil.getCalendar();

	Date conversationAskDate = calendar.getTime();
	
	if(conversationId > 0){
		
		conversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
		
		if(conversation != null){
			
			conversationStatus = conversation.getStatus();
			threadId = conversation.getThreadId();
			askContent = conversation.getAskContent();
			conversationAskDate = conversation.getAskDate();
		}
	}
	
	
	calendar.setTime(conversationAskDate);
	int conversationAskHour = conversationAskDate.getHours();
	int conversationAskAMPM = calendar.get(Calendar.AM_PM);
	if(conversationAskAMPM == Calendar.PM){
		conversationAskHour -= 12;
	}
	
	List<CO_Thread> threadList = CO_ThreadLocalServiceUtil.findByGroup(scopeGroupId);
%>

	<h3><liferay-ui:message key="ask-content" /></h3>
	
	<aui:select name="threadId" label="thread-name">
		<aui:option value="0" label="other" selected="<%=(threadId == 0L) %>"/>
		<%
		for(CO_Thread thread : threadList){
		%>
			<aui:option value="<%=thread.getThreadId()%>" label="<%=thread.getThreadName() %>" selected="<%=(threadId == thread.getThreadId())%>"/>
		<%
		}
		%>					
	</aui:select>
	
	<aui:input type="text" name="askUserName" value='<%= conversation != null ? conversation.getAskUserName() : ""%>'>
		<aui:validator name="required" />
	</aui:input>
			
	<aui:input type="textarea" name="askUserAddress" value='<%= conversation != null ? conversation.getAskUserInfo() : ""%>' />

	<div class="co-conversation-update-form-row">

		<span style="display: block;"><liferay-ui:message key="conversation-ask-date"/></span>
		
		<div class="date-picker">
		
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />askDatePicker">
					<input type="hidden" name="conversationAskDate" id="<portlet:namespace />conversationAskDate" size="30" />
				</div>
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=conversationAskDate.getDate() %>" dayParam="conversationAskDay" 
						firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=conversationAskDate.getMonth() %>" monthParam="conversationAskMonth" 
						yearValue="<%=conversationAskDate.getYear() + 1900 %>" yearParam="conversationAskYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - 5 %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + 5 %>"
				/>
				<liferay-ui:input-time  hourParam="conversationAskHour" hourValue="<%=conversationAskHour %>"
										minuteParam="conversationAskMinute" minuteValue="<%=conversationAskDate.getMinutes() %>" 
										minuteInterval="5"
										amPmParam="conversationAskAMPM" amPmValue="<%=conversationAskAMPM %>"/>
		</div>
	</div>
	
	<aui:select name="conversationStatus" >
		<aui:option label="NEW" value="<%=CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE %>" selected="<%= conversationStatus == CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE %>" />
		<aui:option label="UNPUBLISH" value="<%=CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE %>" selected="<%= conversationStatus == CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE %>" />
		<aui:option label="PUBLISH" value="<%=CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE %>" selected="<%= conversationStatus == CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE %>" />
	</aui:select>
					
	<aui:input type="text" name="conversationTitle" value='<%= conversation != null ? conversation.getTitle() : "" %>' >
		<aui:validator name="required" />
	</aui:input>
	
	<div class="co-conversation-update-form-row">
		<span style="display: block;"><liferay-ui:message key="conversation-ask-content"/>(*)</span>
		
		<liferay-ui:input-editor width="60%" height="60%" name="askContentEditor" initMethod="initAskContentEditor"/>
		
		<aui:input type="hidden" name="askContent"/>
	</div>
		
	<aui:script>
		function <portlet:namespace />initAskContentEditor() {
			return "<%= UnicodeFormatter.toString(askContent)%>";
		}
	</aui:script>
			
