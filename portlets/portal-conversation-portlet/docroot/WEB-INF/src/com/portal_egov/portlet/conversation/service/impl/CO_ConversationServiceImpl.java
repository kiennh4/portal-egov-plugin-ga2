/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.portal_egov.portlet.conversation.service.impl;

import java.util.List;


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.portal_egov.portlet.conversation.model.CO_Conversation;
import com.portal_egov.portlet.conversation.service.CO_ConversationLocalServiceUtil;
import com.portal_egov.portlet.conversation.service.base.CO_ConversationServiceBaseImpl;

/**
 * The implementation of the c o_ conversation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.conversation.service.CO_ConversationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucDVd
 * @see com.portal_egov.portlet.conversation.service.base.CO_ConversationServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.CO_ConversationServiceUtil
 */
public class CO_ConversationServiceImpl extends CO_ConversationServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.conversation.service.CO_ConversationServiceUtil} to access the c o_ conversation remote service.
	 */
	public JSONObject getThreadConversations(long groupId,long threadId) throws JSONException, SystemException{
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		List<CO_Conversation> threadConversationList = CO_ConversationLocalServiceUtil.findByThreadAndGroup(threadId, groupId);
		
		String threadConversationsJSONStr = JSONFactoryUtil.looseSerialize(threadConversationList);
		
		JSONArray threadConversationsJSONArray = JSONFactoryUtil.createJSONArray(threadConversationsJSONStr);
		
		jsonObject.put("threadConversations", threadConversationsJSONArray);
		
		return jsonObject;
	}
}