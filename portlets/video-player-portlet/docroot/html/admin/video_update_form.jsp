<%@page import="com.bkav.portal.portlet.video.model.VideoCategoryMap"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryMapLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoFileUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.bkav.portal.portlet.video.ThumbnailImageFileSizeException"%>
<%@page import="com.bkav.portal.portlet.video.ThumbnailImageFileTypeException"%>
<%@page import="com.bkav.portal.portlet.video.VideoFileSizeException"%>
<%@page import="com.bkav.portal.portlet.video.VideoFileTypeException"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.bkav.portal.portlet.video.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoEntry"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	boolean useVideoThumbnail = true;

	long videoFileId = 0L;
	
	long thumbnailImageId = 0L;
	
	String videoType = VideoConstants.INTERNAL_VIDEO_TYPE;
	
	long videoId = ParamUtil.getLong(request, "videoId");

	VideoEntry videoEntry = null;
	
	long categoryId = 0L;
	
	if(videoId > 0){
		
		videoEntry = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
		
		if(videoEntry != null){
			
			videoType = videoEntry.getVideoType(); 
			videoFileId = videoEntry.getVideoFileId();
			thumbnailImageId = videoEntry.getThumbnailImageId();
			
			List<VideoCategoryMap> listMap = VideoCategoryMapLocalServiceUtil.findByEntry(videoEntry.getEntryId());
			
			if ((Validator.isNotNull(listMap))&&(listMap.size()>0))
				categoryId = listMap.get(0).getCategoryId();
		}
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateVideo();";
	
	List<VideoCategory> listCate = VideoCategoryLocalServiceUtil.findByGroup(groupId);
	
	
%>

<div class="video-update-form">
	
	<c:choose>
	
		<c:when test='<%= SessionMessages.contains(renderRequest, "request_processed") %>'>
			<aui:script>
				Liferay.Util.getOpener().refresh();
				Liferay.Util.getWindow().close();
			</aui:script>
		</c:when>
		
		<c:otherwise>
		
			<liferay-ui:error exception="<%= VideoFileTypeException.class %>">
				<liferay-ui:message arguments="<%= videoExtensions %>" 
									key="please-enter-a-video-file-with-a-valid-file-type-in-x" />
			</liferay-ui:error>
				
			<liferay-ui:error exception="<%= VideoFileSizeException.class %>">
				<liferay-ui:message arguments="<%= videoMaxSize %>" 
									key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x-MB" />
			</liferay-ui:error>
				
			<liferay-ui:error exception="<%= ThumbnailImageFileTypeException.class %>">
				<liferay-ui:message arguments="<%= imageThumbnailExtensions %>" 
									key="please-enter-a-thumbnail-image-file-with-a-valid-file-type-in-x" />
			</liferay-ui:error>
				
			<liferay-ui:error exception="<%= ThumbnailImageFileSizeException.class %>">
				<liferay-ui:message arguments="<%= imageThumbnailMaxSize %>" 
									key="please-enter-a-thumbnail-image-file-with-a-valid-file-size-no-larger-than-x-MB" />
			</liferay-ui:error>
			
			<liferay-portlet:actionURL portletName="<%=videoAdminPortletResource %>" name="updateVideo" var="updateVideoActionURL">
				<liferay-portlet:param name="videoId" value="<%=String.valueOf(videoId) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
	
			<aui:form name="fm" enctype="multipart/form-data" method="post" action="<%=updateVideoActionURL%>" >
			
				<aui:model-context bean="<%= videoEntry %>" model="<%= VideoEntry.class %>" />
						
				<aui:input name="name" label="video-title">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:select name="videoCategory">
					<c:choose>
						<c:when test="<%=(listCate.size()>0) %>">
							<aui:option label = "video-category" 
										value = ""
										selected = "<%=(Validator.equals(categoryId, 0L)) %>"
							/>
							<%
								for (int i = 0; i < listCate.size();i++)
								{
							%>
								<aui:option label = "<%=listCate.get(i).getCategoryName() %>" 
											value = "<%=listCate.get(i).getCategoryId() %>"
											selected = "<%=Validator.equals(listCate.get(i).getCategoryId(), categoryId) %>"	
								/>
							<%
								}
							%>
						</c:when>
						<c:otherwise>
							<aui:option  label = "no-category" value = "0L"/>
						</c:otherwise>
					</c:choose>
				</aui:select>
				
				<aui:select name="videoType">
					<aui:option label="internal" value="<%=VideoConstants.INTERNAL_VIDEO_TYPE %>" 
								selected='<%=Validator.equals(videoType, VideoConstants.INTERNAL_VIDEO_TYPE) %>'/>
					<aui:option label="external" value="<%=VideoConstants.EXTERNAL_VIDEO_TYPE %>" 
								selected='<%=Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE) %>'/>
				</aui:select>
				
				<c:if test="<%=videoEntry != null%>">
					<c:choose>
						<c:when test='<%=Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE) %>'>
							<div class="video-embed-preview"><%=videoEntry.getVideoUrl() %></div>
						</c:when>
						<c:otherwise>
							<%
							
							String videoURL = "";
							
							String videoThumbnailURL = "/video-player-portlet/images/default-video-thumbnail.jpg";
							
							if(videoEntry.getVideoFileId() > 0){
								
								FileEntry videoFileEntry = DLAppServiceUtil.getFileEntry(videoEntry.getVideoFileId());
								
								if(videoFileEntry != null){
									
									videoURL = VideoFileUtil.getVideoPreviewURL(themeDisplay, videoFileEntry);
								}
							}
							
							if(videoEntry.getThumbnailImage() && videoEntry.getThumbnailImageId() > 0){
								
								FileEntry thumbnailImage = DLAppServiceUtil.getFileEntry(videoEntry.getThumbnailImageId());
								
								if(thumbnailImage != null){
									
									videoThumbnailURL = VideoFileUtil.getVideoThumbnailURL(themeDisplay, thumbnailImage);
								}
							}
							%>
							
							<div id="<portlet:namespace />video-player-container" class="video-player-frame" >
								<div class="video-player" id="<portlet:namespace />videoPlayer"></div>
							</div>
		
							<aui:script>
								AUI().ready(function(A){
									jwplayer("<portlet:namespace />videoPlayer").setup({
							            flashplayer: '/video-player-portlet/jwplayer/jwplayer.flash.swf',
							            file: '<%=videoURL%>',
							            image: '<%=videoThumbnailURL %>',
					    		        height: 210,
							            width: 350
							        });
								});
							</aui:script>
						</c:otherwise>
					</c:choose>
				</c:if>
				
				<div id="<portlet:namespace />video-url-container" 
					 class='<%=Validator.equals(videoType, VideoConstants.INTERNAL_VIDEO_TYPE) ? "aui-helper-hidden" : ""%>'>
					<aui:input name="videoUrl" label="video-url"/>
				</div>
				
				<div id="<portlet:namespace />video-upload-container"
					 class='<%=Validator.equals(videoType, VideoConstants.EXTERNAL_VIDEO_TYPE) ? "aui-helper-hidden" : ""%>'>
					<aui:input type="file" name="videoFile" />
										
					<aui:input type="hidden" name="videoFileId" value="<%=videoFileId %>"/>
				</div>	
											
				<aui:input type="checkbox" name="videoThumbnailImage" value="<%=useVideoThumbnail %>"/>
				
				<div id="<portlet:namespace />video-thumbnail-img-container" class="aui-helper-hidden">
					<aui:input type="file" name="videoThumbnailImageFile" />
				</div>
				
				<aui:input type="hidden" name="thumbnailImageId" value="<%=thumbnailImageId %>"/>
					
				<aui:button-row>
					<aui:button type="submit" value="save"/>
					<aui:button name="closeFormBtn" value="cancel"/>
				</aui:button-row>
				
			</aui:form>
		</c:otherwise>
	</c:choose>
</div>

<aui:script>
	Liferay.Util.toggleBoxes('<portlet:namespace />videoThumbnailImageCheckbox','<portlet:namespace />video-thumbnail-img-container');
</aui:script>

<aui:script>
	AUI().ready(function(A){
		
		var videoTypeSelector = A.one('#<portlet:namespace/>videoType');
		
		if(videoTypeSelector){
			
			videoTypeSelector.on('change',function(){
				
				var selectedValue = videoTypeSelector.val();
				
				var videoUrlContainer = A.one('#<portlet:namespace />video-url-container');
				
				var videoUploadContainer = A.one('#<portlet:namespace />video-upload-container');
				
				if(selectedValue == '<%=VideoConstants.INTERNAL_VIDEO_TYPE %>'){
					videoUrlContainer.hide();
					videoUploadContainer.show();
				}else{
					videoUrlContainer.show();
					videoUploadContainer.hide();
					
					var videoPlayerContainer = A.one('#<portlet:namespace />video-player-container');
					
					if(videoPlayerContainer){
						videoPlayerContainer.hide();
					}
				}
			});
		}
		
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});			
</aui:script>