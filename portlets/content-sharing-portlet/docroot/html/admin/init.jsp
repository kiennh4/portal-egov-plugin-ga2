<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.prefs.Preferences"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>

 
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
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	long userId = PortalUtil.getUserId(request);
	
	long companyId = PortalUtil.getCompanyId(request);
	
	User user = PortalUtil.getUser(request);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss"); 
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String contentSharingAdminPortletId = "contentsharingadmin_WAR_contentsharingportlet";
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String[] contentAvailableViewDetail = new String[]{"assetentry","audioplayer_audiofile","videoentry","vbpq_entry"};
	
%>

<liferay-portlet:renderURL var="contentSharingAdminPageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="contentSharingConfigPageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/content-sharing-config/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="contentSharingConfigAdminPageURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/content-sharing-config/admin.jsp"/>
</liferay-portlet:renderURL>


	