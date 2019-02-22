<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.portal_egov.portlet.weather.util.WeatherConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//Kieu hien thi
	String displayStyle = preferences.getValue("displayStyle", "default");
	
	//Ma tra cuu thong tin thoi tiet cua Tinh/TP da chon
	String selectedCityVMCode = preferences.getValue("selectedCityVMCode", WeatherConstants.HA_NOI_CITY_VM_CODE);
	
	//Hien thi select box chon Tinh/TP tren trang hien thi
	boolean displayCustomCityName = GetterUtil.getBoolean(preferences.getValue("displayCustomCityName", null), false);
	
	String customCityName = preferences.getValue("customCityName", StringPool.BLANK);
%>