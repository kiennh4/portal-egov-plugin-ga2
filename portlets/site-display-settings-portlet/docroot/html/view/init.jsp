<%@page import="com.liferay.portal.service.LayoutSetLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.site_display_setting.util.SiteSettingUtil"%>
<%@page import="com.liferay.portal.model.LayoutSet"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

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
	long layoutSetId = 0L;

	long groupId = PortalUtil.getScopeGroupId(request);

	long companyId = PortalUtil.getCompanyId(request);
	
	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	
	Locale locale = PortalUtil.getLocale(request);
	
	LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, false);
	
	if(layoutSet != null){
		layoutSetId = layoutSet.getLayoutSetId();
	}
%>
