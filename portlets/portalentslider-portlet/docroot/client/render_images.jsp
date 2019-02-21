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

<%@ include file="/init.jsp"%>

<%
	long folderId = ParamUtil.getLong(request, "folderId", 0L);
	List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(scopeGroupId, folderId);

	
%>

<c:if test="<%=fileEntries != null && fileEntries.size() > 0 %>">
	
	<ul class="cfg-list-slider-image">
		<%
			
			String fileEntriesIds = StringPool.BLANK; 
			
			for(FileEntry entry: fileEntries){
				if(!SliderUtil.isCorrectImageMimeType(entry.getMimeType())){
					continue;
				}
				
				String imageURL = SliderUtil.getImageURL(entry, themeDisplay, SliderUtil.imageViewType.MIDIUM.toString(), true);
				
				fileEntriesIds += entry.getFileEntryId() + ",";
				
				boolean selected = false;
				
				if(imageIds == null || imageIds.length == 0 || folderId != sliderId){
					selected = true;
				}else{
					selected = ArrayUtil.contains(imageIds, String.valueOf(entry.getFileEntryId()));
				}
				
				String itemCss = StringPool.BLANK;
				
				if(selected){
					itemCss = "cfg-slider-image-selected";
				}
				
				%>
					<li id="<%=entry.getFileEntryId()%>" class="<%=itemCss%>">
						<div class="cfg-image-item">
							<img alt="" src="<%=imageURL%>">
							<div class="cfg-text-item"><%=entry.getTitle() %></div>
						</div>
						<div class="cfg-select-item">
							<input name="<%="_86_" + entry.getFileEntryId() %>" type="checkbox" label="" onChange="selectImage(this)" id='<%="_86_" + entry.getFileEntryId() %>'
								title='<%=LanguageUtil.get(locale, "unselect-to-remove-this-image-from-slider") %>' <% if(selected){%> checked="checked" <%} %>/>
						</div>
					</li>
				<%
			}
		%>
	</ul>	
	<input name="_86_fileEntriesIds" type="hidden" value="<%=fileEntriesIds %>"/>
</c:if>

