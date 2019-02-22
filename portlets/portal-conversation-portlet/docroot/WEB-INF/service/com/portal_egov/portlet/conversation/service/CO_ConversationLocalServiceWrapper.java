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
 * This class is a wrapper for {@link CO_ConversationLocalService}.
 * </p>
 *
 * @author    DucDVd
 * @see       CO_ConversationLocalService
 * @generated
 */
public class CO_ConversationLocalServiceWrapper
	implements CO_ConversationLocalService,
		ServiceWrapper<CO_ConversationLocalService> {
	public CO_ConversationLocalServiceWrapper(
		CO_ConversationLocalService co_ConversationLocalService) {
		_co_ConversationLocalService = co_ConversationLocalService;
	}

	/**
	* Adds the c o_ conversation to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation addCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.addCO_Conversation(co_Conversation);
	}

	/**
	* Creates a new c o_ conversation with the primary key. Does not add the c o_ conversation to the database.
	*
	* @param conversationId the primary key for the new c o_ conversation
	* @return the new c o_ conversation
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation createCO_Conversation(
		long conversationId) {
		return _co_ConversationLocalService.createCO_Conversation(conversationId);
	}

	/**
	* Deletes the c o_ conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws PortalException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation deleteCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.deleteCO_Conversation(conversationId);
	}

	/**
	* Deletes the c o_ conversation from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation deleteCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.deleteCO_Conversation(co_Conversation);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _co_ConversationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.fetchCO_Conversation(conversationId);
	}

	/**
	* Returns the c o_ conversation with the primary key.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation
	* @throws PortalException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation getCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.getCO_Conversation(conversationId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> getCO_Conversations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.getCO_Conversations(start, end);
	}

	/**
	* Returns the number of c o_ conversations.
	*
	* @return the number of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int getCO_ConversationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.getCO_ConversationsCount();
	}

	/**
	* Updates the c o_ conversation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation updateCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.updateCO_Conversation(co_Conversation);
	}

	/**
	* Updates the c o_ conversation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @param merge whether to merge the c o_ conversation with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c o_ conversation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation updateCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.updateCO_Conversation(co_Conversation,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _co_ConversationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_co_ConversationLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _co_ConversationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.countAll();
	}

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.countByCompany(companyId);
	}

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.countByGroup(groupId);
	}

	public int coutByStatusAndCompany(int conversationStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.coutByStatusAndCompany(conversationStatus,
			companyId);
	}

	public int countByStatusAndGroup(int conversationStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.countByStatusAndGroup(conversationStatus,
			groupId);
	}

	public int coutByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.coutByThreadAndCompany(threadId,
			companyId);
	}

	public int countByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.countByThreadAndGroup(threadId,
			groupId);
	}

	public int coutByThreadAndCompanyAndStatus(long threadId, long companyId,
		int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.coutByThreadAndCompanyAndStatus(threadId,
			companyId, conversationStatus);
	}

	public int countByThreadAndGroupAndStatus(long threadId, long groupId,
		int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.countByThreadAndGroupAndStatus(threadId,
			groupId, conversationStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByCompany(companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByCompany(companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByGroup(groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByGroup(groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int conversationStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByStatusAndCompany(conversationStatus,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int conversationStatus, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByStatusAndCompany(conversationStatus,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int conversationStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByStatusAndGroup(conversationStatus,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int conversationStatus, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByStatusAndGroup(conversationStatus,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndCompany(threadId,
			companyId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndCompany(threadId,
			companyId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndCompanyAndStatus(threadId,
			companyId, conversationStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int conversationStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndCompanyAndStatus(threadId,
			companyId, conversationStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndGroup(threadId,
			groupId);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndGroup(threadId,
			groupId, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndGroupAndStatus(threadId,
			groupId, conversationStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int conversationStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.findByThreadAndGroupAndStatus(threadId,
			groupId, conversationStatus, start, end);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int conversationStatus) {
		return _co_ConversationLocalService.findByKeywordAndStatus(companyId,
			keyword, conversationStatus);
	}

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findUnpublishEntry(
		long groupId, java.lang.String searchKeyword) {
		return _co_ConversationLocalService.findUnpublishEntry(groupId,
			searchKeyword);
	}

	public com.portal_egov.portlet.conversation.model.CO_Conversation addCOConversation(
		long companyId, long groupId, long userId, long threadId,
		java.lang.String title, java.lang.String askUserName,
		java.lang.String askUserInfo, java.lang.String askContent,
		java.lang.String answerUserName, java.lang.String answerUserInfo,
		java.lang.String answerContent, java.util.Date askDate,
		java.util.Date answerDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.addCOConversation(companyId,
			groupId, userId, threadId, title, askUserName, askUserInfo,
			askContent, answerUserName, answerUserInfo, answerContent, askDate,
			answerDate, serviceContext);
	}

	public com.portal_egov.portlet.conversation.model.CO_Conversation updateCOConversation(
		long conversationId, long companyId, long groupId, long userId,
		long threadId, java.lang.String title, java.lang.String askUserName,
		java.lang.String askUserInfo, java.lang.String askContent,
		java.lang.String answerUserName, java.lang.String answerUserInfo,
		java.lang.String answerContent, java.util.Date askDate,
		java.util.Date answerDate, int conversationStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.updateCOConversation(conversationId,
			companyId, groupId, userId, threadId, title, askUserName,
			askUserInfo, askContent, answerUserName, answerUserInfo,
			answerContent, askDate, answerDate, conversationStatus);
	}

	public com.portal_egov.portlet.conversation.model.CO_Conversation updateConversationStatus(
		long conversationId, long userId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _co_ConversationLocalService.updateConversationStatus(conversationId,
			userId, conversationStatus);
	}

	public void deleteCoConversation(long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_co_ConversationLocalService.deleteCoConversation(conversationId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CO_ConversationLocalService getWrappedCO_ConversationLocalService() {
		return _co_ConversationLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCO_ConversationLocalService(
		CO_ConversationLocalService co_ConversationLocalService) {
		_co_ConversationLocalService = co_ConversationLocalService;
	}

	public CO_ConversationLocalService getWrappedService() {
		return _co_ConversationLocalService;
	}

	public void setWrappedService(
		CO_ConversationLocalService co_ConversationLocalService) {
		_co_ConversationLocalService = co_ConversationLocalService;
	}

	private CO_ConversationLocalService _co_ConversationLocalService;
}