AUI.add(
	'portal-egov-thread-conversation-loader',
	function(A) {
		
		var Lang = A.Lang;
		
		var EVENT_CLICK = 'click';
		
		var GIVE_ASK_BTN_NAME = 'giveAskBtn';
		
		var CONVERSATION_ENTRY_DISPLAY_TPL 		='<div class="conversation-entry">'
												+	'<div class="conversation-title">'
												+ 		'<a href="javascript:;">{title}</a>'
												+	'</div>'
												+	'<div class="conversation-ask-content">'
												+ 		'{askContent}'
												+	'</div>'
												+	'<div class="conversation-ask-user-info">'
												+ 		'<span>{askUserName}</span>'
												+ 		'<span>{askUserInfo}</span>'
												+	'</div>'
												+	'<div class="conversation-answer-content">'
												+ 		'{answerContent}'
												+	'</div>'
												+'</div>';
		
		var ConversationLoader = A.Component.create(
			{
				EXTENDS: A.Base,

				NAME: 'conversationloader',

				prototype: {
					
					initializer: function(config) {
						
						var instance = this;
						instance.portletId = config.portletId;
						instance.scopeGroupId = config.scopeGroupId;
						instance.threadId = config.threadId;
						instance.threadConversationsContainer = A.one('#' + config.container);
						instance.loadingAnimationContainer = A.one('#' + config.loadingContainer);
						
						instance.giveAskFormPanel = null;
						
						instance.giveAskBtn = A.one('#_' + instance.portletId  + '_' + GIVE_ASK_BTN_NAME);
						
						if(instance.giveAskBtn){
							
							instance.giveAskBtn.on(EVENT_CLICK,function(event){
								instance._showGiveAskFormDialog();
							});
						}
						
						instance._buildThreadConversationsData();
						
						setInterval(
							function(){
								instance._buildThreadConversationsData();
							},
							30000
						);
						
						instance._showLoadingAnimation(instance.loadingAnimationContainer);
						
					},
					
					/**
					 * Hiển thị danh sách câu hỏi và câu trả lời thuộc thread
					 * @param callback
					 */
					_buildThreadConversationsData : function(callback){
						
						var instance = this;
						
						var buffer = [];
						
						instance._getThreadConversations(
							function(result){
								var threadConversations = result.threadConversations;
								
								A.each(
										threadConversations,
										function(item, index, collection){
											
											var conversationEntry = A.clone(item);
											
											buffer.push(Lang.sub(CONVERSATION_ENTRY_DISPLAY_TPL, conversationEntry));
										}
								);
								
								instance.threadConversationsContainer.html(buffer.join(''));

								if (callback) {
									callback();
								}
							}
						);
					},
					
					/**
					 * Hiển thị form gửi câu hỏi giao lưu dưới dạng Dialog
					 */
					_showGiveAskFormDialog : function(){
						
						var instance = this;
						
						var giveAskFormURL = instance._createGiveAskFormRenderURL();

						if(!instance.giveAskFormPanel){
														
							instance.giveAskFormPanel = new A.Dialog({
								centered: true,
								cssClass: 'conversation-give-ask-dialog',
								title: Liferay.Language.get('give-ask'),
								resizable: true,
								width: 550,
								height: 650,
								zIndex: 1000
							}).render();
							
							instance.giveAskFormPanel.plug(
								A.Plugin.IO,{
									autoLoad: false,
									uri: giveAskFormURL.toString()
								}
							);
							
							instance.giveAskFormPanel.hide();
						}
						
						instance.giveAskFormPanel.show();
						instance.giveAskFormPanel.io.start();
					},
					
					/**
					 * Tạo URL đến file jsp chứa Form gửi câu hỏi giao lưu
					 * @returns
					 */
					_createGiveAskFormRenderURL : function(){
						
						var instance = this;
						
						var renderURL = Liferay.PortletURL.createRenderURL();
						
						if(renderURL){
							
							renderURL.setPortletId(instance.portletId);
							renderURL.setWindowState('exclusive');
							renderURL.setParameter('jspPage', '/html/conversation/give_ask_form.jsp');
							renderURL.setParameter('threadId', instance.threadId);
							renderURL.setParameter('threadType', 'onlineThread');
							
							renderURL.setDoAsGroupId(instance.scopeGroupId);
						}
						return renderURL;
					},
					
					/**
					 * Hiển thị icon load dữ liệu
					 * @param container
					 */
					_showLoadingAnimation: function(container) {

						A.all(container).html('<div class="loading-animation" />');
					},
					
					/**
					 * Lấy danh sách câu hỏi và câu trả lời theo Id của buổi giao lưu
					 * @param callback
					 */
					_getThreadConversations : function(callback){
						
						var instance = this;
						
						Liferay.Service.conversation.CO_Conversation.getThreadConversations(
							{
								groupId : instance.scopeGroupId,
								threadId : instance.threadId
							},
							function(result){
								if(callback){
									callback.apply(instance, arguments);
								}
							}
						);
					},
				}
			}
		);
		
		Liferay.Portlet.ConversationLoader = ConversationLoader;
	},
	'',
	{
		requires: ['aui-dialog', 'aui-dialog-iframe','json','liferay-portlet-url']
	}
);
		