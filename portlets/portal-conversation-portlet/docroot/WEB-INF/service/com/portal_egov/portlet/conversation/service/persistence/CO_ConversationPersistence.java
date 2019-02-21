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

package com.portal_egov.portlet.conversation.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.conversation.model.CO_Conversation;

/**
 * The persistence interface for the c o_ conversation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationPersistenceImpl
 * @see CO_ConversationUtil
 * @generated
 */
public interface CO_ConversationPersistence extends BasePersistence<CO_Conversation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CO_ConversationUtil} to access the c o_ conversation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the c o_ conversation in the entity cache if it is enabled.
	*
	* @param co_Conversation the c o_ conversation
	*/
	public void cacheResult(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation);

	/**
	* Caches the c o_ conversations in the entity cache if it is enabled.
	*
	* @param co_Conversations the c o_ conversations
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> co_Conversations);

	/**
	* Creates a new c o_ conversation with the primary key. Does not add the c o_ conversation to the database.
	*
	* @param conversationId the primary key for the new c o_ conversation
	* @return the new c o_ conversation
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation create(
		long conversationId);

	/**
	* Removes the c o_ conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation remove(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	public com.portal_egov.portlet.conversation.model.CO_Conversation updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversation with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_ConversationException} if it could not be found.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByPrimaryKey(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the c o_ conversation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation, or <code>null</code> if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByPrimaryKey(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c o_ conversations where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByCompany_PrevAndNext(
		long conversationId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByGroup_PrevAndNext(
		long conversationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where groupId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByGroup_PrevAndNext(
		long conversationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int status, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int status, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByStatusAndCompany_PrevAndNext(
		long conversationId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByStatusAndGroup_PrevAndNext(
		long conversationId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations that the user has permissions to view where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByStatusAndGroup_PrevAndNext(
		long conversationId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompany_First(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompany_First(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompany_Last(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompany_Last(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndCompany_PrevAndNext(
		long conversationId, long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroup_First(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroup_First(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroup_Last(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroup_Last(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndGroup_PrevAndNext(
		long conversationId, long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations that the user has permissions to view where threadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroup(
		long threadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByThreadAndGroup_PrevAndNext(
		long conversationId, long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompanyAndStatus_First(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompanyAndStatus_First(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompanyAndStatus_Last(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompanyAndStatus_Last(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndCompanyAndStatus_PrevAndNext(
		long conversationId, long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroupAndStatus_First(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroupAndStatus_First(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroupAndStatus_Last(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroupAndStatus_Last(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndGroupAndStatus_PrevAndNext(
		long conversationId, long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @return the range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations that the user has permissions to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ conversations before and after the current c o_ conversation in the ordered set of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param conversationId the primary key of the current c o_ conversation
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByThreadAndGroupAndStatus_PrevAndNext(
		long conversationId, long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException;

	/**
	* Returns all the c o_ conversations.
	*
	* @return the c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ conversations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ conversations
	* @param end the upper bound of the range of c o_ conversations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where status = &#63; and groupId = &#63; from the database.
	*
	* @param status the status
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where threadId = &#63; and companyId = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where threadId = &#63; and groupId = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThreadAndCompanyAndStatus(long threadId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThreadAndGroupAndStatus(long threadId, long groupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ conversations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByThreadAndCompanyAndStatus(long threadId, long companyId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countByThreadAndGroupAndStatus(long threadId, long groupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByThreadAndGroupAndStatus(long threadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ conversations.
	*
	* @return the number of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}