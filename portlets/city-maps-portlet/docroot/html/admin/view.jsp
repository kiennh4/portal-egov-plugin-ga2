<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>
<%@page import="com.portal_egov.portlet.citymaps.permission.CityMapPermission"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.permission.CityMapTypePermission"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	String mapSearchKeyword = ParamUtil.getString(request, "mapSearchKeyword");

	long mapId = ParamUtil.getLong(request, "mapId");
%>

<div class="citymap_admin">

	<liferay-portlet:renderURL var="cityMapAdminPageURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	</liferay-portlet:renderURL>

	<div class="lfr-header-row">
		<div class="lfr-header-row-content">
			<div class="admin_button" align="left">
				<c:if test="<%=CityMapPermission.contains(permissionChecker, groupId, CityMapPermission.PERMISSIONS)%>">
					<liferay-security:permissionsURL
						modelResource="<%=CityMap.class.getName() %>"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(groupId) %>"
						var="permissionsURL"
					/>
					
					<aui:button name="cityMapPermissions" href="<%= permissionsURL %>" value="permissions" />
				</c:if>
			</div>			
			
			<div class="citymap_search_form" align="right">
				<aui:form name="citymap_search_form" method="post" action="<%=cityMapAdminPageURL %>">
				
					<aui:input type="text" label="" name="mapSearchKeyword" placeholder="search-city-map" value='<%= mapSearchKeyword%>'/>
					
					<aui:button type="submit" value="search"/>
					
					<aui:button type="button" value="show-all" href="<%=cityMapAdminPageURL %>"/>
				</aui:form>	
			</div>
		</div>
	</div>
	
	<aui:layout cssClass="citymap_admin_content_wrapper">
		<aui:column columnWidth="30" cssClass="map_type_list_container">
			<div class="results-header">
				<liferay-ui:message key="map-type-list" />
			</div>
			
			<div class="results-content">
				<liferay-util:include page="/html/admin/map_types/map_type_list.jsp" servletContext="<%=getServletContext() %>"/>
			</div>
		</aui:column>
		
		<aui:column columnWidth="70" cssClass="map_list_container">
			<div class="results-header">
				<liferay-ui:message key="map-list" />
			</div>
			<div class="results-content">
				<liferay-util:include page="/html/admin/maps/map_list.jsp" servletContext="<%=getServletContext() %>"/>
			</div>
		</aui:column>
	</aui:layout>
	
	<c:if test="<%= mapId > 0 %>">
		<liferay-util:include page="/html/admin/maps/map_preview.jsp" servletContext="<%=getServletContext() %>"/>
	</c:if>
</div>

<script type="text/javascript">
	AUI().ready('aui-base',function(A){
		
		var cityMapSearchInput = A.one('#<portlet:namespace/>mapSearchKeyword');
		
		if(cityMapSearchInput){
			
			cityMapSearchInput.focus();
		}
	});
</script>