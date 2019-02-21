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

package com.portal_egov.portlet.conversation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CO_ConversationService}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_ConversationService
 * @generated
 */
public class CO_ConversationServiceWrapper implements CO_ConversationService,
	ServiceWrapper<CO_ConversationService> {
	public CO_ConversationServiceWrapper(
		CO_ConversationService co_ConversationService) {
		_co_ConversationService = co_ConversationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _co_ConversationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_co_ConversationService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _co_ConversationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.liferay.portal.kernel.json.JSONObject getThreadConversations(
		long groupId, long threadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return _co_ConversationService.getThreadConversations(groupId, threadId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CO_ConversationService getWrappedCO_ConversationService() {
		return _co_ConversationService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCO_ConversationService(
		CO_ConversationService co_ConversationService) {
		_co_ConversationService = co_ConversationService;
	}

	public CO_ConversationService getWrappedService() {
		return _co_ConversationService;
	}

	public void setWrappedService(CO_ConversationService co_ConversationService) {
		_co_ConversationService = co_ConversationService;
	}

	private CO_ConversationService _co_ConversationService;
}