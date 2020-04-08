<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Id cua du thao hien tai
	long propositionId = ParamUtil.getLong(request, "propositionId",0L);
	
	Proposition currentProposition = null;
	
	String propositionUpdateFormTitle = "add-new-proposition";
	
	if(propositionId > 0){
		currentProposition = PropositionLocalServiceUtil.getProposition(propositionId);
		
		if(currentProposition != null){
			
			propositionUpdateFormTitle = StringUtil.shorten(currentProposition.getPropositionName(), 100);
		}
	}

	String[] formNavigatorCategoryNames = {"proposition-online-feedback"};

	String[] formNavigatorSection = {"proposition-information","proposition-categorization"};

	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitPropositionUpdateForm();";
%>
				
<liferay-portlet:renderURL var="propositionAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/proposition_feedback_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Propositions"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL  name="updateProposition" var="updatePropositionURL">
	<liferay-portlet:param name="propositionId" value="<%=String.valueOf(propositionId) %>"/>
	<portlet:param name="redirectURL" value="<%=propositionAdminURL%>"/>
</liferay-portlet:actionURL>

<liferay-ui:header title="<%= propositionUpdateFormTitle %>" backURL="<%=propositionAdminURL%>" />

<div class="proposition_update_form">
	<aui:form name="proposition_update_form" enctype="multipart/form-data"  method="post" action="<%=updatePropositionURL%>" onSubmit="<%=taglibOnSubmit %>">
						
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/proposition_feedback_admin/proposition_form_sections/"
			backURL="<%= propositionAdminURL %>"
		/>
	</aui:form>
</div>
	
<script type="text/javascript">

	AUI().ready('aui-base','aui-loading-mask','aui-form-validator','aui-overlay-context-panel',function(A){
				
		var propositionNameInput = A.one('#<portlet:namespace/>propositionName');
		
		if(propositionNameInput){
			
			propositionNameInput.focus();
		}
	
		Liferay.provide(
			window,
			'<portlet:namespace />submitPropositionUpdateForm',
			function() {
				
				window.validator = new A.FormValidator({

			        boundingBox: document.<portlet:namespace />proposition_update_form,
			        rules: {
			        	<portlet:namespace />propositionName: {
			                required: true,
			                rangeLength: ['3','300']
			            },
			        	<portlet:namespace />propositionDesc: {
			                required: false,
			                rangeLength: ['0','1000']
			            }
			        }
			    });
				
				window.validator.validate();
				
				if (!window.validator.hasErrors()) {
					
					var portletContainer = A.one('#p_p_id_proposition_feedback_admin_WAR_proposition_feedbackportlet_');
					
// 					portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
					
// 					portletContainer.loadingmask.toggle();
					
					var propositionContent = window.<portlet:namespace />propositionContentEditor.getHTML();
					
					document.<portlet:namespace />proposition_update_form.<portlet:namespace />propositionContent.value = propositionContent;
					
					document.<portlet:namespace />proposition_update_form.submit();
				}	
			},
			['aui-base']
		);
	});

</script>