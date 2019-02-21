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
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the c o_ conversation local service. This utility wraps {@link com.portal_egov.portlet.conversation.service.impl.CO_ConversationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationLocalService
 * @see com.portal_egov.portlet.conversation.service.base.CO_ConversationLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.impl.CO_ConversationLocalServiceImpl
 * @generated
 */
public class CO_ConversationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.portal_egov.portlet.conversation.service.impl.CO_ConversationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the c o_ conversation to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation addCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCO_Conversation(co_Conversation);
	}

	/**
	* Creates a new c o_ conversation with the primary key. Does not add the c o_ conversation to the database.
	*
	* @param conversationId the primary key for the new c o_ conversation
	* @return the new c o_ conversation
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation createCO_Conversation(
		long conversationId) {
		return getService().createCO_Conversation(conversationId);
	}

	/**
	* Deletes the c o_ conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws PortalException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation deleteCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCO_Conversation(conversationId);
	}

	/**
	* Deletes the c o_ conversation from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation deleteCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCO_Conversation(co_Conversation);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCO_Conversation(conversationId);
	}

	/**
	* Returns the c o_ conversation with the primary key.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation
	* @throws PortalException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation getCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_Conversation(conversationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the c o_ conversations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> getCO_Conversations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_Conversations(start, end);
	}

	/**
	* Returns the number of c o_ conversations.
	*
	* @return the number of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int getCO_ConversationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCO_ConversationsCount();
	}

	/**
	* Updates the c o_ conversation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation updateCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCO_Conversation(co_Conversation);
	}

	/**
	* Updates the c o_ conversation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @param merge whether to merge the c o_ conversation with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c o_ conversation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation updateCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCO_Conversation(co_Conversation, merge);
	}

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

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCompany(companyId);
	}

	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByGroup(groupId);
	}

	public static int coutByStatusAndCompany(int conversationStatus,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().coutByStatusAndCompany(conversationStatus, companyId);
	}

	public static int countByStatusAndGroup(int conversationStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatusAndGroup(conversationStatus, groupId);
	}

	public static int coutByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().coutByThreadAndCompany(threadId, companyId);
	}

	public static int countByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByThreadAndGroup(threadId, groupId);
	}

	public static int coutByThreadAndCompanyAndStatus(long threadId,
		long companyId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .coutByThreadAndCompanyAndStatus(threadId, companyId,
			conversationStatus);
	}

	public static int countByThreadAndGroupAndStatus(long threadId,
		long groupId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByThreadAndGroupAndStatus(threadId, groupId,
			conversationStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCompany(companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroup(groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int conversationStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndCompany(conversationStatus, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int conversationStatus, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByStatusAndCompany(conversationStatus, companyId,
			start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int conversationStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatusAndGroup(conversationStatus, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int conversationStatus, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByStatusAndGroup(conversationStatus, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByThreadAndCompany(threadId, companyId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByThreadAndCompany(threadId, companyId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByThreadAndCompanyAndStatus(threadId, companyId,
			conversationStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int conversationStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByThreadAndCompanyAndStatus(threadId, companyId,
			conversationStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByThreadAndGroup(threadId, groupId);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByThreadAndGroup(threadId, groupId, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByThreadAndGroupAndStatus(threadId, groupId,
			conversationStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int conversationStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByThreadAndGroupAndStatus(threadId, groupId,
			conversationStatus, start, end);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int conversationStatus) {
		return getService()
				   .findByKeywordAndStatus(companyId, keyword,
			conversationStatus);
	}

	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findUnpublishEntry(
		long groupId, java.lang.String searchKeyword) {
		return getService().findUnpublishEntry(groupId, searchKeyword);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Conversation addCOConversation(
		long companyId, long groupId, long userId, long threadId,
		java.lang.String title, java.lang.String askUserName,
		java.lang.String askUserInfo, java.lang.String askContent,
		java.lang.String answerUserName, java.lang.String answerUserInfo,
		java.lang.String answerContent, java.util.Date askDate,
		java.util.Date answerDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCOConversation(companyId, groupId, userId, threadId,
			title, askUserName, askUserInfo, askContent, answerUserName,
			answerUserInfo, answerContent, askDate, answerDate, serviceContext);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Conversation updateCOConversation(
		long conversationId, long companyId, long groupId, long userId,
		long threadId, java.lang.String title, java.lang.String askUserName,
		java.lang.String askUserInfo, java.lang.String askContent,
		java.lang.String answerUserName, java.lang.String answerUserInfo,
		java.lang.String answerContent, java.util.Date askDate,
		java.util.Date answerDate, int conversationStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCOConversation(conversationId, companyId, groupId,
			userId, threadId, title, askUserName, askUserInfo, askContent,
			answerUserName, answerUserInfo, answerContent, askDate, answerDate,
			conversationStatus);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Conversation updateConversationStatus(
		long conversationId, long userId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConversationStatus(conversationId, userId,
			conversationStatus);
	}

	public static void deleteCoConversation(long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCoConversation(conversationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CO_ConversationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CO_ConversationLocalService.class.getName());

			if (invokableLocalService instanceof CO_ConversationLocalService) {
				_service = (CO_ConversationLocalService)invokableLocalService;
			}
			else {
				_service = new CO_ConversationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CO_ConversationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CO_ConversationLocalService service) {
	}

	private static CO_ConversationLocalService _service;
}