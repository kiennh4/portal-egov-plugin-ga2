<%@page import="com.bkav.portal.portlet.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portlet.documentlibrary.DuplicateFolderNameException"%>

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
%>
<c:choose>
<c:when test='<%=SessionMessages.contains(renderRequest, "post-save-done")%>' >
	<aui:script>
       Liferay.Util.getOpener().refresh();
       Liferay.Util.getWindow().close();
    </aui:script>
</c:when>
<c:otherwise>
<liferay-portlet:actionURL name="updateEmployees" var="updateEmployeesActionURL">
    <liferay-portlet:param name="postId" value="<%=String.valueOf(emplId)%>" />
    <liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
</liferay-portlet:actionURL>

<!-- .salary_update_form -->
<div class="salary_update_form">
    <aui:form name="salary_update_form" method="post" action="<%=updateEmployeesActionURL%>">
         <aui:input name="name" value="<%=employee.getName() %>" disable="disable">
            <aui:validator name="required"/>
         </aui:input>
         <aui:input name="breakDay"></aui:input>
         <aui:input name="addDay"></aui:input>
         <aui:input name="sal"></aui:input>
         <aui:input name="remunerate"></aui:input>
         <aui:input name="amerce"></aui:input>
		 <div class="aui-button-holder">
			<aui:button type="submit" value="save" />
			<aui:button name="closeFormBtn" value="cancel"/>
		 </div>
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
			'<portlet:namespace />updatePosts',
			function() {
				
				var formContainer = A.one('#<portlet:namespace />post_update_form');
				
				formContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
				
				formContainer.loadingmask.toggle();
				
				A.io.request(
					document.<portlet:namespace />post_update_form.action,
					{
						dataType: 'html',
						form: {
							id: document.<portlet:namespace />post_update_form
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
