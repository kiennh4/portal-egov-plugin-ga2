<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartment"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<%@include file="/html/contacts_admin/init.jsp"%>

<%
	long departmentId = ParamUtil.getLong(request, "departmentId");
	
	ContactsDepartment contactDepartment = null;
	
	if(departmentId > 0L){
		
		contactDepartment = ContactsDepartmentLocalServiceUtil.getContactsDepartment(departmentId);
	}
%>

<c:if test='<%=Validator.isNotNull(contactDepartment) %>'>
	<div class="contact-department-details">
		<div class="department-name"><%=contactDepartment.getDepartmentName() %></div>
		
		<div class="department-info">
			<table>
				<tr>
					<td class="department-info-attr-name"><liferay-ui:message key="department-address"/></td>
					<td><%=contactDepartment.getDepartmentAddress() %></td>
				</tr>
							
				<tr>
					<td class="department-info-attr-name"><liferay-ui:message key="department-phone"/></td>
					<td><%=contactDepartment.getDepartmentPhone() %></td>
				</tr>
							
				<tr>
					<td class="department-info-attr-name"><liferay-ui:message key="department-website"/></td>
					<td><%=contactDepartment.getDepartmentWebsite() %></td>
				</tr>
							
				<tr>
					<td class="department-info-attr-name"><liferay-ui:message key="department-email"/></td>
					<td><%=contactDepartment.getDepartmentEmail() %></td>
				</tr>
				<%
				List<ContactsDepartmentProperty> departmentPropertyList = ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(departmentId);
				
				for(ContactsDepartmentProperty departmentProperty : departmentPropertyList){
				%>			
				<tr>
					<td class="department-info-attr-name"><liferay-ui:message key="<%=departmentProperty.getPropertyKey() %>"/></td>
					<td><%=departmentProperty.getPropertyValue() %></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</c:if>
