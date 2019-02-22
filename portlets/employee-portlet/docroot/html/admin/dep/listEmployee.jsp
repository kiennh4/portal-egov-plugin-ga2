<%@page import="com.bkav.portal.portlet.employee.permission.employeePermission"%>
<%@page import="com.bkav.portal.portlet.employee.search.EmployeeSearch"%>
<%@page import="com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>


<%
int emplIndex = 0;
PortletURL portletURL = renderResponse.createRenderURL();
EmployeeSearch employeeSearch = new EmployeeSearch(renderRequest,portletURL);
long depId = ParamUtil.getLong(request, "depId");
%>

<div class="EMPLOYEES">
		
		<liferay-ui:search-container emptyResultsMessage="no-entry-found" >
		    <%
		        List<Employee> listEmployee = EmployeeLocalServiceUtil.findByDep(depId);	
		    %>
		    <liferay-ui:search-container-results
				results="<%=listEmployee%>"
				total="<%=listEmployee.size() %>"
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
					
				<liferay-ui:search-container-column-text name="employee-name" value="<%=employee.getName()%>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(employee.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=employee.getUserName()%>"/>
				
				<liferay-ui:search-container-column-text name="email" value="<%=employee.getEmail()%>"/>
				
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=true %>"/>
		</liferay-ui:search-container>
</div>