
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/citymap_banner/init.jsp"%>

<%
	Image mapBannerImage = null;

	String mapBannerImagePath = "/city_maps-portlet/images/city_map_default_img.jpg";

	if(bannerImageId > 0){
		
		mapBannerImage = ImageLocalServiceUtil.getImage(bannerImageId);
		
		if(mapBannerImage != null && mapImageWidth == 0 && mapImageHeight == 0){
			
			mapImageWidth = mapBannerImage.getWidth();
			
			mapImageHeight = mapBannerImage.getHeight();
		}
		
		mapBannerImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + bannerImageId + "&t" + WebServerServletTokenUtil.getToken(bannerImageId);
	}
%>

<liferay-portlet:actionURL portletConfiguration="true" var="cityMapConfigurationActionURL" />

<aui:form name="city_map_config_form" method="post" action="<%=cityMapConfigurationActionURL %>" enctype="multipart/form-data">
	
	<div class="citymap-config-panel">
	
		<img id="<portlet:namespace/>mapBannerImage" class="banner-thumbnail-img" alt="" src="<%=mapBannerImagePath%>" 
				style="border: 1px solid #E4E4E4;margin-bottom: 10px;">
		
		<aui:input type="file" name="bannerImageFile" label="choose-image-file"/>
		
		<aui:input name="mapImageWidth" value="<%=mapImageWidth %>">
			<aui:validator name="digits"/>
		</aui:input>
				
		<aui:input name="mapImageHeight" value="<%=mapImageHeight %>">
			<aui:validator name="digits"/>
		</aui:input>
		
		<aui:input type="textarea" name="cityMapDisplayPageURL" label="map-display-page-url" value="<%=cityMapDisplayPageURL %>"/>
		
		<aui:input type="hidden" name="bannerImageId" value="<%=String.valueOf(bannerImageId) %>"/>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
		
</aui:form>

<script type="text/javascript">

	AUI().ready('aui-base',function(A){
		
		var mapBannerImage = A.one('#<portlet:namespace/>mapBannerImage');
		
		if(mapBannerImage){
			
			mapBannerImage.setStyles({
			    height:  <%=mapImageHeight %>,
			    width:   <%=mapImageWidth %>,
			    display: 'block'
			});
		}
	});
</script>