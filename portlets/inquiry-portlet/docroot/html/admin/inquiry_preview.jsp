<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.inquiry.service.OnlineInquiryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.inquiry.model.OnlineInquiry"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">

	.inquiry-preview-container{
		font-size: 12px;
		font-weight: normal;
		color: #434343;
	}
	
	.inquiry-preview-container table{
		border-collapse: collapse;
		width: 100%;
	}
		
	.inquiry-preview-container table tr{
		height: 35px;
		border-bottom: 1px dotted #e8e8e8;
	}
		
	.inquiry-preview-container table tr td{
		padding: 5px 0px;
	}
			
	.inquiry-preview-container table tr td:first-child{
		min-width: 120px;
		padding-right: 10px;
		color: #00528b;
	}
			
	.inquiry-preview-container table tr:hover td{
		background: #D3E8F1;
		border: 1px solid #D3E8F1;
	}
</style>

<%@include file="/html/init.jsp"%>

<%
	long inquiryId = ParamUtil.getLong(request, "inquiryId");

	OnlineInquiry inquiry = null;
	
	if(inquiryId > 0){
		
		inquiry = OnlineInquiryLocalServiceUtil.getOnlineInquiry(inquiryId);
	}
%>

<c:choose>
	<c:when test='<%=Validator.isNotNull(inquiry) %>'>
	
		<%
		String inquiryTitle = StringUtil.shorten(inquiry.getInquiryContent(), 100);
		%>
	
		<div class="inquiry-preview-container">
			<table>
			
				<tr>
					<td><liferay-ui:message key="title"/></td>
					<td><span style="font-weight: bold;"><%=inquiryTitle%></span></td>
				</tr>
							
				<tr>
					<td><liferay-ui:message key="sender-name"/></td>
					<td><a href="#"><%=inquiry.getFullName() %></a></td>
				</tr>
				
				<c:if test='<%=Validator.isNotNull(inquiry.getPhoneNumbers()) %>'>							
					<tr>
						<td><liferay-ui:message key="phone-numbers"/></td>
						<td><%=inquiry.getPhoneNumbers() %></td>
					</tr>
				</c:if>	
								
				<c:if test='<%=Validator.isNotNull(inquiry.getEmailAddress()) %>'>							
					<tr>
						<td><liferay-ui:message key="email"/></td>
						<td><%=inquiry.getEmailAddress() %></td>
					</tr>
				</c:if>
																		
				<tr>
					<td><liferay-ui:message key="send-date"/></td>
					<td><%=dateTimeFormat.format(inquiry.getCreateDate())%></td>
				</tr>
							
				<tr>
					<td><liferay-ui:message key="inquiry-content"/></td>
					<td><%=inquiry.getInquiryContent()%></td>
				</tr>
			</table>
		</div>
		
		<div class="aui-button-holder">
			<aui:button name="closePreviewDialogBtn" value="close"/>
		</div>
		
		<script type="text/javascript">
		
			AUI().ready('aui-base',function(A) {
				
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

