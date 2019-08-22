<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.liferay.portal.theme.PortletDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />
<%
	String languageId = LanguageUtil.getLanguageId(request);

	PortletPreferences preferences = PortalUtil.getPreferences(request);

	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if(Validator.isNotNull(portletResource)){
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

	long groupId = PortalUtil.getScopeGroupId(request);

	String portletId = PortalUtil.getPortletId(request).toString();
	
	Locale locale = PortalUtil.getLocale(request);
	
	long plid = themeDisplay.getPlid();
	
	//default config param
	String onlineChatDesc = preferences.getValue("onlineChatDesc", "");
	
	String reflectRequestDesc = preferences.getValue("reflectRequestDesc", "");
	
	String reflectFristUrl = preferences.getValue("reflectFristUrl", "");
	
	String reflectFirstName = preferences.getValue("reflectFirstName", "");
	
	String reflectSecondUrl = preferences.getValue("reflectSecondUrl", "");
	
	String reflectSecondName = preferences.getValue("reflectSecondName", "");
	
	String legalFaqDesc = preferences.getValue("legalFaqDesc", "");
	
	String legalFaqFirstUrl = preferences.getValue("legalFaqFirstUrl", "");
	
	String legalFaqFirstName =  preferences.getValue("legalFaqFirstName", "");
	
	String legalFaqSecondUrl = preferences.getValue("legalFaqSecondUrl", "");
	
	String legalFaqSecondName =  preferences.getValue("legalFaqSecondName", "");
	
	
%>



