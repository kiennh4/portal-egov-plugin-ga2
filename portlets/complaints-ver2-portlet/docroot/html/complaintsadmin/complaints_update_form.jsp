<%@page import="com.bkav.portal.portlet.complaints.ComplaintsAdmin"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.bkav.portal.portlet.complaints.util.FileAttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="com.bkav.portal.portlet.complaints.service.ComplaintsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.complaints.model.Complaints"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@include file="/html/complaintsadmin/init.jsp"%>
<script type="text/javascript" src="/html/js/liferay/service.js" ></script>
<%
	int yearRange = 20;

	int complaintFileAttachmentIndex = 0;
	
	long folderId = 0;
	
	long complaintId = ParamUtil.getLong(request, "complaintId");
	
	Date expirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
													null, expirationDate, new ServiceContext());
	
	String complaintContent = "";

	Complaints complaint = null;
	
	Calendar calendar = CalendarFactoryUtil.getCalendar();
	
	Date signingDate = calendar.getTime();
	
	if(complaintId > 0){
		
		complaint = ComplaintsLocalServiceUtil.fetchComplaints(complaintId);
		
		if(complaint != null){
			
			complaintContent = complaint.getComplaintContent();
			signingDate = complaint.getSigningDate();		
		}
	}
	
	
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitComplaintUpdateForm();";
%>

<div class="complaint-update-form">

	<liferay-portlet:renderURL var="complaintAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/complaintsadmin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="Complaints"/>
	</liferay-portlet:renderURL>

	<liferay-ui:header
		backURL="<%= complaintAdminURL %>"
		title='<%= (complaint != null) ? StringUtil.shorten(complaint.getComplaintName(),80) : "add-new-complaint" %>'
	/>
		
	<liferay-portlet:actionURL name="updateComplaint" var="updateComplaintActionURL" >
		<liferay-portlet:param name="complaintId" value="<%=String.valueOf(complaintId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=complaintAdminURL %>"/>
		<liferay-portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
		<liferay-portlet:param name="struts_action" value="document_library/edit_file_entry" />		
	</liferay-portlet:actionURL>
	
	<aui:form name="fm" method="post" action="<%= updateComplaintActionURL %>" onSubmit="<%=taglibOnSubmit %>" >
		
		<aui:model-context bean="<%= complaint %>" model="<%= Complaints.class %>" />
		
		<aui:input type="text" name="complaintNumber" >
			<aui:validator name="required"/>
		</aui:input>
		
		<div class="complaint-update-form-row" style = "height:50px;">
			<span style="display: block;"><b><liferay-ui:message key="complaint-signing-date"/></b></span>
			
			<div class="date-picker">
				<div class="aui-datepicker aui-helper-clearfix" id="<portlet:namespace />signingDateDatePicker">
					<input type="hidden" name="signingDate" id="<portlet:namespace />signingDate" size="30" />
				</div>
				
				<liferay-ui:input-date
						disabled="<%= false %>"
						dayValue="<%=signingDate.getDate() %>" dayParam="signingDay" firstDayOfWeek="<%= calendar.getFirstDayOfWeek() - 1 %>"
						monthValue="<%=signingDate.getMonth() %>" monthParam="signingMonth" 
						yearValue="<%=signingDate.getYear() + 1900 %>" yearParam="signingYear" 
						yearRangeStart="<%= calendar.get(Calendar.YEAR) - yearRange %>"
						yearRangeEnd="<%= calendar.get(Calendar.YEAR) + yearRange %>"
				/>
			</div>
		</div>
		<div class = "clear:both"></div>
		<aui:input type="text" name="complaintName" >
			<aui:validator name="required"/>
		</aui:input>
		
		<aui:input type="textarea" name="complaintDesc" />
		
		<span class="aui-field-label"><liferay-ui:message key="complaint-content"/></span>
		<liferay-ui:input-editor name="complaintContent" height="400" initMethod="initComplaintContentEditor"/>
		
		<aui:input type="hidden" name="complaintContent"/>
		
		<span class="aui-field-label"><liferay-ui:message key="complaint-reply-document"/></span>
		<liferay-ui:input-editor name="complaintReplyDocument" height="400" initMethod="initComplaintContentEditor"/>
		
		<aui:input type="hidden" name="complaintReplyDocument"/>
		
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
			<button type="button" value='save' onclick = "<portlet:namespace />submitComplaintUpdateForm();">
				<liferay-ui:message key = "save"/>
			</button>
	
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
						tempFolderName: '<%=ComplaintsAdmin.class.getName() %>'
				}
			},
			uploadFile: '<%=addTempAttachmentURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
			deleteFile: '<%=deleteTempAttachmentURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
		}
	);
</aui:script>