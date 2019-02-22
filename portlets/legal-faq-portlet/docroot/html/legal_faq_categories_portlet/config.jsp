<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/legal_faq_categories_portlet/init.jsp"%>

<%
	//Mang luu so luong category hien thi
	int[] numberOfCategoriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
		
%>

<liferay-portlet:actionURL portletConfiguration="true" var="legalFAQCategoriesConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="legal_faq_categories_config_form" method="post" action="<%=legalFAQCategoriesConfigURL %>">
	
	<div class="legal-faq-portlet-config-panel">

		<aui:select name="numbersOfCategoriesDisplay" label="numbers-of-categories-display" inlineLabel="left">
			<aui:option label="all" value="-1" selected='<%=numbersOfCategoriesDisplay == -1 %>'/>
			<%
			for(int numberOfCategoriesDisplayTempValue : numberOfCategoriesDisplayValues)
			{
			%>
				<aui:option label="<%=String.valueOf(numberOfCategoriesDisplayTempValue) %>" value="<%=numberOfCategoriesDisplayTempValue %>" 
							selected="<%=(numbersOfCategoriesDisplay == numberOfCategoriesDisplayTempValue) %>"/>
			<%
			}
			%>
		</aui:select>
		
		<aui:input name="displayFAQCounter" type="checkbox" label="display-faq-counter-value" value="<%= displayFAQCounter %>"/>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
</aui:form>
		