

<%@ include file="/init.jsp" %>

<%

long folderId  = SliderUtil.getSliderImageFolderId(request);

long userId = themeDisplay.getUserId();

String[] tempFileEntries = SliderUtil.getTempFileEntries(scopeGroupId, folderId, SliderAdminAction.class.getName());

Date fileExpirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);

Ticket ticket = TicketLocalServiceUtil.addTicket(themeDisplay.getCompanyId(), User.class.getName(),
		themeDisplay.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, fileExpirationDate, new ServiceContext());

String resourceNamespace = ParamUtil.getString(request, "resourceNamespace"); 
%>


<liferay-portlet:actionURL var="addTempImagesURL" name="addTempImages" doAsUserId="<%=userId %>" portletName="<%=sliderAdminPortletName %>">
	<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	<portlet:param name="resourceNamespace" value="<%= resourceNamespace %>" />
</liferay-portlet:actionURL>
			
<liferay-portlet:actionURL doAsUserId="<%= userId %>" var="deleteTempImagesURL" name="deleteTempImages" portletName="<%=sliderAdminPortletName %>">
	<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
	<portlet:param name="resourceNamespace" value="<%= resourceNamespace %>" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL  var="uploadImagesURL" name="uploadImages" portletName="<%=sliderAdminPortletName %>">
	<portlet:param name="redirect" value="<%=currentURL %>"/>
	<portlet:param name="resourceNamespace" value="<%= resourceNamespace %>" />
</liferay-portlet:actionURL>
	
	<aui:input type="hidden" name="folderId" value="<%=folderId %>" />
	<aui:input type="hidden" name="resourceNamespace" value="<%=resourceNamespace %>" />
	
	<div id="<portlet:namespace />uploadSliderImages" class="slider-gallery">
		<noscript>
			<p>Please enable JavaScript to use file uploader.</p>
		</noscript>
		<div class="qq-uploader aui-helper-hidden">
			<div class="qq-upload-drop-area"><span>{dragText}</span></div>
			<div class="qq-upload-button"><i class="icon-upload icon-white"></i> {uploadButtonText}</div>
			<ul class="product-images qq-upload-list">
				<c:if test="<%=tempFileEntries != null %>">
					<%
					for(String tempFileName : tempFileEntries){
						String base46 = SliderUtil.encodeTempFileToBase64(themeDisplay.getUserId(), tempFileName);
						
					%>
						<li class="gallery-item">
							<img src='<%="data:image/jpeg;base64," + base46 %>' alt="" title='<%=LanguageUtil.get(locale, "temporary-image") %>'/>
							<i class="icon-trash remove-gallery-item inited" title="<%=LanguageUtil.get(locale, "remove") %>" onclick="<portlet:namespace />remove(this)"></i>
							<i class="icon-ok-sign"></i>
							<input type="hidden" value="<%=tempFileName %>" class="fileName" name="fileName" />
						</li>
					<%	
					}
					%>
				</c:if>
			</ul>
		</div>
	</div>
	
	<div class="qq-upload-extra-drop-area aui-helper-hidden">Drop files here too</div>
	
	<span id="<portlet:namespace />selectedFileNameContainer">
		<aui:input id="selectedFileNames" type="hidden" 
			value="<%=tempFileEntries != null ? StringUtil.merge(tempFileEntries) : StringPool.BLANK %>" name="selectedFileNames" />
	</span>





<aui:script use="aui-base,aui-io,aui-io-request"> 

	var countImage = 0;
	
	var A = AUI();
		 	
	var Lang = A.Lang;
	
	var selectedFileNameContainer = A.one('#<portlet:namespace />selectedFileNameContainer');
	
	var selectedFileNames = A.one('#<portlet:namespace />selectedFileNames');
	
	var fileNames = [];

	var UploadImageUtil = {
		createUploader: function(){
		
			var inputTpl = '<input name="<portlet:namespace />selectedFileName" type="hidden" value="{0}" />';
		
			var uploader = new qq.FileUploader({

				element: document.getElementById('<portlet:namespace />uploadSliderImages'),
                action: '<%=addTempImagesURL %>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= com.liferay.portlet.documentlibrary.model.DLFileEntryConstants.getClassName() %>" />',
                debug: false,
                allowedExtensions: ['jpg','jpeg','png'],
                sizeLimit: 15000000,
                minSizeLimit: 0,
                maxConnections: 2,
	            
	            onComplete: function(id, fileName, responseJSON){
	            	if(responseJSON.success && selectedFileNameContainer){
	            	
	            		var responseFileName = responseJSON.responseFileName;
	            		
	            		
	            		fileNames = selectedFileNames.val().split(',');
	            		
	            		fileNames.push(responseFileName);
						
						selectedFileNames.val(fileNames);
						
	            		var inputName = A.one('#' + this.inputName + countImage);
	            		
	            		if(inputName){
	            			inputName.set('value', responseFileName);
	            			countImage ++;
	            		}
	            	}else {
	            	
	            		<!-- alert(responseJSON.errorMessage); -->
	            	}
	            },
	            
	            messages: {
	                typeError: "Unfortunately the file(s) you selected weren't the type we were expecting. Only {extensions} files are allowed.",
	                sizeError: "{file} is too large, maximum file size is {sizeLimit}.",
	                minSizeError: "{file} is too small, minimum file size is {minSizeLimit}.",
	                emptyError: "{file} is empty, please select files again without it.",
	                onLeave: "The files are being uploaded, if you leave now the upload will be cancelled."            
	            },

				inputName: 'fileName',

				extraDropzones: [qq.getByClass(document, 'qq-upload-extra-drop-area')[0]],

				uploadButtonText: '<%=LanguageUtil.get(locale, "choose-images") %>',
				cancelButtonText: '<%=LanguageUtil.get(locale, "cancel") %>',

				template: A.one('#<portlet:namespace />uploadSliderImages .qq-uploader').removeClass('aui-helper-hidden').get('outerHTML'),

				fileTemplate: '<li class="gallery-item">' +
						'<i class="icon-trash remove-gallery-item" onclick="<portlet:namespace />remove(this)"></i>' +
						'<i class="icon-ok-sign"></i>' +
						'<img src="" id="" alt="" title="<%=LanguageUtil.get(locale, "set-image-as-default") %>"/>' +
						'<span class="qq-progress-bar"></span>' +
						'<span class="qq-upload-file aui-helper-hidden"></span>' +
						'<span class="qq-upload-spinner"></span>' +
						'<span class="qq-upload-size aui-helper-hidden"></span>' + 
						'<a class="qq-upload-cancel" href="#">{cancelButtonText}</a>' +
						'<span class="qq-upload-failed-text">{failUploadtext}</span>' +
						'<input type="hidden" value="" class="fileName" name="fileName" />'+
					'</li>' 
			});
		},
	};

	UploadImageUtil.createUploader();
	
	AUI().all('.gallery-item').each(function(node){
		node.on('click', function(e){
			AUI().all('.gallery-item').removeClass('selected');
			
			var item = e.currentTarget;
			item.addClass('selected');
			
			var fileName = item.one('.fileName');
			var fileId = item.one('.fileId');
			var imageDefaultId = A.one('#<portlet:namespace />imageDefaultId');
			var imageDefaultName = A.one('#<portlet:namespace />imageDefaultName');
			
			if(fileName && imageDefaultName){
				imageDefaultName.set('value', fileName.get('value'));
			} else if(fileId && imageDefaultId){
				imageDefaultId.set('value', fileId.get('value'));
			}
		});
	});

	Liferay.provide(
		window,
		'<portlet:namespace />remove',
		function(item){
			var parent = A.one(item).get('parentNode');
			
			if(parent.hasClass('qq-upload-fail')){
				parent.remove();
				return;
			}
		
			if(confirm('<%=LanguageUtil.get(locale, "do-you-want-remove-this-image") %>')){
				
				var fileName = parent.one('.fileName').get('value');
				
				parent.plug(A.LoadingMask);
				parent.loadingmask.show();
				
				A.io.request(
					'<%=deleteTempImagesURL %>&ticketKey=<%= ticket.getKey()%><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
					{
						dataType: 'json',
						data: {
							<portlet:namespace />fileName: fileName
						},
						after: {
							success: function(event, id, obj) {
								
								var responseData = this.get('responseData');
								
								var deleted = responseData.deleted;
								
								if(deleted){
									parent.remove();
									var fileNames = selectedFileNames.val().split(',');
									var index = fileNames.indexOf(fileName);
									fileNames.splice(index, 1);
									A.one('#<portlet:namespace />selectedFileNames').val(fileNames);
									
			
								}else{
									parent.loadingmask.hide();
									alert(responseData.errorMessage);
								}
								
							},
							failure: function(event, id, obj) {
								parent.loadingmask.hide();
							}
						}
					}
				);
	
	
			}else{
				return;
			}
		}
	);
</aui:script>

