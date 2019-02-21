<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long legalFAQEntryId = ParamUtil.getLong(request, "legalFAQEntryId",0L);

	String headerTitle = "";
	
	LegalFAQEntry legalFAQEntry = null;
	
	if(legalFAQEntryId > 0){
		
		legalFAQEntry = LegalFAQEntryLocalServiceUtil.getEntry(legalFAQEntryId);
		headerTitle = StringUtil.shorten(legalFAQEntry.getAskTitle(), 100);
	}

	String[] formNavigatorCategoryNames = {"faq-entry-details"};

	String[] formNavigatorSection = {"ask-content","answer-content"};

	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = renderResponse.getNamespace() + "submitFAQEntryUpdateForm();";
%>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="jspPage" value="/html/legal_faq_management_portlet/management.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:header title="<%= headerTitle %>" backURL="<%=backURL%>" />

<liferay-portlet:actionURL var="updateFAQEntryURL" name="updateFAQEntry">
	<liferay-portlet:param name="legalFAQEntryId" value="<%=String.valueOf(legalFAQEntryId) %>" />
	<liferay-portlet:param name="ridirectURL" value="<%=backURL %>" />
</liferay-portlet:actionURL>

<div class="legal-faq-update-form">
	<aui:form name="faq_entry_update_form"  method="post" action="<%=updateFAQEntryURL %>" onSubmit="<%=taglibOnSubmit %>">
				
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/legal_faq_management_portlet/faq_entry/form_sections/"
			backURL="<%= backURL %>"
		/>
	</aui:form>
</div>

<script type="text/javascript">
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var citizenNameInput = A.one('#<portlet:namespace/>citizenName');
		
		if(citizenNameInput){
			citizenNameInput.focus();
		}
		
		Liferay.provide(
			window,
			'<portlet:namespace />submitFAQEntryUpdateForm',
			function() {
				
				window.validator = new A.FormValidator({
					
			        boundingBox: document.<portlet:namespace />faq_entry_update_form,
			
			        rules: {
			            <portlet:namespace />citizenName:{
			                required: true,
			                rangeLength: ['3','75']
			            },
			            <portlet:namespace />citizenPhone:{
			                required: false,
			                digits: true,
			                rangeLength: ['0','75']
			            },
			           	<portlet:namespace />citizenEmail:{
			                required: false,
			                email: true,
			                rangeLength: ['0','75']
			            },
			           	<portlet:namespace />askTitle:{
			                required: true,
			                rangeLength: ['3','300']
			            }
			        }
			    });
				
				window.validator.validate();
				
				if (!window.validator.hasErrors()) {
					
					var askContent = window.<portlet:namespace />askContentEditor.getHTML();
					
					document.<portlet:namespace />faq_entry_update_form.<portlet:namespace />askContent.value = askContent;
					
					var answerContent = window.<portlet:namespace />answerContentEditor.getHTML();
					
					document.<portlet:namespace />faq_entry_update_form.<portlet:namespace />answerContent.value = answerContent;
					
					var portletContainer = A.one('#p_p_id_legal_faq_management_WAR_legal_fagportlet_');
					
					portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
					
					portletContainer.loadingmask.toggle();
					
					document.<portlet:namespace />faq_entry_update_form.submit();
				}
			},
			['aui-base']
		);
	});

</script>
