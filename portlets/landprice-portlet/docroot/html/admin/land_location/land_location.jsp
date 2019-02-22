<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandLocation"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.portal_egov.portlet.landprice.permission.LandLocationPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	int landLocationIndex = 0;

	String landLocationSearchKeyword = ParamUtil.getString(request, "landLocationSearchKeyword");

	List<LandLocation> landLocationList = LandLocationLocalServiceUtil.findByKeyword(groupId, 0L, landLocationSearchKeyword, -1, -1, null);
%>

<div class="landprice-admin">
	
	<liferay-portlet:renderURL var="landLocationAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="LandLocation"/>
	</liferay-portlet:renderURL>
		
	<liferay-portlet:renderURL var="landLocationUpdateFormURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/land_location/land_location_update_form.jsp"/>
	</liferay-portlet:renderURL>
		
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="permission-btn-row" align="left">
				
				<c:if test="<%=LandLocationPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">
					<aui:button value="add-new" href="<%=landLocationUpdateFormURL %>"/>
				</c:if>
				
				<c:if test="<%=LandLocationPermission.contains(permissionChecker, groupId, ActionKeys.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=LandLocation.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
			
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>	
						
			<div class="landprice-search-form" align="right">
				<aui:form name="fm" method="post" action="<%=landLocationAdminURL %>">
				
					<input type="text" id="<portlet:namespace/>landLocationSearchKeyword" size="40" 
							name="landLocationSearchKeyword" value='<%= landLocationSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					<aui:button type="button" value="show-all" href="<%=landLocationAdminURL %>"/>
				</aui:form>	
			</div>		
		</div>
	</div>
	
	<div class="landprice-list">
	
		<liferay-portlet:renderURL varImpl="landLocationAdminImplURL">
			<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
			<liferay-portlet:param name="tabs1" value="LandLocation"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:search-container iteratorURL="<%=landLocationAdminImplURL %>">
			
			<liferay-ui:search-container-results 
				results="<%=ListUtil.subList(landLocationList, searchContainer.getStart(), searchContainer.getEnd()) %>" 
				total="<%=landLocationList.size() %>"/>
			
			<liferay-ui:search-container-row className="LandLocation" keyProperty="locationId" modelVar="landLocation" escapedModel="<%=true %>">
				<%
				
				landLocationIndex ++;
				
				String parentLocationName = "";
				
				if(landLocation.getParentLocationId() > 0){
					
					LandLocation parentLocation = LandLocationLocalServiceUtil.getLandLocation(landLocation.getParentLocationId());
					
					if(parentLocation != null){
						
						parentLocationName = parentLocation.getLocationName();
					}
				}
				
				%>
						
				<liferay-portlet:renderURL var="updateLocationURL">
					<liferay-portlet:param name="jspPage" value="/html/admin/land_location/land_location_update_form.jsp"/>
					<liferay-portlet:param name="locationId" value="<%=String.valueOf(landLocation.getLocationId()) %>"/>
				</liferay-portlet:renderURL>
		
				<liferay-ui:search-container-column-text 
					name="#" value="<%=String.valueOf(landLocationIndex)%>" 
					title="view"
				/>
								
				<liferay-ui:search-container-column-text 
					name="title" 
					value="<%=StringUtil.shorten(landLocation.getLocationName(), 80)%>" 
					href="<%=updateLocationURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="parent-location" 
					value="<%=parentLocationName%>" 
					href="<%=updateLocationURL %>"
					title="view"
				/>
												
				<liferay-ui:search-container-column-text 
					name="create-date" 
					value="<%=dateFormat.format(landLocation.getCreateDate())%>"
				/>
																
				<liferay-ui:search-container-column-text 
					name="modified-date" 
					value="<%=dateFormat.format(landLocation.getModifiedDate())%>"
				/>
																				
				<liferay-ui:search-container-column-text 
					name="modified-user" 
					value="<%=landLocation.getUserName()%>"
				/>
												
				<liferay-ui:search-container-column-text name="edit"  >
					<c:if test="<%=LandLocationPermission.contains(permissionChecker, groupId, ActionKeys.UPDATE)%>">		
						<liferay-ui:icon image="edit" message="edit" url="<%= updateLocationURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
								
				<liferay-ui:search-container-column-text name="delete" >
					<c:if test="<%=LandLocationPermission.contains(permissionChecker, groupId, ActionKeys.DELETE)%>">		
																		
						<liferay-portlet:actionURL  name="deleteLandLocation" var="deleteLandLocationActionURL">
							<liferay-portlet:param name="locationId" value="<%=String.valueOf(landLocation.getLocationId()) %>"/>
							<liferay-portlet:param name="redirectURL" value="<%=landLocationAdminURL%>"/>
						</liferay-portlet:actionURL>
						
						<liferay-ui:icon-delete url="<%= deleteLandLocationActionURL %>" />
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
