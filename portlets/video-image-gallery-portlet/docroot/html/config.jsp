<%@page import="com.bkav.portal.portlet.video.service.VideoCategoryLocalServiceUtil"%>
<%@page import="com.bkav.portal.portlet.video.model.VideoCategory"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@include file = "/html/init.jsp" %>

<%
	String tabNames = "image-gallery,video-gallery";
	String  tabs1 = ParamUtil.getString(request,"tabs1","image-gallery");
	
%>

<liferay-portlet:renderURL var="defaultGalleryURL" >
	<liferay-portlet:param name="jspPage" value="/html/config.jsp"/>
</liferay-portlet:renderURL>

<div class = "video-image-config">
<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" >
	<liferay-portlet:param  name="portletResource" value="<%=portletResource%>"/>
</liferay-portlet:actionURL>
<aui:form name="fm" method="post" action="<%=configurationActionURL %>">

	<div class = "image-config">
		<liferay-ui:message key="image-gallery-config"/>
		<%
			//Danh sach tat ca cac folder hien co trong document library
			List<DLFolder> dlFolderList = DLFolderLocalServiceUtil.getFolders(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
			int[] numbersOfImageDisplayValues = {1,2,3,4,5,6,7,8,9,10,15,20,30};
			
			List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
			
			String addButtonIcon = themeDisplay.getPathThemeImages() + "/common/add.png";
		%>
		
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
	</div>
	
	<hr>
	
	<div class = "video-config">
		<liferay-ui:message key="video-gallery-config"/>
		<%
			String[] numbersOfEntriesDisplayValues = {"1","2","3","4","5","6","7","8","9","10","15","20","30","40","50"};
			//List<Layout> groupLayoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
		
			List<VideoCategory> listCategory = VideoCategoryLocalServiceUtil.findByGroup(groupId);	
		
		%>
		
		<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
		
		<div class="portlet-msg-info"><liferay-ui:message key="only-gallery-style-can-be-show-all-categories"/> </div>
		
			<div class="portlet-config-form">		
			
<!-- 				<div class="lfr-form-row"> -->
<!-- 					<div class="row-fields"> -->
<%-- 						<aui:select name="displayStyle" label="display-style" inlineLabel="left"> --%>
<%-- 							<aui:option label="default-style" value="default-style"  --%>
<%-- 										selected='<%=Validator.equals(displayStyle, "default-style") %>'/> --%>
<%-- 							<aui:option label="gallery-style" value="gallery-style"  --%>
<%-- 										selected='<%=Validator.equals(displayStyle, "gallery-style") %>'/> --%>
<%-- 							<aui:option label="slider-style" value="slider-style"  --%>
<%-- 										selected='<%=Validator.equals(displayStyle, "slider-style") %>'/> --%>
<%-- 						</aui:select> --%>
						
<%-- 						<aui:input name="styleTitle" value="<%=styleTitle %>"/> --%>
<!-- 					</div> -->
<!-- 				</div> -->
				
				<div class="lfr-form-row">
					<div class="row-fields">
						<aui:select name="videoCategory" label="display-category" inlineLabel="left">
							<c:choose>
								<c:when test="<%=(listCategory.size()>0) %>">
									<%
										for (int i = 0; i < listCategory.size();i++)
										{
									%>
										<aui:option label = "<%=listCategory.get(i).getCategoryName() %>" 
													value = "<%=listCategory.get(i).getCategoryId() %>"
													selected = "<%=Validator.equals(listCategory.get(i).getCategoryId(), categoryId) %>"	
										/>
									<%
										}
									%>
									<aui:option label = "all" value = "0" cssClass = "categoryStyleDefault" 
									style = '<%=(Validator.equals(displayStyle, "gallery-style")) ? "display:block" : "display:none" %>' />
								</c:when>
								<c:otherwise>
									<aui:option  label = "no-category" value = "0L"/>
								</c:otherwise>
							</c:choose>
						</aui:select>
					</div>
				</div>
					
				<div class="lfr-form-row">
					<div class="row-fields">
						<aui:select name="numbersOfVideoDisplay" label="total-video-display" inlineLabel="left">
							<%
							for(int i = 0;i < numbersOfEntriesDisplayValues.length; i++)
							{
								int numbersOfEntriesDisplayValue = GetterUtil.getInteger(numbersOfEntriesDisplayValues[i]);
							%>
								<aui:option label="<%= String.valueOf(numbersOfEntriesDisplayValue)%>" value="<%= String.valueOf(numbersOfEntriesDisplayValue)%>"
											selected='<%= numbersOfVideoDisplay == numbersOfEntriesDisplayValue %>'/>
							<%
							}
							%>
							<aui:option label="all" value="-1" selected="<%=numbersOfVideoDisplay == -1 %>"/>
						</aui:select>
					</div>
				</div>
				
				<div class="lfr-form-row">
					<div class="row-fields">
						<aui:input type="checkbox" name="useCustomVideoFrameSize" value="<%=useCustomVideoFrameSize %>"/>
						
						<div id="<portlet:namespace />frameSizeSettingContainer" class="aui-helper-hidden">
							<aui:input name="videoFrameHeight" value="<%=videoFrameHeight %>">
								<aui:validator name="digits"/>
							</aui:input>
											
							<aui:input name="videoFrameWidth" value="<%=videoFrameWidth %>">
								<aui:validator name="digits"/>
							</aui:input>
						</div>
					</div>
				</div>
						
				<div class="lfr-form-row">
					<div class="row-fields">
									
						<aui:input type="checkbox" name="showVideoThumbnail" value="<%=showVideoThumbnail %>"/>
						
						<aui:input type="checkbox" name="showVideoPublishDate" value="<%=showVideoPublishDate %>"/>
						
						<aui:input type="checkbox" name="showViewMoreVideoLink" value="<%=showViewMoreVideoLink %>"/>
						
						<div id="<portlet:namespace />videoPageSelectorContainer" class="aui-helper-hidden">
					
							<aui:select name="videoPageLayoutId" label="display-video-on-page">
								<%
								for(Layout layout : groupLayoutList){
								%>
									<aui:option label="<%=layout.getName() %>" value="<%=layout.getPlid() %>" 
												selected="<%=videoPageLayoutId == layout.getPlid() %>"/>
								<%
								}
								%>
							</aui:select>
						</div>
					</div>
				</div>
				
			</div>
		
		<aui:script>
			Liferay.Util.toggleBoxes('<portlet:namespace />useCustomVideoFrameSizeCheckbox','<portlet:namespace />frameSizeSettingContainer');
			Liferay.Util.toggleBoxes('<portlet:namespace />showViewMoreVideoLinkCheckbox','<portlet:namespace />videoPageSelectorContainer');
		</aui:script>
		
		<aui:script>
			AUI().ready(function(A){
				
				var closeConfigPageBtn = A.one('#<portlet:namespace/>cancelBtn');
				
				var displayStyleSelect = A.one('#<portlet:namespace/>displayStyle');
				
				if (displayStyleSelect)
				{
					displayStyleSelect.on('change',function(){
						var displayStyle = displayStyleSelect.attr('value');
						if (displayStyle == 'gallery-style')
						{
							A.one ('.categoryStyleDefault').setStyle ("display","block");
						}
						else
						{
							A.one ('.categoryStyleDefault').setStyle ("display","none");
							document.getElementById("<portlet:namespace/>videoCategory").selectedIndex = -1;
						}
						
					});
				}
				
				if(closeConfigPageBtn){
					
					closeConfigPageBtn.on('click',function(){
						Liferay.Util.getWindow().close();
					});
				}
			});
		</aui:script>
	</div>
	<aui:button-row>
		<aui:button type="submit" value="save"/>
		<aui:button name="cancelBtn" value="cancel"/>
	</aui:button-row>
	
</aui:form>
</div>