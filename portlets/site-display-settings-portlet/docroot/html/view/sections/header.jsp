<%@page import="com.bkav.portal.portlet.site_display_setting.util.SiteSettingUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	long bannerImageId = SiteSettingUtil.getBannerImageId(layoutSetId);

	String bannerImageUrl = "";
	
	boolean isFlashBanner = false;
	
	if (bannerImageId > 0)
	{
		bannerImageUrl = SiteSettingUtil.getImageBannerFilePath(request, bannerImageId);
	
		isFlashBanner = SiteSettingUtil.getImageBannerMimeType(request, bannerImageId).equals("swf");
	
	}

	String redirectURL = ParamUtil.getString(request, "redirectURL");
%>
<div class="section-content">
	<h3><liferay-ui:message key="header-image"/></h3> 
	
	<liferay-portlet:actionURL name="updateHeaderContent" var="updateHeaderContentActionURL" >
		<liferay-portlet:param name="redirectURL" value="<%=redirectURL %>"/>
	</liferay-portlet:actionURL>
	<c:choose>
		<c:when test="<%=isFlashBanner %>">
			<object>
				<param name="wmode" value="transparent">
				<EMBED  SRC="<%=bannerImageUrl %>" 
						WIDTH="100%" 
						HEIGHT="180"
						PLAY="true" 
						LOOP="true" 
						QUALITY="high" 
						scale="noborder" 
						wmode="transparent" 
						PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
				> 
				</EMBED>
			</object>
		</c:when>
		<c:otherwise>
			<img src = "<%=bannerImageUrl %>" width = "100%" height = "180px" />
		</c:otherwise>
	</c:choose>
	<aui:form enctype="multipart/form-data" method="post" name="fm" action="<%=updateHeaderContentActionURL %>">
		<liferay-ui:message key="banner-image-extensions"/>
		<aui:input label="" name="bannerImageFile" size="50" type="file" />
		
		<aui:input type="hidden" name="bannerImageId" value="<%=bannerImageId %>"/>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
		</aui:button-row>
	</aui:form>
</div>






