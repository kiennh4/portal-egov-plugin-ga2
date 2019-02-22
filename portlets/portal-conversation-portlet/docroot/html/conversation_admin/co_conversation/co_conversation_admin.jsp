<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.conversation.util.ConversationUtil"%>
<%@page import="com.portal_egov.portlet.conversation.permission.CO_ConversationPermission"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int conversationIndex = 0;

	int conversationStatus = ParamUtil.getInteger(request, "conversationStatus",-1);

	String searchKeyword = ParamUtil.getString(request, "searchKeyword",StringPool.BLANK);
	
	List<CO_Conversation> conversationList = CO_ConversationLocalServiceUtil.findByKeywordAndStatus(companyId, searchKeyword, conversationStatus);
%>

<div class="co_thread_management">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			<c:if test="<%=CO_ConversationPermission.contains(permissionChecker, scopeGroupId, CO_ConversationPermission.ADD_CONVERSATION) %>">	
				<div class="add-thead-button" align="left">
								
					<liferay-portlet:renderURL var="addNewConversationURL" >
						<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_conversation/conversation_update_form.jsp"/>
					</liferay-portlet:renderURL>
					
					<aui:button type="button" value="add-new-conversation" href="<%=addNewConversationURL %>"/>
											
					<c:if test="<%=CO_ConversationPermission.contains(permissionChecker, scopeGroupId, CO_ConversationPermission.CONVERSATION_PERMISSIONS)%>">
						<liferay-security:permissionsURL
							modelResource="<%=CO_Conversation.class.getName() %>"
							modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
						/>
				
						<aui:button href="<%= permissionsURL %>" value="permissions" />
					</c:if>
				</div>			
			</c:if>
			
			<liferay-portlet:renderURL var="conversationSearchFormURL">
				<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp" />
				<liferay-portlet:param name="tabs1" value="COConversations"/>
			</liferay-portlet:renderURL>
			
			<div class="co_thead_search_form" align="right">
				<aui:form name="tthc_category_search_form" method="post" action="<%=conversationSearchFormURL %>">
					<input type="text" name="searchKeyword" value='<%= searchKeyword%>'/>
					<select name="conversationStatus">
						<option value="-1" <%=(conversationStatus == -1) ? "selected" : "" %>>
							<liferay-ui:message key="all"/>
						</option>
											
						<option value="<%=CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE %>" 
								<%=(conversationStatus == CO_Constants.DEFAULT_CONVERSATION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="new-entries"/>
						</option>
											
						<option value="<%=CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE %>"
								<%=(conversationStatus == CO_Constants.ANSWERED_CONVERSATION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="unpublish-entries"/>
						</option>
																	
						<option value="<%=CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE %>"
								<%=(conversationStatus == CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="publish-entries"/>
						</option>
					</select>
					<aui:button type="submit" value="search"/>
				</aui:form>	
			</div>
		</div>
	</div>

	<liferay-ui:search-container emptyResultsMessage="no-entry-found" delta="10">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(conversationList, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=conversationList.size() %>"
		/>			
			<liferay-ui:search-container-row className="CO_Conversation" keyProperty="conversationId" modelVar="conversation" >
				
				<liferay-portlet:renderURL var="updateConversationContentURL" >
					<liferay-portlet:param name="conversationId" value="<%=String.valueOf(conversation.getConversationId())%>"/>
					<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_conversation/conversation_update_form.jsp"/>
				</liferay-portlet:renderURL>
				
				<%
					conversationIndex ++;
				
					String conversationAswerDate = "";
					if(conversation.getAnswerDate() != null){
						conversationAswerDate = dateTimeFormat.format(conversation.getAnswerDate());
					}
					String status = ConversationUtil.getConversationStatusTitle(conversation.getConversationId());
					String threadName = "others";
					
					if(conversation.getThreadId() > 0){
						CO_Thread thread = CO_ThreadLocalServiceUtil.getCO_Thread(conversation.getThreadId());
						if(thread!= null){
							threadName = thread.getThreadName();
						}
					}
				%>
					
				<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(conversationIndex) %>"/>
									
				<liferay-ui:search-container-column-text name="Name" value="<%=conversation.getTitle() %>" href="<%=updateConversationContentURL %>"/>
				
				<liferay-ui:search-container-column-text name="co-thread-title" >
					<liferay-ui:message key="<%=threadName %>"/>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="Status" >
					<liferay-ui:message key="<%=status %>"/>
				</liferay-ui:search-container-column-text>
															
				<c:if test="<%=CO_ConversationPermission.contains(permissionChecker, scopeGroupId, CO_ConversationPermission.UPDATE_CONVERSATION) %>">
					
					<liferay-ui:search-container-column-text name="edit">
						<liferay-ui:icon image="edit" message="edit" url="<%= updateConversationContentURL %>" />
					</liferay-ui:search-container-column-text>
				</c:if>
																			
				<c:if test="<%=CO_ConversationPermission.contains(permissionChecker, scopeGroupId, CO_ConversationPermission.DELETE_CONVERSATION) %>">										
					<liferay-portlet:actionURL  name="deleteCOConversation" var="deleteCOConversationURL">
						<liferay-portlet:param name="conversationId" value="<%=String.valueOf(conversation.getConversationId())%>"/>
						<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
					</liferay-portlet:actionURL>
					
					<liferay-ui:search-container-column-text name="delete">
						<liferay-ui:icon-delete url="<%= deleteCOConversationURL %>" confirmation="are-you-sure-to-delete-this-entry?"/>
					</liferay-ui:search-container-column-text>			
				</c:if>
			</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
