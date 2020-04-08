<%@page import="com.portal_egov.portlet.contacts.permission.ContactsDepartmentPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.contacts.model.Contacts"%>
<%@page import="com.portal_egov.portlet.contacts.permission.ContactsPermission"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/contacts_admin/init.jsp"%>

<script type="text/javascript" src="/contacts-portlet/js/service.js"></script>
	
<div class="contacts_admin">
	
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			
			<div class="contact-admin-btn-row" align="left">
						
				<c:if test="<%=ContactsDepartmentPermission.contains(permissionChecker, groupId, ContactsDepartmentPermission.ADD) %>">
					<aui:button type="button" name="addNewContactDepartmentBtn" value="add-new-contact-department"/>
				</c:if>		
				
				<c:if test="<%=ContactsPermission.contains(permissionChecker, groupId, ContactsPermission.ADD) %>">
					<aui:button type="button" name="addNewContactBtn" value="add-new-contact"/>
				</c:if>		
						
				<c:if test="<%=ContactsPermission.contains(permissionChecker, groupId, ContactsPermission.PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=Contacts.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="contact-admin-search-form" align="right">
				<input type="text" id='<portlet:namespace />contactSearchInput' value=""/>
				<aui:button type="button" name="showAllContactsBtn" value="show-all"/>
			</div>
		</div>
	</div>
	
	<div class="contact-admin-data">
		<aui:layout>
			<aui:column columnWidth="40" cssClass="contact-departments">
				<div class="contact-column-header"><liferay-ui:message key="contact-department-list"/></div>
				<div id="<portlet:namespace/>contact-departments-container" class="contact-departments-container"></div>
			</aui:column>
			<aui:column columnWidth="60" cssClass="contacts">
				<div class="contact-column-header"><liferay-ui:message key="contact-list"/></div>
				<aui:layout>
					<aui:column columnWidth="50" cssClass="contacts">
						<div id="<portlet:namespace/>contacts-container" class="contacts-container"></div>		
					</aui:column>	
					<aui:column columnWidth="50" cssClass="contacts-info">
						<div id="<portlet:namespace/>contact-detail-container" class="contact-detail-container"></div>	
					</aui:column>
				</aui:layout>
			</aui:column>
		</aui:layout>
	</div>
</div>

<aui:script use="portal-egov-contacts-admin">
	
	new Liferay.Portlet.ContactsAdmin(
		{
			scopeGroupId: <%= groupId %>,
			portletId: '<%= portletId %>'
		}
	);
</aui:script>