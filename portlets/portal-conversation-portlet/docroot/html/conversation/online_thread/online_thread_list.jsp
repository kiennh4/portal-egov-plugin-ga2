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
	int onlineThreadIndex = 0;

	//Danh sach nhung cuoc giao luu (Thread) sap dien ra
	List<CO_Thread> onlineThreadList = CO_ThreadLocalServiceUtil.findByStatusAndCompany(CO_Constants.ONLINE_THREAD_STATUS_VALUE, companyId);
%>
<c:if test="<%=!onlineThreadList.isEmpty() %>">
	<div class="thread-type-title">
		<liferay-ui:message key="online-thread-list"/>
	</div>
	
	<div class="thread-list">

		<liferay-ui:search-container emptyResultsMessage="no-thread-found" delta="10" >
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(onlineThreadList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=onlineThreadList.size() %>"
			/>			
			<liferay-ui:search-container-row className="CO_Thread" keyProperty="threadId" modelVar="onlineThread" >
				
				<%
					onlineThreadIndex ++;
				%>
									
				<liferay-portlet:renderURL var="viewOnlineThreadContentURL">
					<liferay-portlet:param name="jspPage" value="/html/conversation/online_thread/online_thread_content.jsp" />
					<liferay-portlet:param name="threadId" value="<%=String.valueOf(onlineThread.getThreadId()) %>" />
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(onlineThreadIndex) %>" href="<%=viewOnlineThreadContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="co-thread-name" value="<%=onlineThread.getThreadName() %>" href="<%=viewOnlineThreadContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="co-department-name" value="<%=onlineThread.getDepartmentName()%>" href="<%=viewOnlineThreadContentURL %>"/>
										
				<liferay-ui:search-container-column-text name="co-thread-start-date" value="<%=dateTimeFormat.format(onlineThread.getStartDate())%>" href="<%=viewOnlineThreadContentURL %>"/>
			
				<liferay-ui:search-container-column-text name="co-thread-end-date" value="<%=dateTimeFormat.format(onlineThread.getEndDate())%>" href="<%=viewOnlineThreadContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="action">
					<aui:button name="joinOnlineThreadBtn" value="join" href="<%=viewOnlineThreadContentURL %>"/>
				</liferay-ui:search-container-column-text>
				
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</c:if>
