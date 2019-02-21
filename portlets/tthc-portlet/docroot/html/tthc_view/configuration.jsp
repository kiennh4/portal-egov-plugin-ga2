<%@page import="com.portal_egov.portlet.tthc.util.TTHCConstants"%>
<%@page import="com.portal_egov.portlet.tthc.service.TTHC_CategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.tthc.model.TTHC_Category"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/tthc_view/init.jsp"%>

<%
	int[] numberOfEntriesDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
	
	//Danh sach co quan thuc hein thu tuc
	List<TTHC_Category> departmentList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_DEPARTMENT_CATEGORY_TYPE_ID, groupId);
	
	//Danh sach linh vuc thuc hien thu tuc
	List<TTHC_Category> categoriesList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_CATEGORY_CATEGORY_TYPE_ID, groupId);
	
	//Danh sach phan cap thuc tuc
	List<TTHC_Category> tthcLevelList = TTHC_CategoryLocalServiceUtil.findByTypeAndGroup(TTHCConstants.TTHC_LEVEL_CATEGORY_TYPE_ID, groupId);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL">	
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<aui:form name="tthc_settings_form" method="post" action="<%=configurationURL %>" >
	
	<div class="tthc-portlet-config-panel">
				
		<aui:select name="displayStyle">
			<aui:option label="default" value="default-display-style" selected='<%=Validator.equals(displayStyle, "default-display-style") %>'/>
			<aui:option label="search-form" value="tthc-search-form" selected='<%=Validator.equals(displayStyle, "tthc-search-form")  %>'/>
		</aui:select>
		
		<div id="<portlet:namespace/>defaultDisplayStyleSettingContainer">
		
			<aui:select name="tthcScope" label="select-tthc-scope">
				<aui:option label="all" value="" selected='<%=Validator.equals(tthcScope, StringPool.BLANK) %>'/>
				<aui:option label="by-tthc-department" value="tthcDepartment" selected='<%=Validator.equals(tthcScope, "tthcDepartment") %>'/>
				<aui:option label="by-tthc-category" value="tthcCategory" selected='<%=Validator.equals(tthcScope, "tthcCategory") %>'/>
				<aui:option label="by-tthc-level" value="tthcLevel" selected='<%=Validator.equals(tthcScope, "tthcLevel") %>'/>
			</aui:select>
			
			<div id="tthc-department-scope-selector" class='tthc-advanced-settings-container <%=Validator.equals(tthcScope, "tthcDepartment") ? "" : "aui-helper-hidden"%>'>
				<aui:select name="departmentScopeId" label="select-tthc-department">
				<%
				for(TTHC_Category department : departmentList){
				%>
					<aui:option label="<%=department.getCategoryName() %>" value="<%=String.valueOf(department.getCategoryId()) %>" 
								selected='<%=departmentScopeId == department.getCategoryId() %>'/>
				<%
				}
				%>
				</aui:select>
			</div>
					
			<div id="tthc-category-scope-selector" class='tthc-advanced-settings-container <%=Validator.equals(tthcScope, "tthcCategory") ? "" : "aui-helper-hidden"%>'>
				<aui:select name="categoryScopeId" label="select-tthc-category">
				<%
				for(TTHC_Category category : categoriesList){
				%>
					<aui:option label="<%=category.getCategoryName() %>" value="<%=String.valueOf(category.getCategoryId()) %>" 
								selected='<%=categoryScopeId == category.getCategoryId() %>'/>
				<%
				}
				%>
				</aui:select>
			</div>
							
			<div id="tthc-level-scope-selector" class='tthc-advanced-settings-container <%=Validator.equals(tthcScope, "tthcLevel") ? "" : "aui-helper-hidden"%>'>
				<aui:select name="tthcLevelScopeId" label="select-tthc-level">
				<%
				for(TTHC_Category tthcLevel : tthcLevelList){
				%>
					<aui:option label="<%=tthcLevel.getCategoryName() %>" value="<%=String.valueOf(tthcLevel.getCategoryId()) %>" 
								selected='<%=tthcLevelScopeId == tthcLevel.getCategoryId() %>'/>
				<%
				}
				%>
				</aui:select>
			</div>
			
	
			<aui:select name="numbersOfLastestEntriesDisplay" label="numbers-of-lastest-tthc-entries-display-in-view-page">
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
	
			<aui:select name="numbersOfEntriesDisplayOnSearchResultPage" label="numbers-of-tthc-entries-display-in-search-results-page">
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
				
			<aui:input name="displayTTHCSearchForm" type="checkbox" label="display-tthc-search-form" value="<%= displayTTHCSearchForm %>"/>
				
			<aui:input id="displayTTHCRelatedEntries" name="displayTTHCRelatedEntries" type="checkbox" value="<%= displayTTHCRelatedEntries %>"/>
			
			<div id="tthc_related_entries_advanced_settings" class="tthc-advanced-settings-container">
				<aui:select name="relatedVBPQFilter" label="related-tthc-filter">
					<aui:option label="by-tthc-category" value="tthcCategory" selected='<%=Validator.equals(relatedVBPQFilter, "tthcCategory") %>'/>
					<aui:option label="by-tthc-department" value="tthcDepartment" selected='<%=Validator.equals(relatedVBPQFilter, "tthcDepartment") %>'/>
					<aui:option label="by-tthc-level" value="tthcLevel" selected='<%=Validator.equals(relatedVBPQFilter, "tthcLevel") %>'/>
				</aui:select>
				<br/>
				<aui:select name="numbersOfRelatedEntries" label="numbers-of-tthc-related-entries-display">
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
		
		var displayStyleSelector = A.one('#<portlet:namespace/>displayStyle');

		var vbpqSearchFormStyle = 'tthc-search-form';
		
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
		
		var tthcScopeSelector = A.one('#_86_tthcScope');
		
		if(tthcScopeSelector){
			
			tthcScopeSelector.on('change',function(){
				
				var scopeSelectorValue = this.get('value');
				
				var departmentScopeValue = 'tthcDepartment';
				var categoryScopeValue = 'tthcCategory';
				var tthcLevelScopeValue = 'tthcLevel';
				
				var departmentScopeSelector = A.one('#tthc-department-scope-selector');
				var categoryScopeSelector = A.one('#tthc-category-scope-selector');
				var tthcLevelScopeSelector = A.one('#tthc-level-scope-selector');
				
				if(scopeSelectorValue == departmentScopeValue){
					
					departmentScopeSelector.show();
					categoryScopeSelector.hide();
					tthcLevelScopeSelector.hide();
					
				}else if(scopeSelectorValue == categoryScopeValue){
					
					departmentScopeSelector.hide();
					categoryScopeSelector.show();
					tthcLevelScopeSelector.hide();
					
				}else if(scopeSelectorValue == tthcLevelScopeValue){
					
					departmentScopeSelector.hide();
					categoryScopeSelector.hide();
					tthcLevelScopeSelector.show();
					
				}else{
					departmentScopeSelector.hide();
					categoryScopeSelector.hide();
					tthcLevelScopeSelector.hide();
				}
			});
		}
		
		Liferay.Util.toggleBoxes('<portlet:namespace/>displayTTHCRelatedEntriesCheckbox','tthc_related_entries_advanced_settings');
	});
</script>
		