<%@page import="com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Category"%>
<%@page import="com.portal_egov.portlet.ykct.util.FileAttachmentUtil"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Entry"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/html/js/liferay/service.js" language="JavaScript"></script>

<%@include file="/html/ykctadmin/init.jsp"%>

<%
int ykctFileAttachmentIndex = 0;

long categoryId = 0L;

long fileAttachmentMaxSize = GetterUtil.getLong(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE));

long entryId = ParamUtil.getLong(request, "entryId",0L);

YKCT_Entry currentYKCTEntry = null;

if(entryId > 0L){
	
	currentYKCTEntry = YKCT_EntryLocalServiceUtil.getYKCT_Entry(entryId);
	
	if(currentYKCTEntry != null){
		
		categoryId = currentYKCTEntry.getCategoryId();
	}
}

PortletPreferences preferences = PortalUtil.getPreferences(request);

long folderId = GetterUtil.getLong(preferences.getValue("ykctAttachmentFolderId", "0"));

Date fileExpirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);

Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
													null, fileExpirationDate, new ServiceContext());

//Danh sach file dinh kem van ban
List<DLFileEntry> ykctFileAttachmentList = FileAttachmentUtil.getYKCTFileAttachment(entryId);

List<YKCT_Category> ykctCategoryList = YKCT_CategoryLocalServiceUtil.findByGroup(groupId);
%>

<h3><liferay-ui:message key="ykct-information" /></h3>

<aui:input type="textarea" name="entryName" label="ykct-entry-name" value='<%= currentYKCTEntry != null ? HtmlUtil.escape(currentYKCTEntry.getEntryName()) : ""%>'>
	<aui:validator name="required"/>
</aui:input>

<aui:select name="categoryId" label="ykct-category">
	<aui:option value="0" selected="<%= categoryId == 0 %>" label="other"/>
	<%for(YKCT_Category ykctCategory : ykctCategoryList) {%>
		<aui:option value="<%= ykctCategory.getCategoryId() %>" label="<%= ykctCategory.getCategoryName() %>" 
			selected="<%= categoryId ==  ykctCategory.getCategoryId()%>"/>
	<%} %>
</aui:select>

<h3><liferay-ui:message key="ykct-attachment" /></h3>

<div class="ykct-file-attachment-container">
	<c:if test="<%=entryId > 0 %>">
		<div class="ykct-file-attachment-list">
			<%
				String ykctFileAttachmentName = "";
				String ykctFileAttachmentURL = "";
			
				if(currentYKCTEntry != null){
					ykctFileAttachmentName = String.valueOf(currentYKCTEntry.getEntryId());
					ykctFileAttachmentURL = currentYKCTEntry.getFileAttachmentURL();
				}
			%>
			
			<c:if test='<%=Validator.isNotNull(ykctFileAttachmentURL) %>'>
				<a href="<%=ykctFileAttachmentURL%>" title='<liferay-ui:message key="download"/>'>
					<%= ykctFileAttachmentURL%>
				</a> <br/>
			</c:if>
			
			<aui:input name="ykctFileAttachmentURL" type="hidden" value="<%=ykctFileAttachmentURL %>"/>
			
			<liferay-ui:search-container  delta="20" emptyResultsMessage="no-file-attachment">
				<liferay-ui:search-container-results 
					results="<%= ListUtil.subList(ykctFileAttachmentList, searchContainer.getStart(), searchContainer.getEnd())%>"
					total="<%= ykctFileAttachmentList.size()%>"
				/>
				
				<liferay-ui:search-container-row className="DLFileEntry" keyProperty="fileEntryId" modelVar="ykctFileAttachment" >
					<% 
						ykctFileAttachmentIndex ++;
					%>											
					<liferay-portlet:actionURL  name="deleteFileAttachment" var="deleteFileAttachmentURL">
						<liferay-portlet:param name="ykctFileAttachmentId" value="<%=String.valueOf(ykctFileAttachment.getFileEntryId())%>"/>
						<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
					</liferay-portlet:actionURL>
					
					<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(ykctFileAttachmentIndex) %>"/>
					
					<liferay-ui:search-container-column-text name="name" value="<%=ykctFileAttachment.getTitle() %>" 
										href="<%=FileAttachmentUtil.createAttachmentDownloadLink(ykctFileAttachment, themeDisplay) %>"/>
					
					<liferay-ui:search-container-column-text name="size" value='<%=TextFormatter.formatKB(ykctFileAttachment.getSize(), locale) + " KB" %>'/>
					
					<liferay-ui:search-container-column-text name="delete">
						<liferay-ui:icon-delete url="<%= deleteFileAttachmentURL %>" label="remove"/>
					</liferay-ui:search-container-column-text>										
				</liferay-ui:search-container-row>				
				<liferay-ui:search-iterator  paginate="false"/>
			</liferay-ui:search-container>
			
		</div>
	</c:if>
	
	<div class="ykct-file-attachment-uploader">
			
		<div class="portlet-msg-info">
			<span><liferay-ui:message arguments="<%= String.valueOf(fileAttachmentMaxSize/(1024*1024)) %>" key="please-select-file-with-file-size-no-larger-than-x-mb" /></span>
		</div>
		<div class="lfr-dynamic-uploader">
			<div id="ykctUploadButton"></div>
			<div class="lfr-upload-container" id="<portlet:namespace />ykctAttachFileUpload"></div>
		</div>
			
		<liferay-portlet:actionURL var="addTempAttachmentURL" name="addTempAttachment" doAsUserId="<%=userId %>">			
			<portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</liferay-portlet:actionURL>
			
		<liferay-portlet:actionURL doAsUserId="<%= userId %>" var="deleteTempAttachmentURL" name="deleteTempAttachment">
			<portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
		</liferay-portlet:actionURL>
	
		<span id="<portlet:namespace />selectedFileNameContainer"></span>
										
		<div style="clear: both;"></div>
	</div>
</div>

<aui:script use="liferay-upload">
	new Liferay.Upload(
		{
			allowedFileTypes: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
			container: '#<portlet:namespace />ykctAttachFileUpload',
			fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
			maxFileSize: <%= fileAttachmentMaxSize %> / 1024,
			namespace: '<portlet:namespace />',
			buttonPlaceHolderId :'ykctUploadButton',
			tempFileURL: {
				method: Liferay.Service.DL.DLApp.getTempFileEntryNames,
				params: {
						groupId: <%= groupId %>,
						folderId: <%= folderId %>,
						tempFolderName: 'com.portal_egov.portlet.ykct.YKCTAdminPortlet'
				}
			},
			uploadFile: '<%=addTempAttachmentURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
			deleteFile: '<%=deleteTempAttachmentURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
						
		}
	);
</aui:script>