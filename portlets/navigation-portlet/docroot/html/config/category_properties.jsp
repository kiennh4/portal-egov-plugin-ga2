<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.portal_egov.portlet.navigation.util.CategoryPropertyUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String categoryPropertiesPanelState = ParamUtil.getString(request, "categoryPropertiesPanelState","closed");
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>

<liferay-ui:panel-container>	
	
	<%				
		for(int catgoryIndex = 0;catgoryIndex < selectedCategoryIds.length;catgoryIndex ++)
		{
			String propertiesFormName = "category-properties-form" + catgoryIndex;
			
			long categoryId = selectedCategoryIds[catgoryIndex];
			
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
						
			if(assetCategory != null)
			{	
				String displayName = CategoryPropertyUtil.getCategoryPropertyValue(categoryId, displayNamePropertyKey, assetCategory.getName());
								
				long iconImageId = Long.parseLong(CategoryPropertyUtil.getCategoryPropertyValue(categoryId, iconImageIdPropertyKey, "0"));
				
				String customURL = CategoryPropertyUtil.getCategoryPropertyValue(categoryId, customURLPropertyKey, StringPool.BLANK);
				
				String iconImagePath = "";
				
				if(iconImageId > 0){
					
					iconImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + iconImageId + "&t" + WebServerServletTokenUtil.getToken(iconImageId);
				}
	%>
									
				<form action="<%= configurationActionURL %>" enctype="multipart/form-data" method="post" name="<%=propertiesFormName%>">
					
					<liferay-ui:panel title='<%=assetCategory.getName()%>' extended="<%=true %>"  
									  collapsible='<%= true %>' defaultState="<%=categoryPropertiesPanelState %>">
	
						<br>
						
						<aui:layout>
							<aui:column columnWidth="15" >
								&nbsp;&nbsp;<liferay-ui:message key="display-name"/>&nbsp;&nbsp;
							</aui:column>
							
							<aui:column>
								<input name="displayName" type="text" value="<%=displayName%>" />
							</aui:column>					
						</aui:layout><br>
						
						<aui:layout>
							<aui:column columnWidth="15" >
								&nbsp;&nbsp;<liferay-ui:message key="tag-icon"/>&nbsp;&nbsp;
							</aui:column>
							
							<aui:column>
								<img  width="30px" height="30px" src="<%=iconImagePath %>" />
							</aui:column>					
						</aui:layout><br>
						
						<aui:layout>
							<aui:column columnWidth="15" >
								&nbsp;&nbsp;<liferay-ui:message key="upload-icon"/>&nbsp;&nbsp;
							</aui:column>
							
							<aui:column>
								<input type="file" name="iconImageFile" />
							</aui:column>					
						</aui:layout><br>
						
						<aui:layout>
							<aui:column columnWidth="15" >
								&nbsp;&nbsp;<liferay-ui:message key="custom-url"/>&nbsp;&nbsp;
							</aui:column>
							
							<aui:column>
								<input name="customURL" type="text" value="<%=customURL%>" />
							</aui:column>					
						</aui:layout><br>
																	
						<aui:layout>
						
							<input type="hidden" name="configCommand" value="updateEntryProperties" />
							<input type="hidden" name="className" value="<%=AssetCategory.class.getName() %>" />
							<input type="hidden" name="classId" value="<%=assetCategory.getCategoryId() %>" />
							<aui:input name="repositoryId" type="hidden" value="<%=repositoryId %>" />
							<input type="hidden" name="tabs1" value="EntriesSelection" />
							<input type="hidden" name="categoryPropertiesPanelState" value="open" />
																										
							<aui:column>
								<aui:button onClick="submitForm(document.<%=propertiesFormName %>);" type="submit" value="save-properties" />
							</aui:column>						
						</aui:layout>						
					</liferay-ui:panel>	
					<br>				
				</form>				
				
	<%
			} //End for(int catgoryIndex = 0;catgoryIndex < selectedCategoryIds.length;catgoryIndex ++)
		}//End if(assetCategory != null)
	%>
	
</liferay-ui:panel-container>