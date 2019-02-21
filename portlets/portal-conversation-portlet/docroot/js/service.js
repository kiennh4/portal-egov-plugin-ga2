Liferay.Service.register("Liferay.Service.conversation", "com.portal_egov.portlet.conversation.service", "portal-conversation-portlet");

Liferay.Service.registerClass(
	Liferay.Service.conversation, "CO_Conversation",
	{
		getThreadConversations: true
	}
);