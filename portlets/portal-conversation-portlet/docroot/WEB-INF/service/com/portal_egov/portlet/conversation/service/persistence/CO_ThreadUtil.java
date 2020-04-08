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

import com.portal_egov.portlet.conversation.model.CO_Thread;

import java.util.List;

/**
 * The persistence utility for the c o_ thread service. This utility wraps {@link CO_ThreadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucDVd
 * @see CO_ThreadPersistence
 * @see CO_ThreadPersistenceImpl
 * @generated
 */
public class CO_ThreadUtil {
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
	public static void clearCache(CO_Thread co_Thread) {
		getPersistence().clearCache(co_Thread);
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
	public static List<CO_Thread> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CO_Thread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CO_Thread> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CO_Thread update(CO_Thread co_Thread, boolean merge)
		throws SystemException {
		return getPersistence().update(co_Thread, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CO_Thread update(CO_Thread co_Thread, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(co_Thread, merge, serviceContext);
	}

	/**
	* Caches the c o_ thread in the entity cache if it is enabled.
	*
	* @param co_Thread the c o_ thread
	*/
	public static void cacheResult(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread) {
		getPersistence().cacheResult(co_Thread);
	}

	/**
	* Caches the c o_ threads in the entity cache if it is enabled.
	*
	* @param co_Threads the c o_ threads
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> co_Threads) {
		getPersistence().cacheResult(co_Threads);
	}

	/**
	* Creates a new c o_ thread with the primary key. Does not add the c o_ thread to the database.
	*
	* @param threadId the primary key for the new c o_ thread
	* @return the new c o_ thread
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread create(
		long threadId) {
		return getPersistence().create(threadId);
	}

	/**
	* Removes the c o_ thread with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread that was removed
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread remove(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence().remove(threadId);
	}

	public static com.portal_egov.portlet.conversation.model.CO_Thread updateImpl(
		com.portal_egov.portlet.conversation.model.CO_Thread co_Thread,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(co_Thread, merge);
	}

	/**
	* Returns the c o_ thread with the primary key or throws a {@link com.portal_egov.portlet.conversation.NoSuchCO_ThreadException} if it could not be found.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByPrimaryKey(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence().findByPrimaryKey(threadId);
	}

	/**
	* Returns the c o_ thread with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param threadId the primary key of the c o_ thread
	* @return the c o_ thread, or <code>null</code> if a c o_ thread with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByPrimaryKey(
		long threadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(threadId);
	}

	/**
	* Returns all the c o_ threads where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByCompany_PrevAndNext(
		long threadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCompany_PrevAndNext(threadId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ threads where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread
	* @throws com.portal_egov.portlet.conversation.NoSuchCO_ThreadException if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByGroup_PrevAndNext(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByGroup_PrevAndNext(threadId, groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(groupId, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByGroup_PrevAndNext(
		long threadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(threadId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ threads where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndCompany(status, companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int status, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(status, companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndCompany(
		int status, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndCompany(status, companyId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByStatusAndCompany_First(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndCompany_First(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_First(status, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByStatusAndCompany_Last(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndCompany_Last(
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndCompany_Last(status, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByStatusAndCompany_PrevAndNext(
		long threadId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByStatusAndCompany_PrevAndNext(threadId, status,
			companyId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(status, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusAndGroup(status, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusAndGroup(status, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByStatusAndGroup_First(status, groupId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndGroup_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_First(status, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByStatusAndGroup_Last(status, groupId, orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByStatusAndGroup_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusAndGroup_Last(status, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByStatusAndGroup_PrevAndNext(
		long threadId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByStatusAndGroup_PrevAndNext(threadId, status, groupId,
			orderByComparator);
	}

	/**
	* Returns all the c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByStatusAndGroup(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByStatusAndGroup(status, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(status, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByStatusAndGroup(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusAndGroup(status, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByStatusAndGroup_PrevAndNext(
		long threadId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .filterFindByStatusAndGroup_PrevAndNext(threadId, status,
			groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndCompany(parentThreadId, companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndCompany(parentThreadId, companyId,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompany(
		long parentThreadId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndCompany(parentThreadId, companyId,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompany_First(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndCompany_First(parentThreadId,
			companyId, orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompany_First(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndCompany_First(parentThreadId,
			companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompany_Last(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndCompany_Last(parentThreadId,
			companyId, orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompany_Last(
		long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndCompany_Last(parentThreadId,
			companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndCompany_PrevAndNext(
		long threadId, long parentThreadId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndCompany_PrevAndNext(threadId,
			parentThreadId, companyId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndGroup(parentThreadId, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndGroup(parentThreadId, groupId, start,
			end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndGroup(parentThreadId, groupId, start,
			end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroup_First(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndGroup_First(parentThreadId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroup_First(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndGroup_First(parentThreadId, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroup_Last(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndGroup_Last(parentThreadId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroup_Last(
		long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndGroup_Last(parentThreadId, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndGroup_PrevAndNext(
		long threadId, long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndGroup_PrevAndNext(threadId,
			parentThreadId, groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentThreadAndGroup(parentThreadId, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentThreadAndGroup(parentThreadId, groupId,
			start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroup(
		long parentThreadId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentThreadAndGroup(parentThreadId, groupId,
			start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByParentThreadAndGroup_PrevAndNext(
		long threadId, long parentThreadId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .filterFindByParentThreadAndGroup_PrevAndNext(threadId,
			parentThreadId, groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompanyAndStatus_First(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndCompanyAndStatus_First(parentThreadId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompanyAndStatus_First(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndCompanyAndStatus_First(parentThreadId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndCompanyAndStatus_Last(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndCompanyAndStatus_Last(parentThreadId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndCompanyAndStatus_Last(
		long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndCompanyAndStatus_Last(parentThreadId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndCompanyAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndCompanyAndStatus_PrevAndNext(threadId,
			parentThreadId, companyId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroupAndStatus_First(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndGroupAndStatus_First(parentThreadId,
			groupId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroupAndStatus_First(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndGroupAndStatus_First(parentThreadId,
			groupId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByParentThreadAndGroupAndStatus_Last(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndGroupAndStatus_Last(parentThreadId,
			groupId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByParentThreadAndGroupAndStatus_Last(
		long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentThreadAndGroupAndStatus_Last(parentThreadId,
			groupId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByParentThreadAndGroupAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByParentThreadAndGroupAndStatus_PrevAndNext(threadId,
			parentThreadId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByParentThreadAndGroupAndStatus_PrevAndNext(
		long threadId, long parentThreadId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .filterFindByParentThreadAndGroupAndStatus_PrevAndNext(threadId,
			parentThreadId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndCompany(categoryId, companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(categoryId, companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompany(
		long categoryId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompany(categoryId, companyId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndCompany_First(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompany_First(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_First(categoryId, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndCompany_Last(categoryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompany_Last(
		long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompany_Last(categoryId, companyId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndCompany_PrevAndNext(
		long threadId, long categoryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndCompany_PrevAndNext(threadId, categoryId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryAndGroup(categoryId, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroup(categoryId, groupId, start, end,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndGroup_First(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroup_First(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_First(categoryId, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndGroup_Last(categoryId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last c o_ thread in the ordered set where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c o_ thread, or <code>null</code> if a matching c o_ thread could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroup_Last(
		long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroup_Last(categoryId, groupId,
			orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndGroup_PrevAndNext(
		long threadId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndGroup_PrevAndNext(threadId, categoryId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroup(
		long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCategoryAndGroup(categoryId, groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(categoryId, groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroup(
		long categoryId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroup(categoryId, groupId, start,
			end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByCategoryAndGroup_PrevAndNext(
		long threadId, long categoryId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .filterFindByCategoryAndGroup_PrevAndNext(threadId,
			categoryId, groupId, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompanyAndStatus(categoryId, companyId,
			status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompanyAndStatus(categoryId, companyId,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndCompanyAndStatus(
		long categoryId, long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndCompanyAndStatus(categoryId, companyId,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompanyAndStatus_First(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndCompanyAndStatus_First(categoryId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompanyAndStatus_First(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompanyAndStatus_First(categoryId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndCompanyAndStatus_Last(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndCompanyAndStatus_Last(categoryId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndCompanyAndStatus_Last(
		long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndCompanyAndStatus_Last(categoryId,
			companyId, status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndCompanyAndStatus_PrevAndNext(
		long threadId, long categoryId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndCompanyAndStatus_PrevAndNext(threadId,
			categoryId, companyId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroupAndStatus(categoryId, groupId, status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroupAndStatus(categoryId, groupId,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryAndGroupAndStatus(categoryId, groupId,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroupAndStatus_First(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndGroupAndStatus_First(categoryId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroupAndStatus_First(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroupAndStatus_First(categoryId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread findByCategoryAndGroupAndStatus_Last(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndGroupAndStatus_Last(categoryId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread fetchByCategoryAndGroupAndStatus_Last(
		long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryAndGroupAndStatus_Last(categoryId, groupId,
			status, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] findByCategoryAndGroupAndStatus_PrevAndNext(
		long threadId, long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .findByCategoryAndGroupAndStatus_PrevAndNext(threadId,
			categoryId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroupAndStatus(categoryId, groupId,
			status);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroupAndStatus(categoryId, groupId,
			status, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> filterFindByCategoryAndGroupAndStatus(
		long categoryId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCategoryAndGroupAndStatus(categoryId, groupId,
			status, start, end, orderByComparator);
	}

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
	public static com.portal_egov.portlet.conversation.model.CO_Thread[] filterFindByCategoryAndGroupAndStatus_PrevAndNext(
		long threadId, long categoryId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.conversation.NoSuchCO_ThreadException {
		return getPersistence()
				   .filterFindByCategoryAndGroupAndStatus_PrevAndNext(threadId,
			categoryId, groupId, status, orderByComparator);
	}

	/**
	* Returns all the c o_ threads.
	*
	* @return the c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.conversation.model.CO_Thread> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the c o_ threads where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the c o_ threads where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the c o_ threads where status = &#63; and companyId = &#63; from the database.
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
	* Removes all the c o_ threads where status = &#63; and groupId = &#63; from the database.
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
	* Removes all the c o_ threads where parentThreadId = &#63; and companyId = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentThreadAndCompany(long parentThreadId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByParentThreadAndCompany(parentThreadId, companyId);
	}

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and groupId = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentThreadAndGroup(long parentThreadId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentThreadAndGroup(parentThreadId, groupId);
	}

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByParentThreadAndCompanyAndStatus(parentThreadId, companyId,
			status);
	}

	/**
	* Removes all the c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByParentThreadAndGroupAndStatus(parentThreadId, groupId,
			status);
	}

	/**
	* Removes all the c o_ threads where categoryId = &#63; and companyId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndCompany(long categoryId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Removes all the c o_ threads where categoryId = &#63; and groupId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Removes all the c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCategoryAndCompanyAndStatus(categoryId, companyId, status);
	}

	/**
	* Removes all the c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCategoryAndGroupAndStatus(categoryId, groupId, status);
	}

	/**
	* Removes all the c o_ threads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c o_ threads where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of c o_ threads where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of c o_ threads that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(groupId);
	}

	/**
	* Returns the number of c o_ threads where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndCompany(int status, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndCompany(status, companyId);
	}

	/**
	* Returns the number of c o_ threads where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusAndGroup(status, groupId);
	}

	/**
	* Returns the number of c o_ threads that the user has permission to view where status = &#63; and groupId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusAndGroup(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByStatusAndGroup(status, groupId);
	}

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and companyId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentThreadAndCompany(long parentThreadId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentThreadAndCompany(parentThreadId, companyId);
	}

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentThreadAndGroup(long parentThreadId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentThreadAndGroup(parentThreadId, groupId);
	}

	/**
	* Returns the number of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParentThreadAndGroup(long parentThreadId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByParentThreadAndGroup(parentThreadId, groupId);
	}

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentThreadAndCompanyAndStatus(
		long parentThreadId, long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentThreadAndCompanyAndStatus(parentThreadId,
			companyId, status);
	}

	/**
	* Returns the number of c o_ threads where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status);
	}

	/**
	* Returns the number of c o_ threads that the user has permission to view where parentThreadId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param parentThreadId the parent thread ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByParentThreadAndGroupAndStatus(
		long parentThreadId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByParentThreadAndGroupAndStatus(parentThreadId,
			groupId, status);
	}

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and companyId = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndCompany(long categoryId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndCompany(categoryId, companyId);
	}

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndGroup(long categoryId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns the number of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryAndGroup(long categoryId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndGroup(categoryId, groupId);
	}

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and companyId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndCompanyAndStatus(long categoryId,
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryAndCompanyAndStatus(categoryId, companyId,
			status);
	}

	/**
	* Returns the number of c o_ threads where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCategoryAndGroupAndStatus(categoryId, groupId, status);
	}

	/**
	* Returns the number of c o_ threads that the user has permission to view where categoryId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param categoryId the category ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching c o_ threads that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCategoryAndGroupAndStatus(long categoryId,
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCategoryAndGroupAndStatus(categoryId, groupId,
			status);
	}

	/**
	* Returns the number of c o_ threads.
	*
	* @return the number of c o_ threads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CO_ThreadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CO_ThreadPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.conversation.service.ClpSerializer.getServletContextName(),
					CO_ThreadPersistence.class.getName());

			ReferenceRegistry.registerReference(CO_ThreadUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CO_ThreadPersistence persistence) {
	}

	private static CO_ThreadPersistence _persistence;
}