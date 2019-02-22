<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Id cua feedback lay tu URL
	long feedbackId = ParamUtil.getLong(request, "feedbackId",0L);
	
	PropositionFeedback feedback = null;
	
	if(feedbackId > 0){
		
		feedback = PropositionFeedbackLocalServiceUtil.getPropositionFeedback(feedbackId);
	}
%>

	<h3><liferay-ui:message key="feedback-user-information" /></h3>

	<aui:input type="text" name="citizenName" value='<%= (feedback != null) ? feedback.getCitizenName() : ""%>'>
		<aui:validator name="required"/>
	</aui:input>
		
	<aui:input type="text" name="citizenEmail" value='<%= (feedback != null) ? feedback.getCitizenEmail() : ""%>'/>
	
	<aui:input type="text" name="citizenPhone" value='<%= (feedback != null) ? feedback.getCitizenPhone() : ""%>'/>
	
	<aui:input type="textarea" name="citizenAddress" value='<%= (feedback != null) ? feedback.getCitizenAddress() : ""%>'/>
			
