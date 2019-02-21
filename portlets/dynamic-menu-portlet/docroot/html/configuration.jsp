<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.permission.DynamicMenuPermission"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.service.DynamicMenuLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.dynamic_menu.model.DynamicMenu"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%	
	int menuIndex = 0;
	
	int searchContainerDelta = ParamUtil.getInteger(request, "delta",0);
	
	int searchContainerCurrentPage = ParamUtil.getInteger(request, "cur",0);
	
	if(searchContainerCurrentPage > 1){
		
		menuIndex = searchContainerDelta * (searchContainerCurrentPage - 1);
	}
	
	String selectedMenuName = "";
	
	selectedMenuId = ParamUtil.getLong(request, "selectedMenuId",selectedMenuId);
	
	if(selectedMenuId > 0){
		
		DynamicMenu selectedMenu = DynamicMenuLocalServiceUtil.getDynamicMenu(selectedMenuId);
		
		if(selectedMenu != null){
			
			selectedMenuName = selectedMenu.getName();
		}
	}
	
	String styleThumbnailImgPath = "/dynamic-menu-portlet/html/style/" + displayStyle.trim() + "-thumbnail.png";
	
	String portletConfigContainerId = StringPool.UNDERLINE + portletResource + StringPool.UNDERLINE + "configurationIframeDialog";
	
	String menuSearchKeyword = ParamUtil.getString(request, "menuSearchKeyword");
	
	List<DynamicMenu> menuSearchResults = DynamicMenuLocalServiceUtil.findByKeyword(groupId, menuSearchKeyword, 0, -1);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" >
	<liferay-portlet:param name="menuSearchKeyword" value="<%=menuSearchKeyword %>"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL portletConfiguration="true" varImpl="configurationImplRenderURL" >
	<liferay-portlet:param name="menuSearchKeyword" value="<%=menuSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div class="portlet-config-form">
	
	<aui:layout>
		<aui:column columnWidth="30">
			<div id="<portlet:namespace/>selectedMenuInfo" class="portlet-msg-info">
				<c:choose>
					<c:when test='<%=Validator.isNotNull(selectedMenuName) %>'>
						<span class="displaying-menu-holder">
							<liferay-ui:message key="displayed-menu" />: 
							<span class="displaying-menu-name"><%= selectedMenuName %></span>
						</span>
					</c:when>
					<c:otherwise>
						<span class="displaying-help-message-holder 
								<%= Validator.isNotNull(selectedMenuName) ? "aui-helper-hidden"  : StringPool.BLANK %>">
							<liferay-ui:message key="please-select-a-dynamic-menu-from-the-list-below-and-click-save-button" />
						</span>
					
						<span class="displaying-menu-holder 
								<%= Validator.isNotNull(selectedMenuName) ? StringPool.BLANK  :"aui-helper-hidden"%>">
							<liferay-ui:message key="displayed-menu" />: 
							<span class="displaying-menu-name"><%= selectedMenuName %></span>
						</span>
					</c:otherwise>
				</c:choose>		
			</div>
			
			<div>
				<aui:form name="config_fm" method="post" action="<%=configurationActionURL %>">	
					<aui:select name="displayStyle">
						<aui:option label="style-1" value="style-1" 
									selected='<%=Validator.equals(displayStyle, "style-1") %>'/>
						<aui:option label="style-2" value="style-2" 
									selected='<%=Validator.equals(displayStyle, "style-2") %>'/>
					</aui:select>
					
					<aui:input type="hidden" name="selectedMenuId" value="<%=selectedMenuId %>"/>
							
					<aui:button-row>
						<aui:button type="submit" value="save"/>
						<aui:button name="cancelBtn" value="cancel"/>
					</aui:button-row>
				</aui:form>
			</div>
		</aui:column>
		
		<aui:column columnWidth="70">
			<div class="style-thumbnail">
				<img 
					id="<portlet:namespace/>styleThumbnailImage"  
					src="<%=styleThumbnailImgPath %>"
					onerror="this.src='/article-publisher-portlet/images/default-asset-image.jpg'" 
				/>
			</div>
		</aui:column>
	</aui:layout>

	
	<div>
		<div class="menu-search-form">
			<aui:form name="rss_search_fm" method="post" action="<%=configurationRenderURL.toString() %>">
				<input type="text" id="<portlet:namespace/>menuSearchKeyword" name="menuSearchKeyword" value="<%=menuSearchKeyword %>"/>
				
				<aui:button type="submit" value="search"/>
				
				<aui:button value="show-all" href="<%=configurationRenderURL %>"/>
				
				<aui:button name="addNewMenuBtn" value="add-new-menu"/>
			</aui:form>
		</div>
		
		<div style="clear: both;"></div>
		
		<div class="separator"></div>
		
		<div class="menu-search-result">
			<liferay-ui:search-container iteratorURL="<%=configurationImplRenderURL %>" delta="10">
			
				<liferay-ui:search-container-results 
					results="<%=ListUtil.subList(menuSearchResults, searchContainer.getStart(), searchContainer.getEnd()) %>" 
					total="<%=menuSearchResults.size() %>"
				/>
				
				<liferay-ui:search-container-row className="DynamicMenu" keyProperty="menuId" modelVar="dynamicMenu">
					
					<%
						menuIndex ++;
					
						String updateMenuURL = "javascript:" + renderResponse.getNamespace() 
											 + "showMenuUpdateForm(" + dynamicMenu.getMenuId() + ");";
					%>
					
					<liferay-portlet:renderURL portletConfiguration="true" var="selectMenuURL" >
						<liferay-portlet:param name="selectedMenuId" value="<%=String.valueOf(dynamicMenu.getMenuId()) %>"/>
					</liferay-portlet:renderURL>
															
					<liferay-ui:search-container-column-text 
						name="#" 
						value="<%=String.valueOf(menuIndex)%>" 
						href="<%=updateMenuURL %>"
						title="view-detail"
					/>
													
					<liferay-ui:search-container-column-text 
						name="menu-name"
						value="<%=dynamicMenu.getName()%>" 
						href="<%=updateMenuURL %>"
						title="view-detail"
					/>
																	
					<liferay-ui:search-container-column-text 
						name="item-count" 
						value="<%=String.valueOf(dynamicMenu.getItemCount())%>"
						href="<%=updateMenuURL %>"
						title="view-detail"
					/>
													
					<liferay-ui:search-container-column-text 
						name="last-modified-date" 
						value="<%=dateTimeFormat.format(dynamicMenu.getModifiedDate())%>"
						href="<%=updateMenuURL %>"
						title="view-detail"
					/>
					
					<liferay-ui:search-container-column-text name="select">
						<aui:button name="select" value="select-display" href="<%=selectMenuURL %>"/>
					</liferay-ui:search-container-column-text>
									
					<c:if test="<%=DynamicMenuPermission.contains(permissionChecker, groupId,ActionKeys.UPDATE) %>">
						<liferay-ui:search-container-column-text name="edit">															
							<liferay-ui:icon image="edit" message="edit" url="<%= updateMenuURL %>" />
						</liferay-ui:search-container-column-text>
					</c:if>
																										
					<c:if test="<%=DynamicMenuPermission.contains(permissionChecker, groupId, ActionKeys.DELETE) %>">
						<liferay-ui:search-container-column-text name="delete">													
							<liferay-portlet:actionURL  portletName="<%=portletResource %>" name="deleteMenu" var="deleteMenuURL">
								<liferay-portlet:param name="menuId" value="<%=String.valueOf(dynamicMenu.getMenuId()) %>"/>
								<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
							</liferay-portlet:actionURL>
							
							<liferay-ui:icon-delete url="<%= deleteMenuURL %>" />
						</liferay-ui:search-container-column-text>
					</c:if>	
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator paginate="<%=true %>"/>
			</liferay-ui:search-container>
		</div>
	</div>
</div>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
				
		var displayStyleSelector = A.one('#<portlet:namespace/>displayStyle');
		
		if(displayStyleSelector){
			
			displayStyleSelector.on('change',function(){
				
				var selectedStyle = this.val().trim();
				
				var styleThumbnailImg = A.one('#<portlet:namespace/>styleThumbnailImage');
				
				if(styleThumbnailImg){

					var selectedStyleThumbnailPath = '/dynamic-menu-portlet/html/style/' + selectedStyle + '-thumbnail.png';
					
					styleThumbnailImg.setAttribute('src',selectedStyleThumbnailPath);
				}
			});
		}
		
		var menuSearchKeywordInput = A.one('#<portlet:namespace/>menuSearchKeyword');
		
		if(menuSearchKeywordInput){
			menuSearchKeywordInput.focus();
		}
		
		var addNewMenuBtn = A.one('#<portlet:namespace/>addNewMenuBtn');
		
		if(addNewMenuBtn){
			
			addNewMenuBtn.on('click',function(){
				<portlet:namespace/>showMenuUpdateForm(0);
			});
		}
								
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
					
	Liferay.provide(
		window,
		'<portlet:namespace/>showMenuUpdateForm',
		function(menuId){

			var updateMenuURL = Liferay.PortletURL.createRenderURL();
			
			updateMenuURL.setPortletId('<%=portletResource %>');							
			updateMenuURL.setWindowState('pop_up');
			updateMenuURL.setParameter('portletResource', '<%=portletResource %>');
			updateMenuURL.setParameter('jspPage', '/html/menu-update-form.jsp');
			updateMenuURL.setParameter('menuId', menuId);
			updateMenuURL.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 400,
					cache: false
				},
				id: '<portlet:namespace/>menuUpdateFormContainer',
				title: Liferay.Language.get('dynamic-menu-info'),
				uri: updateMenuURL
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
				
	Liferay.provide(
		window,
		'updateMenuSelection',
		function(menuId,menuName){
			var A = AUI();
			
			var selectedMenuInfoContainer = A.one('#<portlet:namespace/>selectedMenuInfo');
			
			if(selectedMenuInfoContainer){
				selectedMenuInfoContainer.empty();
				selectedMenuInfoContainer.html(Liferay.Language.get('displayed-menu') + ' : ' + menuName);
			}
			
			var selectedMenuIdHolder = A.one('#<portlet:namespace/>selectedMenuId');
			
			if(selectedMenuIdHolder){
				selectedMenuIdHolder.set('value',menuId);
			}
		}
	);
					
	Liferay.provide(
		window,
		'refresh',
		function(){
		
			var portletConfigDialog = parent.frames['<%=portletConfigContainerId%>'].document;
			
			if(portletConfigDialog){
				portletConfigDialog.location.reload(true);
			}
		}
	);
</aui:script>
