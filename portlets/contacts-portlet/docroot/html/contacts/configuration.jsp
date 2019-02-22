<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.contacts.service.ContactsDepartmentLocalService"%>
<%@page import="com.portal_egov.portlet.contacts.model.ContactsDepartment"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">
	
	.contact-viewer-config-page{
		padding: 10px;
		margin: 0px;
		border: 1px solid #d2d2d2;
		border-radius: 2px;
	}
		
	.contact-viewer-config-page  .aui-field-content{
		padding-bottom: 15px;
	}
	
	.contact-viewer-config-page input[type="submit"],
	.contact-viewer-config-page  input[type="button"],
	.contact-viewer-config-page  button{
		border-color: #C8C9CA #9E9E9E #9E9E9E #C8C9CA !important;
		color: #00528B !important;
	}
					
				
	.contact-viewer-config-page input[type="text"]{
		background: none repeat scroll 0 0 #FFFFFF;
	    border: 1px solid #A1A2A4;
	    border-radius: 2px;
	    box-shadow: 0 1px 0 white, 0 1px 2px #CCCCCC inset;
	    padding: 5px 1px;
	    text-shadow: none;
		width: 280px;
		margin-right: 10px;
		color: #00528B !important;
	}
	
	.contact-viewer-config-page  input.focus{
		background: none repeat scroll 0 0 #F2F8F8 !important;
    	border: 1px solid #8DD4AE !important;
	}
	
	.contact-viewer-config-page  select{
		width: 284px;
		background-image: none;
		border-radius: 2px;
		box-shadow: 0 1px 0 white, 0 1px 2px #CCCCCC inset;
		padding: 5px;
		border: 1px solid #A1A2A4;
		text-shadow: none;
		color: #00528B !important;
	}
</style>

<%@include file="/html/contacts/init.jsp"%>

<%
	List<ContactsDepartment> listRootDepartments = ContactsDepartmentLocalServiceUtil.findByParentAndGroup(groupId, 0);
	
%>

<liferay-portlet:actionURL portletConfiguration="true" var="contactViewerConfigurationActionURL" />

<div class="contact-viewer-config-page">
	<aui:form name="contact_viewer_config_form" method="post" action="<%=contactViewerConfigurationActionURL %>">
	
		<aui:input name="showDepartmentOnly" type="checkbox" value="<%= showDepartmentOnly %>"/>
	
		<aui:input name="showEmptyDepartment" type="checkbox" value="<%= showEmptyDepartment %>"/>
		
		<aui:input name="showDepartmentInfo" type="checkbox" value="<%= showDepartmentInfo %>"/>
		
		<aui:select name="defaultDepartmentId">
			<%buildContactDepartmentTree(groupId, 0, 0, out, defaultDepartmentId); %>
		</aui:select>
		
		<aui:button type="submit" value="save"/>
	</aui:form>
</div>