<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.Set"%>
<%@page import="com.bkav.portal.portlet.license_manager.util.LicenseUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<portlet:defineObjects />

<div class="license-manager">

	<liferay-ui:error exception="<%=Exception.class %>" message="invalid-license-file"/>
	
	<div class="license-info">
		<h2 class="product-name"><%=LicenseUtil.getProductName() %></h2>
		<h3 class="product-versions"><liferay-ui:message key="product-versions"/>&nbsp;<%=LicenseUtil.getProductVersion() %></h3>
		<h3 class="provider-name"><%=LicenseUtil.getProviderName() %></h3>

		<table class="license-table">
			<tr>
				<th class="header-title"><liferay-ui:message key="server-info"/></th>
				<th class="header-title"><liferay-ui:message key="license-registered"/></th>
			</tr>
			<tr>
				<td style="border: 1px solid gray;">
					<table class="license-table">
						<tr>
							<th><liferay-ui:message key="server-host-name"/></th>
							<th><liferay-ui:message key="server-ip-address"/></th>
							<th><liferay-ui:message key="server-mac-address"/></th>
						</tr>
						<tr>
							<td><%=LicenseUtil.getHostName() %></td>
							<td>
								<%
								for (String ipAddress : StringUtil.split(LicenseUtil.getIpAddresses())) {
								%>
									<%= ipAddress %><br />
								<%
								}
								%>
							</td>
							<td>
								<%
								for (String macAddress : StringUtil.split(LicenseUtil.getMacAddresses())) {
								%>
									<%= macAddress %><br />
								<%
								}
								%>
							</td>
						</tr>
					</table>
				</td>
				<td style="border: 1px solid gray;">
					<table class="license-table">
						<tr>
							<th><liferay-ui:message key="license-product-name" /></th>
							<th><liferay-ui:message key="license-product-version" /></th>
							<th><liferay-ui:message key="license-start-date" /></th>
							<th><liferay-ui:message key="license-expiration-date" /></th>
							<th><liferay-ui:message key="license-max-users" /></th>
							<th><liferay-ui:message key="license-max-sites" /></th>
							<th><liferay-ui:message key="license-max-instances" /></th>
						</tr>
						<tr>
							<td><%=LicenseUtil.getProductName() %></td>
							<td><%=LicenseUtil.getProductVersion() %></td>
							<td><%=LicenseUtil.getStartDate() %></td>
							<td><%=LicenseUtil.getExpirationDate() %></td>
							<td><%=LicenseUtil.getMaxUsers() %></td>
							<td><%=LicenseUtil.getMaxSites() %></td>
							<td><%=LicenseUtil.getMaxInstances() %></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div class="license-update-form">
		<liferay-portlet:actionURL name="uploadLicenseFile" var="uploadLicenseFileActionURL" />
		
		<aui:form enctype="multipart/form-data" name="licenseUploadForm" method="post" action="<%=uploadLicenseFileActionURL %>">
			<aui:input name="licenseUploadFile" type="file" />
			
			<aui:button-row>
				<aui:button type="submit" value="save"/>
			</aui:button-row>
		</aui:form>
	</div>
</div>