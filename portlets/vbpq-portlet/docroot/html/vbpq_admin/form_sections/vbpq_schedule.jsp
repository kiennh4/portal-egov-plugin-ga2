<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int yearRange = 20;

	long entryId = ParamUtil.getLong(request, "entryId",0L);

	boolean neverExpired = true;
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date publishDate = calendar.getTime();
	Date executeDate = calendar.getTime();
	Date expirationDate = calendar.getTime();
	
	VBPQ_Entry currentVBPQEntry = null;
	
	if(entryId > 0L){
		
		currentVBPQEntry = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(entryId);
		
		if(currentVBPQEntry != null){
			
			neverExpired = currentVBPQEntry.getNeverExpired();
			
			if(currentVBPQEntry.getPublishDate() != null){
				
				publishDate = currentVBPQEntry.getPublishDate();
			}
			
			if(currentVBPQEntry.getExecuteDate() != null){
				
				executeDate = currentVBPQEntry.getExecuteDate();
			}
			
			if(currentVBPQEntry.getExpirationDate() != null){
				
				expirationDate = currentVBPQEntry.getExpirationDate();
			}
		}
	}
%>

	<h3><liferay-ui:message key="vbpq-schedule" /></h3>
			
	<div class="vbpq-update-form-row">
		<span style="display: block;"><liferay-ui:message key="vbpq-publish-date"/></span>
		
		<div class="date-picker">
			<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />publishDatePicker">
				<input type="hidden" name="publishDate" id="<portlet:namespace />publishDate" size="30" />
			</div>
			
			<liferay-ui:input-date
					disabled="<%= false %>"
					dayValue="<%=publishDate.getDate() %>" dayParam="vbpqPublishDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
					monthValue="<%=publishDate.getMonth() %>" monthParam="vbpqPublishMonth" 
					yearValue="<%=publishDate.getYear() + 1900 %>" yearParam="vbpqPublishYear" 
					yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
					yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
			/>
		</div>
	</div>
					
	<div class="vbpq-update-form-row">
		<span style="display: block;"><liferay-ui:message key="vbpq-execute-date"/></span>
		
		<div class="date-picker">				
			<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />executeDatePicker">
				<input type="hidden" name="executeDate" id="<portlet:namespace />executeDate" size="30" />
			</div>
			<liferay-ui:input-date
					disabled="<%= false %>"
					dayValue="<%=executeDate.getDate() %>" dayParam="vbpqExecuteDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
					monthValue="<%=executeDate.getMonth() %>" monthParam="vbpqExecuteMonth" 
					yearValue="<%=executeDate.getYear() + 1900 %>" yearParam="vbpqExecuteYear" 
					yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
					yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
			/>
		</div>
	</div>
					
	<div class="vbpq-update-form-row">
		<aui:input id="neverExpired" type="checkbox" name="neverExpired" label="vbpq-never-exprired" value="<%=neverExpired %>"/>
		
		<div class="date-picker">
			<div style="margin-top: 5px;">
				<div id="vbpq_expiration_date_picker" class="vbpq_expiration_date_picker">
				
					<span style="display: block;"><liferay-ui:message key="vbpq-exprired-date"/></span>
					
					<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />expirationDatePicker">
						<input type="hidden" name="expirationDate" id="<portlet:namespace />expirationDate" size="30" />
					</div>
					<liferay-ui:input-date
							disabled="<%= false %>"
							dayValue="<%=expirationDate.getDate() %>" dayParam="vbpqExpirationDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
							monthValue="<%=expirationDate.getMonth() %>" monthParam="vbpqExpirationMonth" 
							yearValue="<%=expirationDate.getYear() + 1900 %>" yearParam="vbpqExpirationYear" 
							yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
							yearRangeEnd="<%= calendar.get(Calendar.YEAR) +  yearRange %>"
					/>
				</div>
			</div>
		</div>
	</div>
			
	<aui:script use="aui-base">			
		Liferay.Util.toggleBoxes('<portlet:namespace />neverExpiredCheckbox','vbpq_expiration_date_picker',true);
	</aui:script>	