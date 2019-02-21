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
<%@page import="com.portal_egov.portlet.vbpq.util.FileAttachmentUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQConstants"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/html/js/liferay/service.js" language="JavaScript"></script>

<%@include file="/html/init.jsp"%>

<%
	int vbpqFileAttachmentIndex = 0;	

	long departmentId = 0L;
	long categoryId = 0L;
	long docTypeId = 0L;
	
	long fileAttachmentMaxSize = GetterUtil.getLong(PropsUtil.get(PropsKeys.DL_FILE_MAX_SIZE));
	
	long entryId = ParamUtil.getLong(request, "entryId",0L);
	
	VBPQ_Entry currentVBPQEntry = null;
	
	if(entryId > 0L){
		
		currentVBPQEntry = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(entryId);
		
		if(currentVBPQEntry != null){
			departmentId = currentVBPQEntry.getDepartmentId();
			categoryId = currentVBPQEntry.getCategoryId();
			docTypeId = currentVBPQEntry.getDocTypeId();		
		}
	}
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	long folderId = GetterUtil.getLong(preferences.getValue("vbpqAttachmentFolderId", "0"));
	
	Date fileExpirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
														null, fileExpirationDate, new ServiceContext());
	
	//Danh sach file dinh kem van ban
	List<DLFileEntry> vbpqFileAttachmentList = FileAttachmentUtil.getVBPQFileAttachment(entryId);
	
	//Danh sach co quan ban hanh VBPQ
	List<VBPQ_Category> vbpqDepartmentList = VBPQ_CategoryLocalServiceUtil.findByTypeAndCompany(VBPQConstants.DEPARTMENT_ID, companyId);

	//Danh sach linh vuc thong ke VBPQ
	List<VBPQ_Category> vbpqCategoryList = VBPQ_CategoryLocalServiceUtil.findByTypeAndCompany(VBPQConstants.CATEGORY_ID, companyId);

	//Danh sach loai VBPQ
	List<VBPQ_Category> vbpqDocTypeList = VBPQ_CategoryLocalServiceUtil.findByTypeAndCompany(VBPQConstants.DOCUMENT_TYPE_ID, companyId);
%>

	<h3><liferay-ui:message key="vbpq-information" /></h3>

	<aui:input name="entryCode" value='<%= currentVBPQEntry != null ? currentVBPQEntry.getEntryCode() : ""%>'>
		<aui:validator name="required"/>
	</aui:input>
	
	<aui:input type="textarea" name="entryName" label="vbpq-entry-name" value='<%= currentVBPQEntry != null ? HtmlUtil.escape(currentVBPQEntry.getEntryName()) : ""%>'>
		<aui:validator name="required"/>
	</aui:input>
	
	<aui:select name="docTypeId" label="vbpq-doc-type">
		<aui:option value="0" selected="<%=(docTypeId == 0L) %>" label="other" />
		<%for(VBPQ_Category vbpqDocType : vbpqDocTypeList){	%>
			<aui:option value="<%=vbpqDocType.getCategoryId()%>" label="<%=vbpqDocType.getCategoryName() %>"
						selected="<%=(docTypeId == vbpqDocType.getCategoryId())%>"/>				
		<%}%>					
	</aui:select>
	
	<aui:select name="categoryId" label="vbpq-category">
		<aui:option value="0" selected="<%=(categoryId == 0L) %>" label="other" />
		<%for(VBPQ_Category vbpqCategory : vbpqCategoryList){%>
			<aui:option value="<%=vbpqCategory.getCategoryId()%>" label="<%=vbpqCategory.getCategoryName() %>"
						selected="<%=(categoryId == vbpqCategory.getCategoryId())%>"/>				
		<%}%>					
	</aui:select>
					
	<aui:select name="departmentId" label="vbpq-department">
		<aui:option value="0" selected="<%=(departmentId == 0L) %>" label="other" />
		<%for(VBPQ_Category vbpqDepartment : vbpqDepartmentList){%>
			<aui:option value="<%=vbpqDepartment.getCategoryId()%>" label="<%=vbpqDepartment.getCategoryName() %>"
						selected="<%=(departmentId == vbpqDepartment.getCategoryId())%>"
			/>				
		<%}%>					
	</aui:select>
	
	<h3><liferay-ui:message key="vbpq-attachment" /></h3>
	
	<div class="vbpq-file-attachment-container">
		<c:if test="<%=entryId > 0 %>">
			<div class="vbpq-file-attachment-list">
				<%
					String vbpqFileAttachmentName = "";
					String vbpqFileAttachmentURL = "";
				
					if(currentVBPQEntry != null){
						vbpqFileAttachmentName = currentVBPQEntry.getEntryCode();
						vbpqFileAttachmentURL = currentVBPQEntry.getFileAttachmentURL();
					}
				%>
				
				<c:if test='<%=Validator.isNotNull(vbpqFileAttachmentURL) %>'>
					<a href="<%=vbpqFileAttachmentURL%>" title='<liferay-ui:message key="download"/>'>
						<%= vbpqFileAttachmentName%>
					</a> <br/>
				</c:if>
				
				<aui:input name="vbpqFileAttachmentURL" type="hidden" value="<%=vbpqFileAttachmentURL %>"/>
				
				<liferay-ui:search-container  delta="20" emptyResultsMessage="no-file-attachment">
					<liferay-ui:search-container-results 
						results="<%= ListUtil.subList(vbpqFileAttachmentList, searchContainer.getStart(), searchContainer.getEnd())%>"
						total="<%= vbpqFileAttachmentList.size()%>"
					/>
					
					<liferay-ui:search-container-row className="DLFileEntry" keyProperty="fileEntryId" modelVar="vbpqFileAttachment" >
						<% 
							vbpqFileAttachmentIndex ++;
						%>											
						<liferay-portlet:actionURL  name="deleteFileAttachment" var="deleteFileAttachmentURL">
							<liferay-portlet:param name="vbpqFileAttachmentId" value="<%=String.valueOf(vbpqFileAttachment.getFileEntryId())%>"/>
							<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(vbpqFileAttachmentIndex) %>"/>
						
						<liferay-ui:search-container-column-text name="name" value="<%=vbpqFileAttachment.getTitle() %>" 
											href="<%=FileAttachmentUtil.createAttachmentDownloadLink(vbpqFileAttachment, themeDisplay) %>"/>
						
						<liferay-ui:search-container-column-text name="size" value='<%=TextFormatter.formatKB(vbpqFileAttachment.getSize(), locale) + " KB" %>'/>
						
						<liferay-ui:search-container-column-text name="delete">
							<liferay-ui:icon-delete url="<%= deleteFileAttachmentURL %>" label="remove"/>
						</liferay-ui:search-container-column-text>										
					</liferay-ui:search-container-row>				
					<liferay-ui:search-iterator  paginate="false"/>
				</liferay-ui:search-container>
			</div>
		</c:if>
		
		<div class="vbpq-file-attachment-uploader">
			
			<div class="portlet-msg-info">
				<span><liferay-ui:message arguments="<%= String.valueOf(fileAttachmentMaxSize/(1024*1024)) %>" key="please-select-file-with-file-size-no-larger-than-x-mb" /></span>
			</div>
			<div class="lfr-dynamic-uploader">
				<div id="vbpqUploadButton"></div>
				<div class="lfr-upload-container" id="<portlet:namespace />vbpqAttachFileUpload"></div>
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
				container: '#<portlet:namespace />vbpqAttachFileUpload',
				fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
				maxFileSize: <%= fileAttachmentMaxSize %> / 1024,
				namespace: '<portlet:namespace />',
				buttonPlaceHolderId :'vbpqUploadButton',
				tempFileURL: {
					method: Liferay.Service.DL.DLApp.getTempFileEntryNames,
					params: {
							groupId: <%= groupId %>,
							folderId: <%= folderId %>,
							tempFolderName: 'com.portal_egov.portlet.vbpq.VBPQManagement'
					}
				},
				uploadFile: '<%=addTempAttachmentURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
				deleteFile: '<%=deleteTempAttachmentURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
							
			}
		);
	</aui:script>
