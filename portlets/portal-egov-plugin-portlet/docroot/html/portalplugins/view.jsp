<%@page import="com.bkav.portal.portlet.portalplugins.util.EportalUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.util.PortalPluginUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.PortalPlugins"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.ePortals"%>
<%@page import="com.bkav.portal.portlet.portalplugins.util.PortalPluginConstant"%>
<%@ include file = "/html/portalplugins/init.jsp"%>
<%
	int pluginIndex = 0;
	
	String pluginName = ParamUtil.getString(request, "pluginName", StringPool.BLANK);
	String pluginCode = ParamUtil.getString(request, "pluginCode", StringPool.BLANK);
	int pluginType = ParamUtil.getInteger(request, "pluginType", -1);
	long ePortalId = ParamUtil.getLong(request, "ePortalId", 0);
	
	List<PortalPlugins> listPlugins = new ArrayList<PortalPlugins>();
	
	if ((!pluginName.equals(StringPool.BLANK))||(!pluginCode.equals(StringPool.BLANK))||(pluginType>-1)||(ePortalId>0))
	{
		listPlugins = PortalPluginUtil.findPortalPluginsByFilter(groupId, pluginName
				, pluginCode, pluginType, ePortalId, -1, -1);
	}
	else
	{
		 listPlugins = PortalPluginsLocalServiceUtil.findByGroupId(groupId);
	}
%>

<liferay-portlet:renderURL varImpl="searchURL" portletName="portalplugins_WAR_portalegovpluginportlet">
	<portlet:param name="mvcPath" value="/html/portalplugins/view.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="searchPluginUrl">
	<liferay-portlet:param name="mvcPath" value="/html/portalplugins/view.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="addPluginUrl">
	<liferay-portlet:param name="jspPage" value="/html/portalplugins/updateplugin.jsp"/>
</liferay-portlet:renderURL>

<div class = "portal-plugins-list">
	<h2>
		<liferay-ui:message key="plugins-list"/>
	</h2>
	
	<hr>
	
	<div class = "portal-plugins-search-form" >
		<form action="<%=searchURL%>" method="post">
			<table style = "width:100%;">
				<tr style = "height:50px;">
					<td width="50%"><aui:input name="pluginName" type="text" /></td>
					<td width="50%"><aui:input name = "pluginCode" type = "text"/></td>
				</tr>
				<tr>
					<td width="50%">
						<aui:select name="pluginType">
							<aui:option value = "-1"><liferay-ui:message key = "all"/></aui:option>
						<%
							String[] pluginTypeArr = PortalPluginConstant.PLUGIN_TYPE;
							
							for (int i = 0; i < pluginTypeArr.length; i++)
							{
						%>
							<aui:option value = "<%=i %>"><%=pluginTypeArr[i] %></aui:option>
						<%
							}
						%>
						</aui:select>
					</td>
					<td width="50%">
						<aui:select name="ePortalId">
							<aui:option value = "0"><liferay-ui:message key = "all"/></aui:option>
						<%
							List<ePortals> listPortal = ePortalsLocalServiceUtil.findByGroupId(groupId);
							
							for (ePortals portal : listPortal)
							{
						%>
							<aui:option value = "<%=portal.getEportalId() %>"><%=portal.getEportalName() %></aui:option>
						<%
							}
						%>
						</aui:select>
					</td>
				</tr>
			</table>
			<br>
			<aui:button type = "submit" value = "search"/>
		</form>
	</div>
	
	<hr>
	
	<aui:button type = "button" value = "add" name = "addPluginBtn" href="<%=addPluginUrl %>"/>
	
	<liferay-ui:search-container
		emptyResultsMessage="no-plugin-found"
		delta = "1"
	>
		<liferay-ui:search-container-results >
			<%
				results = listPlugins;
				
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", listPlugins.size());
			%>
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row className="com.bkav.portal.portlet.portalplugins.model.PortalPlugins" keyProperty="pluginId" modelVar="plugin" >
			<%
					String pluginViewDetailUrl = "javascript: "
								+PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request))
								+"viewPluginDetail("+plugin.getPluginId()+");";
					pluginIndex++;
			%>
			<liferay-ui:search-container-column-text 
					name = "#"
					href = "<%=pluginViewDetailUrl %>"  
					value = "<%=StringUtil.valueOf(pluginIndex) %>"
				/>
				
				<liferay-ui:search-container-column-text 
					name = "plugin-name"
					href = "<%=pluginViewDetailUrl %>"   
					value = "<%=plugin.getPluginName() %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "plugin-code"  
					href = "<%=pluginViewDetailUrl %>"  
					value = "<%=plugin.getPluginCode() %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "version" 
					href = "<%=pluginViewDetailUrl %>"    
					value = "<%=formatter.format(plugin.getPluginVersion()) %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "important" 
					href = "<%=pluginViewDetailUrl %>"     
					value = "<%=StringUtil.valueOf(plugin.getIsImportant()) %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "plugin-type" 
					href = "<%=pluginViewDetailUrl %>"     
					value = "<%=PortalPluginConstant.typeByIndex(plugin.getPluginType()) %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "update-for" 
					href = "<%=pluginViewDetailUrl %>"  
					value = "<%=EportalUtil.getEportalNameById(plugin.getEPortalId()) %>"
				/>
				<liferay-ui:search-container-column-text 
					name = "size" 
					href = "<%=pluginViewDetailUrl %>"  
					value = "<%=StringUtil.valueOf(plugin.getPluginSize()) %>"
				/>
				<liferay-ui:search-container-column-text name = "action" >
					<liferay-portlet:renderURL var="updatePluginUrl">
						<liferay-portlet:param name="jspPage" value="/html/portalplugins/updateplugin.jsp"/>
						<liferay-portlet:param name="pluginId" value="<%=StringUtil.valueOf(plugin.getPluginId()) %>"/>
					</liferay-portlet:renderURL>
					<liferay-portlet:resourceURL var="downloadPluginUrl" >
						<liferay-portlet:param name="jspPage" value="/html/download/war.jsp"/>
						<liferay-portlet:param name="pluginId" value="<%=StringUtil.valueOf(plugin.getPluginId()) %>"/>
					</liferay-portlet:resourceURL>
					<liferay-portlet:actionURL name = "deletePlugin" var="deletePluginUrl">
						<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
						<liferay-portlet:param name="pluginId" value="<%=StringUtil.valueOf(plugin.getPluginId()) %>"/>
					</liferay-portlet:actionURL>
					<liferay-ui:icon-menu>
						 <liferay-ui:icon image="edit" message="edit" url="<%=updatePluginUrl%>"   />
						 <liferay-ui:icon image="delete" message="delete" url="<%=deletePluginUrl%>"   />
						 <liferay-ui:icon image="download" message="download" url="<%=downloadPluginUrl%>"   />
					</liferay-ui:icon-menu>
				</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<aui:script use="aui-dialog" >
AUI().ready('aui-base','liferay-portlet-url',function(A){
	Liferay.provide(
		window,
		'<portlet:namespace/>viewPluginDetail',
		function(pluginId){

			var viewPluginDetailUrl = Liferay.PortletURL.createRenderURL();
										
			viewPluginDetailUrl.setPortletId('portalplugins_WAR_portalegovpluginportlet'); 
			viewPluginDetailUrl.setWindowState('pop_up');
			viewPluginDetailUrl.setParameter('jspPage', '/html/portalplugins/viewdetail.jsp');
			viewPluginDetailUrl.setParameter('pluginId', pluginId);
			viewPluginDetailUrl.setDoAsGroupId('<%=groupId %>');
						
			var dialogWidow = {
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal: true,
					width: 800,
					height:600,
					draggable: true,
        			resizable: false,
					cache: false
				},
				id: '<portlet:namespace/>pluginDetailForm',
				title: '<liferay-ui:message key="plugin-info" />',
				uri: viewPluginDetailUrl
			};
			
			Liferay.Util.openWindow(dialogWidow);	
		}
	);
	Liferay.provide(
		window,
		'showPluginUpdateForm',
		function(pluginId) {
											
			var pluginUpdateFormURL = Liferay.PortletURL.createRenderURL();
			
			if(pluginUpdateFormURL){
				
				pluginUpdateFormURL.setPortletId('portalplugins_WAR_portalegovpluginportlet');
				pluginUpdateFormURL.setWindowState('<%=LiferayWindowState.MAXIMIZED.toString() %>');
				pluginUpdateFormURL.setParameter('jspPage', '/html/portalplugins/updateplugin.jsp');
				pluginUpdateFormURL.setParameter('pluginId', pluginId);
				pluginUpdateFormURL.setDoAsGroupId('<%=groupId %>');
			}
			
			window.location = pluginUpdateFormURL;					
		},
		['aui-base']
	);
})
</aui:script>