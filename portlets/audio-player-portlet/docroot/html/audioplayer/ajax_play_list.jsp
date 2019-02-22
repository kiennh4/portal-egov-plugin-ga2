<%@page import="java.util.ArrayList"%>
<%@page import="com.bkav.portal.portlet.audioplayer.util.AudioUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.admin.AudioAdmin"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<portlet:defineObjects />
<%@include file="/html/audioplayer/init.jsp"%>

<%
	long albumId = ParamUtil.getLong(request, "albumId");
	AudioAlbum album = AudioAlbumLocalServiceUtil.getAudioAlbum(albumId);
	
	List<AudioAlbum> albumList = AudioAlbumLocalServiceUtil.findByGroup(groupId);
	ArrayList<AudioFile> audioList = new ArrayList<AudioFile>();
	
	if (Validator.isNotNull(album))
	{
		audioList = AudioUtil.getListAudioByAlbumId(album.getAlbumId());	
	}
%>
	<c:choose>
		<c:when test="<%=((Validator.isNotNull(audioList))&&(audioList.size()>0)) %>">
			<ul style = "width:100%;margin:0px;margin-left:5px;margin-top:5px;">
			<%
				for (int i = 0;i<audioList.size();i++)
				{
			%>
				<li audio-url = "<%=AudioUtil.getAudioFilePath(renderRequest, audioList.get(i).getAudioFileId()) %>" 
					class = "audio-item" id = "<portlet:namespace/>audio-item-<%=i %>" 
					style = "background: <%= (i==0) ? "rgb(238, 238, 238)" : "white" %>">
					<table style = "width:100%">
						<tr>
						<td onclick = "<portlet:namespace/>playAudio('<%=AudioUtil.getAudioFilePath(renderRequest, audioList.get(i).getAudioFileId()) %>',<%=i %>)">
							<p style = "padding: 2px; margin:0px;margin-left:0px;"><%=audioList.get(i).getAudioName() %></p>
						</td>
						<td width = "25px;" >
							<span style = "float:left;margin-top:5px;"><a href = "javascript:window.location.href = '<%=AudioUtil.getAudioFilePath(renderRequest, audioList.get(i).getAudioFileId()) %>'"><img src = "/audio-player-portlet/css/icon/download.png" width = "16px" height = "16px" /></a></span>
						</td>
						</tr>
					</table>
				</li>
			<%
				 }
			%>
			</ul>
		</c:when>
		<c:otherwise>
			<p style = "color:black; font-size: 14px;"><liferay-ui:message key="no-audio"/></p>
		</c:otherwise>
	</c:choose>



