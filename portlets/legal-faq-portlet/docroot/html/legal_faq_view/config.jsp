<%@page import="com.portal_egov.portlet.legal_faq.util.LegalFAQConstants"%>
<%@page import="com.portal_egov.portlet.legal_faq.permission.LegalFAQEntryPermission"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/legal_faq_view/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="legalFAQCategoriesConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>
		<%	
			//Truy van tat ca cac folder hien co trong document library
			List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, LegalFAQConstants.DL_ROOT_FOLDER_ID);	
		%>
		
		<liferay-portlet:actionURL name="savePortletConfig" var="savePortletConfigURL">
			<liferay-portlet:param  name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-ui:error key="duplicate-folder-name" message="duplicate-folder-name"/>
		
		<div class="legal-faq-settings-form" >
			
			<aui:form name="legal_faq_settings_form" method="post" action="<%=savePortletConfigURL %>">
				
				<div class="lfr-form-row lfr-form-row-inline">
					<aui:select name="legalFaqAttachmentFolderId" label="select-folder">				
						<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
									selected="<%=(legalFaqAttachmentFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>"
						/>					
						<%
						for(DLFolder dlFolder : dlFolderList){
							
						%>
							<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
										selected="<%=dlFolder.getFolderId() == legalFaqAttachmentFolderId%>"
										
							/>
							
						<%
							buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, legalFaqAttachmentFolderId);
						}
						%>					
					</aui:select>
					
					<aui:button name="addNewDLFolderBtn" value="create-new-folder"/>
				</div>
				
				<div class="creat-folder-panel aui-helper-hidden">
							
					<aui:select name="parentFolderId" label="select-parent-upload-folder">				
						<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select"/>					
						<%
						for(DLFolder dlFolder : dlFolderList){
							
						%>
							<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>"/>
							
						<%
							buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, 0);
						}
						%>					
					</aui:select>
				
					<aui:input type="text" name="folderName"/>
				</div>						
				
				<div class="aui-button-holder">
					<aui:button type="submit"/>
					<aui:button type="button" value="cancel"/>
				</div>	
			</aui:form>
		</div>

<aui:script use='aui-form-validator,aui-overlay-context-panel'>

</aui:script>

<script type="text/javascript">
	
	AUI().ready('aui-base','aui-form-validator','aui-overlay-context-panel',function(A){
		
		addNewDLFolderBtn = A.one('#<portlet:namespace />addNewDLFolderBtn');
		
		if(addNewDLFolderBtn){
			
			var createDLFolderPanel = A.all('.creat-folder-panel');
			
			if(createDLFolderPanel){
				
				addNewDLFolderBtn.on('click',function(){
					
					var panelDisplayStyle = createDLFolderPanel.getStyle('display');
					
					if(panelDisplayStyle == 'block'){
						
						createDLFolderPanel.hide();
					
					}else{
						createDLFolderPanel.show();
					}
				});
			}
		}
		
		window.validator = new A.FormValidator({

	        boundingBox: document.<portlet:namespace />legal_faq_settings_form,
	        rules: {
	            <portlet:namespace />folderName: {
	                required: false,
	                rangeLength: ['0','75']
	            }
	        }
	    });
	});
	
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