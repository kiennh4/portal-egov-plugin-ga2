<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.complaints.permission.ComplaintsPermission"%>
<%@page import="com.bkav.portal.portlet.complaints.service.ComplaintsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.complaints.model.Complaints"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/complaintsadmin/init.jsp"%>
<%
	int complaintIndex = 0;
	
	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		complaintIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	String complaintSearchKeyword = ParamUtil.getString(request, "complaintSearchKeyword");
	
	List<Complaints> complaintList = ComplaintsLocalServiceUtil.findByKeyWord(groupId, complaintSearchKeyword, -1, -1, null);
%>

<div class="complaint-admin">
	
	<liferay-portlet:renderURL var="complaintAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/complaintsadmin/view.jsp"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:renderURL var="complaintUpdateFormURL">
		<liferay-portlet:param name="jspPage" value="/html/complaintsadmin/complaints_update_form.jsp"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="permission-btn-row" align="left">
				<c:if test="<%=ComplaintsPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">
					<aui:button value="add-new" href="<%=complaintUpdateFormURL %>"/>
				</c:if>
				
				<c:if test="<%=ComplaintsPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Complaints.class.getName() %>"
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
			
			<liferay-ui:search-container-row className="Complaints" keyProperty="complaintId" modelVar="complaint" escapedModel="<%=true %>">
				<%
				complaintIndex ++;
				
				String complaintTitle = StringUtil.shorten(complaint.getComplaintName(), 80);
				
				%>
						
				<liferay-portlet:renderURL var="updateComplaintURL">
					<liferay-portlet:param name="jspPage" value="/html/complaintsadmin/complaints_update_form.jsp"/>
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
					<c:if test="<%=ComplaintsPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">		
						<liferay-ui:icon image="edit" message="edit" url="<%= updateComplaintURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete"  align="center">
					<c:if test="<%=ComplaintsPermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
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