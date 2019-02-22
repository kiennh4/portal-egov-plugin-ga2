<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/citymap_banner/init.jsp"%>

<%
	String mapBannerImagePath = "/city_maps-portlet/images/city_map_default_img.jpg";

	if(bannerImageId > 0){
		
		mapBannerImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + bannerImageId + "&t" + WebServerServletTokenUtil.getToken(bannerImageId);
	}
	
	String cityMapTitle = LanguageUtil.get(locale, "city-map");
%>

<div class="city-map-banner-image">
	<a href="<%=cityMapDisplayPageURL%>">
		<img id="<portlet:namespace/>mapBannerImage" class="banner-thumbnail-img" title="<%=cityMapTitle %>" src="<%=mapBannerImagePath%>">
	</a>
</div>

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