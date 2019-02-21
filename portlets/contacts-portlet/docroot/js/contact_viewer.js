AUI.add(
	'portal-egov-contacts-viewer',
	
	function(A) {
		
		var Lang = A.Lang;
		
		var Node = A.Node;
		
		var EVENT_CLICK = 'click';
		
		var EVENT_KEY_UP = 'keyup';
		
		var DEPARTMENT_TREEVIEW_CONTAINER = 'department-treeview-container';
		
		var CONTACT_VIEWER_CONTAINER = 'contact-viewer-container';
		
		var CONTACT_SEARCH_INPUT = 'contactViewerSearchInput';
		
		var DEPARTMENT_TREE_BOUNDING_TEMPLATE 	='<div class="department-treeview-container" id="departmentsTreeContainer"></div>';
		
		var DEPARTMENT_TREE_NODE_TEMPLATE 		='<div class="department-item-content-wrapper">'
												+	'<div class="department-name">'
												+ 		'<a href="javascript:;" data-departmentId="{departmentId}">{departmentName}</a>'
												+	'</div>'	
												+'</div>';
		
		
		var CONTACT_VIEWER_HEADER_ROW_TEMPLATE 	='<tr class="contact-viewer-header-row">'
												+	'<td>'
												+		Liferay.Language.get('index')
												+	'</td>'	
												+	'<td>'
												+		Liferay.Language.get('contact-full-name')
												+	'</td>'	
												+	'<td>'
												+		Liferay.Language.get('contact-job-title')
												+	'</td>'
												+	'<td>'
												+		Liferay.Language.get('contact-phone-numbers')
												+	'</td>'
												+	'<td>'
												+		Liferay.Language.get('contact-email')
												+	'</td>'
//												+	'<td>'
//												+		Liferay.Language.get('contact-mobile-numbers')
//												+	'</td>'
												
//												+	'<td>'
//												+		Liferay.Language.get('contact-avatar')
//												+	'</td>'
												
												+'</tr>';
		
		var ContactsViewer = A.Component.create(
			{
				EXTENDS: A.Base,

				NAME: 'contactviewer',

				prototype: {
					
					initializer: function(config) {
						
						var instance = this;
						
						instance.scopeGroupId = config.scopeGroupId;
						instance.portletId = config.portletId;
						instance.showDepartmentInfo = config.showDepartmentInfo;
						instance.showEmptyDepartment = config.showEmptyDepartment;
						
						instance.idPrefix = '#_' + instance.portletId + '_';
						
						instance.selectedDepartmentId = 0;
						
						instance.selectedDepartmentName = '';
						
						instance.selectedContactId = 0;
						
						instance.departmentTreeviewLevel = 0;
						
						instance.expandedNode = false;
						
						instance.contactInfoPanel = null;
						
						instance.departmentTreeviewContainer = A.one(instance.idPrefix + DEPARTMENT_TREEVIEW_CONTAINER);
						
						instance.contactViewerContainer = A.one(instance.idPrefix + CONTACT_VIEWER_CONTAINER);
						
						instance.contactSearchInput = A.one(instance.idPrefix + CONTACT_SEARCH_INPUT);
						
						instance._initializeDepartmentTreeView();
						
						instance._initializeDefaultContactList(config.defaultDepartmentId);
						
						instance._initializeContactLiveSearch();
						
						instance.contactViewerContainer.on(EVENT_CLICK,function(event){
							
							var selectedContactId = instance._getSelectedContactId(event.target);
							
							if(selectedContactId && selectedContactId > 0){
								instance._showContactInfoPanel(selectedContactId);
							}
						});
					},
					
					/**
					 * Khởi tạo Treeview Phòng/Ban/Đơn vị
					 * @param callback
					 */
					_initializeDepartmentTreeView : function(){
						
						var instance = this;
						
						instance._showLoadingAnimation(instance.departmentTreeviewContainer);
						
						instance._getGroupDepartments(
							function(result){

								var groupDepartments = result.groupDepartments;

								if(groupDepartments){
									instance._createDepartmentTreeView(groupDepartments);
								}
							}
						);
					},
					
					/**
					 * HIển thị thông tin liên hệ của tất cả các Phòng/Ban
					 */
					_initializeDefaultContactList : function(departmentId){
						
						var instance = this;
						
							//Hiển thị thông tin liên hệ của từng Phòng/Ban cao nhất và thông tin liên hệ của các Phòng/Ban trực thuộc
						
						if (departmentId>0)
						{
						
							instance._getDepartment(
									departmentId,
									function (rootDepartment)
									{
										if (rootDepartment!=null)
										{
										
											var rootDepartmentName = rootDepartment.departmentName;
											
											instance._buildDepartmentContactList(rootDepartment.departmentId, rootDepartmentName);
											
											if(instance._hasChildDepartment(rootDepartment.departmentId)){
												
												instance._showChildDepartmentContacts(rootDepartment.departmentId, rootDepartmentName);
											}
										}
									}
							);
						}
						else
						{
							var rootDepartments = 						
								Liferay.Service.contacts.ContactsDepartment.getChildDepartments(
										{
											groupId: instance.scopeGroupId,
											parentDepartmentId : 0
										}
								).childDepartments;
							
							if(rootDepartments && rootDepartments.length > 0){
								
								//Hiển thị thông tin liên hệ của từng Phòng/Ban cao nhất và thông tin liên hệ của các Phòng/Ban trực thuộc
								A.each(
									rootDepartments,
									function(item, index, collection) {
										
										var rootDepartment = item;
										
										var rootDepartmentName = rootDepartment.departmentName;
										
										instance._buildDepartmentContactList(rootDepartment.departmentId, rootDepartmentName);
										
										if(instance._hasChildDepartment(rootDepartment.departmentId)){
											
											instance._showChildDepartmentContacts(rootDepartment.departmentId, rootDepartmentName);
										}
									}
								);
							}
						}
					},
					
					
					/**
					 * Tạo Livesearch
					 */
					_initializeContactLiveSearch : function(){
						
						var instance = this;
						
						var liveSearch = new ContactsLiveSearch(
							{
								inputNode: instance.contactSearchInput,
								queryDelay: 300
							}
						);
						
						instance.contactSearchInput.on(EVENT_KEY_UP, instance._onSearchInputKeyUp,instance);
						
						instance.contactLiveSearch = liveSearch;
					},
					
					/**
					 * Xử lý sự kiện người dùng nhập text vào ô tìm kiếm
					 * @param event
					 */
					_onSearchInputKeyUp: function(event) {
						
						var instance = this;
						
						var searchKeyword = instance.contactSearchInput.get('value');

						if(searchKeyword == ''){
							
							instance.contactViewerContainer.empty();
							
							instance._initializeDefaultContactList();
						
						}else{
							
							instance._findContactsByKeyword(
									searchKeyword,
									function(result){
										
										var searchResults = result.searchResults;
										
										if(searchResults){
											instance._showContactSearchResult(searchResults);
										}
									}
							);
						}
					},
					
					/**
					 * Hiển thị kết quả tìm kiếm
					 * @param searchResults
					 */
					_showContactSearchResult : function(searchResults){
						
						var instance = this;
						
						if(searchResults && searchResults.length > 0){
							
							var buffer = [];
							
							var searchResultTitle  	='<div class="department-name">'
													+	Liferay.Language.get('contact-search-result')
													+'</div>';

							buffer.push(searchResultTitle);
							
							buffer.push('<table cellpadding="0" cellspacing="0" >');
							
							buffer.push(CONTACT_VIEWER_HEADER_ROW_TEMPLATE);
							
							A.each(
									searchResults,
								function(item, index, collection){
									
									var contactItem = item;
									
									var contactIndex = index + 1;
									
									var contactPortraitImageURL = instance._getContactPortraitImageURL(contactItem.imageId);
									
									var contactItemRowContent 	='<tr>'
																+	'<td data-contactId="' + contactItem.contactId + '">' 
																+ 		contactIndex 
																+ 	'</td>'
																
																+	'<td data-contactId="' + contactItem.contactId + '">'
																+ 		contactItem.contactName
																+ 	'</td>'
																
																+	'<td data-contactId="' + contactItem.contactId + '">' 
																+ 		contactItem.jobTitle 
																+ 	'</td>'
																
																+	'<td data-contactId="' + contactItem.contactId + '">' 
																+ 		contactItem.phoneNumbers 
																+ 	'</td>'
																
																+	'<td data-contactId="' + contactItem.contactId + '">' 
																+ 		contactItem.email
																+ 	'</td>'
//																
//																+	'<td data-contactId="' + contactItem.contactId + '">' 
//																+ 		contactItem.mobile 
//																+ 	'</td>'
																
//																+	'<td data-contactId="' + contactItem.contactId + '">'
//																+			'<img class="contact-portrait-img" align="center" src="' 
//																+ 				contactPortraitImageURL 
//																+ 				'" data-contactId="'
//																+ 				contactItem.contactId
//																+ 				'" title="'
//																+ 				contactItem.contactName
//																+ 			'"/>'
//																+ 	'</td>'
																
																+'</tr>';
									
									buffer.push(contactItemRowContent);
								}
							);
							
							buffer.push('</table>');
							
							instance.contactViewerContainer.empty();
							
							instance.contactViewerContainer.html(buffer.join(''));
						
						}else{
							
							var searchKeyword = instance.contactSearchInput.get('value');
							
							var emptyResultTitle  	='<div class="department-name">'
													+	Liferay.Language.get('no-contact-exist-with-search-key-word')
													+ ' "' + searchKeyword + '"'
													+'</div>';
							
							instance.contactViewerContainer.empty();
							
							instance.contactViewerContainer.html(emptyResultTitle);
						}
					},
					
					/**
					 * Tạo TreeView cho danh sách Phòng/Ban
					 * @param departments
					 */
					_createDepartmentTreeView: function(departments) {
						var instance = this;
						
						instance.departmentTreeviewContainer.empty();

						var departmentBoundingBox = Node.create(DEPARTMENT_TREE_BOUNDING_TEMPLATE);

						instance.departmentTreeviewContainer.append(departmentBoundingBox);
						
						instance._departmentsTreeView = new DepartmentsTree(
							{
								boundingBox: departmentBoundingBox,
								type: 'normal'
							}
						).render();

						instance._buildDepartmentTreeNode(departments, 0);
					},
					
					/**
					 * Tạo TreeNode cho từng Phòng/Ban để append vào TreeView
					 * @param departments
					 * @param parentDepartmentId
					 * @returns
					 */
					_buildDepartmentTreeNode : function(departments, parentDepartmentId){
						
						var instance = this;

						var childrentDepartments = instance._filterDepartment(departments, parentDepartmentId);
						
						instance.departmentTreeviewLevel ++;
						
//						if(instance.departmentTreeviewLevel == 1){
//							
//							instance.expandedNode = true;
//						}else{
//							
//							instance.expandedNode = false;
//						}
						
						A.each(
							childrentDepartments,
							function(item, index, collection) {
								
								var departmentId = item.departmentId;
								
								var hasChild = instance._filterDepartment(departments, departmentId).length;
								
								var buffer = [];
								
								var departmentItem = A.clone(item);
								
								buffer.push(Lang.sub(DEPARTMENT_TREE_NODE_TEMPLATE, departmentItem));
								
								var departmentContent = buffer.join('');
								
								var node = new A.TreeNode(
									{
										id: 'departmentNode' + departmentId,
										label: departmentContent,
										leaf: false,
										draggable: false,
										expanded: instance.expandedNode,
										on: {
											select: function(event) {
												
												if(instance._hasChildDepartment(departmentId)){
													node.expand();
												}
												
												instance._showLoadingAnimation(instance.contactViewerContainer);
												
												instance.contactViewerContainer.empty();
												
												instance._showDepartmentContactList(item.departmentId, item.departmentName);
											}
										}
									}
								);
								
								var parentId = 'departmentNode' + parentDepartmentId;
								var parentNode = instance._departmentsTreeView.getNodeById(parentId) || instance._departmentsTreeView;

								parentNode.appendChild(node);

								if (hasChild) {
									instance._buildDepartmentTreeNode(departments, departmentId);
								}
							}
						);

						return childrentDepartments.length;
					},
					
					/**
					 * Hiển thị thông tin liên hệ của Phòng/Ban được chọn
					 * @param departmentId
					 * @param departmentName
					 * @returns
					 */
					_showDepartmentContactList : function(departmentId,departmentName){
						var instance = this;
						
						instance._buildDepartmentContactList(departmentId, departmentName);
						
						if(instance._hasChildDepartment(departmentId)){
							
							instance._showChildDepartmentContacts(departmentId, departmentName);
						}
					},
					
					/**
					 * Hiển thị thông tin Phòng/Ban cấp dưới và danh sách cá nhân trực thuộc Phòng/Ban cấp dưới
					 * @param parentDepartmentId
					 * @param parentDepartmentName
					 */
					_showChildDepartmentContacts : function(parentDepartmentId,parentDepartmentName){
						
						var instance = this;
						
						var childDepartments = 						
							Liferay.Service.contacts.ContactsDepartment.getChildDepartments(
									{
										groupId: instance.scopeGroupId,
										parentDepartmentId : parentDepartmentId
									}
							).childDepartments;
						
						if(childDepartments && childDepartments.length > 0){
							
							A.each(
								childDepartments,
								function(item, index, collection) {
									
									var childDepartment = item;
									
									var childDepartmentName = parentDepartmentName + ' - ' + childDepartment.departmentName;
									
									instance._buildDepartmentContactList(childDepartment.departmentId, childDepartmentName);
									
									if(instance._hasChildDepartment(childDepartment.departmentId)){
										
										instance._showChildDepartmentContacts(childDepartment.departmentId, childDepartmentName);
									}
								}
							);
						}
					},
					
					/**
					 * Tạo Template hiển thị danh bạ theo Id và Name của Phòng/Ban
					 * @param departmentId
					 * @param departmentName
					 */
					_buildDepartmentContactList : function(departmentId,departmentName){
						
						var instance = this;
						
						instance._getDepartmentContacts(
							departmentId,
							function(result){
								
								var departmentContacts = result.departmentContacts;
								
								var buffer = [];
								
								var departmentInfo  ='<div class="department-name">'
													+	departmentName
													+'</div>';
								
								if(instance.showDepartmentInfo){
									
									var department = 						
										Liferay.Service.contacts.ContactsDepartment.getDepartment(
												{
													departmentId : departmentId
												}
										);
									
									if(department){
										
										departmentInfo  ='<div class="department-name">'
														+	departmentName
														+'</div>'
														+'<div class="department-info">';
										
										if(department.departmentAddress.length > 0){
											
											departmentInfo += '<div class="department-address">';
											departmentInfo += 		Liferay.Language.get('department-address') + ': ';
											departmentInfo += 		department.departmentAddress;
											departmentInfo += '</div>';
										}
														
										if(department.departmentPhone.length > 0){
											
											departmentInfo += '<span>';
											departmentInfo += 		Liferay.Language.get('department-phone') + ': ';
											departmentInfo += 		department.departmentPhone;
											departmentInfo += '</span>';
										}
										
										if(department.departmentWebsite.length > 0){
											departmentInfo += ' ,';
											departmentInfo += '<span>';
											departmentInfo += 		Liferay.Language.get('department-website') + ': ';
											departmentInfo += 		department.departmentWebsite;
											departmentInfo += '</span>';
										}
										
										if(department.departmentEmail.length > 0){
											departmentInfo += ' ,';
											departmentInfo += '<span>';
											departmentInfo += 		Liferay.Language.get('department-email') + ': ';
											departmentInfo += 		department.departmentEmail;
											departmentInfo += '</span>';
										}
										
										departmentInfo += '</div>';
									}
								}
								
								if(departmentContacts.length > 0){
									
									buffer.push(departmentInfo);
									
									buffer.push('<table cellpadding="0" cellspacing="0" >');
									
									buffer.push(CONTACT_VIEWER_HEADER_ROW_TEMPLATE);
									
									A.each(
										departmentContacts,
										function(item, index, collection){
											
											var contactItem = item;

											var contactIndex = index + 1;
											
											var contactPortraitImageURL = instance._getContactPortraitImageURL(contactItem.imageId);
											
											var contactItemRowContent 	='<tr>'
																		+	'<td data-contactId="' + contactItem.contactId + '">' 
																		+ 		contactIndex 
																		+ 	'</td>'
																		
																		+	'<td data-contactId="' + contactItem.contactId + '">'
																		+ 		contactItem.contactName
																		+ 	'</td>'
																		
																		+	'<td data-contactId="' + contactItem.contactId + '">' 
																		+ 		contactItem.jobTitle 
																		+ 	'</td>'
																		
																		+	'<td data-contactId="' + contactItem.contactId + '">' 
																		+ 		contactItem.phoneNumbers 
																		+ 	'</td>'
																		
																		+	'<td data-contactId="' + contactItem.contactId + '">' 
																		+ 		contactItem.email 
																		+ 	'</td>'
//																		
//																		+	'<td data-contactId="' + contactItem.contactId + '">' 
//																		+ 		contactItem.mobile 
//																		+ 	'</td>'
																		
//																		+	'<td data-contactId="' + contactItem.contactId + '">'
//																		+			'<img class="contact-portrait-img" align="center" src="' 
//																		+ 				contactPortraitImageURL 
//																		+ 				'" data-contactId="'
//																		+ 				contactItem.contactId
//																		+ 				'" title="'
//																		+ 				contactItem.contactName
//																		+ 			'"/>'
//																		+ 	'</td>'
																		
																		+'</tr>';
											
											buffer.push(contactItemRowContent);
										}
									);
									
								}else{
									
									if(instance.showEmptyDepartment){
										
										buffer.push(departmentInfo);
										
										buffer.push('<table cellpadding="0" cellspacing="0" >');
										
										buffer.push(CONTACT_VIEWER_HEADER_ROW_TEMPLATE);
									}
								}

								buffer.push('</table>');
								
								instance.contactViewerContainer.append(buffer.join(''));
							}
						);
					},
					
					/**
					 * Kiểm tra Phòng/Ban hiện tại có đơn vị cấp dưới hay ko?
					 * @param departmentId
					 * @param callback
					 * @returns {Boolean}
					 */
					_hasChildDepartment : function(departmentId){
						
						var instance = this;
						
						if(instance._countChildDepartment(departmentId) > 0){
							
							return true;
						}else{
							
							return false;
						}
					},
					
					/**
					 * Hiển thị thông tin liên hệ chi tiết
					 * @param contactId
					 */
					_showContactInfoPanel : function(contactId){
						
						var instance = this;
						
						var viewContactInfoRenderURL = Liferay.PortletURL.createRenderURL();
						
						if(viewContactInfoRenderURL){
							
							viewContactInfoRenderURL.setPortletId(instance.portletId);
							viewContactInfoRenderURL.setWindowState('exclusive');
							viewContactInfoRenderURL.setParameter('jspPage', '/html/contacts/contact_info.jsp');
							viewContactInfoRenderURL.setParameter('contactId', contactId);
							viewContactInfoRenderURL.setDoAsGroupId(instance.scopeGroupId);
						}
						
						instance._hideDialogPanels();
						
						if(!instance.contactInfoPanel){
							
							var dialogAlignConfig = {
									node: instance.idPrefix + CONTACT_VIEWER_CONTAINER,
									points: ['tl', 'tl']
							};
							
							instance.contactInfoPanel = new A.Dialog({
									align: dialogAlignConfig,
									title: Liferay.Language.get('contact-info'),
									resizable: true,
									destroyOnClose: true,
									width: 360,
									zIndex: 1000
							}).render();
							
							instance.contactInfoPanel.plug(
								A.Plugin.IO,{
									autoLoad: false,
									uri: viewContactInfoRenderURL.toString()
								}
							);
							instance.contactInfoPanel.hide();
						}
						
						instance.contactInfoPanel.show();
						instance.contactInfoPanel.io.start();
					},
					
					/**
					 * Lấy Id của của contact được chọn
					 */
					_getSelectedContactId : function(exp){
						return A.one(exp).attr('data-contactId');
					},
					
					/**
					 * Ẩn tất cả những cửa sổ Dialog đang hiển thị để focus vào cửa sổ mới mở lên
					 */
					_hideDialogPanels : function(){
						
						var instance = this;
						
						if(instance.contactInfoPanel){
							instance.contactInfoPanel.hide();
							instance.contactInfoPanel = null;
						}
					},
					
					/**
					 * Tạo đường dẫn đến file ảnh avatar
					 * @param contactImageId
					 * @returns
					 */
					_getContactPortraitImageURL : function(contactImageId){

						return Liferay.Service.contacts.Contacts.getContactPortraitURL(
							{
								imagePath: themeDisplay.getPathImage(),
								contactImageId : contactImageId
							}
						);
					},
					
					
					/**
					 * Lọc danh sách các Phòng/Ban thuộc cấp dưới theo parentDepartmentId
					 * @param departments
					 * @param parentDepartmentId
					 * @returns {Boolean}
					 */
					_filterDepartment: function(departments, parentDepartmentId) {
						
						var filteredDepartments;

						if (Lang.isArray(departments)) {
							filteredDepartments = A.Array.filter(
								departments,
								function(item, index, collection) {
									return (item.parentId == parentDepartmentId);
								}
							);
						}
						return filteredDepartments || [];
					},
					
					/**
					 * Hiển thị animation khi load dữ liệu
					 * @param container
					 */
					_showLoadingAnimation: function(container) {

						A.all(container).html('<div class="loading-animation" />');
					},
					
					/**
					 * Lấy danh sách tất cả các Phòng ban
					 * @param callback
					 */
					_getGroupDepartments : function(callback){
						
						var instance = this;
						
						Liferay.Service.contacts.ContactsDepartment.getGroupDepartments(
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
					 * Đếm số lượng Phòng/Ban cấp dưới theo Id của Phòng/Ban hiện tại
					 * @param departmentId
					 * @param callback
					 */
					_countChildDepartment : function(departmentId,callback){
						
						var instance = this;
						
						return Liferay.Service.contacts.ContactsDepartment.countChildDepartment(
							{
								groupId: instance.scopeGroupId,
								departmentId: departmentId
							}
						);
					},
					
					/**
					 * Lấy danh sách các phòng ban cấp dưới của Phòng/Ban hiện tại
					 * @param parentDepartmentId - Id của phòng/ban hiện tại
					 * @param callback
					 */
					_getChildDepartments : function(parentDepartmentId,callback){
						
						var instance = this;
						
						Liferay.Service.contacts.ContactsDepartment.getChildDepartments(
							{
								groupId: instance.scopeGroupId,
								parentDepartmentId : parentDepartmentId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					/**
					 * Lấy danh sách tất cả thông tin liên hệ của các cá nhân trong Group
					 * @param callback
					 */
					_getGroupContacts : function(callback){
						
						var instance = this;
						
						Liferay.Service.contacts.Contacts.getGroupContacts(
							{
								groupId : instance.scopeGroupId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					_getDepartment : function(departmentId, callback){
						
						var instance = this;
						
						Liferay.Service.contacts.ContactsDepartment.getDepartment(
							{
								departmentId : departmentId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					
					/**
					 * Lấy danh sách thông tin liên hệ của các cá nhân theo Phòng/Ban
					 * @param departmentId
					 * @param callback
					 */
					
					_getDepartmentContacts : function(departmentId,callback){
						
						var instance = this;
						
						Liferay.Service.contacts.Contacts.getDepartmentContacts(
							{
								groupId : instance.scopeGroupId,
								departmentId : departmentId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					_findContactsByKeyword : function(searchKeyword,callback){
						
						var instance = this;
						
						Liferay.Service.contacts.Contacts.findByKeyword(
							{
								groupId : instance.scopeGroupId,
								searchKeyword : searchKeyword
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					}
					
				}
			}
		);

		Liferay.Portlet.ContactsViewer = ContactsViewer;
		
		var ContactsLiveSearch = A.Component.create(
			{
				AUGMENTS: [A.AutoCompleteBase],
				EXTENDS: A.Base,
				NAME: 'livesearch',
				prototype: {
					initializer: function () {
						this._bindUIACBase();
						this._syncUIACBase();
					}
				}
			}
		);
		
		Liferay.Portlet.ContactsLiveSearch = ContactsLiveSearch;
		
		var DepartmentsTree = A.Component.create(
			{
				NAME: 'DepartmentsTree',

				EXTENDS: A.TreeViewDD,

				prototype: {

					_onDropHit: function(event) {
						
						var instance = this;
						DepartmentsTree.superclass._onDropHit.apply(instance, arguments);
						
					},

					_updateNodeState: function(event) {
						var instance = this;
						DepartmentsTree.superclass._updateNodeState.apply(instance, arguments);
					},
				}
			}
		);
	},
	'',
	{
		requires: ['aui-dialog', 'aui-dialog-iframe','aui-tree-view','json','liferay-portlet-url', 'liferay-util-window','aui-live-search','autocomplete-base']
	}
);