
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	int[] defaultZoomLevelValues = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
%>

<liferay-portlet:actionURL portletConfiguration="true" var="tourismMapConfigurationActionURL" />

<div class="tourism_map_config_form">
	<aui:form name="tourism_map_config_form" method="post" action="<%=tourismMapConfigurationActionURL %>">
					
		<aui:input name="mapAPIKey" label="map-api-key" value="<%=mapAPIKey %>" helpMessage="map-api-key-help-message"/>
		
		<aui:select name="defaultMapType" helpMessage="map-type-selector-help-message">
			<aui:option label="HYBRID" value="<%=hybridMapTypeId %>" selected="<%=Validator.equals(defaultMapType, hybridMapTypeId) %>"/>
			<aui:option label="TERRAIN" value="<%=terrainMapTypeId %>" selected="<%=Validator.equals(defaultMapType, terrainMapTypeId) %>"/>
			<aui:option label="SATELLITE" value="<%=satelLiteMapTypeId %>" selected="<%=Validator.equals(defaultMapType, satelLiteMapTypeId) %>"/>
			<aui:option label="ROADMAP" value="<%=roadmapMapTypeId %>" selected="<%=Validator.equals(defaultMapType, roadmapMapTypeId) %>"/>
		</aui:select>
		
		<aui:select name="defaultZoomLevel" helpMessage="zoom-level-selector-help-message">
			<%
			for(int i = 0; i< defaultZoomLevelValues.length; i ++){
				
				int defaultZoomLevelValue = defaultZoomLevelValues[i];
			%>
				<aui:option label="<%=defaultZoomLevelValue %>" value="<%=defaultZoomLevelValue %>"
							selected="<%=defaultZoomLevelValue == defaultZoomLevel%>"
				/>
			<%
			}
			%>
		</aui:select>
		
		<aui:input name="mapCenterLatitude"  value="<%=mapCenterLatitude %>" helpMessage="map-center-latitude-help-message"/>
		
		<aui:input name="mapCenterLongitude" value="<%=mapCenterLongitude  %>" helpMessage="map-center-longitude-help-message"/>
		
		<aui:button type="submit" value="save"/>
	</aui:form>
</div>

