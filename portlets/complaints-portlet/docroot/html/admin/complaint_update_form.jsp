<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.portal_egov.portlet.compaints.util.FileAttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.compaints.service.Complaint_DlFileEntriesLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.compaints.model.Complaint_DlFileEntries"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.compaints.model.Complaint"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="/html/js/liferay/service.js" ></script>

<%@include file="/html/init.jsp"%>

<%
	int complaintFileAttachmentIndex = 0;
	
	int complaintStatus = 0;

	long folderId = 0;
	
	long complaintId = ParamUtil.getLong(request, "complaintId");
	
	Date expirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
													null, expirationDate, new ServiceContext());
	
	String complaintContent = "";

	Complaint complaint = null;
	
	if(complaintId > 0){
		
		complaint = ComplaintLocalServiceUtil.getComplaint(complaintId);
		
		if(complaint != null){
			
			complaintContent = complaint.getComplaintContent();
			complaintStatus = complaint.getComplaintStatus();
		}
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitComplaintUpdateForm();";
%>

<div class="complaint-update-form">

	<liferay-portlet:renderURL var="complaintAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Complaints"/>
	</liferay-portlet:renderURL>

	<liferay-ui:header
		backURL="<%= complaintAdminURL %>"
		title='<%= (complaint != null) ? StringUtil.shorten(complaint.getComplaintTitle(),80) : "add-new-complaint" %>'
	/>
		
	<liferay-portlet:actionURL name="updateComplaint" var="updateComplaintActionURL" >
		<liferay-portlet:param name="complaintId" value="<%=String.valueOf(complaintId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=complaintAdminURL %>"/>
		<liferay-portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
		<liferay-portlet:param name="struts_action" value="document_library/edit_file_entry" />		
	</liferay-portlet:actionURL>
	
	<aui:form name="fm" method="post" action="<%= updateComplaintActionURL %>" onSubmit="<%=taglibOnSubmit %>" >
		
		<aui:model-context bean="<%= complaint %>" model="<%= Complaint.class %>" />
		
		<aui:select name="complaintStatus" label="select-complaint-type">
			<aui:option label="complaint-entry" value="0" selected="<%=complaintStatus == 0 %>"/>
			<aui:option label="complaint-feedback-entry" value="1" selected="<%=complaintStatus == 1 %>"/>
		</aui:select>
		
		<aui:input type="text" name="complaintTitle" >
			<aui:validator name="required"/>
		</aui:input>
		
		<aui:input type="textarea" name="complaintDescription" />
		
		<span class="aui-field-label"><liferay-ui:message key="complaint-content"/></span>
		<liferay-ui:input-editor name="complaintContent" height="400" initMethod="initComplaintContentEditor"/>
		
		<aui:input type="hidden" name="complaintContent"/>
		
		<c:if test="<%=complaint != null %>">
			<div class="complaint-file-attachment-list">
				
				<span class="aui-field-label"><liferay-ui:message key="file-attachment"/></span>
				
				<%
				List<DLFileEntry> complaintFileAttachmentList = FileAttachmentUtil.getComplaintFileAttachments(complaintId);
				%>
				
				<liferay-ui:search-container  delta="20" emptyResultsMessage="no-file-attachment">
					<liferay-ui:search-container-results 
						results="<%= ListUtil.subList(complaintFileAttachmentList, searchContainer.getStart(), searchContainer.getEnd())%>"
						total="<%= complaintFileAttachmentList.size()%>"
					/>
					
					<liferay-ui:search-container-row className="DLFileEntry" keyProperty="fileEntryId" modelVar="complaintFileAttachment" >
						<% 
							complaintFileAttachmentIndex ++;
						
							String fileDownloadURL = FileAttachmentUtil.createAttachmentDownloadLink(complaintFileAttachment, themeDisplay);
						%>											
						<liferay-portlet:actionURL  name="deleteFileAttachment" var="deleteFileAttachmentURL">
							<liferay-portlet:param name="fileAttachmentId" value="<%=String.valueOf(complaintFileAttachment.getFileEntryId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(complaintFileAttachmentIndex) %>"/>
						
						<liferay-ui:search-container-column-text name="name" 
											value="<%=complaintFileAttachment.getTitle() %>" 
											href="<%=fileDownloadURL %>"/>
						
						<liferay-ui:search-container-column-text name="size" value='<%=TextFormatter.formatKB(complaintFileAttachment.getSize(), locale) + " KB" %>'/>
						
						<liferay-ui:search-container-column-text name="delete">
							<liferay-ui:icon-delete url="<%= deleteFileAttachmentURL %>" label="remove"/>
						</liferay-ui:search-container-column-text>										
					</liferay-ui:search-container-row>				
					<liferay-ui:search-iterator  paginate="false"/>
				</liferay-ui:search-container>
			</div>
		</c:if>
				
		<div class="complaint-attachment-uploader">
			<div class="lfr-dynamic-uploader">
				<div id="<portlet:namespace />upload-btn"></div>
				<div class="lfr-upload-container" id="<portlet:namespace />upload-container"></div>
			</div>

			<span id="<portlet:namespace />selectedFileNameContainer"></span>
		
			<div style="clear: both;"></div>
		</div>
		
		<aui:button-row>
			<aui:button type="submit" value='save'/>
	
			<aui:button href="<%= complaintAdminURL %>" type="cancel"/>
		</aui:button-row>
	</aui:form>
</div>
				
<liferay-portlet:actionURL var="addTempAttachmentURL" name="addTempFileAttachment">			
	<liferay-portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
	<liferay-portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
</liferay-portlet:actionURL>
	
<liferay-portlet:actionURL var="deleteTempAttachmentURL" name="deleteTempAttachment">
	<liferay-portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
	<liferay-portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	<liferay-portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
</liferay-portlet:actionURL>

<script type="text/javascript">
	
	AUI().ready(function(A){
		
		var complaintTitle = A.one('#<portlet:namespace/>complaintTitle');
		
		if(complaintTitle){
			
			complaintTitle.focus();
		}
		
		Liferay.provide(
			window,
			'<portlet:namespace />submitComplaintUpdateForm',
			function() {
				var A = AUI();
				var Lang = A.Lang;
				
// 				var portletContainer = A.one('#p_p_id_complaints_admin_WAR_complaintsportlet_');

// 				portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
				
// 				portletContainer.loadingmask.toggle();
				
				var complaintContent = window.<portlet:namespace />complaintContent.getHTML();
				
				A.one('#<portlet:namespace/>complaintContent').val(complaintContent);
				
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
							dataBuffer[1] = values[i];			
							buffer[i] = Lang.sub(inputTpl, dataBuffer);
					}
					selectedFileNameContainer.html(buffer.join(''));
			
					A.io.request(
						document.<portlet:namespace />fm.action,
						{
							dataType: 'json',
							form: {
									id: document.<portlet:namespace />fm
								},
							after: {
								success: function(event, id, obj) {
									
									window.location = '<%=complaintAdminURL%>';
								}
							}
						}
					);
				}
				
				document.<portlet:namespace />fm.submit();
			},
			['aui-base']
		);
	});
	
</script>
	
<aui:script>
	function <portlet:namespace />initComplaintContentEditor() {
		return "<%= UnicodeFormatter.toString(complaintContent)%>";
	}
</aui:script>
				
<aui:script use="liferay-upload">
	new Liferay.Upload(
		{
			allowedFileTypes: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
			container: '#<portlet:namespace />upload-container',
			buttonPlaceHolderId :'<portlet:namespace />upload-btn',
			fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
			maxFileSize: <%= Long.valueOf(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE)) %> / 1024,
			namespace: '<portlet:namespace />',
			tempFileURL: {
				method: Liferay.Service.DL.DLApp.getTempFileEntryNames,
				params: {
						groupId: <%= groupId %>,
						folderId: <%= folderId %>,
						tempFolderName: 'com.portal_egov.portlet.complaints'
				}
			},
			uploadFile: '<%=addTempAttachmentURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
			deleteFile: '<%=deleteTempAttachmentURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
		}
	);
</aui:script>







