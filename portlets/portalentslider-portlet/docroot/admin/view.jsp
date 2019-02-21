<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>



<%@ include file="/init.jsp" %>

<%
	long folderId  = SliderUtil.getSliderImageFolderId(request);
		
	long userId = themeDisplay.getUserId();
		
	List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(scopeGroupId, folderId);
		
%>

<liferay-portlet:actionURL var="deleteImagesURL" name="deleteImages" doAsUserId="<%=userId %>">
	<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	<portlet:param name="redirect" value="<%=currentURL %>"/>
</liferay-portlet:actionURL>

<portlet:renderURL var="updateSliderDialog">
	<portlet:param name="jspPage" value="/admin/updateSlider.jsp"></portlet:param>
</portlet:renderURL>

<aui:form action="<%=deleteImagesURL.toString() %>" name="fm">
	<aui:button name="add" href="<%=updateSliderDialog.toString() %>" value="add-new" label="" onClick="updateSlider('<%=updateSliderDialog.toString() %>','update')" />
	<c:if test="<%=fileEntries != null && fileEntries.size() > 0 %>">
		<aui:input name="delete" type="submit" value="delete" label=""/>
		<ul class="list-slider-image">
			<%
				for(FileEntry entry: fileEntries){
					if(!SliderUtil.isCorrectImageMimeType(entry.getMimeType())){
						continue;
					}
					
					String imageURL = SliderUtil.getImageURL(entry, themeDisplay, SliderUtil.imageViewType.MIDIUM.toString(), true);
					
					PortletURL deleteFileEntry = renderResponse.createActionURL();
					deleteFileEntry.setParameter("fileEntryId", String.valueOf(entry.getFileEntryId()));
					deleteFileEntry.setParameter("redirect", String.valueOf(currentURL));
					deleteFileEntry.setParameter("javax.portlet.action", "deleteFileEntry");
					
					%>
						<li id="<%=entry.getFileEntryId()%>">
							<div class="image-item">
								<img alt="" src="<%=imageURL%>">
								<div class="text-item"><%=entry.getTitle() %></div>
							</div>
							<div class="delete-item">
								<a href="<%=deleteFileEntry.toString() %>" onclick="return confirm('<%=LanguageUtil.get(locale, "do-you-want-remove-this-image") %>')">
									<img src="<%=themeDisplay.getPathThemeImages()%>/common/delete.png">
								</a>
							</div>
							<div class="select-item">
								<aui:input name="selectItem" type="checkbox" label="" onChange="selectImage(this)"/>
							</div>
						</li>
					<%
				}
			%>
		</ul>	
	</c:if>
	<c:if test="<%=fileEntries == null || fileEntries.size() == 0 %>">
		<h1><liferay-ui:message key="no-found-slider"/></h1>
	</c:if>
	<aui:input name="selectedIds" value="" type="hidden" id="selectedIds"/>
</aui:form>

<aui:script>
	var selectedIds = [];
	Liferay.provide(window,
		'selectImage', function(e) {
			var A = AUI();
			var li = A.one(e).ancestor('li');
			var name = li.one('div.text-item');
			var checkbox = li.one('div.select-item');
			
			var fileEntryId = li.attr('id');
			
			if(A.one(e).get('checked') == true){
				li.setStyle('backgroundColor', '#00A2EA');
				name.setStyle('color', '#EDEDED');
				checkbox.setStyle('display', 'block');
				if(selectedIds.indexOf(fileEntryId) == -1){
					selectedIds.push(fileEntryId);
				}
			}else{
				li.setStyle('backgroundColor', '');
				name.setStyle('color', '#888888');
				checkbox.setStyle('display', '');
				selectedIds.splice(fileEntryId, 1);
			}
			
			A.one('#<portlet:namespace/>selectedIds').val(selectedIds.toString());
		}
	);
	
</aui:script>

<aui:script use="aui-base">

		Liferay.provide(
			window,
			'updateSlider',
			function(url, title) {
				var A = AUI();
				
					var config = {
							dialog: {
								align: Liferay.Util.Window.ALIGN_CENTER,
								modal: true,
								width: 800,
								cache: true
							},
						title: title,
						uri: url,
						id: '<portlet:namespace/>updateSlider'
					};
				Liferay.Util.openWindow(config);
			}
		);
</aui:script>
