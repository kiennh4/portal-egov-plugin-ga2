<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long menuId = ParamUtil.getLong(request, "menuId");
	
	List<DynamicMenuItem> menuItemList = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, menuId, 0L);

	DynamicMenu menu = null;
	
	if(menuId > 0){
		
		menu = DynamicMenuLocalServiceUtil.getDynamicMenu(menuId);
	}
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateMenu();";
	
%>

<liferay-portlet:actionURL name="updateMenu" var="updateMenuActionURL">
	<liferay-portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
</liferay-portlet:actionURL>

<div class="dynamic-menu-update-form">

	<aui:form name="update_menu_form"  method="post" action="<%=updateMenuActionURL%>" onSubmit="<%=taglibOnSubmit %>">
	
		<aui:model-context bean="<%= menu %>" model="<%= DynamicMenu.class %>" />
				
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		
		<c:if test="<%=menu != null && !menuItemList.isEmpty()%>">
			<div class="menu-items">
				<h3><liferay-ui:message key="menu-items"/></h3>
				<ul>
				<%
				for(DynamicMenuItem menuItem : menuItemList){
					
					long itemId = menuItem.getItemId();
					
					long parentId = menuItem.getParentId();
					
					String addChildItemURL = "javascript:" 
						+ renderResponse.getNamespace() + "showMenuItemUpdateForm(" + menuId + "," + itemId + "," + 0 + ");";
							
					String updateItemURL = "javascript:" 
						+ renderResponse.getNamespace() + "showMenuItemUpdateForm(" + menuId + "," + parentId + "," + itemId + ");";
				%>
					<liferay-portlet:actionURL name="deleteMenuItem" var="deleteItemURL">
						<liferay-portlet:param name="itemId" value="<%=String.valueOf(itemId) %>"/>
						<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
					</liferay-portlet:actionURL>
					
					<li class="menu-item root-item">
						<a href="javascript:;"><%=menuItem.getName() %></a>
						
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
					</li>
				<%
					buildMenuItemTree(groupId, menuId, itemId, 1,request, out);
				}
				%>	
				</ul>
			</div>
		</c:if>
			
		<aui:button-row>
			<c:choose>
				<c:when test="<%=menu != null %>">
					<%
					
					StringBundler sb = new StringBundler();

					sb.append("javascript:");
					sb.append(renderResponse.getNamespace());
					sb.append("selectMenu('");
					sb.append(menu.getMenuId());
					sb.append("','");
					sb.append(menu.getName());
					sb.append("');");
					
					String taglibOnSelect = sb.toString();
					%>

					<aui:button type="submit" value="update"/>
					
					<aui:button name="selectMenuBtn" value="select-display" onClick="<%=taglibOnSelect %>"/>
					
					<aui:button name="addMenuItemBtn" value="add-menu-item"/>
				</c:when>
				
				<c:otherwise>
					<aui:button type="submit" value="save"/>
				</c:otherwise>
			</c:choose>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
		
	</aui:form>
</div>

<aui:script>
	AUI().ready('aui-base','liferay-portlet-url',function(A){
	
		var menuNameInput = A.one('#<portlet:namespace/>name');
		
		if(menuNameInput){
			menuNameInput.focus();
		}
		
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
			
		var addMenuItemBtn = A.one('#<portlet:namespace/>addMenuItemBtn');
		
		if(addMenuItemBtn){
			addMenuItemBtn.on('click',function(){
				<portlet:namespace/>showMenuItemUpdateForm('<%=menuId %>','0','0');
			});
		}
	});
								
	Liferay.provide(
		window,
		'<portlet:namespace/>showMenuItemUpdateForm',
		function(menuId,parentId,itemId){

			var updateMenuItemURL = Liferay.PortletURL.createRenderURL();
			
			updateMenuItemURL.setPortletId('<%=portletResource %>');							
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
		'<portlet:namespace />updateMenu',
		function() {
			
			var A = AUI();
			
			A.io.request(
				document.<portlet:namespace />update_menu_form.action,
				{
					dataType: 'html',
					form: {
						id: document.<portlet:namespace />update_menu_form
					},
					after: {
						success: function() {
							Liferay.Util.getOpener().refresh();
							Liferay.Util.getWindow().close();
						}
					}
				}
			);
		}
	);
					
	Liferay.provide(
		window,
		'<portlet:namespace/>selectMenu',
		function(menuId,menuName){
			Liferay.Util.getOpener().updateMenuSelection(menuId,menuName);
			Liferay.Util.getWindow().close();
		}
	);
						
	Liferay.provide(
		window,
		'<portlet:namespace/>refresh',
		function(){
			
			var formContainer = parent.document.getElementById('_86_menuUpdateFormContainer');
			
			if(formContainer){
				formContainer.contentWindow.location.reload(true);
			}
		}
	);
			
</aui:script>