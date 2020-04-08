AUI.add(
	'portal-egov-contacts-admin',
	
	function(A) {
		
		var Lang = A.Lang;
		
		var Node = A.Node;
		
		var PARENT_NODE = 'parentNode';
		
		var EVENT_CLICK = 'click';
		
		var EVENT_KEY_UP = 'keyup';
		
		var DELETE_DEPARTMENT_CONFIRM_MESSAGE = 'are-you-sure-want-to-delete-this-department';
		
		var DELETE_CONTACT_CONFIRM_MESSAGE = 'are-you-sure-want-to-delete-this-contact';
		
		var ADD_NEW_CONTACT_COMMAND = 'add-new-contact';
		
		var VIEW_CONTACT_COMMAND = 'view-contact-info';
		
		var UPDATE_CONTACT_COMMAND = 'update-contact';
		
		var CONTACT_UPDATE_FORM_TITLE = 'contact-infomation';
		
		var ADD_NEW_DEPARTMENT_COMMAND = 'add-new-department';
		
		var VIEW_DEPARTMENT_COMMAND = 'view-department-info';
		
		var UPDATE_DEPARTMENT_COMMAND = 'update-department';
		
		var DEPARTMENT_UPDATE_FORM_TITLE = 'department-infomation';
		
		var DEPARTMENTS_CONTAINER = 'contact-departments-container';
		
		var CONTACTS_CONTAINER = 'contacts-container';
		
		var CONTACTS_DETAIL_CONTAINER = 'contact-detail-container';
		
		var ADD_DEPARTMENT_BTN_NAME = 'addNewContactDepartmentBtn';
		
		var VIEW_DEPARTMENT_BTN_ID = 'viewDepartmentBtn';
		
		var UPDATE_DEPARTMENT_BTN_ID = 'updateDepartmentBtn';
		
		var DELETE_DEPARTMENT_BTN_ID = 'deleteDepartmentBtn';
		
		var ADD_CONTACT_BTN_NAME = 'addNewContactBtn';
		
		var VIEW_CONTACT_BTN_ID = 'viewContactBtn';
		
		var UPDATE_CONTACT_BTN_ID = 'updateContactBtn';
		
		var DELETE_CONTACT_BTN_ID = 'deleteContactBtn';
		
		var SHOW_ALL_CONTACT_BTN_NAME = 'showAllContactsBtn';
			
		var DEPARTMENT_TREE_BOUNDING_TEMPLATE = '<div class="departments-treeview-container" id="departmentsTreeContainer"></div>';
		
		var CONTACT_TREE_BOUNDING_TEMPLATE = '<div class="contacts-treeview-container" id="contactsTreeContainer"></div>';
		
		var EMPTY_DATA_MESSAGE_TEMPLATE 	= '<div class="portlet-configuration portlet-msg-info empty-data-message">'
											+ 			Liferay.Language.get('empty-data')
											+ '</div>';
		
		var DEPARTMENT_TREE_NODE_TEMPLATE 	= '<div class="department-item-content-wrapper">'
											+ 		'<div class="department-name">'
											+ 			'<a href="javascript:;" data-departmentId="{departmentId}">{departmentName}</a>'
											+ 		'</div>'	
											+ '</div>';
		
		var DEPARTMENT_INFO_TEMPLATE 		= '<div class="department-info">'
											+ 		'<span class="department-name">{departmentName}</span>'
											+ 		'<span class="department-attribute">'
											+ 			Liferay.Language.get('department-address') + ': '
											+ 			'{departmentAddress}'
											+ 		'</span>'
											+ 		'<span class="department-attribute">'
											+ 			Liferay.Language.get('department-phone') + ': '
											+ 			'{departmentPhone}'
											+ 		'</span>'
											+ 		'<span class="department-attribute">'
											+ 			Liferay.Language.get('department-website') + ': '
											+ 			'{departmentWebsite}'
											+ 		'</span>'
											+ 		'<span class="department-attribute">'
											+ 			Liferay.Language.get('department-email') + ': '
											+ 			'{departmentEmail}'
											+ 		'</span>'
											+ '</div>'
										    + '<div class="action-btn-row">'
										    + 		'<input type="button" id="viewDepartmentBtn" value="'
										    + 			Liferay.Language.get('view-department-info')
										    + 		'"/>'
										    + 		'<input type="button" id="updateDepartmentBtn" value="'
										    + 			Liferay.Language.get('update-department-info')
										    + 		'"/>'
										    + 		'<input type="button" id="deleteDepartmentBtn" value="'
										    + 			Liferay.Language.get('delete-department')
										    + 		'"/>'
										    + '</div>';
		
		var CONTACT_TREE_NODE_TEMPLATE 		= '<div class="contact-item-content-wrapper">'
											+ 		'<div class="contact-name">'
											+ 			'<a href="javascript:;" data-contactId="{contactId}">{contactName}</a>'
											+ 		'</div>'	
											+ '</div>';
		
		
		var ContactsAdmin = A.Component.create(
			{
				EXTENDS: A.Base,

				NAME: 'contactsadmin',

				prototype: {
					
					initializer: function(config) {
						
						var instance = this;
						
						instance._originalConfig = config;
						
						instance.scopeGroupId = config.scopeGroupId;
						instance.portletId = config.portletId;
						
						instance.idPrefix = '#_' + instance.portletId + '_';
						
						instance.dataFormDialogPanel = null;
						
						instance.departmentTreeLevel = 0;
						
						instance.contactSearchInput = A.one(instance.idPrefix + 'contactSearchInput');
						
						instance._initializeDepartmentTreeView();
						
						instance._initializeDefaultContactData();
						
						instance._createContactLiveSearch();
						
						var addDepartmentBtn = A.one(instance.idPrefix + ADD_DEPARTMENT_BTN_NAME);
						
						if(addDepartmentBtn){
							addDepartmentBtn.on(EVENT_CLICK,function(){
								instance._showDataDialogForm(ADD_NEW_DEPARTMENT_COMMAND, DEPARTMENT_UPDATE_FORM_TITLE);
							});
						}
						
						var addContactBtn = A.one(instance.idPrefix + ADD_CONTACT_BTN_NAME);
						
						if(addContactBtn){
							addContactBtn.on(EVENT_CLICK,function(){
								instance._showDataDialogForm(ADD_NEW_CONTACT_COMMAND, CONTACT_UPDATE_FORM_TITLE);
							});
						}
						
						var showAllContactBtn = A.one(instance.idPrefix + SHOW_ALL_CONTACT_BTN_NAME);
						
						if(showAllContactBtn){
							showAllContactBtn.on(EVENT_CLICK,function(){
								instance._onShowAllContactBtnClick();
							});
						}
					},
					
					/**
					 * Tạo Livesearch
					 */
					_createContactLiveSearch : function(){
						
						var instance = this;
						
						instance.contactSearchInput.set('value',Liferay.Language.get('search'));
						
						var liveSearch = new ContactsLiveSearch(
							{
								inputNode: instance.contactSearchInput,
								queryDelay: 300
							}
						);
						
						instance.contactSearchInput.on(EVENT_CLICK,function(){
							instance.contactSearchInput.set('value','');
						});
						
						instance.contactSearchInput.on(EVENT_KEY_UP, instance._onSearchInputKeyUp,instance);
						
						instance.contactLiveSearch = liveSearch;
					},
					
					/**
					 * Hiển thị kết quả tìm kiếm liên hệ theo từ khóa
					 * @param event
					 */
					_onSearchInputKeyUp: function(event) {
						
						var instance = this;
						
						var searchKeyword = instance.contactSearchInput.get('value');

						if(searchKeyword == ''){
							
							instance._initializeDefaultContactData();
						
						}else{
							
							instance._findContactsByKeyword(
									searchKeyword,
									function(result){
										
										var searchResults = result.searchResults;
										
										if(searchResults){
											instance._buildContactTreeView(searchResults);
										}
									}
							);
						}
					},
					
					/**
					 * Xử lý sự kiện click vào nút "Hiển thị toàn bộ Danh bạ"
					 * @param event
					 */
					_onShowAllContactBtnClick : function(event){
						
						var instance = this;
						
						var contactSearchInput = A.one(instance.idPrefix + 'contactSearchInput');
						
						if(contactSearchInput){
							
							contactSearchInput.set('value', '');
						}
						
						instance._initializeDepartmentTreeView();
						instance._initializeDefaultContactData();
					},
					
					/**
					 * Khởi tạo Treeview Phòng/Ban/Đơn vị
					 * @param callback
					 */
					_initializeDepartmentTreeView : function(callback){
						var instance = this;
						
						var departmentsContainer = A.one(instance.idPrefix + DEPARTMENTS_CONTAINER);
						
						if(departmentsContainer){
							
							instance._showLoadingAnimation(departmentsContainer);
							
							instance._getGroupDepartments(
								function(result){

									var groupDepartments = result.groupDepartments;

									if(groupDepartments){
										instance._createDepartmentTreeView(groupDepartments);
									}

									if (callback) {
										callback();
									}
								}
							);
						}
					},
					
					/**
					 * Khởi tạo danh sách thông tin liên hệ của Cá nhân
					 * @param callback
					 */
					_initializeDefaultContactData : function(callback){
						
						var instance = this;
						
						var contactTreeContainer = A.one(instance.idPrefix + CONTACTS_CONTAINER);
						
						instance._showLoadingAnimation(contactTreeContainer);
						
						if(instance._selectedDepartmentId > 0){
							
							instance._loadDepartmentContacts();
						
						}else{
							
							instance._getGroupContacts(
								function(result){
									
									var groupContacts = result.groupContacts;
									
									if(groupContacts){
										
										contactTreeContainer.empty();
										
										instance._buildContactTreeView(groupContacts);
									}
								}
							);
						}
					},
					
					/**
					 * Tạo TreeView cho danh sách Phòng/Ban
					 * @param departments
					 */
					_createDepartmentTreeView: function(departments) {
						var instance = this;
						
						var departmentTreeContainer = A.one(instance.idPrefix + DEPARTMENTS_CONTAINER);

						departmentTreeContainer.empty();

						if (departments.length <= 0) {
							departmentTreeContainer.append(EMPTY_DATA_MESSAGE_TEMPLATE);
							return;
						}
						
						var departmentBoundingBox = Node.create(DEPARTMENT_TREE_BOUNDING_TEMPLATE);

						departmentTreeContainer.append(departmentBoundingBox);

						instance._departmentsTreeView = new DepartmentsTree(
							{
								boundingBox: departmentBoundingBox,
								on: {
									dropAppend: function(event) {
										
										var tree = event.tree;
										
										var dragNode = tree.dragNode;
										
										var dragNodeId = instance._getDepartmentNodeId(dragNode);
										
										var dropNode = tree.dropNode;
										
										var dropNodeId = instance._getDepartmentNodeId(dropNode);
										
										instance._updateDepartmentParent(dragNodeId, dropNodeId);
										
										dropNode.expand();
									},
									dropInsert: function(event) {
										
										var tree = event.tree;
										
										var dragNode = tree.dragNode;
										
										var dragNodeId = instance._getDepartmentNodeId(dragNode);
										
										var parentNode = dragNode.get(PARENT_NODE);
										
										var parentNodeId = instance._getDepartmentNodeId(parentNode);
										
										instance._updateDepartmentParent(dragNodeId, parentNodeId);
										
										var dragNodeIndex = parentNode.indexOf(dragNode);
										
										instance._updateDepartmentState(dragNodeId, dragNodeIndex);
									}
								},
								type: 'normal'
							}
						).render();

						instance._buildDepartmentTreeView(departments, 0);
					},
					
					/**
					 * Tạo TreeNode cho từng Phòng/Ban để append vào TreeView
					 * @param departments
					 * @param parentDepartmentId
					 * @returns
					 */
					_buildDepartmentTreeView : function(departments, parentDepartmentId){
						
						var instance = this;
						
						instance.departmentTreeLevel ++;
						
						var childrentDepartments = instance._filterDepartment(departments, parentDepartmentId);
						
						A.each(
							childrentDepartments,
							function(item, index, collection) {
								
								var departmentId = item.departmentId;
								
								if(index == 0 && instance._selectedDepartmentId == 0){
									
									instance._selectedDepartmentId = departmentId;
								}
								
								var expanded = false;
								
								var hasChild = instance._filterDepartment(departments, departmentId).length;
								
								if(instance.departmentTreeLevel == 1 && hasChild){
									expanded = true;
								}
								
								var buffer = [];
								
								var departmentItem = A.clone(item);
								
								buffer.push(Lang.sub(DEPARTMENT_TREE_NODE_TEMPLATE, departmentItem));
								
								var departmentContent = buffer.join('');
								
								var node = new A.TreeNode(
									{
										id: 'departmentNode' + departmentId,
										label: departmentContent,
										leaf: false,
										draggable: true,
										expanded: expanded,
										on: {
											select: function(event) {
												
												if(instance._hasChildDepartment(departmentId)){
													node.expand();
												}
												
												instance._selectedDepartmentId = item.departmentId;
												
												var contactsContainer = A.one(instance.idPrefix + CONTACTS_CONTAINER);
												
												instance._showLoadingAnimation(contactsContainer);
												
												instance._loadDepartmentContacts();
												
												instance._showDepartmentInfomation();

											}
										}
									}
								);

								var parentId = 'departmentNode' + parentDepartmentId;
								var parentNode = instance._departmentsTreeView.getNodeById(parentId) || instance._departmentsTreeView;

								parentNode.appendChild(node);

								if (hasChild) {
									instance._buildDepartmentTreeView(departments, departmentId);
								}
							}
						);

						return childrentDepartments.length;
					},
					
					
					/**
					 * Hiển thị thông tin Phòng/Ban
					 */
					_showDepartmentInfomation : function(){
						
						var instance = this;

						var contactDetailContainer = A.one(instance.idPrefix + CONTACTS_DETAIL_CONTAINER);
						
						instance._showLoadingAnimation(contactDetailContainer);
						
						Liferay.Service.contacts.ContactsDepartment.getDepartment(
								{
									departmentId : instance._selectedDepartmentId
								},
								function(result){
									if(result){
										
										var buffer = [];
										
										var department = A.clone(result);
										
										buffer.push(Lang.sub(DEPARTMENT_INFO_TEMPLATE, department));
										
										contactDetailContainer.empty();
										
										contactDetailContainer.html(buffer.join(''));
										
										var viewDepartmentBtn = A.one('#' + VIEW_DEPARTMENT_BTN_ID);
										
										if(viewDepartmentBtn){
											viewDepartmentBtn.on(EVENT_CLICK,function(){
												instance._showDataDialogForm(VIEW_DEPARTMENT_COMMAND, DEPARTMENT_UPDATE_FORM_TITLE);
											});
										}
										
										var updateDepartmentBtn = A.one('#' + UPDATE_DEPARTMENT_BTN_ID);
										
										if(updateDepartmentBtn){
											updateDepartmentBtn.on(EVENT_CLICK,function(){
												instance._showDataDialogForm(UPDATE_DEPARTMENT_COMMAND, DEPARTMENT_UPDATE_FORM_TITLE);
											});
										}
										
										var deleteDepartmentBtn = A.one('#' + DELETE_DEPARTMENT_BTN_ID);
										
										if(deleteDepartmentBtn){
											deleteDepartmentBtn.on(EVENT_CLICK,function(){
												
												if(instance._confirmDelete(DELETE_DEPARTMENT_CONFIRM_MESSAGE)){
													
													instance._deleteDepartment(
														instance._selectedDepartmentId,
														function(){
															instance._initializeDepartmentTreeView();
															instance._initializeDefaultContactData();
														}
													);
												}
											});
										}
									}
								}
						);
					},
					
					/**
					 * Lấy Id của Phòng/Ban được chọn
					 * @param departmentNode
					 * @returns
					 */
					_getDepartmentNodeId: function(departmentNode) {

						var nodeId = departmentNode.get('id') || '';
						
						var departmentId = nodeId.replace('departmentNode', '');

						if (Lang.isGuid(departmentId)) {
							departmentId = '';
						}

						return departmentId;
					},
					
					/**
					 * Lấy Id cấp trên của Phòng/Ban được chọn
					 * @param departmentNode
					 * @returns
					 */
					_getParentDepartmentNodeId: function(departmentNode) {
						var instance = this;

						var parentNode = departmentNode.get(PARENT_NODE);

						return instance._getDepartmentNodeId(parentNode);
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
					 * Hiển thị danh sách Cá nhân theo các Phòng/Ban
					 * @param callback
					 */
					_loadDepartmentContacts : function(callback){
						
						var instance = this;
						
						instance._getDepartmentContacts(
							instance._selectedDepartmentId,
							function(result){
								
								var departmentContacts = result.departmentContacts;
								
								if(departmentContacts){
									instance._buildContactTreeView(departmentContacts);
								}

								if (callback) {
									callback();
								}
							}
						);
					},
					
					/**
					 * Tạo Treeview cho danh sách Cá nhân thuộc Phòng/Ban
					 * @param contactsList
					 * @returns
					 */
					_buildContactTreeView : function(contactsList){
						
						var instance = this;
						
						var contactTreeContainer = A.one(instance.idPrefix + CONTACTS_CONTAINER);
						
						contactTreeContainer.empty();
						
						if (contactsList.length <= 0) {
							contactTreeContainer.append(EMPTY_DATA_MESSAGE_TEMPLATE);
							return;
						}
						
						var contactBoundingBox = Node.create(CONTACT_TREE_BOUNDING_TEMPLATE);
						
						contactTreeContainer.append(contactBoundingBox);
						
						instance._contactsTreeView = new ContactsTree(
							{
								boundingBox: contactBoundingBox,
								on: {
									dropInsert: function(event) {
										
										var tree = event.tree;
										
										var dragNode = tree.dragNode;
										
										var parentNode = dragNode.get(PARENT_NODE);
										
										var dragNodeId = instance._getContactNodeId(dragNode);
										
										var dragNodeIndex = parentNode.indexOf(dragNode);
										
										instance._updateContactState(dragNodeId, dragNodeIndex);
									}
								},
								type: 'normal'
							}
						).render();
						
						A.each(
							contactsList,
							function(item, index, collection) {
								
								var contactId = item.contactId;
								
								var buffer = [];
								
								var contactItem = A.clone(item);
								
								buffer.push(Lang.sub(CONTACT_TREE_NODE_TEMPLATE, contactItem));
								
								var contactItemContent = buffer.join('');
								
								var contactNode = new A.TreeNode(
									{
										id: 'contactNode' + contactId,
										label: contactItemContent,
										leaf: false,
										draggable: true,
										expanded: false,
										on: {
											select: function(event) {
												
												instance._selectedContactId = item.contactId;
												instance._showContactInfomation();
											}
										}
									}
								);
								
								instance._contactsTreeView.appendChild(contactNode);
							}
						);
					},
					
					/**
					 * Lấy Id của contactNode được chọn
					 * @param contactNode
					 * @returns
					 */
					_getContactNodeId: function(contactNode) {

						var nodeId = contactNode.get('id') || '';
						
						var contactNodeId = nodeId.replace('contactNode', '');

						if (Lang.isGuid(contactNodeId)) {
							contactNodeId = '';
						}

						return contactNodeId;
					},
					
					/**
					 * Hiển thị thông tin liên hệ của cá nhân
					 */
					_showContactInfomation : function(){
						
						var instance = this;

						var contactDetailContainer = A.one(instance.idPrefix + CONTACTS_DETAIL_CONTAINER);
						
						instance._showLoadingAnimation(contactDetailContainer);
						
						Liferay.Service.contacts.Contacts.getContact(
							{
								contactId: instance._selectedContactId
							},
							function(result){
								if(result){
									
									var contact = result;
									
									instance._buildContactDetailsContent(contact);
								}
							}
						);
					},
					
					/**
					 * Tạo form hiển thị thông tin liên hệ của cá nhân
					 */
					_buildContactDetailsContent : function(contact){
						
						var instance = this;
						
						if(contact){
							
							Liferay.Service.contacts.Contacts.getContactPortraitURL(
								{
									imagePath: themeDisplay.getPathImage(),
									contactId : contact.imageId
								},
								function(result){
									if(result){
										
										var contactPortraitURL = result;
										
										var contactDetailContent = '<div class="contact-info">'
																 + 		'<div class="contact-portrait">'
																 + 			'<img class="contact-portrait-img" align="left" src="'
																 + 				contactPortraitURL
																 + 			'" />'
																 + 		'</div>'
																 + 		'<div class="contact-name">'
																 + 				contact.contactName
																 + 		'</div>'
																 + 		'<div class="contact-job-title">'
																 + 			contact.jobTitle
																 + 		'</div>'
																 + 		'<div class="contact-attribute">'
																 + 			Liferay.Language.get('contact-phone-numbers') + ': '
																 + 			contact.phoneNumbers
																 + 		'</div>'
																 + 		'<div class="contact-attribute">'
																 + 			Liferay.Language.get('contact-mobile-numbers') + ': '
																 + 			contact.mobile
																 + 		'</div>'
																 + 		'<div class="contact-attribute">'
																 + 			Liferay.Language.get('contact-email') + ': '
																 + 			contact.email
																 + 		'</div>'
																 + '</div>'
																 + '<div class="action-btn-row">'
																 + 		'<input type="button" id="viewContactBtn" value="'
																 + 			Liferay.Language.get('view-contact-info')
																 + 		'"/>'
																 + 		'<input type="button" id="updateContactBtn" value="'
																 + 			Liferay.Language.get('update')
																 + 		'"/>'
																 + 		'<input type="button" id="deleteContactBtn" value="'
																 + 			Liferay.Language.get('delete-contact')
																 + 		'"/>'
																 + '</div>';
																 
										var contactDetailContainer = A.one(instance.idPrefix + CONTACTS_DETAIL_CONTAINER);
										
										contactDetailContainer.empty();
										
										contactDetailContainer.html(contactDetailContent);
										
										
										var viewContactBtn = A.one('#' + VIEW_CONTACT_BTN_ID);
										
										if(viewContactBtn){
											viewContactBtn.on(EVENT_CLICK,function(){
												instance._showDataDialogForm(VIEW_CONTACT_COMMAND, CONTACT_UPDATE_FORM_TITLE);
											});
										}
										
										var updateContactBtn = A.one('#' + UPDATE_CONTACT_BTN_ID);
										
										if(updateContactBtn){
											updateContactBtn.on(EVENT_CLICK,function(){
												instance._showDataDialogForm(UPDATE_CONTACT_COMMAND, CONTACT_UPDATE_FORM_TITLE);
											});
										}
										
										var deleteContactBtn = A.one('#' + DELETE_CONTACT_BTN_ID);
										
										if(deleteContactBtn){
											deleteContactBtn.on(EVENT_CLICK,function(){
												
												if(instance._confirmDelete(DELETE_CONTACT_CONFIRM_MESSAGE)){
													
													instance._deleteContacts(
														instance._selectedContactId,
														function(){
															instance._loadDepartmentContacts();
														}
													);
												}
											});
										}
									}
								}
							);
						}
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
					 * Cập nhật thứ tự hiển thị của Phòng/Ban
					 * @param departmentId - Id của Phòng/Ban
					 * @param displayPriority - Thứ tự ưu tiên hiển thị.Mặc định là 0
					 * @param callback
					 */
					_updateDepartmentState : function(departmentId,displayPriority){
						
						Liferay.Service.contacts.ContactsDepartment.updateDepartmentState(
							{
								departmentId: departmentId,
								displayPriority : displayPriority
							}
						);
					},
					
					/**
					 * Cập nhật Id cấp trên của Phòng/Ban.Áp dụng cho trường hợp chuyển vị trí Phòng/Ban từ Đơn vị này sang đơn vị khác.
					 * @param departmentId - Id của Phòng/Ban
					 * @param parentDepartmentId - Id của Đơn vị mới
					 * @param callback
					 */
					_updateDepartmentParent : function(departmentId,parentDepartmentId){
						
						Liferay.Service.contacts.ContactsDepartment.updateDepartmentParent(
							{
								departmentId: departmentId,
								parentDepartmentId : parentDepartmentId
							}
						);
					},
					
					/**
					 * Xóa thông tin Phòng/Ban
					 * @param departmentId
					 * @param callback
					 */
					_deleteDepartment : function(departmentId,callback){
						
						var instance = this;
						
						Liferay.Service.contacts.ContactsDepartment.deleteDepartment(
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
					
					/**
					 * Lấy thông tin liên hệ cuả cá nhân theo Id
					 * @param contactId
					 * @param callback
					 */
					_getContact : function(contactId,callback){
						
						var instance = this;
						
						Liferay.Service.contacts.Contacts.getContact(
							{
								contactId : contactId
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
					},
					
					/**
					 * Cập nhật thứ tự hiển thị thông tin liên hệ của Cá nhân
					 * @param contactId
					 * @param displayPriority
					 */
					_updateContactState : function(contactId,displayPriority){
						
						Liferay.Service.contacts.Contacts.updateContactState(
							{
								contactId : contactId,
								displayPriority : displayPriority
							}
						);
					},
					
					/**
					 * Cập nhật Id Phòng/Ban của Cá nhân
					 * @param contactId
					 * @param departmentId
					 */
					_updateContactDepartment : function(contactId,departmentId){
						
						Liferay.Service.contacts.Contacts.updateContactDepartment(
							{
								contactId : contactId,
								departmentId : departmentId
							}
						);
					},
					
					
					/**
					 * Xóa thông tin liên hệ của cá nhân theo Id
					 * @param contactId
					 * @param callback
					 */
					_deleteContacts : function(contactId,callback){
						
						var instance = this;
						
						Liferay.Service.contacts.Contacts.deleteContacts(
							{
								contactId : contactId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					/**
					 * Hiển thị form update thông tin liên hệ của Phòng ban/Cá nhân
					 * @param actionCommand
					 * @param formTitle
					 */
					_showDataDialogForm : function(actionCommand,formTitle){
						
						var instance = this;
						
						instance._hideDialogPanels();

						var dialogURL = instance._createPortletRenderURL(actionCommand);

						if(!instance.dataFormDialogPanel){
														
							var dialogAlignConfig = {
									node: instance.idPrefix + CONTACTS_CONTAINER,
									points: ['tl', 'tl']
							};
							
							instance.dataFormDialogPanel = new A.Dialog({
									align: dialogAlignConfig,
									title: Liferay.Language.get(formTitle),
									resizable: true,
									destroyOnClose: true,
									width: 360,
									zIndex: 1000
							}).render();
							
							instance.dataFormDialogPanel.plug(
								A.Plugin.IO,{
									autoLoad: false,
									uri: dialogURL.toString()
								}
							);
							instance.dataFormDialogPanel.hide();
						}
						
						instance.dataFormDialogPanel.show();
						instance.dataFormDialogPanel.io.start();
					},
					
					/**
					 * Tạo URL đến đường dẫn file jsp vẽ form update thông tin liên hệ Phòng/Ban hoặc Cá nhân
					 * @param actionCommand
					 * @returns
					 */
					_createPortletRenderURL : function(actionCommand){
						
						var instance = this;
						
						var renderURL = Liferay.PortletURL.createRenderURL();
						
						if(renderURL){
							
							renderURL.setPortletId(instance.portletId);
							renderURL.setWindowState('exclusive');
							
							var jspPath = '';
							
							if(actionCommand == ADD_NEW_DEPARTMENT_COMMAND){
								renderURL.setParameter('parentDepartmentId', instance._selectedDepartmentId);
								jspPath = '/html/contacts_admin/departments/department_update_form.jsp';
								
							}else if(actionCommand == VIEW_DEPARTMENT_COMMAND){
								renderURL.setParameter('departmentId', instance._selectedDepartmentId);
								jspPath = '/html/contacts_admin/departments/department_details.jsp';
								
							}else if(actionCommand == UPDATE_DEPARTMENT_COMMAND){
								renderURL.setParameter('departmentId', instance._selectedDepartmentId);
								jspPath = '/html/contacts_admin/departments/department_update_form.jsp';
								
							}else if(actionCommand == ADD_NEW_CONTACT_COMMAND){
								renderURL.setParameter('departmentId', instance._selectedDepartmentId);
								jspPath = '/html/contacts_admin/contacts/contact_update_form.jsp';
								
							}else if(actionCommand == VIEW_CONTACT_COMMAND){
								renderURL.setParameter('contactId', instance._selectedContactId);
								jspPath = '/html/contacts_admin/contacts/contact_details.jsp';
								
							}else if(actionCommand == UPDATE_CONTACT_COMMAND){
								renderURL.setParameter('contactId', instance._selectedContactId);
								jspPath = '/html/contacts_admin/contacts/contact_update_form.jsp';
								
							}else{
								
								jspPath = '/html/contacts_admin/invalid_command.jsp';
							}
							renderURL.setParameter('jspPage', jspPath);
							renderURL.setDoAsGroupId(instance.scopeGroupId);
						}
						
						return renderURL;
					},
					
					
					/**
					 * Hiển thị animation khi load dữ liệu
					 * @param container
					 */
					_showLoadingAnimation: function(container) {

						A.all(container).html('<div class="loading-animation" />');
						
						//container.plug(A.LoadingMask, { background: '#d2d2d2' });
						
						//container.loadingmask.toggle();
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
					 * Hiển thị Dialog xác nhận lệnh xóa dữ liệu
					 * @param message
					 * @returns
					 */
					_confirmDelete : function(message){
						
						return confirm(Liferay.Language.get(message));
					},

					//Id của Phòng/Ban hiện đang được chọn
					_selectedDepartmentId : 0,
					
					//Id của Cá nhân hiện đang được chọn
					_selectedContactId : 0
				}
			}
		);
		
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
		
		var ContactsTree = A.Component.create(
			{
				NAME: 'ContactsTree',

				EXTENDS: A.TreeViewDD,

				prototype: {

					_onDropHit: function(event) {
						var instance = this;
						ContactsTree.superclass._onDropHit.apply(instance, arguments);
						
					},

					_updateNodeState: function(event) {
						var instance = this;
						ContactsTree.superclass._updateNodeState.apply(instance, arguments);
					},
				}
			}
		);

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
		
		Liferay.Portlet.ContactsAdmin = ContactsAdmin;
		
		Liferay.Portlet.ContactsLiveSearch = ContactsLiveSearch;
	},
	'',
	{
		requires: ['aui-dialog','aui-loading-mask','aui-dialog-iframe','aui-tree-view','json','liferay-portlet-url', 'liferay-util-window','aui-live-search','autocomplete-base']
	}
);