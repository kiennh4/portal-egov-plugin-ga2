<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.portal_egov.portlet.citymaps.service.CityMapTypeLocalServiceUtil"%>
<%@page import="com.portal_egov.portlet.citymaps.model.CityMapType"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
	//Id cua loai ban do lay tu URL
	long mapTypeId = ParamUtil.getLong(request, "mapTypeId");

	//Danh sach cac loai ban do
	List<CityMapType> mapTypeList = CityMapTypeLocalServiceUtil.findByGroup(groupId);
%>
	
	<div class="add-new-map-type-link">		
		<a href="javascript:;" onclick="showMapTypeUpdateForm(0,'<%= UnicodeLanguageUtil.get(pageContext, "add-new-map-type") %>')">
			<liferay-ui:message key="add-new-map-type"/>
		</a>
	</div>
		
	<liferay-portlet:renderURL var="viewAllMapURL">
		<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
		<liferay-portlet:param name="mapTypeId" value="0"/>
	</liferay-portlet:renderURL>
				
	<div class="maptype-list">
		<ul>
			<li class='maptype-item <%= (mapTypeId == 0 ? "selected" : "") %>' >
				<div class="maptype-item-content-wrapper">
					<span class="maptype-name">
						<a  href="<%=viewAllMapURL%>"><liferay-ui:message key="all"/></a>
					</span>
				</div>
			</li>
		<%
		for(CityMapType mapType : mapTypeList){//Hien thi danh sach loai ban do
			
			long typeId = mapType.getTypeId();
		
			String mapTypeName = mapType.getTypeName();
			
			StringBundler mapTypeUpdateFormBundle = new StringBundler();

			mapTypeUpdateFormBundle.append("javascript:");
			mapTypeUpdateFormBundle.append("showMapTypeUpdateForm");
			mapTypeUpdateFormBundle.append("('");
			mapTypeUpdateFormBundle.append(typeId);
			mapTypeUpdateFormBundle.append("','");
			mapTypeUpdateFormBundle.append(StringUtil.shorten(mapTypeName, 60));
			mapTypeUpdateFormBundle.append("')");

			String	mapTypeUpdateFormURL = mapTypeUpdateFormBundle.toString();
		%>
				
			<liferay-portlet:renderURL var="viewMapListURL">
				<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
				<liferay-portlet:param name="mapTypeId" value="<%=String.valueOf(typeId) %>"/>
			</liferay-portlet:renderURL>
			 
			<liferay-portlet:actionURL name="deleteMapType" var="deleteMapTypeActionURL">
				<liferay-portlet:param name="mapTypeId" value="<%=String.valueOf(typeId) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
				
			<li class='maptype-item <%= (mapTypeId == typeId ? "selected" : "") %>' >
				<div class="maptype-item-content-wrapper">
					<span class="maptype-name">
						<a  href="<%=viewMapListURL%>"><%=mapTypeName %></a>
					</span>
					
					<a href="<%=mapTypeUpdateFormURL%>" class="edit-maptype-actions-trigger" title="edit"></a>
					
					<a 	class="delete-maptype-actions-trigger"
						href="<%= deleteMapTypeActionURL %>" 
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
	
<script type="text/javascript">

	Liferay.provide(window,'showMapTypeUpdateForm',function(mapTypeId,dialogTitle) {
			
			var A = AUI();
		
			A.DialogManager.hideAll();
								
			var mapTypeUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(mapTypeUpdateFormURL){
				
				mapTypeUpdateFormURL.setPortletId('<%=portletId %>');
				mapTypeUpdateFormURL.setWindowState('<%=LiferayWindowState.POP_UP.toString() %>');
				mapTypeUpdateFormURL.setParameter('jspPage', '/html/admin/map_types/map_type_update_form.jsp');
				mapTypeUpdateFormURL.setParameter('mapTypeId', mapTypeId);
				mapTypeUpdateFormURL.setDoAsGroupId('<%=groupId %>');
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
					uri: mapTypeUpdateFormURL
				}
			);
		},
		['liferay-portlet-url','aui-dialog','aui-dialog-iframe']
	);
</script>