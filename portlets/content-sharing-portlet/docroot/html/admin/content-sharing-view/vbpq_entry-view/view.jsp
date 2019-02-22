<%@page import="com.bkav.portal.portlet.contentsharing.util.vbpq.VBPQUtil"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.vbpq.FileAttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@include file="/html/admin/init.jsp"%>
<%
	long vbpqEntryId = ParamUtil.getLong(request, "objectId",0L);
	
	String vbpqFileAttachmentURL = "";	

	VBPQ_Entry vbpqEntry = null;
	
	List<DLFileEntry> fileAttachmentList = new ArrayList<DLFileEntry>();
	
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
			<%=HtmlUtil.stripHtml(vbpqEntry.getEntryName()) %>
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
							
							String fileAttachmentSize = TextFormatter.formatKB(fileAttachment.getSize(), 
									PortalUtil.getLocale(request)) + " KB";
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
					<td><%=dateFormat.format(vbpqEntry.getModifiedDate()) %></td>
				</tr>
				<tr>	
					<td><liferay-ui:message key="last-modified-user"/></td>		
					<td><%=vbpqEntry.getUserName() %></td>
				</tr>
			</table>
		</div>
		
		<div class="aui-button-holder">
			<aui:button value="update" name="updateVBPQBtn" />
			<aui:button value="close" name="closePopupBtn"/>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
	
		var updateVBPQBtn = A.one('#<portlet:namespace/>updateVBPQBtn');
				
		if(updateVBPQBtn){
			
			updateVBPQBtn.on('click',function(){

				Liferay.Util.getOpener().showVBPQUpdateForm('<%=vbpqEntryId %>');
				
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
