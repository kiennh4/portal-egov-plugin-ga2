
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/view/init.jsp"%>

<script type="text/javascript" src="/tourism-map-portlet/js/service.js"></script>

<script type="text/javascript" src="<%=mapAPISourcePath%>"></script>

	
<div class="tourism_map_wrapper_panel">
	<aui:layout>
		<aui:column columnWidth="70" cssClass="map_image">
			<div id="map_container" class="map_container"></div>
		</aui:column>
		<aui:column columnWidth="30" cssClass="map_menu">
			<div id="menu_container" class="menu_container"></div>
			<div id="marker_list_container" class="marker_list_container"></div>
		</aui:column>
	</aui:layout>
</div>


<aui:script use="portal-egov-tourism-map-portlet">
	
	new Liferay.Portlet.TourismMap(
		{
			scopeGroupId: <%= groupId %>,
			defaultMapType: <%=defaultMapType %>,
			defaultZoomLevel: <%= defaultZoomLevel %>,
			mapCenterLatitude: <%= mapCenterLatitude %>,
			mapCenterLongitude: <%= mapCenterLongitude %>
		}
	);
</aui:script>