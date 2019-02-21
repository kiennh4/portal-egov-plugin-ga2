<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.impl.ContactsPropertyImpl"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsPropertyLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsProperty"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.Contacts"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartment"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/contacts_admin/init.jsp"%>

<%
	long departmentId = ParamUtil.getLong(request, "departmentId");
	
	long contactId = ParamUtil.getLong(request, "contactId",0L);
	
	Contacts contact = null;
	
	if(contactId > 0){
		contact = ContactsLocalServiceUtil.getContacts(contactId);
		if(contact != null){
			
			departmentId = contact.getDepartmentId();
		}
	}
	
	//Danh sach co quan,don vi hien co trong database
	List<ContactsDepartment> contactDepartmentList = ContactsDepartmentLocalServiceUtil.findByGroup(groupId);
	
	List<ContactsProperty> contactPropertyList = ContactsPropertyLocalServiceUtil.findByContact(contactId);
	
	int[] contactPropertyIndexes = new int[0];
	
	if(contactPropertyList.isEmpty()){
		
		contactPropertyList = new ArrayList<ContactsProperty>();
		
		contactPropertyList.add(new ContactsPropertyImpl());
		
		contactPropertyIndexes = new int[] {0};
		
	}else{
		
		contactPropertyIndexes = new int[contactPropertyList.size()];

		for (int i = 0; i < contactPropertyList.size(); i++) {
			contactPropertyIndexes[i] = i;
		}
	}
%>

<div class="contacts_update_form">

	<liferay-portlet:renderURL var="contactAdminURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/contacts_admin/contacts_admin.jsp"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:actionURL name="updateContact" var="updateContactURL">
		<liferay-portlet:param name="contactId" value="<%=String.valueOf(contactId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=contactAdminHomePageURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form name="add_new_contact_form" method="post" enctype="multipart/form-data" action="<%=updateContactURL %>">

		<aui:select name="departmentId" label="select-contact-department">
			<aui:option label="none" value="0" selected="<%=departmentId == 0L %>"/>
			<%for(ContactsDepartment contactDepartment : contactDepartmentList){ %>
				<aui:option label="<%=contactDepartment.getDepartmentName() %>" 
							value="<%=contactDepartment.getDepartmentId() %>"
							selected="<%=departmentId == contactDepartment.getDepartmentId() %>"
				/>
			<%} %>
		</aui:select>
			
		<aui:input name="contactName" value="<%=(contact != null) ? contact.getContactName() : StringPool.BLANK  %>">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input type="text" name="jobTitle" label="contact-job-title" value="<%=(contact != null) ? contact.getJobTitle() : StringPool.BLANK  %>"/>
		
		<aui:input name="contactAvatarFile" size="50" type="file" label="avatar-image"/>
		
		<aui:input type="text" name="phoneNumbers" label="contact-phone-numbers" value="<%=(contact != null) ? contact.getPhoneNumbers() : StringPool.BLANK  %>"/>
		
		<aui:input type="text" name="homePhone" label="contact-home-phone-numbers" value="<%=(contact != null) ? contact.getHomePhone() : StringPool.BLANK  %>"/>
		
		<aui:input type="text" name="mobile" label="contact-mobile-numbers" value="<%=(contact != null) ? contact.getMobile() : StringPool.BLANK  %>"/>
		
		<aui:input type="text" name="email" label="contact-email" value="<%=(contact != null) ? contact.getEmail() : StringPool.BLANK  %>"/>
	
		<aui:fieldset id="contact_attribute_fields">
		<%
		for(int i = 0; i<contactPropertyIndexes.length; i++){
			
			ContactsProperty contactProperty = contactPropertyList.get(i);
		%>
			<div class="lfr-form-row ">
				<div class="row-fields">																								
					<aui:input type="text" name="contactPropertyKey" value="<%=contactProperty.getPropertyKey() %>"/>
					<aui:input type="text" name="contactPropertyValue" value="<%=contactProperty.getPropertyValue() %>" />
				</div>
			</div>
		<%
		}
		%>
		</aui:fieldset>
		
		<aui:input type="hidden" name="contactPropertyIndexes"  value="<%=StringUtil.merge(contactPropertyIndexes) %>"/>
		
		<aui:button type="button" value="save" onClick='updateContactInfo();'/>
		
	</aui:form>
</div>

<script type="text/javascript">

	AUI().ready('aui-form-validator,aui-overlay-context-panel',function(A){
		
		window.validator = new A.FormValidator({

	        boundingBox: document.<portlet:namespace />add_new_contact_form,
	        fieldContainer: 'span',
	        validateOnBlur: false,
	        selectText: false,
	        rules: {
	            <portlet:namespace />contactName: {
	                required: true,
	                rangeLength: ['3','150']
	            },
	            <portlet:namespace />jobTitle: {
	                required: false,
	                rangeLength: ['0','150']
	            },
	            <portlet:namespace />phoneNumbers: {
	                required: false,
	                rangeLength: ['0','75']
	            },
	            <portlet:namespace />homePhone: {
	                required: false,
	                rangeLength: ['0','75']
	            },
	            <portlet:namespace />mobile: {
	                required: false,
	                rangeLength: ['0','75']
	            },
	            <portlet:namespace />email: {
	                required: false,
	                rangeLength: ['0','75']
	            }
	        },
	        fieldStrings: {
	            <portlet:namespace />contactName: {
	                required: '<liferay-ui:message key="please-enter-contact-name"/>',
	                rangeLength: '<liferay-ui:message key="contact-name-must-in-3-to-150-range-length"/>'
	            },
	            <portlet:namespace />jobTitle: {
	                rangeLength: '<liferay-ui:message key="contact-job-title-must-in-150-range-length"/>'
	            },
	            <portlet:namespace />phoneNumbers: {
	                rangeLength: '<liferay-ui:message key="contact-phone-numbers-must-in-75-range-length"/>'
	            },
	            <portlet:namespace />homePhone: {
	                rangeLength: '<liferay-ui:message key="home-phone-numbers-must-in-75-range-length"/>'
	            },
	            <portlet:namespace />mobile: {
	                rangeLength: '<liferay-ui:message key="contact-mobile-numbers-must-in-75-range-length"/>'
	            },
	            <portlet:namespace />email: {
	                rangeLength: '<liferay-ui:message key="contact-email-must-in-75-range-length"/>'
	            }
	        }
	    });
	});
	
	function updateContactInfo(){
		window.validator.validate();
		
		if (!window.validator.hasErrors()) {
			submitForm(document.<portlet:namespace />add_new_contact_form);			
		}
	}
</script>

<aui:script use="liferay-auto-fields">
		var contactPropertyFields = new Liferay.AutoFields({
				contentBox: 'fieldset#_contacts_admin_WAR_contactsportlet_contact_attribute_fields',
				fieldIndexes: '_contacts_admin_WAR_contactsportlet_contactPropertyIndexes'
			}
		).render();
</aui:script>