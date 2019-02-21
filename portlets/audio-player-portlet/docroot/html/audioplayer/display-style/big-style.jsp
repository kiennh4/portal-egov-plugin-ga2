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
<script src="/audio-player-portlet/js/mediaelement/mediaelement-and-player.min.js"></script>
<link rel="stylesheet" href="/audio-player-portlet/js/mediaelement/mediaelementplayer.css" />   
<link rel="stylesheet" href="/audio-player-portlet/js/mediaelement/mejs-skins.css" />
<%
	AudioAlbum album = AudioAlbumLocalServiceUtil.getAudioAlbum( Long.parseLong(defaultAlbum));
	List<AudioAlbum> albumList = AudioAlbumLocalServiceUtil.findByGroup(groupId);
	ArrayList<AudioFile> audioList = new ArrayList<AudioFile>();
%>
	<c:choose>
			<c:when test="<%=(Validator.isNotNull(album)) %>">
				<div class = "audioplayer-big-style">
				<c:choose>
					<c:when test="<%=(Validator.isNotNull(album)) %>">
						<%
							audioList = AudioUtil.getListAudioByAlbumId(album.getAlbumId());
						%>						
						<div  class = "album-list">
							<div class = "album-info" >
								<table style = "width:100%;height:50px;">
									<tr>
										<td width = "40px">
											<img class = "selected-album-cover" width = "60px" height = "60px" src = "<%=AudioUtil.getAlbumCoverPath(request, album.getAlbumCoverId()) %>" />
										</td>
										<td style = "padding: 10px;">
											<p class = "selected-album-name" ><b><liferay-ui:message key="current-album-play"/>:</b> <%=album.getAlbumName() %></p>
											<p class = "selected-album-info" ><b><liferay-ui:message key="album-info"/>:</b> <%=album.getAlbumInfo() %></p>
											<p class = "selected-album-num-audio"><b><liferay-ui:message key="audio-num"/>:</b> <%=(Validator.isNotNull(audioList)) ? audioList.size() : 0 %></p>
										</td>
									</tr>
								</table>
							</div>
							<div class = "album-list-item" >
						<%
							for (int i = 0;i<albumList.size();i++)
							{
								ArrayList<AudioFile> audioListTemp = AudioUtil.getListAudioByAlbumId(albumList.get(i).getAlbumId());
						%>
							<div style = "background:<%= (Validator.equals(albumList.get(i).getAlbumId(),album.getAlbumId())) ? "#f0f0f0" : "white"%>" 
								class = "album-item" onclick = "<portlet:namespace/>loadAudioPlayer(<%=albumList.get(i).getAlbumId() %>,'<%= albumList.get(i).getAlbumName()%>','<%=albumList.get(i).getAlbumInfo() %>','<%=AudioUtil.getAlbumCoverPath(request, albumList.get(i).getAlbumCoverId()) %>','<%=(Validator.isNotNull(audioListTemp)) ? audioListTemp.size() : 0  %>')">
								<table>
									<tr>
										<td width = "30px">
											<img src = "<%=AudioUtil.getAlbumCoverPath(request, albumList.get(i).getAlbumCoverId()) %>" width = "40px" height = "40px"/>
										</td>
										<td>
											<p style = "margin:0px;margin-left:5px;"><%=albumList.get(i).getAlbumName() %></p>
										</td>
									</tr>
								</table>
							</div>
						<%
							}
						%>
							</div>
						</div>
						<div class = "audioplayer-list">
							<div  style = "padding-top:10px;width:100%;">
								<div class = "audio-player-bar" style = "background: black;width:100%;height:40px;">
								</div>
								
								<audio id = "<portlet:namespace/>audio-player"  src="<%=((Validator.isNotNull(audioList)) ? AudioUtil.getAudioFilePath(renderRequest, audioList.get(0).getAudioFileId()) : "audio-player-portlet/js/mediaelement/silence.mp3" )%>" controls="controls">		
								</audio>
								<div id = "<portlet:namespace/>audio-list" style = "height:200px;overflow-x:hidden;overflow-y:auto;">
								
								</div>
							</div>
						</div>		
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="no-audio"/>
					</c:otherwise>
				</c:choose>
				</div>
			</c:when>
			<c:otherwise>
				<div class="portlet-configuration portlet-msg-info">
					<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
						label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
				</div>
			</c:otherwise>
		</c:choose>

<liferay-portlet:renderURL var="ajaxPlayListUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/audioplayer/ajax_play_list.jsp"/>
</liferay-portlet:renderURL>
<script>
var currentAudio = 0;
var albumName = "";
var albumInfo = "";
var albumCoverUrl = "";
var albumNumAudio = 0;

var player = new MediaElementPlayer('#<portlet:namespace/>audio-player',{
	 audioWidth: '100%',
	 features: ['playpause','progress','current','duration','tracks','volume','fullscreen'],
	 success: function(mediaElement, domObject) {
	        mediaElement.addEventListener('ended', function() {
	            currentAudio++;
	            if (currentAudio<=(albumNumAudio-1))
	            { 	
	            	$('.audio-item').each(function(){
	            		$(this).css ('background','white');
	            	});
	            	$('#<portlet:namespace/>audio-item-'+currentAudio).css ('background','#eee');
	            	var audioUrl = $('#<portlet:namespace/>audio-item-'+currentAudio).attr('audio-url');
	            	mediaElement.setSrc(audioUrl);
	           	 	mediaElement.play();
	            }
	          
	           
	        }, false);
	        
	        mediaElement.addEventListener('pause', function() {
	        	$('.audio-player-bar').css('background','black');
	  			
	        },false);
	        
	        mediaElement.addEventListener('playing', function() {
	  			$('.audio-player-bar').css('background','url("/audio-player-portlet/css/icon/music_bar.gif")');
	  			
	        },false);
	  }

});

function <portlet:namespace/>playAudio (audioUrl, numAudio) {
	$('.audio-item').each(function(){
		$(this).css ('background','white');
	});
	$('#<portlet:namespace/>audio-item-'+numAudio).css ('background','#eee');
	player.pause();
	player.setSrc(audioUrl);
	currentAudio = numAudio;
	player.play();
}

function <portlet:namespace/>loadAudioPlayer (albumId, albumName_, albumInfo_, albumCoverUrl_, albumNumAudio_,firstRun){
	$.ajax ({
		url: '<%=ajaxPlayListUrl%>',
		dataType: 'text',
		data:{
			albumId: albumId
		},
		success: function (data){
			$('#<portlet:namespace/>audio-list').html('');
			$('#<portlet:namespace/>audio-list').append(data);
			if (albumNumAudio_>0)
			{
				if (!firstRun)
					<portlet:namespace/>playAudio ($('#<portlet:namespace/>audio-item-'+0).attr('audio-url'),0);
			}
			else
			{
				if (!firstRun)
				{
				player.pause();
				MediaElementPlayer('#<portlet:namespace/>audio-player').setSrc('/audio-player-portlet/js/mediaelement/silence.mp3');
				}
			}
			albumName = albumName_;
			albumInfo = albumInfo_;
			albumCoverUrl = albumCoverUrl_;
			albumNumAudio = albumNumAudio_;
			
			$('.selected-album-name').html('<b><liferay-ui:message key="current-album-play"/>: </b>'+albumName);
			
			$('.selected-album-info').html('<b><liferay-ui:message key="album-info"/>: </b>'+albumInfo);
			
			$('.selected-album-num-audio').html('<b><liferay-ui:message key="audio-num"/>: </b>'+albumNumAudio);
			
			
			$('.selected-album-cover').attr('src',albumCoverUrl);
		},
		error: function (a,b,c)
		{
			
		}
	});
}

<portlet:namespace/>loadAudioPlayer (<%=album.getAlbumId() %>,'<%=album.getAlbumName() %>','<%=album.getAlbumInfo() %>','<%=AudioUtil.getAlbumCoverPath(request, album.getAlbumCoverId()) %>',' <%=(Validator.isNotNull(audioList)) ? audioList.size() : 0 %>',true);
</script>		
<aui:script use="aui-dialog">
AUI().ready(function(A){
	
   A.all('.album-item').each (function (){
   	 	this.on('click',function(){
   	 		A.all('.album-item').setStyle ('background','white');
   			this.setStyle('background','#f0f0f0');
   	 	}); 	
   });
   
});
</aui:script>
	
	