<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.bkav.portal.portlet.employee.search.EmployeeSearch"%>
<%@page import="com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.employee.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.bkav.portal.portlet.employee.permission.employeePermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>
<% 
   int emplIndex = 0;
   String employeeAdminPortletResource = "admin_WAR_employeeportlet";
   //List<Employee> listEmployee = EmployeeLocalServiceUtil.findByKeyword(groupId, searchKeyword, 0, -1);
   String searchKeyword = ParamUtil.getString(request, "searchKeyword");
%>
<!-- .employees -->
<div class="employees">
    <liferay-portlet:renderURL var="employeesAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="employee"/>
	</liferay-portlet:renderURL>
    
    <!-- .lfr-header-row -->
    <div class="lfr-header-row">
        <div class="lfr-header-row-content">
             <div class="add_new_posts_button" align="left">
                  <c:if test="<%=employeePermission.contains(permissionChecker, groupId, employeePermission.ADD)%>">
					  <aui:button name="addNewEmployeeBtn" value="add-new-employee"/>
				  </c:if>
				  
				  <c:if test="<%=employeePermission.contains(permissionChecker, groupId, employeePermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Employee.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button name="employeePermissionsBtn" href="<%= permissionsURL %>" value="permissions" />
				</c:if>
             </div>
             
              <!-- .employee_search_form -->
			<div class="post_search_form" align="right">
				<aui:form name="employee_search_form" method="post" action="<%=employeesAdminHomePageURL%>">
					<input type="text" name="searchKeyword" value='<%=searchKeyword%>' />
					<aui:button type="submit" value="search" />
					<aui:button type="button" value="show_all" href="<%=employeesAdminHomePageURL%>" />
				</aui:form>
			</div>
        </div>
    </div>
    
    <%
	PortletURL portletURL = renderResponse.createRenderURL();
	EmployeeSearch employeeSearch = new EmployeeSearch(renderRequest,portletURL);
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "html/admin/employee/employees.jsp");
   %>

    <div class="EMPLOYEES">
		
		<liferay-ui:search-container searchContainer="<%=employeeSearch%>" emptyResultsMessage="no-entry-found" delta="5" iteratorURL="<%=iteratorURL %>">
		    <%
		        List<Employee> listEmployeeSortAble = EmployeeLocalServiceUtil.findByKeyword(groupId, 0L, 0L, searchKeyword, 
		        searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator(), "false", "", "", "");	
		    %>
		    <liferay-ui:search-container-results
				results="<%=listEmployeeSortAble%>"
				total="<%=listEmployeeSortAble.size() %>"
			/>			
		    
			<liferay-ui:search-container-row className="Employee"  keyProperty="emplId" modelVar="employee" >
			    
			    <%
		          emplIndex++;
			      String updateEmployeeURL = "javascrip:;";
				
				  if(employeePermission.contains(permissionChecker, groupId, employeePermission.UPDATE)){
					
					  updateEmployeeURL = "javascript:" + renderResponse.getNamespace() 
										+ "showEmployeeUpdateForm(" + String.valueOf(employee.getEmplId()) + ");";
				  }
				  
				  String updateSalaryURL = "javascrip:;";
					
				  if(employeePermission.contains(permissionChecker, groupId, employeePermission.UPDATE)){
					
					  updateSalaryURL = "javascript:" + renderResponse.getNamespace() 
										+ "showSalaryUpdateForm(" + String.valueOf(employee.getEmplId()) + ");";
				  }
		        %>

				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(emplIndex) %>"/>
					
				<liferay-ui:search-container-column-text name="employee-name" value="<%=employee.getName()%>" orderable="<%=true %>" orderableProperty="name"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(employee.getCreateDate())%>" orderable="<%=true %>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=employee.getUserName()%>"/>
				
				<liferay-ui:search-container-column-text name="edit">
					<c:if test="<%=employeePermission.contains(permissionChecker, groupId, employeePermission.UPDATE)%>">														
						<liferay-ui:icon image="edit" message="edit" url="<%=updateEmployeeURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete">
					<c:if test="<%=employeePermission.contains(permissionChecker, groupId, employeePermission.DELETE)%>">															
						<liferay-portlet:actionURL  name="deleteEmployee" var="deleteEmployeeURL">
							<liferay-portlet:param name="emplId" value="<%=String.valueOf(employee.getEmplId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=employeesAdminHomePageURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteEmployeeURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="Salary" value="Salary" href="<%=updateSalaryURL %>"/>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=true %>"/>
		</liferay-ui:search-container>
	</div>
    
</div>
</div>
<aui:script>
	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var addNewEmployeeBtn = A.one('#<portlet:namespace/>addNewEmployeeBtn');
		
		if(addNewEmployeeBtn){
			
			addNewEmployeeBtn.on('click',function(){

				var addEmployeeURL = Liferay.PortletURL.createRenderURL();
											
				addEmployeeURL.setPortletId('<%=employeeAdminPortletResource %>');
				addEmployeeURL.setWindowState('pop_up');
				addEmployeeURL.setParameter('jspPage', '/html/admin/employee/employees_add_form.jsp');
				addEmployeeURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-employee'),
					uri: addEmployeeURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace/>showEmployeeUpdateForm',
		function(emplId){
			
			var updateEmployeeURL = Liferay.PortletURL.createRenderURL();
										
			updateEmployeeURL.setPortletId('<%=employeeAdminPortletResource %>');
			updateEmployeeURL.setWindowState('pop_up');
			updateEmployeeURL.setParameter('jspPage', '/html/admin/employee/employees_update_form.jsp');
			updateEmployeeURL.setParameter('emplId', emplId);
			updateEmployeeURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('update-employee'),
				uri: updateEmployeeURL
			};
			
			Liferay.Util.openWindow(dialogWidow);
		}
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace/>showSalaryUpdateForm',
		function(emplId){
			
			var updateSalaryURL = Liferay.PortletURL.createRenderURL();
										
			updateSalaryURL.setPortletId('<%=employeeAdminPortletResource %>');
			updateSalaryURL.setWindowState('pop_up');
			updateSalaryURL.setParameter('jspPage', '/html/admin/employee/salary_update_form.jsp');
			updateSalaryURL.setParameter('emplId', emplId);
			updateSalaryURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('update-salary'),
				uri: updateSalaryURL
			};
			
			Liferay.Util.openWindow(dialogWidow);
		}
	);
	
  
	Liferay.provide(
		window,
		'refresh',
		function(){
			Liferay.Portlet.refresh('#p_p_id_admin_WAR_employeeportlet_');
		}
	);

</aui:script>

