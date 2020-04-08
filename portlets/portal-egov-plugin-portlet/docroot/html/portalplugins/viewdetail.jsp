<%@page import="com.bkav.portal.portlet.portalplugins.util.PortalPluginConstant"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.PortalPlugins"%>
<%@ include file = "/html/portalplugins/init.jsp"%>
<%
	long pluginId = ParamUtil.getLong(request, "pluginId");

	PortalPlugins plugin = PortalPluginsLocalServiceUtil.fetchPortalPlugins(pluginId);
%>

<div class = "plugin-detail">
	<c:choose>
		<c:when test="<%=(plugin!=null) %>">
			<liferay-portlet:renderURL var="updatePluginUrl">
				<liferay-portlet:param name="jspPage" value="/html/portalplugins/updateplugin.jsp"/>
				<liferay-portlet:param name="pluginId" value="<%=StringUtil.valueOf(plugin.getPluginId()) %>"/>
			</liferay-portlet:renderURL>
			<h3>
				<liferay-ui:message key="plugin-package"/> <%=plugin.getPluginName() %>
			</h3>
			<hr>
			<table style = "width:100%">
				<tr>
					<td width= "30%">
						<liferay-ui:message key="plugin-name"/>:
					</td>
					<td>
						<%=plugin.getPluginName() %>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="plugin-code"/>:
					</td>
					<td>
						<%=plugin.getPluginCode() %>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="plugin-type"/>:
					</td>
					<td>
						<%=PortalPluginConstant.typeByIndex(plugin.getPluginType()) %>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="update-for"/>:
					</td>
					<td>
						<%=plugin.getEPortalId() %>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="current-version"/>:
					</td>
					<td>
						<%=formatter.format(plugin.getPluginVersion())  %>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="important-level"/>:
					</td>
					<td>
						<c:choose>
							<c:when test="<%=(plugin.getIsImportant()==0) %>">
								<liferay-ui:message key="important-level-0"/>
							</c:when>
							<c:otherwise>
								<liferay-ui:message key="important-level-1"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="plugin-description"/>:
					</td>
					<td>
						<%=plugin.getPluginDescription() %>
					</td>
				</tr>
				<tr>
					<td>
						<liferay-ui:message key="plugin-update-info"/>:
					</td>
					<td>
						<%=plugin.getPluginUpdateInfo() %>
					</td>
				</tr>
			</table>
			<aui:button-row>
				<aui:button type = "button" href="<%=updatePluginUrl %>" name = "updateBtn" value = "update"/>
				<aui:button type = "button" href="<%=updatePluginUrl %>" name = "closePopupBtn" value = "close"/>
			</aui:button-row>
			<script type="text/javascript">
				AUI().ready('aui-base',function(A){
				
					var updateBtn = A.one('#<portlet:namespace/>updateBtn');
							
					if(updateBtn){
						
						updateBtn.on('click',function(){
			
							Liferay.Util.getOpener().showPluginUpdateForm('<%=plugin.getPluginId() %>');
							
							Liferay.Util.getWindow().close();
						});
					}
					
					var closePopupBtn = A.one('#<portlet:namespace/>closePopupBtn');
					
					if(closePopupBtn){
						
						closePopupBtn.on('click',function(){
							Liferay.Util.getWindow().close();
						});
					}
				});
			</script>
		</c:when>
	</c:choose>
</div>
