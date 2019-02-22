<%@page import="com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMapType"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/map_types/init.jsp"%>

<%
	long selectedMapId = ParamUtil.getLong(request, "cityMapId");

	//Danh sach cac loai ban do
	List<CityMapType> cityMapTypeList = CityMapTypeLocalServiceUtil.findByGroup(groupId);
%>

<div class="city-map-types-list">
	<ul>
		<%
		for(CityMapType mapType : cityMapTypeList){
			
			long mapTypeId = mapType.getTypeId();
			String mapTypeName = mapType.getTypeName();
			
			//Danh sach ban do theo tung loai ban do
			List<CityMap> cityMapList = CityMapLocalServiceUtil.findByType(mapTypeId);
		%>
			<li>
				<div class="map-type-name" onclick="toggleMenu('<%=mapTypeId%>');">
					<a href="javascript:;"><%=mapTypeName %></a>
				</div>
				
				<div id="<%=mapTypeId %>" class="city-map-list aui-helper-hidden">
					<ul>
						<%
						for(CityMap cityMap : cityMapList){
							
							long cityMapId = cityMap.getMapId();
							
							String cityMapName = cityMap.getMapName();
						
						%>
							<liferay-portlet:renderURL var="viewMapInfoURL">
								<liferay-portlet:param name="jspPage" value="/html/map_types/view.jsp"/>
								<liferay-portlet:param name="cityMapId" value="<%=String.valueOf(cityMapId) %>"/>
							</liferay-portlet:renderURL>
							
							<li class='city-map-entry <%=(selectedMapId == cityMapId) ? "selected-map" : "" %>'>
								<div class="city-map-content-wrapper">
									<span class="city-map-name">
										<a href="<%=viewMapInfoURL%>"><%=cityMapName %></a>
									</span>
								</div>
							</li>
						<%
						}
						%>
					</ul>
				</div>
			</li>
		<%
		}
		%>
	</ul>
</div>

<aui:script>
	
	AUI().ready('aui-base', function(A) {
		
		var selectedMap = A.one('.selected-map');
		
		if(selectedMap){
			var selectedMapAncestor = selectedMap.ancestor('.city-map-list');
			
			if(selectedMapAncestor){
				selectedMapAncestor.show();
			}
		}
	});
	
	function toggleMenu(menuId){
		
		var A = AUI();
		
		A.all('.city-map-list').each(function(){
			this.hide();
		});
		
		var selectedMenu = A.one('#'+menuId);
		
		if(selectedMenu){
			selectedMenu.show();
		}
	}
</aui:script>
