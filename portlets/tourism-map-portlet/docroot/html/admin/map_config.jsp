<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	int[] defaultZoomLevelValues = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
%>

<liferay-portlet:renderURL var="mapAdminHomePageURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
</liferay-portlet:renderURL>
		
<liferay-portlet:actionURL name="updateMapConfig" var = "updateMapConfigActionURL">
	<liferay-portlet:param name="redirectURL" value="<%=mapAdminHomePageURL %>"/>
</liferay-portlet:actionURL>

<div class="tourism_map_admin">
	<div class="map_config_form">
		<aui:form name="map_config_form" method="post" action="<%=updateMapConfigActionURL %>">
			
			<aui:input name="mapAPIKey" label="map-api-key" value="<%=mapAPIKey %>" helpMessage="map-api-key-help-message">
				<aui:validator name="required" />
			</aui:input>
			
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
			
			<aui:input name="mapCenterLatitude"  value="<%=mapCenterLatitude %>" helpMessage="map-center-latitude-help-message">
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input name="mapCenterLongitude" value="<%=mapCenterLongitude  %>" helpMessage="map-center-longitude-help-message">
				<aui:validator name="required" />
			</aui:input>
			
			<aui:button type="submit" value="save"/>
			
			<aui:button type="button" name="closeDialogBtn" value="close"/>	
			
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel', function(A) {
		
		
		var mapAPIKeyInput = A.one('#<portlet:namespace/>mapAPIKey');
		
		if(mapAPIKeyInput){
			mapAPIKeyInput.focus();
		}
		
		var closeDialogBtn = A.one('#<portlet:namespace/>closeDialogBtn');
		
		if(closeDialogBtn){
			
			closeDialogBtn.on('click',function(){
				
				A.DialogManager.hideAll();
			});
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />map_config_form,
	
	        rules: {
	            <portlet:namespace />mapAPIKey: {
	                required: true,
	                rangeLength: ['3','150']
	            },
	            <portlet:namespace />mapCenterLatitude: {
	                required: true,
	                rangeLength: ['3','150']
	            },
	            <portlet:namespace />mapCenterLongitude: {
	                required: true,
	                rangeLength: ['3','150']
	            }
	        }
	    });
	});	
</script>
