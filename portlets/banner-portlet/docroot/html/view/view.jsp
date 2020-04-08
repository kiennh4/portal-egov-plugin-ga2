<%@page import="com.portal_egov.portlet.banner.util.BannerUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.portal_egov.portlet.banner.service.BannerLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.banner.model.Banner"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	Banner displayBanner = null;

	String bannerImageSrcPath = "";

	if(bannerId > 0){
		
		displayBanner = BannerLocalServiceUtil.getBanner(bannerId);
		
		if(displayBanner.getBannerImageId() > 0){
			
			bannerImageSrcPath =  BannerUtil.getBannerImagePath(request, displayBanner.getBannerImageId());
		}
	}
	
	boolean showConfigPortletIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION);
	
%>
<c:choose>
	<c:when test="<%=displayBanner != null %>">
		<div class='<%="display-banner" + bannerId %> banner-image-wrapper'>
			<a href="<%=bannerLink%>" target="<%=(linkToNewTab) ? "_blank" : StringPool.BLANK %>">
				<img class='<%="banner-image" + bannerId %>' style="width: 100%;" src="<%=bannerImageSrcPath%>"/>
			</a>
		</div>
	</c:when>
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
				label="please-select-banner" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>

<aui:script>
	AUI().ready('aui-base',function(A){
		var bannerImage = A.one('.display-banner' + '<%=bannerId %>' + ' .banner-image' + '<%=bannerId %>');
		if(bannerImage){
			bannerImage.setStyles({
			    height:  <%=bannerImageHeight %>,
			    display: 'block'
			});
		}
	});
</aui:script>