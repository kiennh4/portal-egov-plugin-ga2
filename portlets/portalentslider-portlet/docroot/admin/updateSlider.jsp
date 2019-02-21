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




<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>

<%@ include file="/init.jsp" %>

<%
	
	
	String resourceInstanceName = ParamUtil.getString(request,"resourceInstanceName");
	
	String configFrameName = StringPool.UNDERLINE + resourceInstanceName + StringPool.UNDERLINE + "configurationIframeDialog";
		
	long subFolderId = ParamUtil.getLong(request, "subFolderId", 0L);
		
	DLFolder subFolder = null;
	
	List<FileEntry> fileEntries = new ArrayList<FileEntry>();
	
	if(subFolderId > 0){
		subFolder = DLFolderLocalServiceUtil.getDLFolder(subFolderId);
		fileEntries = DLAppServiceUtil.getFileEntries(scopeGroupId, subFolderId);
	}
	
	boolean closeDialog = false;
	
	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

	if(SessionErrors.isEmpty(portletRequest) && !SessionMessages.isEmpty(portletRequest)){
		closeDialog = true;
	}
		
%>

<c:if test="<%=closeDialog%>">
	<aui:script use="aui-base">
		 closeAndRefreshPopup();
	</aui:script>
</c:if>

<liferay-portlet:actionURL var="updateSliderURL" name="updateSlider"  portletName="<%=sliderAdminPortletName %>">
	<liferay-portlet:param name="redirect" value="<%=currentURL %>"></liferay-portlet:param>
</liferay-portlet:actionURL>

<aui:form name="fmUpdateSlider" action="<%=updateSliderURL %>">
	<aui:input name="subFolderId" type="hidden" value="<%=subFolderId %>"/>
	<aui:input name="selectedIds" value="" type="hidden" id="selectedIds"/>
	<aui:fieldset label="">
		<liferay-ui:error key="<%=SliderUtil._ERROR_MSG01 %>" message="<%=SliderUtil._ERROR_MSG01 %>"/>
		<liferay-ui:error key="<%=SliderUtil._ERROR_MSG02 %>" message="<%=SliderUtil._ERROR_MSG02 %>"/>
		<liferay-ui:error key="<%=SliderUtil._ERROR_MSG03 %>" message="<%=SliderUtil._ERROR_MSG03 %>"/>
		<liferay-ui:success key="<%=SliderUtil._SUCCESS_MSG %>" message="<%=SliderUtil._SUCCESS_MSG %>"/>
		<aui:input name="sliderName" type="text" label="sliderName" id="sliderName" value="<%=subFolder != null? subFolder.getName():StringPool.BLANK %>"/>
	</aui:fieldset>
	
	<aui:fieldset label="">
		<liferay-util:include page="/common/uploadImages.jsp" servletContext="<%=application %>">
			<portlet:param name="resourceNamespace" value="<%=themeDisplay.getPortletDisplay().getNamespace() %>"></portlet:param>
		</liferay-util:include>
	</aui:fieldset>
	<aui:fieldset>
		<c:if test="<%=fileEntries != null && fileEntries.size() > 0 %>">
	
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
								<aui:input name="selectItem" type="checkbox" label="" onChange="selectImage(this)" title='<%=LanguageUtil.get(locale, "select-to-remove-image") %>'/>
							</div>
						</li>
					<%
				}
			%>
		</ul>	
		</c:if>
	</aui:fieldset>
	<aui:fieldset label="">
		<aui:button type="submit" value="save"/>
	</aui:fieldset>
</aui:form>

<aui:script>
	var selectedIds = [];
	Liferay.provide(window,
		'selectImage', function(e) {
			var A = AUI();
			var li = A.one(e).ancestor('li');
			var name = li.one('div.text-item');
			var checkbox = li.one('div.delete-item');
			
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
	AUI().ready('aui-base,aui-form-validator,aui-overlay-context-panel',function(A){
			
			
			var sliderName = A.one('#<portlet:namespace />sliderName');
			
			if(sliderName){
				sliderName.focus();
			}
			
					
			window.validator = new A.FormValidator({
		
		        boundingBox: document.<portlet:namespace />fmUpdateSlider,
		
		        rules: {
		         	<portlet:namespace />sliderName: {
			                required: true,
			                rangeLength: ['3','64']
			        }
	
		        }
		    });
	});
	
	Liferay.provide(
        window,
        'closeAndRefreshPopup',function() {
			var configDocument = parent.frames['<%=configFrameName%>'].document;
			configDocument.location.reload(true);
		    Liferay.Util.getWindow().close();
        }     
    );
	
</aui:script>