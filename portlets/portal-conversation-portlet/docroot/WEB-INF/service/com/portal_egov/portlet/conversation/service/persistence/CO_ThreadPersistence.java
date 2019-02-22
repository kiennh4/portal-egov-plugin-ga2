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

import com.portal_egov.portlet.conversation.model.CO_Thread;

/**
 * The persistence interface for the c o_ thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadPersistenceImpl
 * @see CO_ThreadUtil
 * @generated
 */
public interface CO_ThreadPersistence extends BasePersistence<CO_Thread> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CO_ThreadUtil} to access the c o_ thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the c o_ thread in the entity cache if it is enabled.
	*
	* @param co_Thread the c o_ thread
	*/
	public void cacheResult(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread);

	/**
	* Caches the c o_ threads in the entity cache if it is enabled.
	*
	* @param co_Threads the c o_ threads
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> co_Threads);

	/**
	* Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	*
	* @param threadId the primary key for the new c o_ thread
	* @return the new c o_ thread
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread create(
		long threadId);

	/**
	* Removes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread that was removed
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread remove(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	public com.portal_egov.portlet.conversation.model.CO_Thread updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ thread with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_ThreadException} if it could not be found.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByPrimaryKey(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the c o_ thread with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread, or <code>null</code> if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByPrimaryKey(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c o_ threads where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByCompany_PrevAndNext(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByGroup_PrevAndNext(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByGroup_PrevAndNext(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int status, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int status, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByStatusAndCompany_PrevAndNext(
		long threadId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByStatusAndGroup_PrevAndNext(
		long threadId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads that the user has permissions to view where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByStatusAndGroup_PrevAndNext(
		long threadId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompany_First(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompany_First(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompany_Last(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompany_Last(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndCompany_PrevAndNext(
		long threadId, long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroup_First(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroup_First(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroup_Last(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroup_Last(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndGroup_PrevAndNext(
		long threadId, long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads that the user has permissions to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByParentThreadAndGroup_PrevAndNext(
		long threadId, long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompanyAndStatus_First(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompanyAndStatus_First(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompanyAndStatus_Last(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompanyAndStatus_Last(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndCompanyAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroupAndStatus_First(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroupAndStatus_First(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroupAndStatus_Last(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroupAndStatus_Last(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndGroupAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads that the user has permissions to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByParentThreadAndGroupAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndCompany_PrevAndNext(
		long threadId, long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndGroup_PrevAndNext(
		long threadId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads that the user has permissions to view where categoryId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByCategoryAndGroup_PrevAndNext(
		long threadId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompanyAndStatus_First(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompanyAndStatus_First(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompanyAndStatus_Last(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompanyAndStatus_Last(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndCompanyAndStatus_PrevAndNext(
		long threadId, long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroupAndStatus_First(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroupAndStatus_First(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroupAndStatus_Last(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroupAndStatus_Last(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndGroupAndStatus_PrevAndNext(
		long threadId, long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads that the user has permissions to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c o_ threads before and after the current c o_ thread in the ordered set of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param threadId the primary key of the current c o_ thread
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByCategoryAndGroupAndStatus_PrevAndNext(
		long threadId, long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException;

	/**
	* Returns all the c o_ threads.
	*
	* @return the c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c o_ threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @return the range of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c o_ threads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c o_ threads
	* @param end the upper bound of the range of c o_ threads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where status = &#63; and groupId = &#63; from the database.
	*
	* @param status the status
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and companyId = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentThreadAndCompany(long parentThreadId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and groupId = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentThreadAndGroup(long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentThreadAndCompanyAndStatus(long parentThreadId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where categoryId = &#63; and companyId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c o_ threads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentThreadAndCompany(long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentThreadAndGroup(long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentThreadAndGroup(long parentThreadId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentThreadAndCompanyAndStatus(long parentThreadId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByParentThreadAndGroupAndStatus(long parentThreadId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryAndGroupAndStatus(long categoryId, long groupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c o_ threads.
	*
	* @return the number of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}