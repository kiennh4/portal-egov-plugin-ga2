<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.permission.TTHCEntryPermission"%>
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

<%@include file="/html/init.jsp"%>

<liferay-portlet:renderURL var="tthcAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/tthc_admin/tthc_admin.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:header title="select-tthc-upload-folder" backURL="<%=tthcAdminURL%>" />

<c:choose>
	<c:when test="<%=TTHCEntryPermission.contains(permissionChecker, scopeGroupId, TTHCEntryPermission.FILE_ATTACHMENT_CONFIG) %>">		
		<%	
			PortletPreferences preferences = PortalUtil.getPreferences(request);
		
			String portletResource = ParamUtil.getString(request,"portletResource");
			
			if (Validator.isNotNull(portletResource)) {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
			}
			
			//Id folder cha
			long tthcAttachmentFolderId = GetterUtil.getLong(preferences.getValue("tthcAttachmentFolderId", "0"));
			
			//Tu dong tao folder chua file dinh kem cho moi thu tuc
			boolean autoCreateSubFolder = GetterUtil.getBoolean(preferences.getValue("autoCreateSubFolder", "true"));
			
			//Truy van tat ca cac folder hien co trong document library
			List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(scopeGroupId, TTHCConstants.DL_ROOT_FOLDER_ID);	
		%>
		
		<liferay-portlet:actionURL name="updateTTHCSettings"   var="updateTTHCSettingsURL">
			<liferay-portlet:param  name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-ui:error key="duplicate-folder-name" message="duplicate-folder-name"/>
		
		<div class="tthc-upload-settings" >
			
			<aui:form name="tthc_settings_form" method="post" action="<%=updateTTHCSettingsURL %>">
				
				<div class="lfr-form-row lfr-form-row-inline">
					<aui:select name="tthcAttachmentFolderId" label="select-folder">				
						<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
									selected="<%=(tthcAttachmentFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>"
						/>					
						<%
						for(DLFolder dlFolder : dlFolderList){
							
						%>
							<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
										selected="<%=dlFolder.getFolderId() == tthcAttachmentFolderId%>"
										
							/>
							
						<%
							buildDLFolderTree(scopeGroupId, dlFolder.getFolderId(),1, out, tthcAttachmentFolderId);
						}
						%>					
					</aui:select>
					
					<aui:button name="addNewDLFolderBtn" value="create-new-folder"/>
				</div>
				
				<div id="<portlet:namespace/>createFolderPanelWrapper" class="creat-folder-panel aui-helper-hidden">
							
					<aui:select name="parentFolderId" label="select-parent-upload-folder">				
						<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select"/>					
						<%
						for(DLFolder dlFolder : dlFolderList){
							
						%>
							<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>"/>
							
						<%
							buildDLFolderTree(scopeGroupId, dlFolder.getFolderId(),1, out, 0);
						}
						%>					
					</aui:select>
				
					<aui:input type="text" name="folderName"/>
				</div>	
								
				<div class="aui-button-holder">	
					<aui:button type="submit" value="save"/>
					<aui:button type="button" value="cancel" href="<%=tthcAdminURL %>"/>	
				</div>	
				<aui:input type="checkbox" name="autoCreateSubFolder" value="<%=autoCreateSubFolder %>" label="auto-create-upload-folder-for-each-tthc-entry"/>		
			</aui:form>
		</div>
	</c:when>
	
	<c:otherwise>
		<span class="permission_required_message">
			<liferay-ui:message key="[SYSTEM] you-do-not-have-permission-to-access-this-page.Please-contact-portal-administrator-for-this-permission!"/>
		</span>		
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	
	AUI().ready('aui-base','aui-form-validator','aui-overlay-context-panel',function(A){
		
		var addNewDLFolderBtn = A.one('#<portlet:namespace />addNewDLFolderBtn');
		
		var createFolderPanelWrapper = A.one('#<portlet:namespace/>createFolderPanelWrapper');
		
		if(addNewDLFolderBtn){
			
			addNewDLFolderBtn.on('click',function(){
				
				if(createFolderPanelWrapper.hasClass('aui-helper-hidden')){
					
					createFolderPanelWrapper.show();
					
					var folderNameInput = A.one('#<portlet:namespace/>folderName');
					
					folderNameInput.focus();
				
				}else{
					createFolderPanelWrapper.hide();
				}
			});
		}
		
		window.validator = new A.FormValidator({

	        boundingBox: document.<portlet:namespace />tthc_settings_form,
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