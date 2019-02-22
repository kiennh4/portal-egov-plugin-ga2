<%@page import="com.portal_egov.portlet.contacts.service.ContactsPropertyLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsProperty"%>
<%@page import="com.liferay.portal.model.UserConstants"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.Contacts"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/contacts_admin/init.jsp"%>

<%
	long contactId = ParamUtil.getLong(request, "contactId");
	
	Contacts contact = null;
	
	if(contactId > 0L){
		
		contact = ContactsLocalServiceUtil.getContacts(contactId);
	}
%>

<c:if test='<%=Validator.isNotNull(contact) %>'>
	
	<div class="contact-details">
		
		<div>
			<div class="contact-portrait">
				<img class="contact-portrait-img" src="<%=UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, contact.getImageId())%>"/>		
			</div>	
			<div class="contact-infomation">
				<div class="contact-name"><%=contact.getContactName() %></div>
				<div class="contact-job-title"><%=contact.getJobTitle() %></div>
			</div>
		</div>
		
		<div style="clear: both;"></div>
		
		<div class="contact-info">
			<table>
				<tr>
					<td class="contact-info-attr-name"><liferay-ui:message key="contact-phone-numbers"/></td>
					<td><%=contact.getPhoneNumbers() %></td>
				</tr>
							
				<tr>
					<td class="contact-info-attr-name"><liferay-ui:message key="contact-mobile-numbers"/></td>
					<td><%=contact.getMobile()%></td>
				</tr>
							
				<tr>
					<td class="contact-info-attr-name"><liferay-ui:message key="contact-email"/></td>
					<td><%=contact.getEmail() %></td>
				</tr>
				<%
				List<ContactsProperty> contactPropertyList = ContactsPropertyLocalServiceUtil.findByContact(contactId);
				
				for(ContactsProperty contactProperty : contactPropertyList){
				%>			
				<tr>
					<td class="contact-info-attr-name"><liferay-ui:message key="<%=contactProperty.getPropertyKey() %>"/></td>
					<td><%=contactProperty.getPropertyValue() %></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</c:if>
