<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.navigation.util.TagPropertyUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	String tagPropertiesPanelState = ParamUtil.getString(request, "tagPropertiesPanelState","closed");
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>

<liferay-ui:panel-container>	

	<div class="entry_properties">	
	<%				
		for(int tagIndex = 0;tagIndex < selectedTagIds.length;tagIndex ++)
		{
			String propertiesFormName = "tags-properties-form" + tagIndex;
			
			long assetTagId = selectedTagIds[tagIndex];
			
			AssetTag assetTag = AssetTagLocalServiceUtil.getAssetTag(assetTagId);

			if(assetTag != null)
			{	

				String displayName = TagPropertyUtil.getTagPropertyValue(assetTagId, displayNamePropertyKey, assetTag.getName());
				
				long iconImageId = Long.parseLong(TagPropertyUtil.getTagPropertyValue(assetTagId, iconImageIdPropertyKey, "0"));
				
				String customURL = TagPropertyUtil.getTagPropertyValue(assetTagId, customURLPropertyKey, StringPool.BLANK);
				
				String iconImagePath = "";
				
				if(iconImageId > 0){
					
					iconImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + iconImageId + "&t" + WebServerServletTokenUtil.getToken(iconImageId);
				}
	%>
									
				<form action="<%= configurationActionURL %>" enctype="multipart/form-data" method="post" name="<%=propertiesFormName%>">
					
					<liferay-ui:panel title='<%=assetTag.getName()%>' extended="<%=true %>"  
									  collapsible='<%= true %>' defaultState="<%=tagPropertiesPanelState %>">
	
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
							<input type="hidden" name="className" value="<%=AssetTag.class.getName() %>" />
							<input type="hidden" name="classId" value="<%=assetTag.getTagId() %>" />
							<aui:input name="repositoryId" type="hidden" value="<%=repositoryId %>" />
							<input type="hidden" name="tabs1" value="EntriesSelection" />
							<input type="hidden" name="tagPropertiesPanelState" value="open" />
																										
							<aui:column>
								<aui:button onClick="submitForm(document.<%=propertiesFormName %>);" type="submit" value="save-properties" />
							</aui:column>						
						</aui:layout>						
					</liferay-ui:panel>	
					<br>				
				</form>				
	<%
			} //End for(int tagIndex = 0;tagIndex < selectedTagIds;tagIndex ++)
		}//End if(assetTag != null)
	%>
	</div>
</liferay-ui:panel-container>