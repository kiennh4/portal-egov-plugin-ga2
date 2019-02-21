AUI.add(
	'portal-egov-tourism-map-portlet',
	function(A) {
		
		var Lang = A.Lang;
		
		var EVENT_CLICK = 'click';
		
		var MAP_CONTAINER = 'map_container';
		
		var MENU_CONTAINER = 'menu_container';
		
		var MARKER_LIST_CONTAINER = 'marker_list_container';
		
		var ROOT_GROUP_TEMPLATE 	= '<li class="group-item results-row selected" data-markerGroupId="0">'
									+ 	'<div class="group-item-content-wrapper">'
									+ 		'<span class="group-name">'
									+ 			'<a href="javascript:;" data-markerGroupId="0">'
									+ 				'Tất cả địa danh'
									+ 			'</a>'
									+ 		'</span>'	
									+ 	'</div>'
									+ '</li>';
		
		var GROUP_ITEM_TEMPLATE 	= '<li class="group-item results-row {cssClassSelected}" data-markerGroupId="{markerGroupId}">'
									+ 	'<div class="group-item-content-wrapper">'
									+ 		'<span class="group-name">'
									+ 			'<a href="javascript:;" data-markerGroupId="{markerGroupId}">{markerGroupName}</a>'
									+ 		'</span>'	
									+ 	'</div>'
									+ '</li>';
		
		var MARKER_ITEM_TEMPLATE 	= '<li class="marker-item results-row" data-markerId="{markerId}">'
									+ 	'<div class="marker-item-content-wrapper">'
									+ 		'<span class="marker-name">'
									+ 			'<a href="javascript:;" data-markerId="{markerId}">{markerTitle}</a>'
									+ 		'</span>'	
									+ 	'</div>'
									+ '</li>';
		
		var TourismMap = A.Component.create(
			{
				EXTENDS: A.Base,
				NAME: 'tourismmap',
				prototype: {
					
					initializer: function(config) {
						
						var instance = this;
						
						instance.tourismMap = null;
						
						instance.markerArray = [];
						
						instance.markerInfoWindow = null;
						
						instance._originalConfig = config;
						
						instance.scopeGroupId = config.scopeGroupId;
						instance.defaultMapType = config.defaultMapType;
						instance.defaultZoomLevel = config.defaultZoomLevel;
						instance.mapCenterLatitude = config.mapCenterLatitude;
						instance.mapCenterLongitude = config.mapCenterLongitude;
						
						instance._initializeMap();
						
						instance._showGroupsMenu();
						
						instance._showAllMarkers();
						
						var groupMenuList = A.one(instance._groupMenuContainer);
						
						groupMenuList.on(EVENT_CLICK, instance._onGroupMenuClick, instance);
						
						var markerList = A.one(instance._markerListContainer);
						
						markerList.on(EVENT_CLICK, instance._onMarkerClick, instance);
					},
					
					/**
					 * Khởi tạo bản đồ theo những thông tin cấu hình truyền vào ban đầu
					 */
					_initializeMap : function(){
						
						var instance = this;
						
						var mapContainer = A.one('#' + MAP_CONTAINER);
						
						instance._showLoadingAnimation(mapContainer);
						
						//Toa do tam ban do
						var mapCenterLatLng = new google.maps.LatLng(instance.mapCenterLatitude, instance.mapCenterLongitude);
						
						var mapOptions ={
								mapTypeId: instance.defaultMapType,
								center: mapCenterLatLng,
								zoom: instance.defaultZoomLevel
						};
						//Khởi tạo bản đồ
						instance.tourismMap = new google.maps.Map(document.getElementById(MAP_CONTAINER), mapOptions);
						
						//Đánh dấu điểm trung tâm bản đồ
						var centerMarker = new google.maps.Marker();
						
						centerMarker.setPosition(mapCenterLatLng);
						centerMarker.setDraggable(true);
						centerMarker.setAnimation(google.maps.Animation.DROP);
						centerMarker.setClickable(true);
						centerMarker.setVisible(true);
						
						centerMarker.setMap(instance.tourismMap);
					},
					
					/**
					 * Hiển thị menu các nhóm địa điểm đánh dấu trên bản đồ
					 * @param callback
					 */
					_showGroupsMenu : function(callback){
						
						var instance = this;
						
						var buffer = [];
						
						var groupMenuContainer = A.one(instance._groupMenuContainer);
						
						instance._showLoadingAnimation(groupMenuContainer);
						
						buffer.push('<ul>');
						buffer.push(ROOT_GROUP_TEMPLATE);
						
						instance._getJsonGroups(
							function(result){
								
								var markerGroups = result.markerGroups;
								
								A.each(
										markerGroups,
										function(item, index, collection){
											
											var groupItem = A.clone(item);
											
											buffer.push(Lang.sub(GROUP_ITEM_TEMPLATE, groupItem));
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
					 * Hiển thị tất cả các điểm đánh dấu trên bản đồ
					 */
					_showAllMarkers : function(){
						
						var instance = this;
						
						instance._getJsonMarkers(
							function(result){
								
								var markerList = result.markers;
								
								if(markerList){
									instance._displayMarkerList(markerList);
								}
							}
						);
					},

					/**
					 * Xử lý sự kiện khi người dùng click vào tên nhóm địa điểm
					 * @param event
					 */
					_onGroupMenuClick : function(event){
						
						var instance = this;
						
						//Lấy Id của group được chọn
						var selectedGroupId = instance._getSelectedGroupId(event.target);
						
						//Lấy đối tượng được chọn theo Id
						var selectedGroup = A.one('li[data-markerGroupId="' + selectedGroupId + '"]');
						
						if(selectedGroup){
							
							//Loại bỏ hết class 'selected' của những group được chọn trước
							A.all(instance._groupMenuItemSelector).removeClass('selected');
							
							//Add class selected cho group được chọn hiện tại
							selectedGroup.addClass('selected');
							
							//Loại bỏ hết những điểm đánh dấu hiện đang hiển thị trên bản đồ
							instance._clearMarkers();
				        	
							//Ẩn các cửa sổ thông tin marker
							if (instance.markerInfoWindow) {
								instance.markerInfoWindow.close();
								instance.markerInfoWindow = null;
							}
							
							//Hiển thị danh sách những điểm đánh dấu trên menu và Drop xuống bản đồ
							instance._showMarkersBySelectedGroup(selectedGroupId);
						}
					},
					
					/**
					 * Lấy Id của nhóm trên group menu khi được chọn
					 */
					_getSelectedGroupId : function(exp){
						return A.one(exp).attr('data-markerGroupId');
					},
					
					
					/**
					 * Xử lý sự kiện người dùng click vào tên địa điểm được đánh dấu trên menu bên phải
					 * @param event
					 */
					_onMarkerClick : function(event){
						
						var instance = this;
						
						//Lấy Id của marker được chọn
						var selectedMarkerId = instance._getSelectedMarkerId(event.target);
						
						//Lấy đối tượng được chọn theo Id
						var selectedMarkerItem = A.one('li[data-markerId="' + selectedMarkerId + '"]');
						
						if(selectedMarkerItem){
							
							//Loại bỏ hết class 'selected' của những marker được chọn trước
							A.all(instance._markerItemSelector).removeClass('selected');
							
							//Add class selected cho marker được chọn hiện tại
							selectedMarkerItem.addClass('selected');
							
							//Lấy và hiển thị thông tin của marker được chọn trên bản đồ
							instance._getJsonMarker(
								selectedMarkerId,
								function(result){
									
									var selectedMarker = result;
									
									if(selectedMarker){
										
										var markerLatLng = new google.maps.LatLng(selectedMarker.markerLatitude, selectedMarker.markerLongitude);
										
										var marker = new google.maps.Marker();
										
										marker.setPosition(markerLatLng);
										marker.setTitle(selectedMarker.markerTitle);
										marker.setDraggable(true);
										marker.setAnimation(google.maps.Animation.DROP);
										marker.setClickable(true);
										marker.setVisible(true);
										
										var markerInfoContent = instance._buildMarkerInfoContent(selectedMarker);
										
										instance._showMarkerInfo(marker, markerInfoContent);
									}
								}
							);
						}
					},
					
					/**
					 * Lấy Id của marker được chọn
					 * @param exp
					 */
					_getSelectedMarkerId : function(exp){
						return A.one(exp).attr('data-markerId');
					},
					
					/**
					 * Tạo html content cho điểm đánh dấu (marker)
					 * @param marker
					 */
					_buildMarkerInfoContent : function(marker){
						
						if(marker){
							
							var markerTitle = marker.markerTitle;
							var markerAddress = marker.markerAddress;
							var markerInfo = marker.markerInfo;
							
							var markerImagePath = Liferay.ThemeDisplay.getPathImage() + '/logo?img_id=' + marker.markerImageId;
							
							var markerInfoContent = '<div class="marker-info-wrapper">';
								markerInfoContent += 	'<span class="marker-title">' + markerTitle + '</span>';
								markerInfoContent += 	'</br>';
								markerInfoContent += 	'<span class="marker-address">' + markerAddress + '</span>';
								markerInfoContent += 	'<div style="clear: both;"></div>';
								markerInfoContent += 	'<span class="marker-image">';
								markerInfoContent += 		'<img src="' + markerImagePath + '"/>';
								markerInfoContent += 	'</span>';
								markerInfoContent += 	'<span class="marker-info">' + markerInfo + '</span>';
								markerInfoContent += '</div>';
							
							return markerInfoContent;
						}
					},
					
					/**
					 * Hiển thị những điểm đánh dấu theo nhóm được chọn
					 * @param markerGroupId Id của nhóm 
					 * @param callback
					 */
					_showMarkersBySelectedGroup : function(selectedGroupId,callback){
						
						var instance = this;
						
						if(selectedGroupId > 0){
							
							instance._getJsonMarkersByGroup(
								selectedGroupId,
								function(result){
									
									var markerList = result.markers;
									
									if(markerList){
										instance._displayMarkerList(markerList);
									}
								}
							);
						
						}else{
							
							instance._getJsonMarkers(
								function(result){
									
									var markerList = result.markers;
									
									if(markerList){
										instance._displayMarkerList(markerList);
									}
								}
							);
						}
					},
					/**
					 * Tạo nội dung html hiển thị danh sách các điểm đánh dấu trên khung menu
					 * @param markerList
					 */
					_displayMarkerList : function(markerList){
						
						var instance = this;
						
						var markerListContainer = A.one(instance._markerListContainer);
						
						if(markerList && markerListContainer){
							
							instance._showLoadingAnimation(markerListContainer);
							
							var buffer = [];
							
							buffer.push('<ul>');
							
							A.each(
									markerList,
									function(item, index, collection){
										
										var markerItem = A.clone(item);
										
										buffer.push(Lang.sub(MARKER_ITEM_TEMPLATE, markerItem));
										
										var markerImagePath = Liferay.ThemeDisplay.getPathImage() + '/logo?img_id=' + markerItem.markerImageId;
										
										instance._addMapMarker(markerItem.markerTitle, markerItem.markerLatitude, markerItem.markerLongitude,
												markerItem.markerAddress, markerItem.markerInfo, markerImagePath);
									}
							);
							buffer.push('</ul>');
							
							markerListContainer.html(buffer.join(''));
							
							instance._dropMarkerList();
						}
					},					
					
					/**
					 * Hiển thị các điểm đánh dấu trên bản đồ với hiệu ứng DROP
					 */
					_dropMarkerList : function(){
						var instance = this;
						if (instance.markerArray && instance.tourismMap) {
							for (var i = 0; i < instance.markerArray.length; i++) {					
								var marker = instance.markerArray[i];
								
								setTimeout(instance._dropMarker(marker), i*200);
							}
						}
					},
					
					_dropMarker : function(marker){
						var instance = this;
						if(marker && instance.tourismMap){
							
							return function(){
								marker.setMap(instance.tourismMap);
							};
						}
					},
					
					/**
					 * Add tọa độ và thông tin điểm đánh dấu trên bản đồ
					 * @param markerTitle - Tên điểm đánh dấu
					 * @param markerLatitude - Vĩ độ của điểm đánh dấu
					 * @param markerLongitude - Kinh độ của điểm đánh dấu
					 * @param markerInfo - Thông tin điểm đánh dấu
					 * @param markerImageURL - URL đến ảnh mô tả
					 */
					_addMapMarker : function(markerTitle,markerLatitude,markerLongitude,markerAddress,markerInfo,markerImageURL){
						
						var instance = this;
						
						var markerLatLng = new google.maps.LatLng(markerLatitude, markerLongitude);
						
						var marker = new google.maps.Marker();
						
						marker.setPosition(markerLatLng);
						marker.setTitle(markerTitle);
						marker.setDraggable(true);
						marker.setAnimation(google.maps.Animation.DROP);
						marker.setClickable(true);
						marker.setVisible(true);
						
						google.maps.event.addListener(marker, 'click', function() {
							
							var markerInfoContent = '<div class="marker-info-wrapper">';
								markerInfoContent += 	'<span class="marker-title">' + markerTitle + '</span>';
								markerInfoContent += 	'</br>';
								markerInfoContent += 	'<span class="marker-address">' + markerAddress + '</span>';
								markerInfoContent += 	'<div style="clear: both;"></div>';
								markerInfoContent += 	'<span class="marker-image">';
								markerInfoContent += 		'<img class="marker-image" src="' + markerImageURL + '"/>';
								markerInfoContent += 	'</span>';
								markerInfoContent += 	'<span class="marker-info">' + markerInfo + '</span>';
								markerInfoContent += '</div>';
							
							instance._showMarkerInfo(marker, markerInfoContent);	
						});
						
						instance.markerArray.push(marker);
					},
					
					/**
					 * Hiển thị thông tin địa điểm được đánh dấu
					 * @param marker
					 * @param markerInfoContent
					 */
			        _showMarkerInfo : function(marker,markerInfoContent) {
			        	
			        	var instance = this;
			        	
						if (instance.markerInfoWindow) {
							instance.markerInfoWindow.close();
							instance.markerInfoWindow = null;
						}

						instance.markerInfoWindow = new google.maps.InfoWindow({
							content: markerInfoContent
						});
						
						instance.markerInfoWindow.open(instance.tourismMap, marker);
					},
					
					/**
					 * Loại bỏ các điểm đánh dấu khỏi bản đồ
					 */
					_clearMarkers : function(){
						
						var instance = this;
						
						var markerListContainer = A.one(instance._markerListContainer);
						
						markerListContainer.empty();
						
						for(var i = 0; i < instance.markerArray.length; i ++){
							
							var marker = instance.markerArray[i];
							
							marker.setMap(null);
						}	
						
						instance.markerArray = [];
					},
					
					/**
					 * Lấy danh sách các nhóm địa điểm từ database
					 * @param callback
					 */
					_getJsonGroups : function(callback){
						
						var instance = this;
						
						Liferay.Service.tourismmap.TourismMapMarkerGroup.getJSONmarkerGroups(
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
					 * Lấy Marker từ database theo Id
					 * @param markerId
					 * @param callback
					 */
					_getJsonMarker : function(markerId,callback){
						
						var instance = this;
						
						Liferay.Service.tourismmap.TourismMapMarker.getMarker(
							{
								markerId: markerId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					/**
					 * Lấy danh sách tất cả các điểm đánh dấu trên bản đồ trong database
					 * @param callback
					 */
					_getJsonMarkers : function(callback){
						
						var instance = this;
						
						Liferay.Service.tourismmap.TourismMapMarker.getJSONMarkers(
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
					 * Lấy danh sách các điểm đánh dấu theo từng nhóm
					 * @param markerGroupId - Id của nhóm
					 * @param callback
					 */
					_getJsonMarkersByGroup : function(markerGroupId,callback){
						
						var instance = this;
						
						Liferay.Service.tourismmap.TourismMapMarker.getJSONMarkersByGroup(
							{
								markerGroupId: markerGroupId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
					
					/**
					 * Hiển thị icon load dữ liệu
					 * @param container
					 */
					_showLoadingAnimation: function(container) {

						A.all(container).html('<div class="loading-animation" />');
					},
					
					_confirmDelete : function(message){
						
						return confirm(Liferay.Language.get(message));
					},
					
					_groupMenuContainer : '#' + MENU_CONTAINER ,
					
					_groupMenuItemSelector:  '#' + MENU_CONTAINER + ' li' ,
					
					_markerListContainer : '#' + MARKER_LIST_CONTAINER,
					
					_markerItemSelector : '#' + MARKER_LIST_CONTAINER + ' li' ,
					
					_selectedGroupId : 0,
					
					_selectedMarkerId : 0
				}
			}
		);
		
		Liferay.Portlet.TourismMap = TourismMap;
	},
	'',
	{
		requires: ['aui-dialog', 'aui-dialog-iframe','aui-tree-view','json','liferay-portlet-url', 'liferay-util-window']
	}
);