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
	long subFolderId  = ParamUtil.getLong(request, "subFolderId", 0L);
	List<FileEntry> fileEntries = null;
	if(subFolderId > 0){
		fileEntries = DLAppServiceUtil.getFileEntries(scopeGroupId, subFolderId);
	}
%>

<c:if test="<%=fileEntries != null%>">
<%
	for(FileEntry fileEntry:fileEntries){
		if(!SliderUtil.isCorrectImageMimeType(fileEntry.getMimeType())){
			continue;
		}
			
		String imageURL = SliderUtil.getImageURL(fileEntry, themeDisplay, SliderUtil.imageViewType.MIDIUM.toString(), true);
		%>
			<li class="gallery-item">
				<img src="<%=imageURL %>" alt="" title='<%=fileEntry.getTitle() %>'/>
				<i class="icon-trash remove-gallery-item inited" title="<%=LanguageUtil.get(locale, "remove") %>" onclick="<portlet:namespace />removeSliderImage(this,<%=fileEntry.getFileEntryId()%>)"></i>
				<i class="icon-ok-sign"></i>
				<input type="hidden" value="<%=fileEntry.getFileEntryId() %>" class="fileId" name="fileId" />
			</li>
		<%
	}
%>
</c:if>

