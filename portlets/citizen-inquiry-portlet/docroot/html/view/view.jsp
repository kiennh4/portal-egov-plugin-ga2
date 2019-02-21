<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.service.CitizenInquiryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.model.CitizenInquiry"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.citizen_inquiry.search.InquirySearch"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">

	.inquiry-list .lfr-search-container .results-grid{
		border: none;
	}
	
	.inquiry-list .lfr-search-container .results-grid .results-header{
		display: none;
	}
		
	.inquiry-list .lfr-search-container .results-row td,
	.inquiry-list .lfr-search-container .results-row.alt td{
		border: none;
		background: #fff;
		padding: 0px;
	}
		
	.inquiry-list .lfr-search-container .taglib-search-iterator-page-iterator-bottom,
	.inquiry-list .lfr-search-container .search-results{
		color: #999 !important;
	}
	
</style>

<%@include file="/html/init.jsp"%>

<%
	int inquiryIndex = 0;

	String inquirySearchKeyword = ParamUtil.getString(request, "inquirySearchKeyword");
%>

<liferay-portlet:renderURL var="inquiryHomePageURL">
	<liferay-portlet:param name="jspPage" value="/html/view/view.jsp"/>
	<liferay-portlet:param name="inquirySearchKeyword" value="<%=inquirySearchKeyword %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="inquiryFormURL">
	<liferay-portlet:param name="jspPage" value="/html/view/inquiry_form.jsp"/>
</liferay-portlet:renderURL>

<div class="inquiry-view">
	
	<div class="inquiry-toolbar">
		<div class="inquiry-title" align="left">
			<liferay-ui:message key="inquiry-list"/>
		</div>
		<div class="inquiry-search-form" align="right">
			<aui:form name="fm" method="post" action="<%=inquiryHomePageURL %>">
			
				<input type="text" name="inquirySearchKeyword" value="<%=inquirySearchKeyword %>" />
				
				<aui:button type="submit" value="search"/>
				<aui:button value="show-all" href="<%=inquiryHomePageURL %>"/>
				<aui:button value="send-inquiry" href="<%=inquiryFormURL %>"/>
	
			</aui:form>	
		</div>
	</div>
	
	<div class="inquiry-list">

		<liferay-portlet:renderURL varImpl="inquiryHomePageImplURL">
			<liferay-portlet:param name="jspPage" value="/html/view/view.jsp"/>
			<liferay-portlet:param name="inquirySearchKeyword" value="<%=inquirySearchKeyword %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container 
			searchContainer="<%=new InquirySearch(renderRequest,inquiryHomePageImplURL) %>"
		>
			<%	
				List<CitizenInquiry> inquiryList = CitizenInquiryLocalServiceUtil.findByKeyword(groupId, 0L, 
					inquirySearchKeyword,searchContainer.getStart(), searchContainer.getEnd(),false, searchContainer.getOrderByComparator());
			%>
			
			<liferay-ui:search-container-results results="<%=inquiryList %>" total="<%=inquiryList.size() %>"/>
			
			<liferay-ui:search-container-row className="CitizenInquiry" keyProperty="inquiryId" modelVar="inquiry" escapedModel="<%=true %>">
				
				<liferay-ui:search-container-column-jsp path="/html/view/inquiry_row.jsp"/>	
								
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var inquirySearchInput = A.one('#<portlet:namespace/>inquirySearchKeyword');
		
		if(inquirySearchInput){
			
			inquirySearchInput.focus();
		}
	});
</script>
