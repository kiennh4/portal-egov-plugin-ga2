<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/init.jsp"%>

<%
	//Danh sach tat ca cac folder hien co trong document library
	List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

	int[] numbersOfImageDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30};
	
	List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
	
	String addButtonIcon = themeDisplay.getPathThemeImages() + "/common/add.png";
%>

<liferay-portlet:actionURL portletConfiguration="true" var="imageGalleryConfigURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL var="updateImageFolderURL" portletName="<%=portletResource %>">
	<liferay-portlet:param name="jspPage" value="/html/common/image-folder-update-form.jsp" />
	<liferay-portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request) %>"/>	
</liferay-portlet:renderURL>

<aui:form name="image_gallery_config_form" method="post" action="<%=imageGalleryConfigURL%>">
	<div class="portlet-config-form">
			
		<aui:select name="selectedImageFolderId" label="select-image-folder">				
			<aui:option value="<%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>" label="select" cssClass="root-folder"
						selected="<%=(selectedImageFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) %>"
			/>					
			<%
			for(DLFolder dlFolder : dlFolderList){
			%>
				<aui:option value="<%=dlFolder.getFolderId()%>" label="<%=dlFolder.getName() %>" cssClass="root-folder"
							selected="<%=dlFolder.getFolderId() == selectedImageFolderId%>"
							
				/>
			<%
				buildDLFolderTree(groupId, dlFolder.getFolderId(),1, out, selectedImageFolderId);
			}
			%>					
		</aui:select>
		
		<a id="<portlet:namespace />createFolderIcon" href="javascript:;"  title="<%=LanguageUtil.get(themeDisplay.getLocale(), "add") %>">
			<img class="icon" src="<%=addButtonIcon %>" alt="<%=LanguageUtil.get(themeDisplay.getLocale(), "add") %>"/>
		</a>
		
		<aui:select name="numbersOfImageDisplay">
			<aui:option label="all" value="-1" selected="<%=numbersOfImageDisplay == -1 %>"/>
			<%
			for(int numbersOfImageDisplayValue : numbersOfImageDisplayValues){
			%>
				<aui:option label="<%=String.valueOf(numbersOfImageDisplayValue) %>" value="<%=String.valueOf(numbersOfImageDisplayValue) %>" 
							selected="<%= numbersOfImageDisplay == numbersOfImageDisplayValue%>"/>
			<%
			}
			%>
		</aui:select>
		
		<aui:input type="checkbox" name="useThumbnailImage" label="use-thumbnail-image" value="<%= useThumbnailImage %>"/>
			
		<aui:input type="checkbox" name="useCustomImageSize" label="use-custom-image-size" value="<%= useCustomImageSize %>"/>
		
		<div id="<portlet:namespace />customImageSizePanel" class="aui-helper-hidden" style="padding-left: 15px;">		
			<aui:input type="text" name="imageThumbnailWidth" value="<%=imageThumbnailWidth %>"/>
			<aui:input type="text" name="imageThumbnailHeight" value="<%=imageThumbnailHeight %>"/>
		</div>
					
		<aui:input type="checkbox" name="displayGalleryLink" label="display-image-gallery-link" value="<%= displayGalleryLink %>"/>
		
		<div id="<portlet:namespace />displayGalleryLinkPanel" class="aui-helper-hidden" style="padding-left: 15px;">		
			<aui:select name="galleryPageId" label="image-gallery-page">
				<%
				for(Layout layout : groupLayoutList){
				%>
					<aui:option label="<%=layout.getName() %>" value="<%=layout.getPlid() %>" 
								selected="<%=galleryPageId == layout.getPlid() %>"/>
				<%
				}
				%>
			</aui:select>
		</div>
	</div>	
			
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button name="cancelBtn" value="cancel"/>
	</aui:button-row>
</aui:form>

<aui:script>

	AUI().ready('aui-base','liferay-portlet-url',function(A){
		
		var createFolderIcon = A.one('#<portlet:namespace />createFolderIcon');
		
		if(createFolderIcon){
		
			createFolderIcon.on('click',function(){
				
				var folderSelector = A.one('#<portlet:namespace />selectedImageFolderId');
				
				if(folderSelector){
					
					var parentFolderId = folderSelector.val();
									
					var updateFolderURL = Liferay.PortletURL.createRenderURL();
												
					updateFolderURL.setPortletId('<%=portletResource %>');
					updateFolderURL.setParameter('portletResource', '<%=portletResource %>');
					updateFolderURL.setWindowState('pop_up');
					updateFolderURL.setParameter('jspPage', '/html/common/image-folder-update-form.jsp');
					updateFolderURL.setParameter('parentFolderId', parentFolderId);
					updateFolderURL.setDoAsGroupId('<%=groupId %>');
					
					<portlet:namespace />addImageFolder(updateFolderURL);
				}
			});
		}
						
		var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
		
		if(closeConfigPageBtn){
			
			closeConfigPageBtn.on('click',function(){
				Liferay.Util.getWindow().close();
			});
		}
		
		Liferay.Util.toggleBoxes('<portlet:namespace />useCustomImageSizeCheckbox','<portlet:namespace />customImageSizePanel');
	
		Liferay.Util.toggleBoxes('<portlet:namespace />displayGalleryLinkCheckbox','<portlet:namespace />displayGalleryLinkPanel');
	});
	
		
	Liferay.provide(
		window,
		'<portlet:namespace />addImageFolder',
		function(url) {
		
			var A = AUI();
			
			var config = {
					dialog: {
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: 820,
						cache: false
					},
				uri: url
			};
			Liferay.Util.openWindow(config);
		}
	);
</aui:script>



