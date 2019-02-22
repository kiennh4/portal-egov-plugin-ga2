<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-3/init.jsp"%>

<liferay-ui:panel-container>

	<liferay-util:include page="/html/style/style-4/tab-config/tab1.jsp" servletContext="<%=this.getServletContext() %>"/>
	
	<liferay-util:include page="/html/style/style-4/tab-config/tab2.jsp" servletContext="<%=this.getServletContext() %>"/>
	
	<liferay-util:include page="/html/style/style-4/tab-config/tab3.jsp" servletContext="<%=this.getServletContext() %>"/>

</liferay-ui:panel-container>

