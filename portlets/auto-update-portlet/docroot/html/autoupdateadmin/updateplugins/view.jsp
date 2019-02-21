<%@page import="com.bkav.portal.portlet.autoupdate.service.UpdatePluginsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file = "/html/autoupdateadmin/updateplugins/init.jsp" %>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateConnector"%>
<%@page import="com.bkav.portal.autoupdate.admin.util.AutoUpdateAdminUtil"%>
<%@page import="com.bkav.portal.portlet.autoupdate.model.UpdatePlugins"%>

<%
	List<UpdatePlugins> listAvailablePlugins = AutoUpdateConnector.getAllAvailablePlugins("localhost:8086");

	List<UpdatePlugins> listUpdatePlugins = AutoUpdateAdminUtil.getUpdatePlugins(listAvailablePlugins);
	
	int pluginIndex = 0;
	
%>
<liferay-portlet:actionURL  name="restorePlugins" var="restorePluginsUrl">
	<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
</liferay-portlet:actionURL>

<div class = "portlet-msg-info" style = "display:none;" id = "<portlet:namespace/>infoMsg">
	<liferay-ui:message key = "you-must-select-at-least-1-plugin"  />
</div>
<div class = "update-plugins-content">
	<liferay-ui:search-container
			emptyResultsMessage="no-update-found"
			delta = "5"
		>
			<liferay-ui:search-container-results >
				<%
					results = listUpdatePlugins;
					
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", listUpdatePlugins.size());
				%>
			</liferay-ui:search-container-results>
			
			<liferay-ui:search-container-row className="com.bkav.portal.portlet.autoupdate.model.UpdatePlugins" keyProperty="pluginId" modelVar="plugin" >
				<%
						String pluginViewDetailUrl = "javascript: "
									+PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request))
									+"viewDetailUpdate("+plugin.getPluginId()+");";
									
						pluginIndex++;
						
						String currentVersion = "";
						
						UpdatePlugins existedPlugin = UpdatePluginsLocalServiceUtil.fetchByPluginCode(plugin.getPluginCode());
						
						if (existedPlugin!=null)
						{
							currentVersion = StringUtil.valueOf(existedPlugin.getCurrentVersion());
						}
				%>
					<liferay-ui:search-container-column-text >
						<input type = "checkbox" value = "<%=plugin.getPluginId() %>" 
						server-company-id = "<%=plugin.getServerCompanyId() %>" 
						plugin-code = "<%=plugin.getPluginCode() %>"
						plugin-version = "<%=formatter.format(plugin.getCurrentVersion())  %>"
						plugin-type = "<%=plugin.getPluginType() %>"
						plugin-name = "<%=plugin.getPluginName() %>"
						plugin-size = "<%=plugin.getCurrentSize() %>"
						class = "<portlet:namespace/>updatePluginId"/>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text 
						name = "#"
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
						name = "current-version" 
						value = "<%=currentVersion %>"
					/>
					<liferay-ui:search-container-column-text 
						name = "current-version" 
						value = "<%=(!currentVersion.equals(StringPool.BLANK)) ? formatter.format(Double.valueOf(currentVersion)) : StringPool.BLANK %>"
					/>
					<liferay-ui:search-container-column-text 
						name = "update-version" 
						value = "<%=formatter.format(plugin.getCurrentVersion())  %>"
					/>
					<liferay-ui:search-container-column-text >
						<liferay-portlet:renderURL var="updatePluginUrl" portletName="autoupdateadmin_WAR_autoupdateportlet">
							<liferay-portlet:param name="jspPage" value="/html/autoupdateadmin/updateplugins/update.jsp"/>
							<liferay-portlet:param name="pluginId" value="<%=StringUtil.valueOf(plugin.getPluginId()) %>"/>
							<liferay-portlet:param name="pluginVersion" value="<%=StringUtil.valueOf(plugin.getCurrentVersion()) %>"/>
							<liferay-portlet:param name="pluginCode" value="<%=plugin.getPluginCode() %>"/>
							<liferay-portlet:param name="serverCompanyId" value="<%=StringUtil.valueOf(plugin.getServerCompanyId()) %>"/>
							<liferay-portlet:param name="pluginName" value="<%=plugin.getPluginName() %>"/>
							<liferay-portlet:param name="pluginSize" value="<%=StringUtil.valueOf(plugin.getCurrentSize()) %>"/>
							<liferay-portlet:param name="pluginType" value="<%=StringUtil.valueOf(plugin.getPluginType()) %>"/>
						</liferay-portlet:renderURL>
						<%
							String updatePluginEvent = "javascript: window.location.href = '"+updatePluginUrl+"';";
						%>
						<aui:button type = "button" value = "update" name = "updatePluginBtn" onClick="<%=updatePluginEvent %>"  />
					</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	
	<aui:button name = "updateSelectedPlugin" value = "update" type = "button"/>
	<aui:button name = "rollBackSelectedPlugin" value = "rollback" type = "button"/>
</div>
<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		A.one('#<portlet:namespace/>updateSelectedPlugin').on('click',function(){
			<portlet:namespace/>updatePlugins();
		});
		
		A.one('#<portlet:namespace/>rollBackSelectedPlugin').on('click',function(){
			<portlet:namespace/>rollbackPlugins();
		});
		
		Liferay.provide(
			window,
			'<portlet:namespace/>updatePlugins',
			function(){
				var havePluginSelected = false;
				
				var updatePluginUrl = Liferay.PortletURL.createRenderURL();
											
				updatePluginUrl.setPortletId('autoupdateadmin_WAR_autoupdateportlet'); 
				updatePluginUrl.setParameter('jspPage', '/html/autoupdateadmin/updateplugins/update.jsp');
				
				var pluginId = [];
				var serverCompanyIdArray = [];
				var pluginCodeArray = [];
				var pluginVersionArray = [];
				var pluginTypeArray = [];
				var pluginSizeArray = [];
				var pluginNameArray = [];
				
				A.all('.<portlet:namespace/>updatePluginId').each(function(){
					
					if (A.one(this).get('checked'))
					{
						pluginId.push(A.one(this).val());
						serverCompanyIdArray.push(A.one(this).getAttribute('server-company-id'));
						pluginCodeArray.push(A.one(this).getAttribute('plugin-code'));
						pluginVersionArray.push(A.one(this).getAttribute('plugin-version'));
						pluginTypeArray.push(A.one(this).getAttribute('plugin-type'));
						pluginSizeArray.push(A.one(this).getAttribute('plugin-size'));
						pluginNameArray.push(A.one(this).getAttribute('plugin-name'));
						havePluginSelected = true;
					}
				});
				
				updatePluginUrl.setParameter('pluginId', pluginId.toString());
				updatePluginUrl.setParameter('serverCompanyId', serverCompanyIdArray.toString());
				updatePluginUrl.setParameter('pluginCode', pluginCodeArray.toString());
				updatePluginUrl.setParameter('pluginVersion', pluginVersionArray.toString());
				updatePluginUrl.setParameter('pluginType', pluginTypeArray.toString());
				updatePluginUrl.setParameter('pluginSize', pluginSizeArray.toString());
				updatePluginUrl.setParameter('pluginName', pluginNameArray.toString());
				
				updatePluginUrl.setDoAsGroupId('<%=groupId %>');
				if (havePluginSelected)
				{		
					window.location.href = updatePluginUrl;
				}
				else
				{
					A.one('#<portlet:namespace/>infoMsg').setStyle('display','block');
				}	
			}
		);
		
		Liferay.provide(
			window,
			'<portlet:namespace/>rollbackPlugins',
			function(){
				var havePluginSelected = false;
				
				var restorePluginUrl = Liferay.PortletURL.createRenderURL();
											
				restorePluginUrl.setPortletId('autoupdateadmin_WAR_autoupdateportlet'); 
				restorePluginUrl.setParameter('jspPage', '/html/autoupdateadmin/updateplugins/rollback.jsp');
				
				var pluginCodeArray = [];
				
				A.all('.<portlet:namespace/>updatePluginId').each(function(){
					if (A.one(this).get('checked'))
					{
						pluginCodeArray.push(A.one(this).getAttribute('plugin-code'));
						havePluginSelected = true;
					}
				});
				
				restorePluginUrl.setParameter('pluginCode', pluginCodeArray.toString());
				
				restorePluginUrl.setDoAsGroupId('<%=groupId %>');
				if (havePluginSelected)
				{		
					window.location.href = restorePluginUrl;
				}
				else
				{
					A.one('#<portlet:namespace/>infoMsg').setStyle('display','block');
				}	
			}
		);
	})
</aui:script>
