<%@page import="com.bkav.portal.portlet.video.util.VideoPlayerUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
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
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script src="/video-player-portlet/jwplayer/jwplayer.js" type="text/javascript"></script>

<%@include file="/html/view/init.jsp"%>

<%
	boolean autoPlay = false;

	long selectedVideoId = ParamUtil.getLong(request, "videoId", 0);
	
	String key = ParamUtil.getString(request, "searchKey", StringPool.BLANK);
	
	if (selectedVideoId>0)
	{
// 		List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByEntry(selectedVideoId);
		
// 		if ((Validator.isNotNull(listMap))&&(listMap.size()>0))
// 		{
			categoryId = VideoPlayerUtil.getCategoryByVideoId(selectedVideoId
					, groupId, PortalUtil.getCompanyId(request)).getCategoryId();
// 		}
		
	}
	
	List<VideoEntry> videoList = null;
	
	List<VideoEntry> videoPlaylist = new ArrayList<VideoEntry>();
	
	if (!Validator.equals(key.trim(), StringPool.BLANK))
	{
		videoList = VideoEntryLocalServiceUtil.findByKeyword(groupId, key, -1, -1);
		
		if(videoList.size() > 1){
			
			videoPlaylist = ListUtil.subList(videoList, 0, videoList.size());
		}
	}
	else
	{
	
		videoList =	 ListUtil.subList(VideoPlayerUtil.getVideoEntriesByCategoryId(categoryId
				, groupId, PortalUtil.getCompanyId(request)),0,numbersOfVideoDisplay);
				
		if(videoList.size() > 1){
			
			videoPlaylist = ListUtil.subList(videoList, 0, videoList.size());
		}
	}
	
%>
<c:choose>
	<c:when test="<%=((categoryId==0)&&(Validator.equals(key.trim(), StringPool.BLANK))) %>">
		
		<div class = "list-category">
			<%
				List<VideoCategory> allCategorys = VideoCategoryLocalServiceUtil.findByGroup(groupId);
			%>
			<div class = "list-category-header">
				<span class = "list-category-title"><liferay-ui:message key = "list-categories"/></span>
				<span class = "search-video-form">
						<aui:button-row>
						<input id="<portlet:namespace/>searchKey" label = "" placeholder = "<liferay-ui:message key = 'search-video'/>"  type = "text"/>
						<input align="absmiddle" id = "<portlet:namespace/>searchBtn" border="0" src="/video-player-portlet/images/search.png" title="search"  type="image"/>
						</aui:button-row>
				</span>
			</div>
			<aui:script>
				AUI().ready('liferay-portlet-url',function(A){
		
					
					var searchBtn = A.one('#<portlet:namespace/>searchBtn');
					
					var searchKey = A.one('#<portlet:namespace/>searchKey');
					
					if (searchBtn)
					{
						searchBtn.on('click',function(){
							if (searchKey)
							{
								var videoSearchUrl = Liferay.PortletURL.createRenderURL();
										
								videoSearchUrl.setPortletId('<%=portletVideoPlayerId %>'); 
								videoSearchUrl.setParameter('searchKey', searchKey.attr('value'));
								videoSearchUrl.setDoAsGroupId('<%=groupId %>');
								
								location.href = videoSearchUrl;	
							}
						});
						
						searchKey.on('keydown',function(e){
							e = e || window.event; 
						 	var charCode = e.charCode || e.keyCode
							
							if (charCode==13)
							{
								if (searchKey)
								{
									var videoSearchUrl = Liferay.PortletURL.createRenderURL();
											
									videoSearchUrl.setPortletId('<%=portletVideoPlayerId %>'); 
									videoSearchUrl.setParameter('searchKey', searchKey.attr('value'));
									videoSearchUrl.setDoAsGroupId('<%=groupId %>');
									
									location.href = videoSearchUrl;	
								}
							}
							

						});
						
					}
					
				});
			</aui:script>
			<hr width="100%">
			<c:choose>
				<c:when test="<%=((Validator.isNotNull(allCategorys))&&(allCategorys.size()>0)) %>">
					<ul>
						<%
							for (VideoCategory videoCategory : allCategorys)
							{
						%>
							<liferay-portlet:renderURL var="videoCategoryURL">
								<liferay-portlet:param name="categoryId" value="<%=String.valueOf(videoCategory.getCategoryId()) %>"/>
							</liferay-portlet:renderURL>
								<li class = "category-list-item">
									<div class = "category-item">
										<a href = "<%=videoCategoryURL %>">
											<img src = "/video-player-portlet/images/category_folder.png"/>
										</a>
										<a href = "<%=videoCategoryURL %>">
											<span class = "category-item-title"><%=videoCategory.getCategoryName() %></span>
										</a>
									</div>					
								</li>
						<%
							}
						%>
					</ul>
				</c:when>
				<c:otherwise>
					<liferay-ui:message key = "no-category-found"/>
				</c:otherwise>
			</c:choose>
		</div>
		
	</c:when>
	<c:otherwise>
	
		<c:choose>
			<c:when test="<%=((videoList!=null)&&(!videoList.isEmpty()))%>">
				<liferay-portlet:renderURL var="allVideoCategorytURL">
					<liferay-portlet:param name="categoryId" value="0"/>
				</liferay-portlet:renderURL>
				<div class = "back-link">
					<span class = "back-link-title">
						<a href = "<%=allVideoCategorytURL %>">
							«<liferay-ui:message key="list-categories"/>
						</a>
					</span>
					
					<span class = "search-video-form">
						<aui:button-row>
							<input id="<portlet:namespace/>searchKey" value = "<%=key %>" placeholder = "<liferay-ui:message key = 'search-video'/>" type = "text"/>
							<input align="absmiddle" id = "<portlet:namespace/>searchBtn" border="0" src="/video-player-portlet/images/search.png" title="search"  type="image"/>
						</aui:button-row>
					</span>
				</div>
				<aui:script>
					AUI().ready('liferay-portlet-url',function(A){
			
						
						var searchBtn = A.one('#<portlet:namespace/>searchBtn');
						
						var searchKey = A.one('#<portlet:namespace/>searchKey');
						
						if (searchBtn)
						{
							searchBtn.on('click',function(){
								if (searchKey)
								{
									var videoSearchUrl = Liferay.PortletURL.createRenderURL();
											
									videoSearchUrl.setPortletId('<%=portletVideoPlayerId %>'); 
									videoSearchUrl.setParameter('searchKey', searchKey.attr('value'));
									videoSearchUrl.setDoAsGroupId('<%=groupId %>');
									
									location.href = videoSearchUrl;	
								}
							});
							
							searchKey.on('keydown',function(e){
								e = e || window.event; 
							 	var charCode = e.charCode || e.keyCode
								
								if (charCode==13)
								{
									if (searchKey)
									{
										var videoSearchUrl = Liferay.PortletURL.createRenderURL();
												
										videoSearchUrl.setPortletId('<%=portletVideoPlayerId %>'); 
										videoSearchUrl.setParameter('searchKey', searchKey.attr('value'));
										videoSearchUrl.setDoAsGroupId('<%=groupId %>');
										
										location.href = videoSearchUrl;	
									}
								}
								

							});
						}
						
					});
				</aui:script>	
				<hr width = "100%">
				<div class="video-gallery-style">
					<%
					VideoEntry topVideo = videoList.get(0);
					
					if(selectedVideoId > 0){
						
						autoPlay = true;
						
						topVideo = VideoEntryLocalServiceUtil.getVideoEntry(selectedVideoId);
						
						renderResponse.setTitle(topVideo.getName());
					}
					
					String topVideoTitle = topVideo.getName();
					
					String topVideoURL = "";
					
					String topVideoThumbnailURL = "/video-player-portlet/images/default-video-thumbnail.jpg";
					
					if(Validator.equals(topVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
						
						String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(topVideo.getVideoUrl());
						
						topVideoURL = VideoFileUtil.getEmbedYoutubeVideoURL(externalVideoId);
						
					}else{
						
						if(topVideo.getVideoFileId() > 0){
							
							FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(topVideo.getVideoFileId());
							
							if(videoFileEntry != null){
								
								topVideoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
							}
						}
					}
					
					if(topVideo.getThumbnailImage() && topVideo.getThumbnailImageId() > 0){
						
						FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(topVideo.getThumbnailImageId());
						
						if(thumbnailImage != null){
							
							topVideoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
						}
					}
					%>
					
					<div class="video-player-frame" >
						<c:choose>
							<c:when test='<%=Validator.equals(topVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE) %>'>
								<div class="external-video-frame" style="height: <%=videoFrameHeight%>px">
									<iframe src="<%=topVideoURL %>" 
									width="100%"  allowfullscreen style="border: 0;">
									</iframe>
								</div>
							</c:when>
							
							<c:otherwise>
								<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
					
								<aui:script>
									AUI().ready(function(A){
										jwplayer("<portlet:namespace />videoPlayer").setup({
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
								</aui:script>
							</c:otherwise>
						</c:choose>
					</div>
					
					<div class="top-video-title">
						<a href="javascript:;" title="<%=topVideoTitle %>"><%=topVideoTitle %></a>
					</div>
					
					<div class="video-gallery">
						<ul class="gallery-wrapper">
							<%
							for(VideoEntry videoEntry : videoPlaylist){
								
								String videoTitle = videoEntry.getName();
								
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
								
								String videoPublishDate = dateTimeFormat.format(videoEntry.getCreateDate());
							%>
							
								<liferay-portlet:renderURL var="videoPlaylistURL">
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
												
												<c:if test='<%=showVideoPublishDate %>'>
													<span class="video-upload-date"><%=videoPublishDate %></span>
												</c:if>
											</a>
										</div>
									</div>
								</li>
							<%
							}
							%>
						</ul>
						
						<div style="clear:both;"></div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<liferay-portlet:renderURL var="allVideoCategorytURL">
					<liferay-portlet:param name="categoryId" value="0"/>
				</liferay-portlet:renderURL>
				<div class = "back-link">
					<span class = "back-link-title">
						<a href = "<%=allVideoCategorytURL %>">
							«<liferay-ui:message key="list-categories"/>
						</a>
					</span>
					
					<span class = "search-video-form">
						<aui:button-row>
							<input id="<portlet:namespace/>searchKey" value = "<%=key %>" placeholder = "<liferay-ui:message key = 'search-video'/>"  type = "text"/>
							<input align="absmiddle" id = "<portlet:namespace/>searchBtn" border="0" src="/video-player-portlet/images/search.png" title="search"  type="image"/>
						</aui:button-row>
					</span>
				</div>
				<aui:script>
					AUI().ready('liferay-portlet-url',function(A){
			
						
						var searchBtn = A.one('#<portlet:namespace/>searchBtn');
						
						var searchKey = A.one('#<portlet:namespace/>searchKey');
						
						if (searchBtn)
						{
							searchBtn.on('click',function(){
								if (searchKey)
								{
									var videoSearchUrl = Liferay.PortletURL.createRenderURL();
											
									videoSearchUrl.setPortletId('<%=portletVideoPlayerId %>'); 
									videoSearchUrl.setParameter('searchKey', searchKey.attr('value'));
									videoSearchUrl.setDoAsGroupId('<%=groupId %>');
									
									location.href = videoSearchUrl;	
								}
							});
							
							searchKey.on('keydown',function(e){
								e = e || window.event; 
							 	var charCode = e.charCode || e.keyCode
								
								if (charCode==13)
								{
									if (searchKey)
									{
										var videoSearchUrl = Liferay.PortletURL.createRenderURL();
												
										videoSearchUrl.setPortletId('<%=portletVideoPlayerId %>'); 
										videoSearchUrl.setParameter('searchKey', searchKey.attr('value'));
										videoSearchUrl.setDoAsGroupId('<%=groupId %>');
										
										location.href = videoSearchUrl;	
									}
								}
								

							});
						}
						
					});
				</aui:script>	
				<hr width = "100%">
				<liferay-ui:message key="no-video-found"/>
			</c:otherwise>
		</c:choose>
	</c:otherwise>	
</c:choose>

