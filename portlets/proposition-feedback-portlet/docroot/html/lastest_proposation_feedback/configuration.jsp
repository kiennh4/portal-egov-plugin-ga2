<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/lastest_proposation_feedback/init.jsp"%>

<%
	int[] numberOfEntriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>


<aui:form name="proposition_config_form" method="post" action="<%=configurationURL %>" enctype="multipart/form-data">
	<div class="proposition_view_configuration">
		<aui:select name="displayStyle" label="select-display-style">
			<aui:option label="default-style" value="default" selected='<%=Validator.equals(displayStyle, "default") %>'/>
		</aui:select>

		<aui:select name="numbersOfLastestFeedbackDisplay" label="numbers-of-lastest-proposition-entries-display-in-view-page">
			<aui:option label="all-entries" value="-1" selected='<%=(numbersOfLastestFeedbackDisplay == -1)  %>'/>				
			<%
			for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
			{
				int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
			%>
				<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
							selected="<%=(numbersOfLastestFeedbackDisplay == numberOfEntriesDisplayTempValue) %>"/>
			<%
			}
			%>
		</aui:select>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
</aui:form>
		