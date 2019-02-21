


<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%
	/**
	 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
	 *
	 * This library is free software; you can redistribute it and/or modify it under
	 * the terms of the GNU Lesser General Public License as published by the Free
	 * Software Foundation; either version 2.1 of the License, or (at your option)
	 * any later version.
	 *
	 * This library is distributed in the hope that it will be useful, but WITHOUT
	 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
	 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
	 * details.
	 */
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page
	import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@ page import="com.liferay.portlet.PortletURLUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page
	import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@ page import="java.text.Format"%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page import="com.bkav.portalentslider.action.SliderAdminAction"%>
<%@ page import="com.bkav.portalentslider.util.SliderUtil"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants"%>
<%@ page import="com.liferay.portal.service.ServiceContext"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Time"%>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.model.TicketConstants"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.service.TicketLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Ticket"%>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@ page import="java.util.ArrayList"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.bkav.portalentslider.util.PortletPropsValues"%>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.log.Log"%>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	PortletPreferences preferences = null;

	if (renderRequest != null) {
		preferences = renderRequest.getPreferences();
	}

	String portletResource = ParamUtil.getString(request,
			"portletResource");

	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);
	}

	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale,
			timeZone);
	Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(
			locale, timeZone);

	WindowState windowState = null;
	PortletMode portletMode = null;

	PortletURL currentURLObj = null;

	if (renderRequest != null) {
		windowState = renderRequest.getWindowState();
		portletMode = renderRequest.getPortletMode();

		currentURLObj = PortletURLUtil.getCurrent(renderRequest,
				renderResponse);
	} else if (resourceRequest != null) {
		windowState = resourceRequest.getWindowState();
		portletMode = resourceRequest.getPortletMode();

		currentURLObj = PortletURLUtil.getCurrent(resourceRequest,
				resourceResponse);
	}

	String currentURL = currentURLObj.toString();

	//String sliderAdminPortletName = "slideradmin_WAR_portalentsliderportlet";

	//String[] imageIds = preferences.getValues("imageIds", new String[]{});

	long sliderId = GetterUtil.getLong(
			preferences.getValue("sliderId", "0"), 0L);

	String sliderStyle = preferences.getValue("sliderStyle", "style1");

	String sliderPath = "/client/slider_display_style/" + sliderStyle
			+ ".jsp";

	int sliderWidth = GetterUtil.getInteger(
			preferences.getValue("sliderWidth", StringPool.BLANK), 600);

	int sliderHeight = GetterUtil
			.getInteger(preferences.getValue("sliderHeight",
					StringPool.BLANK), 300);

	String sliderItems = preferences.getValue("sliderItems",
			StringPool.BLANK);
	String styleTitle = preferences.getValue("styleTitle",
			StringPool.BLANK);

	/* boolean auto = GetterUtil.getBoolean(preferences.getValue("auto", String.valueOf(true)), true); */

	int duration = GetterUtil.getInteger(
			preferences.getValue("duration", String.valueOf(1000)),
			1000);

	int durationTimeout = GetterUtil.getInteger(
			preferences.getValue("durationTimeout",
					String.valueOf(1000)), 1000);
%>
