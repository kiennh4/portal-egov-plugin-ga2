<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMapType"%>
<%@page import="java.util.List"%>
<%@page import="com.portal_egov.portlet.citymaps.search.CityMapSearch"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<%
	CityMap defaultMapDisplay = null;
	
	//Id cua ban do duoc chon de hien thi mac dinh
	long selectedMapId = ParamUtil.getLong(request, "selectedMapId",defaultCityMapDisplayId);

	//defaultCityMapDisplayId la Id cua ban do hien thi mac dinh luu trong cau hinh portlet(xem trong file init.jsp)
	
	if(selectedMapId > 0){
		
		defaultMapDisplay = CityMapLocalServiceUtil.getCityMap(selectedMapId);
	}
%>

<liferay-portlet:actionURL portletConfiguration="true" var="cityMapConfigurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" varImpl="cityMapConfigurationRenderImplURL"/>

<liferay-portlet:renderURL portletConfiguration="true" var="cityMapConfigurationRenderURL"/>

<aui:form name="city_map_config_form" method="post" action="<%=cityMapConfigurationActionURL %>">

	<div class="portlet-msg-info">
		<span class="displaying-help-message-holder <%= defaultMapDisplay == null ? StringPool.BLANK : "aui-helper-hidden" %>">
			<liferay-ui:message key="please-select-a-default-display-map-from-the-list-below-and-click-save-button" />
		</span>

		<span class="displaying-article-id-holder <%= defaultMapDisplay == null ? "aui-helper-hidden" : StringPool.BLANK %>">
			<liferay-ui:message key="default-display-map" />: 
			<span class="displaying-article-id"><%= defaultMapDisplay != null ? defaultMapDisplay.getMapName() : StringPool.BLANK %></span>
		</span>
	</div>
		
	<liferay-ui:search-container
		searchContainer="<%= new CityMapSearch(renderRequest,cityMapConfigurationRenderImplURL) %>"
		iteratorURL="<%=cityMapConfigurationRenderImplURL %>"
	>
	<%
		List<CityMap> searchResultList = CityMapLocalServiceUtil.findByKeyword(groupId, 0, StringPool.BLANK,0, -1, searchContainer.getOrderByComparator());
	%>
		<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(searchResultList, searchContainer.getStart(), searchContainer.getEnd()) %>" 
			total="<%=searchResultList.size() %>"
		/>
		
		<liferay-ui:search-container-row className="CityMap" keyProperty="mapId" modelVar="cityMap" escapedModel="<%=true %>">
			
			<%
				String mapTypeName = "";
				
				if(cityMap.getMapTypeId() > 0){
					
					CityMapType mapType = CityMapTypeLocalServiceUtil.getCityMapType(cityMap.getMapTypeId());
					
					if(mapType != null){
						
						mapTypeName = mapType.getTypeName();
					}
				}
			%>
			
			<liferay-portlet:renderURL portletConfiguration="true" var="selectCityMapURL" >
				<liferay-portlet:param name="selectedMapId" value="<%=String.valueOf(cityMap.getMapId()) %>"/>
			</liferay-portlet:renderURL>
											
			<liferay-ui:search-container-column-text 
				name="map-name" 
				orderable="<%=true %>"  
				value="<%=cityMap.getMapName()%>" 
				href="<%=selectCityMapURL %>"
			/>
															
			<liferay-ui:search-container-column-text 
				name="map-type" 
				orderable="<%=true %>"  
				value="<%=mapTypeName%>" 
				href="<%=selectCityMapURL %>"
			/>
											
			<liferay-ui:search-container-column-text 
				name="create-date" 
				value="<%=dateTimeFormat.format(cityMap.getCreateDate())%>"
				orderable="<%=true %>"
				orderableProperty="create-date"
				href="<%=selectCityMapURL %>"
			/>
			
			<liferay-ui:search-container-column-text 
				name="last-modified-date" 
				value="<%=dateTimeFormat.format(cityMap.getModifiedDate())%>"
				orderable="<%=true %>"
				orderableProperty="modified-date"
				href="<%=selectCityMapURL %>"
			/>
			
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
	<aui:input  type="hidden"  name="defaultCityMapDisplayId" value="<%=selectedMapId %>"/>
	<aui:button type="submit" value="save"/>
</aui:form>