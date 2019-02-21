<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	int[] numberOfEntriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="vbpq_settings_form" method="post" action="<%=configurationURL %>">
	
	<div class="portlet-config-form">
		
		<aui:select name="displayStyle">
			<aui:option label="default" value="default-display-style" selected='<%=Validator.equals(displayStyle, "default-display-style") %>'/>
			<aui:option label="search-form" value="vbpq-search-form" selected='<%=Validator.equals(displayStyle, "vbpq-search-form")  %>'/>
		</aui:select>
		
		<div id="<portlet:namespace/>defaultDisplayStyleSettingContainer">
								
			<aui:select name="numbersOfLastestEntriesDisplay" label="numbers-of-lastest-entries-display-in-view-page">
				<aui:option label="all-entries" value="-1" selected='<%=(numbersOfLastestEntriesDisplay == -1)  %>'/>				
				<%
				for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
				{
					int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
				%>
					<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
								selected="<%=(numbersOfLastestEntriesDisplay == numberOfEntriesDisplayTempValue) %>"/>
				<%
				}
				%>
			</aui:select>
			
			<aui:select name="numbersOfEntriesDisplayOnSearchResultPage" label="numbers-of-entries-display-in-search-results-page">
				<aui:option label="all-entries" value="-1" selected='<%=(numbersOfEntriesDisplayOnSearchResultPage == -1)  %>'/>					
				<%
				for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
				{
					int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
				%>
					<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
								selected="<%=(numbersOfEntriesDisplayOnSearchResultPage == numberOfEntriesDisplayTempValue) %>"/>
				<%
				}
				%>
			</aui:select>
			
			<aui:input id="displayRelatedEntries" name="displayRelatedEntries" type="checkbox" value="<%= displayRelatedEntries %>"/>
			
			<div id="vbpq_related_entries_advanced_settings">
				<aui:select name="relatedVBPQFilter" label="related-filter">
					<aui:option label="by-vbpq-category" value="vbpqCategory" selected='<%=Validator.equals(relatedVBPQFilter, "vbpqCategory") %>'/>
					<aui:option label="by-vbpq-department" value="vbpqDepartment" selected='<%=Validator.equals(relatedVBPQFilter, "vbpqDepartment") %>'/>
					<aui:option label="by-vbpq-doctype" value="vbpqDoctype" selected='<%=Validator.equals(relatedVBPQFilter, "vbpqDoctype") %>'/>
				</aui:select>
				
				<aui:select name="numbersOfRelatedEntries" label="numbers-of-related-entries-display">
					<aui:option label="all-entries" value="-1" selected='<%=(numbersOfRelatedEntries == -1)  %>'/>				
					<%
					for(int i =0;i< numberOfEntriesDisplayValues.length; i ++)
					{
						int numberOfEntriesDisplayTempValue = numberOfEntriesDisplayValues[i];
					%>
						<aui:option label="<%=String.valueOf(numberOfEntriesDisplayTempValue) %>" value="<%=numberOfEntriesDisplayTempValue %>" 
									selected="<%=(numbersOfRelatedEntries == numberOfEntriesDisplayTempValue) %>"/>
					<%
					}
					%>
				</aui:select>
			</div>
		</div>	
	</div>
	
	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
	
</aui:form>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		Liferay.Util.toggleBoxes('<portlet:namespace/>displayRelatedEntriesCheckbox','vbpq_related_entries_advanced_settings');
			
		var displayStyleSelector = A.one('#<portlet:namespace/>displayStyle');

		var vbpqSearchFormStyle = 'vbpq-search-form';
		
		var defaultDisplayStyleSettingContainer = A.one('#<portlet:namespace/>defaultDisplayStyleSettingContainer');
		
		if(displayStyleSelector && defaultDisplayStyleSettingContainer){
			
			if(displayStyleSelector.val() == vbpqSearchFormStyle){
				
				defaultDisplayStyleSettingContainer.hide();
			}
			
			displayStyleSelector.on(
				'change',
				function(event){
					
					var currentSelectedValue = displayStyleSelector.val();
										
					if(currentSelectedValue == vbpqSearchFormStyle){																
						defaultDisplayStyleSettingContainer.hide();
											
					}else{
						defaultDisplayStyleSettingContainer.show();
					}
				}
			);
		}
	});

</script>
		