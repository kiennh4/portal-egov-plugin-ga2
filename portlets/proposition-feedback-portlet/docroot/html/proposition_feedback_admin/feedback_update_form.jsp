<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String feedbackTitle = "";
	
	//Id cua feedback lay tu URL
	long feedbackId = ParamUtil.getLong(request, "feedbackId",0L);
	
	PropositionFeedback feedback = null;
	
	if(feedbackId > 0){
		
		feedback = PropositionFeedbackLocalServiceUtil.getPropositionFeedback(feedbackId);
		
		if(feedback!= null){
			
			feedbackTitle = StringUtil.shorten(feedback.getFeedbackTitle(), 100);
		}
	}

	String[] formNavigatorCategoryNames = {"proposition-feedback"};

	String[] formNavigatorSection = {"feedback-user-information","feedback-content"};

	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitFeedbackUpdateForm();";
%>
				
<liferay-portlet:renderURL var="feedbackAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Feedbacks"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL  name="updateFeedbackContent" var="updateFeedbackContentURL">
	<liferay-portlet:param name="feedbackId" value="<%=String.valueOf(feedbackId) %>"/>
	<portlet:param name="redirectURL" value="<%=feedbackAdminURL%>"/>
</liferay-portlet:actionURL>

<liferay-ui:header title="<%= feedbackTitle %>" backURL="<%=feedbackAdminURL%>" />

<div class="proposition_update_form">
	<aui:form name="feedback_update_form" method="post" action="<%=updateFeedbackContentURL%>" onSubmit="<%=taglibOnSubmit %>">
						
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/proposition_feedback_admin/feedback_form_sections/"
			backURL="<%= feedbackAdminURL %>"
		/>
	</aui:form>
</div>
	
<script type="text/javascript">
	AUI().ready('aui-base','aui-loading-mask','aui-form-validator','aui-overlay-context-panel',function(A){
		
		var citizenNameInput = A.one('#<portlet:namespace/>citizenName');
		
		if(citizenNameInput){
			
			citizenNameInput.focus();
		}
		
		Liferay.provide(
			window,
			'<portlet:namespace />submitFeedbackUpdateForm',
			function() {
				
				window.validator = new A.FormValidator({

			        boundingBox: document.<portlet:namespace />feedback_update_form,
			        rules: {
			        	<portlet:namespace />citizenName: {
			                required: true,
			                rangeLength: ['3','75']
			            },
			        	<portlet:namespace />citizenEmail: {
			        		email: true,
			        		required: false,
			                rangeLength: ['0','75']
			            },
			            <portlet:namespace />citizenPhone: {
			            	digits: true,
			            	required: false,
			                rangeLength: ['0','75']
			            },
			        	<portlet:namespace />citizenAddress: {
			                required: false,
			                rangeLength: ['0','300']
			            },
			        	<portlet:namespace />feedbackTitle: {
			                required: true,
			                rangeLength: ['3','300']
			            }
			        }
			    });
				
				window.validator.validate();
				
				if (!window.validator.hasErrors()) {				
					var portletContainer = A.one('#p_p_id_proposition_feedback_admin_WAR_proposition_feedbackportlet_');
					
// 					portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
					
// 					portletContainer.loadingmask.toggle();
					
					var feedbackContent = window.<portlet:namespace />feedbackContentEditor.getHTML();
					
					document.<portlet:namespace />feedback_update_form.<portlet:namespace />feedbackContent.value = feedbackContent;
					
					document.<portlet:namespace />feedback_update_form.submit();
				}
			},
			['aui-base']
		);
	});
</script>