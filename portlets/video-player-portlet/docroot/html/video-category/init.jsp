<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.bkav.portal.portlet.video.util.VideoConstants"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	long groupId = PortalUtil.getScopeGroupId(request);
	
	Locale locale = PortalUtil.getLocale(request);
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	String videoAdminPortletResource = "videoadmin_WAR_videoplayerportlet";
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	long videocategoryPageLayoutId = GetterUtil.getLong(preferences.getValue("videocategoryPageLayoutId",
			String.valueOf(themeDisplay.getPlid())));
	
	String portletVideoPlayerId = "videoplayer_WAR_videoplayerportlet";
	
	int numCategoryDisplay = GetterUtil.getInteger(preferences.getValue("numCategoryDisplay", "5")); 
%>