<%@page import="com.bkav.portal.portlet.video.util.VideoPlayerUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.swing.plaf.ListUI"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoFileUtil"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoEntry"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/video-player-portlet/jwplayer/video.js" type="text/javascript"></script>
<script src="/video-player-portlet/jwplayer/videojs-resolution-switcher.js" type="text/javascript"></script>
<%@include file="/html/view/init.jsp"%>

<%
	long selectedVideoId = ParamUtil.getLong(request, "videoId");
	
	if (selectedVideoId>0)
	{
		categoryId = VideoPlayerUtil.getCategoryByVideoId(selectedVideoId
				, groupId, PortalUtil.getCompanyId(request)).getCategoryId();
		
	}

	List<VideoEntry> videoList = ListUtil.subList(VideoPlayerUtil.getVideoEntriesByCategoryId(categoryId
			, groupId, PortalUtil.getCompanyId(request)),0,numbersOfVideoDisplay);

	String linkToLayoutUuid = GetterUtil.getString(preferences.getValue("portletSetupLinkToLayoutUuid", null)); 

	String linkToPage = "";
	
	if ((linkToLayoutUuid!=null)&&(!linkToLayoutUuid.equals("")))
	{
		Layout layout = LayoutLocalServiceUtil.fetchLayoutByUuidAndGroupId(linkToLayoutUuid, groupId);
		
		if (layout!=null)
		{
			linkToPage = layout.getFriendlyURL();
		}
		
	}
	
%>
<c:choose>
	<c:when test="<%=!videoList.isEmpty()%>">
		<div class="video-slider-style">

			<div class="style-title">
				<a href = "<%=linkToPage%>" style = "color:#ff0700"><span><%=styleTitle %></span></a>
			</div>
			
			<div class="style-content">
				<ul id="<portlet:namespace/>jcarousel" class="jcarousel-skin-tango">
					<%
					for(VideoEntry videoEntry : videoList){
						
						String videoTitle = StringUtil.shorten(videoEntry.getName(),40);
						
						String videoURL = "";
						
						if(videoEntry.getVideoFileId() > 0){
							
							FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(videoEntry.getVideoFileId());
							
							if(videoFileEntry != null){
								
								videoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
							}
						}
						
						String videoThumbnailURL = "/video-player-portlet/images/default-video-thumbnail.jpg";
						
						if(videoEntry.getThumbnailImage() && videoEntry.getThumbnailImageId() > 0){
							
							FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(videoEntry.getThumbnailImageId());
							
							if(thumbnailImage != null){
								
								videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
							}
						}
						
					%>
					
						<liferay-portlet:renderURL var="videoPlaylistURL" plid="<%=videoPageLayoutId %>">
							<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoEntry.getEntryId()) %>"/>
						</liferay-portlet:renderURL>
						
						<li class="video-entry">
							<div class="video-detail">
								<div class="video-thumbnail">
									<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
										<div class="play-icon"></div>
									</a>
									<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
										<span class="thumbnail-container">
											<img alt="<%=videoTitle %>" src="<%=videoThumbnailURL%>">
										</span>
									</a>
								</div>
								
								<div class="video-name">
									<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
										<span class="video-title"><%=videoTitle %></span>
									</a>
								</div>
							</div>
						</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
				
		<script type="text/javascript">
		
			jQuery(document).ready(function() {
			    jQuery('#<portlet:namespace/>jcarousel').jcarousel({        
			    	scroll: 1,
			    	auto: 10,
			    	wrap: 'both'
			    });
			});
		</script>
	</c:when>
	<c:otherwise>
		<liferay-portlet:renderURL var="allVideoCategorytURL">
			<liferay-portlet:param name="categoryId" value="0"/>
		</liferay-portlet:renderURL>
		<div class = "back-link">
			<a href = "<%=allVideoCategorytURL %>">
				<span class = "back-link-title">
					«<liferay-ui:message key="list-categories"/>
				</span>
			</a>
		</div>
		<hr>	
		<liferay-ui:message key="no-video-found"/>
	</c:otherwise>
</c:choose>

