<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionFeedbackLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.PropositionFeedback"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/lastest_proposation_feedback/init.jsp"%>

<%
	List<PropositionFeedback> lastestFeedbackList = PropositionFeedbackLocalServiceUtil.findByStatusAndGroup(scopeGroupId
		, PropositionConstants.PUBLISH_FEEDBACK_STATUS_VALUE, 0, numbersOfLastestFeedbackDisplay);
%>

<c:choose>
	<c:when test="<%=lastestFeedbackList.size() > 0 %>">
		<div class="lastest_feedback_list">
			<ul>
				<%
				for(PropositionFeedback lastestFeedback : lastestFeedbackList){
					
					long feedbackId = lastestFeedback.getFeedbackId();
					
					long propositionId = lastestFeedback.getPropositionId();
					
					String feedbackTitle = StringUtil.shorten(lastestFeedback.getFeedbackTitle(),80);
					String citizenName = lastestFeedback.getCitizenName();
					String sendDate = dateFormat.format(lastestFeedback.getCreateDate());
				%>
					<liferay-portlet:renderURL var="viewFeedbackContentURL">
						<liferay-portlet:param name="propositionId" value="0"/>
						<liferay-portlet:param name="feedbackId" value="<%=String.valueOf(feedbackId) %>"/>
					</liferay-portlet:renderURL>
					<li>
						<a href="<%=viewFeedbackContentURL%>"><%=feedbackTitle %></a>
						<br/>
						<span class="citizen_name"><%=citizenName %> | </span>
						<span class="proposition_publish_date"><%=sendDate %></span>
					</li>
				<%
				}
				%>
			</ul>
		</div>
	</c:when>
	
	<c:otherwise>
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>
		<div class="portlet-configuration portlet-msg-info">
			<aui:a href="<%= portletDisplay.getURLConfiguration() %>" label="please-config-portlet-to-display-data" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
		</div>
	</c:otherwise>
</c:choose>
