<%@page import="com.liferay.compat.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<liferay-ui:success key="send-success" message="thank-you-for-your-registry" />

<liferay-ui:success key="send-error" message="error-when-process-registry" />

<liferay-portlet:renderURL var="publicServiceHomeURL">
	<liferay-portlet:param name="jspPage" value="/html/public-service/view.jsp"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:actionURL name="updateRegistryContent"  var="updateRegistryActionURL">
	<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>" />
</liferay-portlet:actionURL>

<div class="public-service-registry-container">
	<form action="<%=updateRegistryActionURL %>" method="post" id="registryServiceForm">
		<label for="citizenName"><liferay-ui:message key="citizen-name"/><span class="warning"> (*)</span></label> 
		<input type="text" id="citizenName" name="citizenName" placeholder=""> 
		<div class="error" id="errorCitizenName"></div>
		
		<label for="citizenCode"><liferay-ui:message key="citizen-code"/><span class="warning"> (*)</span></label>
		<input type="text" id="citizenCode" name="citizenCode" placeholder=""> 
		<div class="error" id="errorCitizenCode"></div>
		
		<label for="citizenEmail"><liferay-ui:message key="citizen-email"/><span class="warning"> (*)</span></label> 
		<input type="email" id="citizenEmail" name="citizenEmail" placeholder="">
		<div class="error" id="errorCitizenEmail"></div> 
		
		<label for="citizenPhone"><liferay-ui:message key="citizen-phone"/><span class="warning"> (*)</span></label> 
		<input type="text" id="citizenPhone" name="citizenPhone" placeholder="">
		<div class="error" id="errorCitizenPhone"></div>
		<label for="citizenAddress"><liferay-ui:message key="citizen-address"/><span class="warning"> (*)</span></label> 
		
		<input type="text" id="citizenAddress" name="citizenAddress" placeholder="">
		<div class="error" id="errorCitizenAddress"></div> 
		<button class="btn btn-submit" type="submit" onclick='return submitForm();'><liferay-ui:message key="submit"/></button>
	</form>
</div>