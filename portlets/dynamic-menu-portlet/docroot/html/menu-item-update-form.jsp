<%@page import="com.bkav.portal.portlet.dynamic_menu.util.DynamicMenuUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuItemLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenuItem"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long menuId = ParamUtil.getLong(request, "menuId");

	long itemId = ParamUtil.getLong(request, "itemId");
	
	long parentId = ParamUtil.getLong(request, "parentId");
	
	long selectedPageLayoutId = 0L;
	
	String urlType = DynamicMenuUtil.EXTERNAL_URL_TYPE;

	DynamicMenuItem item = null;
	
	if(itemId > 0){
		
		item = DynamicMenuItemLocalServiceUtil.getDynamicMenuItem(itemId);
		
		if(item != null){
			
			parentId = item.getParentId();
			
			urlType = item.getUrlType();
			
			if(Validator.equals(urlType, DynamicMenuUtil.INTERNAL_URL_TYPE)){
				
				String friendlyURL = item.getUrl();
				
				Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, false, friendlyURL);
				
				if(layout != null){
					
					selectedPageLayoutId = layout.getPlid();
				}
			}
		}
	}
	
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
	
	List<DynamicMenuItem> rootItemList = DynamicMenuItemLocalServiceUtil.findByG_M_P(groupId, menuId, 0);
	
	String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "updateMenuItem();";
%>

<liferay-portlet:actionURL name="updateMenuItem" var="updateMenuItemActionURL">
	<liferay-portlet:param name="itemId" value="<%=String.valueOf(itemId) %>"/>
</liferay-portlet:actionURL>

<div class="dynamic-menu-update-form">

	<aui:form name="menu_item_update_fm"  method="post" action="<%=updateMenuItemActionURL%>" onSubmit="<%=taglibOnSubmit %>">
	
		<aui:model-context bean="<%= item %>" model="<%= DynamicMenuItem.class %>" />
		
		<aui:select name="parentId" label="parent-menu-item">
			<aui:option label="none" value="0" selected="<%=parentId == 0L %>"/>
			<%
			for(DynamicMenuItem parentItem : rootItemList){
			%>
			<aui:option label="<%=parentItem.getName() %>" value="<%=parentItem.getItemId() %>" 
						selected="<%=parentId == parentItem.getItemId() %>"/>
			<%
				buildMenuItemTreeSelector(groupId, parentItem.getMenuId(), parentItem.getItemId(),
					parentId, 1, out);
			}
			%>
		</aui:select>
						
		<aui:input name="name">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:select name="urlType" label="url-type" helpMessage="menu-item-url-type-help-msg">
			<aui:option label="internal-url" value="<%=DynamicMenuUtil.INTERNAL_URL_TYPE %>" 
						selected='<%=Validator.equals(urlType, DynamicMenuUtil.INTERNAL_URL_TYPE) %>'/>
			<aui:option label="external-url" value="<%=DynamicMenuUtil.EXTERNAL_URL_TYPE %>" 
						selected='<%=Validator.equals(urlType, DynamicMenuUtil.EXTERNAL_URL_TYPE) %>'/>
		</aui:select>
				
		<div id="<portlet:namespace/>internal" 
			 class='<%=Validator.equals(urlType, "internal") ? StringPool.BLANK : "aui-helper-hidden"%> item-url-wrapper'>
						
			<aui:select name="pageLayoutId" label="link-to-page">
				<aui:option label="select" value="0" selected="<%= selectedPageLayoutId == 0L %>"/>
				<%
				for(Layout layout : groupLayoutList){
				%>
					<aui:option label="<%=layout.getName() %>" value="<%=layout.getPlid() %>" 
								selected="<%=selectedPageLayoutId == layout.getPlid() %>"
					/>
				<%
				}
				%>
			</aui:select>
		</div>	
		
		<div id="<portlet:namespace/>external"
			 class='<%=Validator.equals(urlType, "external") ? StringPool.BLANK : "aui-helper-hidden"%> item-url-wrapper'>
			<aui:input type="textarea" name="url" />
		</div>	
							
		<aui:input name="position" label="display-position" helpMessage="menu-item-position-help-msg">
			<aui:validator name="digits" />
		</aui:input>
		
		<aui:input type="hidden" name="menuId" value="<%=menuId %>"/>
		
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
		
	</aui:form>
</div>

<aui:script>
	AUI().ready('aui-loading-mask', 'aui-io-request',function(A){
	
		var itemNameInput = A.one('#<portlet:namespace/>name');
		
		if(itemNameInput){
			itemNameInput.focus();
		}
	
		var urlTypeSelector = A.one('#<portlet:namespace/>urlType');
		
		if(urlTypeSelector){
			
			urlTypeSelector.on('change',function(){
			
				A.all('.item-url-wrapper').hide();
				
				var selectorValue = urlTypeSelector.val().trim();
				
				var urlWrapper = A.one('#<portlet:namespace/>' + selectorValue);
				
				if(urlWrapper){
					urlWrapper.show();
				}
			});
		}
		
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
					
	Liferay.provide(
		window,
		'<portlet:namespace />updateMenuItem',
		function() {
			
			var A = AUI();
			
			var formContainer = A.one('#<portlet:namespace />menu_item_update_fm');
			
			formContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
			
			formContainer.loadingmask.toggle();
			
			A.io.request(
				document.<portlet:namespace />menu_item_update_fm.action,
				{
					dataType: 'html',
					form: {
						id: document.<portlet:namespace />menu_item_update_fm
					},
					after: {
						success: function() {
							Liferay.Util.getOpener().<portlet:namespace/>refresh();
							Liferay.Util.getWindow().close();
						}
					}
				}
			);
		}
	);	
</aui:script>