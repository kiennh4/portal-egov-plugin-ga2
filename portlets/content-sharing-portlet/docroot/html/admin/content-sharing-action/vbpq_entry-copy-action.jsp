<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
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
	
	List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	
%>
<liferay-portlet:actionURL portletName="<%=contentSharingAdminPortletId %>"  name="copyVbpq" 
							var = "copyVbpq">
		<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:actionURL>
<c:if test='<%=!Validator.isNull(vbpqEntry) %>'>

	<div class="vbpq-preview-content">
		
		<aui:form action = "<%=copyVbpq %>" method = "post">
			<aui:input type = "hidden" name="originGroupId" value = "<%=vbpqEntry.getGroupId() %>"/>
			<aui:input type = "hidden" name="originVbpqEntryId" value = "<%=vbpqEntry.getEntryId() %>"/>
			<aui:select name="folderId" label="select-file-copy-folder">				
				<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
				/>					
				<%
				for(DLFolder dlFolder : dlFolderList){
					
				%>
					<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
					/>
					
				<%
					buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, -1);
				}
				%>					
			</aui:select>
			<aui:button name="addNewDLFolderBtn" value="create-new-folder"/>
		
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
			<aui:button value="copy" name="copy" type = "submit" />
			<aui:button value="close" name="closePopupBtn"/>
		</div>
		</aui:form>
	</div>
</c:if>

<script type="text/javascript">
	AUI().ready('aui-base','liferay-portlet-url',function(A){

		var addNewDLFolderBtn = A.one('#<portlet:namespace/>addNewDLFolderBtn');
		
		if(addNewDLFolderBtn){
			
			addNewDLFolderBtn.on('click',function(){

				var addNewFolderURL = Liferay.PortletURL.createRenderURL();
											
				addNewFolderURL.setPortletId('<%=contentSharingAdminPortletId %>');
				addNewFolderURL.setWindowState('pop_up');
				addNewFolderURL.setParameter('jspPage', '/html/admin/content-sharing-action/add-new-folder.jsp');
				addNewFolderURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-folder'),
					uri: addNewFolderURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
		
		var closePopupBtn = A.one('#<portlet:namespace/>closePopupBtn');
		
		if(closePopupBtn){
			
			closePopupBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
	
	Liferay.provide(
		window,
		'refresh',
		function(){
		    location.reload();
		}
	);
	
</script>
<%!
	/**
	* Tao cay thu muc trong document media
	* parentFolderId - Id cua thu muc cha (mac dinh la thu muc Root)
	* treeLevel - Cap thu muc
	* selectedFolderId - Thu muc dang duoc chon de hien thi anh
	*/
	protected void buildDLFolderTree(long groupId,long parentFolderId,int treeLevel,JspWriter jspWriter,long selectedFolderId){
		
		try{
	
			//Lay danh sach thu muc con cap 1 tinh tu thu muc cha (theo parentFolderId)
			List<DLFolder> subFolderList = DLFolderLocalServiceUtil.getFolders(groupId, parentFolderId);
			
			if(subFolderList.size() > 0){
				
				for(DLFolder subFolder : subFolderList){
					
					String folderNamePrefix = "";
					
					if(treeLevel > 0){
						
						for(int i = 0; i< treeLevel; i++){
							
							folderNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					String subFolderName = folderNamePrefix + subFolder.getName();
					
					if(subFolder.getFolderId() == selectedFolderId){
						
						jspWriter.println("<option selected=\"selected\" value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
					}else{
						
						jspWriter.println("<option value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
					}
					
					int nextTreeLevel = treeLevel + 1;
					
					buildDLFolderTree(groupId, subFolder.getFolderId(), nextTreeLevel, jspWriter, selectedFolderId);
				}
			}
		}catch(Exception e){
			
		}
	}
%>