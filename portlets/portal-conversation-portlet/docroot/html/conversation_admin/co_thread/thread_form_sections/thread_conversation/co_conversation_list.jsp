<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.portal_egov.portlet.conversation.util.ConversationUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">
	
	.mapping-conversation-entries{
		padding: 0px;
		margin: 0px;
		display: block;
	}
	
	.mapping-conversation-entries .lfr-header-row{
		margin-bottom: 20px;
		border-radius: 4px;
		background: url("/conversation-portlet/images/admin_tool_bar_bg.png") repeat-x scroll 0 0 #D9D9D9;
    	border: 1px solid #C9C9C9;
	}
	
	.mapping-conversation-entries .lfr-header-row-content{
		padding: 2px 4px 0 !important;
	}
		
	.mapping-conversation-entries .lfr-header-row-content input[type="text"]{
		width: 200px;
	}
	
</style>

<%@include file="/html/init.jsp"%>

<%
	int threadConversationIndex = 0;

	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	String callbackMethod = "addConversationEntry";
	
	String conversationSearchKeyword = ParamUtil.getString(request, "conversationSearchKeyword");
	
	List<CO_Conversation> threadConversationList = CO_ConversationLocalServiceUtil.findUnpublishEntry(scopeGroupId, conversationSearchKeyword);
%>
	<div class="mapping-conversation-entries">
		<h3><liferay-ui:message key="co-conversation-list" /></h3>
		<div class="lfr-header-row">
			<div class="lfr-header-row-content">						
				
				<liferay-portlet:renderURL var="conversationMappingSearchURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_thread/thread_form_sections/thread_conversation/co_conversation_list.jsp" />
					<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>" />		
				</liferay-portlet:renderURL>
				
				<div class="conversation-search-control" align="right">
					<aui:form name="vbpq_search_form" method="post" action="<%=conversationMappingSearchURL %>">				
						<input type="text" name="conversationSearchKeyword" value='<%= conversationSearchKeyword%>'/>
						
						<aui:button type="submit" value="search"/>
						
						<aui:button type="button" value="show-all" href="<%=conversationMappingSearchURL %>"/>
					</aui:form>	
				</div>	
			</div>
		</div>
		
		<div class="conversation-search-result">
		
			<liferay-portlet:renderURL varImpl="conversationListImplURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_thread/thread_form_sections/thread_conversation/co_conversation_list.jsp" />
				<liferay-portlet:param name="conversationSearchKeyword" value="<%=conversationSearchKeyword %>" />
				<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>" />			
			</liferay-portlet:renderURL>
				
			<liferay-ui:search-container emptyResultsMessage="no-entry-found" delta="20" iteratorURL="<%=conversationListImplURL %>">
				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(threadConversationList, searchContainer.getStart(), searchContainer.getEnd())%>"
					total="<%=threadConversationList.size() %>"
				>			
				</liferay-ui:search-container-results>
					
				<liferay-ui:search-container-row className="CO_Conversation" keyProperty="conversationId" modelVar="threadConversation" >
					<%
						threadConversationIndex ++;
					
						String conversationStatus = ConversationUtil.getConversationStatusTitle(threadConversation.getConversationId());
						
						StringBundler sb = new StringBundler(9);
	
						sb.append("javascript:Liferay.Util.getOpener().");
						sb.append(callbackMethod);
						sb.append("('");
						sb.append(threadConversation.getConversationId());
						sb.append("', '");
						sb.append(threadConversation.getTitle());
						sb.append("');Liferay.Util.getWindow().close();");
		
						String	rowHREF = sb.toString();
						
					%>																					
					<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(threadConversationIndex) %>" href="<%=rowHREF %>"/>										
					<liferay-ui:search-container-column-text name="Name" value="<%=threadConversation.getTitle() %>" href="<%=rowHREF %>"/>
									
					<liferay-ui:search-container-column-text name="status" value="<%=conversationStatus %>" href="<%=rowHREF %>"/>
						
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</div>			

			
