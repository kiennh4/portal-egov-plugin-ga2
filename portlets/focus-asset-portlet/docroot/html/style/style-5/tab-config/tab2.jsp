<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/style/style-5/init.jsp"%>

<liferay-ui:panel collapsible='<%=true%>' extended='<%=true%>' title="2nd-tab-settings" defaultState="closed">

	<aui:input label="style-title" name="secondFiveTabTitle" value="<%=secondTabTitle%>"/>

	<div class="aui-field-row query-row">
	
		<span class="aui-field-label"><liferay-ui:message key="display-assets-must-match-these-rules"/></span>
		
		<aui:select inlineField="<%= true %>" name="secondFiveTabQueryContains" label="">
			<aui:option label="contains" value="true"  selected="<%= secondTabQueryContains %>" />
			<aui:option label="does-not-contain" value="false" selected="<%= !secondTabQueryContains %>"/>
		</aui:select>
		
		<aui:select inlineField="<%= true %>" label="" name="secondFiveTabQueryAndOperator">
			<aui:option label="all" value="true" selected="<%= secondTabQueryAndOperator %>"  />
			<aui:option label="any" value="false" selected="<%= !secondTabQueryAndOperator %>"  />
		</aui:select>	
		
		<aui:select id='<%= randomNameSpace + "selector" %>' cssClass="tab-asset-query-name"  
					name="secondFiveTabQueryName" label="" inlineField="<%=true %>" inlineLabel="left">
			<aui:option label="tags" value="assetTags" selected='<%= Validator.equals(secondTabQueryName, "assetTags") %>' />
			<aui:option label="categories" value="assetCategories" selected='<%= Validator.equals(secondTabQueryName, "assetCategories")  %>'/>
		</aui:select>
		
		<div class="aui-field tags-selector <%= Validator.equals(secondTabQueryName, "assetTags") ? StringPool.BLANK : "aui-helper-hidden" %>">
			<liferay-ui:asset-tags-selector
				hiddenInput="secondFiveTabSelectedTagsNames"
				curTags='<%= Validator.equals(secondTabQueryName, "assetTags") ? secondTabQueryValues : null %>'
				focus="<%= false %>"
			/>
		</div>
		
		<div class="aui-field categories-selector <%= Validator.equals(secondTabQueryName, "assetCategories") ? StringPool.BLANK : "aui-helper-hidden" %>">
			<liferay-ui:asset-categories-selector
				hiddenInput="secondFiveTabSelectedCategoryIds"
				curCategoryIds='<%= Validator.equals(secondTabQueryName, "assetCategories") ? secondTabQueryValues : null %>'
				focus="<%= false %>"
			/>
		</div>	
	</div>

	<aui:select name="secondFiveTabEntriesDisplay" label="total-assets-display" inlineLabel="left">
		<%
		for(int i = 0;i < numbersOfEntriesDisplayValues.length; i++)
		{
			int numbersOfEntriesDisplayValue = GetterUtil.getInteger(numbersOfEntriesDisplayValues[i]);
		%>
			<aui:option label="<%= String.valueOf(numbersOfEntriesDisplayValue)%>" 
						value="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
						selected='<%= secondTabEntriesDisplay == numbersOfEntriesDisplayValue %>'/>
		<%
		}
		%>
	</aui:select>
	
	<div style="clear: both;"></div>
					
	<aui:select inlineField="<%= true %>" name="secondFiveTabOrderByColumn" label="asset-order-by-column" inlineLabel="left" >
		<aui:option label="by-title" value="title"  selected='<%= Validator.equals(secondTabOrderByColumn, "title") %>'/>
		<aui:option label="by-publish-date" value="publishDate" selected='<%= Validator.equals(secondTabOrderByColumn, "publishDate") %>'/>
		<aui:option label="by-view-count" value="viewCount" selected='<%= Validator.equals(secondTabOrderByColumn, "viewCount") %>'/>
	</aui:select>
						
	<aui:select inlineField="<%= true %>" label="" name="secondFiveTabOrderByType">
		<aui:option label="ASC" value="ASC" selected='<%= Validator.equals(secondTabOrderByType, "ASC") %>' />
		<aui:option label="DESC" value="DESC" selected='<%= Validator.equals(secondTabOrderByType, "DESC") %>'  />
	</aui:select>
			
</liferay-ui:panel>

<aui:script>

	AUI().ready(function(A){
		var select = A.one('#<portlet:namespace /><%= randomNameSpace %>selector');
	
		if (select) {
			var row = select.ancestor('.query-row');
	
			if (row) {
				select.on(
					'change',
					function(event) {
						var tagsSelector = row.one('.tags-selector');
						var categoriesSelector = row.one('.categories-selector');
	
						if (select.val() == 'assetTags') {
							if (tagsSelector) {
								tagsSelector.show();
							}
	
							if (categoriesSelector) {
								categoriesSelector.hide();
							}
						}
						else {
							if (tagsSelector) {
								tagsSelector.hide();
							}
	
							if (categoriesSelector) {
								categoriesSelector.show();
							}
						}
					}
				);
			}
		}
	});
</aui:script>
