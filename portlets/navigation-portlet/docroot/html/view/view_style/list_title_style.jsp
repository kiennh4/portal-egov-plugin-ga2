<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.portal_egov.portlet.navigation.util.CategoryPropertyUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.portal_egov.portlet.navigation.util.TagPropertyUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.asset.model.AssetTag"%>
<%@page import="com.portal_egov.portlet.navigation.util.NavigationUtil"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Ten hien thi
	String displayName = "";

	//URL
	String customURL = "";
	
	String viewContentURL = "";
	
	String target = "_self";
	
	long[] selectedEntryIds = new long[0];
	
	long plid = themeDisplay.getLayout().getPlid();
				
	if(Validator.equals(selectedName, "assetTags")){
		
		selectedEntryIds = selectedTagIds;
	}else{
		
		selectedEntryIds = selectedCategoryIds;
	}
	
	selectedEntryIds = NavigationUtil.validateSelectedEntryIds(selectedEntryIds, selectedName);
%>
<div id="navigation_title">
	<span><%=navigationTitle %></span>
</div>

<div id="navigation_content">
	<div class="list_title_style">
	<ul>
	<%
		for(int i = 0; i < selectedEntryIds.length; i++)
		{
			long entryId = selectedEntryIds[i];
			
			if(Validator.equals(selectedName, "assetTags")){
				
				AssetTag assetTag = AssetTagLocalServiceUtil.getAssetTag(entryId);
				
				displayName = TagPropertyUtil.getTagPropertyValue(entryId, displayNamePropertyKey, assetTag.getName());
								
				customURL = TagPropertyUtil.getTagPropertyValue(entryId, customURLPropertyKey, StringPool.BLANK);
																				
				if(Validator.equals(customURL, StringPool.BLANK)){
					
					// "101" la id cua portlet AssetPublisher
					PortletURL portletURL = PortletURLFactoryUtil.create(request, "101", plid, PortletRequest.RENDER_PHASE);
					portletURL.setParameter("tag", assetTag.getName());
					viewContentURL = portletURL.toString();
										
				}else{
					
					viewContentURL = customURL;
					target = "_blank";
				}
												
			}else{
				
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(entryId);
				
				displayName = CategoryPropertyUtil.getCategoryPropertyValue(entryId, displayNamePropertyKey, assetCategory.getName());
				
				customURL = CategoryPropertyUtil.getCategoryPropertyValue(entryId, customURLPropertyKey, StringPool.BLANK);
				
				if(Validator.equals(customURL, StringPool.BLANK)){
					
					PortletURL portletURL = PortletURLFactoryUtil.create(request, "101", plid, PortletRequest.RENDER_PHASE);
					portletURL.setParameter("categoryId", String.valueOf(assetCategory.getCategoryId()));
					viewContentURL = portletURL.toString();					
					
				}else{
					viewContentURL = customURL;
					target = "_blank";
				}
			}	

	%>	
			
			<li>	  		  
	  		  <span class="entry_name">
	  		    <a target="<%=target%>" href="<%= viewContentURL%>"><%=displayName%></a>
	  		  </span>
	  		  
	  		  <span style="display: block; clear: both;"></span>	
		    </li>
	<%
		}
	%>
	</ul>
	</div>
</div>