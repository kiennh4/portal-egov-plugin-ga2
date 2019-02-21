AUI.add(
	'portal-egov-sitemap',
	
	function(A) {
		
		var Lang = A.Lang;
		
		var Node = A.Node;
		
		var LAYOUT_NODE_ID_PREFIX = 'layoutNode';
		
		var LAYOUT_TREE_BOUNDING_TEMPLATE 	='<div class="layout-treeview-container" id="layoutsTreeContainer"></div>';
		
		var LAYOUT_TREE_NODE_TEMPLATE 		='<div class="layout-item-content-wrapper">'
											+	'<div class="layout-name">'
											+ 		'<a href="{friendlyURL}" title="{nameCurrentValue}">{nameCurrentValue}</a>'
											+	'</div>'	
											+'</div>';
		
		var SiteMap = A.Component.create(
			{
				EXTENDS: A.Base,

				NAME: 'sitemap',

				prototype: {
					
					initializer: function(config) {
						
						var instance = this;
						
						//GroupId lấy từ config
						instance.scopeGroupId = config.scopeGroupId;
						
						//Container chứa LayoutTree
						instance.siteMapContainer = A.one('#' + config.container);
						
						//Id của Layout gốc được chọn trên trang config
						instance.rootLayoutId = config.rootLayoutId;
						
						instance.expandAllLayout = config.expandAllLayout;
						
						instance.highLightCurrentLayout = config.highLightCurrentLayout;
						
						if(instance.siteMapContainer){
							
							instance._showLoadingAnimation(instance.siteMapContainer);
							instance._getPublicLayouts(
								function(result){

									var publicLayouts = result;
									
									if(publicLayouts){
										instance._initializeLayoutsTree(publicLayouts);
									}
								}
							);
						}
					},
					
					/**
					 * Khởi tạo Layout Tree
					 * @param publicLayouts
					 */
					_initializeLayoutsTree : function(publicLayouts){
						
						var instance = this;
						
						instance.siteMapContainer.empty();

						var layoutTreeBoundingBox = Node.create(LAYOUT_TREE_BOUNDING_TEMPLATE);

						instance.siteMapContainer.append(layoutTreeBoundingBox);
						
						instance.layoutTree = new A.TreeView(
							{
								boundingBox: layoutTreeBoundingBox,
								type: 'normal'
							}
						).render();
						
						
						instance._buildLayoutTreeNode(publicLayouts, instance.rootLayoutId);
					},
					
					/**
					 * Tạo TreeNode cho từng Layout
					 * @param publicLayouts
					 * @param parentLayoutId
					 * @returns
					 */
					_buildLayoutTreeNode : function(publicLayouts,parentLayoutId){
						
						var instance = this;
						
						var childLayouts = instance._filterLayouts(publicLayouts, parentLayoutId);
						
						A.each(
							childLayouts,
							function(item, index, collection) {
								
								var expanded = false;
								
								var buffer = [];
								
								var layoutItem = A.clone(item);
								
								var layoutId = layoutItem.layoutId;
								
								buffer.push(Lang.sub(LAYOUT_TREE_NODE_TEMPLATE, layoutItem));
								
								var layoutItemContent = buffer.join('');
								
								var hasChild = instance._filterLayouts(publicLayouts, layoutId).length;
								
								if(hasChild && instance.expandAllLayout){
									expanded = true;
								}
								
								var layoutNode = new A.TreeNode(
									{
										id: LAYOUT_NODE_ID_PREFIX + layoutId,
										label: layoutItemContent,
										leaf: false,
										draggable: false,
										expanded: expanded
									}
								);
								
								var parentLayoutNodeId = LAYOUT_NODE_ID_PREFIX + parentLayoutId;
								var parentLayoutNode = instance.layoutTree.getNodeById(parentLayoutNodeId) || instance.layoutTree;
								
								if(instance.highLightCurrentLayout){
									
									//LayoutId của Trang hiện tại
									var currentLayoutId = themeDisplay.getLayoutId();
									
									if(currentLayoutId == layoutId){
										
										layoutNode.select();
										
										if(hasChild){
											
											layoutNode.expand();
										}
										
										var currentParentLayoutId = layoutItem.parentLayoutId;
										
										var currentParentLayoutNode = instance.layoutTree.getNodeById(LAYOUT_NODE_ID_PREFIX + currentParentLayoutId);
										
										if(currentParentLayoutNode){
											currentParentLayoutNode.expand();
										}
									}
								}

								parentLayoutNode.appendChild(layoutNode);

								if (hasChild) {
									instance._buildLayoutTreeNode(publicLayouts, layoutId);
								}
							}
						);
						
						return childLayouts.length;
					},
					
					
					/**
					 * Sắp xếp Layout theo nhóm đệ quy
					 * @param publicLayouts
					 * @param parentLayoutId
					 * @returns {Boolean}
					 */
					_filterLayouts: function(publicLayouts, parentLayoutId) {
						
						var filteredLayouts;

						if (Lang.isArray(publicLayouts)) {
							filteredLayouts = A.Array.filter(
								publicLayouts,
								function(item, index, collection) {
									return (item.parentLayoutId == parentLayoutId);
								}
							);
						}
						return filteredLayouts || [];
					},
					
					
					/**
					 * Hiển thị animation khi load dữ liệu
					 * @param container
					 */
					_showLoadingAnimation: function(container) {

						A.all(container).html('<div class="loading-animation" />');
					},
					
					/**
					 * Get tất cả public layouts hiện có theo groupId
					 * @param callback
					 */
					_getPublicLayouts : function(callback){
						
						var instance = this;
						
						Liferay.Service.Portal.Layout.getLayouts(
							{
								groupId : instance.scopeGroupId,
								privateLayout: false
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
		
		Liferay.Portlet.SiteMap = SiteMap;
	},
	'',
	{
		requires: ['aui-tree-view','json','liferay-portlet-url']
	}
);