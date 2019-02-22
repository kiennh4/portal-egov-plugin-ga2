<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Danh sach nhung cuoc giao luu (Thread) dang dien ra
	List<CO_Thread> onlineThreadList = CO_ThreadLocalServiceUtil.findByStatusAndCompany(CO_Constants.ONLINE_THREAD_STATUS_VALUE, companyId);
	
	//Danh sach nhung cuoc giao luu (Thread) sap dien ra
	List<CO_Thread> openThreadList = CO_ThreadLocalServiceUtil.findByStatusAndCompany(CO_Constants.OPEN_THREAD_STATUS_VALUE, companyId);
%>

<div class="conversation-portlet-view-page">
	
	<div class="conversation-header">
		<span><liferay-ui:message key="portal-egov-online-conversation"/></span>
	</div>
	
	<div class="conversation-thread-list">
		<c:if test="<%=!onlineThreadList.isEmpty() %>">
			<liferay-util:include page="/html/conversation/online_thread/online_thread_list.jsp" servletContext="<%=this.getServletContext() %>"/>
			<div class="thread-separator"></div>
		</c:if>
		
		<c:if test="<%=!openThreadList.isEmpty() %>">
			<liferay-util:include page="/html/conversation/open_thread/open_thread_list.jsp" servletContext="<%=this.getServletContext() %>"/>
			<div class="thread-separator"></div>
		</c:if>

		<div class="publish_thread_list">
			<liferay-util:include page="/html/conversation/publish_thread/publish_thread_list.jsp" servletContext="<%=this.getServletContext() %>"/>
		</div>
	</div>
</div>