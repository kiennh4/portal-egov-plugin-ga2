<%@page import="com.portal_egov.portlet.citymaps.util.CityMapUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	CityMap cityMap = null;
	
	String cityMapName = portletDisplay.getTitle();
	
	String cityMapImagePath = "";
	
	//defaultCityMapDisplayId la Id cua ban do duoc chon de hien thi mac dinh trong cau hinh
	
	//Id cua ban do duoc chon tu menu ben trai
	long cityMapId = ParamUtil.getLong(request, "cityMapId");
	
	if(cityMapId <= 0 && defaultCityMapDisplayId > 0){//Truong hop da chon ban do hien thi mac dinh trong trang cau hinh
		
		//Gan Id hien thi ban do = Id cua ban do duoc chon de hien thi mac dinh
		cityMapId = defaultCityMapDisplayId;
	}
	
	if(cityMapId > 0){
		
		cityMap = CityMapLocalServiceUtil.getCityMap(cityMapId);
		
		if(cityMap != null){
			
			cityMapName = cityMap.getMapName();
			
			if(cityMap.getMapImageId() > 0){
				cityMapImagePath = CityMapUtil.getMapImagePath(request, cityMap.getMapImageId());
			}
		}
	}
	
	//Set Portlet Title = cityMapName
	PortletPreferences portletPreference = 	PortletPreferencesFactoryUtil.getLayoutPortletSetup(themeDisplay.getLayout(), PortalUtil.getPortletId(request));			
	
	portletPreference.setValue("portlet-setup-use-custom-title", String.valueOf(true));
	portletPreference.store();
	
	renderResponse.setTitle(cityMapName);
	
%>
	<c:choose>
		<c:when test="<%= cityMap != null %>">
			<liferay-portlet:renderURL var="viewMapImageFullSizeURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
				<liferay-portlet:param name="jspPage" value="/html/view/view_map_image.jsp"/>
				<liferay-portlet:param name="cityMapName" value="<%=cityMapName %>"/>
				<liferay-portlet:param name="cityMapImagePath" value="<%=cityMapImagePath %>"/>
			</liferay-portlet:renderURL>
			
			<div class="citi-map-preview" align="center">
				<div class="map-title">
					<h3><%=cityMap.getMapName() %></h3>
				</div>
				<div class="map-desc">
					<%=cityMap.getMapDesc() %>
				</div>
				<div class="city-map-image">
					<img alt="" src="<%=cityMapImagePath%>">
					<div class="view-map-image-url">
						<a target="_blank" href="<%=viewMapImageFullSizeURL%>">
							<liferay-ui:message key="this-map-image-was-resize-click-here-to-view-full-size-image"/>
						</a>
					</div>
				</div>
				<div class="map-sumary">
					<%=cityMap.getMapSumary() %>
				</div>
				
			</div>
		</c:when>
		<c:otherwise>
		<%
			renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

			<div class="portlet-configuration portlet-msg-info">
				<aui:a href="<%= portletDisplay.getURLConfiguration() %>" 
					label="please-configure-this-portlet-to-select-default-display-map" onClick="<%= portletDisplay.getURLConfigurationJS() %>" />
			</div>
		</c:otherwise>
	</c:choose>
	