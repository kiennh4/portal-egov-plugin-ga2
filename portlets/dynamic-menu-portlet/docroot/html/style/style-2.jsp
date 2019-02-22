<%@page import="com.bkav.portal.portlet.dynamic_menu.util.DynamicMenuUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="/dynamic-menu-portlet/js/hoverIntent.js"></script>

<script type="text/javascript" src="/dynamic-menu-portlet/js/superfish.js"></script>

<%@include file="/html/init.jsp"%>

<%
	List<DynamicMenuItem> rootMenuItems = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, selectedMenuId, 0);
%>

<div class="dynamic-menu-style-2">
	<ul id="<portlet:namespace/>dynamic-sidebar-menu" class="sf-menu sf-vertical">
		<%
		for(DynamicMenuItem rootMenuItem : rootMenuItems){
			
			long itemId = rootMenuItem.getItemId();
			
			String itemURL = DynamicMenuUtil.getMenuItemURL(themeDisplay, rootMenuItem.getUrlType(), rootMenuItem.getUrl());
			
			String addChildItemURL = "javascript:" 
				+ renderResponse.getNamespace() + "showMenuItemUpdateForm(" + selectedMenuId 
				+ "," + itemId + "," + 0 + ");";
					
			String updateItemURL = "javascript:" 
				+ renderResponse.getNamespace() + "showMenuItemUpdateForm(" + selectedMenuId + "," 
				+ rootMenuItem.getParentId() + "," + itemId + ");";
		%>
			<liferay-portlet:actionURL name="deleteMenuItem" var="deleteItemURL">
				<liferay-portlet:param name="itemId" value="<%=String.valueOf(itemId) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
			
			<li class="menu-item root-item">
				
				<a href="<%=itemURL%>"><%=rootMenuItem.getName() %></a>
				
				<div class="menu-action">										
					<c:if test="<%=hasAddMenuItemPermission %>">
						<a 	href="<%=addChildItemURL%>" title="<%=LanguageUtil.get(locale, "add-child-item") %>" 
							class="add-menu-item-trigger" ></a>
					</c:if>
					
					<c:if test="<%=hasUpdateMenuItemPermission %>">
						<a 	href="<%=updateItemURL%>" title="<%=LanguageUtil.get(locale, "edit") %>" 
							class="update-menu-item-trigger" ></a>
					</c:if>	
					
					<c:if test="<%=hasDeleteMenuItemPermission %>">		
						<a 	href="<%=deleteItemURL.toString()%>" title="<%=LanguageUtil.get(locale, "delete") %>" 
							class="delete-menu-item-trigger"
							onclick="return confirm('confirm delete ?');" ></a>
					</c:if>
				</div>
				<%
				buildMenuItemTree(groupId, selectedMenuId, itemId, 1,request, out);
				%>
			</li>
		<%
		}
		%>	
	</ul>
</div>

<div style="clear:both;"></div>

<script type="text/javascript">
	AUI().ready(function(){
		jQuery('#<portlet:namespace/>dynamic-sidebar-menu').superfish({
			animation: {height:'show'},	// slide-down effect without fade-in
			delay:		 500			// 1.2 second delay on mouseout
		});
	});
</script>
<aui:script use="aui-base,liferay-portlet-url">
								
	Liferay.provide(
		window,
		'<portlet:namespace/>showMenuItemUpdateForm',
		function(menuId,parentId,itemId){

			var updateMenuItemURL = Liferay.PortletURL.createRenderURL();
			
			updateMenuItemURL.setPortletId('<%=portletDisplay.getId() %>');							
			updateMenuItemURL.setWindowState('pop_up');
			updateMenuItemURL.setParameter('jspPage', '/html/menu-item-update-form.jsp');
			updateMenuItemURL.setParameter('menuId', menuId);
			updateMenuItemURL.setParameter('parentId', parentId);
			updateMenuItemURL.setParameter('itemId', itemId);
			updateMenuItemURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				title: Liferay.Language.get('menu-item-info'),
				uri: updateMenuItemURL
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
					
	Liferay.provide(
		window,
		'<portlet:namespace/>selectMenu',
		function(menuId,menuName){
			Liferay.Util.getWindow().close();
		}
	);
						
	Liferay.provide(
		window,
		'<portlet:namespace/>refresh',
		function(){
			Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
		}
	);
			
</aui:script>
