<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	Layout layout = themeDisplay.getLayout();
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	long groupId = themeDisplay.getScopeGroupId();
	
	long userId = PortalUtil.getUserId(request);
		
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//Id cua banner duoc chon hien thi
	long bannerId = GetterUtil.getLong(preferences.getValue("bannerId", "0"));
	
	//Ten banner duoc chon hien thi
	String bannerTitle = preferences.getValue("bannerTitle", StringPool.BLANK);
	
	//Chieu cao hien thi cua banner
	int bannerImageHeight = GetterUtil.getInteger(preferences.getValue("bannerImageHeight", "0"));
	
	//Chieu dai hien thi cua banner
	long bannerImageWidth = GetterUtil.getLong(preferences.getValue("bannerImageWidth", "0"));
	
	//URL Lien ket cua banner
	String bannerLink = preferences.getValue("bannerLink", StringPool.BLANK);
	
	//BIen boolean xac dinh co hien thi border cho banner hay ko
	boolean bannerImageBorder = GetterUtil.getBoolean(preferences.getValue("bannerImageBorder", "true"));
	
	boolean linkToNewTab = GetterUtil.getBoolean(preferences.getValue("linkToNewTab", "true"));
%>