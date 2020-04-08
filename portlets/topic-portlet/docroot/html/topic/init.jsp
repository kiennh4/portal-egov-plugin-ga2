<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
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
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
 
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
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	long groupId = PortalUtil.getScopeGroupId(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}

	long userId = PortalUtil.getUserId(request);
	
	long companyId = PortalUtil.getCompanyId(request);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss"); 
	
	String topicAdminPortletId = "topic_WAR_topicportlet";
	
	int numberTopicDisplay = Integer.parseInt(preferences.getValue("numberTopicDisplay", "5"));
	
	String allTopicPageUrl = PortalUtil.getHomeURL(request)+ "/" + preferences.getValue("allTopicUrl", "chuyen-de");
	
	String bigStyle = "big";
	
	String smallStyle = "small";
	
	String topicStyle = preferences.getValue("topicStyle", smallStyle);
	
	long topicPageLayoutId = GetterUtil.getLong(preferences.getValue("topicPageLayoutId",
			String.valueOf(themeDisplay.getPlid())));

	int delta = GetterUtil.getInteger(preferences.getValue("delta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);

	String paginationType =  PropsKeys.SEARCH_CONTAINER_SHOW_PAGINATION_BOTTOM;
%>
