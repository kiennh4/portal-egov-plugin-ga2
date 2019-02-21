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

<%
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	long companyId = themeDisplay.getCompanyId();
	
	long groupId = themeDisplay.getScopeGroupId();
	
	long userId = PortalUtil.getUserId(request);
		
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//Danh muc duoc chon trong cau hinh
	long defaultCategoryId = GetterUtil.getLong(preferences.getValue("defaultCategoryId", "0"));
	
	//Kieu hien thi dang nhieu Tab chuyen muc
	String multiTabsDisplayStyle = "multiTabsDisplayStyle";
	
	//Kieu hien thi dang danh sach tieu de cac website
	String listTitleDisplayStyle = "listTitleDisplayStyle";
	
	//Kieu hien thi.Mac dinh la kieu default
	String displayStyle = preferences.getValue("displayStyle", "defaultDisplayStyle");
	
	//Array chua Id cua cac chuyen muc duoc hien thi theo Tab
	String[] selectedWeblinkTabIds = preferences.getValues("selectedWeblinkTabIds", new String[0]);
	
	//So luong lien ket hien thi tren moi Tab
	int numbersOfWeblinkPerTab = GetterUtil.getInteger(preferences.getValue("numbersOfWeblinkPerTab", "6"));
	
	//Id cua chuyen muc hien thi danh sach lien ket(tuong ung voi kieu hien thi dang danh sach lien ket)
	long selectedCategoryId = GetterUtil.getLong(preferences.getValue("selectedCategoryId", "0"));
	
	//So luong lien ket hien thi theo chuyen muc (tuong ung voi kieu hien thi dang danh sach lien ket)
	int numbersOfWeblinkDisplayList = GetterUtil.getInteger(preferences.getValue("numbersOfWeblinkDisplayList", "0"));
	
%>