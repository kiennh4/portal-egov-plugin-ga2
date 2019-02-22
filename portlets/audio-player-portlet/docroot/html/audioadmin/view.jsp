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
<script type="text/javascript" src="/audio-player-portlet/js/jquery-1.7.1.js"></script>

<%@include file="/html/audioadmin/init.jsp"%>



<%
	String  tabs1 = ParamUtil.getString(request,"tabs1","audio-admin");
	String tabNames = "audio-admin,audio-settings";
%>

<liferay-portlet:renderURL var="audioAdminURL" >
	<liferay-portlet:param name="jspPage" value="/html/audioadmin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs names="<%=tabNames %>" url="<%=audioAdminURL.toString() %>">

	<c:if test='<%=tabs1.equals("audio-admin") %>'>
	    <liferay-util:include page="/html/audioadmin/audios.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
				
	<c:if test='<%=tabs1.equals("audio-settings") %>'>
	    <liferay-util:include page="/html/audioadmin/settings.jsp" servletContext="<%=this.getServletContext() %>"/>
	</c:if>
</liferay-ui:tabs>
	