<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int feedbackStatus = PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE;

	long propositionId = 0L;

	String feedbackTitle = "";
	
	String feedbackContent = "";
	
	//Id cua feedback lay tu URL
	long feedbackId = ParamUtil.getLong(request, "feedbackId",0L);
	
	PropositionFeedback feedback = null;
	
	Proposition feedbackProposition = null;
	
	if(feedbackId > 0){
		
		feedback = PropositionFeedbackLocalServiceUtil.getPropositionFeedback(feedbackId);
		
		if(feedback!= null){
			
			feedbackStatus = feedback.getStatus();
			
			feedbackTitle = StringUtil.shorten(feedback.getFeedbackTitle(), 100);
			
			feedbackContent = feedback.getFeedbackContent();
			
			if(feedback.getPropositionId() > 0L){
				
				feedbackProposition = PropositionLocalServiceUtil.getProposition(feedback.getPropositionId());
				
				if(feedbackProposition != null){
					
					propositionId = feedbackProposition.getPropositionId();
				}
			}
		}
	}
	
	List<Proposition> propositionList = PropositionLocalServiceUtil.findByGroup(scopeGroupId);
	
%>

	<h3><liferay-ui:message key="feedback-categorization" /></h3>
		
	<aui:select name="status">
	
		<aui:option value="<%=PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE %>" label="unpublish-feedback"
					selected="<%=feedbackStatus == PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE %>"/>
						
		<aui:option value="<%=PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE %>" label="publish-feedback"
					selected="<%=feedbackStatus == PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE %>"/>
	</aui:select>
	
	<aui:select name="propositionId" label="select-proposition">
		<aui:option value="0" label="select" selected="<%=propositionId == 0L %>"/>
		<%
		for(Proposition proposition : propositionList){
		%>
			<aui:option value="<%=proposition.getPropositionId() %>" label="<%=proposition.getPropositionName() %>" 
						selected="<%=propositionId == proposition.getPropositionId() %>"/>
		<%
		}//thank khiu
		%>
	</aui:select>
		
	<h3><liferay-ui:message key="feedback-content" /></h3>
			
	<aui:input type="text" name="feedbackTitle" value='<%= feedbackTitle%>'>
		<aui:validator name="required"/>
	</aui:input>
	
	<div style="padding: 5px 0px;">
		<liferay-ui:message key="content" />
	</div>
	
	<liferay-ui:input-editor name="feedbackContentEditor" height="400" initMethod="initFeedbackContentEditor"/>
	
	<aui:input type="hidden" name="feedbackContent"/>
		
	<aui:script>
		function <portlet:namespace />initFeedbackContentEditor() {
			return "<%= UnicodeFormatter.toString(feedbackContent)%>";
		}
	</aui:script>
	
	
	
	
	
	