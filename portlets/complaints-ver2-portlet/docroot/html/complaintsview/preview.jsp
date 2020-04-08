<%@page import="com.bkav.portal.portlet.complaints.util.FileAttachmentUtil"%>
<%@page import="com.bkav.portal.portlet.complaints.service.ComplaintsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.complaints.model.Complaints"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/complaintsview/init.jsp"%>

<%
	long complaintId = ParamUtil.getLong(request, "complaintId");

	Complaints complaint = null;
	
	if(complaintId > 0){
		
		complaint = ComplaintsLocalServiceUtil.fetchComplaints(complaintId);
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
%>

<c:if test='<%=Validator.isNotNull(complaint) %>'>
	
	<%
	List<DLFileEntry> attachmentFileList = FileAttachmentUtil.getComplaintFileAttachments(complaintId);
	%>
	
	<div class="complaint-preview">
		
		<div class="complaint-detail">
		
			<c:if test='<%=Validator.isNotNull(complaint.getComplaintDesc()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="complaint-description"/></div>
					<div class="complaint-description ">
						<span><%=complaint.getComplaintDesc() %></span>
					</div>
				</div>
			</c:if>
			
			<c:if test='<%=Validator.isNotNull(complaint.getSigningDate()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="signing-date"/></div>
					<div class="complaint-description ">
						<span><%=sdf.format(complaint.getSigningDate()) %></span>
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
			
			<c:if test='<%=Validator.isNotNull(complaint.getComplaintContent()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="complaint-reply-document"/></div>
					<div class="complaint-content ">
						<span><%=complaint.getReplyDocument() %></span>
					</div>
				</div>
			</c:if>
								
			<c:if test='<%=(!attachmentFileList.isEmpty()) %>'>
				<div class="content-row">
					<div class="content-row-title"><liferay-ui:message key="file-attachment"/></div>
					<div class="complaint-attachment ">
						<%
						for(DLFileEntry attachmentFile : attachmentFileList){
							
							String fileName = attachmentFile.getTitle();
							String fileSize = TextFormatter.formatKB(attachmentFile.getSize(), PortalUtil.getLocale(request)) 
												+ " KB";
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