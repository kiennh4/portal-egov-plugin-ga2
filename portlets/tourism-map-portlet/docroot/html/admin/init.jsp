<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

	long groupId = themeDisplay.getScopeGroupId();
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//API key mac dinh
	String defaultMapAPIKey = "AIzaSyAdeuxLfD_bJTCj33hva4Dyar8nzwSTNDA";
	
	//API key cua Google map
	String mapAPIKey = preferences.getValue("mapAPIKey", defaultMapAPIKey);
	
	String 	hybridMapTypeId = "google.maps.MapTypeId.HYBRID";
	
	String 	terrainMapTypeId = "google.maps.MapTypeId.TERRAIN";
	
	String 	satelLiteMapTypeId = "google.maps.MapTypeId.SATELLITE";
	
	String 	roadmapMapTypeId = "google.maps.MapTypeId.ROADMAP";
	
	//Kieu ban do mac dinh
	String defaultMapType = preferences.getValue("defaultMapType", terrainMapTypeId);
	
	//Level zoom mac dinh
	int defaultZoomLevel = GetterUtil.getInteger(preferences.getValue("defaultZoomLevel", "13"));
	
	//Vi do mac dinh cua trung tam ban do (Quang truong Ba Dinh - Ha noi)
	String defaultMapCenterLatitude = "21.037083";
	
	//Vi do cua diem trung tam ban do
	String mapCenterLatitude = preferences.getValue("mapCenterLatitude", defaultMapCenterLatitude);
	
	//Kinh do mac dinh cua trung tam ban do (Quang truong Ba Dinh - Ha noi)
	String defaultMapCenterLongitude = "105.835284";
	
	//Kinh do cua diem trung tam ban do
	String mapCenterLongitude = preferences.getValue("mapCenterLongitude", defaultMapCenterLongitude);
	
	//Source Path thu vien google map
	String mapAPISourcePath = "http://maps.google.com/maps/api/js?key=" + mapAPIKey + "&sensor=false";
	
%>