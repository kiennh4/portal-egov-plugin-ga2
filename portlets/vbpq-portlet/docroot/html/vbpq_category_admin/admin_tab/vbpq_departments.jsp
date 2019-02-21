<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_EntryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.permission.VBPQCategoryPermission"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.util.VBPQConstants"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.service.VBPQ_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.vbpq.model.VBPQ_Category"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	int vbpqDepartmentIndex = 0;

	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		vbpqDepartmentIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}

	long departmentId = ParamUtil.getLong(request, "departmentId",0L);

	VBPQ_Category currentDepartment = null;
		
	if(departmentId > 0){
		
		currentDepartment = VBPQ_CategoryLocalServiceUtil.getCategory(departmentId);
	}
	
	String command = ParamUtil.getString(request, "command",StringPool.BLANK);
	
	String vbpqDepartmentSearchKeyword = ParamUtil.getString(request, "vbpqDepartmentSearchKeyword");
	
	//Danh sach CO quan ban hanh
	List<VBPQ_Category> departmentList = VBPQ_CategoryLocalServiceUtil.findByKeyword(groupId, VBPQConstants.DEPARTMENT_ID, vbpqDepartmentSearchKeyword, 0, -1);
%>
		
<liferay-portlet:renderURL var="vbpqDepartmentAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_category_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Departments"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:renderURL var="addNewDepartmentURL">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_category_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="Departments"/>
	<liferay-portlet:param name="command" value="updateDepartment"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="updateDepartmentActionURL" name="updateCategory">
	<liferay-portlet:param name="jspPage" value="/html/vbpq_category_admin/view.jsp" />
	<liferay-portlet:param name="tab1" value="Departments" />
</liferay-portlet:actionURL>

<div class="vbpq-category-admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			
			<div class="vbpq-control-btn-group" align="left">
				
				<c:if test="<%=VBPQCategoryPermission.contains(permissionChecker, groupId, VBPQCategoryPermission.ADD_CATEGORY) %>">
					<aui:button type="button" value="add-vbpq-department" href="<%=addNewDepartmentURL %>"/>
				</c:if>
								
				<c:if test="<%=VBPQCategoryPermission.contains(permissionChecker, groupId, VBPQCategoryPermission.CATEGORY_PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%=VBPQ_Category.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="vbpq-search-form" align="right">
						
				<aui:form name="vbpq_department_search_form" method="post" action="<%=vbpqDepartmentAdminURL %>">
				
					<input type="text" id="<portlet:namespace />vbpqDepartmentSearchInput" name="vbpqDepartmentSearchKeyword" value='<%= vbpqDepartmentSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=vbpqDepartmentAdminURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>

	<c:if test='<%=Validator.equals(command, "updateDepartment")%>'>
			
		<div class="vbpq-category-update-form" align="center">
			<br/>
			<aui:form name="vbpq_category_update_form"
					  method="post"	action="<%=updateDepartmentActionURL.toString() %>">
				<table>
					<tr>
						<td><liferay-ui:message key="vbpq-department-name"/> (<liferay-ui:message key="required"/>)</td>
						
						<td>
							<aui:input type="text" name="categoryName" label="" value='<%= currentDepartment != null ? currentDepartment.getCategoryName() : ""%>'/>
						</td>
					</tr>		
										
					<tr>
						<td><liferay-ui:message key="display-priority"/></td>
						<td>
							<aui:input type="text" name="displayPriority" label="" value='<%= currentDepartment != null ? currentDepartment.getDisplayPriority() : "0"%>'>
								<aui:validator name="digits"/>
							</aui:input>
						</td>
					</tr>
											
					<tr>
						<td><liferay-ui:message key="vbpq-department-desc"/></td>
						
						<td>
							<aui:input type="textarea" name="categoryDesc" label="" value='<%= currentDepartment != null ? currentDepartment.getCategoryDesc(): ""%>'/>
						</td>
					</tr>
					<tr>
						<td><liferay-ui:message key=""/></td>
						
						<td>
							<div class="aui-button-holder">
								<c:if test="<%=VBPQCategoryPermission.contains(permissionChecker, groupId, VBPQCategoryPermission.ADD_CATEGORY) %>">
									<aui:button type="submit"/>
								</c:if>							
								<aui:button type="button" value="cancel" href="<%=vbpqDepartmentAdminURL %>"/>
							</div>
						</td>
					</tr>
				</table>
				<aui:input type="hidden" name="categoryId"  value="<%=departmentId%>" />
				<aui:input type="hidden" name="categoryTypeId"  value="1" />
				<aui:input type="hidden" name="redirectURL"  value="<%=vbpqDepartmentAdminURL%>" />
			</aui:form>
		</div>		
	</c:if>
	
	<div class="vbpq-category-search-container">
					
		<liferay-ui:search-container emptyResultsMessage="no-department-found" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(departmentList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=departmentList.size() %>"
			>			
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="VBPQ_Category" keyProperty="categoryId" modelVar="vbpqDepartment" >
				
				<%
					vbpqDepartmentIndex ++;
				%>
																				
				<liferay-portlet:renderURL var="updateDepartmentURL" >
					<liferay-portlet:param name="departmentId" value="<%=String.valueOf(vbpqDepartment.getCategoryId())%>"/>
					<liferay-portlet:param name="command" value="updateDepartment"/>
					<liferay-portlet:param name="tabs1" value="Departments"/>
				</liferay-portlet:renderURL>
										
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(vbpqDepartmentIndex) %>"  
						title='<%=LanguageUtil.get(locale, "view") %>' 	href="<%=updateDepartmentURL %>"/>
			
				<liferay-ui:search-container-column-text name="vbpq-department-name" value="<%=vbpqDepartment.getCategoryName() %>" 
						title='<%=LanguageUtil.get(locale, "view") %>' href="<%=updateDepartmentURL %>"/>
				
				<liferay-ui:search-container-column-text name="vbpq-count" 
							value="<%=String.valueOf(VBPQ_EntryLocalServiceUtil.countByDepartmentAndGroup(groupId, vbpqDepartment.getCategoryId()))%>"/>
													
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(vbpqDepartment.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=UserLocalServiceUtil.getUser(vbpqDepartment.getUserId()).getFullName()%>"/>
				
				<c:if test="<%=VBPQCategoryPermission.contains(permissionChecker, groupId, VBPQCategoryPermission.UPDATE_CATEGORY) %>">
					<liferay-ui:search-container-column-text name="edit">					
						<liferay-ui:icon image="edit" message="edit" url="<%= updateDepartmentURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
														
				<c:if test="<%=VBPQCategoryPermission.contains(permissionChecker, groupId, VBPQCategoryPermission.UPDATE_CATEGORY) %>">
					<liferay-ui:search-container-column-text name="delete">									
						<liferay-portlet:actionURL  name="deleteCategory" var="deleteCategoryURL">
							<portlet:param name="categoryId" value="<%=String.valueOf(vbpqDepartment.getCategoryId())%>"/>
							<portlet:param name="redirectURL" value="<%=vbpqDepartmentAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteCategoryURL %>" />
					</liferay-ui:search-container-column-text>					
				</c:if>
				
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator paginate="<%=false %>" />
		</liferay-ui:search-container>
	</div>
</div>
<aui:script >
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var vbpqDepartmentSearchInput = A.one('#<portlet:namespace />vbpqDepartmentSearchInput');
		
		if(vbpqDepartmentSearchInput){
			vbpqDepartmentSearchInput.focus();
		}
		
		if(<%=Validator.equals(command, "updateDepartment")%>){
		
			var vbpqCategoryInput = A.one('#<portlet:namespace />categoryName');
			
			if(vbpqCategoryInput){
				vbpqCategoryInput.focus();
			}
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />vbpq_category_update_form,
		
		        rules: {
		            <portlet:namespace />categoryName: {
		                required: true,
		                rangeLength: ['1','300']
		            },
		            <portlet:namespace />categoryDesc: {
		                required: false,
		                rangeLength: ['0','500']
		            }
		        }
		    });
		}
	});

</aui:script>
