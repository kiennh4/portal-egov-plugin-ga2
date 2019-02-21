<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCFileAttachmentUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/html/js/liferay/service.js" language="JavaScript"></script>

<%@include file="/html/init.jsp"%>

<%	
	int fileAttachmentIndex = 0;
	
	long folderId = 0;
	
	long repositoryId = scopeGroupId;
	
	Date expirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
													null, expirationDate, new ServiceContext());
	
	List<DLFileEntry> tthcFileAttachList = new ArrayList<DLFileEntry>();

	long tthcEntryId = ParamUtil.getLong(request, "tthcEntryId",0L);

	TTHC_Entry tthcEntry = null;
	
	if(tthcEntryId > 0){
		
		tthcEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
		
		if(tthcEntry != null){
			
			tthcFileAttachList = TTHCFileAttachmentUtil.getTTHCAttachFiles(scopeGroupId, tthcEntryId);
		}
	}
%>

	<h3><liferay-ui:message key="tthc-information" /></h3>

	<aui:input type="text" name="entryCode" label="tthc-entry-code"
				value='<%= tthcEntry != null ? tthcEntry.getEntryCode() : ""%>' >
		<aui:validator name="required" />
	</aui:input>

	<aui:input type="textarea" name="entryName" label="tthc-entry-name"
				value='<%= tthcEntry != null ? tthcEntry.getEntryName() : ""%>' >
		<aui:validator name="required" />
	</aui:input>

	<aui:input type="textarea" name="processFoundationDocument" label="tthc-foundation"
			   value='<%= tthcEntry != null ? tthcEntry.getProcessFoundationDocument() : ""%>' />
							
	<aui:input type="text" name="processType" label="tthc-process-type" 
				value='<%= tthcEntry != null ? tthcEntry.getProcessType() : ""%>' />

	<aui:input type="text" name="processFee" label="tthc-process-fees" 
				value='<%= tthcEntry != null ? tthcEntry.getProcessFee() : ""%>' />
				
	<aui:input type="text" name="processTime" label="tthc-process-time" 
				value='<%= tthcEntry != null ? tthcEntry.getProcessTime() : ""%>' />

	<h3><liferay-ui:message key="tthc-file-attachment" /></h3>
	
	<div class="tthc-file-attachment-container">
		<c:if test="<%=tthcEntryId > 0 %>">
			<div class="tthc-file-attachment-list">
				<liferay-ui:search-container  emptyResultsMessage="no-file-attachment">
					<liferay-ui:search-container-results 
						results="<%= ListUtil.subList(tthcFileAttachList, searchContainer.getStart(), searchContainer.getEnd())%>"
						total="<%= tthcFileAttachList.size()%>"
					/>
					
					<liferay-ui:search-container-row className="DLFileEntry" keyProperty="fileEntryId" modelVar="tthcFileAttachment" >
						<%
							fileAttachmentIndex ++;
						
							String downloadFileAttachmentURL = TTHCFileAttachmentUtil.createAttachmentDownloadLink(tthcFileAttachment, themeDisplay);
						%>											
						<liferay-portlet:actionURL name="deleteFileAttachment" var="deleteFileAttachmentURL">
							<liferay-portlet:param name="tthcFileAttachmentId" value="<%=String.valueOf(tthcFileAttachment.getFileEntryId())%>"/>
							<liferay-portlet:param name="tthcEntryId" value="<%=String.valueOf(tthcEntryId)%>"/>
							<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:search-container-column-text 
							name="#" 
							value="<%=String.valueOf(fileAttachmentIndex) %>"
							href="<%=downloadFileAttachmentURL %>"
						/>
						
						<liferay-ui:search-container-column-text 
							name="name" 
							value="<%=tthcFileAttachment.getTitle() %>" 
							href="<%=downloadFileAttachmentURL %>"
						/>
						
						<liferay-ui:search-container-column-text 
							name="size" 
							value='<%=TextFormatter.formatKB(tthcFileAttachment.getSize(), locale) + " KB" %>'
							href="<%=downloadFileAttachmentURL %>"
						/>
						
						<liferay-ui:search-container-column-text name="">
							<liferay-ui:icon-delete url="<%= deleteFileAttachmentURL %>" label="remove"/>
						</liferay-ui:search-container-column-text>										
					</liferay-ui:search-container-row>				
					<liferay-ui:search-iterator paginate="<%= false %>"/>
				</liferay-ui:search-container>	
			</div>
		</c:if>
		
		<div class="tthc-file-attachment-uploader">
			<div class="lfr-dynamic-uploader">
				<div id="requiredDocumentUploadBtn"></div>
				<div class="lfr-upload-container" id="<portlet:namespace />required_document_file_upload"></div>
			</div>
				
			<liferay-portlet:actionURL var="addTempAttachmentURL" name="addTempAttachment" doAsUserId="<%=userId %>">			
				<portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
				<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
			</liferay-portlet:actionURL>
				
			<liferay-portlet:actionURL var="deleteTempAttachmentURL" name="deleteTempAttachment"  doAsUserId="<%= userId %>" >
				<portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
				<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
				<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			</liferay-portlet:actionURL>
			
			<span id="<portlet:namespace />selectedFileNameContainer"></span>
		
			<div style="clear: both;"></div>
		</div>
	</div>
				
<aui:script use="liferay-upload">
	new Liferay.Upload(
		{
			allowedFileTypes: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
			container: '#<portlet:namespace />required_document_file_upload',
			fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
			maxFileSize: <%= Long.valueOf(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE)) %> / 1024,
			namespace: '<portlet:namespace />',
			tempFileURL: {
				method: Liferay.Service.DL.DLApp.getTempFileEntryNames,
				params: {
						groupId: <%= scopeGroupId %>,
						folderId: <%= folderId %>,
						tempFolderName: 'com.portal_egov.portlet.tthc.TTHCAdmin'
				}
			},
			uploadFile: '<%=addTempAttachmentURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
			deleteFile: '<%=deleteTempAttachmentURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
		}
	);
</aui:script>			