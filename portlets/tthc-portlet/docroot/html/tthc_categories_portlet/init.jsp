<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
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

	String portletResource = ParamUtil.getString(request,"portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}	
	
	//Loai Category hien thi
	int tthcCategoryTypeId = GetterUtil.getInteger(preferences.getValue("tthcCategoryTypeId", String.valueOf(TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID)));
	
	//So luong Category hien thi mac dinh
	int defaultNumbersOfCategoriesDisplay = -1;
	
	//So luong category hien thi da Config
	int numbersOfCategoriesDisplay = GetterUtil.getInteger(preferences.getValue("numbersOfCategoriesDisplay", String.valueOf(defaultNumbersOfCategoriesDisplay)));
	
	//Hien thi so luong thu tuc
	boolean displayTTHCCount = GetterUtil.getBoolean(preferences.getValue("displayTTHCCount", null));
%>
