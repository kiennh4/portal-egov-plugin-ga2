AUI().add(
		
	'portal-egov-banner-admin',
	
	function(A) {	
		
		var Lang = A.Lang;
		
		var BANNER_GROUP_MENU_CONTAINER = '#banner-groups-container';
		
		var BANNER_LIST_CONTAINER = '#banner-list-container';
		
		var ADD_GROUP_BTN_NAME = 'addBannerGroupBtn';
		
		var ADD_BANNER_BTN_NAME = 'addBannerBtn';
		
		var SEARCH_BANNER_BTN_NAME = 'searchBannerBtn';
		
		var SHOW_ALL_BANNER_BTN_NAME = 'showAllBannerBtn';
		
		var EVENT_CLICK = 'click';
		
		var UPDATE_GROUP_COMMAND = 'update-banner-group';
		
		var ADD_GROUP_FORM_TITLE = 'add-new-banner-group';
		
		var UPDATE_GROUP_FORM_TITLE = 'update-banner-group-information';
		
		var UPDATE_BANNER_COMMAND = 'update-banner';
		
		var ADD_BANNER_FORM_TITLE = 'add-new-banner';
		
		var UPDATE_BANNER_FORM_TITLE = 'update-banner-information';
		
		var CONFIRM_DELETE_BANNER_GROUP_MESSAGE = 'are-you-sure-want-to-delete-this-banner-group?';
		
		var CONFIRM_DELETE_BANNER_MESSAGE = 'are-you-sure-want-to-delete-this-banner?';
		
		var ROOT_GROUP_DISPLAY_TEMPLATE 	= '<li class="group-item results-row selected" data-bannerGroupId="0">'
											+ 	'<div class="group-item-content-wrapper">'
											+ 		'<span class="group-name">'
											+ 			'<a href="javascript:;" data-bannerGroupId="0">'
											+ 				Liferay.Language.get('all')
											+ 			'</a>'
											+ 		'</span>'	
											+ 	'</div>'
											+ '</li>';
		
		var GROUP_ITEM_DISPLAY_TEMPLATE 	= '<li class="group-item results-row {cssClassSelected}" data-bannerGroupId="{bannerGroupId}">'
											+ 	'<div class="group-item-content-wrapper">'
											+ 		'<span class="group-name">'
											+ 			'<a href="javascript:;" data-bannerGroupId="{bannerGroupId}">{groupName}</a>'
											+ 			'<a class="group-item-edit-trigger" href="javascript:;" data-bannerGroupId="{bannerGroupId}"></a>'
											+ 			'<a class="group-item-delete-trigger" href="javascript:;" data-bannerGroupId="{bannerGroupId}"></a>'
											+ 		'</span>'	
											+ 	'</div>'
											+ '</li>';
		
		var BANNER_ITEM_DISPLAY_TEMPLATE 	= '<li class="banner-item results-row {cssClassSelected}" data-bannerId="{bannerId}">'
											+ 	'<div class="banner-item-content-wrapper">'
											+ 		'<div class="banner-title">'
											+ 			'<a class="banner-descriptions" title="{bannerTitle}" data-bannerId="{bannerId}" href="javascript:;">'
											+ 				'<span>{bannerTitle}</span>'
											+ 				'<br/>'
											+ 				'<span>'
											+ 					'<img data-bannerId="{bannerId}" class="banner-image-thumbnail" src="'
											+ 							Liferay.ThemeDisplay.getPathImage() + '/logo?img_id=' + '{bannerImageId}'
											+ 							'&t' + (new Date()).getTime()
											+ 					'"/>'
											+ 				'<span>'
											+ 			'</a>'
											+ 			'<a class="banner-item-edit-trigger" href="javascript:;" data-bannerId="{bannerId}"></a>'
											+ 			'<a class="banner-item-delete-trigger" href="javascript:;" data-bannerId="{bannerId}"></a>'
											+ 		'</div>'
											+ 	'</div>'
											+ '</li>';
		
		var BannerAdmin = A.Component.create({
			EXTENDS: A.Base,
			NAME: 'banneradmin',
			prototype: {
				
				initializer: function(config) {
					
					var instance = this;
					
					instance.portletId = 'banner_admin_WAR_bannerportlet';
					
					instance.scopeGroupId = config.scopeGroupId;
					
					instance.dataFormDialogPanel = null;
					
					instance.imageViewer = null;
					
					instance.idPrefix = '#_' + instance.portletId + '_';

					instance._initializeBannerGroupMenuData();
					
					instance._initializeBannersListData();
					
					var bannerSearchInput = A.one('#_banner_admin_WAR_bannerportlet_bannerSearchInput');
					
					if(bannerSearchInput){
						
						bannerSearchInput.focus();
					}
					
					var addGroupBtn = A.one(instance.idPrefix + ADD_GROUP_BTN_NAME);
					
					if(addGroupBtn){
						addGroupBtn.on(EVENT_CLICK,function(){
							instance._onAddGroupBtnClick();
						});
					}
					
					var addBannerBtn = A.one(instance.idPrefix + ADD_BANNER_BTN_NAME);
					
					if(addBannerBtn){
						addBannerBtn.on(EVENT_CLICK,function(){
							instance._onAddBannerBtnClick();
						});
					}
					
					var searchBannerBtn = A.one(instance.idPrefix + SEARCH_BANNER_BTN_NAME);
					
					if(searchBannerBtn){
						searchBannerBtn.on(EVENT_CLICK,function(){
							instance._onSearchBannerBtnClick();
						});
					}
					
					var showAllBannerBtn = A.one(instance.idPrefix + SHOW_ALL_BANNER_BTN_NAME);
					
					if(showAllBannerBtn){
						showAllBannerBtn.on(EVENT_CLICK,function(){
							instance._onShowAllBannerBtnClick();
						});
					}
					
					var groupMenuContainer = A.one(BANNER_GROUP_MENU_CONTAINER);
					
					groupMenuContainer.on(EVENT_CLICK, instance._onGroupBannerClick, instance);
					
					var bannerListContainer = A.one(BANNER_LIST_CONTAINER);
					
					bannerListContainer.on(EVENT_CLICK, instance._onBannerClick, instance);
					
				},
		
				/**
				 * Khởi tạo menu danh sách các nhóm banner
				 */
				_initializeBannerGroupMenuData : function(callback){
					
					var instance = this;
					
					var buffer = [];
					
					var groupMenuContainer = A.one(BANNER_GROUP_MENU_CONTAINER);
					
					instance._showLoadingAnimation(groupMenuContainer);
					
					buffer.push('<ul>');
					buffer.push(ROOT_GROUP_DISPLAY_TEMPLATE);
					
					instance._getBannerGroups(
						function(result){

							var bannerGroups = result.bannerGroups;
							
							A.each(
									bannerGroups,
									function(item, index, collection){
										
										var groupItem = A.clone(item);
										
										buffer.push(Lang.sub(GROUP_ITEM_DISPLAY_TEMPLATE, groupItem));
									}
							);
							
							buffer.push('</ul>');
							
							groupMenuContainer.html(buffer.join(''));
							
							if (callback) {
								callback();
							}
						}
					);

				},
				
				/**
				 * Khởi tạo danh sách banner hiển thị mặc định trên site khi mới load
				 */
				_initializeBannersListData : function(callback){
					
					var instance = this;
					
					var buffer = [];
					
					var bannerListContainer = A.one(BANNER_LIST_CONTAINER);
					
					instance._showLoadingAnimation(bannerListContainer);
					
					buffer.push('<ul>');
					
					instance._getAllBanners(
						function(result){

							var banners = result.banners;
							
							A.each(
									banners,
									function(item, index, collection){
										
										var bannerItem = A.clone(item);
										
										buffer.push(Lang.sub(BANNER_ITEM_DISPLAY_TEMPLATE, bannerItem));
									}
							);
							buffer.push('</ul>');
							
							bannerListContainer.html(buffer.join(''));

							if (callback) {
								callback();
							}
						}
					);
				},
				
				/**
				 * Khởi tạo trình xem ảnh banner
				 */
				_initializeImageViewer : function(){
					
					var instance = this;
					
					var imageViewerLinks = A.all(BANNER_LIST_CONTAINER + ' .banner-descriptions');
					
					if(!instance.imageViewer){
						
						instance.imageViewer = new A.ImageGallery({ 
									links: imageViewerLinks 
						}).render();
					}
				},
				
				/**
				 * Xử lý sự kiện click vào nút Thêm mới group
				 */
				_onAddGroupBtnClick : function(){
					
					var instance = this;
					
					instance._showDataUpdateForm(UPDATE_GROUP_COMMAND, ADD_GROUP_FORM_TITLE);
				},
				
				/**
				 * Xử lý sự kiện click vào nút Thêm mới Banner
				 */
				_onAddBannerBtnClick : function(){
					
					var instance = this;
					
					instance._showDataUpdateForm(UPDATE_BANNER_COMMAND, ADD_BANNER_FORM_TITLE);

				},
				
				/**
				 * Xử lý sự kiện tìm banner theo từ khóa
				 * @param event
				 */
				_onSearchBannerBtnClick : function(event){
					var instance = this;
					
					var searchInput = A.one(instance.idPrefix + 'bannerSearchInput');
					
					if(searchInput){
						
						var searchKeyword = searchInput.get('value');
						
						var buffer = [];
						
						var bannerListContainer = A.one(BANNER_LIST_CONTAINER);
						
						instance._showLoadingAnimation(bannerListContainer);
						
						buffer.push('<ul>');
						
						instance._searchBannerByKeyword(
							searchKeyword,
							function(result){
								var banners = result.banners;
								
								A.each(
										banners,
										function(item, index, collection){
											
											var bannerItem = A.clone(item);
											
											buffer.push(Lang.sub(BANNER_ITEM_DISPLAY_TEMPLATE, bannerItem));
										}
								);
								buffer.push('</ul>');
								
								bannerListContainer.html(buffer.join(''));
							}
						);
					}
				},
				
				
				/**
				 * Xử lý sự kiện click vào nút show-all-baners
				 * @param event
				 */
				_onShowAllBannerBtnClick : function(event){
					
					var instance = this;
					
					var searchInput = A.one(instance.idPrefix + 'bannerSearchInput');
					
					if(searchInput){
						
						searchInput.set('value', '');
					}
					
					instance._initializeBannerGroupMenuData();
					instance._initializeBannersListData();
				},
				
				/**
				 * Xử lý sự kiện click vào tên nhóm Banner (thư mục)
				 */
				_onGroupBannerClick : function(event){
					
					var instance = this;
					
					//Lấy Id của group được chọn
					var selectedBannerGroupId = instance._getSelectedBannerGroupId(event.target);
					
					//Lấy đối tượng được chọn theo Id
					var selectedGroup = A.one('li[data-bannerGroupId="' + selectedBannerGroupId + '"]');
					
					if(selectedGroup){
						
						instance._selectedGroupId = selectedBannerGroupId;
						
						//Loại bỏ hết class 'selected' của những group được chọn trước
						A.all(BANNER_GROUP_MENU_CONTAINER + ' li').removeClass('selected');
						
						//Add class selected cho group được chọn hiện tại
						selectedGroup.addClass('selected');
						
						if(event.target.hasClass('group-item-edit-trigger')) {//Cập nhật thông tin group
							
							instance._showDataUpdateForm(UPDATE_GROUP_COMMAND,UPDATE_GROUP_FORM_TITLE);
								
						}else if(event.target.hasClass('group-item-delete-trigger')) {//Xóa group
								
							if(instance._confirmDelete(CONFIRM_DELETE_BANNER_GROUP_MESSAGE)){
								
								//Xóa group
								instance._deleteBannerGroup(
										
									selectedBannerGroupId,
									function(){
										//Load lại menu
										instance._reloadBannerGroupMenu();
									}
								);
							}
						}else{//Hiển thị danh sách các banner có trong group
							
							//Hiển thị danh sách banner
							instance._showBannersByGroup(selectedBannerGroupId);
						}
					}
				},
				
				
				/**
				 * Lấy Id của của group được chọn
				 */
				_getSelectedBannerGroupId : function(exp){
					return A.one(exp).attr('data-bannerGroupId');
				},
				
				
				/**
				 * Hiển thị danh sách banner theo id của group
				 * @param selectedBannerGroupId
				 */
				_showBannersByGroup : function(selectedBannerGroupId,callback){
					
					var instance = this;

					var buffer = [];
					
					var bannerListContainer = A.one(BANNER_LIST_CONTAINER);
					
					instance._showLoadingAnimation(bannerListContainer);
					
					buffer.push('<ul>');
					
					if(selectedBannerGroupId > 0){
						
						instance._getGroupBanners(
							selectedBannerGroupId,
							function(result){

								var banners = result.banners;
								
								A.each(
										banners,
										function(item, index, collection){
											
											var bannerItem = A.clone(item);
											
											buffer.push(Lang.sub(BANNER_ITEM_DISPLAY_TEMPLATE, bannerItem));
										}
								);
								buffer.push('</ul>');
								
								bannerListContainer.html(buffer.join(''));

								if (callback) {
									callback();
								}
							}
						);
					
					}else{
						
						instance._getAllBanners(
							function(result){

								var banners = result.banners;
								
								A.each(
										banners,
										function(item, index, collection){
											
											var bannerItem = A.clone(item);
											
											buffer.push(Lang.sub(BANNER_ITEM_DISPLAY_TEMPLATE, bannerItem));
										}
								);
								buffer.push('</ul>');
								
								bannerListContainer.html(buffer.join(''));

								if (callback) {
									callback();
								}
							}
						);
					}

				},
				
				/**
				 * Load lại menu banner group
				 */
				_reloadBannerGroupMenu : function(callback){
					
					var instance = this;
					
					instance._initializeBannerGroupMenuData();
				},
				
				/**
				 * Xử lý sự kiện click vào tên Banner
				 */
				_onBannerClick : function(event){
					
					var instance = this;
					
					//Lấy Id của banner được chọn
					var selectedBannerId = instance._getSelectedBannerId(event.target);

					//Lấy đối tượng được chọn theo Id
					var selectedBanner = A.one('li[data-bannerId="' + selectedBannerId + '"]');

					if(selectedBanner){
						//Loại bỏ hết class 'selected' của những banner được chọn trước
						A.all(BANNER_LIST_CONTAINER + ' li').removeClass('selected');
						
						//Add class selected cho banner hiện tại
						selectedBanner.addClass('selected');
						
						if(event.target.hasClass('banner-item-edit-trigger')) {//Cập nhật thông tin banner
							
							instance._selectedBannerId = selectedBannerId;
							
							instance._showDataUpdateForm(UPDATE_BANNER_COMMAND,UPDATE_BANNER_FORM_TITLE);
								
						}else if(event.target.hasClass('banner-item-delete-trigger')) {//Xóa banner
								
							if(instance._confirmDelete(CONFIRM_DELETE_BANNER_MESSAGE)){
								
								//Xóa group
								instance._deleteBanner(
									selectedBannerId,
									function(){
										//Load lại danh sách banner
										instance._reloadBannerListData();
									}
								);
							}
							
						}else{
							instance._initializeImageViewer();
						}
					}
				},
				
				/**
				 * Load lại danh sách banner hiện tại sau khi thay đổi
				 */
				_reloadBannerListData : function(){
					
					var instance = this;
					
					if(instance._selectedGroupId > 0){//Trường hợp đang hiển thị banner theo group
						
						instance._showBannersByGroup(instance._selectedGroupId);
					
					}else{//Load lại toàn bộ banner hiện có
						
						instance._initializeBannersListData();
					}
				},
				
				/**
				 * Lấy Id của của banner được chọn
				 */
				_getSelectedBannerId : function(exp){
					return A.one(exp).attr('data-bannerId');
				},
				
				
				/**
				 * Hiển thị form nhập/cập nhật dữ liệu
				 * @param actionCommand
				 * @param formTitle
				 */
				_showDataUpdateForm : function(actionCommand,formTitle){
					
					var instance = this;
					
					instance._hideDialogPanels();

					var dialogURL = instance._createPortletRenderURL(actionCommand);

//					if(!instance.dataFormDialogPanel){
//													
//						var dialogAlignConfig = {
//								node: '#banner-list-container',
//								points: ['tl', 'tl']
//						};
//						instance.dataFormDialogPanel = new A.Dialog({
//								align: dialogAlignConfig,
//								title: Liferay.Language.get(formTitle),
//								resizable: true,
//								destroyOnClose: true,
//								width: 360,
//								zIndex: 1000
//						}).render();
//						instance.dataFormDialogPanel.plug(
//							A.Plugin.IO,{
//								autoLoad: false,
//								uri: dialogURL.toString()
//							}
//						);
//						instance.dataFormDialogPanel.hide();
//					}
//					
//					instance.dataFormDialogPanel.show();
//					instance.dataFormDialogPanel.io.start();
					
					var dialogWidow = {
						dialog: {
							align: Liferay.Util.Window.ALIGN_CENTER,
							modal: true,
							width: 400,
							cache: false
						},
						title: formTitle,
						uri: dialogURL
					};
					
					Liferay.Util.openWindow(dialogWidow);
				},
				
				/**
				 * Tạo URL tương ứng với từng action
				 * @param actionCommand
				 * @returns
				 */
				_createPortletRenderURL : function(actionCommand){
					
					var instance = this;
					
					var renderURL = Liferay.PortletURL.createRenderURL();
					
					if(renderURL){
						
						renderURL.setPortletId(instance.portletId);
						renderURL.setWindowState('pop_up');
						
						var jspPath = '';
						
						if(actionCommand == UPDATE_GROUP_COMMAND){
							
							renderURL.setParameter('bannerGroupId', instance._selectedGroupId);
							
							instance._selectedGroupId = 0;
							
							jspPath = '/html/admin/banner_group_update_form.jsp';
						
						}else if(actionCommand == UPDATE_BANNER_COMMAND){
							
							renderURL.setParameter('bannerId', instance._selectedBannerId);
							
							if(instance._selectedGroupId > 0){
								renderURL.setParameter('bannerGroupId', instance._selectedGroupId);
							}
							
							instance._selectedBannerId = 0;
							
							jspPath = '/html/admin/banner_update_form.jsp';
							
						}else{
							
							jspPath = '/html/admin/invalid_command.jsp';
						}
						renderURL.setParameter('jspPage', jspPath);
						renderURL.setDoAsGroupId(instance.scopeGroupId);
					}
					
					return renderURL;
				},
				
				/**
				 * Ẩn tất cả những cửa sổ Dialog đang hiển thị để focus vào cửa sổ mới mở lên
				 */
				_hideDialogPanels : function(){
					
					var instance = this;
					
					if(instance.dataFormDialogPanel){
						instance.dataFormDialogPanel.hide();
						instance.dataFormDialogPanel = null;
					}
				},
				
				/**
				 * Hiển thị icon load dữ liệu
				 * @param container
				 */
				_showLoadingAnimation: function(container) {

					A.all(container).html('<div class="loading-animation" />');
				},
				
				/**
				 * Hiển thị Dialog xác nhận lệnh xóa dữ liệu
				 * @param message
				 * @returns
				 */
				_confirmDelete : function(message){
					
					return confirm(Liferay.Language.get(message));
				},
				
				/**
				 * Lấy danh sách tất cả các nhóm Banner lưu trong csdl theo scopeGroupId
				 * @param callback
				 */
				_getBannerGroups : function(callback){
					
					var instance = this;
					Liferay.Service.banner.BannerGroup.getBannerGroups(
						{
							groupId: instance.scopeGroupId
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				/**
				 * Xóa nhóm Banner theo Id
				 * @param bannerGroupId
				 * @param callback
				 */
				_deleteBannerGroup : function(bannerGroupId,callback){
					var instance = this;
					Liferay.Service.banner.BannerGroup.deleteBannerGroup(
						{
							groupId: instance.scopeGroupId, 
							bannerGroupId: bannerGroupId
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				
				_getBanner : function(bannerId,callback){
					
					var instance = this;
					
					Liferay.Service.banner.Banner.getBanner(
						{
							bannerId: bannerId
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				/**
				 * Lấy kết quả tìm kiếm banner theo từ khóa
				 * @param callback
				 */
				_searchBannerByKeyword : function(searchKeyword,callback){
					
					var instance = this;
					
					Liferay.Service.banner.Banner.findByKeyword(
						{
							groupId: instance.scopeGroupId,
							bannerGroupId : instance._selectedGroupId,
							searchKeyword : searchKeyword
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				/**
				 * Lấy tất cả Banner hiện có trong csdl theo scopeGroupId
				 * @param callback
				 */
				_getAllBanners : function(callback){
					
					var instance = this;
					
					Liferay.Service.banner.Banner.getAllBanners(
						{
							groupId: instance.scopeGroupId
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				/**
				 * Lấy danh sách banner theo nhóm
				 * @param bannerGroupId
				 * @param callback
				 */
				_getGroupBanners : function(bannerGroupId,callback){
					
					var instance = this;
					
					Liferay.Service.banner.Banner.getGroupBanners(
						{
							bannerGroupId: bannerGroupId
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				/**
				 * Xóa banner
				 * @param bannerGroupId
				 * @param callback
				 */
				_deleteBanner : function(bannerId,callback){
					
					var instance = this;
					
					Liferay.Service.banner.Banner.deleteBanner(
						{
							groupId: instance.scopeGroupId,
							bannerId: bannerId
						},
						function(result){
							if(callback){
								callback.apply(instance, arguments);
							}
						}
					);
				},
				
				_selectedGroupId : 0,
				
				_selectedBannerId : 0
			}
		});
		
		Liferay.Portlet.BannerAdmin = BannerAdmin;
	},
	'',
	{
		requires: ['aui-dialog', 'aui-dialog-iframe','aui-tree-view','json','liferay-portlet-url', 'liferay-util-window','aui-image-viewer-gallery']
	}
);