<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long entryId = ParamUtil.getLong(request, "entryId",0L);

	String vbpqUpdateFormTitle = "add-new-vbpq-entry";
	
	if(entryId > 0){
		
		VBPQ_Entry vbpqEntry = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(entryId);
		
		if(vbpqEntry != null){
			
			vbpqUpdateFormTitle = StringUtil.shorten(vbpqEntry.getEntryName(), 100);
		}
	}

	String[] formNavigatorCategoryNames = {"vbpq-details"};

	String[] formNavigatorSection = {"vbpq-information","vbpq-schedule"};

	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitVBPQUpdateForm();";
%>


<liferay-portlet:renderURL var="vbpqAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Entries" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="updateVBPQEntryURL" name="updateVBPQEntry" doAsUserId="<%=userId %>">
	<liferay-portlet:param name="redirectURL" value="<%= vbpqAdminURL %>" />
	<liferay-portlet:param name="entryId" value="<%= String.valueOf(entryId) %>" />	
	<portlet:param name="struts_action" value="document_library/edit_file_entry" />								
	<portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
</liferay-portlet:actionURL>


<liferay-ui:header title="<%= vbpqUpdateFormTitle %>" backURL="<%=vbpqAdminURL%>" />

<div class="vbpq-update-form">
	<aui:form method="post" name="vbpq_entry_update_form" action="<%=updateVBPQEntryURL %>" onSubmit="<%=taglibOnSubmit %>">
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/vbpq_admin/form_sections/"
			backURL="<%= vbpqAdminURL %>"
		/>
	</aui:form>
</div>

<script type="text/javascript">

	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var vbpqEntryCodeInput = A.one('#<portlet:namespace/>entryCode');
		
		if(vbpqEntryCodeInput){
			
			vbpqEntryCodeInput.focus();
		}
		
		Liferay.provide(
				window,
				'<portlet:namespace />submitVBPQUpdateForm',
				function() {
					
					var A = AUI();
					
					var Lang = A.Lang;
					
					var selectedFileNameContainer = A.one('#<portlet:namespace />selectedFileNameContainer');
					
					var inputTpl = '<input id="<portlet:namespace />selectedFileName{0}" name="<portlet:namespace />selectedFileName" type="hidden" value="{1}" />';
			
					var values = A.all('input[name=<portlet:namespace />selectUploadedFileCheckbox]:checked').val();
					
					var uploadFileAttachment = A.one('.select-file');

					if(uploadFileAttachment){
						
						var buffer = [];
						var dataBuffer = [];
						var length = values.length;
						
						for (var i = 0; i < length; i++){
							
							dataBuffer[0] = i;
							
							var selectedFileName = values[i].replace(/[\,\r]/gm, '');
							
							dataBuffer[1] = selectedFileName;
							
							buffer[i] = Lang.sub(inputTpl, dataBuffer);
						}
						
						selectedFileNameContainer.html(buffer.join(''));
					}
					
					document.<portlet:namespace />vbpq_entry_update_form.submit();
				},
			['aui-base']
		);
	});
</script>