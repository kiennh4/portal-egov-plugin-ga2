<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.bkav.portal.portlet.audioplayer.model.AudioAlbum"%>
<%@page import="com.bkav.portal.portlet.audioplayer.service.AudioAlbumLocalServiceUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="java.util.List" %>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

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
	String audioplayerAdminPortletId = "audioadmin_WAR_audioplayerportlet";

	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	System.out.println(portletResource);
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	List<AudioAlbum> albumListTemp = AudioAlbumLocalServiceUtil.findByGroup(groupId);
	String defaultAlbum = "";
	if(albumListTemp != null && (albumListTemp.size() > 0)){
		defaultAlbum = preferences.getValue("default-album",StringUtil.valueOf(albumListTemp.get(0).getAlbumId()));	
	}
	
	String bigStyle = "big-style";
	
	String smallStyle = "small-style";
	
	String defaultStyle = smallStyle;
	
	String currentStyle = preferences.getValue("display-style", defaultStyle); 
	
	long audioplayerWidth = GetterUtil.getLong(preferences.getValue("audioplayerWidth", "0"));
%>