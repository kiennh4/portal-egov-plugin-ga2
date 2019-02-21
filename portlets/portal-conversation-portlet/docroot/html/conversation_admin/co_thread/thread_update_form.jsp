<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long threadId = ParamUtil.getLong(request, "threadId",0L);

	String threadName = "add-new-thread";
	
	CO_Thread coThread = null;
	
	if(threadId > 0){
		
		coThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
		
		if(coThread != null){
			threadName = StringUtil.shorten(coThread.getThreadName(), 100);
		}
	}

	String[] formNavigatorCategoryNames = {"co-thread"};

	String[] formNavigatorSection = {"thread-information","thread-schedule","thread-conversations"};
	
	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitThreadUpdateForm();";
%>
				
<liferay-portlet:renderURL var="threadAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="COThreads"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="updateCOThreadURL" name="updateCOThread">
	<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=threadAdminURL %>"/>
</liferay-portlet:actionURL>

<liferay-ui:header title="<%= threadName %>" backURL="<%=threadAdminURL%>" />

<div class="co-thread-update-form">
	<aui:form name="thread_update_form"  method="post" action="<%=updateCOThreadURL%>" onSubmit="<%=taglibOnSubmit %>">
						
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/conversation_admin/co_thread/thread_form_sections/"
			backURL="<%= threadAdminURL %>"
		/>
	</aui:form>
</div>
	
<aui:script use="aui-base,aui-loading-mask">
	Liferay.provide(
		window,
		'<portlet:namespace />submitThreadUpdateForm',
		function() {
			var A = AUI();
			
			var portletContainer = A.one('#p_p_id_conversation_admin_WAR_conversationportlet_');
			
			//portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
			
			//portletContainer.loadingmask.toggle();
			
			var threadDesc = window.<portlet:namespace />threadDescEditor.getHTML();
			
			document.<portlet:namespace />thread_update_form.<portlet:namespace />threadDesc.value = threadDesc;
			
			document.<portlet:namespace />thread_update_form.submit();
		},
		['aui-base']
	);
</aui:script>