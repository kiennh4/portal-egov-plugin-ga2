<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AudioPermission"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AlbumPermission"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="com.liferay.portal.model.Ticket"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.TicketConstants"%>
<%@page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.*"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/html/js/liferay/service.js" language="JavaScript"></script>

<%@include file="/html/audioadmin/init.jsp"%>
<%
	long fileAttachmentMaxSize = GetterUtil.getLong(preferences.getValue("audioMaxSize",
			String.valueOf(audioConstants.DEFAULT_AUDIO_MAX_SIZE)));
	
	

	long audioId = ParamUtil.getLong(request, "audioId");
	
	AudioFile audio = null;
	
	long albumId = ParamUtil.getLong(request, "albumId");
	
	
	
	if(audioId > 0){
		
		audio = AudioFileLocalServiceUtil.getAudioFile(audioId);
		if (audio!=null)
		{
			long albumFileId = audio.getAudioFileId();
			
			
		}
	}
	
	AudioAlbum album_ = AudioAlbumLocalServiceUtil.getAudioAlbum(albumId);
	
	Date fileExpirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), userId, TicketConstants.TYPE_IMPERSONATE, 
			null, fileExpirationDate, new ServiceContext());
	
	
	String redirect = ParamUtil.getString(request, "redirect",albumAdminHomePageURL.toString());
	
	boolean closeDialog = false;
	
	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
	
	String portletInstanceResource = ParamUtil.getString(request, "portletInstanceResource");
	
	
	if(Validator.isNotNull(portletInstanceResource)){
		redirect = PortalUtil.getCurrentURL(request);
	}
	
	if(SessionErrors.isEmpty(portletRequest) && !SessionMessages.isEmpty(portletRequest) && Validator.isNotNull(portletInstanceResource)){
		closeDialog = true;
	}
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitAdioUpdateForm();";
%>

<c:if test="<%=closeDialog%>">
	<aui:script use="aui-base">
		 closeAndRefreshPopup();
	</aui:script>
</c:if>

<liferay-portlet:actionURL portletName="<%=audioplayerAdminPortletId %>"  name="addAudio" var = "updateAudioActionURL">
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
<c:choose>
	<c:when test='<%= SessionMessages.contains(renderRequest, "audio-saved-successfully") %>'>
				<aui:script>
					Liferay.Util.getOpener().refresh();
					
					Liferay.Util.getWindow().close();
				</aui:script>
	</c:when>
</c:choose>
<div class = "admin-update-form">
	<aui:form method="post" name="audio_update_form" action="<%=updateAudioActionURL %>" onSubmit="<%=taglibOnSubmit %>">
		<div class="audio-file-uploader">
					
					<div class="portlet-msg-info">
						<span><liferay-ui:message arguments="<%= String.valueOf(fileAttachmentMaxSize) %>" key="please-select-file-with-file-size-no-larger-than-x-mb" /></span>
					</div>
					<div class="portlet-msg-info">
						<span><liferay-ui:message arguments="<%= audioExtensions %>" key="audio-file-extension-x" /></span>
					</div>
					<div class="lfr-dynamic-uploader" style = "max-height:200px;overflow:auto;">
						<div id="audioUploadBtn"></div>
						<div class="lfr-upload-container" id="<portlet:namespace />audioFileUpload"></div>
					</div>
						
					<span id="<portlet:namespace />selectedFileNameContainer"></span>
													
					<div style="clear: both;"></div>
		</div>
		<c:choose>
			<c:when test="<%= Validator.isNotNull(album_)%>">
			</c:when>
			<c:otherwise>
				<div class = "select-album">
					<aui:select name = "albumSelected" style = "width:100%" lable = "select-album">
					
							
							
								<aui:option  value = "-1"><liferay-ui:message key = "root-album"/></aui:option>
								<%
									List<AudioAlbum> albums = AudioAlbumLocalServiceUtil.findByGroup(groupId);
									for (int i = 0;i<albums.size();i++)
									{
										AudioAlbum album = albums.get(i);
										String albumCoverLink = AudioUtil.getAlbumCoverPath(request, album.getAlbumCoverId());
								%>
									<aui:option  value = "<%=album.getAlbumId() %>">
												<%=album.getAlbumName() %>
									</aui:option>
								<%
									}
								%>
					</aui:select>
				</div>
			</c:otherwise>
		</c:choose>
		<aui:button-row>
			<aui:button name="submitBtn" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>

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
<script type="text/javascript">

	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		
		
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
		
		var submitBtn = A.one('#<portlet:namespace/>submitBtn');
		
		if(submitBtn){
			
			submitBtn.on('click',function(){
				<portlet:namespace/>submitAdioUpdateForm();
			});
		}
		
		Liferay.provide(
				window,
				'<portlet:namespace />submitAdioUpdateForm',
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
					
					document.<portlet:namespace />audio_update_form.submit();
				},
			['aui-base']
		);
	});
</script>


