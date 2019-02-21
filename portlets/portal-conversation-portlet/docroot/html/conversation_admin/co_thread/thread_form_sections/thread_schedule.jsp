<%@page import="com.portal_egov.portlet.conversation.service.CO_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
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
	int threadStatus = CO_Constants.DEFAULT_THREAD_STATUS_VALUE;
	
	long threadCategoryId = 0L;

	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date threadStartDate = calendar.getTime();
	Date threadEndDate = calendar.getTime();
	
	CO_Thread coThread = null;
	
	if(threadId > 0){
		
		coThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
		
		if(coThread != null){
			
			threadStatus = coThread.getStatus();
			
			threadCategoryId = coThread.getCategoryId();
			
			threadStartDate = coThread.getStartDate();
			
			threadEndDate = coThread.getEndDate();
		}
	}
	
	calendar.setTime(threadStartDate);
	
	int threadStartHour = threadStartDate.getHours();
	int threadStartAMPM = calendar.get(Calendar.AM_PM);
	if(threadStartAMPM == Calendar.PM){
		threadStartHour -= 12;
	}
	
	calendar.setTime(threadEndDate);
	int threadEndHour = threadEndDate.getHours();
	int threadEndAMPM = calendar.get(Calendar.AM_PM);
	if(threadEndAMPM == Calendar.PM){
		threadEndHour -= 12;
	}
	
	List<CO_Category> threadCategoryList = CO_CategoryLocalServiceUtil.findByGroup(scopeGroupId);
%>

	<h3><liferay-ui:message key="thread-schedule" /></h3>
	
		<aui:select name="threadStatus">
		
			<aui:option label="UNPUBLISH" value="<%=CO_Constants.DEFAULT_THREAD_STATUS_VALUE %>" 
						selected="<%=threadStatus == CO_Constants.DEFAULT_THREAD_STATUS_VALUE %>"
			/>
					
			<aui:option label="PUBLISH" value="<%=CO_Constants.PUBLISH_THREAD_STATUS_VALUE %>" 
						selected="<%=threadStatus == CO_Constants.PUBLISH_THREAD_STATUS_VALUE %>"
			/>
					
			<aui:option label="OPEN" value="<%=CO_Constants.OPEN_THREAD_STATUS_VALUE %>" 
						selected="<%=threadStatus == CO_Constants.OPEN_THREAD_STATUS_VALUE %>"
			/>
								
			<aui:option label="ONLINE" value="<%=CO_Constants.ONLINE_THREAD_STATUS_VALUE %>" 
						selected="<%=threadStatus == CO_Constants.ONLINE_THREAD_STATUS_VALUE %>"
			/>
		</aui:select>
		
				
		<aui:select name="threadCategoryId" label="co-thread-category">
			<aui:option label="others" value="0" selected="<%=threadCategoryId == 0L %>" />
			<%
			for(CO_Category threadCategory : threadCategoryList){
			%>
				<aui:option label="<%=threadCategory.getCategoryName() %>" value="<%=threadCategory.getCategoryId() %>" 
							selected="<%=threadCategory.getCategoryId() == threadCategoryId %>"/>
			<%
			}
			%>
		</aui:select>
			
		<div class="co-thread-update-form-row">

			<span style="display: block;"><liferay-ui:message key="co-thread-start-date"/></span>
			
			<div class="date-picker">
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />startDatePicker">
					<input type="hidden" name="threadStartDate" id="<portlet:namespace />threadStartDate" size="30" />
				</div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=threadStartDate.getDate() %>" dayParam="threadStartDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=threadStartDate.getMonth() %>" monthParam="threadStartMonth" 
						yearValue="<%=threadStartDate.getYear() + 1900 %>" yearParam="threadStartYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + 5 %>"
				/>
				
				<liferay-ui:input-time  hourParam="threadStartHour" hourValue="<%=threadStartHour %>"
										minuteParam="threadStartMinute" minuteValue="<%=threadStartDate.getMinutes() %>" minuteInterval="5"
										amPmParam="threadStartAMPM" amPmValue="<%=threadStartAMPM %>"/>
			</div>
		</div>						
		<br>
		<div class="co-thread-update-form-row">
		
			<span style="display: block;"><liferay-ui:message key="co-thread-end-date"/></span>
			
			<div class="date-picker">
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />endDatePicker">
					<input type="hidden" name="threadEndDate" id="<portlet:namespace />threadEndDate" size="30" />
				</div>
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=threadEndDate.getDate() %>" dayParam="threadEndDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=threadEndDate.getMonth() %>" monthParam="threadEndMonth" 
						yearValue="<%=threadEndDate.getYear() + 1900 %>" yearParam="threadEndYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + 5 %>"
				/>
				<liferay-ui:input-time  hourParam="threadEndHour" hourValue="<%=threadEndHour %>"
										minuteParam="threadEndMinute" minuteValue="<%=threadEndDate.getMinutes() %>" minuteInterval="5"
										amPmParam="threadEndAMPM" amPmValue="<%=threadEndAMPM %>"/>
			</div>
		</div>
			

			
