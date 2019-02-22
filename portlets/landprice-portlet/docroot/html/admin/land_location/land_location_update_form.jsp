<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.portal_egov.portlet.landprice.service.LandLocationLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.landprice.model.LandLocation"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long parentLocationId = 0L;

	long locationId = ParamUtil.getLong(request, "locationId");

	LandLocation landLocation = null;
	
	if(locationId > 0){
		
		landLocation = LandLocationLocalServiceUtil.getLandLocation(locationId);
		
		if(landLocation != null){
			
			parentLocationId = landLocation.getParentLocationId();
		}
	}
	
	List<LandLocation> rootLocationList = LandLocationLocalServiceUtil.findByParentLocation(0);
%>


<div class="landprice-update-form">

	<liferay-portlet:renderURL var="landLocationAdminURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="tabs1" value="LandLocation"/>
	</liferay-portlet:renderURL>

	<liferay-ui:header
		backURL="<%= landLocationAdminURL %>"
		title='<%= (landLocation != null) ? StringUtil.shorten(landLocation.getLocationName(),80) : "add-new-land-location" %>'
	/>
		
	<liferay-portlet:actionURL name="updateLandLocation" var="updateLandLocationActionURL" >
		<liferay-portlet:param name="locationId" value="<%=String.valueOf(locationId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=landLocationAdminURL %>"/>
	</liferay-portlet:actionURL>
	
	<aui:form name="fm" method="post" action="<%= updateLandLocationActionURL %>">
		
		<aui:model-context bean="<%= landLocation %>" model="<%= LandLocation.class %>" />
		
		<aui:select name="parentLocationId" label="parent-location">
			<option value="0" <%=parentLocationId == 0L ? "selected" : ""%>><liferay-ui:message key="none"/></option>
			
			<%
			for(LandLocation rootLocation : rootLocationList){
			%>
			<option value="<%=rootLocation.getLocationId() %>" <%=parentLocationId == rootLocation.getLocationId() ? "selected" : "" %>>
				<%=rootLocation.getLocationName() %>
			</option>
			<%
			buildLandLocationTree(rootLocation.getLocationId() , 1, out, parentLocationId);
			}
			%>
		</aui:select>
		
		<aui:input type="text" name="locationName" >
			<aui:validator name="required"/>
		</aui:input>
		
		<aui:input type="textarea" name="locationInfo" />
				
		<aui:button-row>
			<aui:button type="submit" value='save'/>
	
			<aui:button href="<%= landLocationAdminURL %>" type="cancel"/>
		</aui:button-row>
	</aui:form>
</div>