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
	
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletId = PortalUtil.getPortletId(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}	
	
	//So luong Entry hien thi mac dinh
	int defaultNumbersOfEntriesDisplay = 6;
	
	//So luong cau hoi xem nhieu hien thi tren trang
	int numbersOfTopViewEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfTopViewEntriesDisplay", 
																		String.valueOf(defaultNumbersOfEntriesDisplay)));
	//So luong cau hoi moi cap nhat hien thi tren trang
	int numbersOfLastestEntriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfLastestEntriesDisplay", 
																		String.valueOf(defaultNumbersOfEntriesDisplay)));
%>
