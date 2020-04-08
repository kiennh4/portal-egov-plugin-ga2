<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.ykct.service.impl.YKCT_CategoryLocalServiceImpl"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Category"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.ykct.util.FileAttachmentUtil"%>
<%@page import="com.portal_egov.portlet.ykct.service.YKCT_EntryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.ykct.model.YKCT_Entry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/ykct/init.jsp"%>

<%
long ykctEntryId = ParamUtil.getLong(request, "ykctEntryId", 0L);

String ykctFileAttachmentURL = "";

YKCT_Entry ykctEntry = null;

List<DLFileEntry> fileAttachmentList = new ArrayList<DLFileEntry>();

if(ykctEntryId > 0){
	
	ykctEntry = YKCT_EntryLocalServiceUtil.fetchYKCT_Entry(ykctEntryId);
	
	if(ykctEntry != null){
		
		fileAttachmentList = FileAttachmentUtil.getYKCTFileAttachment(ykctEntryId);
		
		ykctFileAttachmentURL = ykctEntry.getFileAttachmentURL();
	}
}
%>

<c:if test="<%= ykctEntry != null %>">
	<%
	long categoryId = ykctEntry.getCategoryId();
	
	YKCT_Category ykctCategory = null;
	
	if(categoryId > 0){
	
		ykctCategory = YKCT_CategoryLocalServiceUtil.getYKCT_Category(categoryId);
	
	}
	
	%>
	<div class="ykct-preview-content">
		
		<div class="ykct-title">
			<%=HtmlUtil.stripHtml(ykctEntry.getEntryName()) %>
		</div>
		
		<div class="ykct-detail-content">
			<table>
				<tr>
					<td><liferay-ui:message key="ykct-category"/></td>
					<td><%= (ykctCategory != null) ? ykctCategory.getCategoryName() : "Ch&#432;a ph&#226;n lo&#7841;i"%></td>
				</tr>
				
				<tr class="last_ykct_attribute">
					<td><liferay-ui:message key="ykct-attachment-file" /></td>
					<td>
						<c:if test='<%=Validator.isNotNull(ykctFileAttachmentURL) %>'>
							<a href="<%=ykctFileAttachmentURL%>" title='<liferay-ui:message key="download"/>'>
								<%= ykctEntry.getEntryId()%>
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
				
				<tr>
					<td><liferay-ui:message key="last-modified-date"/></td>		
					<td><%=dateTimeFormat.format(ykctEntry.getModifiedDate()) %></td>
				</tr>
				
				<tr>	
					<td><liferay-ui:message key="last-modified-user"/></td>		
					<td><%=ykctEntry.getUserName() %></td>
				</tr>
			</table>
		</div>
		
		<div class="aui-button-holder">
			<aui:button value="update" name="updateYKCTBtn" />
			<aui:button value="close" name="closePopupBtn"/>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
	
		var updateYKCTBtn = A.one('#<portlet:namespace/>updateYKCTBtn');
				
		if(updateYKCTBtn){
			
			updateYKCTBtn.on('click',function(){

				Liferay.Util.getOpener().showYKCTUpdateForm('<%=ykctEntryId %>');
				
				Liferay.Util.getWindow().close();
			});
		}
		
		var closePopupBtn = A.one('#<portlet:namespace/>closePopupBtn');
		
		if(closePopupBtn){
			
			closePopupBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</script>