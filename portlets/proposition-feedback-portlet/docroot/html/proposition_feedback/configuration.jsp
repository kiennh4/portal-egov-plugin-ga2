<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/proposition_feedback/init.jsp"%>

<%
	int[] numberOfEntriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
%>

<style type="text/css">
	.proposition_view_configuration select{
		width: auto !important;
	}
</style>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>


<aui:form name="proposition_config_form" method="post" action="<%=configurationURL %>" enctype="multipart/form-data">
	<div class="proposition_view_configuration">
		<br/>
		<table>						
			<tr>
				<td><liferay-ui:message key="numbers-of-lastest-proposition-entries-display-in-view-page"/></td>
				<td>			
					<aui:select name="numbersOfLastestProposition" label="">
						<aui:option label="all-entries" value="0" selected='<%=(numbersOfLastestProposition == 0)  %>'/>				
						<%
						for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
						{
							int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
						%>
							<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
										selected="<%=(numbersOfLastestProposition == numberOfEntriesDisplayTempValue) %>"/>
						<%
						}
						%>
					</aui:select>
				</td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="numbers-of-top-view-count-proposition-entries-display-in-view-page"/></td>
				<td>			
					<aui:select name="numbersOfTopViewProposition" label="">
						<aui:option label="all-entries" value="0" selected='<%=(numbersOfTopViewProposition == 0)  %>'/>				
						<%
						for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
						{
							int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
						%>
							<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
										selected="<%=(numbersOfTopViewProposition == numberOfEntriesDisplayTempValue) %>"/>
						<%
						}
						%>
					</aui:select>
				</td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="numbers-of-top-feedback-proposition-entries-display-in-view-page"/></td>
				<td>			
					<aui:select name="numbersOfTopFeedbackProposition" label="">
						<aui:option label="all-entries" value="0" selected='<%=(numbersOfTopFeedbackProposition == 0)  %>'/>				
						<%
						for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
						{
							int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
						%>
							<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
										selected="<%=(numbersOfTopFeedbackProposition == numberOfEntriesDisplayTempValue) %>"/>
						<%
						}
						%>
					</aui:select>
				</td>
			</tr>
			
			<tr>
				<td><liferay-ui:message key="numbers-of-proposition-entries-display-in-search-results-page"/></td>
				<td>			
					<aui:select name="numbersOfSearchResultProposition" label="">
						<aui:option label="all-entries" value="0" selected='<%=(numbersOfSearchResultProposition == 0)  %>'/>					
						<%
						for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
						{
							int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
						%>
							<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
										selected="<%=(numbersOfSearchResultProposition == numberOfEntriesDisplayTempValue) %>"/>
						<%
						}
						%>
					</aui:select>
				</td>
			</tr>
		</table>
		<br/>
	</div>
	<br/>
	<aui:button type="submit" value="save"/>
</aui:form>
		