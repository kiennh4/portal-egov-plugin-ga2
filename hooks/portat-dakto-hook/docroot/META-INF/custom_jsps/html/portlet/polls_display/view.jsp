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

<style type="text/css">
	
	.portlet-polls-display .poll-question-title{
		font-size: 12px;
		font-weight: bold;
		color: #bc0000;
		padding: 10px 0px;
		text-shadow:1px 1px white;
	}
		
	.portlet-polls-display .poll-question-choices{
		font-size: 11px;
	}
			
	.portlet-polls-display .poll-question-choices table{
		width: 100%;
	}
				
	.portlet-polls-display .poll-question-choices table tr.results-header{
		background: #f0f0f0;
	}
					
	.portlet-polls-display .poll-question-choices table tr.results-header td{
		color: #00528b;
		font-weight: bold;
	}
	
</style>

<%@ include file="/html/portlet/polls_display/init.jsp" %>

<%
PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeys.POLLS_QUESTION);
%>

<c:choose>
	<c:when test="<%= question == null %>">

		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="portlet-configuration portlet-msg-info">
			<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
				<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
			</a>
		</div>
	</c:when>
	<c:otherwise>

		<%
		String redirect = StringPool.BLANK;

		question = question.toEscapedModel();

		List<PollsChoice> choices = question.getChoices();

		boolean hasVoted = PollsUtil.hasVoted(request, question.getQuestionId());
		%>

		<portlet:actionURL var="voteQuestionURL">
			<portlet:param name="struts_action" value="/polls_display/vote_question" />
		</portlet:actionURL>

		<aui:form action="<%= voteQuestionURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.VOTE %>" />
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />
			<aui:input name="successMessage" type="hidden" value='<%= LanguageUtil.get(pageContext, "thank-you-for-your-vote") %>' />

			<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
			<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />
			
			<div class="poll-question-title" >
				<%= StringUtil.replace(question.getDescription(locale), StringPool.NEW_LINE, "<br />") %>
			</div>
			
			<div class="poll-question-choices">
				<c:choose>
					<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
						<aui:fieldset>
							<aui:field-wrapper>
	
								<%
								for (PollsChoice choice : choices) {
									choice = choice.toEscapedModel();
								%>
	
									<aui:input inlineLabel="left" label='<%= "<strong>" + choice.getName() + ".</strong> " + choice.getDescription(locale) %>' name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" />
	
								<%
								}
								%>
	
							</aui:field-wrapper>
	
							<aui:button type="submit" value="vote" />
						</aui:fieldset>
					</c:when>
					<c:otherwise>
						<%@ include file="/html/portlet/polls_display/view_question_results.jspf" %>
					</c:otherwise>
				</c:choose>
			</div>
		</aui:form>
	</c:otherwise>
</c:choose>

<%
boolean hasViewPermission = true;

if (question != null) {
	hasViewPermission = PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.VIEW);
}

boolean showEditPollIcon = (question != null) && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.UPDATE);
boolean showSelectPollIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION);
boolean showAddPollIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION) && PollsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_QUESTION);
boolean showIconsActions = themeDisplay.isSignedIn() && (showEditPollIcon || showSelectPollIcon || showAddPollIcon);
%>

<c:if test="<%= showIconsActions && hasViewPermission %>">

	<%
	Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.CONTROL_PANEL);

	long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);

	PortletURL redirectURL = liferayPortletResponse.createRenderURL();

	redirectURL.setWindowState(LiferayWindowState.POP_UP);

	redirectURL.setParameter("struts_action", "/polls_display/add_question_redirect");
	%>

	<div class="lfr-meta-actions icons-container">
		<div class="icon-actions">
			<c:if test="<%= showEditPollIcon %>">
				<liferay-portlet:renderURL doAsGroupId="<%= scopeGroupId %>" plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.POLLS %>" refererPlid="<%= plid %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="editPollURL">
					<liferay-portlet:param name="struts_action" value="/polls/edit_question" />
					<liferay-portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
					<liferay-portlet:param name="referringPortletResource" value="<%= portletDisplay.getId() %>" />
					<liferay-portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</liferay-portlet:renderURL>

				<%
				String editQuestionURL = "javascript:Liferay.Util.openWindow({dialog: {width: 960}, id: '" + liferayPortletResponse.getNamespace() + "', title: '" + ResourceActionsUtil.getModelResource(locale, PollsQuestion.class.getName()) + "', uri:'" + HtmlUtil.escapeURL(editPollURL.toString()) + "'});";
				%>

				<liferay-ui:icon
					image="edit"
					message="edit-question"
					url="<%= editQuestionURL %>"
				/>
			</c:if>

			<c:if test="<%= showSelectPollIcon %>">
				<liferay-ui:icon
					cssClass="portlet-configuration"
					image="configuration"
					message="select-question"
					method="get"
					onClick="<%= portletDisplay.getURLConfigurationJS() %>"
					url="<%= portletDisplay.getURLConfiguration() %>"
				/>
			</c:if>

			<c:if test="<%= showAddPollIcon %>">
			   	<liferay-portlet:renderURL doAsGroupId="<%= scopeGroupId %>" plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.POLLS %>" refererPlid="<%= plid %>" windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="addPollURL">
					<liferay-portlet:param name="struts_action" value="/polls/edit_question" />
					<liferay-portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
					<liferay-portlet:param name="referringPortletResource" value="<%= portletDisplay.getId() %>" />
				</liferay-portlet:renderURL>

				<%
				String addQuestionURL = "javascript:Liferay.Util.openWindow({dialog: {width: 960}, id: '" + liferayPortletResponse.getNamespace() + "', title: '" + ResourceActionsUtil.getModelResource(locale, PollsQuestion.class.getName()) + "', uri:'" + HtmlUtil.escapeURL(addPollURL.toString()) + "'});";
				%>

				<liferay-ui:icon
					image="add_article"
					message="add-question"
					url="<%= addQuestionURL %>"
				/>
			</c:if>
		</div>
	</div>
</c:if>