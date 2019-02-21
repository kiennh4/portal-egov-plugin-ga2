<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoFileUtil"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalService"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.video.permission.VideoEntryPermission"%>
<%@page import="com.bkav.portal.portlet.video.permission.VideoCategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.bkav.portal.portlet.video.search.VideoSearch"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoEntry"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long categoryId = ParamUtil.getLong(request, "categoryId");

	String key = ParamUtil.getString(request, "key");

	String redirectUrl = request.getParameter("redirectUrl");
	if (!Validator.isNotNull(redirectUrl))
		redirectUrl = albumAdminHomePageURL;
%>
<ul>
	<c:choose>
		<c:when test="<%=Validator.isNotNull(categoryId) %>">
			<%
				List<VideoEntry> listVideos = VideoEntryLocalServiceUtil.findByCategoryId(groupId, categoryId, -1, -1);
			%>
			<c:choose>
				<c:when test="<%=((Validator.isNotNull(listVideos))&&(listVideos.size()>0)) %>">
					<%
						for (int i = 0; i < listVideos.size();i++)
						{
							VideoEntry videoItem = listVideos.get(i);
					%>
						<li>
							<table style = "width:100%">
								<tr>
									<td width = "50px">
										<img src = "/video-player-portlet/images/video.png" width = "50px" height = "50px"/>
									</td>
									<td onclick = "<portlet:namespace/>showVideoUpdateForm(<%=videoItem.getEntryId()%>)">
										<p class = "video-title"><%=videoItem.getName() %></p>
										<p class = "video-type"><b><liferay-ui:message  key = "video-type"/></b>: 
											<liferay-ui:message key="<%=videoItem.getVideoType() %>"/>
										</p>
										<p class = "video-date"><b><liferay-ui:message  key = "video-user"/></b>: <%=videoItem.getUserName() %> / <b><liferay-ui:message  key = "video-date"/></b>: <%=dateTimeFormat.format(videoItem.getModifiedDate()) %></p>
									</td>
									<td width = "30px;">
										<c:if test="<%=VideoEntryPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
												<liferay-portlet:actionURL  name="deleteVideo" var="deleteVideoActionURL">
													<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoItem.getEntryId())%>"/>
													<liferay-portlet:param name="redirectURL" value="<%=redirectUrl %>"/>
												</liferay-portlet:actionURL>
												
												<liferay-ui:icon-delete url="<%= deleteVideoActionURL %>" />
										</c:if>
									</td>
								</tr>
							</table>
						</li>	
					<%
						}
					%>
				</c:when>
				<c:otherwise>
					<li>
						<center>
							<b><liferay-ui:message key="no-video-found"/></b>
							
						</center>
					</li>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<%
				List<VideoEntry> listVideo = new ArrayList<VideoEntry>();
			
				if ((Validator.isNotNull(key))&&(!key.trim().equals("")))
				{ 
					listVideo = VideoEntryLocalServiceUtil.findByKeyword(groupId, 
							key, -1, -1);
				}
				else
				{
					listVideo  = VideoEntryLocalServiceUtil.findByGroup(groupId);
				}
			%>
			<c:choose>
				<c:when test="<%=((Validator.isNotNull(listVideo))&&(listVideo.size()>0)) %>">
					<%
						for (int i = 0; i < listVideo.size();i++)
						{
							VideoEntry videoItem = VideoEntryLocalServiceUtil.getVideoEntry(listVideo.get(i).getEntryId());
							List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByEntry(videoItem.getEntryId());
							
							String categoryName = "no-category";
							
							if ((Validator.isNotNull(listMap))&&(listMap.size() > 0)) 
							{
								VideoCategory videoCate = VideoCategoryLocalServiceUtil.getVideoCategory(listMap.get(0).getCategoryId());
							 	categoryName = videoCate.getCategoryName();
							}
					%>
						<li>
							<table style = "width:100%">
								<tr>
									<td width = "50px">
										<img src = "/video-player-portlet/images/video.png" width = "50px" height = "50px"/>
									</td>
									<td onclick = "<portlet:namespace/>showVideoUpdateForm(<%=videoItem.getEntryId()%>)">
										<p class = "video-title"><%=videoItem.getName() %></p>
										<p class = "video-type"><b><liferay-ui:message  key = "category"/>
										: </b>
											<liferay-ui:message key="<%=categoryName %>"/>
										</p>
										<p class = "video-type"><b><liferay-ui:message  key = "video-type"/></b>: 
											<liferay-ui:message key="<%=videoItem.getVideoType() %>"/>
										</p>
										<p class = "video-date"><b><liferay-ui:message  key = "video-user"/></b>: <%=videoItem.getUserName() %> / <b><liferay-ui:message  key = "video-date"/></b>: <%=dateTimeFormat.format(videoItem.getModifiedDate()) %></p>
									</td>
									<td width = "30px;">
										<c:if test="<%=VideoEntryPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
												<liferay-portlet:actionURL  name="deleteVideo" var="deleteVideoActionURL">
													<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoItem.getEntryId())%>"/>
													<liferay-portlet:param name="redirectURL" value="<%=redirectUrl %>"/>
												</liferay-portlet:actionURL>
												
												<liferay-ui:icon-delete url="<%= deleteVideoActionURL %>" />
										</c:if>
									</td>
								</tr>
							</table>
						</li>	
					<%
						}
					%>
				</c:when>
				<c:otherwise>
					<li>
						<center>
							<b><liferay-ui:message key="no-video-found"/></b>
							
						</center>
					</li>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<li style = "background: #8fbe31;color:white;margin-top:5px;height:30px;" onclick = "<portlet:namespace/>showVideoUpdateForm()" class = "add-new-video">
		<center>
			<b><liferay-ui:message key="add-new-video"/></b>
			<liferay-ui:icon image="add"/>
		</center>
	</li>
</ul>