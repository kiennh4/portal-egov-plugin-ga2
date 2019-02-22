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



<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp" %>

<%
	long folderId  = SliderUtil.getSliderImageFolderId(request);
	List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, folderId);
	String editButtonIcon = themeDisplay.getPathThemeImages() + "/common/edit.png";
	String deleteButtonIcon = themeDisplay.getPathThemeImages() + "/common/delete.png";
%>
<liferay-portlet:renderURL var="selectSliderURL" portletName="<%=SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/common/slider_images.jsp"></liferay-portlet:param>	
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="deleteSliderURL" portletName="<%=SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>" name="deleteSlider">
	<liferay-portlet:param name="redirect" value="<%=currentURL %>"></liferay-portlet:param>	
</liferay-portlet:actionURL>

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="addURL" portletName="<%= SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
	<portlet:param name="mvcPath" value="/common/add_slider.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="editURL" portletName="<%= SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
	<portlet:param name="mvcPath" value="/common/edit_slider.jsp" />
</liferay-portlet:renderURL>
	
<liferay-portlet:actionURL var="updateSliderURL" name="updateSlider"  portletName="<%=SliderUtil.SLIDER_ADMIN_PORTLET_NAME %>">
	<liferay-portlet:param name="redirect" value="<%=editURL %>"></liferay-portlet:param>
	<liferay-portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>"></liferay-portlet:param>
</liferay-portlet:actionURL>

<aui:field-wrapper label="manager-sliders" helpMessage="guide-manager-sliders">
	<div class="taglib-header"></div>
	<div class="manager-slider-container">
	<aui:layout>
		<c:choose>
			<c:when test="<%=folders == null || folders.isEmpty() %>">
				<aui:column columnWidth="100">
					<div class="portlet-msg-info">
						<a href="javascript:void(0);" onclick="<portlet:namespace/>addSliderDialog()"><liferay-ui:message key="no-slider-were-found"/></a>
					</div>
				</aui:column>
			</c:when>
			<c:otherwise>
				<aui:column columnWidth="20">
					<ul>
						<%
							if(folders != null && !folders.isEmpty()){
								for(DLFolder folder:folders){
									%>
										<li class="slider-item" id="<portlet:namespace/><%=folder.getFolderId()%>">
											<span class="slider-name">
												<%=folder.getName() %>
											</span>
											<span class="slider-control">	
												<a href="#"  title="<%=LanguageUtil.get(themeDisplay.getLocale(), "delete") %>" onclick="<portlet:namespace/>deleteSlider(<%=folder.getFolderId()%>)">
													<img class="icon" src="<%=deleteButtonIcon %>" alt="<%=LanguageUtil.get(themeDisplay.getLocale(), "delete") %>"/>
												</a>
											</span>
											<input class="sliderId" name="sliderId" value="<%=folder.getFolderId()%>" type="hidden"/>
											<input class="sliderName" name="sliderName" value="<%=folder.getName()%>" type="hidden"/>
										</li>
									<%
								}
							}
						%>
					</ul>
				</aui:column>
				<aui:column columnWidth="80">
					<aui:form name="fmUpdateSlider" action="<%=updateSliderURL %>" >
						<aui:field-wrapper cssClass="slider-content aui-helper-hidden">
						<aui:fieldset label="">
							<liferay-ui:error key="<%=SliderUtil._ERROR_MSG01_KEY %>" message="<%=SliderUtil._ERROR_MSG01 %>"/>
							<liferay-ui:error key="<%=SliderUtil._ERROR_MSG02_KEY %>" message="<%=SliderUtil._ERROR_MSG02 %>"/>
							<liferay-ui:error key="<%=SliderUtil._ERROR_MSG03_KEY %>" message="<%=SliderUtil._ERROR_MSG03 %>"/>
							<liferay-ui:success key="<%=SliderUtil._SUCCESS_MSG02_KEY %>" message="<%=SliderUtil._SUCCESS_MSG02 %>"/>
						</aui:fieldset>
						
						<aui:fieldset label="">
							<liferay-util:include page="/common/uploadImages.jsp" servletContext="<%=application %>">
								<portlet:param name="resourceNamespace" value="<%=themeDisplay.getPortletDisplay().getNamespace() %>"/>
								<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>"/>
							</liferay-util:include>
						</aui:fieldset>
						<aui:fieldset>
							
						</aui:fieldset>
						<aui:fieldset label="">
							<aui:input name="<%=com.liferay.portal.kernel.util.Constants.CMD %>" id="<%=Constants.CMD %>" type="hidden" value=""/>
							<aui:input name="subFolderId" id="subFolderId" value="" type="hidden"/>
							<aui:button name="saveBtn" value="save" type="submit"/>
						</aui:fieldset>
						</aui:field-wrapper>
					</aui:form>
				</aui:column>
			</c:otherwise>
		</c:choose>
		
	</aui:layout>
	
	</div>
</aui:field-wrapper>
<aui:script>
	AUI().ready(function(){
		var A  = AUI();
		var sliderItems = A.all('.slider-item');
		if(sliderItems){
			sliderItems.each(function(item, index){
				var sliderId = item.one('.sliderId').val();
				var sliderName = item.one('.sliderName').val();
				if(index == 0){
					<portlet:namespace/>selectSlider(sliderId, sliderName);
					item.addClass('selected-slider');
				}
				
				item.on('click', function(e){
					A.all('.slider-item').removeClass('selected-slider');
					<portlet:namespace/>selectSlider(sliderId, sliderName);
					item.addClass('selected-slider');
				});
				
			});
		}
	});
	
	Liferay.provide(
		window,
		'<portlet:namespace/>deleteSlider',
		function(folderId) {
			if(confirm('<%=LanguageUtil.get(locale, "are-you-sure-delete-this-slider") %>')){
				var A = AUI();
				var url = '<%=deleteSliderURL.toString() %>';
				
				var item = A.one('#<portlet:namespace/>' + folderId);
				if(item){
					item.plug(A.LoadingMask);
					item.loadingmask.show();
				}
				
				if(parseInt(folderId) <= 0){
					return;
				}else{
					
					A.io.request(
					url,
						{
							dataType: 'json',
								
							data: {
								folderId: folderId
							},
							
							on: {
								
								success: function(event, id, obj) {
									var jsonObject = this.get('responseData');
																		
									var errorMsg = jsonObject.error;	
					 	
								 	if(errorMsg !=null){
								 		alert(errorMsg);
	
								 	}else{
								 		item.remove();
										var firstSlider = A.one('.slider-item');
										if(firstSlider){
											var sliderId = firstSlider.one('.sliderId').val();
											var sliderName = firstSlider.one('.sliderName').val();
										
											<portlet:namespace/>selectSlider(sliderId, sliderName);
											firstSlider.addClass('selected-slider');
										}else{
											 Liferay.Util.getWindow().close();
										}
								 	}
										
									item.loadingmask.hide();								
								},
								failure: function(event, id, obj) {
									item.loadingmask.hide();
								}
							}
						}
					);
				}
			}
		},
		['aui-base','aui-io','aui-io-request']
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace/>selectSlider',
		function(subFolderId, sliderName) {
			var A = AUI();
			
			var url = '<%=selectSliderURL %>';
				
			var item = A.one('.slider-content');
			
			var subFolderIdInput = A.one('#<portlet:namespace/>subFolderId'); 
			
			var sliderNameInput = A.one('#<portlet:namespace/>sliderName');
			
			if(item){
				item.toggleClass('aui-helper-hidden');
				item.show();
				item.plug(A.LoadingMask);
				item.loadingmask.show();
			}
				
			if(parseInt(subFolderId) <= 0){
				return;
			}else{
					
				A.io.request(
				url,
					{
						dataType: 'html',
								
						data: {
							subFolderId: subFolderId
						},
							
						on: {
								
							success: function(event, id, obj) {
								var data = this.get('responseData');
								var sliderImagesContainer = A.one('.slider-images');
								
								subFolderIdInput.val(subFolderId);
								sliderNameInput.val(sliderName);
								
								if(sliderImagesContainer){
									sliderImagesContainer.empty();
									sliderImagesContainer.append(data);
								}								
	
								item.loadingmask.hide();								
							},
							failure: function(event, id, obj) {
								item.loadingmask.hide();
							}
						}
					}
				);
			}
		},
		['aui-base','aui-io','aui-io-request']
	);
	
	
	Liferay.provide(
			window,
			'<portlet:namespace/>addSliderDialog',
			function() {
			var A = AUI();
			
			Liferay.Util.openWindow({
				dialog: {
					align: Liferay.Util.Window.ALIGN_CENTER, width: 600, modal: true
				},
				id: 'add-slider',
				title: 'add-slider',
				uri:'<%=addURL %>',
				cache: false,
				resizeable: false,
				dialogSubmitButton: true
			});
			Liferay.Util.getWindow().close();
		},['aui-base']
	);	
	
</aui:script>