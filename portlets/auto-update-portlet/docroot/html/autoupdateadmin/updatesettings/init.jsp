<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@include file = "/html/autoupdateadmin/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%
	boolean isAutoUpdate = Boolean.parseBoolean(preferences.getValue("isAutoUpdate", "false"));
	boolean isUpdateByDay = Boolean.parseBoolean(preferences.getValue("isUpdateByDay", "false"));
	int autoUpdateHour = Integer.parseInt(preferences.getValue("autoUpdateHour", "0"));
	int autoUpdateMinutes = Integer.parseInt(preferences.getValue("autoUpdateMinutes", "0"));
	int autoUpdateDay = Integer.parseInt(preferences.getValue("autoUpdateDay", "-1"));
	
%>
