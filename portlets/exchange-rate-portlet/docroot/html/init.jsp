<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	PortletPreferences preferences = PortalUtil.getPreferences(request);
	
	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	//Kieu hien thi mac dinh.HIen thi ca thong tin thoi tiet va gia vang
	String defaultDisplayStyle = "default";
	
	//Kieu hien thi thong tin gia vang
	String goldPriceStyle = "goldPriceStyle";
	
	//Kieu hien thi thong tin ty gia
	String currencyRateStyle = "currencyRateStyle";
	
	//Kieu hien thi.Co the chi hien thi gia vang hoac ty gia.Mac dinh la hien thi ca 2 tren cung 1 trang
	String displayStyle = preferences.getValue("displayStyle", defaultDisplayStyle);
	
	//Tieu de hien thi cua bang ty gia
	String currencyRateTitle = preferences.getValue("currencyRateTitle", "currency-rate");
	
	
%>