<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Department"%>
<%@page import="com.bkav.portal.portlet.employee.permission.departmentPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/admin/init.jsp"%>
<%
   String depAdminPortletResource = "admin_WAR_employeeportlet";
   int depIndex = 0;
   String depSearchKeyword = ParamUtil.getString(request, "depSearchKeyword");
   List<Department> listDep = DepartmentLocalServiceUtil.findByKeyword(groupId, depSearchKeyword, 0, -1);
   int postIndex = 0;
  
%>
<!-- .Deps -->
<div class="Dep">
    <liferay-portlet:renderURL var="depsAdminHomePageURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="dep"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:renderURL var="ajaxListEmployeeURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/admin/dep/listEmployee.jsp" />
	</liferay-portlet:renderURL>
    
    <!-- .lfr-header-row -->
    <div class="lfr-header-row">
        <div class="lfr-header-row-content">
             <div class="add_new_posts_button" align="left">
                  <c:if test="<%=departmentPermission.contains(permissionChecker, groupId, departmentPermission.ADD)%>">
					  <aui:button name="addNewDepBtn" value="add-new-dep"/>
				  </c:if>
				  
				  <c:if test="<%=departmentPermission.contains(permissionChecker, groupId, departmentPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=Department.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button name="depPermissionsBtn" href="<%= permissionsURL %>" value="permissions" />
				  </c:if>
             </div>
             
             <div class="post_search_form" align="right">
				<aui:form name="post_search_form" method="post" action="<%=depsAdminHomePageURL%>">
					<input type="text" id="<portlet:namespace/>categorySearchInput"
						name="depSearchKeyword"
						value='<%=depSearchKeyword%>' />
					<aui:button type="submit" value="search" />
					<aui:button type="button" value="show_all" href="<%=depsAdminHomePageURL%>" />
				</aui:form>
			</div>
        </div>
    </div>
    
    
    <div class="deps">
	
		<liferay-ui:search-container emptyResultsMessage="no-entry-found" >
			<liferay-ui:search-container-results
				results="<%=listDep%>"
				total="<%=listDep.size() %>"
			/>			
		  
			<liferay-ui:search-container-row className="Department" keyProperty="depId" modelVar="dep" >
				<%
				    depIndex++;
					
					int depCounter = DepartmentLocalServiceUtil.countByGroup(groupId);
					
					String updateDepURL = "javascrip:;";
					
					if(departmentPermission.contains(permissionChecker, groupId, departmentPermission.UPDATE)){
						
						updateDepURL = "javascript:" + renderResponse.getNamespace() 
											+ "showDepUpdateForm(" + String.valueOf(dep.getDepId()) + ");";
					}
					
                    String listEmployeeURL = "javascrip:;";
					
						
                    listEmployeeURL = "javascript:" + renderResponse.getNamespace() 
											+ "showListEmployee(" + String.valueOf(dep.getDepId()) + ");";
				%>
				
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(depIndex) %>"/>
					
				<liferay-ui:search-container-column-text name="dep-name" value="<%=dep.getDepName()%>" href="<%=listEmployeeURL %>"/>
				
				<liferay-ui:search-container-column-text name="dep-address" value="<%=dep.getDepAddres()%>"/>
				
				<liferay-ui:search-container-column-text name="dep-phone" value="<%=dep.getDepPhone()%>"/>
				
				<liferay-ui:search-container-column-text name="created-date" value="<%=dateFormat.format(dep.getCreateDate())%>"/>
				
				<liferay-ui:search-container-column-text name="created-by-user" value="<%=dep.getUserName()%>"/>
				
				<liferay-ui:search-container-column-text name="edit">
					<c:if test="<%=departmentPermission.contains(permissionChecker, groupId, departmentPermission.UPDATE)%>">														
						<liferay-ui:icon image="edit" message="edit" url="<%=updateDepURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete">
					<c:if test="<%=departmentPermission.contains(permissionChecker, groupId, departmentPermission.DELETE)%>">															
						<liferay-portlet:actionURL  name="deleteDeps" var="deleteDepURL">
							<liferay-portlet:param name="depId" value="<%=String.valueOf(dep.getDepId())%>"/>
							<liferay-portlet:param name="redirectURL" value="<%=depsAdminHomePageURL%>"/>
							<liferay-portlet:param name="deleteEmployees" value="<%=String.valueOf(false)%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteDepURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator paginate="<%=false %>"/>
		</liferay-ui:search-container>
	</div>
</div>
</br>

</br>
<div id="employee-file-container">

</div>
<aui:script>
	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
   Liferay.provide(
   window,
   '<portlet:namespace/>showListEmployee',
   function(depId) {
   
   A.io.request('<%=ajaxListEmployeeURL%>',{   
    
    data:{
     depId: depId,
     redirectUrl: '<%=PortalUtil.getCurrentURL(request) %>'
    },
    on: {   
     success: function(){
      
      var employeeList = this.get('responseData');
      
      var employeeListContainer = A.one('#employee-file-container');
      
      if(employeeListContainer && employeeList){
       
         employeeListContainer.empty();
       
         employeeListContainer.html(employeeList);
      }
     },
     failure:function(){
      
      var loadDataFailMsgTpl  = '<div class="portlet-msg-info">'
            +  '<liferay-ui:message key="load-data-failure"/>'
            + '</div>';
            
      var employeeListContainer = A.one('#<portlet:namespace/>employee-file-container');
      
      employeeListContainer.html(loadDataFailMsgTpl);
     }
    } 
   });
    
  });
		
		var addNewDepBtn = A.one('#<portlet:namespace/>addNewDepBtn');
		
		if(addNewDepBtn){
			
			addNewDepBtn.on('click',function(){

				var addDepURL = Liferay.PortletURL.createRenderURL();
											
				addDepURL.setPortletId('<%=depAdminPortletResource %>');
				addDepURL.setWindowState('pop_up');
				addDepURL.setParameter('jspPage', '/html/admin/dep/deps_add_form.jsp');
				addDepURL.setDoAsGroupId('<%=groupId %>');
							
				var dialogWidow = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 400,
						cache: false
					},
					title: Liferay.Language.get('add-new-dep'),
					uri: addDepURL
				};
				
				Liferay.Util.openWindow(dialogWidow);				
			});
		}
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace/>showDepUpdateForm',
		function(depId){
			
			var updateVideoURL = Liferay.PortletURL.createRenderURL();
										
			updateVideoURL.setPortletId('<%=depAdminPortletResource %>');
			updateVideoURL.setWindowState('pop_up');
			updateVideoURL.setParameter('jspPage', '/html/admin/dep/deps_update_form.jsp');
			updateVideoURL.setParameter('depId', depId);
			updateVideoURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('update-dep'),
				uri: updateVideoURL
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