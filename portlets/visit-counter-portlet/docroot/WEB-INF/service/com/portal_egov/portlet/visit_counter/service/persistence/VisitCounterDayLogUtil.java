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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog;

import java.util.List;

/**
 * The persistence utility for the visit counter day log service. This utility wraps {@link VisitCounterDayLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HungDX
 * @see VisitCounterDayLogPersistence
 * @see VisitCounterDayLogPersistenceImpl
 * @generated
 */
public class VisitCounterDayLogUtil {
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
	public static void clearCache(VisitCounterDayLog visitCounterDayLog) {
		getPersistence().clearCache(visitCounterDayLog);
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
	public static List<VisitCounterDayLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisitCounterDayLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisitCounterDayLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VisitCounterDayLog update(
		VisitCounterDayLog visitCounterDayLog, boolean merge)
		throws SystemException {
		return getPersistence().update(visitCounterDayLog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VisitCounterDayLog update(
		VisitCounterDayLog visitCounterDayLog, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(visitCounterDayLog, merge, serviceContext);
	}

	/**
	* Caches the visit counter day log in the entity cache if it is enabled.
	*
	* @param visitCounterDayLog the visit counter day log
	*/
	public static void cacheResult(
		com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog visitCounterDayLog) {
		getPersistence().cacheResult(visitCounterDayLog);
	}

	/**
	* Caches the visit counter day logs in the entity cache if it is enabled.
	*
	* @param visitCounterDayLogs the visit counter day logs
	*/
	public static void cacheResult(
		java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> visitCounterDayLogs) {
		getPersistence().cacheResult(visitCounterDayLogs);
	}

	/**
	* Creates a new visit counter day log with the primary key. Does not add the visit counter day log to the database.
	*
	* @param daylogId the primary key for the new visit counter day log
	* @return the new visit counter day log
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog create(
		java.lang.String daylogId) {
		return getPersistence().create(daylogId);
	}

	/**
	* Removes the visit counter day log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param daylogId the primary key of the visit counter day log
	* @return the visit counter day log that was removed
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog remove(
		java.lang.String daylogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence().remove(daylogId);
	}

	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog updateImpl(
		com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog visitCounterDayLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(visitCounterDayLog, merge);
	}

	/**
	* Returns the visit counter day log with the primary key or throws a {@link com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException} if it could not be found.
	*
	* @param daylogId the primary key of the visit counter day log
	* @return the visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByPrimaryKey(
		java.lang.String daylogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence().findByPrimaryKey(daylogId);
	}

	/**
	* Returns the visit counter day log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param daylogId the primary key of the visit counter day log
	* @return the visit counter day log, or <code>null</code> if a visit counter day log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByPrimaryKey(
		java.lang.String daylogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(daylogId);
	}

	/**
	* Returns all the visit counter day logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId);
	}

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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompany(companyId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence().findByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the first visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompany_First(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence().findByCompany_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last visit counter day log in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCompany_Last(companyId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog[] findByCompany_PrevAndNext(
		java.lang.String daylogId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence()
				   .findByCompany_PrevAndNext(daylogId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the visit counter day logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId);
	}

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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(groupId, start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence().findByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the first visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_First(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log
	* @throws com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence().findByGroup_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last visit counter day log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching visit counter day log, or <code>null</code> if a matching visit counter day log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroup_Last(groupId, orderByComparator);
	}

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
	public static com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog[] findByGroup_PrevAndNext(
		java.lang.String daylogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.portal_egov.portlet.visit_counter.NoSuchVisitCounterDayLogException {
		return getPersistence()
				   .findByGroup_PrevAndNext(daylogId, groupId, orderByComparator);
	}

	/**
	* Returns all the visit counter day logs.
	*
	* @return the visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.portal_egov.portlet.visit_counter.model.VisitCounterDayLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the visit counter day logs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompany(companyId);
	}

	/**
	* Removes all the visit counter day logs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(groupId);
	}

	/**
	* Removes all the visit counter day logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of visit counter day logs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompany(companyId);
	}

	/**
	* Returns the number of visit counter day logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(groupId);
	}

	/**
	* Returns the number of visit counter day logs.
	*
	* @return the number of visit counter day logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VisitCounterDayLogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VisitCounterDayLogPersistence)PortletBeanLocatorUtil.locate(com.portal_egov.portlet.visit_counter.service.ClpSerializer.getServletContextName(),
					VisitCounterDayLogPersistence.class.getName());

			ReferenceRegistry.registerReference(VisitCounterDayLogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VisitCounterDayLogPersistence persistence) {
	}

	private static VisitCounterDayLogPersistence _persistence;
}