<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/vbpq_category_portlet/init.jsp"%>

<%
	int[] numberOfEntriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="vbpq_settings_form" method="post" action="<%=configurationURL %>">
	<div class="portlet-config-form">
					
		<aui:select name="categoryType" label="select-category-type">
			<aui:option label="vbpq-department" value="department" selected='<%=Validator.equals(categoryType, "department") %>'/>
			<aui:option label="vbpq-category" value="category" selected='<%=Validator.equals(categoryType, "category") %>'/>
			<aui:option label="vbpq-doctype" value="doctype" selected='<%=Validator.equals(categoryType, "doctype") %>'/>
		</aui:select>
									
		<aui:select name="numbersOfEntriesDisplay" label="numbers-of-entries-display">
			<aui:option label="all" value="<%=displayAllCategory %>" selected="<%=(numbersOfEntriesDisplay == displayAllCategory) %>"/>
			<%
			for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
			{
				int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
			%>
				<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
							selected="<%=(numbersOfEntriesDisplay == numberOfEntriesDisplayTempValue) %>"/>
			<%
			}
			%>
		</aui:select>
		
		<aui:input type="checkbox" name="displayVBPQCount" label="display-vbpq-counter" value="<%=displayVBPQCount %>"/>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
</aui:form>
		