<%@page import="com.bkav.portal.portlet.audioplayer.service.AlbumAudioMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AlbumAudioMap"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioFileLocalServiceUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.impl.AudioAlbumLocalServiceImpl"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.util.AudioUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioFile"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AudioPermission"%>
<%@page import="com.bkav.portal.portlet.audioplayer.permission.AlbumPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/audioadmin/init.jsp"%>



<%
	String albumIdStr = request.getParameter("albumId");
	String audioNameKey = request.getParameter("key");
	
	if (!Validator.isNotNull(audioNameKey))
		audioNameKey = "";
	String audioIconLink = "/audio-player-portlet/css/icon/audio.png";
	String audioListHtml = "";
	
	long albumId = Long.parseLong(albumIdStr);
	
	String redirectUrl = request.getParameter("redirectUrl");
		if (!Validator.isNotNull(redirectUrl))
			redirectUrl = albumAdminHomePageURL;
	
	
	
%>
<ul class = "audioListTable">
	
	
	<c:choose>
		
		<c:when test="<%=(albumId <= 0) %>">
			<%List<AudioFile> audios = AudioFileLocalServiceUtil.findByAudioName(groupId, audioNameKey,-1,-1, null); %>
				<c:choose>
					<c:when test="<%=(audios.size()<=0) %>">
						<liferay-ui:message key="no-audio-found" />
					</c:when>
					<c:otherwise>
						<%
							for(int i = 0;i< audios.size();i++) 
							{
								SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
								AudioFile audio = AudioFileLocalServiceUtil.getAudioFile(audios.get(i).getAudioId());
								String dateStr = df.format(audio.getModifyDate());
						%>
							<li  class = "audio-item" style = 'width:100%;'>
								<table style = 'width:100%;'>
									<tr>
										<td width = '50px'>
											<img width = '50px' height = '50px' src = "<%= audioIconLink%>"/>
										</td>
										<td onclick = "<portlet:namespace/>previewAudio('<%=AudioUtil.getAudioFilePath(renderRequest, audio.getAudioFileId()) %>','<%=audio.getAudioName() %>');" style = 'padding:10px;'>
											<p class = 'audioName'><%=audio.getAudioName() %></p>
											<p class = 'audioInfo'><%=audio.getAudioInfo() %></p>
											<p class = 'audioDate'>Lượt xem:  <%=audio.getViewCounter() %>. Ngày cập nhật: <%=dateStr %></p>
										</td>
										<td width = '60px'>
											
											<c:if test="<%=AlbumPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
																											
													<liferay-portlet:actionURL  name="deleteAudio" var="deleteAudioActionURL">
														<liferay-portlet:param name="audioId" value="<%=String.valueOf(audio.getAudioId())%>"/>
														<liferay-portlet:param name="redirectURL" value="<%=redirectUrl %>"/>
													</liferay-portlet:actionURL>
															
													<liferay-ui:icon-delete url="<%= deleteAudioActionURL %>" />
														
											</c:if>
										</td>
					
									</tr>
								</table>
							</li>
						<%
							}
						%>	
							
					</c:otherwise>
				</c:choose>
				<li style = "background: #8fbe31;color:white;" class = "add-new-album" onclick="<portlet:namespace/>showUpdateAudio()">
					<center>
						<b><liferay-ui:message key="add-new-audio"/></b>
						<liferay-ui:icon image="add"/>
					</center>
				</li>
		</c:when>
		
		<c:otherwise>
			<%
				List<AlbumAudioMap> audioListId  = AlbumAudioMapLocalServiceUtil.findByAlbumId(albumId);
			 %>
			 <c:choose>
			 	<c:when test="<%=(audioListId.size()<=0) %>">
			 		<liferay-ui:message key="no-audio-found" />
			 	</c:when>
			 	<c:otherwise>
			 		<%
				 		for(int i = 0;i< audioListId.size();i++) 
						{
							AlbumAudioMap aam = audioListId.get(i); 
							SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
							AudioFile audio = AudioFileLocalServiceUtil.getAudioFile(aam.getAudioId());
							String dateStr = df.format(audio.getModifyDate());
			 		%>
			 			<li  class = "audio-item" style = 'width:100%;'>
							<table style = 'width:100%;'>
								<tr>
									<td width = '50px'>
										<img width = '50px' height = '50px' src = "<%= audioIconLink%>"/>
									</td>
									<td onclick = "<portlet:namespace/>previewAudio('<%=AudioUtil.getAudioFilePath(renderRequest, audio.getAudioFileId()) %>','<%=audio.getAudioName() %>');" style = 'padding:10px;'>
										<p class = 'audioName'><%=audio.getAudioName() %></p>
										<p class = 'audioInfo'><%=audio.getAudioInfo() %></p>
										<p class = 'audioDate'><liferay-ui:message key = "view-counter"/>: <%=audio.getViewCounter() %>. <liferay-ui:message key = "update-date"/>: <%=dateStr %></p>
									</td>
									<td width = '60px'>
										
										<c:if test="<%=AlbumPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE) %>">
																										
												<liferay-portlet:actionURL  name="removeAudioFromAlbum" var="removeAudioActionUrl">
													<liferay-portlet:param name="audioId" value="<%=String.valueOf(audio.getAudioId())%>"/>
													<liferay-portlet:param name="albumId" value="<%=String.valueOf(albumId)%>"/>
													<liferay-portlet:param name="redirectURL" value="<%=redirectUrl %>"/>
												</liferay-portlet:actionURL>
																
												<liferay-ui:icon  src="/audio-player-portlet/css/icon/remove_album.png" url="<%= removeAudioActionUrl %>" message="remove-audio-from-album" />
															
										</c:if>
										<br>
										<c:if test="<%=AlbumPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
																										
												<liferay-portlet:actionURL  name="deleteAudio" var="deleteAudioActionURL">
													<liferay-portlet:param name="audioId" value="<%=String.valueOf(audio.getAudioId())%>"/>
													<liferay-portlet:param name="redirectURL" value="<%=redirectUrl %>"/>
												</liferay-portlet:actionURL>
																
												<liferay-ui:icon-delete url="<%= deleteAudioActionURL %>" />
															
										</c:if>
									</td>
								</tr>
							</table>
						</li>
					<%
						}
					%>
						
			 	</c:otherwise>
			 </c:choose>
			 <li  style = "background: #8fbe31;color:white;" class = "add-new-album" onclick="<portlet:namespace/>showUpdateAlbum(<%=albumId%>)">
				<center>
					<b><liferay-ui:message key="add-new-audio"/></b>
					<liferay-ui:icon image="add"/>
				</center>
			</li>
		</c:otherwise>
	</c:choose>
</ul>