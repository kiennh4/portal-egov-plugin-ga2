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

package com.portal_egov.portlet.visit_counter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog;

/**
 * The persistence interface for the visit counter day log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VisitCounterDayLogPersistenceImpl
 * @see VisitCounterDayLogUtil
 * @generated
 */
public interface VisitCounterDayLogPersistence extends BasePersistence<VisitCounterDayLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisitCounterDayLogUtil} to access the visit counter day log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the visit counter day log in the entity cache if it is enabled.
	*
	* @param visitCounterDayLog the visit counter day log
	*/
	public void cacheResult(
		com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog visitCounterDayLog);

	/**
	* Caches the visit counter day logs in the entity cache if it is enabled.
	*
	* @param visitCounterDayLogs the visit counter day logs
	*/
	public void cacheResult(
		java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> visitCounterDayLogs);

	/**
	* Creates a new visit counter day log with the primary key. Does not add the visit counter day log to the database.
	*
	* @param daylogId the primary key for the new visit counter day log
	* @return the new visit counter day log
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog create(
		java.lang.String daylogId);

	/**
	* Removes the visit counter day log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param daylogId the primary key of the visit counter day log
	* @return the visit counter day log that was removed
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog remove(
		java.lang.String daylogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog updateImpl(
		com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog visitCounterDayLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the visit counter day log with the primary key or throws a {@link com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException} if it could not be found.
	*
	* @param daylogId the primary key of the visit counter day log
	* @return the visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByPrimaryKey(
		java.lang.String daylogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns the visit counter day log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param daylogId the primary key of the visit counter day log
	* @return the visit counter day log, or <code>null</code> if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByPrimaryKey(
		java.lang.String daylogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the visit counter day logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the visit counter day logs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counter day logs
	* @param end the upper bound of the range of visit counter day logs (not inclusive)
	* @return the range of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the visit counter day logs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of visit counter day logs
	* @param end the upper bound of the range of visit counter day logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns the first visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns the last visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the visit counter day logs before and after the current visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param daylogId the primary key of the current visit counter day log
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog[] findByCompany_PrevAndNext(
		java.lang.String daylogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns all the visit counter day logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the visit counter day logs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counter day logs
	* @param end the upper bound of the range of visit counter day logs (not inclusive)
	* @return the range of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the visit counter day logs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of visit counter day logs
	* @param end the upper bound of the range of visit counter day logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns the first visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns the last visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the visit counter day logs before and after the current visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param daylogId the primary key of the current visit counter day log
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog[] findByGroup_PrevAndNext(
		java.lang.String daylogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException;

	/**
	* Returns all the visit counter day logs.
	*
	* @return the visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the visit counter day logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of visit counter day logs
	* @param end the upper bound of the range of visit counter day logs (not inclusive)
	* @return the range of visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the visit counter day logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of visit counter day logs
	* @param end the upper bound of the range of visit counter day logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the visit counter day logs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the visit counter day logs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the visit counter day logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of visit counter day logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of visit counter day logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of visit counter day logs.
	*
	* @return the number of visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}