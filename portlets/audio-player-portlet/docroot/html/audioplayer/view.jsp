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
	AudioAlbum album = AudioAlbumLocalServiceUtil.getAudioAlbum( Long.parseLong(defaultAlbum));
	List<AudioAlbum> albumList = AudioAlbumLocalServiceUtil.findByGroup(groupId);
	ArrayList<AudioFile> audioList = new ArrayList<AudioFile>();
	
%>
	<div class = "audio-player-content" style = "max-height:500px;">
		<c:choose>
			<c:when test="<%=(currentStyle.equals(smallStyle)) %>">
				<liferay-util:include page="/html/audioplayer/display-style/small-style.jsp" servletContext="<%=getServletContext() %>"/>
			</c:when>
			<c:when test="<%=(currentStyle.equals(bigStyle)) %>">
				<liferay-util:include page="/html/audioplayer/display-style/big-style.jsp" servletContext="<%=getServletContext() %>"/>
			</c:when>
		</c:choose>
	</div>
		