<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.util.PropositionConstants"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.service.PropositionLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.proposition_feedback.model.Proposition"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/lastest_proposation/init.jsp"%>

<%
	List<Proposition> lastestPropositionList = PropositionLocalServiceUtil.findByPropositionStatus(scopeGroupId,
		PropositionConstants.ALL_PUBLISH_PROPOSITION_STATUS,PropositionConstants.ORDER_BY_CREATE_DATE, 
		PropositionConstants.ORDER_BY_TYPE_DESC, 0, numbersOfLastestPropositionDisplay);
%>

<c:choose>
	<c:when test="<%=lastestPropositionList.size() > 0 %>">
		<div class="lastest_proposition_list">
			<ul>
				<%
				for(Proposition lastestProposition : lastestPropositionList){
					
					String propositionName = StringUtil.shorten(lastestProposition.getPropositionName(), 80);
					
					String publishDate = dateFormat.format(lastestProposition.getCreateDate());
				%>
					<liferay-portlet:renderURL var="viewPropositionURL">
						<liferay-portlet:param name="propositionId" value="<%=String.valueOf(lastestProposition.getPropositionId()) %>"/>
						<liferay-portlet:param name="feedbackId" value="0"/>
					</liferay-portlet:renderURL>
					<li>
						<a href="<%=viewPropositionURL%>"><%=propositionName %></a>
						<span class="proposition_publish_date"><%=publishDate %></span>
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
