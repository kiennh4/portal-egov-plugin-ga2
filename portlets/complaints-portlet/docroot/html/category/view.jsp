<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<div class="complaint-category">
	<ul>
		<li>
			<liferay-portlet:renderURL var="viewComplaintEntriesURL" portletName="complaints_WAR_complaintsportlet">
				<liferay-portlet:param name="complaintStatus" value="0"/>
			</liferay-portlet:renderURL>
			
			<a href="<%=viewComplaintEntriesURL%>">
				<liferay-ui:message key="complaint-entry-category"/>
			</a>
		</li>
		
		<li>
			<liferay-portlet:renderURL var="viewComplaintFeedbacksURL" portletName="complaints_WAR_complaintsportlet">
				<liferay-portlet:param name="complaintStatus" value="1"/>
			</liferay-portlet:renderURL>
			
			<a href="<%=viewComplaintFeedbacksURL%>">
				<liferay-ui:message key="complaint-feedback-category"/>
			</a>
		</li>
				
<!-- 		<li> -->
<!-- 			<a href="javascript:;"> -->
<%-- 				<liferay-ui:message key="complaint-vbpq"/> --%>
<!-- 			</a> -->
<!-- 		</li> -->
						
<!-- 		<li> -->
<!-- 			<a href="javascript:;"> -->
<%-- 				<liferay-ui:message key="complaint-tthc"/> --%>
<!-- 			</a> -->
<!-- 		</li> -->
	</ul>
</div>
