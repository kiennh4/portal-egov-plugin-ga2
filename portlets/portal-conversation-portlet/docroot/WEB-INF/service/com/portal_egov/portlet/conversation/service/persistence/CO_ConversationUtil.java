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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.conversation.model.CO_Conversation;

import java.util.List;

/**
 * The persistence utility for the c o_ conversation service. This utility wraps {@link CO_ConversationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_ConversationPersistence
 * @see CO_ConversationPersistenceImpl
 * @generated
 */
public class CO_ConversationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CO_Conversation co_Conversation) {
		getPersistence().clearCache(co_Conversation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CO_Conversation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CO_Conversation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CO_Conversation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CO_Conversation update(CO_Conversation co_Conversation,
		boolean merge) throws SystemException {
		return getPersistence().update(co_Conversation, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CO_Conversation update(CO_Conversation co_Conversation,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(co_Conversation, merge, serviceContext);
	}

	/**
	* Caches the c o_ conversation in the entity cache if it is enabled.
	*
	* @param co_Conversation the c o_ conversation
	*/
	public static void cacheResult(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation) {
		getPersistence().cacheResult(co_Conversation);
	}

	/**
	* Caches the c o_ conversations in the entity cache if it is enabled.
	*
	* @param co_Conversations the c o_ conversations
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> co_Conversations) {
		getPersistence().cacheResult(co_Conversations);
	}

	/**
	* Creates a new c o_ conversation with the primary key. Does not add the c o_ conversation to the database.
	*
	* @param conversationId the primary key for the new c o_ conversation
	* @return the new c o_ conversation
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation create(
		long conversationId) {
		return getPersistence().create(conversationId);
	}

	/**
	* Removes the c o_ conversation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation that was removed
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation remove(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence().remove(conversationId);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Conversation updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Conversation co_Conversation,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(co_Conversation, merge);
	}

	/**
	* Returns the c o_ conversation with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_ConversationException} if it could not be found.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByPrimaryKey(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence().findByPrimaryKey(conversationId);
	}

	/**
	* Returns the c o_ conversation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param conversationId the primary key of the c o_ conversation
	* @return the c o_ conversation, or <code>null</code> if a c o_ conversation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByPrimaryKey(
		long conversationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(conversationId);
	}

	/**
	* Returns all the c o_ conversations where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByCompany_PrevAndNext(
		long conversationId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByCompany_PrevAndNext(conversationId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ConversationException if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByGroup_PrevAndNext(
		long conversationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByGroup_PrevAndNext(conversationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ conversations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByGroup_PrevAndNext(
		long conversationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(conversationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndCompany(status, companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int status, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(status, companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndCompany(
		int status, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(status, companyId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByStatusAndCompany_First(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(status, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByStatusAndCompany_Last(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(status, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByStatusAndCompany_PrevAndNext(
		long conversationId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(conversationId, status,
			companyId, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(status, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(status, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(status, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByStatusAndGroup_First(status, groupId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(status, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByStatusAndGroup_Last(status, groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(status, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByStatusAndGroup_PrevAndNext(
		long conversationId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(conversationId, status,
			groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatusAndGroup(status, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(status, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(status, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByStatusAndGroup_PrevAndNext(
		long conversationId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(conversationId,
			status, groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThreadAndCompany(threadId, companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndCompany(threadId, companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompany(
		long threadId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndCompany(threadId, companyId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompany_First(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndCompany_First(threadId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompany_First(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndCompany_First(threadId, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompany_Last(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndCompany_Last(threadId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompany_Last(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndCompany_Last(threadId, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndCompany_PrevAndNext(
		long conversationId, long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndCompany_PrevAndNext(conversationId,
			threadId, companyId, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThreadAndGroup(threadId, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndGroup(threadId, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroup(
		long threadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndGroup(threadId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroup_First(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndGroup_First(threadId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroup_First(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndGroup_First(threadId, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroup_Last(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndGroup_Last(threadId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ conversation in the ordered set where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ conversation, or <code>null</code> if a matching c o_ conversation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroup_Last(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndGroup_Last(threadId, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndGroup_PrevAndNext(
		long conversationId, long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndGroup_PrevAndNext(conversationId, threadId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroup(
		long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByThreadAndGroup(threadId, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroup(
		long threadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByThreadAndGroup(threadId, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroup(
		long threadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByThreadAndGroup(threadId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByThreadAndGroup_PrevAndNext(
		long conversationId, long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .filterFindByThreadAndGroup_PrevAndNext(conversationId,
			threadId, groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndCompanyAndStatus(threadId, companyId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndCompanyAndStatus(threadId, companyId,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndCompanyAndStatus(
		long threadId, long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndCompanyAndStatus(threadId, companyId,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompanyAndStatus_First(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndCompanyAndStatus_First(threadId, companyId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompanyAndStatus_First(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndCompanyAndStatus_First(threadId, companyId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndCompanyAndStatus_Last(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndCompanyAndStatus_Last(threadId, companyId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndCompanyAndStatus_Last(
		long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndCompanyAndStatus_Last(threadId, companyId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndCompanyAndStatus_PrevAndNext(
		long conversationId, long threadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndCompanyAndStatus_PrevAndNext(conversationId,
			threadId, companyId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndGroupAndStatus(threadId, groupId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndGroupAndStatus(threadId, groupId, status,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThreadAndGroupAndStatus(threadId, groupId, status,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroupAndStatus_First(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndGroupAndStatus_First(threadId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroupAndStatus_First(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndGroupAndStatus_First(threadId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation findByThreadAndGroupAndStatus_Last(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndGroupAndStatus_Last(threadId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation fetchByThreadAndGroupAndStatus_Last(
		long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThreadAndGroupAndStatus_Last(threadId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] findByThreadAndGroupAndStatus_PrevAndNext(
		long conversationId, long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .findByThreadAndGroupAndStatus_PrevAndNext(conversationId,
			threadId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByThreadAndGroupAndStatus(threadId, groupId,
			status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByThreadAndGroupAndStatus(threadId, groupId,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> filterFindByThreadAndGroupAndStatus(
		long threadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByThreadAndGroupAndStatus(threadId, groupId,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Conversation[] filterFindByThreadAndGroupAndStatus_PrevAndNext(
		long conversationId, long threadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ConversationException {
		return getPersistence()
				   .filterFindByThreadAndGroupAndStatus_PrevAndNext(conversationId,
			threadId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ conversations.
	*
	* @return the c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Conversation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the c o_ conversations where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the c o_ conversations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the c o_ conversations where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndCompany(status, companyId);
	}

	/**
	* Removes all the c o_ conversations where status = &#63; and groupId = &#63; from the database.
	*
	* @param status the status
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusAndGroup(status, groupId);
	}

	/**
	* Removes all the c o_ conversations where threadId = &#63; and companyId = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThreadAndCompany(threadId, companyId);
	}

	/**
	* Removes all the c o_ conversations where threadId = &#63; and groupId = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThreadAndGroup(threadId, groupId);
	}

	/**
	* Removes all the c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThreadAndCompanyAndStatus(long threadId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByThreadAndCompanyAndStatus(threadId, companyId, status);
	}

	/**
	* Removes all the c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThreadAndGroupAndStatus(long threadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByThreadAndGroupAndStatus(threadId, groupId, status);
	}

	/**
	* Removes all the c o_ conversations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c o_ conversations where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of c o_ conversations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of c o_ conversations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of c o_ conversations where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndCompany(status, companyId);
	}

	/**
	* Returns the number of c o_ conversations where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(status, groupId);
	}

	/**
	* Returns the number of c o_ conversations that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatusAndGroup(status, groupId);
	}

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and companyId = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThreadAndCompany(long threadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThreadAndCompany(threadId, companyId);
	}

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThreadAndGroup(threadId, groupId);
	}

	/**
	* Returns the number of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByThreadAndGroup(long threadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByThreadAndGroup(threadId, groupId);
	}

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThreadAndCompanyAndStatus(long threadId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThreadAndCompanyAndStatus(threadId, companyId, status);
	}

	/**
	* Returns the number of c o_ conversations where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThreadAndGroupAndStatus(long threadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThreadAndGroupAndStatus(threadId, groupId, status);
	}

	/**
	* Returns the number of c o_ conversations that the user has permission to view where threadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ conversations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByThreadAndGroupAndStatus(long threadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByThreadAndGroupAndStatus(threadId, groupId,
			status);
	}

	/**
	* Returns the number of c o_ conversations.
	*
	* @return the number of c o_ conversations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CO_ConversationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CO_ConversationPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.conversation.service.ClpSerializer.getServletContextName(),
					CO_ConversationPersistence.class.getName());

			ReferenceRegistry.registerReference(CO_ConversationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CO_ConversationPersistence persistence) {
	}

	private static CO_ConversationPersistence _persistence;
}