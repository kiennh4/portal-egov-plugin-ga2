<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.compaints.service.ComplaintLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.compaints.search.ComplaintSearch"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.compaints.model.Complaint"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.compaints.permission.ComplaintPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int complaintIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		complaintIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}

	String complaintSearchKeyword = ParamUtil.getString(request, "complaintSearchKeyword");
	
	List<Complaint> complaintList = ComplaintLocalServiceUtil.findByKeyword(groupId, complaintSearchKeyword, -1, -1, -1, null);
%>

<div class="complaint-admin">
	
	<liferay-portlet:renderURL var="complaintAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:renderURL var="complaintUpdateFormURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/complaint_update_form.jsp"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="permission-btn-row" align="left">
				<c:if test="<%=ComplaintPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">
					<aui:button value="add-new" href="<%=complaintUpdateFormURL %>"/>
				</c:if>
				
				<c:if test="<%=ComplaintPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Complaint.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>	
						
			<div class="complaint-admin-search-form" align="right">
				<aui:form name="fm" method="post" action="<%=complaintAdminURL %>">
				
					<input type="text" 
							id="<portlet:namespace/>complaintSearchKeyword" size="40" 
							name="complaintSearchKeyword" value='<%= complaintSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=complaintAdminURL %>"/>
				</aui:form>	
			</div>		
		</div>
	</div>
	
	<div class="complaint-list">
		<liferay-portlet:renderURL varImpl="complaintAdminImplURL">
			<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
			<liferay-portlet:param name="complaintSearchKeyword" value="<%=complaintSearchKeyword %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container iteratorURL="<%=complaintAdminImplURL %>" delta="20" emptyResultsMessage="no-data">
			
			<liferay-ui:search-container-results 
				results="<%=ListUtil.subList(complaintList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=complaintList.size() %>"/>
			
			<liferay-ui:search-container-row className="Complaint" keyProperty="complaintId" modelVar="complaint" escapedModel="<%=true %>">
				<%
				complaintIndex ++;
				
				String complaintTitle = StringUtil.shorten(complaint.getComplaintTitle(), 80);
				
				%>
						
				<liferay-portlet:renderURL var="updateComplaintURL">
					<liferay-portlet:param name="jspPage" value="/html/admin/complaint_update_form.jsp"/>
					<liferay-portlet:param name="complaintId" value="<%=String.valueOf(complaint.getComplaintId()) %>"/>
				</liferay-portlet:renderURL>
		
				<liferay-ui:search-container-column-text 
					name="#" value="<%=String.valueOf(complaintIndex)%>" 
					title="view"
				/>
								
				<liferay-ui:search-container-column-text 
					name="title" 
					value="<%=complaintTitle%>" 
					href="<%=updateComplaintURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="create-date" 
					value="<%=dateFormat.format(complaint.getCreateDate())%>"
					orderable="true"
					orderableProperty="createDate"
					href="<%=updateComplaintURL %>"
					title="view" 
				/>
																
				<liferay-ui:search-container-column-text 
					name="modified-date" 
					value="<%=dateFormat.format(complaint.getModifiedDate())%>"
					orderable="true"
					orderableProperty="modifiedDate"
					href="<%=updateComplaintURL %>"
					title="view" 
				/>
												
				<liferay-ui:search-container-column-text name="edit"  align="center">
					<c:if test="<%=ComplaintPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">		
						<liferay-ui:icon image="edit" message="edit" url="<%= updateComplaintURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete"  align="center">
					<c:if test="<%=ComplaintPermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
						<liferay-portlet:actionURL  name="deleteComplaint" var="deleteComplaintActionURL">
							<liferay-portlet:param name="complaintId" value="<%=String.valueOf(complaint.getComplaintId()) %>"/>
							<liferay-portlet:param name="redirectURL" value="<%=complaintAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteComplaintActionURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>