<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	long parentFolderId = ParamUtil.getLong(request, "parentFolderId");

	String redirect = ParamUtil.getString(request, "redirect",PortalUtil.getCurrentURL(request));
	
	String portletInstanceName = ParamUtil.getString(request, "portletResource");
	
	List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
%>

<liferay-portlet:actionURL var="addImageFolderActionURL" name="addImageFolder" portletName="<%=portletInstanceName %>">
	<liferay-portlet:param  name="redirect" value="<%=redirect%>"/>
</liferay-portlet:actionURL>

<aui:form name="fm" method="post" action="<%=addImageFolderActionURL%>">
				
	<aui:select name="parentFolderId" label="select-parent-folder">				
		<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
					selected="<%=(parentFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>"
		/>					
		<%
		for(DLFolder dlFolder : dlFolderList){
		%>
			<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
						selected="<%=dlFolder.getFolderId() == parentFolderId%>"
						
			/>
		<%
			buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, parentFolderId);
		}
		%>					
	</aui:select>
	
	<aui:input name="folderName" >
		<aui:validator name="required"/>
	</aui:input>
						
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button name="cancelBtn" value="cancel"/>
	</aui:button-row>
</aui:form>

<aui:script>
	AUI().ready(function(A){
					
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
	});
</aui:script>