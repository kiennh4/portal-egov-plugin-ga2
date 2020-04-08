AUI.add(
	'portal-egov-admin-panel',
	
	function(A) {
		
		var AdminPanel = A.Component.create(
			{
				EXTENDS: A.Base,

				NAME: 'adminpanel',

				prototype: {
					
					initializer: function(config) {
						
						var instance = this;
						
						//Tên Panel
						instance.panelTitle = config.panelTitle;
						
						//Chiều dài của Panel
						instance.panelWidth = config.panelWidth;
						
						//Chiều rộng của Panel
						instance.panelHeight = config.panelHeight;
						
						//Hiển thị giữa màn hình ? (true/false)
						instance.panelAlignCentered = config.panelAlignCentered;
						
						//Hiển thị tại vị trí của 1 Node bất kỳ trên trang 
						//(Dựa vào Id của node,vị trí Panel hiển thị mặc định là đặt ngang bằng bên phải so với vị trí của node)
						instance.panelAlignNodeId = config.panelAlignNodeId;
						
						//Có khả năng co giãn kích thước
						instance.panelResizeable = config.panelResizeable;
						
						//URL trỏ đến trang jsp hiển thị nội dung trên Panel
						instance.panelURI = config.panelURI;
						
						instance._createAdminPanel();
						alert('4');
						
					},
					
					//Tạo Panel
					_createAdminPanel: function(){
						
						var instance = this;
						
						var adminPanelAlignConfig = instance._createAdminPanelAlignConfig();
						alert('3');
						//Khởi tạo Panel
						var adminPanel = new A.Dialog(
								{
									title: instance.panelTitle,
									width: instance.panelWidth,
									height: instance.panelHeight,
									centered: instance.panelAlignCentered,
									align: adminPanelAlignConfig,
									resizable: instance.panelResizeable,
									cssClass: 'portal-egov-admin-panel',
									zIndex: 1000
								}
						).render();
						
						//Bind nội dung vào Panel theo URI cấu hình
						
						adminPanel.plug(
							A.Plugin.IO,
							{
								autoLoad: false,
								uri: instance.panelURI
							}
						);
						
						adminPanel.hide();
					},
					
					//Tạo thông tin cấu hình vị trí hiển thị Panel (Chỉ áp dụng cho trường hợp panelAlignCentered = false)
					_createAdminPanelAlignConfig: function(){
						alert('2');
						var instance = this;
						
						var adminPanelAlignConfig = {
								node: '#' + instance.panelAlignNodeId,
								points: ['tl', 'tr']
						};
						
						return adminPanelAlignConfig;
					},
				}
			}	
		);
	},
	'',
	{
		requires: ['aui-dialog']
	}
);