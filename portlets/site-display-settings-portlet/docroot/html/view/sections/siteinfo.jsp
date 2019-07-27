<%@page import="com.bkav.portal.portlet.site_display_setting.util.SiteSettingConstants"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
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
	String headline = "";
	String description = "";
	String keywords = "";
	String image_url = "";
	String url = "";
	String type = "";
	
	Map<String,String> siteInfo = SiteSettingUtil.getSiteInfo(layoutSetId);
	if(!siteInfo.isEmpty()){
		headline = (String)siteInfo.get(SiteSettingConstants.HEADLINE);
		
		description = (String)siteInfo.get(SiteSettingConstants.DESCRIPTION);
		
		keywords = (String)siteInfo.get(SiteSettingConstants.KEYWORDS);
		
		type = (String)siteInfo.get(SiteSettingConstants.TYPE);
		
		url = (String)siteInfo.get(SiteSettingConstants.URL);
		
		image_url = (String)siteInfo.get(SiteSettingConstants.IMAGE_URL);
	}
	String redirectURL = ParamUtil.getString(request, "redirectURL");
%>
<div class="section-content">
	<h3><liferay-ui:message key="site-info-setting"/></h3>
	
	<liferay-portlet:actionURL name="updateSiteInfo" var="updateSiteInfoURL" >
		<liferay-portlet:param name="redirectURL" value="<%=redirectURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form method="post" name="fm" action="<%=updateSiteInfoURL %>">
		<aui:input name="headline" id="headline" label="headline" value="<%=headline %>"/>
		<aui:input name="siteImage" id="siteImage" label="site-image" value="<%=image_url %>"/>
		<aui:input name="description" id="description" label="description" value="<%=description %>"/>
		<aui:input name="url" id="url" label="url" value="<%=url %>"/>
		<aui:input name="keywords" id="keywords" label="keywords" value="<%=keywords %>"/>
		<aui:input name="type" id="type" label="type" value="<%=type %>"/>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button type="reset" value="reset"></aui:button>
		</aui:button-row>
		
	</aui:form>
</div>

