<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Category"%>
<%@page import="com.portal_egov.portlet.conversation.util.ConversationUtil"%>
<%@page import="com.portal_egov.portlet.conversation.util.CO_Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.conversation.permission.CO_ThreadPermission"%>
<%@page import="com.portal_egov.portlet.conversation.service.CO_ThreadLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.conversation.model.CO_Thread"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int threadIndex = 0;

	int theadStatus = ParamUtil.getInteger(request, "theadStatus",-1);

	String searchKeyword = ParamUtil.getString(request, "searchKeyword",StringPool.BLANK);

	List<CO_Thread> threadList = CO_ThreadLocalServiceUtil.findByKeywordAndStatus(companyId, searchKeyword, theadStatus);
%>

<div class="co_thread_management">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">						
			<c:if test="<%=CO_ThreadPermission.contains(permissionChecker, scopeGroupId, CO_ThreadPermission.ADD_THREAD) %>">	
				<div class="add-thead-button" align="left">
				
					<liferay-portlet:renderURL var="addNewThreadURL">
						<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_thread/thread_update_form.jsp"/>
					</liferay-portlet:renderURL>
				
					<aui:button type="button" value="add-new-thread" href="<%=addNewThreadURL %>"/>
						
					<c:if test="<%=CO_ThreadPermission.contains(permissionChecker, scopeGroupId, CO_ThreadPermission.THREAD_PERMISSIONS)%>">
						<liferay-security:permissionsURL
							modelResource="<%=CO_Thread.class.getName() %>"
							modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
							resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
							var="permissionsURL"
						/>
				
						<aui:button href="<%= permissionsURL %>" value="permissions" />
					</c:if>
				</div>			
			</c:if>
			
			<liferay-portlet:renderURL var="coThreadSearchFormURL">
				<liferay-portlet:param name="jspPage" value="/html/conversation_admin/view.jsp" />
				<liferay-portlet:param name="tabs1" value="COThreads"/>
			</liferay-portlet:renderURL>
			
			<div class="co_thead_search_form" align="right">
				<aui:form name="tthc_category_search_form" method="post" action="<%=coThreadSearchFormURL %>">
					<input type="text" name="searchKeyword" value='<%= searchKeyword%>'/>
					<select name="theadStatus">
						<option value="-1" <%=(theadStatus == -1) ? "selected" : "" %>>
							<liferay-ui:message key="all-thread"/>
						</option>
											
						<option value="<%=CO_Constants.DEFAULT_THREAD_STATUS_VALUE %>" 
								<%=(theadStatus == CO_Constants.DEFAULT_THREAD_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="unpublish-thread"/>
						</option>
																	
						<option value="<%=CO_Constants.PUBLISH_THREAD_STATUS_VALUE %>"
								<%=(theadStatus == CO_Constants.PUBLISH_THREAD_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="publish-thread"/>
						</option>
																	
						<option value="<%=CO_Constants.OPEN_THREAD_STATUS_VALUE %>"
								<%=(theadStatus == CO_Constants.OPEN_THREAD_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="open-thread"/>
						</option>
																	
						<option value="<%=CO_Constants.ONLINE_THREAD_STATUS_VALUE %>"
								<%=(theadStatus == CO_Constants.ONLINE_THREAD_STATUS_VALUE) ? "selected" : "" %>>
							<liferay-ui:message key="online-thread"/>
						</option>
					</select>
					<aui:button type="submit" value="search"/>
				</aui:form>	
			</div>
		</div>
	</div>

	<liferay-ui:search-container emptyResultsMessage="no-thread-found" delta="10">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(threadList, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=threadList.size() %>"
		/>			
		<liferay-ui:search-container-row className="CO_Thread" keyProperty="threadId" modelVar="coThread" >
			<%
				threadIndex ++;
				
				String threadCategoryName = "others";
				
				if(coThread.getCategoryId() > 0){
					
					CO_Category threadCategory = CO_CategoryLocalServiceUtil.getCO_Category(coThread.getCategoryId());
					
					if(threadCategory != null){
						
						threadCategoryName = threadCategory.getCategoryName();
					}
				}
				
				String threadStatus = ConversationUtil.getThreadStatusTitle(coThread.getThreadId());
			%>
			
			<liferay-portlet:renderURL var="updateThreadContentURL" >
				<liferay-portlet:param name="threadId" value="<%=String.valueOf(coThread.getThreadId())%>"/>
				<liferay-portlet:param name="jspPage" value="/html/conversation_admin/co_thread/thread_update_form.jsp"/>
				<liferay-portlet:param name="tabs1" value="COThreads"/>
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="#" value="<%=String.valueOf(threadIndex)%>"  href="<%=updateThreadContentURL %>"/>
									
			<liferay-ui:search-container-column-text name="Name" value="<%=coThread.getThreadName() %>" href="<%=updateThreadContentURL %>"/>
			
			<liferay-ui:search-container-column-text name="thread-category">
				<liferay-ui:message key="<%=threadCategoryName %>"/>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="thread-status">
				<liferay-ui:message key="<%=threadStatus %>"/>
			</liferay-ui:search-container-column-text>
			
			<c:if test="<%=CO_ThreadPermission.contains(permissionChecker, scopeGroupId, CO_ThreadPermission.UPDATE_THREAD) %>">
				<liferay-ui:search-container-column-text name="edit">
					<liferay-ui:icon image="edit" message="edit" url="<%= updateThreadContentURL %>" />
				</liferay-ui:search-container-column-text>
			</c:if>
																		
			<c:if test="<%=CO_ThreadPermission.contains(permissionChecker, scopeGroupId, CO_ThreadPermission.DELETE_THREAD) %>">										
				
				<liferay-portlet:actionURL  name="deleteCOThread" var="deleteCOThreadURL">
					<liferay-portlet:param name="threadId" value="<%=String.valueOf(coThread.getThreadId())%>"/>
					<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
				</liferay-portlet:actionURL>
				<liferay-ui:search-container-column-text name="delete">
					<liferay-ui:icon-delete url="<%= deleteCOThreadURL %>" 
						confirmation="are-you-sure-to-delete-thread-and-delete-all-conversation-entries-of-this-thread"/>				
				</liferay-ui:search-container-column-text>
			</c:if>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>