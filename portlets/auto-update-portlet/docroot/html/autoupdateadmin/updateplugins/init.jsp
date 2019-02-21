<%@page import="com.liferay.portal.kernel.scheduler.StorageType"%>
<%@page import="com.liferay.portal.kernel.scheduler.SchedulerEngineUtil"%>
<%@page import="com.liferay.portal.kernel.messaging.DestinationNames"%>
<%@page import="com.liferay.portal.kernel.messaging.MessageBusUtil"%>
<%@page import="com.liferay.portal.kernel.scheduler.CronTrigger"%>
<%@page import="com.liferay.portal.kernel.scheduler.Trigger"%>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateScheduler"%>
<%@page import="com.liferay.portal.kernel.messaging.Message"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@include file = "/html/autoupdateadmin/init.jsp" %>
<%
%>