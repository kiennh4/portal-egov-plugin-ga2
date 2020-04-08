<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<style type="text/css">
	.show-advanced-settings-action-trigger{
		text-align: right;
	}
	
	.show-advanced-settings-action-trigger a{
		text-decoration: underline;
	}
</style>

<%@include file="/html/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL">
	<liferay-portlet:param  name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>


<form action="<%= configurationActionURL %>" 
	  enctype="multipart/form-data" method="post" 
	  name='<portlet:namespace />entry-selector-form'>
				
	<liferay-ui:panel-container>
		<liferay-ui:panel collapsible='<%= true %>' extended='<%= true %>' title="">
			<div style="font-weight: bold;">
				<aui:select name="displayStyle" label="display-style" inlineLabel="left">
					<aui:option label="<%= defaultDisplayStyle%>" selected='<%= displayStyle.equals(defaultDisplayStyle) %>'/>
					<aui:option label="<%= listTitleDisplayStyle%>" selected='<%= displayStyle.equals(listTitleDisplayStyle) %>'/>
					<aui:option label="<%= sliderDisplayStyle%>" selected='<%= displayStyle.equals(sliderDisplayStyle) %>'/>
				</aui:select>
				
				<div class="lfr-form-row">
					<div class="row-fields">
						<div class="aui-field-row query-row">						
							<aui:select cssClass="asset-query-name" 
										id= "entrySelector" name="selectedName" 
										inlineLabel="left" label="select-entry-type"
							>
								<aui:option label="tags" selected='<%= Validator.equals(selectedName, "assetTags") %>' value="assetTags" />
								<aui:option label="categories" selected='<%= Validator.equals(selectedName, "assetCategories") %>' value="assetCategories" />
							</aui:select>
							<div class="aui-field tags-selector <%= Validator.equals(selectedName, "assetTags") ? StringPool.BLANK : "aui-helper-hidden" %>">
								<liferay-ui:asset-tags-selector
									hiddenInput="selectedTagsNames"
									curTags='<%= Validator.equals(selectedName, "assetTags") ? currentSelectedValues : null %>'
									focus="<%= false %>"
								/>
							</div>
										
							<div class="aui-field categories-selector <%= Validator.equals(selectedName, "assetCategories") ? StringPool.BLANK : "aui-helper-hidden" %>">
								<liferay-ui:asset-categories-selector
									hiddenInput="selectedCategoryIds"
									curCategoryIds='<%= Validator.equals(selectedName, "assetCategories") ? currentSelectedValues : null %>'
									focus="<%= false %>"
								/>
							</div>
						</div>		
					</div>
				</div>
			</div>	
			
			<div class="show-advanced-settings-action-trigger">
				<a id="show-advanced-settings-action-trigger" href='javascript:;'>
					<liferay-ui:message key="show-advance-settings"/> >>>
				</a>
			</div>
			
			<input type="hidden" name="configCommand" value="updateEntriesSelection" />							

			<aui:button onClick="submitForm(document.<portlet:namespace />entry-selector-form);" 
						type="submit" 
						value="save"/>				
		</liferay-ui:panel>		
	</liferay-ui:panel-container>
</form>

<div id="advanced-settings-container" class="advanced-settings-container aui-helper-hidden">
<!-- TAG PROPERTIES -->
<c:if test='<%=Validator.equals(selectedName, "assetTags") %>'>
	<liferay-util:include page="/html/config/tag_properties.jsp" servletContext="<%=this.getServletContext() %>"/>
</c:if>

<!-- CATEGORY PROPERTIES -->
<c:if test='<%=Validator.equals(selectedName, "assetCategories") %>'>
	<liferay-util:include page="/html/config/category_properties.jsp" servletContext="<%=this.getServletContext() %>"/>
</c:if>
</div>

<script>

AUI().ready('aui-base',function(A){

	var select = A.one('#<portlet:namespace />entrySelector');
	
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
	
	var advancedSettingContainer = A.one('#advanced-settings-container');
	
	if(advancedSettingContainer){
		
		var showAdvancedSettingsTrigger = A.one('#show-advanced-settings-action-trigger');
	
		if(showAdvancedSettingsTrigger){
			
			showAdvancedSettingsTrigger.on('click',function(){
				
				console.log('click');
				
				if(advancedSettingContainer.hasClass('aui-helper-hidden')){
					
					advancedSettingContainer.show();
				
				}else{
					
					advancedSettingContainer.hide();
				}
				
			});
		}
	}
});
</script>