<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Entry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/ykctadmin/init.jsp"%>

<%
long entryId = ParamUtil.getLong(request, "entryId",0L);

String ykctUpdateFormTitle = "add-new-ykct-entry";

if(entryId > 0){
	
	YKCT_Entry ykctEntry = YKCT_EntryLocalServiceUtil.getYKCT_Entry(entryId);
	
	if(ykctEntry != null){
		
		ykctUpdateFormTitle = StringUtil.shorten(ykctEntry.getEntryName(), 100);
	}
}

String[] formNavigatorCategoryNames = {"ykct-details"};

String[] formNavigatorSection = {"ykct-information"};

String[][] formNavigatorSections = {formNavigatorSection};

String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitYKCTUpdateForm();";
%>

<liferay-portlet:renderURL var="ykctAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/ykctadmin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="ykct_entry" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="updateYKCTEntryURL" name="updateYKCTEntry" doAsUserId="<%=userId %>">
	<liferay-portlet:param name="redirectURL" value="<%= ykctAdminURL %>" />
	<liferay-portlet:param name="entryId" value="<%= String.valueOf(entryId) %>" />	
	<portlet:param name="struts_action" value="document_library/edit_file_entry" />								
	<portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
</liferay-portlet:actionURL>

<liferay-ui:header title="<%= ykctUpdateFormTitle %>" backURL="<%=ykctAdminURL%>" />

<div class="ykct-update-form">
	<aui:form method="post" name="ykct_entry_update_form" action="<%=updateYKCTEntryURL %>" onSubmit="<%=taglibOnSubmit %>">
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/ykctadmin/form_sections/"
			backURL="<%= ykctAdminURL %>"
		/>
	</aui:form>
</div>

<script type="text/javascript">

	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var ykctEntryNameInput = A.one('#<portlet:namespace/>entryName');
		
		if(ykctEntryNameInput){
			
			ykctEntryNameInput.focus();
		}
		
		Liferay.provide(
				window,
				'<portlet:namespace />submitYKCTUpdateForm',
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
					
					document.<portlet:namespace />ykct_entry_update_form.submit();
				},
			['aui-base']
		);
	});
</script>