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
			
			relatedVBPQList = VBPQUtil.getRelatedEntries(groupId, vbpqEntryId, relatedVBPQFilter, numbersOfRelatedEntries);
			
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
							<a href="<%=fileAttachmentDownloadLink%>" download="<%=fileAttachment.getTitle()%>" title='<liferay-ui:message key="download"/>'>
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
	<c:if test="<%=displayRelatedEntries  && (relatedVBPQList.size() > 0)%>">
		
		<div class="vbpq-related-entries">
			<div class="related-title">
				<span><liferay-ui:message key="related-vbpq-entries"/></span>
			</div>

			<div class="related-entry-list">
				<ul>
					<%
						for(VBPQ_Entry relatedEntry : relatedVBPQList){
							
							StringBundler sb = new StringBundler();
		
							sb.append("javascript:");
							sb.append("showVBPQPreviewDialog");
							sb.append("('");
							sb.append(relatedEntry.getEntryId());
							sb.append("')");
		
							String	viewRelatedEntryURL = sb.toString();
					%>
														
							<li>	  		  
					  		    <a href="<%= viewRelatedEntryURL%>" title='<liferay-ui:message key="view"/>'>
					  		    	<%=relatedEntry.getEntryName()%>
					  		    </a>
					  		  	
					  		  	<c:if test='<%=Validator.isNotNull(relatedEntry.getPublishDate()) %>'>  		  				
									<span class="related-entry-publish-date">
										(<%=dateFormat.format(relatedEntry.getPublishDate()) %>)
									</span>
					  		  	</c:if>
					  		  	<span style="display: block; clear: both;"></span>	
						    </li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</c:if>
</c:if>

<script type="text/javascript">
	Liferay.provide(
		window,
		'showVBPQPreviewDialog',
		function(vbpqEntryId) {
			
			var A = AUI();
			
			A.DialogManager.hideAll();
			
			var vbpqPreviewRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(vbpqPreviewRenderURL){
				
				vbpqPreviewRenderURL.setPortletId('<%=portletId %>');
				vbpqPreviewRenderURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				vbpqPreviewRenderURL.setParameter('jspPage', '/html/view/vbpq_relate_preview.jsp');
				vbpqPreviewRenderURL.setParameter('vbpqEntryId', vbpqEntryId);
				vbpqPreviewRenderURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '.vbpq_search_form_wrapper',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					id: '<portlet:namespace/>vbpqRelatePreviewDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "vbpq-preview-content") %>',
					uri: vbpqPreviewRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe','aui-base']
	);
</script>
