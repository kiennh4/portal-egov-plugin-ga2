<%@page import="com.liferay.compat.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<div class="search-container">
	<div class="search-form">
		<form id="lookup-document">
			<div class="header-title">
				<span><liferay-ui:message key="header-title"/></span>
			</div>
			<div class="input-group">
				<input type="text" name="documentId" id="documentId" placeholder='Mã số biên nhận'>
				<span class="input-group-addon" id="lookup-button"><liferay-ui:message key="search"/></span>
			</div>
		</form>
	</div>
	
	<div id="result-search">
	
	</div>
</div>
