<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.portal_egov.portlet.compaints.util.FileAttachmentUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.compaints.model.Complaint"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long complaintId = ParamUtil.getLong(request, "complaintId");

	Complaint complaint = null;
	
	if(complaintId > 0){
		
		complaint = ComplaintLocalServiceUtil.getComplaint(complaintId);
	}
%>

<c:if test='<%=Validator.isNotNull(complaint) %>'>
	
	<%
	List<DLFileEntry> attachmentFileList = FileAttachmentUtil.getComplaintFileAttachments(complaintId);
	%>
	
	<div class="complaint-preview">
		
		<div class="complaint-detail">
		
			<c:if test='<%=Validator.isNotNull(complaint.getComplaintDescription()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="complaint-description"/></div>
					<div class="complaint-description ">
						<span><%=complaint.getComplaintDescription() %></span>
					</div>
				</div>
			</c:if>
					
			<c:if test='<%=Validator.isNotNull(complaint.getComplaintContent()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="complaint-content"/></div>
					<div class="complaint-content ">
						<span><%=complaint.getComplaintContent() %></span>
					</div>
				</div>
			</c:if>
								
			<c:if test='<%=!attachmentFileList.isEmpty() || Validator.isNotNull(complaint.getFileAttachmentURL()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="file-attachment"/></div>
					<div class="complaint-attachment ">
						
						<c:if test='<%=Validator.isNotNull(complaint.getFileAttachmentURL()) %>'>
							<a href="<%=complaint.getFileAttachmentURL()%>" title='<liferay-ui:message key="download"/>'>
								<liferay-ui:message key="attachments"/>
							</a>
							<br/>
						</c:if>
					
						<%
						for(DLFileEntry attachmentFile : attachmentFileList){
							
							String fileName = attachmentFile.getTitle();
							String fileSize = TextFormatter.formatKB(attachmentFile.getSize(), locale) + " KB";
							String fileDownloadLink = FileAttachmentUtil.createAttachmentDownloadLink(attachmentFile, themeDisplay);
						%>
							<a href="<%=fileDownloadLink%>" title='<liferay-ui:message key="download"/>'>
								<%= fileName %>
							</a>
							<span style="font-size: 10px;"><%="   (" + fileSize + ")" %></span>
							<br/>
						<%
						}
						%>
					</div>
				</div>
			</c:if>
			
		</div>
	</div>
</c:if>