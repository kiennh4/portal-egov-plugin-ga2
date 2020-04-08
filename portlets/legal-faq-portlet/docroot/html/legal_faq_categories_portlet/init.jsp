<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<%
	long scopeGroupId = PortalUtil.getScopeGroupId(request);

	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

	PortletPreferences preferences = PortalUtil.getPreferences(request);

	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}	

	//So luong Category hien thi mac dinh
	int defaultNumbersOfCategoriesDisplay = 6;
	
	//So luong category hien thi da Config
	int numbersOfCategoriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfCategoriesDisplay", String.valueOf(defaultNumbersOfCategoriesDisplay)));
	
	//Hien thi so luong cau hoi cua tung chuyen muc hay khong?
	boolean displayFAQCounter = GetterUtil.getBoolean(preferences.getValue("displayFAQCounter","false"));
%>
