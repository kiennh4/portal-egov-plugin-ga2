<%@page import="com.liferay.portlet.documentlibrary.DuplicateFolderNameException"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<%
String taglibOnSubmit = "event.preventDefault(); " + renderResponse.getNamespace() + "addVideoFolder();";	

List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
%>

<liferay-ui:error exception="<%=DuplicateFolderNameException.class %>" message="duplicate-folder-name"/>

<liferay-portlet:actionURL name="addVideoFolder" var="addVideoFolderActionURL" />

<div class="video-update-form">
	<aui:form name="fm"  method="post" action="<%=addVideoFolderActionURL%>" onSubmit="<%=taglibOnSubmit %>">	
		
		<aui:select name="parentFolderId" label="select-parent-folder">				
			<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="root-folder"
			/>					
			<%
			for(DLFolder dlFolder : dlFolderList){
				
			%>
				<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>"/>
				
			<%
				buildDLFolderTree(groupId, dlFolder.getFolderId(), 1, out, 0L);
			}
			%>					
		</aui:select>
		
		<aui:input name="videoFolderName"/>
				
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button name="closeFormBtn" value="cancel"/>
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
	AUI().ready('aui-loading-mask', 'aui-io-request',function(A){
	
		var closeFormBtn = A.one('#<portlet:namespace/>closeFormBtn');
		
		if(closeFormBtn){
			
			closeFormBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
				
		Liferay.provide(
			window,
			'<portlet:namespace />addVideoFolder',
			function() {
				
				var formContainer = A.one('#<portlet:namespace />fm');
				
				formContainer.plug(A.LoadingMask, { background: '#d2d2d2' });
				
				formContainer.loadingmask.toggle();
				
				A.io.request(
					document.<portlet:namespace />fm.action,
					{
						dataType: 'html',
						form: {
							id: document.<portlet:namespace />fm
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
	});			
</aui:script>