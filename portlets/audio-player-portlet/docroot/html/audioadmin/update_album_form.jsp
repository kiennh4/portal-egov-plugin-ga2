<%@page import="com.liferay.taglib.aui.AUIUtil"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AudioPermission"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AlbumPermission"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/html/js/liferay/service.js" language="JavaScript"></script>
<%@include file="/html/audioadmin/init.jsp"%>

<%
	long fileAttachmentMaxSize = GetterUtil.getLong(preferences.getValue("audioMaxSize",
		String.valueOf(audioConstants.DEFAULT_AUDIO_MAX_SIZE)));


	long albumId = ParamUtil.getLong(request, "albumId");

	AudioAlbum album = null;
	
	String albumCoverImage = "";
	
	
	
	if(albumId > 0){
		
		album = AudioAlbumLocalServiceUtil.getAudioAlbum(albumId);
		if (album!=null)
		{
			long albumCoverId = album.getAlbumCoverId();
			albumCoverImage = themeDisplay.getPathImage() + "/logo?img_id=" 
								+ albumCoverId + "&t" + WebServerServletTokenUtil.getToken(albumCoverId);
			
		}
	}
	
	String redirect = ParamUtil.getString(request, "redirect",albumAdminHomePageURL.toString());
	
	boolean closeDialog = false;
	
	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

	String portletInstanceResource = ParamUtil.getString(request, "portletInstanceResource");
	
	Date fileExpirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
			null, fileExpirationDate, new ServiceContext());
	
	
	
	if(Validator.isNotNull(portletInstanceResource)){
		redirect = PortalUtil.getCurrentURL(request);
	}
	
	if(SessionErrors.isEmpty(portletRequest) && !SessionMessages.isEmpty(portletRequest) && Validator.isNotNull(portletInstanceResource)){
		closeDialog = true;
	}
	
	String uploadImageStr = "/audio-player-portlet/css/icon/upload.ico";
%>

<c:if test="<%=closeDialog%>">
	<aui:script use="aui-base">
		 closeAndRefreshPopup();
	</aui:script>
</c:if>

<liferay-portlet:actionURL portletName="<%=audioplayerAdminPortletId %>"  name="updateAlbum" var = "updateAlbumActionURL">
	<liferay-portlet:param name="albumId" value="<%=String.valueOf(albumId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
	<portlet:param name="struts_action" value="document_library/edit_file_entry" />								
	<portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="addTempAudioFileURL" name="addTempAudioFile" doAsUserId="<%=userId %>">			
	<portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
	<portlet:param name="folderId" value="<%= String.valueOf(audioFolderId) %>" />
</liferay-portlet:actionURL>
							
<liferay-portlet:actionURL doAsUserId="<%= userId %>" var="deleteTempAudioFileURL" name="deleteTempAudioFile">
			<portlet:param name="struts_action" value="/document_library/edit_file_entry" />				
			<portlet:param name="folderId" value="<%= String.valueOf(audioFolderId) %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(groupId) %>" />
</liferay-portlet:actionURL>

<liferay-portlet:renderURL portletConfiguration="true" var="updateAudioUrl" windowState="<%= LiferayWindowState.POP_UP.toString() %>" >
	<liferay-portlet:param name="jspPage" value="/html/audioadmin/update_audio_form.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="listAudioFileUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/audioadmin/list_audio_file.jsp"/>
</liferay-portlet:renderURL>

<div class="album-admin-form">
	<c:choose>
	
		<c:when test='<%= SessionMessages.contains(renderRequest, "album-saved-successfully") %>'>
			<aui:script>
				Liferay.Util.getOpener().refresh();
				Liferay.Util.getWindow().close();
			</aui:script>
		</c:when>
		<c:otherwise>
		<aui:form name="album_update_form" enctype="multipart/form-data" method="post" action="<%=updateAlbumActionURL %>">
			
			<table style = "width:100%;">
				<tr>
					<td width = "50%">
						<aui:model-context bean="<%= album %>" model="<%= AudioAlbum.class %>" />
						
						<aui:input name="albumName" style = "width: 200px" type = "text">
							<aui:validator name="required" />
						</aui:input>
						<aui:input name="albumInfo" style = "width: 200px"  type = "textarea">
						</aui:input>
					</td>
					<td width = "50%">
						<div class="<portlet:namespace/>image-upload">
						<b><liferay-ui:message key="image-cover"/></b> (<liferay-ui:message key="click-image-to-choose-cover"/>)
						<br>
							<div class="portlet-msg-error" id = "<portlet:namespace/>image-extensions-error" style = "display:none;">
									<span><liferay-ui:message  key="image-cover-extensions-error" /></span>
							</div>
							<div class="portlet-msg-error" id = "<portlet:namespace/>image-size-error"  style = "display:none;">
									<span><liferay-ui:message arguments="<%=imageCoverMaxSize %>" key="image-cover-size-error-x" /></span>
							</div>		
							<input type="file" name="albumCoverFile" accept="image/*" id = "<portlet:namespace/>albumCoverInput" style = "display:none;" />
						    <label for="<portlet:namespace/>albumCoverInput">
						        <img width = "40px" height = "40px" src="<%= album != null ? AudioUtil.getAlbumCoverPath(request, album.getAlbumCoverId()) : uploadImageStr%>"/>
						    </label> 
						</div>
					</td>
				</tr>
			</table>
			
			 <b style = "float:left;"><liferay-ui:message key="selected-audio"/></b>
			 <div class = "selected-audio-class" id = "<portlet:namespace/>selected-audio" style = "width:100%;height:150px;overflow:auto;background:#61C5F0">
			 	<c:choose>
			 		<c:when test="<%=Validator.isNotNull(album) %>">
			 			<%
			 				List<AudioFile> audioList = AudioUtil.getListAudioByAlbumId(album.getAlbumId());
			 				if (Validator.isNotNull(audioList))
			 				for (int i = 0;i<audioList.size();i++)
			 				{
			 			%>
			 				<div id = "<portlet:namespace/>audio-selected-item-<%= audioList.get(i).getAudioId()  %>"  class = "audio-selected-item-class" >
			 					<span style = "width: 90%;"><%=audioList.get(i).getAudioName() %></span>
			 					<a style = "float:right" href = "javascript:;" class = "<portlet:namespace/>remove-audio-item ltf-button delete-button" onclick = "<portlet:namespace/>removeSelectedAudio(<%= audioList.get(i).getAudioId() %>)">
			 						<img src = "/audio-player-portlet/css/icon/remove_album.png"/>
			 					</a>
			 				</div>
			 				<input class = "<portlet:namespace/>audio-file-selected audio-file-selected-<%=audioList.get(i).getAudioId() %>" type="hidden" name="listAudioSelected" value='<%= audioList.get(i).getAudioId() %>'/>
			 			<%
			 				}
			 			%>
			 		</c:when>
			 	</c:choose>
			 </div>
			 
			 <div>
			 	<aui:button type = "button" name = "chooseExistAudioBtn" value = "choose-audio" style = "margin:10px;" />

				
			</div>
			<div class="audio-file-uploader">
					
					<div class="portlet-msg-info">
						<span><liferay-ui:message arguments="<%= String.valueOf(fileAttachmentMaxSize) %>" key="please-select-file-with-file-size-no-larger-than-x-mb" /></span>
						<br/>
						<span><liferay-ui:message arguments="<%= audioExtensions %>" key="audio-file-extension-x" /></span>
					</div>
					
					<div class="lfr-dynamic-uploader" style = "max-height:200px;overflow:auto;">
						<div id="audioUploadBtn"></div>
						<div class="lfr-upload-container" id="<portlet:namespace />audioFileUpload"></div>
					</div>
						
					<span id="<portlet:namespace />selectedFileNameContainer"></span>
													
					<div style="clear: both;"></div>
			</div>
			<aui:input type="hidden" name="albumCoverId" value='<%= album != null ? album.getAlbumCoverId() : CounterLocalServiceUtil.increment() %>'/>
											
			<aui:button-row>
				<aui:button name="submitAlbumBtn" value="save"/>
				<aui:button name="closeFormBtn" value="cancel"/>
			</aui:button-row>
			
		</aui:form>
			<aui:script use="liferay-upload">
			new Liferay.Upload(
				{
					allowedFileTypes: '<%= audioExtensions /*StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA))*/ %>',
					container: '#<portlet:namespace />audioFileUpload',
					fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
					maxFileSize: <%= fileAttachmentMaxSize %>*1024,
					namespace: '<portlet:namespace />',
					buttonPlaceHolderId :'audioUploadBtn',
					tempFileURL: {
						method: Liferay.Service.DL.DLApp.getTempFileEntryNames,
						params: {
								groupId: <%= groupId %>,
								folderId: <%= audioFolderId %>,
								tempFolderName: 'com.bkav.portal.portlet.audioplayer.AudioAdmin'
						}
					},
					uploadFile: '<%=addTempAudioFileURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
					deleteFile: '<%=deleteTempAudioFileURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
								
				}
			);
			</aui:script>
<liferay-ui:success key="saved" message="album-saved-successfully" />
<liferay-ui:success key="deleted" message="album-deleted" />
<liferay-ui:success key="updated" message="album-updated" />

<aui:script >
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel','liferay-portlet-url',function(A){
		//function fill audio upload vao input hidden
		Liferay.provide(
				window,
				'<portlet:namespace />prepareUpdateAudio',
				function() {
					
					var A = AUI();
					
					var Lang = A.Lang;
					
					var selectedFileNameContainer = A.one('#<portlet:namespace />selectedFileNameContainer');
					
					var inputTpl = '<input id="<portlet:namespace />selectedFileName{0}" name="<portlet:namespace />selectedFileName" type="hidden" value="{1}" />';
			
					var values = A.all('input[name=<portlet:namespace />selectUploadedFileCheckbox]:checked').val();
					
					var uploadFileAttachment = A.one('.select-file');

					if(uploadFileAttachment){
						
						var buffer = [];
						var dataBuffer = [];
						var length = values.length;
						
						for (var i = 0; i < length; i++){
							
							dataBuffer[0] = i;
							
							var selectedFileName = values[i].replace(/[\,\r]/gm, '');
							
							dataBuffer[1] = selectedFileName;
							
							buffer[i] = Lang.sub(inputTpl, dataBuffer);
						}
						
						selectedFileNameContainer.html(buffer.join(''));
					}
				},
			['aui-base']
		);
		
		//function xoa Audio da chon
		Liferay.provide(
			window,
			'<portlet:namespace/>removeSelectedAudio',
			function(audioId) {
				
				A.one ('#<portlet:namespace/>audio-selected-item-'+audioId).remove();
				
				A.all ('.audio-file-selected-'+audioId).remove();
			});
		
		//function refresh 
		Liferay.provide(
		window,
		'refresh',
		function(){
			<portlet:namespace/>showSelectAudio();
		});
		
		Liferay.provide(
		window,
		'getSelectedAudio',
		function(data){
			
			for (var i = 0;i< data.length ;i++)
			{
				var itemHtml = '';
				itemHtml += '<div id = "<portlet:namespace/>audio-selected-item-'+data[i].audioId+'"  class = "audio-selected-item-class" >';
				itemHtml += '<span style = "width: 90%;">'+data[i].audioName+'</span>';
				itemHtml += '<a style = "float:right" href = "javascript:;" class = "<portlet:namespace/>remove-audio-item ltf-button delete-button" onclick = "<portlet:namespace/>removeSelectedAudio('+data[i].audioId+')">';
				itemHtml += '<img src = "/audio-player-portlet/css/icon/remove_album.png"/></a></div>';
				itemHtml += '<input class = "<portlet:namespace/>audio-file-selected audio-file-selected-'+data[i].audioId+'" type="hidden" name="listAudioSelected" value="'+data[i].audioId+'"/>';
				A.one ('#<portlet:namespace/>selected-audio').append(itemHtml);
			}
		});
		
		//function show audio dc chon
		Liferay.provide(
		window,
		'<portlet:namespace/>showSelectAudio',
		function(audioId,albumId){
			
			var selectedAudioFile = '';
			
			A.all ('.<portlet:namespace/>audio-file-selected').each (function(){
				selectedAudioFile += this.getAttribute('value')+',';
			});	

			var selectAudioUrl = Liferay.PortletURL.createRenderURL();
			 						
			selectAudioUrl.setPortletId('<%=audioplayerAdminPortletId %>'); 
			selectAudioUrl.setWindowState('pop_up');
			selectAudioUrl.setParameter('jspPage', '/html/audioadmin/list_audio_file.jsp');
			selectAudioUrl.setParameter('albumId', <%=albumId %>);
			selectAudioUrl.setParameter('selectedAudio', selectedAudioFile);
			selectAudioUrl.setDoAsGroupId('<%=groupId %>');
			
			
					
						
			var dialogWidow = {
				dialog: {
					centered: false,
					modal: true,
					width: 400,
					height:450,
					draggable: true,
        			resizable: false,
					cache: false
				},
				id: '<portlet:namespace/>audioSelectForm_1',
				title: '<liferay-ui:message key="audio-info" />',
				uri: selectAudioUrl
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		});
		
		//function show form upload audio
		Liferay.provide(
		window,
		'<portlet:namespace/>showUpdateAudio',
		function(audioId,albumId){

			var updateAudioUrl_ = Liferay.PortletURL.createRenderURL();
			 						
			updateAudioUrl_.setPortletId('<%=audioplayerAdminPortletId %>'); 
			updateAudioUrl_.setWindowState('pop_up');
			updateAudioUrl_.setParameter('jspPage', '/html/audioadmin/update_audio_form.jsp');
			updateAudioUrl_.setParameter('audioId', audioId);
			updateAudioUrl_.setParameter('albumId', <%=albumId %>);
			updateAudioUrl_.setDoAsGroupId('<%=groupId %>');
					
					
						
			var dialogWidow = {
				dialog: {
					centered: false,
					modal: true,
					width: 500,
					height:650,
					draggable: true,
        			resizable: false,
					cache: false
				},
				id: '<portlet:namespace/>audioDetailForm_1',
				title: '<liferay-ui:message key="audio-info" />',
				uri: updateAudioUrl_
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		});
		
		//function show form chon audio co san
		Liferay.provide(
		window,
		'<portlet:namespace/>showSelectAudio',
		function(audioId,albumId){
			
			var selectedAudioFile = '';
			
			A.all ('.<portlet:namespace/>audio-file-selected').each (function(){
				selectedAudioFile += this.getAttribute('value')+',';
			});	

			var selectAudioUrl = Liferay.PortletURL.createRenderURL();
			 						
			selectAudioUrl.setPortletId('<%=audioplayerAdminPortletId %>'); 
			selectAudioUrl.setWindowState('pop_up');
			selectAudioUrl.setParameter('jspPage', '/html/audioadmin/list_audio_file.jsp');
			selectAudioUrl.setParameter('albumId', <%=albumId %>);
			selectAudioUrl.setParameter('selectedAudio', selectedAudioFile);
			selectAudioUrl.setDoAsGroupId('<%=groupId %>');
			
			
					
						
			var dialogWidow = {
				dialog: {
					centered: false,
					modal: true,
					width: 400,
					height:450,
					draggable: true,
        			resizable: false,
					cache: false
				},
				id: '<portlet:namespace/>audioSelectForm_1',
				title: '<liferay-ui:message key="audio-info" />',
				uri: selectAudioUrl
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		});
		
		//function check file size
		function GetFileSize(fileid) {
		 try {
		 var fileSize = 0;
		 //for IE
		 if (navigator.userAgent.toLowerCase().indexOf('msie')>=0) {
		 //before making an object of ActiveXObject, 
		 //please make sure ActiveX is enabled in your IE browser
			 var objFSO = new ActiveXObject("Scripting.FileSystemObject"); 
			 var filePath = document.getElementById("#" + fileid).value;
			 var objFile = objFSO.getFile(filePath);
			 var fileSize = objFile.size; //size in kb
			 fileSize = fileSize / 1048576; //size in mb 
		 }
		 //for FF, Safari, Opeara and Others
		 else {
			 fileSize = document.getElementById(''+fileid).files[0].size //size in kb
			 fileSize = fileSize / 1048576; //size in mb 
		 }
		    return fileSize;
		 }
		 catch (e) {
		 	return -1;
		 }
		}
		
		//function validate album name
		
		var albumNameInput = A.one('#<portlet:namespace/>albumName');
		
		if(albumNameInput){
			albumNameInput.focus();
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />album_update_form,
	
	        rules: {
	           
	            <portlet:namespace />albumName: {
	                required: true,
	                rangeLength: ['3','300']
	            }
	 
	        }
	    });
		
		//su kien click close form
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
		
		//su kien click button upload audio
		//A.one('#<portlet:namespace/>uploadAudioBtn').on('click',function(){
		//	
		//	<portlet:namespace/>showUpdateAudio();
		//});
		
		//su kien click button chon audio
		A.one ('#<portlet:namespace/>chooseExistAudioBtn').on('click',function(){
			<portlet:namespace/>showSelectAudio();
		});
		
		//su kien click button save
		A.one('#<portlet:namespace/>submitAlbumBtn').on('click',function(){
			
			var albumName = A.one('#<portlet:namespace/>albumName').attr('value');
			
			if ((albumName.length<3)||(albumName.length>100))
			{
				A.one('#<portlet:namespace/>albumName').focus();
				return false;
			}
			
			var size  = GetFileSize('<portlet:namespace/>albumCoverInput');
			if (size==-1)
			{
				<portlet:namespace />prepareUpdateAudio();
				document.getElementById("<portlet:namespace/>album_update_form").submit();
			}
			else
			{
				var fileType = document.getElementById('<portlet:namespace/>albumCoverInput').files[0].type;
				fileType = fileType.substring (fileType.indexOf('/')+1,fileType.length)
				var fileExtension = '<%=imageCoverExtensions %>';
				if (size > <%=imageCoverMaxSize %>)
				{
					A.one('#<portlet:namespace/>image-size-error').setStyle('display','block');
					return false;
				}
				else
					if (fileExtension.indexOf(fileType)<0)
					{
						A.one('#<portlet:namespace/>image-extensions-error').setStyle('display','block');
						return false;
					}
				else
				{
					<portlet:namespace />prepareUpdateAudio();
					A.one('#<portlet:namespace/>image-extensions-error').setStyle('display','none');
					A.one('#<portlet:namespace/>image-size-error').setStyle('display','none');
					document.getElementById("<portlet:namespace/>album_update_form").submit();
				}
			}
		});		
		
		
	});
			
</aui:script>
</c:otherwise>
</c:choose>
</div>