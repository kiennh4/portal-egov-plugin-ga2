<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/audioadmin/init.jsp"%>

<%

List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

%>
		
<liferay-portlet:actionURL name="updateAudioSettings" var="updateAudioSettingsActionURL">
	<liferay-portlet:param  name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:actionURL>

<div class="audio-form">
	<aui:form name="fm"  method="post" action="<%=updateAudioSettingsActionURL%>">
	
		<aui:fieldset title="audio-upload-folder">		
		
			<liferay-ui:panel-container>	
				<liferay-ui:panel title="upload-folder" extended="true">				
					<aui:select name="audioFolderId" label="select-audio-upload-folder">				
						<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
									selected="<%=(audioFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>"
						/>					
						<%
						for(DLFolder dlFolder : dlFolderList){
							
						%>
							<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
										selected="<%=dlFolder.getFolderId() == audioFolderId%>"
										
							/>
							
						<%
							buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, audioFolderId);
						}
						%>					
					</aui:select>
					<aui:button name="addNewDLFolderBtn" value="create-new-folder"/>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
				
			<liferay-ui:panel-container>	
				<liferay-ui:panel title="audio-upload-file" extended="true">
					<div class="portlet-msg-info">
						<span><liferay-ui:message  key="audio-extensions-available" /></span>
					</div>	
					<aui:input name="audioExtensions" value="<%=audioExtensions %>"/>
					<aui:input name="audioMaxSize" value="<%=audioMaxSize %>"/>	
				</liferay-ui:panel>
			</liferay-ui:panel-container>
					
			<liferay-ui:panel-container>	
				<liferay-ui:panel title="image-cover" extended="true">	
					<aui:input name="imageCoverExtensions" value="<%=imageCoverExtensions %>"/>
					
					<aui:input name="imageCoverMaxSize" value="<%=imageCoverMaxSize %>"/>			
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
											
				addNewFolderURL.setPortletId('<%=audioplayerAdminPortletId %>');
				addNewFolderURL.setWindowState('pop_up');
				addNewFolderURL.setParameter('jspPage', '/html/audioadmin/add_audio_folder.jsp');
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
			Liferay.Portlet.refresh('#p_p_id_audioadmin_WAR_audioplayerportlet_');
		}
	);
</aui:script>
