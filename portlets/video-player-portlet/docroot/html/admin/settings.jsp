<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.bkav.portal.portlet.video.VideoFileSizeException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

%>

<liferay-portlet:actionURL name="updateVideoSettings" var="updateVideoSettingsActionURL">
	<liferay-portlet:param  name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:actionURL>

		
<liferay-ui:error exception="<%= VideoFileSizeException.class %>">
	<liferay-ui:message arguments="<%= PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE)/VideoConstants.FILE_SIZE_COEFFICENT %>" 
						key="video-upload-file-size-not-larger-than-x-MB" />
</liferay-ui:error>

<div class="video-form">
	<aui:form name="fm"  method="post" action="<%=updateVideoSettingsActionURL%>">
	
		<aui:fieldset title="video-upload-folder">		
		
			<liferay-ui:panel-container>	
				<liferay-ui:panel title="upload-folder" extended="true">				
					<aui:select name="videoFolderId" label="select-video-upload-folder">				
						<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
									selected="<%=(videoFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>"
						/>					
						<%
						for(DLFolder dlFolder : dlFolderList){
							
						%>
							<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
										selected="<%=dlFolder.getFolderId() == videoFolderId%>"
										
							/>
							
						<%
							buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, videoFolderId);
						}
						%>					
					</aui:select>
					<aui:button name="addNewDLFolderBtn" value="create-new-folder"/>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
				
			<liferay-ui:panel-container>	
				<liferay-ui:panel title="video-upload-file" extended="true">	
					<aui:input name="videoExtensions" value="<%=videoExtensions %>"/>
					<aui:input name="videoMaxSize" value="<%=videoMaxSize %>"/>	
				</liferay-ui:panel>
			</liferay-ui:panel-container>
					
			<liferay-ui:panel-container>	
				<liferay-ui:panel title="image-thumbnail" extended="true">	
					<aui:input name="imageThumbnailExtensions" value="<%=imageThumbnailExtensions %>"/>
					
					<aui:input name="imageThumbnailMaxSize" value="<%=imageThumbnailMaxSize %>"/>			
				</liferay-ui:panel>
			</liferay-ui:panel-container>
			
			<aui:button-row>
				<aui:button type="submit" value="save"/>
			</aui:button-row>
		</aui:fieldset>
	</aui:form>
</div>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var addNewDLFolderBtn = A.one('#<portlet:namespace/>addNewDLFolderBtn');
		
		if(addNewDLFolderBtn){
			
			addNewDLFolderBtn.on('click',function(){

				var addNewFolderURL = Liferay.PortletURL.createRenderURL();
											
				addNewFolderURL.setPortletId('<%=videoAdminPortletResource %>');
				addNewFolderURL.setWindowState('pop_up');
				addNewFolderURL.setParameter('jspPage', '/html/admin/add_video_folder.jsp');
				addNewFolderURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-video-folder'),
					uri: addNewFolderURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
	});
				
	Liferay.provide(
		window,
		'refresh',
		function(){
			Liferay.Portlet.refresh('#p_p_id_videoadmin_WAR_videoplayerportlet_');
		}
	);
</aui:script>
