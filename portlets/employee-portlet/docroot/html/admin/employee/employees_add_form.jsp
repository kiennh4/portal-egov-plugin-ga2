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
Calendar birthday = CalendarFactoryUtil.getCalendar();
birthday.set(Calendar.MONTH, Calendar.JANUARY);
birthday.set(Calendar.DATE, 1);
birthday.set(Calendar.YEAR, 1970);

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
   <liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
</liferay-portlet:actionURL>
<!-- .Employees_add_form -->
<div class="employees_add_form">
    <aui:form name="employee_add_form" method="post" action="<%=addEmployeesActionURL%>">
        <aui:input name="name" value=''>
            <aui:validator name="required"/>
        </aui:input>
        <aui:input model="<%= Employee.class %>" name="birthday" value="<%= birthday %>" />
        <aui:select label="gender" name="male">
			<aui:option label="male" value="male" />
			<aui:option label="female" value="female" />
		</aui:select>
		<aui:input name="phone" type="text"/>
		<aui:input name="addres" type="text"/>
		<aui:input name="email" value="" />
		<aui:select label="department" name="department">
			<%
			  for(Department dep : listDep){
			%>
			  <aui:option label="<%=dep.getDepName() %>" value="<%=dep.getDepId() %>" />
			<%
			  }
			%>  
		 </aui:select>
		 <aui:select label="post" name="post">
			<%
			  for(Post post : listPost){
			%>
			  <aui:option label="<%=post.getPostName() %>" value="<%=post.getPostId() %>" />
			<%
			  }
			%>  
		 </aui:select>
		 <aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		 </aui:button-row>
    </aui:form>
</div>

<aui:script>
	AUI().ready('aui-loading-mask', 'aui-io-request',function(A){
	
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
				
		Liferay.provide(
			window,
			'<portlet:namespace />updateEmployees',
			function() {
				
				var formContainer = A.one('#<portlet:namespace />employee_add_form');
				
				formContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
				
				formContainer.loadingmask.toggle();
				
				A.io.request(
					document.<portlet:namespace />employee_add_form.action,
					{
						dataType: 'html',
						form: {
							id: document.<portlet:namespace />employee_add_form
						},
						after: {
							success: function() {
								Liferay.Util.getOpener().refresh();
								Liferay.Util.getWindow().close();
							}
						}
					}
				);
			}
		);
	});			
</aui:script>
</c:otherwise>
</c:choose>
