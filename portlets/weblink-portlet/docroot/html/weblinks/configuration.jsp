<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.weblinks.util.WeblinkUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.service.WeblinkCategoryLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.weblinks.model.WeblinkCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/weblinks/init.jsp"%>


<%
	//Danh sach cac chuyen muc lien ket lay theo group
	List<WeblinkCategory> weblinkCategoryList = WeblinkCategoryLocalServiceUtil.findByGroup(groupId);

	int[] numbersOfWeblinksDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30,40,50};
%>

	<liferay-portlet:actionURL portletConfiguration="true" var="weblinkConfigURL">	
		<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
	</liferay-portlet:actionURL>

	<aui:form name="weblink_config_form" method="post" action="<%=weblinkConfigURL %>">
	
		<div class="weblink-config-container">
		
			<aui:select name="displayStyle" >
				<aui:option label="default" value="defaultDisplayStyle" selected='<%=Validator.equals(displayStyle, "defaultDisplayStyle") %>'/>
				<aui:option label="multi-tabs-style" value="multiTabsDisplayStyle" selected='<%=Validator.equals(displayStyle, multiTabsDisplayStyle) %>'/>
				<aui:option label="list-title-style" value="listTitleDisplayStyle" selected='<%=Validator.equals(displayStyle, listTitleDisplayStyle) %>'/>
			</aui:select>
			
			<div id="default_style_settings" >
				<aui:select name="defaultCategoryId" label="category">
					<aui:option value="0" label="all" selected="<%=defaultCategoryId == 0L %>"/>
					<%
					for(WeblinkCategory weblinkCategory : weblinkCategoryList){
					%>
					<aui:option value="<%=weblinkCategory.getCategoryId() %>" label="<%=weblinkCategory.getCategoryName() %>"
								selected="<%=weblinkCategory.getCategoryId() == defaultCategoryId %>"
					/>
					<%
					}
					%>
				</aui:select>
			</div>
			
			<div id="multi_tabs_style_settings" class="multi_tabs_style_settings">
				<table>
					<tr>
						<td><liferay-ui:message key="select-weblink-categories"/></td>
						<td>
							<%
							for(WeblinkCategory weblinkCategory : weblinkCategoryList){
								
								boolean selectedWeblink = WeblinkUtil.isSelectedCategory(selectedWeblinkTabIds, weblinkCategory.getCategoryId());
							%>
							 <input type="checkbox" name="selectedWeblinkTabId" 
						   			   value="<%=String.valueOf(weblinkCategory.getCategoryId())%>" <%=selectedWeblink ? "checked" : StringPool.BLANK%>
							/><b>&nbsp;<%=weblinkCategory.getCategoryName()%></b> <br/>
		
							<%
							}
							%>
						</td>
					</tr>
									
					<tr>
						<td><liferay-ui:message key="numbers-of-weblink-display-per-tab"/></td>
						<td>
							<aui:select name="numbersOfWeblinkPerTab" label="">
								<aui:option label="all" value="0"/>
								<%
								for(int i = 0; i< numbersOfWeblinksDisplayValues.length; i++){
									
									int numbersOfWeblinkDisplayPerTab = GetterUtil.getInteger(numbersOfWeblinksDisplayValues[i]);
								
								%>
								<aui:option label="<%=numbersOfWeblinkDisplayPerTab %>" value="<%=numbersOfWeblinkDisplayPerTab%>"
											selected="<%=numbersOfWeblinkDisplayPerTab == numbersOfWeblinkPerTab %>"
								/>
								<%
								}
							%>
							</aui:select>
						</td>
					</tr>
				</table>
			</div>
			
			<div id="list_title_style_settings" class="list_title_style_settings">
						
				<table>
					<tr>
						<td><liferay-ui:message key="select-weblink-category"/></td>
						<td>
							<aui:select name="selectedCategoryId" label="">
								<%
								for(WeblinkCategory weblinkCategory : weblinkCategoryList){
								%>
								<aui:option value="<%=weblinkCategory.getCategoryId() %>" label="<%=weblinkCategory.getCategoryName() %>"
											selected="<%=weblinkCategory.getCategoryId() == selectedCategoryId %>"
								/>
								<%
								}
								%>
							</aui:select>
						</td>
					</tr>
					<tr>
						<td><liferay-ui:message key="numbers-of-weblink-display"/></td>
						<td>
				
							<aui:select name="numbersOfWeblinkDisplayList" label="">
								<aui:option label="all" value="0"/>
								<%
								for(int i = 0; i< numbersOfWeblinksDisplayValues.length; i++){
									
									int numbersOfWeblinkDisplay = GetterUtil.getInteger(numbersOfWeblinksDisplayValues[i]);
								
								%>
								<aui:option label="<%=numbersOfWeblinkDisplay %>" value="<%=numbersOfWeblinkDisplay%>"
											selected="<%=numbersOfWeblinkDisplay == numbersOfWeblinkDisplayList %>"
								/>
								<%
								}
								%>
							</aui:select>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="aui-button-holder">
			<aui:button type="submit" value="save"/>
		</div>
	</aui:form>

<aui:script>
	Liferay.Util.toggleSelectBox('_86_displayStyle','defaultDisplayStyle','default_style_settings');
	
	Liferay.Util.toggleSelectBox('_86_displayStyle','multiTabsDisplayStyle','multi_tabs_style_settings');
	
	Liferay.Util.toggleSelectBox('_86_displayStyle','listTitleDisplayStyle','list_title_style_settings');
</aui:script>