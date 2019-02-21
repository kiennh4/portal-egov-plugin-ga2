<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.tthc.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_AttributeLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Attribute"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.tthc.TTHCFileAttachmentUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.bkav.portal.portlet.contentsharing.util.tthc.TTHCUtil"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Entry"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	//Id cua thu tuc lay tu URL
	long tthcEntryId = ParamUtil.getLong(request, "objectId",0L);

	TTHC_Entry tthcEntry = null;
	
	if(tthcEntryId > 0){
		tthcEntry = TTHC_EntryLocalServiceUtil.getTTHC_Entry(tthcEntryId);
	}
%>
		
<div class="tthc-preview">
	
	<c:if test='<%=Validator.isNotNull(tthcEntry) %>'>
	<c:choose>
		<c:when test='<%= SessionMessages.contains(renderRequest, "copy-success") %>'>
			   <div class="portlet-msg-success"><liferay-ui:message key="copy-success"/></div>
		</c:when>
		<c:when test='<%= SessionErrors.contains(renderRequest, "copy-error") %>'>
			   <div class="portlet-msg-success"><liferay-ui:message key="copy-error"/></div>
		</c:when>
	</c:choose>
	
	<liferay-portlet:actionURL portletName="<%=contentSharingAdminPortletId %>"  name="copyTTHC" 
								var = "copyTTHCActionURL">
			<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form action = "<%=copyTTHCActionURL %>" method = "post">
		<aui:input name="originTTHCId" type = "hidden" value = "<%=tthcEntry.getEntryId() %>"/>
		
		<div class="tthc-name" align="center">
			<span><%=tthcEntry.getEntryName() %></span>
		</div>
	
		<div id="<portlet:namespace/>contentTabs" class="tthc-content-tab">
      
			<ul id="<portlet:namespace/>tabListNode" class="aui-nav aui-nav-tabs">
				<li><a href="javascript:;"><liferay-ui:message key="tthc-infomation" /></a></li>
				<li><a href="javascript:;"><liferay-ui:message key="tthc-process-guide" /></a></li>
				<li><a href="javascript:;"><liferay-ui:message key="tthc-required-documents" /></a></li>
				<li><a href="javascript:;"><liferay-ui:message key="tthc-attachment-files" /></a></li>
				<li><a href="javascript:;"><liferay-ui:message key="tthc-vbpq" /></a></li>
			</ul>

			<div id="<portlet:namespace/>tabContentNode">
			
				<!-- GENERAL INFORMATION -->
			     <div class="aui-tabview-content-item">
					<table>	
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-entry-code" /></td>
					
							<td><%=tthcEntry.getEntryCode() %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-category" /></td>
					
							<td><%=TTHCUtil.getTTHCCategoryName(tthcEntry.getCategoryId()) %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-department" /></td>
					
							<td><%=TTHCUtil.getTTHCCategoryName(tthcEntry.getDepartmentId()) %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-audience" /></td>
					
							<td><%=TTHCUtil.getTTHCCategoryName(tthcEntry.getAudienceId()) %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-process-type" /></td>
					
							<td><%=tthcEntry.getProcessType() %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-process-time" /></td>
					
							<td><%=tthcEntry.getProcessTime() %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-process-fees" /></td>
					
							<td><%=tthcEntry.getProcessFee() %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-result-type" /></td>
					
							<td><%=TTHCUtil.getTTHCCategoryName(tthcEntry.getResultTypeId()) %></td>
						</tr>
						<tr>
							<td class="tthc_attribute_name"><liferay-ui:message key="tthc-foundation-content" /></td>
					
							<td><%=tthcEntry.getProcessFoundationDocument() %></td>
						</tr>
					</table>
			     </div>
			     
			     <!-- PROCESS GUIDE -->			
			     <div class="aui-tabview-content-item">
			     	<c:choose>
			     		<c:when test='<%=Validator.isNotNull(tthcEntry.getProcessGuide()) %>'>
			     			<span><%=tthcEntry.getProcessGuide() %></span>
			     		</c:when>
			     		
			     		<c:otherwise>
			     			<div class="portlet-msg-info">
			     				<span><liferay-ui:message key="process-guide-updating" /></span>
			     			</div>
			     		</c:otherwise>
			     	</c:choose>
			     </div>
			     
			     <!-- REQUIREMENTS -->		
			     <div class="aui-tabview-content-item">
			     	<c:choose>
			     		<c:when test='<%=Validator.isNotNull(tthcEntry.getProcessRequirement()) %>'>
			     			<span><%=tthcEntry.getProcessRequirement() %></span>
			     		</c:when>
			     		<c:otherwise>
			     			<div class="portlet-msg-info">
			     				<span><liferay-ui:message key="no-required-documents" /></span>
			     			</div>
			     		</c:otherwise>
			     	</c:choose>
			     </div>
			     
			     <!-- FILE ATTACHMENTS -->			
			     <div class="aui-tabview-content-item">
					
					<%
						List<DLFileEntry> tthcFileAttachmentList = TTHCFileAttachmentUtil.getTTHCAttachFiles(groupId, tthcEntryId);
					%>
								     
			     	<c:choose>
			     		<c:when test='<%=tthcFileAttachmentList.size() > 0 %>'>
							<div class="tthc_file_attachment_title">
								<span><liferay-ui:message key="tthc-file-attachment-list"/></span>
							</div>
							
							<div class="tthc_file_attachment_list">
								<table>
									<%
									for(DLFileEntry tthcFileAttachment : tthcFileAttachmentList){
										
										String fileName = tthcFileAttachment.getTitle();
										String fileSize = "(" + TextFormatter.formatKB(tthcFileAttachment.getSize(), PortalUtil.getLocale(request)) + " KB" + ")";
										String fileDownloadLink = TTHCFileAttachmentUtil.createAttachmentDownloadLink(tthcFileAttachment, themeDisplay);
									%>
										<tr>
											<td>
												<a href="<%=fileDownloadLink%>">
													<%=fileName %>
												</a>
												 &nbsp; <%=fileSize %>
											</td>
											<td>
												<span><liferay-ui:message key=""/></span>
											</td>
										</tr>
									<%
									}
									%>
								</table>
							</div>
			     		</c:when>
			     		<c:otherwise>
			     			<div class="portlet-msg-info">
			     				<span><liferay-ui:message key="no-file-attachments" /></span>
			     			</div>
			     		</c:otherwise>
					</c:choose>
			     </div>
			     
			     <!-- VBPQ MAPPING LIST -->			
			     <div class="aui-tabview-content-item">
					<%
						//List chua danh sach vbpq mapping voi thu tuc hien tai
						List<TTHC_Attribute> vbpqMappingAttributeList = 
							TTHC_AttributeLocalServiceUtil.findByTTHCEntryAndAttrTypeAndGroup(groupId, tthcEntryId,TTHCConstants.VBPQ_ID_ATTRIBUTE_TYPE_ID);
						
						//Danh sach VBPQ quy dinh thu tuc
						List<VBPQ_Entry> vbpqMappingList = new ArrayList<VBPQ_Entry>();
						
						for(TTHC_Attribute vbpqMappingAttribute : vbpqMappingAttributeList){
							
							long vbpqMappingId = GetterUtil.getLong(vbpqMappingAttribute.getAttributeValue(), 0L);
							
							if(vbpqMappingId > 0){
								
								VBPQ_Entry vbpqMapping = VBPQ_EntryLocalServiceUtil.getVBPQ_Entry(vbpqMappingId);
								
								if(vbpqMapping != null){
									
									vbpqMappingList.add(vbpqMapping);
								}
							}
						}
					%>
								     
			     	<c:choose>
			     		<c:when test='<%=vbpqMappingList.size() > 0 %>'>
							<ul>
								<%
								for(VBPQ_Entry vbpqMapping : vbpqMappingList){
									
									String vbpqName = vbpqMapping.getEntryName();
								%>
									<li>
										<a href="javascript:;">
											<%=vbpqName %>
										</a>
									</li>
								<%
								}
								%>
							</ul>
			     		</c:when>
			     		<c:otherwise>
			     			<div class="portlet-msg-info">
			     				<span><liferay-ui:message key="no-vbpq-matching-list" /></span>
			     			</div>
			     		</c:otherwise>
			     	</c:choose>
			     </div>
			</div>
    	</div>
	    	<center>
			<aui:button-row>
				<aui:button type = "submit" value = "copy"/>
				<aui:button name = "cancelCopy" value = "cancel"/>
			</aui:button-row>
			</center>
		</aui:form>
	</c:if>
</div>

<script type="text/javascript">

	AUI().ready('aui-tabs', 'substitute', function(A) {
		
		var contentTabs = new A.TabView({
			boundingBox : '#<portlet:namespace/>contentTabs',
			listNode : '#<portlet:namespace/>tabListNode',
			contentNode : '#<portlet:namespace/>tabContentNode'
		});
		
		contentTabs.render();
	});
</script>