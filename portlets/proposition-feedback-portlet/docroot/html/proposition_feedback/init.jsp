<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.security.permission.PermissionThreadLocal"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	long companyId = themeDisplay.getCompanyId();
	
	long scopeGroupId = themeDisplay.getScopeGroupId();
	
	long userId = PortalUtil.getUserId(request);
	
	User user = null;
	
	if(userId > 0){
		user = UserLocalServiceUtil.getUser(userId);
	}
	
	Locale locale = PortalUtil.getLocale(request);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	

	String portletResource = ParamUtil.getString(request,"portletResource");
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//So luong du thao moi nhat hien thi tren trang chinh
	int numbersOfLastestProposition = GetterUtil.getInteger(preferences.getValue("numbersOfLastestProposition", "6"));
	
	//So luong du thao duoc nhieu nguoi quan tam hien thi tren trang chinh
	int numbersOfTopViewProposition = GetterUtil.getInteger(preferences.getValue("numbersOfTopViewProposition", "6"));

	//So luong du thao co nhieu gop y hien thi tren trang chinh
	int numbersOfTopFeedbackProposition = GetterUtil.getInteger(preferences.getValue("numbersOfTopFeedbackProposition", "6"));

	//So luong ket qua tim kiem du thao hien thi
	int numbersOfSearchResultProposition = GetterUtil.getInteger(preferences.getValue("numbersOfSearchResultProposition", "6"));

%>