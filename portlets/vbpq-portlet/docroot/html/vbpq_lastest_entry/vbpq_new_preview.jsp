<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.portal_egov.portlet.vbpq.util.FileAttachmentUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	long vbpqEntryId = ParamUtil.getLong(request, "vbpqEntryId",0L);
	
	String vbpqFileAttachmentURL = "";

	VBPQ_Entry vbpqEntry = null;
	
	List<DLFileEntry> fileAttachmentList = new ArrayList<DLFileEntry>();
	
	List<VBPQ_Entry> relatedVBPQList = new ArrayList<VBPQ_Entry>();
	
	if(vbpqEntryId > 0){
		
		vbpqEntry = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(vbpqEntryId);
		
		if(vbpqEntry != null){
			
			fileAttachmentList = FileAttachmentUtil.getVBPQFileAttachment(vbpqEntryId);
			
			vbpqFileAttachmentURL = vbpqEntry.getFileAttachmentURL();
		}
	}	
%>
	
<c:if test='<%=!Validator.isNull(vbpqEntry) %>'>

	<div class="vbpq-preview-content">
		
		<div class="vbpq-title">
			<%=vbpqEntry.getEntryName() %>
		</div>
		
		<div class="vbpq-detail-content">
			<table>
				<tr>			
					<td><liferay-ui:message key="entry-code"/></td>
					<td><%=vbpqEntry.getEntryCode() %></td>
				</tr>
				<tr>	
					<td><liferay-ui:message key="vbpq-department"/></td>		
					<td>
						<liferay-ui:message key="<%=VBPQUtil.getVBPQCategoryName(vbpqEntry.getDepartmentId()) %>"/>
					</td>
				</tr>
				<tr>	
					<td><liferay-ui:message key="vbpq-category-name"/></td>		
					<td>
						<liferay-ui:message key="<%=VBPQUtil.getVBPQCategoryName(vbpqEntry.getCategoryId()) %>"/>
					</td>
				</tr>
				<tr>	
					<td><liferay-ui:message key="vbpq-doctype-name"/></td>	
					<td>
						<liferay-ui:message key="<%=VBPQUtil.getVBPQCategoryName(vbpqEntry.getDocTypeId()) %>"/>
					</td>
				</tr>
				
				<c:if test="<%=vbpqEntry.getPublishDate() != null %>">
					<tr>	
						<td><liferay-ui:message key="vbpq-publish-date"/></td>		
						<td><%=dateFormat.format(vbpqEntry.getPublishDate()) %></td>
					</tr>
				</c:if>
				
				<c:if test="<%=vbpqEntry.getExecuteDate() != null %>">
					<tr>	
						<td><liferay-ui:message key="vbpq-execute-date"/></td>		
						<td><%=dateFormat.format(vbpqEntry.getExecuteDate()) %></td>
					</tr>
				</c:if>
				
				<c:if test='<%=!vbpqEntry.getNeverExpired() && vbpqEntry.getExpirationDate() != null%>'>
					<tr>	
						<td><liferay-ui:message key="vbpq-expired-date"/></td>		
						<td><%=dateFormat.format(vbpqEntry.getExpirationDate())%></td>
					</tr>
				</c:if>
				
				<tr class="last_vbpq_attribute">
					<td><liferay-ui:message key="vbpq-attachment-file"/></td>			
					<td>
										
						<c:if test='<%=Validator.isNotNull(vbpqFileAttachmentURL) %>'>
							<a href="<%=vbpqFileAttachmentURL%>" title='<liferay-ui:message key="download"/>'>
								<%= vbpqEntry.getEntryCode()%>
							</a> <br/>
						</c:if>
						
						<%
						for(int i = 0;i < fileAttachmentList.size(); i++)
						{
							DLFileEntry fileAttachment = fileAttachmentList.get(i);
							
							String fileAttachmentDownloadLink = FileAttachmentUtil.createAttachmentDownloadLink(fileAttachment, themeDisplay);
							
							String fileAttachmentSize = TextFormatter.formatKB(fileAttachment.getSize(), locale) + " KB";
						%>
							<a href="<%=fileAttachmentDownloadLink%>" title='<liferay-ui:message key="download"/>'>
								<%= fileAttachment.getTitle() + "(" + fileAttachmentSize + ")" %>
							</a> <br/>
						<%
						}
						%>
					</td>
				</tr>
			</table>
		</div>
	</div>
</c:if>