<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long inquiryId = ParamUtil.getLong(request, "inquiryId");

	CitizenInquiry inquiry = null;
	
	if(inquiryId > 0){
		
		inquiry = CitizenInquiryLocalServiceUtil.getCitizenInquiry(inquiryId);
	}
%>

<c:choose>
	<c:when test="<%=inquiry != null %>">
		<div class="inquiry-detail">
			<div class="header">
				<div class="header-title"><liferay-ui:message key="inquiry-detail"/></div>
				
				<div class="header-toolbar">
					
					<liferay-portlet:renderURL var="inquiryHomePageURL">
						<liferay-portlet:param name="jspPage" value="/html/view/view.jsp"/>
					</liferay-portlet:renderURL>
										
					<liferay-portlet:renderURL var="inquiryFormURL">
						<liferay-portlet:param name="jspPage" value="/html/view/inquiry_form.jsp"/>
					</liferay-portlet:renderURL>
						
					<span class="send-inquiry-icon">
						<a href="<%=inquiryFormURL%>">
							<liferay-ui:message key="send-inquiry"/>
						</a>
					</span>
					
					<span class="back-icon">
						<a href="<%=inquiryHomePageURL%>">
							<liferay-ui:message key="back-to-home-page"/>
						</a>
					</span>
				</div>
			</div>
			
			<div style="clear: both;"></div>
			
			<div class="inquiry-content">
				<div class="title"><span><liferay-ui:message key="inquiry-content"/></span></div>
				<div class="info">
					<table>
						<tr>
							<td><liferay-ui:message key="inquiry-title"/></td>
							<td><span style="font-weight: bold;color: #00528B;"><%=inquiry.getInquiryTitle() %></span></td>
						</tr>
											
						<tr>
							<td><liferay-ui:message key="citizen-name"/></td>
							<td><%=inquiry.getCitizenName() %></td>
						</tr>
						
						<c:if test="<%=Validator.isNotNull(inquiry.getCitizenAddress()) %>">
							<tr>
								<td><liferay-ui:message key="citizen-address"/></td>
								<td><%=inquiry.getCitizenAddress() %></td>
							</tr>
						</c:if>
																	
						<tr>
							<td><liferay-ui:message key="inquiry-create-date"/></td>
							<td><%=dateFormat.format(inquiry.getCreateDate()) %></td>
						</tr>
					</table>
				</div>
				<div class="content"><%=inquiry.getInquiryContent() %></div>
			</div>
						
			<div class="feedback-content">
				<div class="title"><liferay-ui:message key="inquiry-feedback"/></div>
				<div class="info">
					<table>
						<tr>
							<td><liferay-ui:message key="inquiry-feedback-user"/></td>
							<td><%=inquiry.getInquiryFeedbackUser() %></td>
						</tr>
						
						<c:if test="<%=Validator.isNotNull(inquiry.getInquiryFeedbackDate()) %>">
							<tr>
								<td><liferay-ui:message key="feedback-date"/></td>
								<td><%=dateFormat.format(inquiry.getInquiryFeedbackDate()) %></td>
							</tr>
						</c:if>
					</table>
				</div>
				<div class="content"><%=inquiry.getInquiryFeedback() %></div>
			</div>
		</div>
	</c:when>
	
	<c:otherwise>
		<div class="portlet-msg-info">
			<span><liferay-ui:message key="no-inquiry-exist-with-primary-key"/> <%=inquiryId %></span>
		</div>
	</c:otherwise>
</c:choose>

