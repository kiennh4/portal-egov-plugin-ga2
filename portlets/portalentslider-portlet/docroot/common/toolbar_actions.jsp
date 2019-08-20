
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@include file="/init.jsp"%>

<%
	boolean showConfigPortletIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION);
%>

<c:if test="<%= showConfigPortletIcon%>">
	<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="addURL" portletName="<%= SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
		<portlet:param name="mvcPath" value="/common/add_slider.jsp" />
	</liferay-portlet:renderURL>
					
	<%
		String taglibAddURL = "javascript:Liferay.Util.openWindow({dialog: {width: '600px',modal: true, align: Liferay.Util.Window.ALIGN_CENTER}, cache: false, dialogSubmitButton: true, id: '" + 
					renderResponse.getNamespace() + "addSlider', title: '" + LanguageUtil.get(pageContext, "add-slider") + 
							"', uri:'" + HtmlUtil.escapeURL(addURL) + "'})";
	%>
	
	<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="editURL" portletName="<%= SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
		<portlet:param name="mvcPath" value="/common/edit_slider.jsp" />
	</liferay-portlet:renderURL>
					
	<%
		String taglibEditURL = "javascript:Liferay.Util.openWindow({dialog: {width: '820px', modal: true, align: Liferay.Util.Window.ALIGN_CENTER},cache: false, dialogSubmitButton: true, id: '" + 
					renderResponse.getNamespace() + "editSlider', title: '" + LanguageUtil.get(pageContext, "edit-slider") + 
							"', uri:'" + HtmlUtil.escapeURL(editURL) + "'})";
	%>
	<div class="lfr-meta-actions icons-container aui-helper-hidden">
		<div class="icon-actions">
			<div class="toolbar-portlet-config">
				<liferay-ui:icon
					cssClass="portlet-configuration"
					image="configuration"
					message="configuration"
					method="get"
					onClick="<%= portletDisplay.getURLConfigurationJS() %>"
					url="<%= portletDisplay.getURLConfiguration() %>"
				/>
			</div>
			<div class="toolbar-portlet-add">
				<liferay-ui:icon
					image="add"
					label="<%=false %>"
					message='<%= LanguageUtil.get(pageContext, "add-product") %>'
					url="<%=taglibAddURL %>"
				/>
			</div>
			<div class="toolbar-portlet-edit">
				<liferay-ui:icon
					image="edit"
					label="<%=false %>"
					message='<%= LanguageUtil.get(pageContext, "add-product") %>'
					url="<%=taglibEditURL %>"
				/>
			</div>
		</div>
	</div>

	<aui:script use="aui-base">
		AUI().ready(function(A){
			var portletToolbarAction = A.one('#p_p_id<portlet:namespace /> .portlet-borderless-bar .portlet-actions');
			
			if(portletToolbarAction){
				var TPL_SPAN_SEPARATOR = '<span class="portlet-action-separator">-</span>';

				var toolbarPortletAdd = A.one('#p_p_id<portlet:namespace /> .toolbar-portlet-add');
				if(toolbarPortletAdd){
					var nodeToolbarAdd = A.Node.create('<span class="portlet-action portlet-add"></span>');
					nodeToolbarAdd.append(TPL_SPAN_SEPARATOR);
					nodeToolbarAdd.append(toolbarPortletAdd.getContent());
					portletToolbarAction.append(nodeToolbarAdd);
					
					var tmpToolbar = toolbarPortletAdd.ancestor('.lfr-meta-actions');
				}
				
				var toolbarPortletEdit = A.one('#p_p_id<portlet:namespace /> .toolbar-portlet-edit');
				if(toolbarPortletEdit){
					var nodeToolbarEdit = A.Node.create('<span class="portlet-action portlet-edit"></span>');
					nodeToolbarEdit.append(TPL_SPAN_SEPARATOR);
					nodeToolbarEdit.append(toolbarPortletEdit.getContent());
					portletToolbarAction.append(nodeToolbarEdit);
					
					var tmpToolbar = toolbarPortletEdit.ancestor('.lfr-meta-actions');
				}

				var toolbarPortletConfig = A.one('#p_p_id<portlet:namespace /> .toolbar-portlet-config');
				if(toolbarPortletConfig){
					var nodeToolbarConfig = A.Node.create('<span class="portlet-action portlet-config"></span>');
					nodeToolbarConfig.append(TPL_SPAN_SEPARATOR);
					nodeToolbarConfig.append(toolbarPortletConfig.getContent());
					portletToolbarAction.append(nodeToolbarConfig);
					
					var tmpToolbar = nodeToolbarConfig.ancestor('.lfr-meta-actions');
				}
				
			} else {
			
				var portlettopperToolbar = A.one('#portlet-topper-toolbar_<%=portletDisplay.getId() %>');
				
				if(portlettopperToolbar) {
				
					var toolbarPortletAdd = A.one('#p_p_id<portlet:namespace /> .toolbar-portlet-add');
					if(toolbarPortletAdd){
						
						portlettopperToolbar.append(toolbarPortletAdd.getContent());
					}
					
					var toolbarPortletEdit = A.one('#p_p_id<portlet:namespace /> .toolbar-portlet-edit');
					if(toolbarPortletEdit){
						
						portlettopperToolbar.append(toolbarPortletEdit.getContent());
					}
					
					var toolbarPortletConfig = A.one('#p_p_id<portlet:namespace /> .toolbar-portlet-config');
					if(toolbarPortletConfig){
						portlettopperToolbar.append(toolbarPortletConfig.getContent());
						
					}
				}
			}
		});
	</aui:script>
</c:if>
