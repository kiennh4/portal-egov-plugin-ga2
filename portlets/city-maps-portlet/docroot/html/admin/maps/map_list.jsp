<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMap"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	long mapId = ParamUtil.getLong(request, "mapId");

	//Id cua loai ban do 
	long mapTypeId = ParamUtil.getLong(request, "mapTypeId",0L);
	
	//Tu khoa
	String mapSearchKeyword = ParamUtil.getString(request, "mapSearchKeyword");

	List<CityMap> mapList = mapList = CityMapLocalServiceUtil.findByKeyword(groupId, mapTypeId, mapSearchKeyword, 0, -1, null);
%>
	
<c:choose>
	<c:when test="<%=!mapList.isEmpty() %>">
	
		<div class="add-new-map-link">		
			<a href="javascript:;" onclick="showMapUpdateForm(0,'<%= UnicodeLanguageUtil.get(pageContext, "add-new-city-map") %>')">
				<liferay-ui:message key="add-new-map"/>
			</a>
		</div>
		
		<div class="citymap-list">
			<ul>
				<%
				for(CityMap cityMap : mapList){
					
					long cityMapId = cityMap.getMapId();
					String mapName = cityMap.getMapName();
					
					StringBundler mapPreviewBundle = new StringBundler();

					mapPreviewBundle.append("javascript:");
					mapPreviewBundle.append("showMapPreviewDialog");
					mapPreviewBundle.append("('");
					mapPreviewBundle.append(cityMapId);
					mapPreviewBundle.append("','");
					mapPreviewBundle.append(StringUtil.shorten(mapName, 60));
					mapPreviewBundle.append("')");

					String	mapPreviewURL = mapPreviewBundle.toString();
					
					StringBundler mapUpdateFormBundle = new StringBundler();

					mapUpdateFormBundle.append("javascript:");
					mapUpdateFormBundle.append("showMapUpdateForm");
					mapUpdateFormBundle.append("('");
					mapUpdateFormBundle.append(cityMapId);
					mapUpdateFormBundle.append("','");
					mapUpdateFormBundle.append(StringUtil.shorten(mapName, 60));
					mapUpdateFormBundle.append("')");

					String	mapUpdateFormURL = mapUpdateFormBundle.toString();
				%>
					<liferay-portlet:actionURL name="deleteCityMap" var="deleteCityMapActionURL">
						<liferay-portlet:param name="mapId" value="<%=String.valueOf(cityMapId) %>"/>
						<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
					</liferay-portlet:actionURL>

					<li class='city-map <%= (cityMapId == mapId ? "selected" : "") %>' >
						<div class="city-map-content-wrapper">
							<span class="city-map-name">
								<a  href="<%=mapPreviewURL%>"><%=mapName %></a>
							</span>
							
							<a href="<%=mapUpdateFormURL%>" class="edit-city-map-actions-trigger"></a>
							<a 	class="delete-city-map-actions-trigger"
								href="<%= deleteCityMapActionURL %>" 
								onclick="return confirm('<liferay-ui:message key="are-you-sure-want-to-delete-this-item?"/>')"
								title="delete"
							>
							</a>
						</div>
					</li>
				<%
				}
				%>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<a href="javascript:;" onclick="showMapUpdateForm(0,'add-new-city-map')"><liferay-ui:message key="citymap-list-is-empty-click-here-to-create-new-map"/></a>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">

	Liferay.provide(window,'showMapPreviewDialog',function(mapId,dialogTitle) {
			var A = AUI();
			
			A.DialogManager.hideAll();
								
			var mapPreviewURL = Liferay.PortletURL.createRenderURL();
			
			if(mapPreviewURL){
				
				mapPreviewURL.setPortletId('<%=portletId %>');
				mapPreviewURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				mapPreviewURL.setParameter('jspPage', '/html/admin/maps/map_preview.jsp');
				mapPreviewURL.setParameter('mapId', mapId);
				mapPreviewURL.setDoAsGroupId('<%=groupId %>');
			}
																			
			var dialogAlignConfig = {
					node: '#_citymaps_admin_WAR_city_mapsportlet_cityMapPermissions',
					points: ['tl', 'tr']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						width:720,
						destroyOnClose:true
					},
					id: '<portlet:namespace/>cityMapPreviewDialog',
					title: dialogTitle,
					uri: mapPreviewURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);

	Liferay.provide(window,'showMapUpdateForm',function(mapId,dialogTitle) {
			
			var A = AUI();
		
			A.DialogManager.hideAll();
								
			var mapUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(mapUpdateFormURL){
				
				mapUpdateFormURL.setPortletId('<%=portletId %>');
				mapUpdateFormURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				mapUpdateFormURL.setParameter('jspPage', '/html/admin/maps/map_update_form.jsp');
				mapUpdateFormURL.setParameter('mapId', mapId);
				mapUpdateFormURL.setDoAsGroupId('<%=groupId %>');
			}
			
			var dialogAlignConfig = {
					node: '.map_type_list_container-content',
					points: ['tl', 'tr']
			};
								   
			Liferay.Util.openWindow(
				{
					dialog: {
						align: dialogAlignConfig,
						constrain: true,
						width:365,
						destroyOnClose:true
					},
					id: '<portlet:namespace/>cityMapDialog',
					title: dialogTitle,
					uri: mapUpdateFormURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</script>
