<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	long threadId = ParamUtil.getLong(request, "threadId",0L);

	String threadType = ParamUtil.getString(request, "threadType");
	
	String jspPath = "/html/conversation/open_thread/open_thread_content.jsp";
	
	if(Validator.equals(threadType, "onlineThread")){
		
		jspPath = "/html/conversation/online_thread/online_thread_content.jsp";
	}
%>

<div class="conversation-give-ask-form">
		
	<liferay-portlet:renderURL var="conversationThreadHomePageURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
		<liferay-portlet:param name="jspPage" value="<%=jspPath %>"/>
		<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:actionURL var="giveAskContentURL" name="updateAskContent">
		<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=conversationThreadHomePageURL %>"/>
	</liferay-portlet:actionURL>
	
	<div class="give-ask-form-header">
		<span class="form-title"><liferay-ui:message key="give-ask-form"/></span>
		<span class="notice-message">(<liferay-ui:message key="please-enter-your-profile-and-ask-question-to-that-form-below"/>)</span>
	</div>
	
	<div>
		<aui:form name="give_ask_content_form"  method="post" action="<%=giveAskContentURL%>" >
						
			<aui:input type="text" name="askUserName" label="full-name">
				<aui:validator name="required" />
			</aui:input>
										
			<aui:input type="text" name="askUserAddress" label="address" >
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input type="text" name="askTitle" >
				<aui:validator name="required" />
			</aui:input>
					
			<div class="give-ask-form-row">
				<span style="display: block;"><liferay-ui:message key="ask-content"/></span>
				<liferay-ui:input-editor name="askContent"/>
			</div>
																			
			<div class="button_row">												
				<aui:button type="button" value="send-question" onClick='giveAskContent();'/>
			</div>
			
			<aui:input type="hidden" name="askContent"/>
			
		</aui:form>
	</div>
</div>

<script type="text/javascript">

	AUI().ready('aui-form-validator,aui-overlay-context-panel',function(A){
		
		window.validator = new A.FormValidator({
	        boundingBox: document.<portlet:namespace />give_ask_content_form,
	        fieldContainer: 'span',
	        validateOnBlur: false,
	        selectText: false,
	        rules: {
	        	<portlet:namespace />askUserName: {
	                required: true,
	                rangeLength: ['5','150']
	            },
	            <portlet:namespace />askUserAddress: {
	                required: true,
	                rangeLength: ['2','300']
	            },
	            <portlet:namespace />askTitle: {
	                required: true,
	                rangeLength: ['5','1000']
	            }
	        },
	        fieldStrings: {
	        	<portlet:namespace />askUserName: {
	                required: '<liferay-ui:message key="please-enter-your-name-here"/>'
	            },
	            <portlet:namespace />askUserAddress: {
	                required: '<liferay-ui:message key="please-enter-your-address-here"/>'
	            },
	            <portlet:namespace />askTitle: {
	                required: '<liferay-ui:message key="please-enter-question-title-here"/>'
	            }
	        }
	    });
	});
	

	function <portlet:namespace />initEditor() {
		return "<%= StringPool.BLANK %>";
	}
	
	function giveAskContent() {
		window.validator.validate();
		
		if (!window.validator.hasErrors()) {
			var askContent = window.<portlet:namespace />askContent.getHTML();
			document.<portlet:namespace />give_ask_content_form.<portlet:namespace />askContent.value = askContent;
			
			submitForm(document.<portlet:namespace />give_ask_content_form);
		}
	}
</script>
