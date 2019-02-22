<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Conversation"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int threadConversationIndex = 0;

	long threadId = ParamUtil.getLong(request, "threadId",0L);
	
	CO_Thread coThread = null;
	
	List<CO_Conversation> threadConversationList = new ArrayList<CO_Conversation>();
	
	if(threadId > 0){
		
		coThread = CO_ThreadLocalServiceUtil.getCO_Thread(threadId);
		
		if(coThread != null){
			
			threadConversationList = CO_ConversationLocalServiceUtil.findByThreadAndGroupAndStatus(threadId, scopeGroupId,
				CO_Constants.PUBLISH_CONVERSATION_STATUS_VALUE);;
		}
	}
%>

<h3><liferay-ui:message key="thread-conversations" /></h3>
			
<liferay-util:buffer var="removeConversationIcon">
	<liferay-ui:icon image="unlink" label="<%=true %>" message="remove"/>
</liferay-util:buffer>

<liferay-ui:search-container headerNames="#,title,null" id="conversationMappingContainer">
	<liferay-ui:search-container-results 
			results="<%=threadConversationList %>"
			total="<%=threadConversationList.size() %>"
	/>
	
	<liferay-ui:search-container-row className="CO_Conversation" keyProperty="conversationId" modelVar="threadConversation" >
		<%
			threadConversationIndex ++;
			long conversationId = threadConversation.getConversationId();
			
			StringBundler sb = new StringBundler();

			sb.append("javascript:");
			sb.append("showConversationContent");
			sb.append("('");
			sb.append(threadConversation.getConversationId());
			sb.append("')");

			String	rowHREF = sb.toString();
		%>
		
		<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(threadConversationIndex) %>" href="<%=rowHREF %>"/>
		<liferay-ui:search-container-column-text name="title" value="<%=threadConversation.getTitle() %>" href="<%=rowHREF %>"/>
		
		<liferay-ui:search-container-column-text>
			<a class="modify-link" data-rowId="<%= conversationId %>"  href="javascript:;"><%= removeConversationIcon %></a>
		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>

<div class="aui-button-holder">
	<aui:button value="add-conversation-entry" onClick='openVBPQSelectBrowser();'/>
</div>
		
<aui:script>

	var threadConversationIndex = <%=threadConversationIndex %>;
	
	function openVBPQSelectBrowser() {
	
		var url = '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>">';	   	 		        
			url += '<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_thread/thread_form_sections/thread_conversation/co_conversation_list.jsp" />';
			url += '<liferay-portlet:param name="threadId" value="<%=String.valueOf(threadId) %>" />';
	        url += '</liferay-portlet:renderURL>';
	     														
		var dialogAlignConfig = {
				node: '#_conversation_admin_WAR_conversationportlet_sectionsContainer',
				points: ['tl', 'tl']
		};
							   
		Liferay.Util.openWindow(
			{
				dialog: {
					align: dialogAlignConfig,
					constrain: true,
					width: 820
				},
				id: 'conversation_browser',
				title: '<%= UnicodeLanguageUtil.get(pageContext, "select-conversation-entry") %>',
				uri: url
			}
		);
	}

	Liferay.provide(
		window,
		'showConversationContent',
		function(conversationId) {
								
			var viewContactInfoRenderURL = Liferay.PortletURL.createRenderURL();
			
			if(viewContactInfoRenderURL){
				
				viewContactInfoRenderURL.setPortletId('<%=portletId %>');
				viewContactInfoRenderURL.setWindowState('exclusive');
				viewContactInfoRenderURL.setParameter('jspPage', '/html/conversation_admin/co_thread/thread_form_sections/thread_conversation/co_conversation_content.jsp');
				viewContactInfoRenderURL.setParameter('conversationId', conversationId);
				viewContactInfoRenderURL.setDoAsGroupId('<%=scopeGroupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#portlet_conversation_admin_WAR_conversationportlet',
					points: ['tl', 'tl']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true
					},
					title: '<%= UnicodeLanguageUtil.get(pageContext, "conversation-content") %>',
					uri: viewContactInfoRenderURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);

	Liferay.provide(
		window,
		'addConversationEntry',
		function(conversationId, conversationTitle) {
			var A = AUI();

			threadConversationIndex ++;
			
			var searchContainerName = '<portlet:namespace/>conversationMappingContainer';

			searchContainer = Liferay.SearchContainer.get(searchContainerName);
			
			var conversationIndex = '<a href="javascript:showConversationContent('+ conversationId + ');">' + threadConversationIndex + '</a>';
			
			var conversationTitleRow = '<a href="javascript:showConversationContent('+ conversationId + ');">' + conversationTitle + '</a>';
			
			var conversationLink = '<a class="modify-link" data-rowId="' + conversationId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeConversationIcon) %></a>';

			searchContainer.addRow([conversationIndex,conversationTitleRow, conversationLink], conversationId);

			searchContainer.updateDataStore();
		},
		['liferay-search-container']
	);

</aui:script>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />conversationMappingContainer');

	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;

			var tr = link.ancestor('tr');
			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		},
		'.modify-link'
	);

</aui:script>


			
