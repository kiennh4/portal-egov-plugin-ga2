<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<%@include file="/html/admin/init.jsp"%>

<%
	long mapId = ParamUtil.getLong(request, "mapId");

	CityMap cityMap = null;
	
	String mapName = "";
	
	String mapImagePath = "";
	
	if(mapId > 0){
		
		cityMap = CityMapLocalServiceUtil.getCityMap(mapId);
		
		if(cityMap != null){
			
			long mapImageId = cityMap.getMapImageId();
			
			mapName = cityMap.getMapName();
			
			mapImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + mapImageId + "&t" + WebServerServletTokenUtil.getToken(mapImageId);
		}
	}
%>

	<c:if test="<%= cityMap != null %>">
	
		<liferay-portlet:renderURL var="viewMapImageFullSizeURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
			<liferay-portlet:param name="jspPage" value="/html/view/view_map_image.jsp"/>
			<liferay-portlet:param name="cityMapName" value="<%=mapName %>"/>
			<liferay-portlet:param name="cityMapImagePath" value="<%=mapImagePath %>"/>
		</liferay-portlet:renderURL>
		
		<div class="citi-map-preview" align="center">
			<div class="city-map-name">
				<span><%=mapName %></span>
			</div>
			<div class="city-map-image">
				<img alt="" src="<%=mapImagePath%>">
			</div>
									
			<div class="view-map-image-url">
				<a target="_blank" href="<%=viewMapImageFullSizeURL%>">
					<liferay-ui:message key="this-map-image-was-resize-click-here-to-view-full-size-image"/>
				</a>
			</div>
		</div>
		
		<div class="aui-button-holder">
			<aui:button name="openMapUpdateFormBtn" value="update"/>
			<aui:button name="closePreviewDialogBtn" value="close"/>
		</div>
	</c:if>


	<script type="text/javascript">
	
		AUI().ready('aui-base',function(A) {
			
			var openMapUpdateFormBtn = A.one('#<portlet:namespace/>openMapUpdateFormBtn');
					
			if(openMapUpdateFormBtn){
				
				openMapUpdateFormBtn.on('click',function(){
					Liferay.Util.getWindow().close();
					Liferay.Util.getOpener().showMapUpdateForm('<%=mapId %>','<%=StringUtil.shorten(mapName, 60)%>');
					
				});
			}
			
			var closePreviewDialogBtn = A.one('#<portlet:namespace/>closePreviewDialogBtn');
			
			if(closePreviewDialogBtn){
				
				closePreviewDialogBtn.on('click',function(){
					Liferay.Util.getWindow().close();
				});
			}
		});
	</script>