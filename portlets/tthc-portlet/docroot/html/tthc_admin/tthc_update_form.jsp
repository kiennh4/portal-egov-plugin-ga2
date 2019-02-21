<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String formTitle = "add-new-tthc";
	//Thu tuc hanh chinh hien tai (Dung cho truong hop update)
	TTHC_Entry currentTTHCEntry = null;
	
	long tthcEntryId = ParamUtil.getLong(request, "tthcEntryId",0L);
	
	if(tthcEntryId > 0){
		
		currentTTHCEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
		
		if(currentTTHCEntry!= null){
			
			formTitle = StringUtil.shorten(currentTTHCEntry.getEntryName(), 100);
		}
	}

	String[] formNavigatorCategoryNames = {"tthc-details"};

	String[] formNavigatorSection = {"tthc-information","tthc-categorization","tthc-process-guide","tthc-required-document","mapping-vbpq-entry"};

	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitTTHCUpdateForm();";
%>

	<liferay-portlet:renderURL var="backURL">
		<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_admin.jsp" />
	</liferay-portlet:renderURL>
	
	<liferay-portlet:actionURL var="updateTTHCEntryURL" name="updateTTHCEntry">
		<liferay-portlet:param name="redirectURL" value="<%=backURL%>" />
		<liferay-portlet:param name="tthcEntryId" value="<%=String.valueOf(tthcEntryId)%>"/>
	</liferay-portlet:actionURL>
	
	
	<liferay-ui:header title="<%= formTitle %>" backURL="<%=backURL%>" />
	
	<div class="tthc-update-form" id="<portlet:namespace />tthcUpdateFormContainer">
		<aui:form name="tthc_entry_update_form" method="post" action="<%=updateTTHCEntryURL %>" onSubmit="<%=taglibOnSubmit %>">
							
			<liferay-ui:form-navigator 
				categoryNames="<%=formNavigatorCategoryNames %>" 
				categorySections="<%=formNavigatorSections %>"
				jspPath="/html/tthc_admin/form_sections/"
				backURL="<%= backURL %>"
				showButtons="true"
			/>		
		
		</aui:form>	
	</div>
	
	<script type="text/javascript">
		AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
					
			var tthcEntryCodeInput = A.one('#<portlet:namespace/>entryCode');
			
			if(tthcEntryCodeInput){
				
				tthcEntryCodeInput.focus();
			}
			
			Liferay.provide(
					window,
					'<portlet:namespace />submitTTHCUpdateForm',
					function() {
						var A = AUI();
						var Lang = A.Lang;
						
						var processGuide = window.<portlet:namespace />processGuide.getHTML();
						document.<portlet:namespace />tthc_entry_update_form.<portlet:namespace />processGuide.value = processGuide;

						var processRequirement = window.<portlet:namespace />processRequirement.getHTML();
						document.<portlet:namespace />tthc_entry_update_form.<portlet:namespace />processRequirement.value = processRequirement;
										
						var selectedFileNameContainer = A.one('#<portlet:namespace />selectedFileNameContainer');
						
						var inputTpl = '<input id="<portlet:namespace />selectedFileName{0}" name="<portlet:namespace />selectedFileName" type="hidden" value="{1}" />';
				
						var values = A.all('input[name=<portlet:namespace />selectUploadedFileCheckbox]:checked').val();
						
						var uploadFileAttachment = A.one('.select-file');

						if(uploadFileAttachment){
							
							var buffer = [];
							var dataBuffer = [];
							var length = values.length;
					
							for (var i = 0; i < length; i++) {
									dataBuffer[0] = i;
									dataBuffer[1] = values[i].replace(/[\,\r]/gm, '');			
									buffer[i] = Lang.sub(inputTpl, dataBuffer);
							}
							selectedFileNameContainer.html(buffer.join(''));
						}
						
						document.<portlet:namespace />tthc_entry_update_form.submit();
					},
					['aui-base']
				);
		});
		
	</script>