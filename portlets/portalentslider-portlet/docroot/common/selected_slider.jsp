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

<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="/init.jsp"%>

<%
	long folderId = ParamUtil.getLong(request, "folderId", 0L);
	List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(scopeGroupId, folderId);
	
	String sliderItemStr = preferences.getValue("sliderItems", "");
	
	JSONArray sliderItemJSON = null;
	
	if (!Validator.equals(sliderItemStr, ""))
	{
		sliderItemJSON = JSONFactoryUtil.createJSONArray(sliderItemStr);
	}
	
%>

<c:if test="<%=fileEntries != null && fileEntries.size() > 0 %>">
	
	<%
	
		for(FileEntry entry: fileEntries){
			if(!SliderUtil.isCorrectImageMimeType(entry.getMimeType())){
				continue;
			}
			
			String url_ = "";
			boolean isSelected = false;
			
			if (sliderItemJSON!=null)
			{
				for (int i = 0; i < sliderItemJSON.length();i++)
				{
					if (entry.getFileEntryId()==sliderItemJSON.getJSONObject(i).getLong("imageId"))
					{
						isSelected = true;
						url_ = sliderItemJSON.getJSONObject(i).getString("url");
					}
				}
			}
				
			String imageURL = SliderUtil.getImageURL(entry, themeDisplay, SliderUtil.imageViewType.MIDIUM.toString(), true);
			
			if (isSelected)
			{
				%>
					<li id="<%=entry.getFileEntryId()%>" class="cfg-slider-image">
						<i class="cfg-icon-trash" onclick="removeItem(this);" title="remove-this-image-from-slider"></i>
						<div class="cfg-image-item">
							<img alt="" src="<%=imageURL%>">
						</div>
						<aui:input name='<%=entry.getFileEntryId() + "_redirectURL" %>' id='<%=entry.getFileEntryId() + "_redirectURL" %>' type="text" value = "<%=url_%>" label=""  placeholder="redirect-url"/>
						<aui:input name="fileId" type="hidden" label="" value="<%=entry.getFileEntryId() %>"/>
					</li>
				<%
			}
			else
			{
				%>
				<li id="<%=entry.getFileEntryId()%>" class="cfg-slider-image">
					<i class="cfg-icon-trash add" title="add-this-image-to-slider" onclick="addItem(this);"></i>
					<div class="cfg-image-item">
						<img alt="" src="<%=imageURL%>">
					</div>
					<aui:input name='<%=entry.getFileEntryId() + "_redirectURL" %>' id='<%=entry.getFileEntryId() + "_redirectURL" %>' type="text" value = "<%=url_%>" label=""  placeholder="redirect-url"/>
					<aui:input name="fileId" type="hidden" label="" value="<%=entry.getFileEntryId() %>"/>
					<div class="unselected-overlay"></div>
				</li>
			<%
			}
		}
	%>
</c:if>

