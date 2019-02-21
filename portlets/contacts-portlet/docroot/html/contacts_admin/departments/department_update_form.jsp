<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.contacts.model.impl.ContactsDepartmentPropertyImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentPropertyLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartmentProperty"%>
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
	long parentDepartmentId = ParamUtil.getLong(request, "parentDepartmentId");

	//Id cua don vi cap tren lay tu URL
	long departmentId = ParamUtil.getLong(request, "departmentId");
	
	ContactsDepartment contactDepartment = null;
	
	if(departmentId > 0L){
		
		contactDepartment = ContactsDepartmentLocalServiceUtil.getContactsDepartment(departmentId);
		
		if(contactDepartment != null){
			parentDepartmentId = contactDepartment.getParentId();
		}
	}
	
	//Danh sach co quan,don vi hien co trong database
	List<ContactsDepartment> parentDepartmentList = ContactsDepartmentLocalServiceUtil.findByGroup(groupId);
	
	List<ContactsDepartmentProperty> departmentPropertyList = ContactsDepartmentPropertyLocalServiceUtil.findByContactsDepartment(departmentId);
	
	int[] departmentPropertyIndexes = new int[0];
	
	if(departmentPropertyList.isEmpty()){
		
		departmentPropertyList = new ArrayList<ContactsDepartmentProperty>();
		
		departmentPropertyList.add(new ContactsDepartmentPropertyImpl());
		
		departmentPropertyIndexes = new int[] {0};
		
	}else{
		
		departmentPropertyIndexes = new int[departmentPropertyList.size()];

		for (int i = 0; i < departmentPropertyList.size(); i++) {
			departmentPropertyIndexes[i] = i;
		}
	}
%>

<div class="contacts_update_form">

	<liferay-portlet:renderURL var="contactAdminURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/contacts_admin/contacts_admin.jsp"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:actionURL name="updateDepartment" var="updateDepartmentURL">
		<liferay-portlet:param name="departmentId" value="<%=String.valueOf(departmentId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=contactAdminHomePageURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form name="add_new_department_form" method="post" action="<%=updateDepartmentURL %>">

		<aui:select name="parentDepartmentId" label="parent-department">
			<aui:option label="none" value="0" selected="<%=parentDepartmentId == 0L %>"/>
			<%for(ContactsDepartment parentDepartment : parentDepartmentList){ %>
				<aui:option label="<%=parentDepartment.getDepartmentName() %>" 
							value="<%=parentDepartment.getDepartmentId() %>"
							selected="<%=parentDepartmentId == parentDepartment.getDepartmentId() %>"
				/>
			<%} %>
		</aui:select>
		
		<aui:input  type="text" name="departmentName" label="contact-department-name" 
					value="<%=(contactDepartment != null) ? contactDepartment.getDepartmentName() : StringPool.BLANK %>">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input type="textarea" name="departmentAddress" value="<%=(contactDepartment != null) ? contactDepartment.getDepartmentAddress() : StringPool.BLANK  %>"/>
		
		<aui:input type="text" name="departmentPhone" value="<%=(contactDepartment != null) ? contactDepartment.getDepartmentPhone() : StringPool.BLANK  %>"/>
		
		<aui:input type="text" name="departmentWebsite" value="<%=(contactDepartment != null) ? contactDepartment.getDepartmentWebsite() : StringPool.BLANK  %>"/>
		
		<aui:input type="text" name="departmentEmail" value="<%=(contactDepartment != null) ? contactDepartment.getDepartmentEmail() : StringPool.BLANK  %>"/>
		
		<aui:fieldset id="department_attribute_fields">
		<%
		for(int i = 0; i<departmentPropertyIndexes.length; i++){
			
			ContactsDepartmentProperty departmentProperty = departmentPropertyList.get(i);
		%>
		
			<div class="lfr-form-row ">
				<div class="row-fields">																								
					<aui:input type="text" name="departmentPropertyKey" value="<%=departmentProperty.getPropertyKey() %>"/>
					<aui:input type="text" name="departmentPropertyValue" value="<%=departmentProperty.getPropertyValue() %>"/>
				</div>
			</div>
		
		
		<%} %>
			<aui:input type="hidden" name="departmentPropertyIndexes" value="<%=StringUtil.merge(departmentPropertyIndexes) %>"/>
		</aui:fieldset>
		<aui:button type="button" value="save" onClick='updateDepartmentInfo();'/>
	</aui:form>
</div>
<script type="text/javascript">

	AUI().ready('aui-form-validator,aui-overlay-context-panel',function(A){
		
		window.validator = new A.FormValidator({

	        boundingBox: document.<portlet:namespace />add_new_department_form,
	        fieldContainer: 'span',
	        validateOnBlur: false,
	        selectText: false,
	        rules: {
	            <portlet:namespace />departmentName: {
	                required: true,
	                rangeLength: ['3','500']
	            },
	            <portlet:namespace />departmentAddress: {
	                required: false,
	                rangeLength: ['0','1000']
	            },
	            <portlet:namespace />departmentPhone: {
	                required: false,
	                rangeLength: ['0','75']
	            },
	            <portlet:namespace />departmentWebsite: {
	                required: false,
	                rangeLength: ['0','150']
	            },
	            <portlet:namespace />departmentEmail: {
	                required: false,
	                rangeLength: ['0','75']
	            }
	        },
	        fieldStrings: {
	            <portlet:namespace />departmentName: {
	                required: '<liferay-ui:message key="please-enter-department-name"/>',
	                rangeLength: '<liferay-ui:message key="department-name-must-in-3-to-300-range-length"/>'
	            },
	            <portlet:namespace />departmentAddress: {
	                rangeLength: '<liferay-ui:message key="department-address-must-in-1000-range-length"/>'
	            },
	            <portlet:namespace />departmentPhone: {
	                rangeLength: '<liferay-ui:message key="department-phone-must-in-75-range-length"/>'
	            },
	            <portlet:namespace />departmentWebsite: {
	                rangeLength: '<liferay-ui:message key="department-website-must-in-150-range-length"/>'
	            },
	            <portlet:namespace />departmentEmail: {
	                rangeLength: '<liferay-ui:message key="department-email-must-in-75-range-length"/>'
	            }
	        }
	    });
	});
	
	function updateDepartmentInfo(){
		window.validator.validate();
		
		if (!window.validator.hasErrors()) {
			submitForm(document.<portlet:namespace />add_new_department_form);			
		}
	}
</script>

<aui:script use="liferay-auto-fields">
		
		var departmentPropertyFields = new Liferay.AutoFields({
				contentBox: 'fieldset#_contacts_admin_WAR_contactsportlet_department_attribute_fields',
				fieldIndexes: '_contacts_admin_WAR_contactsportlet_departmentPropertyIndexes'
			}
		).render();
</aui:script>
