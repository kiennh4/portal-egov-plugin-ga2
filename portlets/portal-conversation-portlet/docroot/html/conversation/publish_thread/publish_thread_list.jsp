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
	int publishThreadIndex = 0;

	//Danh sach nhung cuoc giao luu (Thread) sap dien ra
	List<CO_Thread> publishThreadList = CO_ThreadLocalServiceUtil.findByStatusAndCompany(CO_Constants.PUBLISH_THREAD_STATUS_VALUE, companyId);
%>
<c:if test="<%=!publishThreadList.isEmpty() %>">
	
	<div class="thread-type-title">
		<liferay-ui:message key="publish-thread-list"/>
	</div>

	<div class="thread-list">
	
		<liferay-ui:search-container emptyResultsMessage="no-thread-found" delta="10">
			<liferay-ui:search-container-results
				results="<%=ListUtil.subList(publishThreadList, searchContainer.getStart(), searchContainer.getEnd())%>"
				total="<%=publishThreadList.size() %>"
			/>			
			<liferay-ui:search-container-row className="CO_Thread" keyProperty="threadId" modelVar="publicThread" >
													
				<%
					publishThreadIndex ++;
				%>					
				<liferay-portlet:renderURL var="viewPublicThreadContentURL">
					<liferay-portlet:param name="jspPage" value="/html/conversation/publish_thread/publish_thread_content.jsp" />
					<liferay-portlet:param name="threadId" value="<%=String.valueOf(publicThread.getThreadId()) %>" />
				</liferay-portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(publishThreadIndex) %>" href="<%=viewPublicThreadContentURL %>"/>
									
				<liferay-ui:search-container-column-text name="co-thread-name" value="<%=publicThread.getThreadName() %>" href="<%=viewPublicThreadContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="co-department-name" value="<%=publicThread.getDepartmentName()%>" href="<%=viewPublicThreadContentURL %>"/>
										
				<liferay-ui:search-container-column-text name="co-thread-date" value="<%=dateFormat.format(publicThread.getEndDate())%>" href="<%=viewPublicThreadContentURL %>"/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</c:if>