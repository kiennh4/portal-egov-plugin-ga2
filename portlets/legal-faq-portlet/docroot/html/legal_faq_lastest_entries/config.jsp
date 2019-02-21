<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/legal_faq_lastest_entries/init.jsp"%>

<style type="text/css">
	
	.legal_faq_lastest_entry_config{
		border: 1px solid #E4E4E4;
		border-radius: 2px;		
		font-size: 12px;	
		margin-bottom: 10px;
	}

	.legal_faq_lastest_entry_config table tr{
		height:40px;
	}	
	.legal_faq_lastest_entry_config table tr td{
		padding-left: 10px;
		padding-right: 10px;
	}
	
	.legal_faq_lastest_entry_config input[type="text"],
	.legal_faq_lastest_entry_config select{
		background: none repeat scroll 0 0 #FFFFFF;
	    border: 1px solid #A1A2A4;
	    border-radius: 2px;
	    box-shadow: 0 1px 0 white, 0 1px 2px #CCCCCC inset;
	    padding: 5px 1px;
	    text-shadow: none;
	    width: 260px;
	}	

	.legal_faq_lastest_entry_config select{
		width: 264px;
		background-image: none;
		border-radius: 2px;
		box-shadow: 0 1px 0 white, 0 1px 2px #CCCCCC inset;
		padding: 4px;
		border: 1px solid #A1A2A4;
	}	
				
	.legal_faq_lastest_entry_config input.focus,
	.legal_faq_lastest_entry_config textarea.focus{
		background: none repeat scroll 0 0 #F2F8F8 !important;
    	border: 1px solid #8DD4AE !important;
	}
</style>

<%
	//Mang luu so luong category hien thi
	int[] numberOfCategoriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
		
%>

<liferay-portlet:actionURL portletConfiguration="true" var="legalFAQCategoriesConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>


<aui:form name="legal_faq_lastest_entry_config_form" method="post" action="<%=legalFAQCategoriesConfigURL %>">
	
	<div class="legal-faq-portlet-config-panel">
		<aui:select name="numbersOfTopViewEntriesDisplay" label="numbers-of-top-view-entries-display">
			<%
			for(int numberOfCategoriesDisplayTempValue : numberOfCategoriesDisplayValues)
			{
			%>
				<aui:option label="<%=String.valueOf(numberOfCategoriesDisplayTempValue) %>" value="<%=numberOfCategoriesDisplayTempValue %>" 
							selected="<%=(numbersOfTopViewEntriesDisplay == numberOfCategoriesDisplayTempValue) %>"/>
			<%
			}
			%>
		</aui:select>

		<aui:select name="numbersOfLastestEntriesDisplay" label="numbers-of-lastest-entries-display">
			<%
			for(int numberOfCategoriesDisplayTempValue : numberOfCategoriesDisplayValues)
			{
			%>
				<aui:option label="<%=String.valueOf(numberOfCategoriesDisplayTempValue) %>" value="<%=numberOfCategoriesDisplayTempValue %>" 
							selected="<%=(numbersOfLastestEntriesDisplay == numberOfCategoriesDisplayTempValue) %>"/>
			<%
			}
			%>
		</aui:select>
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
</aui:form>
		