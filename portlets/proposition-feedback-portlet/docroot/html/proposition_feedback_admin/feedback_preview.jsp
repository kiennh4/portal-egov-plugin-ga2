<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.permission.PropositionFeedbackPermission"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
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

<c:if test='<%=Validator.isNotNull(feedback) %>'>
	<%
		String feedbackTitle = feedback.getFeedbackTitle();
	
		long propositionId = feedback.getPropositionId();
		
		String propositionName = "";
		
		if(propositionId > 0){
			Proposition proposition = PropositionLocalServiceUtil.getProposition(propositionId);
			
			if(proposition != null){
				propositionName = proposition.getPropositionName();
			}
		}
		
		String statusByUserName = "";
		
		if(feedback.getStatusByUserId() > 0){
			
			User user = UserLocalServiceUtil.getUser(feedback.getStatusByUserId());
			
			if(user != null){
				statusByUserName = user.getFullName();
			}
		}
	%>
	<div class="feedback-preview">
		<div class="feedback-title">
			<span style="display: block;font-weight: normal;"><liferay-ui:message key="feedback-title"/></span>
			<span><%=feedbackTitle %></span>
		</div>
		
		<table>
			<tr>
				<td><liferay-ui:message key="proposition-name"/></td>
				<td class="proposition-title"><%=propositionName %></td>
			</tr>
						
			<tr>
				<td ><liferay-ui:message key="citizen-name"/></td>
				<td><%=feedback.getCitizenName() %></td>
			</tr>
										
			<tr>
				<td ><liferay-ui:message key="citizen-email"/></td>
				<td><%=feedback.getCitizenEmail() %></td>
			</tr>
										
			<tr>
				<td ><liferay-ui:message key="citizen-phone"/></td>
				<td><%=feedback.getCitizenPhone() %></td>
			</tr>
														
			<tr>
				<td><liferay-ui:message key="feedback-content"/></td>
				<td><%=feedback.getFeedbackContent() %></td>
			</tr>
																						
			<tr>
				<td><liferay-ui:message key="receive-date"/></td>
				<td><%=dateTimeFormat.format(feedback.getCreateDate()) %></td>
			</tr>
																										
			<tr>
				<td><liferay-ui:message key="feedback-status"/></td>
				<td><liferay-ui:message key="<%=PropositionUtil.getFeedbackStatusTitle(feedback) %>"/></td>
			</tr>
																														
			<tr>
				<td><liferay-ui:message key="feedback-status-date"/></td>
				<td><%=dateTimeFormat.format(feedback.getStatusDate()) %></td>
			</tr>
																																		
			<tr>
				<td><liferay-ui:message key="status-by-user"/></td>
				<td><liferay-ui:message key="<%=statusByUserName %>"/></td>	
			</tr>
		</table>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="button" name="updateFeedbackBtn" value="update"/>
		<c:if test="<%= feedback.getStatus() == PropositionConstants.DEFAULT_FEEDBACK_STATUS_VALUE %>">
			<aui:button type="button" name="publishFeedbackBtn" value="publish"/>
		</c:if>
		<aui:button type="button" name="closeDialogBtn" value="close"/>
	</div>
</c:if>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var EVENT_CLICK = 'click';
		var CONFIRM_PUBLISH_FEEDBACK_MSG = 'are-you-sure-want-to-publish-this-feedback?';
		
		var updateFeedbackBtn = A.one('#<portlet:namespace/>updateFeedbackBtn');
				
		if(updateFeedbackBtn){
			
			updateFeedbackBtn.on(EVENT_CLICK,function(){

				Liferay.Util.getOpener().showFeedbackUpdateForm('<%=feedbackId%>');
				
				Liferay.Util.getWindow().close();
			});
		}
		
		var publishFeedbackBtn = A.one('#<portlet:namespace/>publishFeedbackBtn');
				
		if(publishFeedbackBtn){
			
			publishFeedbackBtn.on(EVENT_CLICK,function(){
				
				if(confirm(Liferay.Language.get(CONFIRM_PUBLISH_FEEDBACK_MSG))){
					
					Liferay.Util.getOpener().publishFeedback('<%=feedbackId%>');
					
					Liferay.Util.getWindow().close();
				}
			});
		}
		
		var closeDialogBtn = A.one('#<portlet:namespace/>closeDialogBtn');
		
		if(closeDialogBtn){
			
			closeDialogBtn.on(EVENT_CLICK,function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</script>