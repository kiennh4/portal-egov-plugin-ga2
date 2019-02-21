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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the c o_ conversation local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationLocalServiceUtil
 * @see com.portal_egov.portlet.conversation.service.base.CO_ConversationLocalServiceBaseImpl
 * @see com.portal_egov.portlet.conversation.service.impl.CO_ConversationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CO_ConversationLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CO_ConversationLocalServiceUtil} to access the c o_ conversation local service. Add custom service methods to {@link com.portal_egov.portlet.conversation.service.impl.CO_ConversationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the c o_ conversation to the database. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation addCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new c o_ conversation with the primary key. Does not add the c o_ conversation to the database.
	*
	* @param conversationId the primary key for the new c o_ conversation
	* @return the new c o_ conversation
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation createCO_Conversation(
		long conversationId);

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
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the c o_ conversation from the database. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation deleteCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversation with the primary key.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation
	* @throws PortalException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.portal_egov.portlet.conversation.model.CO_Conversation getCO_Conversation(
		long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> getCO_Conversations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations.
	*
	* @return the number of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCO_ConversationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the c o_ conversation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param co_Conversation the c o_ conversation
	* @return the c o_ conversation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation updateCO_Conversation(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int coutByStatusAndCompany(int conversationStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByStatusAndGroup(int conversationStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int coutByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int coutByThreadAndCompanyAndStatus(long threadId, long companyId,
		int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByThreadAndGroupAndStatus(long threadId, long groupId,
		int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int conversationStatus, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int conversationStatus, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int conversationStatus, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int conversationStatus, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int conversationStatus, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int conversationStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByKeywordAndStatus(
		long companyId, java.lang.String keyword, int conversationStatus);

	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findUnpublishEntry(
		long groupId, java.lang.String searchKeyword);

	public com.portal_egov.portlet.conversation.model.CO_Conversation addCOConversation(
		long companyId, long groupId, long userId, long threadId,
		java.lang.String title, java.lang.String askUserName,
		java.lang.String askUserInfo, java.lang.String askContent,
		java.lang.String answerUserName, java.lang.String answerUserInfo,
		java.lang.String answerContent, java.util.Date askDate,
		java.util.Date answerDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.conversation.model.CO_Conversation updateCOConversation(
		long conversationId, long companyId, long groupId, long userId,
		long threadId, java.lang.String title, java.lang.String askUserName,
		java.lang.String askUserInfo, java.lang.String askContent,
		java.lang.String answerUserName, java.lang.String answerUserInfo,
		java.lang.String answerContent, java.util.Date askDate,
		java.util.Date answerDate, int conversationStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.portal_egov.portlet.conversation.model.CO_Conversation updateConversationStatus(
		long conversationId, long userId, int conversationStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteCoConversation(long conversationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}