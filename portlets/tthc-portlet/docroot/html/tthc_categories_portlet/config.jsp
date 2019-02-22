<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/tthc_categories_portlet/init.jsp"%>

<%
	//Mang luu so luong category hien thi
	int[] numberOfCategoriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20};
%>

<liferay-portlet:actionURL portletConfiguration="true" var="tthcCategoriesConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>


<aui:form name="tthc_categories_config_form" method="post" action="<%=tthcCategoriesConfigURL %>">
	<div class="tthc-portlet-config-panel">		
		<aui:select name="tthcCategoryTypeId" label="select-tthc-category-type">
			<aui:option label="tthc-level" value="<%=TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID %>" 
						selected='<%=(tthcCategoryTypeId == TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID) %>'/>
								
			<aui:option label="tthc-department" value="<%=TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID %>" 
						selected='<%=(tthcCategoryTypeId == TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID) %>'/>
								
			<aui:option label="tthc-category" value="<%=TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID %>" 
						selected='<%=(tthcCategoryTypeId == TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID) %>'/>
								
			<aui:option label="tthc-audience" value="<%=TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID %>" 
						selected='<%=(tthcCategoryTypeId == TTHCConstants.TTHC_AUDIENCE_CATEGORY_TYPE_ID) %>'/>
		</aui:select>
	
		<aui:select name="numbersOfCategoriesDisplay" label="numbers-of-categories-display">
			<aui:option label="all" value="-1" selected='<%=(numbersOfCategoriesDisplay == -1) %>'/>
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
		
		<aui:input type="checkbox" name="displayTTHCCount" label="display-tthc-counter" value="<%=displayTTHCCount %>"/>
	</div>

	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>	
</aui:form>
