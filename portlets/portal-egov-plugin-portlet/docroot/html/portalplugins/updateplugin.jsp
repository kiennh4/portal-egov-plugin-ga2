<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.ePortalsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.ePortals"%>
<%@page import="com.bkav.portal.portlet.portalplugins.util.PortalPluginConstant"%>
<%@page import="com.bkav.portal.portlet.portalplugins.service.PortalPluginsLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.portalplugins.model.PortalPlugins"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@ include file = "/html/portalplugins/init.jsp"%>

<%
	List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

	long pluginId = ParamUtil.getLong(request, "pluginId");

	PortalPlugins plugin = PortalPluginsLocalServiceUtil.fetchPortalPlugins(pluginId);
%>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="jspPage" value="/html/portalplugins/view.jsp"/>
</liferay-portlet:renderURL>

<div class = "update-portal-plugin">
	<c:choose>
		<c:when test="<%=Validator.isNotNull(plugin) %>">
			
			<liferay-portlet:actionURL name="updatePlugin" var="updatePluginUrl">
				<liferay-portlet:param name="pluginId" value="<%=Long.toString(plugin.getPluginId()) %>"/>
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
			
			<h2><liferay-ui:message key="update-plugin"/></h2>
			
			<hr>	
			
			<aui:form action="<%=updatePluginUrl %>" method = "POST" enctype="multipart/form-data" >
				<table style = "width:100%">
					<tr>
						<td width = "50%" style = "padding:left:5px">
							<aui:input name="pluginName" type="text" value = "<%=plugin.getPluginName() %>" size = "40" />
							<aui:input name="pluginCode" type="text" value = "<%=plugin.getPluginCode() %>" size = "40" disabled="true"/>
							<aui:input name="pluginVersion" type="text" value = "<%=formatter.format(plugin.getPluginVersion()) %>" size = "40" disabled="true"/>
							<aui:input name="warFile" type = "file"  accept=".war"/>
							<aui:input name="signFile" type = "file"  accept=".sign"/>			
							<aui:select name="pluginType" >
								<%
									String[] pluginTypeArr = PortalPluginConstant.PLUGIN_TYPE;
									
									for (int i = 0; i < pluginTypeArr.length; i++)
									{
								%>
									<aui:option value = "<%=i %>" 
										selected = "<%=(i==plugin.getPluginType())%>"
									>
										<%=pluginTypeArr[i] %>
									</aui:option>
								<%
									}
								%>
							</aui:select>
							<aui:select name="ePortalId" >
								<aui:option value = "0"><liferay-ui:message key = "all"/></aui:option>
								<%
									List<ePortals> listPortal = ePortalsLocalServiceUtil.findByGroupId(groupId);

									for (ePortals portal_ : listPortal)
									{
								%>
									<aui:option value = "<%=portal_.getEportalId() %>" 
										selected = "<%=(portal_.getEportalId()==plugin.getEPortalId())%>"
									>
										<%=portal_.getEportalName() %>
									</aui:option>
								<%
									}
								%>
							</aui:select>
							<aui:select name="isImportant">
								<aui:option value = "0" selected = "<%=(plugin.getIsImportant()==0) %>"><liferay-ui:message key = "important-level-0"/></aui:option>
								<aui:option value = "1" selected = "<%=(plugin.getIsImportant()==1)%>"><liferay-ui:message key = "important-level-1"/></aui:option>
							</aui:select>
						</td>
						<td>
							<p class="aui-field-label"><liferay-ui:message key="plugin-description"/></p>
							<textarea name="pluginDescription" style = "resize:none;" rows="11" cols="50" ><%=plugin.getPluginDescription().trim() %></textarea>
							<p class="aui-field-label"><liferay-ui:message key="plugin-update-info"/></p>
							<textarea name="pluginUpdateInfo" style = "resize:none;" rows="11" cols="50" ><%=plugin.getPluginUpdateInfo().trim() %></textarea>
						</td>
					</tr>
					
				</table>
				<br>
				<br>
				<aui:button type = "submit" name = "saveBtn" value = "save" />
				<aui:button type = "button" name = "backBtn" value = "back" href = "<%=backURL %>"/>			
			</aui:form>
				
		</c:when>
		<c:otherwise>
			
			<liferay-portlet:actionURL name="addPlugin" var="addPluginUrl">
				<liferay-portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request) %>"/>
			</liferay-portlet:actionURL>
			
			<h2><liferay-ui:message key="add-plugin"/></h2>
			
			<hr>	
			
			<aui:form action="<%=addPluginUrl %>" method = "POST" enctype="multipart/form-data" >
				<table style = "width:100%">
					<tr>
						<td width = "50%" style = "padding:left:5px">
							<aui:input name="pluginName" type="text" value = "" size = "40" />
							<aui:input name="pluginCode" type="text" value = "" size = "40"/>
							<aui:input name="pluginVersion" type="text" value = "" size = "40"/>
							<aui:input name="warFile" type = "file"  accept=".war"/>
							<aui:input name="signFile" type = "file"  accept=".sign"/>			
							<aui:select name="pluginType" >
								<aui:option value = "-1"><liferay-ui:message key = "all"/></aui:option>
								<%
									String[] pluginTypeArr = PortalPluginConstant.PLUGIN_TYPE;
									
									for (int i = 0; i < pluginTypeArr.length; i++)
									{
								%>
									<aui:option value = "<%=i %>" >
										<%=pluginTypeArr[i] %>
									</aui:option>
								<%
									}
								%>
							</aui:select>
							<aui:select name="ePortalId" >
								<aui:option value = "0"><liferay-ui:message key = "all"/></aui:option>
								<%
									List<ePortals> listPortal = ePortalsLocalServiceUtil.findByGroupId(groupId);

									for (ePortals portal_ : listPortal)
									{
								%>
									<aui:option value = "<%=portal_.getEportalId() %>" >
										<%=portal_.getEportalName() %>
									</aui:option>
								<%
									}
								%>
							</aui:select>
							<aui:select name="isImportant">
								<aui:option value = "0"><liferay-ui:message key = "not-important"/></aui:option>
								<aui:option value = "1"><liferay-ui:message key = "important"/></aui:option>
							</aui:select>
						</td>
						<td>
							<p class="aui-field-label"><liferay-ui:message key="plugin-description"/></p>
							<textarea name="pluginDescription" style = "resize:none;" rows="11" cols="50" ></textarea>
							<p class="aui-field-label"><liferay-ui:message key="plugin-update-info"/></p>
							<textarea name="pluginUpdateInfo" style = "resize:none;" rows="11" cols="50" ></textarea>
						</td>
					</tr>
					
				</table>
				<br>
				<br>
				<aui:button type = "submit" name = "saveBtn" value = "save" />
				<aui:button type = "button" name = "backBtn" value = "back" href = "<%=backURL %>"/>			
			</aui:form>
		</c:otherwise>
	</c:choose>
</div>
<%!
	/**
	* Tao cay thu muc trong document media
	* parentFolderId - Id cua thu muc cha (mac dinh la thu muc Root)
	* treeLevel - Cap thu muc
	* selectedFolderId - Thu muc dang duoc chon de hien thi anh
	*/
	protected void buildDLFolderTree(long groupId,long parentFolderId,int treeLevel,JspWriter jspWriter,long selectedFolderId){
		
		try{
	
			//Lay danh sach thu muc con cap 1 tinh tu thu muc cha (theo parentFolderId)
			List<DLFolder> subFolderList = DLFolderLocalServiceUtil.getFolders(groupId, parentFolderId);
			
			if(subFolderList.size() > 0){
				
				for(DLFolder subFolder : subFolderList){
					
					String folderNamePrefix = "";
					
					if(treeLevel > 0){
						
						for(int i = 0; i< treeLevel; i++){
							
							folderNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					String subFolderName = folderNamePrefix + subFolder.getName();
					
					if(subFolder.getFolderId() == selectedFolderId){
						
						jspWriter.println("<option selected=\"selected\" value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
					}else{
						
						jspWriter.println("<option value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
					}
					
					int nextTreeLevel = treeLevel + 1;
					
					buildDLFolderTree(groupId, subFolder.getFolderId(), nextTreeLevel, jspWriter, selectedFolderId);
				}
			}
		}catch(Exception e){
			
		}
	}
%>