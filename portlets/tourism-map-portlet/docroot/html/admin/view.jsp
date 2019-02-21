<%@page import="com.portal_egov.portlet.tourism_map.model.TourismMapMarker"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.tourism_map.permission.TourismMapMarkerPermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<script type="text/javascript" src="/tourism-map-portlet/js/service.js"></script>

<script type="text/javascript" src="<%=mapAPISourcePath%>"></script>

<liferay-portlet:renderURL var="groupUpdateFormRenderURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<liferay-portlet:param name="jspPage" value="/html/admin/location_group_update_form.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="markerUpdateFormRenderURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<liferay-portlet:param name="jspPage" value="/html/admin/location_marker_update_form.jsp"/>
</liferay-portlet:renderURL>

<div class="tourism_map_admin">
	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="admin_button" align="left" style="float: left;display: inline-block;">
				<c:if test="<%=TourismMapMarkerPermission.contains(permissionChecker, groupId, TourismMapMarkerPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=TourismMapMarker.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
					
					<aui:button href="<%= permissionsURL %>" value="permissions" />
				</c:if>
									
				<aui:button type="button" name="mapConfigBtn" value="map-config"/>
			</div>
			
			<div style="float: right;display: inline-block;">
				<aui:button type="button" name="addGroupBtn" value="add-group" />
				<aui:button type="button" name="addMarkerBtn" value="add-location-marker"/>
			</div>
		</div>
	</div>
	
	<div class="tourism_map_wrapper_panel">
		<aui:layout>
			<aui:column columnWidth="70" cssClass="map_image">
				<div id="map_container" class="map_container"></div>
			</aui:column>
			<aui:column columnWidth="30" cssClass="map_menu">
				<div id="menu_container" class="menu_container">
					<span class="menu-title"><liferay-ui:message key="marker-group-menu" /></span>
				</div>
				<div id="marker_list_container" class="marker_list_container"></div>
			</aui:column>
		</aui:layout>
	</div>
	
</div>

<aui:script use="portal-egov-tourism-map-admin-portlet">
	
	new Liferay.Portlet.TourismMapAdmin(
		{
			scopeGroupId: <%= groupId %>,
			defaultMapType: <%=defaultMapType %>,
			defaultZoomLevel: <%= defaultZoomLevel %>,
			mapCenterLatitude: <%= mapCenterLatitude %>,
			mapCenterLongitude: <%= mapCenterLongitude %>
		}
	);
</aui:script>