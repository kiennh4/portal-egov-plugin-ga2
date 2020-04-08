<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.kernel.servlet.ServletContextUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.ImageProcessorUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileVersion"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long javaScriptLastModified = ServletContextUtil.getLastModified(application, "/html/js/", true);
%>


<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request,"/image-gallery-portlet/js/jquery.easing.1.3.js", javaScriptLastModified)) %>" type="text/javascript"></script>

<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request,"/image-gallery-portlet/js/jquery.slideviewer.1.2.js", javaScriptLastModified)) %>" type="text/javascript"></script>

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
 		});
 		
		if(<%=useCustomImageSize %>){
		
			var imageThumbnail = imageGallerySlider.all('img');
			
			imageThumbnail.setStyles({
 			    height:  <%=imageThumbnailHeight %>,
			})
		}
	}
</aui:script>
