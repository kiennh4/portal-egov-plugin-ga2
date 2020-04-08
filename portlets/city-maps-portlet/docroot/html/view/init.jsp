<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="java.util.Locale"%>
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

	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

	long companyId = themeDisplay.getCompanyId();
	
	long groupId = themeDisplay.getScopeGroupId();
	
	Locale locale = PortalUtil.getLocale(request);
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	//Id cua ban do hien thi mac dinh khi moi khoi tao portlet Ban do hanh chinh
	long defaultCityMapDisplayId = GetterUtil.getLong(preferences.getValue("defaultCityMapDisplayId", "0"));
%>