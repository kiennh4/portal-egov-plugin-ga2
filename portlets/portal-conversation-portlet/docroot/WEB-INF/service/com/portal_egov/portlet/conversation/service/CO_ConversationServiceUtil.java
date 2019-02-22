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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the c o_ conversation remote service. This utility wraps {@link com.portal_egov.portlet.conversation.service.impl.CO_ConversationServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationService
 * @see com.portal_egov.portlet.conversation.service.base.CO_ConversationServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.impl.CO_ConversationServiceImpl
 * @generated
 */
public class CO_ConversationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.conversation.service.impl.CO_ConversationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONObject getThreadConversations(
		long groupId, long threadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException {
		return getService().getThreadConversations(groupId, threadId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CO_ConversationService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CO_ConversationService.class.getName());

			if (invokableService instanceof CO_ConversationService) {
				_service = (CO_ConversationService)invokableService;
			}
			else {
				_service = new CO_ConversationServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CO_ConversationServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CO_ConversationService service) {
	}

	private static CO_ConversationService _service;
}