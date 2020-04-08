<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/tthc_lastest_entries_portlet/init.jsp"%>

<%
	int[] numberOfEntriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30};
%>

<liferay-portlet:actionURL portletConfiguration="true" var="tthcLastestEntriesConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="tthc_lastest_entries_config_form" method="post" action="<%=tthcLastestEntriesConfigURL %>">
	
	<div class="tthc-portlet-config-panel">		
			
		<aui:select name="numbersOfEntriesDisplay" label="">	
			<aui:option label="all" value="-1" selected='<%=(numbersOfEntriesDisplay == -1) %>'/>					
			<%
			for(int numberOfEntriesDisplayTempValue : numberOfEntriesDisplayValues)
			{
			%>
				<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
							selected="<%=(numbersOfEntriesDisplay == numberOfEntriesDisplayTempValue) %>"/>
			<%
			}
			%>
		</aui:select>
		
	</div>

	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>	
</aui:form>

