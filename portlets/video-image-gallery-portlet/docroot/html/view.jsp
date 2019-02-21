<%@page import="com.bkav.portal.portlet.videoplayer.util.VideoFileUtil"%>
<%@page import="com.bkav.portal.portlet.videoplayer.util.VideoConstants"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoEntry"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.ImageProcessorUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileVersion"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.ServletContextUtil"%>
<%@include file = "/html/init.jsp" %>

<liferay-portlet:renderURL var="defaultGalleryURL" >
	<liferay-portlet:param name="jspPage" value="/html/view.jsp"/>
</liferay-portlet:renderURL>


<div class = "video-image-display-content">
	<div class = "display-panel" >
		<table style = "width:100%">
			<tr>
				<td width = "50%" class = "tab-display active" tabs-type = "image">
					<liferay-ui:message key="image-gallery"/>
				</td>
				<td width = "50%" class = "tab-display last" tabs-type = "video">
					<liferay-ui:message key="video-gallery"/>
				</td>
			</tr>
		</table>
	</div>

	<div class = "image-gallery-display-content">
			<%
				long javaScriptLastModified = ServletContextUtil.getLastModified(application, "/html/js/", true);
			%>
			
			
			<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request,"/video-image-gallery-portlet/js/jquery.easing.1.3.js", javaScriptLastModified)) %>" type="text/javascript"></script>
			
			<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request,"/video-image-gallery-portlet/js/jquery.slideviewer.1.2.js", javaScriptLastModified)) %>" type="text/javascript"></script>
			
			<c:choose>
				<c:when test="<%=selectedImageFolderId > 0L %>">
					<div class="imageGallerySliderFrame">
						<div id="<portlet:namespace />imageGallerySlider" class="imageGallerySlider">
						<%
							//Danh sach cac file co trong thu muc
							List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(groupId, selectedImageFolderId,0,numbersOfImageDisplay);
							
							int fileIndex = 0;
							
							for(FileEntry fileEntry : fileEntryList){
								
								FileVersion fileVersion = fileEntry.getLatestFileVersion();
								
								//Kiem tra file co phai la dinh dang anh hay khong?
								boolean hasImage = ImageProcessorUtil.hasImages(fileVersion);
								
								if(hasImage){//Truong hop dung la file anh
										
									String imageIdStr = String.valueOf(fileEntry.getFileEntryId());
									
									String[] imageIdStrSplitedArr = imageIdStr.split("(?<=\\G.{2})");
									
									StringBuilder stringBuilder = new StringBuilder();
			
									if(useThumbnailImage){
										stringBuilder.append("/thumbnail/260x140/");
									}else{
										stringBuilder.append("/thumbnail/400x300/");
									}
									
									for (int i = 0; i < imageIdStrSplitedArr.length; i++){
										
										stringBuilder.append(imageIdStrSplitedArr[i]);
										stringBuilder.append(StringPool.SLASH);
									}
									
									stringBuilder.append(fileEntry.getFileEntryId() + "." + fileEntry.getExtension());
									
									String imageSrc = stringBuilder.toString();
									
									//Duong dan den file anh voi kich thuoc day du
									String imageHref = DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, StringPool.BLANK);
									
									String imageDescription = HtmlUtil.escape(fileEntry.getDescription());
										
									if(Validator.isNull(imageDescription)){
										
										imageDescription = HtmlUtil.escape(fileEntry.getTitle());
									}
									
									String imageCssClass = "";
									
									if(fileIndex == 0){
										
										imageCssClass = "active";
									}
									
									fileIndex ++;
						%>		
									<div class="image-thumbnail-preview <%=imageCssClass%>">
										<a href="<%=imageHref%>" title="<%=imageDescription%>">
											<img src="<%= imageSrc %>" class="<%=imageCssClass%>"/>
										</a>
									</div>
									
						<%
								}
							}
						%>
						</div>
						
						<c:if test='<%=displayGalleryLink %>'>
							<%
							Layout layout = LayoutLocalServiceUtil.getLayout(galleryPageId);
							
							String viewImageGalleryLink = PortalUtil.getLayoutFriendlyURL(layout, themeDisplay);
							%>
							<div class="view-gallery-links">
								<a href="<%=viewImageGalleryLink%>"><liferay-ui:message key="view-gallery"/></a>
							</div>
						</c:if>
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="portlet-configuration portlet-msg-info">
						<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
							label="please-config-this-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
					</div>
				</c:otherwise>
			</c:choose>
			<span class = "<portlet:namespace />templateInfo" style = "display:none;"></span>
			<script type="text/javascript">
			
				function slideSwitch() {
				    var active = jQuery('#<portlet:namespace />imageGallerySlider DIV.active');
				
				    if ( active.length == 0 ) active = jQuery('#<portlet:namespace />imageGallerySlider DIV:last');
				
				    // use this to pull the divs in the order they appear in the markup
				    var next =  active.next().length ? active.next(): jQuery('#<portlet:namespace />imageGallerySlider DIV:first');
				
				    active.addClass('last-active');
				
				    next.css({opacity: 0.0})
				        .addClass('active')
				        .animate({opacity: 1.0}, 1000, function() {
				            active.removeClass('active last-active');
				        });
				}
				
				jQuery(function() {
				    setInterval( "slideSwitch()", 5000 );
				});
			
			</script>
				
			<aui:script use="aui-image-viewer-gallery,aui-media-viewer-plugin">
				var A = AUI();
				
				var imageGallerySlider = A.one('#<portlet:namespace />imageGallerySlider');
				
				var templateInfo = A.one('.<portlet:namespace />templateInfo');
				
				if(imageGallerySlider){
					
					var viewportRegion = A.getDoc().get('viewportRegion');
						
					var maxHeight = (viewportRegion.height * 0.5);
					var maxWidth = (viewportRegion.width * 0.5);
						
					var imageGallery = new A.ImageGallery({
					
							links: imageGallerySlider.all('a'),
							autoPlay: true,
							showControls: false,
							maxHeight: maxHeight,
							maxWidth: maxWidth,
							caption: "",
							infoTemplate: "",
							playingLabel: "",
							captionFromTitle: false,
							preloadNeighborImages: true,
							preloadAllImages: true,
							showInfo: false
						}		
					).render();
					
					
					imageGallerySlider.setStyles({
					    height:  <%=imageThumbnailHeight + 4%>,
					    width:   <%=imageThumbnailWidth + 4%>
					})
					
					if(<%=useCustomImageSize %>){
					
						var imageThumbnail = imageGallerySlider.all('img');
						
						imageThumbnail.setStyles({
						    height:  <%=imageThumbnailHeight %>,
						    width:   <%=imageThumbnailWidth %>
						})
					}
				}
			</aui:script>
	</div>
	
	<div class = "video-gallery-display-content">
		<%
			boolean autoPlay = false;
		
			long selectedVideoId = ParamUtil.getLong(request, "videoId");
			
			if (selectedVideoId>0)
			{
				List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByEntry(selectedVideoId);
				
				if ((Validator.isNotNull(listMap))&&(listMap.size()>0))
				{
					categoryId = listMap.get(0).getCategoryId();
				}
				
			}
			
			//List<VideoEntry> videoList = VideoEntryLocalServiceUtil.findByGroup(groupId, 0, numbersOfVideoDisplay);
		
			List<VideoEntry> videoList = VideoEntryLocalServiceUtil.findByCategoryId(groupId, categoryId, 0, numbersOfVideoDisplay);
			
			List<VideoEntry> videoPlaylist = new ArrayList<VideoEntry>();
			
			if(videoList.size() > 1){
				
				videoPlaylist = ListUtil.subList(videoList, 0, videoList.size());
			}
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
					
					String topVideoURL = "";
					
					String topVideoThumbnailURL = "/video-player-portlet/images/default-video-thumbnail.jpg";
					
					if(Validator.equals(topVideo.getVideoType(), VideoConstants.EXTERNAL_VIDEO_TYPE)){
						
						String externalVideoId = VideoFileUtil.getVideoIdFromYoutubeURL(topVideo.getVideoUrl());
						
						topVideoURL = VideoFileUtil.getEmbedYoutubeVideoURL(videoFrameWidth, videoFrameHeight, externalVideoId);
						
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
								<div class="external-video-frame">
									<%=topVideoURL %>
								</div>
							</c:when>
							
							<c:otherwise>
								<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
											
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
								</aui:script>
							</c:otherwise>
						</c:choose>
					</div>
					
					<div class="top-video-title">
						<a href="javascript:;"><%=topVideoTitle %></a>
					</div>
						
					<div class="video-playlist">
						<ul>
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
							
							String videoPublishDate = dateTimeFormat.format(videoEntry.getCreateDate());
						%>
						
							<liferay-portlet:renderURL var="videoPlaylistURL">
								<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoEntry.getEntryId()) %>"/>
							</liferay-portlet:renderURL>
							
							<li>
								<a href="<%=videoPlaylistURL %>" title="<%=videoTitle %>">
									<span class="video-title"><%=videoTitle %></span>
									<c:if test='<%=showVideoPublishDate %>'>
										<span class="video-upload-date"><%=videoPublishDate %></span>
									</c:if>
								</a>
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
							<a href="<%=viewMoreVideoURL%>"><liferay-ui:message key="more-video"/> >>></a>
						</div>
						
						<div style="clear: both;"></div>
					</c:if>
				</div>
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="no-video-found"/>
			</c:otherwise>
		</c:choose>
	</div>
		
</div>
<script>
	$('.tab-display').click (function(){
		$('.tab-display.active').removeClass('active');
		$(this).addClass('active');
		var tabstype = $(this).attr('tabs-type');
		
		if (tabstype=='video')
		{
			$('.image-gallery-display-content').hide();
			$('.video-gallery-display-content').show();
		}
		else
		{
			$('.image-gallery-display-content').show();
			$('.video-gallery-display-content').hide();
		}
		
	});
</script>