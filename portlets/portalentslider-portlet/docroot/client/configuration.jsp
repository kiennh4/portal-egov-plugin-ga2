
<%@include file="/init.jsp"%>

<%
	//String addButtonIcon = themeDisplay.getPathThemeImages() + "/common/add.png";
	//String editButtonIcon = themeDisplay.getPathThemeImages() + "/common/edit.png";
	//String deleteButtonIcon = themeDisplay.getPathThemeImages() + "/common/delete.png";
	long folderId  = SliderUtil.getSliderImageFolderId(request);
	List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(scopeGroupId, folderId);
	
	List<FileEntry> fileEntries = null;
	
	if(sliderId > 0){
		fileEntries = DLAppServiceUtil.getFileEntries(scopeGroupId, sliderId);
	}
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<liferay-portlet:renderURL var="selectedSliderURL" portletName="<%=portletResource %>" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/common/selected_slider.jsp"></liferay-portlet:param>
</liferay-portlet:renderURL>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<div class="slider-config-wrapper">
		<liferay-ui:panel-container>
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="selected-images" persistState="<%= true %>" title="selected-images">
				<aui:fieldset>
					<aui:select name="sliderId" onChange="changeSlider();" label="select-slider" id="sliderName">
						<aui:option value="-1" ><liferay-ui:message key="select-slider"/></aui:option>
							<%
								if(folders != null && !folders.isEmpty()){
									for(DLFolder folder:folders){
										%>
											<aui:option value="<%=folder.getFolderId() %>" selected="<%=sliderId == folder.getFolderId()? true:false%>">
												<%=folder.getName() %>
											</aui:option>
										<%
									}
								}
							%>		
					</aui:select>
				</aui:fieldset>			
				<aui:fieldset>
					<ul id="<%=portletResource%>images" class="cfg-list-slider-image"></ul>
					<ul id="<%=portletResource%>unselectedImages" class="cfg-list-slider-image-unselected"></ul>
					
				</aui:fieldset>
			</liferay-ui:panel>
			
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="display-style" persistState="<%= true %>" title="display-style">
			<%
				String[] styles = PortletPropsValues.SLIDER_STYLE;
			%>
				<div class="display-settings">
					<aui:select name="sliderStyle" label="select-slider-style">
						<%
							for(String style:styles){
								%>
									<aui:option value="<%=style %>" selected="<%=style.equals(sliderStyle) %>"><liferay-ui:message key="<%=style%>"/></aui:option>
								<%
							}
						%>
					</aui:select>
					<aui:input name="sliderWidth" label="slider-width" type="text" value="<%=sliderWidth %>">
						<aui:validator name="digits" />
			
						<aui:validator name="min">'100'</aui:validator>
										
						<aui:validator name="max">'2000'</aui:validator>
					</aui:input>
					<aui:input name="sliderHeight" label="slider-height" type="text" value="<%=sliderHeight %>">
						<aui:validator name="digits" />
			
						<aui:validator name="min">'100'</aui:validator>
										
						<aui:validator name="max">'2000'</aui:validator>
					</aui:input>
					<%-- <aui:input name="auto" type="checkbox" value="<%=auto %>" label="auto-start"/> --%>

					<aui:input name="durationTimeout" label="slider-duration-timeout" type="text" value="<%=durationTimeout %>">
						<aui:validator name="digits" />
			
						<aui:validator name="min">'50'</aui:validator>
										
						<aui:validator name="max">'60000'</aui:validator>
					</aui:input>
					
					<aui:input name="duration" label="slider-duration" type="text" value="<%=duration %>">
						<aui:validator name="digits" />
			
						<aui:validator name="min">'50'</aui:validator>
										
						<aui:validator name="max">'60000'</aui:validator>
					</aui:input>
				</div>
			</liferay-ui:panel>	
		</liferay-ui:panel-container>
	</div>

	<div class="aui-button-holder">
		<aui:button type="submit" value="save"/>
	</div>
	<aui:input name="selectedIds" value="" type="hidden" id="selectedIds"/>
</aui:form>

<aui:script use="aui-base">
	
	var selectedIds = [];
	
	AUI().ready(function(A){
	
		var folderId = A.one('#<portlet:namespace/>sliderName').val();
		if(parseInt(folderId) <= 0){
		}else{
			changeSlider();
		}
	});
	
	Liferay.provide(window,
		'selectImage', function(e) {
			var A = AUI();
			var li = A.one(e).ancestor('li');
			var name = li.one('div.cfg-text-item');
			var checkbox = li.one('div.cfg-select-item');
			
			var fileEntryId = li.attr('id');
			
			if(A.one(e).get('checked') == true){
				li.setStyle('backgroundColor', '#00A2EA');
				li.setStyle('borderRadius', '3px');
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
	
	Liferay.provide(
		window,
		'changeSlider',
		function() {
			var A = AUI();
			var folderId = A.one('#<portlet:namespace/>sliderName').val();
			var url = '<%=selectedSliderURL.toString() %>';
			var renderArea = A.one('#<%=portletResource%>images');
			if(parseInt(folderId) <= 0){
			
				renderArea.empty();
			}else{
				
				A.io.request(
				url,
					{
						dataType: 'html',
							
						data: {
							folderId: folderId
						},
						
						on: {
							
							success: function(data) {
								
								renderArea.html(this.get('responseData'));
								
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
		'addItem',
		function(item) {
			var A = AUI();
			var parent = A.one(item).get('parentNode');
			var selectedImages = A.one('#<%=portletResource%>images');
			parent.plug(A.LoadingMask);
			parent.loadingmask.show();
			parent.remove();
			var iconTrash = parent.one('i.cfg-icon-trash');
			if(iconTrash){
				iconTrash.remove();
				var addItem = '<i class="cfg-icon-trash" title="remove-this-image-from-slider" onclick="removeItem(this);"></i>'
				parent.append(addItem);
			}
			var unselectedOverlay  = parent.one('div.unselected-overlay');
				
			unselectedOverlay.remove();
			
			parent.all('input').each(function(item){
				var name = item.attr('name');
				name = name.replace('_unselected', '');
				
				var id = item.attr('id');
				id = id.replace('_unselected', '');
				
				item.attr('name', name);
				item.attr('id', name);
				
			});
			selectedImages.append(parent);
			parent.loadingmask.hide();
		}
	);
	
	Liferay.provide(
		window,
		'removeItem',
		function(item) {
			var A = AUI();
			var parent = A.one(item).get('parentNode');
			var unselectedImages = A.one('#<%=portletResource%>unselectedImages');
			if(confirm('<%=LanguageUtil.get(locale, "do-you-want-to-delete-this-image-from-slide") %>')){
				parent.plug(A.LoadingMask);
				parent.loadingmask.show();
				parent.remove();
				var iconTrash = parent.one('i.cfg-icon-trash');
				if(iconTrash){
					iconTrash.remove();
					var addItem = '<i class="cfg-icon-trash add" title="add-this-image-to-slider" onclick="addItem(this);"></i>'
					parent.append(addItem);
				}
				var unselectedOverlay  = '<div class="unselected-overlay"></div>'
				
				parent.append(unselectedOverlay);
				parent.all('input').each(function(item){
					var name = item.attr('name');
					var id = item.attr('id');
					item.attr('name', name + '_unselected');
					item.attr('id', name + '_unselected');
				});
				unselectedImages.append(parent);
				parent.loadingmask.hide();
			}
		}
	);
	
	
	
	AUI().use('sortable', function(A) {
		var sortable = new A.Sortable({
			container: '#'+ '<%=portletResource %>' + 'images',
			nodes: 'li',
			opacity: '.1'
		});
	});
	
	
</aui:script>


<%!
	private static Log _log = LogFactoryUtil.getLog("configuration.jsp");
%>