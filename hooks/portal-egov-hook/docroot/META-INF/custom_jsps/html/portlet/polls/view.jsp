<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.polls.service.PollsVoteLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.permission.GroupPermissionUtil"%>
<%@page import="com.liferay.portlet.polls.service.permission.PollsPermission"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portlet.polls.model.PollsQuestion"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>

<style type="text/css">
	.portlet-polls .lfr-header-row{
		margin-bottom: 10px;
		background: url("/html/portlet/polls/images/admin_toolbar_bg.png") repeat-x scroll 0 0 #D9D9D9;
    	border: 1px solid #C9C9C9;
    	border-radius:3px;
	}	
	
	.portlet-polls  .lfr-header-row-content{
		padding: 2px 4px 0 !important;
	}
							
	.portlet-polls .lfr-search-container .aui-field-content{
		margin: 0px !important;
	}
						
	.portlet-polls .lfr-search-container .delta-selector,
	.portlet-polls .lfr-search-container .page-selector{
		padding-right: 5px;
	}
				
	.portlet-polls .lfr-search-container .delta-selector select,
	.portlet-polls .lfr-search-container .page-selector select{
		border-radius: 2px !important;
		padding: 0px !important;
		margin: 0px !important;
	}
</style>

<%@ include file="/html/portlet/polls/init.jsp" %>

<aui:form method="post" name="fm">

	<%

	boolean showAddPollButton = PollsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_QUESTION);
	
	boolean showPermissionsButton = GroupPermissionUtil.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
	
	int pollIndex = 0;

	List<PollsQuestion> pollQuestionList = PollsQuestionLocalServiceUtil.getQuestions(scopeGroupId);

	%>

	<aui:fieldset>
		<c:if test="<%= showAddPollButton || showPermissionsButton %>">
			<div class="lfr-header-row">
				<div class="lfr-header-row-content">
					<aui:button-row>
						<c:if test="<%= showAddPollButton %>">
							<portlet:renderURL var="editQuestionURL">
								<portlet:param name="struts_action" value="/polls/edit_question" />
								<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(request) %>" />
							</portlet:renderURL>
		
							<aui:button href="<%= editQuestionURL %>" value="add-question" />
						</c:if>
		
						<c:if test="<%= showPermissionsButton %>">
							<liferay-security:permissionsURL
								modelResource="com.liferay.portlet.polls"
								modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
								resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
								var="permissionsURL"
							/>
		
							<aui:button href="<%= permissionsURL %>" value="permissions" />
						</c:if>
					</aui:button-row>
				</div>
			</div>
		</c:if>
		
		<div>
			<liferay-portlet:renderURL varImpl="pollAdminImplURL">
				<liferay-portlet:param name="struts_action" value="/polls/view"/>
			</liferay-portlet:renderURL>
			
			<liferay-ui:search-container emptyResultsMessage="no-entry-found" iteratorURL="<%=pollAdminImplURL %>">
				<liferay-ui:search-container-results
					results="<%=ListUtil.subList(pollQuestionList, searchContainer.getStart(), searchContainer.getEnd())%>"
					total="<%=pollQuestionList.size() %>"
				/>			
					
				<liferay-ui:search-container-row className="PollsQuestion" keyProperty="questionId" modelVar="pollQuestion" >
					<%
						pollIndex++;
					
						int votesCount = PollsVoteLocalServiceUtil.getQuestionVotesCount(pollQuestion.getQuestionId());
						
						String questionLastVoteDateStr = LanguageUtil.get(pageContext, "never");
						
						String questionExpirationDateStr = LanguageUtil.get(pageContext, "never");
						
						if(pollQuestion.getLastVoteDate() != null){
							
							questionLastVoteDateStr = dateFormatDateTime.format(pollQuestion.getLastVoteDate());
						}
						
						
						if(pollQuestion.getExpirationDate() != null){
							
							questionExpirationDateStr = dateFormatDateTime.format(pollQuestion.getExpirationDate());
						}
						
					%>
					
					<liferay-portlet:renderURL var="viewQuestionURL" >				
						<liferay-portlet:param name="struts_action" value="/polls/view_question"/>
						<liferay-portlet:param name="questionId" value="<%=String.valueOf(pollQuestion.getQuestionId()) %>"/>
						<liferay-portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request) %>"/>
					</liferay-portlet:renderURL>
									
					<liferay-ui:search-container-column-text 
						name="#" 
						value="<%=String.valueOf(pollIndex) %>" 
						href="<%=viewQuestionURL %>"
					/>
						
					<liferay-ui:search-container-column-text 
						name="question" 
						value="<%=StringUtil.shorten(pollQuestion.getTitle(locale), 80)%>" 
						href="<%=viewQuestionURL %>"
					/>
					
					<liferay-ui:search-container-column-text 
						name="num-of-votes" 
						value="<%=String.valueOf(votesCount)%>" 
					/>
					
					<liferay-ui:search-container-column-text 
						name="last-vote-date" 
						value="<%=questionLastVoteDateStr%>"
					/>
									
					<liferay-ui:search-container-column-text 
						name="expiration-date" 
						value="<%=questionExpirationDateStr%>"
					/>
					
					<liferay-ui:search-container-column-text name="edit">
						<c:if test="<%=PollsQuestionPermission.contains(permissionChecker, pollQuestion, ActionKeys.UPDATE)%>">		
											
							<liferay-portlet:renderURL var="updateQuestionURL" >				
								<liferay-portlet:param name="struts_action" value="/polls/edit_question"/>
								<liferay-portlet:param name="questionId" value="<%=String.valueOf(pollQuestion.getQuestionId()) %>"/>
								<liferay-portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request) %>"/>
							</liferay-portlet:renderURL>	
																		
							<liferay-ui:icon image="edit" message="edit" url="<%= updateQuestionURL %>" />
						</c:if>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="permissions">
						<c:if test="<%= PollsQuestionPermission.contains(permissionChecker, pollQuestion, ActionKeys.PERMISSIONS) %>">
							<liferay-security:permissionsURL
								modelResource="<%= PollsQuestion.class.getName() %>"
								modelResourceDescription="<%= pollQuestion.getTitle(locale) %>"
								resourcePrimKey="<%= String.valueOf(pollQuestion.getQuestionId()) %>"
								var="permissionsURL"
							/>
					
							<liferay-ui:icon
								image="permissions"
								url="<%= permissionsURL %>"
							/>
						</c:if>
					</liferay-ui:search-container-column-text>
									
					<liferay-ui:search-container-column-text name="delete">
						<c:if test="<%= PollsQuestionPermission.contains(permissionChecker, pollQuestion, ActionKeys.DELETE)%>">
																					
							<liferay-portlet:actionURL var="deleteQuestionURL">
								<liferay-portlet:param name="struts_action" value="/polls/edit_question"/>
								<liferay-portlet:param name="<%= Constants.CMD %>" value="<%=Constants.DELETE %>"/>
								<liferay-portlet:param name="questionId" value="<%=String.valueOf(pollQuestion.getQuestionId()) %>"/>
								<liferay-portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request) %>"/>
							</liferay-portlet:actionURL>
							
							<liferay-ui:icon-delete url="<%= deleteQuestionURL %>" />
						</c:if>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
	</aui:fieldset>
</aui:form>