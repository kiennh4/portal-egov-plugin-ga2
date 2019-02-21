<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int yearRange = 20;

	long legalFAQEntryId = ParamUtil.getLong(request, "legalFAQEntryId",0L);
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date answerDate = calendar.getTime();
	
	String answerContent = "";
	
	LegalFAQEntry legalFAQEntry = null;
	
	if(legalFAQEntryId > 0){
		
		legalFAQEntry = LegalFAQEntryLocalServiceUtil.getEntry(legalFAQEntryId);
		
		if(legalFAQEntry != null){
			
			answerDate = legalFAQEntry.getAnswerDate();
			answerContent = legalFAQEntry.getAnswerContent();
		}
	}
%>
	<h3><liferay-ui:message key="answer-content" /></h3>
		
	<div class="lfr-form-row">
		<span style="display: block;"><liferay-ui:message key="answer-date"/></span>
		
		<div class="date-picker">
			<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />answerDatePicker">
				<input type="hidden" name="answerDate" id="<portlet:namespace />answerDate" size="30" />
			</div>
			
			<liferay-ui:input-date
					disabled="<%= false %>"
					dayValue="<%=answerDate.getDate() %>" dayParam="answerDayParam" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
					monthValue="<%=answerDate.getMonth() %>" monthParam="answerMonthParam" 
					yearValue="<%=answerDate.getYear() + 1900 %>" yearParam="answerYearParam" 
					yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
					yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
			/>
		</div>
	</div>
		
	<span style="display: block;font-weight: bold;"><liferay-ui:message key="answer-content"/></span>
	
	<liferay-ui:input-editor name="answerContentEditor" height="400" initMethod="initAnswerContentEditor"/>
	
	<aui:input type="hidden" name="answerContent" value=""/>
	<br/>
	<p style="color:red;">*<liferay-ui:message key="faq-send-email-message"/></p>
	<aui:script>
		function <portlet:namespace />initAnswerContentEditor() {
			return "<%= UnicodeFormatter.toString(answerContent)%>";
		}
	</aui:script>
	
			
