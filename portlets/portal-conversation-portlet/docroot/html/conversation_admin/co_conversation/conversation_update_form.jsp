<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long conversationId = ParamUtil.getLong(request, "conversationId",0L);

	String formTitle = "add-new-conversation";
	
	CO_Conversation conversation = null;
	
	if(conversationId > 0){
		
		conversation = CO_ConversationLocalServiceUtil.getCO_Conversation(conversationId);
		
		if(conversation != null){
			formTitle = StringUtil.shorten(conversation.getTitle(), 100);
		}
	}

	String[] formNavigatorCategoryNames = {"co-conversation"};

	String[] formNavigatorSection = {"ask-content","answer-content"};
	
	String[][] formNavigatorSections = {formNavigatorSection};
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "submitConversationUpdateForm();";
%>
				
<liferay-portlet:renderURL var="conversationAdminURL">
	<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp" />
	<liferay-portlet:param name="tabs1" value="COConversations"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="updateConversationContent" var="updateConversationContentURL" >
	<liferay-portlet:param name="conversationId" value="<%=String.valueOf(conversationId) %>"/>
	<liferay-portlet:param name="redirectURL" value="<%=conversationAdminURL %>"/>
</liferay-portlet:actionURL>

<liferay-ui:header title="<%= formTitle %>" backURL="<%=conversationAdminURL%>" />

<div class="co-conversation-update-form">
	<aui:form name="conversation_update_form"  method="post" action="<%=updateConversationContentURL%>" onSubmit="<%=taglibOnSubmit %>">
						
		<liferay-ui:form-navigator 
			categoryNames="<%=formNavigatorCategoryNames %>" 
			categorySections="<%=formNavigatorSections %>"
			jspPath="/html/conversation_admin/co_conversation/conversation_form_sections/"
			backURL="<%= conversationAdminURL %>"
		/>
	</aui:form>
</div>
	
<aui:script use="aui-base,aui-loading-mask">
	Liferay.provide(
		window,
		'<portlet:namespace />submitConversationUpdateForm',
		function() {
			var A = AUI();
			
			var portletContainer = A.one('#p_p_id_conversation_admin_WAR_conversationportlet_');
			
			//portletContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
			
			//portletContainer.loadingmask.toggle();
			
			var askContent = window.<portlet:namespace />askContentEditor.getHTML();
			
			document.<portlet:namespace />conversation_update_form.<portlet:namespace />askContent.value = askContent;
						
			var answerContent = window.<portlet:namespace />answerContentEditor.getHTML();
			
			document.<portlet:namespace />conversation_update_form.<portlet:namespace />answerContent.value = answerContent;
			
			document.<portlet:namespace />conversation_update_form.submit();
		},
		['aui-base']
	);
</aui:script>