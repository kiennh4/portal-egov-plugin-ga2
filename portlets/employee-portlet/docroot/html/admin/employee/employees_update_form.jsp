<%@page import="com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.service.DepartmentLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Department"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portlet.documentlibrary.DuplicateFolderNameException"%>

<%@page import="com.bkav.portal.portlet.employee.service.PostLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.employee.model.Post"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.employee.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
long emplId = ParamUtil.getLong(request, "emplId");

Employee employee = EmployeeLocalServiceUtil.getEmployee(emplId);

long selecteDepId = employee.getDepId();
long selectePostId = employee.getPostId();
String selecteMale = employee.getMale();
List<Department> listDep = DepartmentLocalServiceUtil.findByGroup(groupId);
List<Post> listPost = PostLocalServiceUtil.findByGroup(groupId);

%>
<c:choose>
<c:when test='<%=SessionMessages.contains(renderRequest, "post-save-done")%>' >
	<aui:script>
       Liferay.Util.getOpener().refresh();
       Liferay.Util.getWindow().close();
    </aui:script>
</c:when>
<c:otherwise>
<%
long depId = ParamUtil.getLong(request, "department");
long postId = ParamUtil.getLong(request, "post");
%>
<liferay-portlet:actionURL name="updateEmployees" var="addEmployeesActionURL">
   <liferay-portlet:param name="emplId" value="<%=String.valueOf(emplId)%>" />
   <liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
</liferay-portlet:actionURL>
<!-- .Employees_add_form -->
<div class="employees_update_form">
    <aui:form name="employee_update_form" method="post" action="<%=addEmployeesActionURL %>">
        <aui:input name="name" value='<%=employee.getName() %>'>
        </aui:input>
        <aui:select label="gender" name="male">
			<aui:option label="male" value="male" />
			<aui:option label="female" value="female"/>
		</aui:select>
		<aui:input name="phone" type="text" value="<%=employee.getPhone() %>"/>
		<aui:input name="addres" type="text" value="<%=employee.getAddres() %>"/>
		<aui:input name="email" value="<%=employee.getEmail() %>" />
		<aui:select label="department" name="department">
			<%
			  for(Department dep : listDep){
			%>
			  <aui:option label="<%=dep.getDepName() %>" value="<%=dep.getDepId() %>" selected="<%=selecteDepId == dep.getDepId() %>"/>
			<%
			  }
			%>  
		</aui:select>
		<aui:select label="post" name="post">
			<%
			  for(Post post : listPost){
			%>
			  <aui:option label="<%=post.getPostName() %>" value="<%=post.getPostId() %>" selected="<%=selectePostId == post.getPostId() %>"/>
			<%
			  }
			%>  
		</aui:select>
		<aui:input name="endDate" value="<%=employee.getEndDate() %>"></aui:input>
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
    </aui:form>
</div>

<aui:script>
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
			
			var nameInput = A.one('#<portlet:namespace/>name');
			
			if(nameInput){
				nameInput.focus();
			}
			
			var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
			
			if(closeFormBtn){
				
				closeFormBtn.on('click',function(){
					
					Liferay.Util.getWindow().close();
				});
			}
			
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />employee_update_form,
		
		        rules: {
		            <portlet:namespace />name: {
		                required: true,
		                rangeLength: ['3','300']
		            }
		        }
		    });
		});
</aui:script>
</c:otherwise>
</c:choose>
