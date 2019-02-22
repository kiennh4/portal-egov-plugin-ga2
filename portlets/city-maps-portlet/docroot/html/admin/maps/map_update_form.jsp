<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMapType"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	//Id cua ban do
	long mapId = ParamUtil.getLong(request, "mapId");

	//Id cua chuyen muc lay tu URL
	long mapTypeId = ParamUtil.getLong(request, "mapTypeId",0L);
	
	String mapImagePath = "";
	
	//Ban do
	CityMap cityMap = null;
		
	if(mapId > 0L){//truong hop update loai ban do
		
		cityMap = CityMapLocalServiceUtil.getCityMap(mapId);
	
		if(cityMap != null){
			mapTypeId = cityMap.getMapTypeId();
			
			long mapImageId = cityMap.getMapImageId();
			
			if(mapImageId > 0){
				mapImagePath = themeDisplay.getPathImage() + "/logo?img_id=" + mapImageId + "&t" + WebServerServletTokenUtil.getToken(mapImageId);
			}
		}
	}
	
	//Danh sach cac loai ban do
	List<CityMapType> mapTypeList = CityMapTypeLocalServiceUtil.findByGroup(groupId);
%>

<div class="citymap_admin">
	<liferay-portlet:renderURL var="redirectURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
		<liferay-portlet:param name="jspPage" value="/html/admin/redirect.jsp"/>
	</liferay-portlet:renderURL>
	
	<liferay-portlet:actionURL name="updateCityMap" var="updateCityMapActionURL">
		<liferay-portlet:param name="mapId" value="<%=String.valueOf(mapId) %>"/>
		<liferay-portlet:param name="redirectURL" value="<%=redirectURL %>"/>
	</liferay-portlet:actionURL>
	
	<div class="city_map_admin_form">
		<aui:form name="citi_map_update_form" method="post" action="<%=updateCityMapActionURL %>" enctype="multipart/form-data">
			<aui:select name="mapTypeId" label="select-map-type">
				<%
				for(CityMapType mapType : mapTypeList){
					long typeId = mapType.getTypeId();
					String typeName = mapType.getTypeName();
				%>
				<aui:option label="<%=typeName %>" value="<%=typeId %>" selected="<%= (typeId == mapTypeId) %>"/>
				<%
				}
				%>
			</aui:select>
		
			<aui:input type="textarea" name="mapName" value='<%=(cityMap != null) ? cityMap.getMapName() : "" %>'>
				<aui:validator name="required" />
			</aui:input>
					
			<c:if test='<%=Validator.isNotNull(mapImagePath) %>'>
				<liferay-ui:message key="map-image"/>
				<img alt="" src="<%=mapImagePath%>" width="310" style="border: 1px solid #E4E4E4;">
			</c:if>
			
			<aui:input type="file" name="mapImageFile" label="choose-map-image-file"/>
			
			<aui:input type="hidden" name="mapImageId" value='<%=(cityMap != null) ? cityMap.getMapImageId() : "0" %>'/>
			
			<aui:button type="submit" value="save"/>
			<aui:button name="closeUpdateFormBtn" value="cancel"/>
		</aui:form>
	</div>
</div>

<script type="text/javascript">
	
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
		
		var mapNameInput = A.one('#<portlet:namespace/>mapName');
		
		if(mapNameInput){
			mapNameInput.focus();
		}
		
		var closeUpdateFormBtn = A.one('#<portlet:namespace/>closeUpdateFormBtn');
		
		if(closeUpdateFormBtn){
			
			closeUpdateFormBtn.on('click',function(){
				
				Liferay.Util.getWindow().close();
			});
		}
		
		window.validator = new A.FormValidator({
	
	        boundingBox: document.<portlet:namespace />citi_map_update_form,
	
	        rules: {
	            <portlet:namespace />mapName: {
	                required: true,
	                rangeLength: ['3','300']
	            }
	        }
	    });
	});

</script>
