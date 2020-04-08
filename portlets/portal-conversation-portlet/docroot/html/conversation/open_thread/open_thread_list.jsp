<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.conversation.util.ConversationUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int openThreadIndex = 0;
	//Danh sach nhung cuoc giao luu (Thread) sap dien ra
	List<CO_Thread> openThreadList = CO_ThreadLocalServiceUtil.findByStatusAndCompany(CO_Constants.OPEN_THREAD_STATUS_VALUE, companyId);
%>
<c:if test="<%=!openThreadList.isEmpty() %>">

	<div class="thread-type-title">
		<liferay-ui:message key="open-thread-list"/>
	</div>

	<div class="thread-list">		
		<liferay-ui:search-container emptyResultsMessage="no-thread-found" delta="10">
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(openThreadList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=openThreadList.size() %>"
			/>			
			<liferay-ui:search-container-row className="CO_Thread" keyProperty="threadId" modelVar="openThread" >
								
				<%
					openThreadIndex ++;
				%>					
				<liferay-portlet:renderURL var="viewOpenThreadContentURL">
					<liferay-portlet:param name="jspPage" value="/html/conversation/open_thread/open_thread_content.jsp" />
					<liferay-portlet:param name="threadId" value="<%=String.valueOf(openThread.getThreadId()) %>" />
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(openThreadIndex) %>" href="<%=viewOpenThreadContentURL %>"/>
								
				<liferay-ui:search-container-column-text name="co-thread-name" value="<%=openThread.getThreadName() %>" href="<%=viewOpenThreadContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="co-department-name" value="<%=openThread.getDepartmentName()%>"  href="<%=viewOpenThreadContentURL %>"/>
										
				<liferay-ui:search-container-column-text name="co-thread-start-date" value="<%=dateTimeFormat.format(openThread.getStartDate())%>" href="<%=viewOpenThreadContentURL %>"/>
			
				<liferay-ui:search-container-column-text name="co-thread-end-date" value="<%=dateTimeFormat.format(openThread.getEndDate())%>" href="<%=viewOpenThreadContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="action">
					<aui:button name="joinOpenThreadBtn" value="join" href="<%=viewOpenThreadContentURL %>"/>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</c:if>