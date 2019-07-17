<%@page import="java.util.Collections"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoPlayerUtil"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoConstants"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.swing.plaf.ListUI"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoFileUtil"%>
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
<script src="/video-player-portlet/jwplayer/video.js" type="text/javascript"></script>
<script src="/video-player-portlet/jwplayer/videojs-resolution-switcher.js" type="text/javascript"></script>
<%@include file="/html/view/init.jsp"%>

<%
	boolean autoPlay = false;

	long selectedVideoId = ParamUtil.getLong(request, "videoId");
	
	if (selectedVideoId>0)
	{
		categoryId = VideoPlayerUtil.getCategoryByVideoId(selectedVideoId
				, groupId, PortalUtil.getCompanyId(request)).getCategoryId();
		
	}
	
	//List<VideoEntry> videoList = VideoEntryLocalServiceUtil.findByGroup(groupId, 0, numbersOfVideoDisplay);

	List<VideoEntry> videoList = ListUtil.subList(VideoPlayerUtil.getVideoEntriesByCategoryId(categoryId
			, groupId, PortalUtil.getCompanyId(request)),0,numbersOfVideoDisplay);
	Collections.sort(videoList);
	List<VideoEntry> videoPlaylist = new ArrayList<VideoEntry>();
	
	if(videoList.size() > 1){
		
		videoPlaylist = ListUtil.subList(videoList, 0, videoList.size());
	}
	Collections.sort(videoPlaylist);
%>
<c:choose>
	<c:when test="<%=!videoList.isEmpty()%>">
		<div class="video-player-default-style">
			<%
			VideoEntry topVideo = videoList.get(0);
			
			if(selectedVideoId > 0){
				
				autoPlay = true;
				
				topVideo = VideoEntryLocalServiceUtil.getVideoEntry(selectedVideoId);
				
				renderResponse.setTitle(topVideo.getName());
			}
			
			String topVideoTitle = topVideo.getName();
			
			String topVideoURL = VideoFileUtil.getViewVideoURL(themeDisplay, topVideo);
			
			String topVideoThumbnailURL = "/video-player-portlet/images/default-video-thumbnail.jpg";
			
			if(topVideo.getThumbnailImage() && topVideo.getThumbnailImageId() > 0){
				
				FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(topVideo.getThumbnailImageId());
				
				if(thumbnailImage != null){
					
					topVideoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
				}
			}
			String style = "width:" + videoFrameWidth +"px;height:" + videoFrameHeight + "px";
			%>
			<div class="video-player-frame" >
				<div class="video-player" style="<%=style%>">
				<c:choose>
					<c:when test='<%=Validator.equals(topVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE) %>'>
						<div class="external-video-frame" style="<%=style%>">
							<iframe id="videoFrame" width="<%=VideoConstants.DEFAULT_VIDEO_FRAME_WIDTH%>" height="<%=videoFrameHeight %>"
								src="<%=topVideoURL%>" allowfullscreen> </iframe>
						</div>
					</c:when>
					<c:otherwise>	
							<video id="player" class="video-js vjs-default-skin"  controls
								preload="none" loop width="640" height="360"
								poster="<%=topVideoThumbnailURL%>">
							</video>
							<aui:script>
						        var player = videojs('player', {
						            plugins: {
						                videoJsResolutionSwitcher: {
						                    dynamicLabel: true
						                }
						            }
						        });
						        player.updateSrc([
						           	{
										src: '<%=topVideoURL%>',
										type: 'video/mp4',
										res: 360,
										label: '360p'
									},
						            {
						                src: '<%=topVideoURL%>',
						                type: 'video/mp4',
						                res: 480,
						                label: '480p'
						            },
						            {
						                src: '<%=topVideoURL%>',
						                type: 'video/mp4',
						                res: 720,
						                label: '720p'
						            },
						            {
						                src: '<%=topVideoURL%>',
						                type: 'video/mp4',
						                res: 1080,
						                label: '1080p'
						            }
						        ])
	    					</aui:script>
						
						<%-- <div class="video-player" style="<%=style%>" id="<portlet:namespace />videoPlayer">
						</div>		
						<aui:script>
							AUI().ready(function(A){
								jwplayer("<portlet:namespace />videoPlayer").setup({
						            flashplayer: '/video-player-portlet/jwplayer/jwplayer.flash.swf',
						            file: '<%=topVideoURL%>',
						            image: '<%=topVideoThumbnailURL %>',
				    		        height: <%=videoFrameHeight%>,
						            width: <%=videoFrameWidth%>,
						            autostart: <%=autoPlay %>
						        });
						        jwplayer("<portlet:namespace />videoPlayer").onReady (function (){
						        	 A.one('#<portlet:namespace />videoPlayer_logo').setStyle ('display','none');
						        });
						        
							});
						</aui:script> --%>
					</c:otherwise>
				</c:choose>
				</div>
			</div>
			
			<div class="top-video-title">
				<a href="javascript:;" id="topVideo"><%=topVideoTitle %></a>
			</div>
				
			<div class="video-playlist">
				<ul>
				<%
				for(VideoEntry videoEntry : videoPlaylist){
					
					String videoTitle = videoEntry.getName();
					
					String videoURL = VideoFileUtil.getViewVideoURL(themeDisplay, videoEntry);
					
					String videoPublishDate = dateTimeFormat.format(videoEntry.getCreateDate());
					String videoType = videoEntry.getVideoType();
				%>
				
				<%-- 	<liferay-portlet:renderURL var="videoPlaylistURL">
						<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoEntry.getEntryId()) %>"/>
					</liferay-portlet:renderURL> --%>
					
					<li>
						<a href="javascript:;" title="<%=videoTitle %>" data-type="<%=videoType %>" mediaurl="<%=videoURL%>" class="viewVideo">
							<span class="video-title"><%=videoTitle %></span>
						</a>
						<c:if test='<%=showVideoPublishDate %>'>
								<span class="video-upload-date"><%=videoPublishDate %></span>
						</c:if>
					</li>
				<%
				}
				%>
				</ul>
			</div>
				
			<c:if test='<%=showViewMoreVideoLink %>'>
				<%
				Layout layout = LayoutLocalServiceUtil.getLayout(videoPageLayoutId);
				
				String viewMoreVideoURL = PortalUtil.getLayoutFriendlyURL(layout, themeDisplay);
				%>
				<div class="view-more-video-link">
					<a href="<%=viewMoreVideoURL%>"><liferay-ui:message key="more-video"/></a>
				</div>
				
				<div style="clear: both;"></div>
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-video-found"/>
	</c:otherwise>
</c:choose>
