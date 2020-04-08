<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartment"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/contacts/init.jsp"%>

<script type="text/javascript" src="/contacts-portlet/js/service.js" ></script>

<c:choose>
	<c:when test="<%=showDepartmentOnly %>">
		<%
		int departmentIndex = 0;
		
		List<ContactsDepartment> departmentList = ContactsDepartmentLocalServiceUtil.findByGroup(groupId);
		%>
	
		<div class="contact-viewer">
			<div class="contact-viewer-content">
				<div class="contact-viewer-container">
					<table cellpadding="0" cellspacing="0" >
						<tr class="contact-viewer-header-row">
							<td><liferay-ui:message key="index"/></td>
							<td><liferay-ui:message key="contact-department-name"/></td>
							<td><liferay-ui:message key="department-phone"/></td>
							<td><liferay-ui:message key="department-email"/></td>
						</tr>
						<%
						for(ContactsDepartment department : departmentList){
							
							departmentIndex ++;
							
							String departmentName = department.getDepartmentName();
							String departmentPhone = department.getDepartmentPhone();
							String departmentEmail = department.getDepartmentEmail();
						%>
						<tr>
							<td><%=departmentIndex %></td>
							<td><%=departmentName %></td>
							<td><%=departmentPhone %></td>
							<td><%=departmentEmail %></td>
						</tr>	
						<%
						}
						%>
					</table>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="contact-viewer">
			<div class="contact-viewer-live-search" align="right">
				<aui:input type="text" placeholder="search" name="contactViewerSearchInput" label="" value=""/>
			</div>
			
			<div class="contact-viewer-content">
				<aui:layout>
					<aui:column columnWidth="25" cssClass="contact-department-column">
						<div id="<portlet:namespace/>department-treeview-container" class="department-treeview-container"></div>
					</aui:column>
					<aui:column columnWidth="75" cssClass="contact-column">
						<div id="<portlet:namespace/>contact-viewer-container" class="contact-viewer-container"></div>
					</aui:column>
				</aui:layout>
			</div>
		</div>
		
		<aui:script use="portal-egov-contacts-viewer">
			
			new Liferay.Portlet.ContactsViewer(
				{
					scopeGroupId: <%= groupId %>,
					portletId: '<%= portletId %>',
					showDepartmentInfo: <%= showDepartmentInfo %>,
					showEmptyDepartment: <%= showEmptyDepartment %>,
					defaultDepartmentId: <%= defaultDepartmentId %>
				}
			);
		</aui:script>
	</c:otherwise>
</c:choose>

