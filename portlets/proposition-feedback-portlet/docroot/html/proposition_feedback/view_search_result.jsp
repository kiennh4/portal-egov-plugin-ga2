<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/proposition_feedback/init.jsp"%>

<%@ include file="/html/proposition_feedback/proposition_search_form.jspf" %>

<%

	//Ket qua tim kiem du thao luat.
	List<Proposition> searchResultList = PropositionLocalServiceUtil.findByMultiCondition(scopeGroupId, searchCategoryId,
								searchCompilationDepartmentId, searchVerificationDepartmentId, propositionSearchKeyword,
								searchPropositionStatus,0,numbersOfSearchResultProposition);
%>
<div class="proposition_list">
	<ul>
		<%
		for(Proposition proposition : searchResultList){
			
			String categoryName = "";
			String compilationDepartmentName = "";
			String verificationDepartmentName = "";
			
			if(proposition.getCategoryId() > 0){
				categoryName = PropositionCategoryLocalServiceUtil.getPropositionCategory(proposition.getCategoryId()).getCategoryName();
			}
			
			if(proposition.getCompilationDepartmentId() > 0){
				compilationDepartmentName = PropositionCategoryLocalServiceUtil.getPropositionCategory(proposition.getCompilationDepartmentId()).getCategoryName();
			}
			
			if(proposition.getVerificationDepartmentId() > 0){
				verificationDepartmentName = PropositionCategoryLocalServiceUtil.getPropositionCategory(proposition.getVerificationDepartmentId()).getCategoryName();
			}
		%>
		
		<liferay-portlet:renderURL var="viewPropositionDetailURL">
			<liferay-portlet:param name="jspPage" value="/html/proposition_feedback/view_proposition_details.jsp" />
			<liferay-portlet:param name="propositionId" value="<%=String.valueOf(proposition.getPropositionId()) %>" />
		</liferay-portlet:renderURL>
	
		<li>
			<div class="proposition_summary">
				<div class="proposition_img">
					<a href="<%=viewPropositionDetailURL%>">
						<img alt="" src="/proposition_feedback-portlet/images/icon/proposition_icon.gif">
					</a>
				</div>
				<div class="proposition_info">
					<div class="proposition_name">
						<a href="<%=viewPropositionDetailURL%>"><%=proposition.getPropositionName() %></a>
					</div>
					
					<div>
						<span class="proposition_attribute_name"><liferay-ui:message key="proposition-category"/><%=StringPool.COLON %></span>
						<%=categoryName%>
					</div>
	
					<div>
						<span class="proposition_attribute_name"><liferay-ui:message key="proposition-compilation-department"/><%=StringPool.COLON %></span>
						<%=compilationDepartmentName%>
					</div>
					
					<div>
						<span class="proposition_attribute_name"><liferay-ui:message key="proposition-verification-department"/><%=StringPool.COLON %></span>
						<%=verificationDepartmentName%>
					</div>
									
					<div>
						<span class="proposition_attribute_name"><liferay-ui:message key="proposition-status"/><%=StringPool.COLON %></span>
						<liferay-ui:message key="<%=PropositionUtil.getPropositionStatusTitle(proposition.getPropositionId()) %>"/>
					</div>
					
					<div class="proposition_metadata_list">
						<span class="proposition_metadata"><%=dateFormat.format(proposition.getCreateDate()) %></span>
						
						<span class="proposition_metadata"><%=proposition.getViewCount() %> <liferay-ui:message key="view-counter"/></span>
						
						<span class="proposition_metadata"><%=proposition.getFeedbackCount() %> <liferay-ui:message key="feedback-count"/></span>
					</div>				
				</div>
			</div>
			<div style="clear: both;"></div>
		</li>
		<%
		}
		%>
	</ul>
	<div style="clear: both;"></div>
</div>