<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long inquiryId = ParamUtil.getLong(request, "inquiryId");

	String inquiryActionBtnName = "update";

	CitizenInquiry inquiry = null;
	
	if(inquiryId > 0){
		
		inquiry = CitizenInquiryLocalServiceUtil.getCitizenInquiry(inquiryId);
		
		if(inquiry != null && Validator.isNull(inquiry.getInquiryFeedback())){
			
			inquiryActionBtnName = "update-feedback";
		}
	}
%>

<c:choose>
	<c:when test='<%=Validator.isNotNull(inquiry) %>'>
				
		<liferay-portlet:renderURL var="inquiryAdminURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
			<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		</liferay-portlet:renderURL>
	
		<liferay-portlet:actionURL name="updateInquiry"  var="updateInquiryURL">
			<liferay-portlet:param name="inquiryId" value="<%=String.valueOf(inquiryId) %>" />
			<liferay-portlet:param name="redirectURL" value="<%=inquiryAdminURL %>" />
		</liferay-portlet:actionURL>
	
		<aui:form name="fm"  method="post" action="<%=updateInquiryURL%>">
			<div class="inquiry-form">
		
				<aui:model-context bean="<%= inquiry %>" model="<%= CitizenInquiry.class %>" />
				
				<aui:input name="citizenName"/>
				
				<aui:input name="citizenAddress"/>
				
				<aui:input name="inquiryTitle"/>
				
				<aui:input name="inquiryContent" type="textarea"/>
				
				<aui:input name="inquiryFeedback" type="textarea"/>
				
				<aui:input name="inquiryFeedbackUser"/>
			
			</div>
		
			<div class="aui-button-holder">
				<aui:button type="submit" value="<%=inquiryActionBtnName %>"/>
				<aui:button name="closePreviewDialogBtn" value="close"/>
			</div>
		</aui:form>
			
		<script type="text/javascript">
		
			AUI().ready('aui-base',function(A) {
				
				var citizenNameInput = A.one('#<portlet:namespace/>citizenName');
				
				if(citizenNameInput){
					citizenNameInput.focus();
				}
				
				window.validator = new A.FormValidator({
					
			        boundingBox: document.<portlet:namespace />fm,
			
			        rules: {
			            <portlet:namespace />citizenName: {
			                required: true,
			                rangeLength: ['3','75']
			            },
			            <portlet:namespace />citizenAddress: {
			                required: false,
			                rangeLength: ['0','75']
			            },
			           	<portlet:namespace />inquiryTitle: {
			                required: true,
			                rangeLength: ['3','1000']
			            },
			           	<portlet:namespace />inquiryContent: {
			                required: true,
			                rangeLength: ['3','5000']
		            	},
		            	<portlet:namespace />inquiryFeedback: {
			                required: false,
			                rangeLength: ['0','5000']
			            },
			           	<portlet:namespace />inquiryFeedbackUser: {
			                required: false,
			                rangeLength: ['3','75']
			            }
			        }
			    });
				
				window.validator.validate();
				
				var closePreviewDialogBtn = A.one('#<portlet:namespace/>closePreviewDialogBtn');
				
				if(closePreviewDialogBtn){
					
					closePreviewDialogBtn.on('click',function(){
						Liferay.Util.getWindow().close();
					});
				}
			});
		</script>
		
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<span><liferay-ui:message key="no-inquiry-exist-with-primary-key"/> <%=inquiryId %></span>
		</div>
	</c:otherwise>
</c:choose>